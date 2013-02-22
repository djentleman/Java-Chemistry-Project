/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package src.chem;

/**
 *
 * @author Todd Perry
 */
import java.util.*;

public class Molecule {

    private ArrayList<Atom> atoms;
    private String name;

    public Molecule(Atom initial, String name) {
        atoms = new ArrayList<Atom>();
        atoms.add(initial);
        this.name = name;
        // sets up 'core' of molecule as 0 in array
    }
    
    public ArrayList<Atom> getAtoms(){
        return atoms;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String n){
        name = n;
    }


    public int getSize() { //returns the size or 'complexity' of a molecule
        int len = atoms.size();
        int size = 0;
        for (int i = 0; i < len; i++) {
            Atom current = atoms.get(i);
            size += current.getAtomicNumber();
        }
        return size;
    }

    public int getTotalFreeElectrons() {
        int len = atoms.size();
        int freeElectrons = 0;
        for (int i = 0; i < len; i++) {
            Atom current = atoms.get(i);
            freeElectrons += current.getFreeElectrons();
        }
        return freeElectrons;
    }

    public void printOut() {
        // console print out
        int len = atoms.size();
        System.out.println("-----" + name + "-----");
        System.out.println("Formula: " + calculateFormula());
        System.out.println("Size (number of protons): " + getSize());
        System.out.println("Total Free Electrons: " + getTotalFreeElectrons());
        for (int i = 0; i < len; i++) {
            Atom currentAtom = atoms.get(i);
            currentAtom.printOut();
        }
    }

    public void covalentBond(Atom atom1, Atom atom2) {
        if (atom1.canBond() && atom2.canBond()) {
            //if the two atoms can bond, they will
            atom1.bond(atom2);
            atom2.bond(atom1);
            //the molecule can contain neither, either, or both atoms
            if (atoms.contains(atom1) == false) {
                atoms.add(atom1);
            }
            if (atoms.contains(atom2) == false) {
                atoms.add(atom2);
            }
        } else {
            // console error message
            System.out.println("cannot covalent bond, no free electrons");
        }
    }

    public void covalentBond(Atom atom) {
        // this method is different, it searches the structure for an atom which can 
        // accept a new bond, and bonds it with a single covalent bond
        if (atom.canBond()) {
            int len = atoms.size();
            boolean hasBonded = false;
            for (int i = 0; i < len; i++) {
                if (hasBonded) {
                    break;
                }
                //search all atoms in structure
                Atom current = atoms.get(i);
                if (current.canBond()) {
                    //if current can bond
                    current.bond(atom);
                    atom.bond(current);
                    //they bond
                    hasBonded = true;
                    atoms.add(atom);
                    //add atom to structure
                }
            }
            if (hasBonded == false) {
                //console error message
                System.out.println("cannot covalent bond, nowhere to bond on.");
            }

        } else {
            // console error message
            System.out.println("cannot covalent bond, no free electrons");
        }
    }

    public void doubleBond(Atom atom1, Atom atom2) {
        if ((atom1.getFreeElectrons() - 2 > -1) && (atom2.getFreeElectrons() - 2 > -1)) {
            atom1.doubleBond(atom2);

            atom2.doubleBond(atom1);

            if (atoms.contains(atom1) == false) {
                atoms.add(atom1);
            }
            if (atoms.contains(atom2) == false) {
                atoms.add(atom2);
            }
        } else {
            System.out.println("double bond cannot be performed, not enough free electrons");
        }
    }

    public void doubleBond(Atom atom) {
        if (atom.getFreeElectrons() > 1) {
            int len = atoms.size();
            boolean hasBonded = false;
            for (int i = 0; i < len; i++) {
                if (hasBonded) {
                    break;
                    //don't want things to get messy
                }
                Atom current = atoms.get(i);
                if (current.getFreeElectrons() > 1) {
                    atom.doubleBond(current);
                    current.doubleBond(atom);

                    hasBonded = true;
                    atoms.add(atom);
                }
            }
            if (hasBonded == false) {
                System.out.println("bond failed, nowhere to bond to");
            }

        } else {
            System.out.println("bond failed, not enough free electrons");
        }
    }

    public void ionicBond(Atom atom1, Atom atom2) {
        if (atom1.canIonicBond(atom2) && atom2.canIonicBond(atom1)) {
            atom1.ionicBond(atom2);

            atom2.ionicBond(atom1);

            if (atoms.contains(atom1) == false) {
                atoms.add(atom1);
            }
            if (atoms.contains(atom2) == false) {
                atoms.add(atom2);
            }

        } else {
            System.out.println("cannot ionic bond");
        }
    }

    public void ionicBond(Atom atom) {

        int len = atoms.size();
        boolean hasBonded = false;
        for (int i = 0; i < len; i++) {
            if (hasBonded) {
                break;
                //don't want things to get messy
            }
            Atom current = atoms.get(i);
            if (current.canIonicBond(atom) && atom.canIonicBond(current)) {
                atom.ionicBond(current);
                current.ionicBond(atom);

                hasBonded = true;
                atoms.add(atom);
            }
        }
        if (hasBonded == false) {
            System.out.println("nowhere to bond to");
        }
    }

    // the 'smart bonding' methods, return booleans on whether a molecule can bond or not
    public boolean canCovalantBond(Atom atom) {
        if (atom.canBond()) {
            int totalFreeElectrons = getTotalFreeElectrons();
            if (totalFreeElectrons > 0) {
                return true;
                // a free electron exists
            }
        }
        return false;
    }

    public boolean canDoubleBond(Atom atom) {
        if (atom.getFreeElectrons() > 1) {
            // atom must be able to bond
            int len = atoms.size();
            for (int i = 0; i < len; i++) {
                Atom current = atoms.get(i);
                if (current.getFreeElectrons() > 1) {
                    // a partnet must be able to bond
                    return true;
                }
            }
        }
        return false;
    }

    public boolean canIonicBond(Atom atom) {
        int len = atoms.size();
        for (int i = 0; i < len; i++) {
            Atom current = atoms.get(i);
            if (current.canIonicBond(atom) && atom.canIonicBond(current)) {
                return true;
                //pair can bond
            }
        }
        return false;
        // no bond-able pair
    }

    public String calculateFormula() {
        int len = atoms.size();

        //doesn't take ionic structures into account (yet).

        //lol such bad code, but On = 2n efficency, so not terrible

        //the usual suspects
        int carbons = 0;
        int hydrogens = 0;
        int oxygens = 0;
        int nitrogens = 0;

        //other stuff
        int chlorines = 0;
        int fluorines = 0;
        int heliums = 0;
        int lithiums = 0;
        int sodiums = 0;


        for (int i = 0; i < len; i++) {
            Atom currentAtom = atoms.get(i);
            int aN = currentAtom.getAtomicNumber();

            if (aN == 1) {
                hydrogens++;
            } else if (aN == 2) {
                heliums++;
            } else if (aN == 3) {
                lithiums++;
            } else if (aN == 6) {
                carbons++;
            } else if (aN == 7) {
                nitrogens++;
            } else if (aN == 8) {
                oxygens++;
            } else if (aN == 9) {
                fluorines++;
            } else if (aN == 11) {
                sodiums++;
            } else if (aN == 17) {
                chlorines++;
            }

        }

        //build the string

        String formula = "";
        if (carbons != 0) {
            if (carbons == 1) {
                formula = formula + "C";
            } else {
                formula = formula + "C" + carbons;
            }
        }

        if (hydrogens != 0) {
            if (hydrogens == 1) {
                formula = formula + "H";
            } else {
                formula = formula + "H" + hydrogens;
            }
        }

        if (oxygens != 0) {
            if (oxygens == 1) {
                formula = formula + "O";
            } else {
                formula = formula + "O" + oxygens;
            }
        }

        if (nitrogens != 0) {
            if (nitrogens == 1) {
                formula = formula + "N";
            } else {
                formula = formula + "N" + nitrogens;
            }
        }

        if (chlorines != 0) {
            if (chlorines == 1) {
                formula = formula + "Cl";
            } else {
                formula = formula + "Cl" + chlorines;
            }
        }

        if (fluorines != 0) {
            if (fluorines == 1) {
                formula = formula + "F";
            } else {
                formula = formula + "F" + fluorines;
            }
        }

        if (heliums != 0) {
            if (heliums == 1) {
                formula = formula + "He";
            } else {
                formula = formula + "He" + heliums;
            }
        }

        if (lithiums != 0) {
            if (lithiums == 1) {
                formula = formula + "Li";
            } else {
                formula = formula + "Li" + lithiums;
            }
        }

        if (sodiums != 0) {
            if (sodiums == 1) {
                formula = formula + "Na";
            } else {
                formula = formula + "Na" + sodiums;
            }
        }


        return formula;
    }

    public void covalentLink() {
        int len = atoms.size();
        if (len > 1) {
            //select two viable atoms
            Atom atom1 = null;
            Atom atom2 = null;

            boolean atomsAsigned = false;

            for (int i = 0; i < len; i++) {
                Atom current = atoms.get(i);
                if (atom1 == null && current.canBond()) {
                    atom1 = current;
                } else if (atom2 == null && current.canBond()) {
                    atom2 = current;
                    atomsAsigned = true;
                    break;

                }
            }

            if (atomsAsigned == false) {
                System.out.println("link failed, no viable atoms");
            } else {
                // loop structure created
                atom1.bond(atom2);
                atom2.bond(atom1);
            }
            
        } else {
            System.out.println("molecule not big enough");
        }
    }
}

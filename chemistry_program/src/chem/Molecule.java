/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chem;

/**
 *
 * @author Todd Perry
 */
import java.util.*;

public class Molecule {

    private ArrayList<Atom> atoms;
    private String name;
    private int size; // number of atoms contained
    private int currentId; // handles the contained Atom IDs
    private int id; // unique molecule ID number
    private int lastBond; // allows unbond to work, records the last bond
    // -1 for no bonds, 0 for covalent, 1 for double, 2 for ionic

    public Molecule() {
        atoms = new ArrayList<Atom>(); // init
        lastBond = -1;
        //default constructor
    }

    public Molecule(Atom initial, String name) {
        atoms = new ArrayList<Atom>();
        atoms.add(initial);
        initial.setId(0);
        // sets up 'core' of molecule as 0 in array
        currentId = 1; // 0 is already used
        this.name = name;
        id = -1; // not yet asigned, will be asigned by a higher method usch a protein builder
        size = 1; // starts off witha  core
        lastBond = -1;
    }

    public ArrayList<Atom> getAtoms() {
        return atoms;
    }

    public void setAtoms(ArrayList<Atom> atoms) {
        this.atoms = atoms;
    }

    public Atom getAtom(int index) {
        return atoms.get(index);
    }

    public Atom getLast() {
        int len = atoms.size();
        Atom last = atoms.get(len - 1); // last atom stored
        // for removing OH in proteins
        return last;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberOfAtoms() {
        return size; // returns number of atoms
    }

    public int getSize() { //returns the number of protons
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

    public void setGroup() {
        for (Atom current : atoms) {
            current.setGroup(id); // sets group as current ID
        }
    }

    public void printOut() {
        // console print out
        int len = atoms.size();
        System.out.println("-----" + name + "-----");
        System.out.println("Formula: " + calculateFormula());
        System.out.println("Number Of Atoms :" + size);
        System.out.println("Size (number of protons): " + getSize());
        System.out.println("Total Free Electrons: " + getTotalFreeElectrons());
        for (int i = 0; i < len; i++) {
            Atom currentAtom = atoms.get(i);
            currentAtom.printOut();
        }
    }

    public void covalentBond(Atom atom1, Atom atom2) {
        if ((atom1.canBond() && atom2.canBond()) && (atoms.contains(atom1) == false && atoms.contains(atom2)) == false) {
            //if the two atoms can bond, they will
            atom1.bond(atom2);
            atom2.bond(atom1);
            // bond successful
            lastBond = 0;

            //the molecule can contain either, or both atoms
            if (atoms.contains(atom1) == false) {
                atoms.add(atom1);
                atom1.setId(currentId);
                atom1.setParent(atom2);
                currentId++;
                size++;
            }
            if (atoms.contains(atom2) == false) {
                atoms.add(atom2);
                atom2.setId(currentId);
                atom2.setParent(atom1);
                currentId++;
                size++;
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
                    lastBond = 0;
                    atom.setParent(current); // set parent

                    atom.setId(currentId);
                    currentId++;
                    size++;

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
            if (atoms.contains(atom1) == false && atoms.contains(atom2)) {
                atom1.doubleBond(atom2);

                atom2.doubleBond(atom1);
                
                lastBond = 1;

                if (atoms.contains(atom1) == false) {
                    atoms.add(atom1);
                    atom1.setId(currentId);
                    atom1.setParent(atom2);
                    currentId++;
                    size++;
                }
                if (atoms.contains(atom2) == false) {
                    atoms.add(atom2);
                    atom2.setId(currentId);
                    atom2.setParent(atom1);
                    currentId++;
                    size++;
                }
            } else {
                System.out.println("double bond cannot be performed, not enough free electrons");
            }
            System.out.println("neither atoms are in the molecule");
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
                    atom.setParent(current);
                    atom.setId(currentId);
                    currentId++;
                    size++;
                    lastBond = 1;

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
            if (atoms.contains(atom1) == false && atoms.contains(atom2)) {
                atom1.ionicBond(atom2);

                atom2.ionicBond(atom1);
                
                lastBond = 2;

                if (atoms.contains(atom1) == false) {
                    atoms.add(atom1);
                    atom1.setId(currentId);
                    atom1.setParent(atom2);
                    currentId++;
                    size++;
                }
                if (atoms.contains(atom2) == false) {
                    atoms.add(atom2);
                    atom2.setId(currentId);
                    atom1.setParent(atom1);
                    currentId++;
                    size++;
                }

            } else {
                System.out.println("cannot ionic bond");
            }
            System.out.println("neither atoms are contained");
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
                atom.setParent(current);
                atom.setId(currentId);
                currentId++;
                size++;
                lastBond = 2;

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

    public void include(Molecule toAdd) {
        // adds multiple new atoms into 'this'
        ArrayList<Atom> atomsToAdd = toAdd.getAtoms();
        for (Atom current : atomsToAdd) {
            if (atoms.contains(current) == false) {
                // current is not part of the molecule
                atoms.add(current);
            }
        }
    }

    public void unBondAtom(Atom toRemove) {
        int idToRemove = toRemove.getId(); // get ID, as opposed to index
        // we have the id to remove

        //atoms.remove(toRemove); // remove the atom from the molecule
        // doesn't work if atom has previously unbonded
        
        
        atoms.remove(toRemove);
    

        for (Atom current : atoms) {
            // cycle through atoms to remove from bond indexes
            for (Atom bond : current.cBondList) {
                if (bond.getId() == idToRemove) {
                    boolean found = current.unBond(toRemove, lastBond);
                    if (found) {
                        size--;
                    }
                }
            }

            for (Atom bond : current.dBondList) {
                if (bond.getId() == idToRemove) {
                    boolean found = current.unBond(toRemove, lastBond);
                    if (found) {
                        size--;
                    }
                }
            }

            for (Atom bond : current.iBondList) {
                if (bond.getId() == idToRemove) {
                    boolean found = current.unBond(toRemove, lastBond);
                    if (found) {
                        size--;
                    }
                }
            }

        }// finished removing from bond indexes

    }
}

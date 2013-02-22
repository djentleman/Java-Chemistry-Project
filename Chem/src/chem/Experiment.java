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

public class Experiment {

    private ArrayList<Atom> atoms;
    private ArrayList<Molecule> molecules;

    public Experiment() {
        atoms = new ArrayList<Atom>();
        molecules = new ArrayList<Molecule>();
        //this is a 'playground' of random atoms
        int i = 0;
        while (i < 1000) {
            //1000 hydrogen atoms
            atoms.add(i, new Hydrogen());
            i++;
        }
        while (i < 1150) {
            //150 carbon
            atoms.add(i, new Carbon());
            i++;
        }
        while (i < 1200) {
            //50 oxygen
            atoms.add(i, new Oxygen());
            i++;
        }
        while (i < 1250) {
            //50 nitrogen
            atoms.add(i, new Nitrogen());
            i++;
        }
        while (i < 1260) {
            //10 fluorine
            atoms.add(i, new Fluorine());
            i++;
        }
        while (i < 1270) {
            //10 chlorine
            atoms.add(i, new Chlorine());
            i++;
        }
        while (i < 1280) {
            //10 lithium
            atoms.add(i, new Lithium());
            i++;
        }
        while (i < 1300) {
            //20 sodium
            atoms.add(i, new Sodium());
            i++;
        }

        //these atoms are 'floating', they can bond with molecules
        //there are 10 carbon atoms, which will be bonded with at random
        //this is to test the complexity of emerging structures.

        int j = 0;
        while (j < 20) {
            //all molecule cores are carbon
            molecules.add(j, new Molecule(new Carbon(), "Experiment" + j));
            j++;
        }

    }

    private int getTotalFreeElectrons() {
        int count = 0;
        for (Molecule current : molecules) {
            count += current.getTotalFreeElectrons();
        }
        return count;
    }

    public void run() {
        Random atomGenerator = new Random();
        // Random bondGenerator = new Random();
        Random moleculeGenerator = new Random();
        
        

        boolean canContinue = true;
        //program stops being able to continue when no molecules have free electrons left
        while (canContinue) {
            int randAtom = atomGenerator.nextInt(1300);
            //randAtom is between 0 and 1299
            Atom atomToBond = atoms.get(randAtom);


            int randMol = moleculeGenerator.nextInt(20);
            Molecule currentMolecule = molecules.get(randMol);
            // pick a random molecule from the 20


            if (currentMolecule.canIonicBond(atomToBond)) {
                currentMolecule.ionicBond(atomToBond);
            } else if (atomToBond.getFreeElectrons() < 7) {
                // can't get any grim stuff happen
                if (currentMolecule.canDoubleBond(atomToBond)) {
                    currentMolecule.doubleBond(atomToBond);
                } else if (currentMolecule.canCovalantBond(atomToBond)) {
                    currentMolecule.covalentBond(atomToBond);
                }
            } else {
                //bond attempt failed
                //inert it up in here
                atoms.set(randAtom, new Helium());
            }


            if (getTotalFreeElectrons() == 0) {
                canContinue = false;
            }

        }

        for (Molecule current : molecules) {
            current.printOut();
            Render r = new Render(current);
            
            r.run();
        }
    }
}

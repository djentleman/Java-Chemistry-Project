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

public class ProteinBuilder {

    private ArrayList<String> instruction;
    // this instruction is like the code behind the protein
    // the order in which amino acids get made
    private int index;
    // used for getting current instruction
    private Molecule structure;
    // actual molecular structure
    // private ArrayList<Molecule> molecules;
    // holds each invidividual molecule, seperate from structure

    public ProteinBuilder() {
        instruction = new ArrayList<String>();
        // constructor
    }

    public ProteinBuilder(ArrayList<String> instruction) {
        this.instruction = instruction;
        index = 0;
        construct();
    }

    public String getCurrentInstruction() {
        String currentInstruction = "0"; // 0 is null valie, can be used in instruction set to end
        try {
            if (instruction.get(index) != null) {
                currentInstruction = instruction.get(index);
                System.out.print(currentInstruction + ",");
                index++;
            }
        } catch (Exception e) {
            // exception means index is out of bounds
            // cIns stays 0
        }
        return currentInstruction;
    }

    public void construct() {
        boolean canContinue = true;
        while (canContinue) {
            String currentInstruction = getCurrentInstruction();
            if (currentInstruction.equals("0") == false) {
                //build protein
                if (index == 1) {
                    //first molecule in chain
                    Molecule first = new Molecule();

                    if (currentInstruction.equals("A")) {
                        first = buildAlanine();
                    } else if (currentInstruction.equals("V")) {
                        first = buildValine();
                    }
                    first.setId(index);
                    first.setGroup();


                    // O and H need to be unbonded

                    Atom toDelete = first.getLast();
                    first.unBondAtom(toDelete); // deletes H
                    toDelete = first.getLast();
                    first.unBondAtom(toDelete); // deletes O


                    structure = first;

                } else if (index != 1 && index != (instruction.size())) { // needs refactoring for end molecule
                    Molecule toAdd = new Molecule();
                    if (currentInstruction.equals("A")) {
                        toAdd = buildAlanine();
                    } else if (currentInstruction.equals("V")) {
                        toAdd = buildValine();
                    }
                    toAdd.setId(index); // set Protein ID

                    // need to remove hydrogen to bond, the third atom in the amino acid
                    // arraylist id would be 2

                    Atom toDelete = toAdd.getAtom(2);
                    toAdd.unBondAtom(toDelete); // Deletes N group H

                    toDelete = toAdd.getLast();
                    toAdd.unBondAtom(toDelete); // deletes H
                    toDelete = toAdd.getLast();
                    toAdd.unBondAtom(toDelete); // deletes O

                    // bond on

                    Atom toBond = toAdd.getAtom(0); // N atom, molecule core - so 0

                    toAdd.setGroup();

                    structure.covalentBond(toBond);
                    // bonds on
                    structure.include(toAdd);
                    // adds rest of molecule

                    //toAdd.printOut();
                    //structure.printOut();



                } else if (index == instruction.size()) {
                    Molecule toAdd = new Molecule();
                    if (currentInstruction.equals("A")) {
                        toAdd = buildAlanine();
                    } else if (currentInstruction.equals("V")) {
                        toAdd = buildValine();
                    }
                    toAdd.setId(index); // set Protein ID

                    Atom toDelete = toAdd.getAtom(2);
                    toAdd.unBondAtom(toDelete); // Deletes N group H

                    Atom toBond = toAdd.getAtom(0); // N atom, molecule core - so 0

                    toAdd.setGroup();

                    structure.covalentBond(toBond);
                    // bonds on
                    structure.include(toAdd);
                    // don't need to rmove O and H


                }
                // first peptide in chain has been created
                // now to bond stuff
            } else {
                System.out.println();
                System.out.println("end of instructions reached");
                canContinue = false;
            }
        }

        Render r = new Render(structure);
        //r.run();
        structure.setName("Polypeptide");
        structure.printOut();

    }

    public Molecule buildNH2() {
        // step 1
        Atom n = new Nitrogen();
        Atom h1 = new Hydrogen();
        Atom h2 = new Hydrogen();

       

        Molecule mol = new Molecule(n, "Construct");

        mol.covalentBond(h1);
        mol.covalentBond(h2);

        return mol;
    }

    public Molecule buildVariableGroupA(Molecule mol) {

        mol.setName("Alanine");

        Atom c1 = new Carbon();
        Atom h1 = new Hydrogen();


        mol.covalentBond(c1);
        mol.covalentBond(c1, h1);

        Atom c2 = new Carbon();
        Atom h2 = new Hydrogen();
        Atom h3 = new Hydrogen();
        Atom h4 = new Hydrogen();


        mol.covalentBond(c2);
        mol.covalentBond(c2, h2);
        mol.covalentBond(c2, h3);
        mol.covalentBond(c2, h4);




        return mol;
    }

    public Molecule buildVariableGroupV(Molecule mol) {


        mol.setName("Valine");

        Atom c1 = new Carbon();
        Atom h1 = new Hydrogen();

        mol.covalentBond(c1);
        mol.covalentBond(c1, h1);

        Atom c2 = new Carbon();
        Atom h2 = new Hydrogen();
        Atom h3 = new Hydrogen();
        Atom c3 = new Carbon();
        Atom h4 = new Hydrogen();
        Atom h5 = new Hydrogen();
        Atom h6 = new Hydrogen();

        mol.covalentBond(c2);
        mol.covalentBond(c2, c3); // makes rendering easier
        mol.covalentBond(c2, h2);
        mol.covalentBond(c2, h3);
        mol.covalentBond(c3, h4);
        mol.covalentBond(c3, h5);
        mol.covalentBond(c3, h6);

        return mol;
    }

    public Molecule buildCOOH(Molecule mol) {

        Atom c = new Carbon();
        Atom o1 = new Oxygen();
        Atom o2 = new Oxygen();
        Atom h = new Hydrogen();

        mol.covalentBond(c); // C

        mol.doubleBond(o1); //  CO
        mol.covalentBond(c, o2); //  COO
        mol.covalentBond(h); // COOH



        return mol;
    }

    public Molecule buildAlanine() {
        Molecule mol = buildNH2();
        mol = buildVariableGroupA(mol);
        mol = buildCOOH(mol);
        return mol;
    }

    public Molecule buildValine() {
        Molecule mol = buildNH2();
        mol = buildVariableGroupV(mol);
        mol = buildCOOH(mol);
        return mol;
    }
}

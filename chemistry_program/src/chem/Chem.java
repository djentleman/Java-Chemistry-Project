/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chem;

/**
 *
 * @author Todd Perry
 */
import chem.graphics.GUI;
import chem.graphics.Render;
import chem.atoms.Oxygen;
import chem.atoms.Chlorine;
import chem.atoms.Carbon;
import chem.atoms.Hydrogen;
import chem.atoms.Nitrogen;
import chem.atoms.Sodium;
import java.util.*;

public class Chem {

    /**
     * @param args the command line arguments
     */
    private static void module1() {
        //tests bonding with 2 parameters
        Atom ox1 = new Oxygen();
        Atom hy1 = new Hydrogen();
        Atom hy2 = new Hydrogen();

        Molecule water = new Molecule(ox1, "Water");

        water.printOut();


        System.out.println("");
        System.out.println("---Bonds with two Hydrogens---");
        water.covalentBond(ox1, hy1);
        water.covalentBond(ox1, hy2);
        water.covalentBond(ox1, hy2);

        water.printOut();

        System.out.println("--------------------------");
        
        //GUI gui = new GUI(water);
        //gui.main(null);
    }

    private static void module2() {
        // automatic (one parameter) bond test
        Atom hy1 = new Hydrogen();
        Atom hy2 = new Hydrogen();
        Atom hy3 = new Hydrogen();

        Molecule h2 = new Molecule(hy1, "Dual Hydrogen");

        h2.printOut();

        h2.covalentBond(hy2);
        //this method works

        h2.printOut();

        h2.covalentBond(hy3);
        // error detected, test success :D

        System.out.println("----------------------------");
    }

    private static void module3() {
        //propane (carbon test)
        Atom cb1 = new Carbon();
        Atom cb2 = new Carbon();
        Atom cb3 = new Carbon();

        Atom hy1 = new Hydrogen();
        Atom hy2 = new Hydrogen();
        Atom hy3 = new Hydrogen();
        Atom hy4 = new Hydrogen();
        Atom hy5 = new Hydrogen();
        Atom hy6 = new Hydrogen();
        Atom hy7 = new Hydrogen();
        Atom hy8 = new Hydrogen();
        Atom[] hydrogens = {hy1, hy2, hy3, hy4, hy5, hy6, hy7, hy8};

        Molecule propane = new Molecule(cb1, "Propane");

        propane.covalentBond(cb2);
        propane.covalentBond(cb3);

        for (Atom hy : hydrogens) {
            propane.covalentBond(hy);
        }





        //System.out.println("carbon inner structure");
        propane.printOut();
        
        Render r = new Render(propane);
        
        r.run();

    }

    public static void module4() {

        //prepane (carbon double bond test)
        Atom cb1 = new Carbon();
        Atom cb2 = new Carbon();
        Atom cb3 = new Carbon();

        Atom hy1 = new Hydrogen();
        Atom hy2 = new Hydrogen();
        Atom hy3 = new Hydrogen();
        Atom hy4 = new Hydrogen();
        Atom hy5 = new Hydrogen();
        Atom hy6 = new Hydrogen();
        Atom hy7 = new Hydrogen();
        Atom[] hydrogens = {hy1, hy2, hy3, hy4, hy5, hy6, hy7};

        Molecule propene = new Molecule(cb1, "Propane");

        propene.covalentBond(cb2);
        propene.doubleBond(cb2, cb3);

        for (Atom hy : hydrogens) {
            propene.covalentBond(hy);
        }





        //System.out.println("carbon inner structure");
        propene.printOut();
    }

    public static void module5() {
        //o2, non manual double bond test
        Atom ox1 = new Oxygen();
        Atom ox2 = new Oxygen();

        Molecule o2 = new Molecule(ox1, "O2");

        o2.doubleBond(ox2);

        o2.printOut();

    }

    public static void module6() {
        //CO2
        Atom cb1 = new Carbon();
        Atom ox1 = new Oxygen();
        Atom ox2 = new Oxygen();

        Molecule co2 = new Molecule(cb1, "Carbon Di-Oxide");

        co2.doubleBond(ox1);
        co2.doubleBond(ox2);

        System.out.println("double bond test");
        System.out.println();
        System.out.println();
        co2.printOut();
        
        //Render r = new Render(co2);
        
        //r.run();
        
        //GUI gui = new GUI(co2);
        //gui.main(null);



    }

    private static void module7() {
        //test to make a simple amino acid
        //two carbons, two oxygens, a nitrogen and 5 hydrogens
        Atom cb1 = new Carbon();
        Atom cb2 = new Carbon();

        Atom ox1 = new Oxygen();
        Atom ox2 = new Oxygen();

        Atom ni1 = new Nitrogen();

        Atom hy1 = new Hydrogen();
        Atom hy2 = new Hydrogen();
        Atom hy3 = new Hydrogen();
        Atom hy4 = new Hydrogen();
        Atom hy5 = new Hydrogen();


        Molecule alanine = new Molecule(ni1, "Alanine");

        //nitrogen core

        System.out.println("before anything bonds:");
        alanine.printOut();

        //first make H2N

        alanine.covalentBond(hy1);
        alanine.covalentBond(hy2);

        System.out.println("H2N");
        System.out.println();
        alanine.printOut();

        alanine.covalentBond(cb1);
        alanine.covalentBond(hy3);
        alanine.covalentBond(hy4);


        System.out.println("more structure");
        System.out.println();

        alanine.printOut();

        alanine.covalentBond(cb2);
        alanine.covalentBond(ox1);
        alanine.doubleBond(ox2);
        alanine.covalentBond(hy5);

        alanine.printOut();
        
        // r = new Render(alanine);
        
        //r.run();
        
        //GUI gui = new GUI(alanine);
        //gui.main(null);

    }

    public static void module8() {
        //ionic bond test, time to make salt
        Atom na = new Sodium();
        Atom cl = new Chlorine();

        Molecule NaCl = new Molecule(na, "Sodium Chloride");

        NaCl.ionicBond(cl);

        NaCl.printOut();
    }

    public static void module9() {
        // second ionic bond test, NaOH
        Atom na = new Sodium();
        Atom ox = new Oxygen();
        Atom hy = new Hydrogen();

        Molecule NaOH = new Molecule(ox, "NaOH");

        NaOH.covalentBond(hy);

        NaOH.ionicBond(na);

        NaOH.printOut();
    }

    public static void module10() {
        //hydrogen ionic bondinging NaH

        Atom na = new Sodium();
        Atom hy = new Hydrogen();

        Molecule NaH = new Molecule(hy, "NaH");

        NaH.ionicBond(na);

        NaH.printOut();
    }
    
    public static void module11(){
        //the moment we've all been waiting for - benzene time
        
        // 6 carbons
        Atom cb1 = new Carbon();
        Atom cb2 = new Carbon();
        Atom cb3 = new Carbon();
        Atom cb4 = new Carbon();
        Atom cb5 = new Carbon();
        Atom cb6 = new Carbon();
        
        // 6 hydrogens
        
        Atom hy1 = new Hydrogen();
        Atom hy2 = new Hydrogen();
        Atom hy3 = new Hydrogen();
        Atom hy4 = new Hydrogen();
        Atom hy5 = new Hydrogen();
        Atom hy6 = new Hydrogen();
        
        Molecule bz = new Molecule(cb1, "Benzene");
        
        bz.doubleBond(cb2);
        bz.covalentBond(cb3);
        
        // c3 - c1 = c2
        
        bz.covalentBond(hy1);
        
        // c3 - c1h1 = c2
        
        bz.covalentBond(cb4);
        bz.covalentBond(hy2);
        
        // c3 - c1h1 = c2h2 - c4
        
        bz.doubleBond(cb5);
        bz.covalentBond(hy3);
        
        // c5 = c3h3 - c1h1 = c2h2 - c4
        
        bz.doubleBond(cb6);
        bz.covalentBond(hy4);
        
        // c5 = c3h3 - c1h1 = c2h2 - c4h4 = c6
        
        bz.covalentLink();
        
        bz.covalentBond(hy5);
        bz.covalentBond(hy6);
        
        bz.printOut();
        
    }
    
    public static void module12(){
        Atom h1 = new Hydrogen();
        Atom h2 = new Hydrogen();
        
        Molecule hy = new Molecule(h1, "H2");
        hy.covalentBond(h2);
        
        hy.printOut();
        
        hy.unBondAtom(h2);
        
        hy.printOut();
    }
    
    public static void module13(){
        Atom h1 = new Hydrogen();
        Atom h2 = new Hydrogen();
        Atom o = new Oxygen();
        Atom h3 = new Hydrogen();
        
        Molecule hy = new Molecule(h1, "H2");
        hy.setId(0);
        
        Render r = new Render(hy);
        
        hy.covalentBond(h2);
        
        r.run();
        
        
        hy.printOut();
        
        hy.unBondAtom(h2);
        
        r.run();
        
        hy.printOut();
        
        hy.covalentBond(o);
        hy.covalentBond(h3);
        
        r.run();
        
        hy.printOut();
    }
    

    public static void main(String[] args) {
        // TODO code application logic here
        long startTime = System.currentTimeMillis();
        // covalant testing
        //module1(); // water
        //module2(); // h2
        //module3(); // propane

        // double bond testing
        //module4(); // propene
        //module5(); // o2
        //module6(); // co2

        //amino acid test
        //module7(); //alanine (amino acid)

        // ionic bond testing
        //module8(); // NaCl
        //module9(); //NaOH
        //module10(); //NaH

        //link (cycle structure) testing
        //module11(); //C6H6 benzene
        
        // unbonding testing
        //module12(); // h2 unbond
        //module13(); //rebonding

        
        //chem formation
        
        //Experiment exp = new Experiment();
        //exp.run();
        
        
        
        // 2D CHEMICAL RENDER
        // IT WORKS NAO
        
       // Atom h1 = new Hydrogen();
       // Atom h2 = new Hydrogen();
       // Atom ox = new Oxygen();
       // 
       // Molecule water = new Molecule(ox, "Water");
       // 
       // water.covalentBond(h1);
       // water.covalentBond(h2);
       // 
       // water.printOut();
       // 
       // Render p = new Render(water);
       // 
       // p.run();
        
        
        // Protein building
        
        //ArrayList<String> ins = new ArrayList<String>(0);
        //ins.add("V");
        //ins.add("A");
        //ins.add("V");
        //ins.add("A");
        //ins.add("V");
        //ins.add("A");
        //ins.add("V");
        //ProteinBuilder p = new ProteinBuilder(ins);
        
        // MAKE MOLECULE ID AN ATTRIBUTE OF ATOM
        
        
        // ACTUAL CODE FOR PROGRAM LAUNCH
        try{
            GUI gui = new GUI();
            gui.main(null);
        } catch (Exception e){
            System.out.println("Something Went Wrong");
        }
        
        
        
        long endTime = System.currentTimeMillis();
        System.out.println("Calculation Completed in: "
                + (endTime - startTime) + " ms");
    }
}

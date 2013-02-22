/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package src.chem;

/**
 *
 * @author Todd Perry
 */
public class ProteinBuilder {
    
    public ProteinBuilder(){
        // constructor
    }
    
    public Molecule buildNH2(){
        // step 1
        Atom n = new Nitrogen();
        Atom h1 = new Hydrogen();
        Atom h2 = new Hydrogen();
        
        Molecule mol = new Molecule(n, "Construct");
        
        mol.covalentBond(h1);
        mol.covalentBond(h2);
        
        return mol;
    }
    
    public Molecule buildVariableGroupA(Molecule mol){
        
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
    
    public Molecule buildVariableGroupV(Molecule mol){
        
        
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
    
    public Molecule buildCOOH(Molecule mol){
        
        Atom c = new Carbon();
        Atom o1 = new Oxygen();
        Atom o2 = new Oxygen();
        Atom h = new Hydrogen();
        
        mol.covalentBond(c);
        
        mol.doubleBond(o1);
        mol.covalentBond(c, o2);
        mol.covalentBond(h);
        
        
        
        return mol;
    }
    
    
    public void run(){
        
        Molecule test = buildNH2();
        test = buildVariableGroupA(test);
        test = buildCOOH(test);
        
        Molecule test2 = buildNH2();
        test2 = buildVariableGroupV(test2);
        test2 = buildCOOH(test2);
        
        
        
        Render r = new Render(test);
        Render r1 = new Render(test2);
        
        r.run();
        r1.run();
    }
    
}

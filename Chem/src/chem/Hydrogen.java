/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package src.chem;

/**
 *
 * @author Todd Perry
 */
public class Hydrogen extends Atom {
    //hydrogen atom
    
    public Hydrogen(){
        super();
        atomicNumber = 1;
        freeElectrons = 1;
        symbol = "H";
    }
    
    //special code for hydrogen bonding maybe?
    
    
    public void printOut(){
        //overrides Atom.printOut()
        System.out.println();
        System.out.println("------Hydrogen------");
        super.printOut();
    }
}

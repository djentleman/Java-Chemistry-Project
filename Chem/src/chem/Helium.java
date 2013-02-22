/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package src.chem;

/**
 *
 * @author Todd Perry
 */
public class Helium extends Atom {
    
    public Helium() {
        super();
        symbol = "He";
        atomicNumber = 2;
        freeElectrons = 0;
    }

    public void printOut() {
        //overrides Atom.printOut()
        System.out.println();
        System.out.println("------Helium------");
        super.printOut();
    }
}

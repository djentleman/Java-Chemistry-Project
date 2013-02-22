/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package src.chem;

/**
 *
 * @author Todd Perry
 */
public class Fluorine extends Atom {

    public Fluorine() {
        super();
        symbol = "F";
        atomicNumber = 9;
        freeElectrons = 1;
    }

    public void printOut() {
        //overrides Atom.printOut()
        System.out.println();
        System.out.println("------Fluorine------");
        super.printOut();
    }
}

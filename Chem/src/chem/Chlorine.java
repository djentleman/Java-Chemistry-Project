/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package src.chem;

/**
 *
 * @author Todd Perry
 */
public class Chlorine extends Atom {
    public Chlorine(){
        super();
        atomicNumber = 17;
        freeElectrons = 1;
        symbol = "Cl";
    }
    
    public void printOut(){
        System.out.println();
        System.out.println("------Chlorine------");
        super.printOut();
    }
}

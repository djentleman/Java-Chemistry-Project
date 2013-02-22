/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package src.chem;

/**
 *
 * @author Todd Perry
 */
public class Nitrogen extends Atom {
    
    public Nitrogen(){
        super();
        symbol = "N";
        freeElectrons = 3;
        atomicNumber = 7;
    }
    
     public void printOut(){
        //overrides Atom.printOut()
        System.out.println();
        System.out.println("------Nitrogen------");
        super.printOut();
    }
}

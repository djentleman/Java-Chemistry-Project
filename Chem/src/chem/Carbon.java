/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package src.chem;

/**
 *
 * @author Todd Perry
 */
public class Carbon extends Atom{
    
    public Carbon(){
        super();
        atomicNumber = 6;
        freeElectrons = 4;
        symbol = "C";
    }
    
    public void printOut(){
        System.out.println();
        System.out.println("------Carbon------");
        super.printOut();
    }
}

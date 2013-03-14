/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chem.atoms;

import chem.Atom;

/**
 *
 * @author Todd Perry
 */
public class Lithium extends Atom {
    
    public Lithium(){
        super();
        atomicNumber = 3;
        freeElectrons = 7;
        symbol = "Li";
    }
    
    public void printOut(){
        System.out.println();
        System.out.println("------Lithium------");
        super.printOut();
    }
}

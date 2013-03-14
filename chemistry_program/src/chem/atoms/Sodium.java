/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chem.atoms;

import chem.Atom;
import chem.Atom;

/**
 *
 * @author Todd Perry
 */
public class Sodium extends Atom {
    
    
     public Sodium(){
        super();
        atomicNumber = 11;
        freeElectrons = 7;
        symbol = "Na";
    }
     
    public void printOut(){
        System.out.println();
        System.out.println("------Sodium------");
        super.printOut();
    }
}

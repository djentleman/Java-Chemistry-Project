/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chem;

/**
 *
 * @author Todd Perry
 */
public class Oxygen extends Atom {
    
    
     public Oxygen(){
         super();
         freeElectrons = 2;
         atomicNumber = 8;
         symbol = "O";
     }
     
       public void printOut(){
        //overrides Atom.printOut()
        System.out.println();
        System.out.println("------Oxygen------");
        super.printOut();
    }
}

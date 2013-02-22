/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package src.chem;

/**
 *
 * @author Todd Perry
 */
import java.util.*;

public abstract class Atom {
    // specific types of atom will inherit atom

    protected int freeElectrons;
    protected int atomicNumber;
    protected int charge;
    protected String symbol;
    protected ArrayList<Atom> cBondList; //covalant bonds
    protected ArrayList<Atom> dBondList; //double bonds
    protected ArrayList<Atom> iBondList; //ionic bonds

    public Atom() {
        cBondList = new ArrayList<Atom>(0);
        dBondList = new ArrayList<Atom>(0);
        iBondList = new ArrayList<Atom>(0);
        charge = 0;
    } //default contructor
    //other constructors will not be needed, as each atom defines itself

    public int getFreeElectrons() {
        return freeElectrons;
    }

    public int getAtomicNumber() {
        return atomicNumber;
    }
    
    public ArrayList<Atom> getCBondList(){
        return cBondList;
    }
    
    public ArrayList<Atom> getDBondList(){
        return dBondList;
    }
    
    public ArrayList<Atom> getIBondList(){
        return iBondList;
    }
    
    public int getAdjacent(){
        // get number of adjacent atoms
        // rendering only works for covalent at the moment
        return cBondList.size();
    }

    public int getCharge() {
        return charge;
    }

    public void ionize(boolean isPositive) {
        if (isPositive == true) {
            charge++;
            freeElectrons++;
            if (charge >= 0) {
                symbol = symbol + "+";
            } else {
                symbol = symbol.substring(0, (symbol.length() - 1)); // remove a minus
            }
        } else {
            charge--;
            freeElectrons--;
            if (charge <= 0) {
                symbol = symbol + "-";
            } else {
                symbol = symbol.substring(0, (symbol.length() - 1)); // remove a plus
            }
        }
    }

    private double get2dBondAngle() {
        //calculates 2d bond angle
        ArrayList<Atom> work = new ArrayList<Atom>(0);
        int lenC = cBondList.size();
        int lenD = dBondList.size();
        int lenI = iBondList.size();
        int count = lenC + lenD + lenI;
        if (count != 0) {
            //gets the angle
            return (360 / count);
        } else {
            return -1;
            //no bonds
        }
    }

    public boolean canBond() {
        //returns whether the atom can bond or not
        if (freeElectrons < 1 || freeElectrons > 4) {
            return false;
        }
        return true;
    }

    public void bond(Atom atom) {
        //covalent bond

        if (freeElectrons > 0) {
            cBondList.add(atom); // add new neighbor
            freeElectrons--;
        } // a new shared electron exists, number of free electrons goes down
        else {
            System.out.println("cannot covalent bond, no free electrons");
        }
    }

    public void doubleBond(Atom atom) {
        if (freeElectrons > 1) {
            dBondList.add(atom);
            freeElectrons -= 2;
        } else {
            System.out.println("Double bond failed");
        }
    }

    public boolean canIonicBond(Atom atom) {
        //if it can bond it returns true
        if ((freeElectrons == 7 && atom.getFreeElectrons() == 1)
                || (freeElectrons == 1 && atom.getFreeElectrons() == 7)) {
            // ionic bonding relies not on the state of each atom indiviually, but both as a pair
            return true;
        }
        System.out.println("can't ionic bond");
        return false;
        

    }

    public void ionicBond(Atom atom) {
        // first if is errornous
        // we already know an atom can bond before it gets here, hence no inner validation
        // inner validation makes a mess
        if (freeElectrons == 7) {
            ionize(true); // loose an electron
            iBondList.add(atom);
            freeElectrons = 0; // complete outer ring by reduction
        } else if (freeElectrons == 1) {
            ionize(false); // gain an electron
            iBondList.add(atom);
            // comeplete outer ring through gain
        } else {
            System.out.println("ionic bond failed");
        }

    }

    public String getSymbol() {
        return symbol;
    }

    public void printOut() {
        //gets overridden
        //below code gets called by subclasses
        System.out.println("Symbol: " + symbol);
        System.out.println("Atomic Number:" + atomicNumber);
        System.out.println("Free Electrons:" + freeElectrons);
        System.out.println("Charge: " + charge);
        System.out.println("2D Bond Angle: " + get2dBondAngle());

        int len = cBondList.size();
        System.out.print("Covalant Bonded Atoms: ");
        for (int i = 0; i < len; i++) {
            Atom current = cBondList.get(i);
            System.out.print(current.getSymbol() + ", ");
        }
        System.out.println();
        len = dBondList.size();
        System.out.print("Double Bonded Atoms: ");
        for (int i = 0; i < len; i++) {
            Atom current = dBondList.get(i);
            System.out.print(current.getSymbol() + ", ");
        }
        System.out.println();
        len = iBondList.size();
        System.out.print("Ionic Bonded Atoms: ");
        for (int i = 0; i < len; i++) {
            Atom current = iBondList.get(i);
            System.out.print(current.getSymbol() + ", ");
        }
        System.out.println();
        System.out.println("---------------------");
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chem;

/**
 *
 * @author Todd Perry 
 * 'experimental' class
 * it's what you load/save from the gui
 * yet to be implemented
 */
import java.util.ArrayList;

public class Project {
    
    private ArrayList<Molecule> molecules;
    private Molecule currentMol; // current molecule - displayed on screen
    private String filePath; // save/load location
    private String name; // name of project
}

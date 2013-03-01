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
    // this class will allow for molecules to bond!
    
    private ArrayList<Molecule> molecules;
    private Molecule currentMol; // current molecule - displayed on screen
    private String filePath; // save/load location
    private String name; // name of project
    
    public Project(Molecule starter, String name, String fp){
        molecules = new ArrayList<Molecule>(); // init
        currentMol = starter; // add
        molecules.add(starter);
        this.name = name;
        this.filePath = fp;
    }
    
    public Project(Molecule starter, String name){
        molecules = new ArrayList<Molecule>(); // init
        currentMol = starter; // add
        molecules.add(starter);
        this.name = name;
        this.filePath = "C:/Program Files/ChemRender/"; // default filePath
    }
    
    public Molecule getCurrentMol(){
        return this.currentMol;
    }
    
    public void addMol(Molecule mol){
        molecules.add(mol);
        currentMol = mol;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getFilePath(){
        return filePath;
    }
    
    public void setFilePath(String filePath){
        this.filePath = filePath;
    }
}

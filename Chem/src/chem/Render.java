/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package src.chem;

/**
 *
 * @author Todd Perry
 */
import javax.swing.JFrame;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.util.*; //for arraylists

public class Render extends JPanel {

    private Molecule molecule; // each render panel is focused on one molecule

    public Render(Molecule molecule) // set up graphics window
    {
        super();
        setBackground(Color.WHITE);
        this.molecule = molecule;
    }

    public void paintComponent(Graphics g) // draw graphics in the panel
    {
        int width = getWidth();             // width of window in pixels
        int height = getHeight();           // height of window in pixels



        super.paintComponent(g);            // call superclass to make panel display correctly


        // Drawing code goes here

        //covalent rendering code now bug free :D

        // next step, double bonds



        ArrayList<Atom> atoms = molecule.getAtoms();
        int len = atoms.size();

        int cX = 250;
        int cY = 250;

        Atom core = atoms.get(0);

        g.drawString(molecule.getName(), 250, 30);
        g.drawString("Formula: " + molecule.calculateFormula(), 250, 60);


        drawMolecule(g, core, cX, cY, true, "none", false);

        //CH4, non generic

        // g.drawString("C", 200, 200);

        // x base lines
        // g.drawLine(210, 195, 230, 195);
        // g.drawLine(195, 195, 175, 195);
        // y base lines
        // g.drawLine(204, 205, 204, 225); 
        // g.drawLine(204, 185, 204, 165);

        // x hydrogens
        // g.drawString("H", 165, 200);
        // g.drawString("H", 235, 200);

        // y hydrogens

        // g.drawString("H", 200, 235);
        // g.drawString("H", 200, 162);

        //g.drawLine(x, y, x, y);

    }

    public void drawMolecule(Graphics g, Atom current, int cX, int cY, boolean isCore, String branch, boolean branchDouble) {
        // add another parameter, that can either be up down left or right
        // it contains he value of the last rendered atom, eg. where to avoid rendering
        // then start on double bond rendering

        // the branch system is confusing as shit

        // up branch is 'down', left branch is 'right', etc...


        // only handles covalent (for now)

        g.drawString(current.getSymbol(), cX, cY);

        int adjacent = current.getAdjacent(); // number of neighboring atoms

        // highest adjacent can be is 4

        // order: up, down, left, right


        ArrayList<Atom> bondList = current.getCBondList();
        ArrayList<Atom> ionicBonds = current.getIBondList();
        ArrayList<Atom> doubleBonds = current.getDBondList();

        if (ionicBonds.isEmpty() == false) {
            //nothing will be to the right of the core
            g.drawString(ionicBonds.get(0).getSymbol(), cX + 30, cY);
        }

        if (isCore) {
            // current is molecule core


            if (adjacent == 1) {
                g.drawLine(cX + 4, cY - 13, cX + 4, cY - 33); // up
                drawMolecule(g, bondList.get(0), cX, cY - 40, false, "down", false);
            } else if (adjacent == 2) {
                g.drawLine(cX + 4, cY - 13, cX + 4, cY - 33); // up
                drawMolecule(g, bondList.get(0), cX, cY - 40, false, "down", false);

                g.drawLine(cX + 4, cY + 5, cX + 4, cY + 25); // down
                drawMolecule(g, bondList.get(1), cX, cY + 40, false, "up", false);

            } else if (adjacent == 3) {
                g.drawLine(cX + 4, cY - 13, cX + 4, cY - 33); // up
                drawMolecule(g, bondList.get(0), cX, cY - 40, false, "down", false);


                g.drawLine(cX + 4, cY + 5, cX + 4, cY + 25); // down
                drawMolecule(g, bondList.get(1), cX, cY + 40, false, "up", false);

                g.drawLine(cX - 5, cY - 4, cX - 25, cY - 4); // left
                drawMolecule(g, bondList.get(2), cX - 35, cY, false, "right", false);

            } else if (adjacent == 4) {
                g.drawLine(cX + 4, cY - 13, cX + 4, cY - 33); // up
                drawMolecule(g, bondList.get(0), cX, cY - 40, false, "down", false);

                g.drawLine(cX + 4, cY + 5, cX + 4, cY + 25); // down
                drawMolecule(g, bondList.get(1), cX, cY + 40, false, "up", false);

                g.drawLine(cX - 5, cY - 4, cX - 25, cY - 4); // left
                drawMolecule(g, bondList.get(2), cX - 35, cY, false, "right", false);

                g.drawLine(cX + 13, cY - 4, cX + 33, cY - 4); // right
                drawMolecule(g, bondList.get(3), cX + 40, cY, false, "left", false);
            }

        } else {
            // current isn't molecule core


            adjacent = adjacent - 1; // bond 0 has already been acounted for



            if (branchDouble == false) {
                if (branch.equals("right")) {
                    // left branch, don't draw 'right'
                    if (adjacent == 1) {
                        g.drawLine(cX + 4, cY - 13, cX + 4, cY - 33); // up
                        drawMolecule(g, bondList.get(1), cX, cY - 40, false, "down", false);
                    } else if (adjacent == 2) {
                        g.drawLine(cX + 4, cY - 13, cX + 4, cY - 33); // up
                        drawMolecule(g, bondList.get(1), cX, cY - 40, false, "down", false);

                        g.drawLine(cX + 4, cY + 5, cX + 4, cY + 25); // down
                        drawMolecule(g, bondList.get(2), cX, cY + 40, false, "up", false);
                    } else if (adjacent == 3) {
                        g.drawLine(cX + 4, cY - 13, cX + 4, cY - 33); // up
                        drawMolecule(g, bondList.get(1), cX, cY - 40, false, "down", false);

                        g.drawLine(cX + 4, cY + 5, cX + 4, cY + 25); // down
                        drawMolecule(g, bondList.get(2), cX, cY + 40, false, "up", false);

                        g.drawLine(cX - 5, cY - 4, cX - 25, cY - 4); // left
                        drawMolecule(g, bondList.get(3), cX - 35, cY, false, "right", false);

                    }
                } else if (branch.equals("up")) {
                    // down branch, don't draw 'up'

                    if (adjacent == 1) {
                        g.drawLine(cX + 4, cY + 5, cX + 4, cY + 25); // down
                        drawMolecule(g, bondList.get(1), cX, cY + 40, false, "up", false);
                    } else if (adjacent == 2) {
                        g.drawLine(cX + 4, cY + 5, cX + 4, cY + 25); // down
                        drawMolecule(g, bondList.get(1), cX, cY + 40, false, "up", false);

                        g.drawLine(cX - 5, cY - 4, cX - 25, cY - 4); // left
                        drawMolecule(g, bondList.get(2), cX - 35, cY, false, "right", false);
                    } else if (adjacent == 3) {
                        g.drawLine(cX + 4, cY + 5, cX + 4, cY + 25); // down
                        drawMolecule(g, bondList.get(1), cX, cY + 40, false, "up", false);

                        g.drawLine(cX - 5, cY - 4, cX - 25, cY - 4); // left
                        drawMolecule(g, bondList.get(2), cX - 35, cY, false, "right", false);

                        g.drawLine(cX + 13, cY - 4, cX + 33, cY - 4); // right
                        drawMolecule(g, bondList.get(3), cX + 40, cY, false, "left", false);
                    }
                } else if (branch.equals("down")) {
                    // up branch, don't go down
                    if (adjacent == 1) {
                        g.drawLine(cX + 4, cY - 13, cX + 4, cY - 33); // up
                        drawMolecule(g, bondList.get(1), cX, cY - 40, false, "down", false);
                    } else if (adjacent == 2) {
                        g.drawLine(cX + 4, cY - 13, cX + 4, cY - 33); // up
                        drawMolecule(g, bondList.get(1), cX, cY - 40, false, "down", false);

                        g.drawLine(cX - 5, cY - 4, cX - 25, cY - 4); // left
                        drawMolecule(g, bondList.get(2), cX - 35, cY, false, "right", false);
                    } else if (adjacent == 3) {
                        g.drawLine(cX + 4, cY - 13, cX + 4, cY - 33); // up
                        drawMolecule(g, bondList.get(1), cX, cY - 40, false, "down", false);

                        g.drawLine(cX - 5, cY - 4, cX - 25, cY - 4); // left
                        drawMolecule(g, bondList.get(2), cX - 35, cY, false, "right", false);

                        g.drawLine(cX + 13, cY - 4, cX + 33, cY - 4); // right
                        drawMolecule(g, bondList.get(3), cX + 40, cY, false, "left", false);
                    }
                } else if (branch.equals("left")) {
                    // right branch, don't draw left

                    if (adjacent == 1) {
                        g.drawLine(cX + 4, cY - 13, cX + 4, cY - 33); // up
                        drawMolecule(g, bondList.get(1), cX, cY - 40, false, "down", false);
                    } else if (adjacent == 2) {
                        g.drawLine(cX + 4, cY - 13, cX + 4, cY - 33); // up
                        drawMolecule(g, bondList.get(1), cX, cY - 40, false, "down", false);

                        g.drawLine(cX + 4, cY + 5, cX + 4, cY + 25); // down
                        drawMolecule(g, bondList.get(2), cX, cY + 40, false, "up", false);
                    } else if (adjacent == 3) {
                        g.drawLine(cX + 4, cY - 13, cX + 4, cY - 33); // up
                        drawMolecule(g, bondList.get(1), cX, cY - 40, false, "down", false);

                        g.drawLine(cX + 4, cY + 5, cX + 4, cY + 25); // down
                        drawMolecule(g, bondList.get(2), cX, cY + 40, false, "up", false);

                        g.drawLine(cX + 13, cY - 4, cX + 33, cY - 4); // right
                        drawMolecule(g, bondList.get(3), cX + 40, cY, false, "left", false);
                    }
                }




            } else {
                
                adjacent++;

                // branch is a double

                // max other branches is gunna be 2 rly


                if (branch.equals("right")) {
                    // left branch, don't draw 'right'
                    if (adjacent == 1) {
                        g.drawLine(cX + 4, cY - 13, cX + 4, cY - 33); // up
                        drawMolecule(g, bondList.get(0), cX, cY - 40, false, "down", false);
                    } else if (adjacent == 2) {
                        g.drawLine(cX + 4, cY - 13, cX + 4, cY - 33); // up
                        drawMolecule(g, bondList.get(0), cX, cY - 40, false, "down", false);

                        g.drawLine(cX + 4, cY + 5, cX + 4, cY + 25); // down
                        drawMolecule(g, bondList.get(1), cX, cY + 40, false, "up", false);
                    }
                } else if (branch.equals("up")) {
                    // down branch, don't draw 'up'

                    if (adjacent == 1) {
                        g.drawLine(cX + 4, cY + 5, cX + 4, cY + 25); // down
                        drawMolecule(g, bondList.get(0), cX, cY + 40, false, "up", false);
                    } else if (adjacent == 2) {
                        g.drawLine(cX + 4, cY + 5, cX + 4, cY + 25); // down
                        drawMolecule(g, bondList.get(0), cX, cY + 40, false, "up", false);

                        g.drawLine(cX - 5, cY - 4, cX - 25, cY - 4); // left
                        drawMolecule(g, bondList.get(1), cX - 35, cY, false, "right", false);
                    }
                } else if (branch.equals("down")) {
                    // up branch, don't go down
                    if (adjacent == 1) {
                        g.drawLine(cX + 4, cY - 13, cX + 4, cY - 33); // up
                        drawMolecule(g, bondList.get(0), cX, cY - 40, false, "down", false);
                    } else if (adjacent == 2) {
                        g.drawLine(cX + 4, cY - 13, cX + 4, cY - 33); // up
                        drawMolecule(g, bondList.get(0), cX, cY - 40, false, "down", false);

                        g.drawLine(cX - 5, cY - 4, cX - 25, cY - 4); // left
                        drawMolecule(g, bondList.get(1), cX - 35, cY, false, "right", false);
                    }
                } else if (branch.equals("left")) {
                    // right branch, don't draw left

                    if (adjacent == 1) {
                        g.drawLine(cX + 4, cY - 13, cX + 4, cY - 33); // up
                        drawMolecule(g, bondList.get(0), cX, cY - 40, false, "down", false);
                    } else if (adjacent == 2) {
                        g.drawLine(cX + 4, cY - 13, cX + 4, cY - 33); // up
                        drawMolecule(g, bondList.get(0), cX, cY - 40, false, "down", false);

                        g.drawLine(cX + 4, cY + 5, cX + 4, cY + 25); // down
                        drawMolecule(g, bondList.get(1), cX, cY + 40, false, "up", false);
                    }
                }
            }

        }
        // end of single bond run


        int currentBonds = current.getAdjacent();
        int doubleBondNo = current.getDBondList().size();
        // up down left right, plus whatever branch
        if (isCore && currentBonds
                == 0) {
            if (doubleBondNo == 1) {
                g.drawLine(cX + 2, cY - 13, cX + 2, cY - 33); // up
                g.drawLine(cX + 6, cY - 13, cX + 6, cY - 33); // up
                drawMolecule(g, doubleBonds.get(0), cX, cY - 40, false, "down", true);
            } else if (doubleBondNo == 2) {
                g.drawLine(cX + 2, cY - 13, cX + 2, cY - 33); // up
                g.drawLine(cX + 6, cY - 13, cX + 6, cY - 33); // up
                drawMolecule(g, doubleBonds.get(0), cX, cY - 40, false, "down", true);


                g.drawLine(cX + 2, cY + 5, cX + 2, cY + 25); // down
                g.drawLine(cX + 6, cY + 5, cX + 6, cY + 25); // down
                drawMolecule(g, doubleBonds.get(1), cX, cY + 40, false, "up", true);
            } else if (doubleBondNo == 3) {
                // this is the most it's possibly going to be realisticly

                g.drawLine(cX + 2, cY - 13, cX + 2, cY - 33); // up
                g.drawLine(cX + 6, cY - 13, cX + 6, cY - 33); // up
                drawMolecule(g, doubleBonds.get(0), cX, cY - 40, false, "down", true);


                g.drawLine(cX + 2, cY + 5, cX + 2, cY + 25); // down
                g.drawLine(cX + 6, cY + 5, cX + 6, cY + 25); // down
                drawMolecule(g, doubleBonds.get(1), cX, cY + 40, false, "up", true);


                g.drawLine(cX - 5, cY - 2, cX - 25, cY - 2); // left
                g.drawLine(cX - 5, cY - 6, cX - 25, cY - 6); // left
                drawMolecule(g, doubleBonds.get(2), cX - 35, cY, false, "right", true);
            }
        } else if (isCore && currentBonds
                == 1) {
            // it is possible to have two double bonds here
            if (doubleBondNo == 1) {

                // down

                g.drawLine(cX + 2, cY + 5, cX + 2, cY + 25); // down
                g.drawLine(cX + 6, cY + 5, cX + 6, cY + 25); // down
                drawMolecule(g, doubleBonds.get(0), cX, cY + 40, false, "up", true);
            } else if (doubleBondNo == 2) {

                g.drawLine(cX + 2, cY + 5, cX + 2, cY + 25); // down
                g.drawLine(cX + 6, cY + 5, cX + 6, cY + 25); // down
                drawMolecule(g, doubleBonds.get(0), cX, cY + 40, false, "up", true);


                g.drawLine(cX - 5, cY - 2, cX - 25, cY - 2); // left
                g.drawLine(cX - 5, cY - 6, cX - 25, cY - 6); // left
                drawMolecule(g, doubleBonds.get(1), cX - 35, cY, false, "right", true);
            }

        } else if (isCore && currentBonds
                == 2) {

            if (doubleBondNo == 1) {

                g.drawLine(cX - 5, cY - 2, cX - 25, cY - 2); // left
                g.drawLine(cX - 5, cY - 6, cX - 25, cY - 6); // left
                drawMolecule(g, doubleBonds.get(0), cX - 35, cY, false, "right", true);
            } else if (doubleBondNo == 2) {

                g.drawLine(cX - 5, cY - 2, cX - 25, cY - 2); // left
                g.drawLine(cX - 5, cY - 6, cX - 25, cY - 6); // left
                drawMolecule(g, doubleBonds.get(0), cX - 35, cY, false, "right", true);

                g.drawLine(cX + 13, cY - 2, cX + 33, cY - 2); // right
                g.drawLine(cX + 13, cY - 6, cX + 33, cY - 6); // right
                drawMolecule(g, doubleBonds.get(1), cX + 40, cY, false, "left", true);
            }



        } else if (isCore == false && doubleBondNo > 1 && branchDouble
                == true) {
            // the rest
            // the first double bond has already been rendered
            doubleBondNo--;
            if (branch.equals("up")) {

                g.drawLine(cX + 2, cY + 5, cX + 2, cY + 25); // down
                g.drawLine(cX + 6, cY + 5, cX + 6, cY + 25); // down
                drawMolecule(g, doubleBonds.get(1), cX, cY + 40, false, "up", true);
            } else if (branch.equals("down")) {

                g.drawLine(cX + 2, cY - 13, cX + 2, cY - 33); // up
                g.drawLine(cX + 6, cY - 13, cX + 6, cY - 33); // up
                drawMolecule(g, doubleBonds.get(1), cX, cY - 40, false, "down", true);
            } else if (branch.equals("left")) {
                g.drawLine(cX + 13, cY - 2, cX + 33, cY - 2); // right
                g.drawLine(cX + 13, cY - 6, cX + 33, cY - 6); // right
                drawMolecule(g, doubleBonds.get(1), cX + 40, cY, false, "left", true);
            } else if (branch.equals("right")) {
                g.drawLine(cX - 5, cY - 2, cX - 25, cY - 2); // left
                g.drawLine(cX - 5, cY - 6, cX - 25, cY - 6); // left
                drawMolecule(g, doubleBonds.get(1), cX - 35, cY, false, "right", true);
            }


        } else if (isCore == false && doubleBondNo == 1 && branchDouble
                == false) {
            currentBonds--;
            //currentBonds wil be either 1 or 2
            if (currentBonds == 0) {
                if (branch.equals("up") == false) {
                    g.drawLine(cX + 2, cY - 13, cX + 2, cY - 33); // up
                    g.drawLine(cX + 6, cY - 13, cX + 6, cY - 33); // up
                    drawMolecule(g, doubleBonds.get(0), cX, cY - 40, false, "down", true);
                } else {
                    g.drawLine(cX + 2, cY + 5, cX + 2, cY + 25); // down
                    g.drawLine(cX + 6, cY + 5, cX + 6, cY + 25); // down
                    drawMolecule(g, doubleBonds.get(0), cX, cY + 40, false, "up", true);
                }
            } else if (currentBonds == 1) {
                if (branch.equals("up")) {
                    g.drawLine(cX - 5, cY - 2, cX - 25, cY - 2); // left
                    g.drawLine(cX - 5, cY - 6, cX - 25, cY - 6); // left
                    drawMolecule(g, doubleBonds.get(0), cX - 35, cY, false, "right", true);
                } else if (branch.equals("down")) {
                    g.drawLine(cX - 5, cY - 2, cX - 25, cY - 2); // left
                    g.drawLine(cX - 5, cY - 6, cX - 25, cY - 6); // left
                    drawMolecule(g, doubleBonds.get(0), cX - 35, cY, false, "right", true);
                } else if (branch.equals("left")) {
                    g.drawLine(cX + 2, cY + 5, cX + 2, cY + 25); // down
                    g.drawLine(cX + 6, cY + 5, cX + 6, cY + 25); // down
                    drawMolecule(g, doubleBonds.get(0), cX, cY + 40, false, "up", true);
                } else if (branch.equals("right")) {
                    g.drawLine(cX - 5, cY - 2, cX - 25, cY - 2); // left
                    g.drawLine(cX - 5, cY - 6, cX - 25, cY - 6); // left
                    drawMolecule(g, doubleBonds.get(0), cX - 35, cY, false, "right", true);
                }
            }
        }
        // handle double bonds here
        // we know where bonds already exists due to branch and adjacent
    }

    public void run() {
        Render panel = new Render(molecule);                            // window for drawing
        JFrame application = new JFrame();                            // the program itself

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // set frame to exit
        // when it is closed
        application.add(panel);


        application.setSize(500, 500);         // window is 500 pixels wide, 500 high
        application.setVisible(true);



    }
}

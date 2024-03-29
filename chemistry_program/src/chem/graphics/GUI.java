/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chem.graphics;

import chem.Atom;
import chem.Molecule;
import chem.Project;
import chem.atoms.Chlorine;
import chem.atoms.Fluorine;
import chem.atoms.Hydrogen;
import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author U AMD
 */
public class GUI extends javax.swing.JFrame {

    /**
     * Creates new form GUI
     */
    private static Project project;
    private int renderType; // render type

    public GUI(Project project) {
        this.project = project;
        this.renderType = 2;
        initComponents();
        this.setBackground(Color.white);
        refresh();
    }

    public GUI() {
        this.project = new Project(new Molecule(new Hydrogen(), "Empty"), "Empty");
        this.renderType = 2;
        initComponents();
        //MoleculeInput moleIn = new MoleculeInput(this); // launches before main GUI can run
        //moleIn.main(null);

        refresh();
    }
    
    public void setProject(Project newProject){
        this.project = newProject;
        refresh();
    }
    
    public Project getProject(){
        return project;
    }

    public void addToMol(Atom atom, String bondType) {
        if (bondType.equals("Covalent")) {
            project.getCurrentMol().covalentBond(atom);
        } else if (bondType.equals("Double")) {
            project.getCurrentMol().doubleBond(atom);
        } else {
            project.getCurrentMol().ionicBond(atom);
        }
        refresh();
    }

    public Molecule getMol() {
        return project.getCurrentMol();
    }

    public void addMol(Molecule mol) {
        this.project.addMol(mol);
        refresh();
    }

    private void reRender() {
        render.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        render.setPreferredSize(new java.awt.Dimension(500, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(infoWrap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(render, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(title, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(render, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(infoWrap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap()));


    }

    public void refresh() {
        // update molecule
        // refreshes all
        // public; can be accessed externally
        this.remove(render);
        render = new Render(project.getCurrentMol(), renderType);
        this.add(render);
        reRender();
        this.invalidate();
        render.repaint();
        //this.revalidate();

        molName.setText(project.getCurrentMol().getName());
        molFormula.setText(project.getCurrentMol().calculateFormula());
        molAtoms.setText(String.valueOf(project.getCurrentMol().getNumberOfAtoms()));
        molProt.setText(String.valueOf(project.getCurrentMol().getSize()));
        molFree.setText(String.valueOf(project.getCurrentMol().getTotalFreeElectrons()));

        projectName.setText(project.getName());
        filePathTxt.setText(project.getFilePath());
        noOfMols.setText(String.valueOf(project.getNumberOfMolecules()));


    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        render = new Render(project.getCurrentMol(), renderType);
        title = new javax.swing.JLabel();
        infoWrap = new javax.swing.JPanel();
        projectInfoWrap = new javax.swing.JPanel();
        lnlProjInfo = new javax.swing.JLabel();
        lblProjName = new javax.swing.JLabel();
        projectName = new javax.swing.JLabel();
        lblNoOfMols = new javax.swing.JLabel();
        noOfMols = new javax.swing.JLabel();
        filePath = new javax.swing.JLabel();
        filePathTxt = new javax.swing.JLabel();
        moleculeInfoWrap = new javax.swing.JPanel();
        lblinfo = new javax.swing.JLabel();
        lblMolname = new javax.swing.JLabel();
        molName = new javax.swing.JLabel();
        lblFormula = new javax.swing.JLabel();
        molFormula = new javax.swing.JLabel();
        lblnoofAtom = new javax.swing.JLabel();
        molAtoms = new javax.swing.JLabel();
        lblnoofProt = new javax.swing.JLabel();
        molProt = new javax.swing.JLabel();
        lblFreeElc = new javax.swing.JLabel();
        molFree = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        file = new javax.swing.JMenu();
        newProject = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        manualRefresh = new javax.swing.JMenuItem();
        edit = new javax.swing.JMenu();
        deleteLast = new javax.swing.JMenuItem();
        view = new javax.swing.JMenu();
        selectRenderType = new javax.swing.JMenu();
        fullRender = new javax.swing.JCheckBoxMenuItem();
        negateHydrogen = new javax.swing.JCheckBoxMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        smartRender = new javax.swing.JCheckBoxMenuItem();
        projectMenu = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        molecule = new javax.swing.JMenu();
        newMolecule = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        addAtom = new javax.swing.JMenuItem();
        autoFill = new javax.swing.JMenu();
        autoHydrogen = new javax.swing.JMenuItem();
        autoFluorine = new javax.swing.JMenuItem();
        autoChlorine = new javax.swing.JMenuItem();
        buildInfo = new javax.swing.JMenu();
        showBuildInfo = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chemical Render System");

        render.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        render.setPreferredSize(new java.awt.Dimension(500, 500));

        javax.swing.GroupLayout renderLayout = new javax.swing.GroupLayout(render);
        render.setLayout(renderLayout);
        renderLayout.setHorizontalGroup(
            renderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 496, Short.MAX_VALUE)
        );
        renderLayout.setVerticalGroup(
            renderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 496, Short.MAX_VALUE)
        );

        title.setFont(new java.awt.Font("Utsaah", 2, 24)); // NOI18N
        title.setText("Chemical Render System");

        projectInfoWrap.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        projectInfoWrap.setOpaque(false);
        projectInfoWrap.setPreferredSize(new java.awt.Dimension(255, 167));

        lnlProjInfo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lnlProjInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lnlProjInfo.setText("Project Info");

        lblProjName.setText("Project Name:");

        projectName.setText("-");

        lblNoOfMols.setText("Number Of Molecules:");

        noOfMols.setText("-");

        filePath.setText("File Path:");

        filePathTxt.setText("-");

        javax.swing.GroupLayout projectInfoWrapLayout = new javax.swing.GroupLayout(projectInfoWrap);
        projectInfoWrap.setLayout(projectInfoWrapLayout);
        projectInfoWrapLayout.setHorizontalGroup(
            projectInfoWrapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lnlProjInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(projectInfoWrapLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(projectInfoWrapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNoOfMols)
                    .addGroup(projectInfoWrapLayout.createSequentialGroup()
                        .addGroup(projectInfoWrapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblProjName)
                            .addComponent(filePath))
                        .addGap(64, 64, 64)
                        .addGroup(projectInfoWrapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(filePathTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                            .addGroup(projectInfoWrapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(projectName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                                .addComponent(noOfMols, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        projectInfoWrapLayout.setVerticalGroup(
            projectInfoWrapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(projectInfoWrapLayout.createSequentialGroup()
                .addComponent(lnlProjInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(projectInfoWrapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProjName)
                    .addComponent(projectName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(projectInfoWrapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filePath)
                    .addComponent(filePathTxt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(projectInfoWrapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNoOfMols)
                    .addComponent(noOfMols))
                .addContainerGap())
        );

        moleculeInfoWrap.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblinfo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblinfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblinfo.setText("Molecule Info");

        lblMolname.setText("Molecule Name:");

        molName.setText("-");

        lblFormula.setText("Formula:");

        molFormula.setText("-");

        lblnoofAtom.setText("Number Of Atoms:");

        molAtoms.setText("-");

        lblnoofProt.setText("Number Of Protons:");

        molProt.setText("-");

        lblFreeElc.setText("Free Electrons:");

        molFree.setText("-");

        javax.swing.GroupLayout moleculeInfoWrapLayout = new javax.swing.GroupLayout(moleculeInfoWrap);
        moleculeInfoWrap.setLayout(moleculeInfoWrapLayout);
        moleculeInfoWrapLayout.setHorizontalGroup(
            moleculeInfoWrapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblinfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(moleculeInfoWrapLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(moleculeInfoWrapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMolname)
                    .addComponent(lblFormula)
                    .addComponent(lblnoofAtom)
                    .addComponent(lblnoofProt)
                    .addComponent(lblFreeElc))
                .addGap(26, 26, 26)
                .addGroup(moleculeInfoWrapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(molFree, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(moleculeInfoWrapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(molProt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(molFormula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(molAtoms, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(molName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(149, Short.MAX_VALUE))
        );
        moleculeInfoWrapLayout.setVerticalGroup(
            moleculeInfoWrapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(moleculeInfoWrapLayout.createSequentialGroup()
                .addComponent(lblinfo, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(moleculeInfoWrapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMolname)
                    .addComponent(molName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(moleculeInfoWrapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFormula)
                    .addComponent(molFormula))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(moleculeInfoWrapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblnoofAtom)
                    .addComponent(molAtoms))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(moleculeInfoWrapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblnoofProt)
                    .addComponent(molProt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(moleculeInfoWrapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblFreeElc)
                    .addComponent(molFree, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout infoWrapLayout = new javax.swing.GroupLayout(infoWrap);
        infoWrap.setLayout(infoWrapLayout);
        infoWrapLayout.setHorizontalGroup(
            infoWrapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoWrapLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(infoWrapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(projectInfoWrap, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE)
                    .addComponent(moleculeInfoWrap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        infoWrapLayout.setVerticalGroup(
            infoWrapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoWrapLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(projectInfoWrap, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(moleculeInfoWrap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        file.setText("File");

        newProject.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        newProject.setText("New Project");
        newProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newProjectActionPerformed(evt);
            }
        });
        file.add(newProject);
        file.add(jSeparator1);

        manualRefresh.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        manualRefresh.setText("Refresh");
        manualRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manualRefreshActionPerformed(evt);
            }
        });
        file.add(manualRefresh);

        menuBar.add(file);

        edit.setText("Edit");

        deleteLast.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        deleteLast.setText("Remove Last Atom");
        deleteLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteLastActionPerformed(evt);
            }
        });
        edit.add(deleteLast);

        menuBar.add(edit);

        view.setText("View");

        selectRenderType.setText("Select Render Type");

        fullRender.setText("Full Render");
        fullRender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fullRenderActionPerformed(evt);
            }
        });
        selectRenderType.add(fullRender);

        negateHydrogen.setText("Negate Hydrogens");
        negateHydrogen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                negateHydrogenActionPerformed(evt);
            }
        });
        selectRenderType.add(negateHydrogen);
        selectRenderType.add(jSeparator3);

        smartRender.setSelected(true);
        smartRender.setText("'Smart' Render");
        smartRender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smartRenderActionPerformed(evt);
            }
        });
        selectRenderType.add(smartRender);

        view.add(selectRenderType);

        menuBar.add(view);

        projectMenu.setText("Project");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Change Current Molecule");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        projectMenu.add(jMenuItem2);

        menuBar.add(projectMenu);

        molecule.setText("Molecule");

        newMolecule.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, java.awt.event.InputEvent.CTRL_MASK));
        newMolecule.setText("New Molecule");
        newMolecule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newMoleculeActionPerformed(evt);
            }
        });
        molecule.add(newMolecule);
        molecule.add(jSeparator2);

        addAtom.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.ALT_MASK));
        addAtom.setText("Add Atom");
        addAtom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAtomActionPerformed(evt);
            }
        });
        molecule.add(addAtom);

        autoFill.setText("Auto Fill");

        autoHydrogen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        autoHydrogen.setText("Hydrogens");
        autoHydrogen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autoHydrogenActionPerformed(evt);
            }
        });
        autoFill.add(autoHydrogen);

        autoFluorine.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        autoFluorine.setText("Fluorines");
        autoFluorine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autoFluorineActionPerformed(evt);
            }
        });
        autoFill.add(autoFluorine);

        autoChlorine.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        autoChlorine.setText("Chlorines");
        autoChlorine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autoChlorineActionPerformed(evt);
            }
        });
        autoFill.add(autoChlorine);

        molecule.add(autoFill);

        menuBar.add(molecule);

        buildInfo.setText("Build Info");
        buildInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buildInfoActionPerformed(evt);
            }
        });

        showBuildInfo.setText("Show Build Info");
        showBuildInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showBuildInfoActionPerformed(evt);
            }
        });
        buildInfo.add(showBuildInfo);

        jMenuItem1.setText("Show Changelog");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        buildInfo.add(jMenuItem1);

        menuBar.add(buildInfo);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(infoWrap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addComponent(render, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(title)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(render, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(infoWrap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addAtomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAtomActionPerformed
        AtomInput atomIn = new AtomInput(this);
        atomIn.main(null);
        refresh(); // repaint
    }//GEN-LAST:event_addAtomActionPerformed

    private void newMoleculeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newMoleculeActionPerformed
        MoleculeInput moleIn = new MoleculeInput(this);
        moleIn.main(null);
        refresh(); // repaint
    }//GEN-LAST:event_newMoleculeActionPerformed

    private void manualRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manualRefreshActionPerformed
        refresh();
    }//GEN-LAST:event_manualRefreshActionPerformed

    private void autoChlorineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autoChlorineActionPerformed
        int total = project.getCurrentMol().getTotalFreeElectrons();
        for (int i = 0; i < total; i++) {
            project.getCurrentMol().covalentBond(new Chlorine());
            refresh();
        }
    }//GEN-LAST:event_autoChlorineActionPerformed

    private void autoHydrogenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autoHydrogenActionPerformed
        int total = project.getCurrentMol().getTotalFreeElectrons();
        for (int i = 0; i < total; i++) {
            project.getCurrentMol().covalentBond(new Hydrogen());
            refresh();
        }
    }//GEN-LAST:event_autoHydrogenActionPerformed

    private void autoFluorineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autoFluorineActionPerformed
        int total = project.getCurrentMol().getTotalFreeElectrons();
        for (int i = 0; i < total; i++) {
            project.getCurrentMol().covalentBond(new Fluorine());
            refresh();
        }
    }//GEN-LAST:event_autoFluorineActionPerformed

    private void deleteLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteLastActionPerformed
        if (project.getCurrentMol().getNumberOfAtoms() > 1) {
            ArrayList<Atom> atoms = project.getCurrentMol().getAtoms();
            if (atoms.size() > 1) {
                Atom toRemove = atoms.get(atoms.size() - 1); // error is on this line
                atoms.get(atoms.size() - 1).printOut();
                project.getCurrentMol().unBondAtom(toRemove);
                refresh();
            }
            refresh();
        }
    }//GEN-LAST:event_deleteLastActionPerformed

    private void buildInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buildInfoActionPerformed
    }//GEN-LAST:event_buildInfoActionPerformed

    private void showBuildInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showBuildInfoActionPerformed
        BuildInfo bi = new BuildInfo();
        bi.main(null);
    }//GEN-LAST:event_showBuildInfoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Changelog cl = new Changelog();
        cl.main(null);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void newProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newProjectActionPerformed
        NewProject np = new NewProject(this);
        np.main(null);
    }//GEN-LAST:event_newProjectActionPerformed

    private void fullRenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fullRenderActionPerformed
        // Full render
        negateHydrogen.setSelected(false);
        smartRender.setSelected(false);


        fullRender.setSelected(true);

        renderType = 0;
        refresh();

    }//GEN-LAST:event_fullRenderActionPerformed

    private void negateHydrogenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_negateHydrogenActionPerformed
        // Negate Hydrogens
        smartRender.setSelected(false);
        fullRender.setSelected(false);


        negateHydrogen.setSelected(true);

        renderType = 1;
        refresh();
    }//GEN-LAST:event_negateHydrogenActionPerformed

    private void smartRenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smartRenderActionPerformed
        // Smart Render
        fullRender.setSelected(false);
        negateHydrogen.setSelected(false);

        smartRender.setSelected(true);



        renderType = 2;
        refresh();
    }//GEN-LAST:event_smartRenderActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        
        ChangeMolecule cm = new ChangeMolecule(this);
        cm.main(null);
        refresh();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem addAtom;
    private javax.swing.JMenuItem autoChlorine;
    private javax.swing.JMenu autoFill;
    private javax.swing.JMenuItem autoFluorine;
    private javax.swing.JMenuItem autoHydrogen;
    private javax.swing.JMenu buildInfo;
    private javax.swing.JMenuItem deleteLast;
    private javax.swing.JMenu edit;
    private javax.swing.JMenu file;
    private javax.swing.JLabel filePath;
    private javax.swing.JLabel filePathTxt;
    private javax.swing.JCheckBoxMenuItem fullRender;
    private javax.swing.JPanel infoWrap;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JLabel lblFormula;
    private javax.swing.JLabel lblFreeElc;
    private javax.swing.JLabel lblMolname;
    private javax.swing.JLabel lblNoOfMols;
    private javax.swing.JLabel lblProjName;
    private javax.swing.JLabel lblinfo;
    private javax.swing.JLabel lblnoofAtom;
    private javax.swing.JLabel lblnoofProt;
    private javax.swing.JLabel lnlProjInfo;
    private javax.swing.JMenuItem manualRefresh;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JLabel molAtoms;
    private javax.swing.JLabel molFormula;
    private javax.swing.JLabel molFree;
    private javax.swing.JLabel molName;
    private javax.swing.JLabel molProt;
    private javax.swing.JMenu molecule;
    private javax.swing.JPanel moleculeInfoWrap;
    private javax.swing.JCheckBoxMenuItem negateHydrogen;
    private javax.swing.JMenuItem newMolecule;
    private javax.swing.JMenuItem newProject;
    private javax.swing.JLabel noOfMols;
    private javax.swing.JPanel projectInfoWrap;
    private javax.swing.JMenu projectMenu;
    private javax.swing.JLabel projectName;
    private javax.swing.JPanel render;
    private javax.swing.JMenu selectRenderType;
    private javax.swing.JMenuItem showBuildInfo;
    private javax.swing.JCheckBoxMenuItem smartRender;
    private javax.swing.JLabel title;
    private javax.swing.JMenu view;
    // End of variables declaration//GEN-END:variables
}

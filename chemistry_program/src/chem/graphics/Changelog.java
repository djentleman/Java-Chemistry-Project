/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chem.graphics;

/**
 *
 * @author Todd Perry
 */
public class Changelog extends javax.swing.JFrame {

    /**
     * Creates new form Changelog
     */
    public Changelog() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        changelog = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Change Log");

        changelog.setEditable(false);
        changelog.setColumns(20);
        changelog.setRows(5);
        changelog.setText("Java-Chemistry-Project\n======================\n\n> Current Version 1.2\n\nCHANGELOG:\n\n---------------------------------------------------\n\nINDEV\n\n--changes from v1.2--\n\n- able to view changelog\n\n- able to view build info\n\n- on launch bug fix\n\n- changes made to 'smart render', a\nmolecule must contain 20 atoms in order to be rendered in shorthand\n\n- able to delete the last added atom from the molecule\n\n- users can now pick bond types when adding atoms\n\n- add atom bugfix\n\n- project class added, but not implemented\n\n- obsolete classes removed\n\n- new project form added\n\n- cranges made to GUI structure\n\n- now works with 'Project' as opposed to 'Molecule'\n\n- keeps track of number of Molecules in project\n\n- can now change rendeing type\n\n- undo bug(s) fixed\n\n---------------------------------------------------\nv1.2\n\n--changes from v1.1--\n\n- Java Swing GUI implemented!!!\n\n- hydrogen, fluorine, chlorone 'auto fill' feature\n\n- Chem now runs a GUI\n\n---------------------------------------------------\nv1.1\n\n--changes from v1.0--\n\n- atom nodes now have a 'parent', \ndoes nothing yet but will be\nimplemented to rendering soon\n\n- 'smart rendering', larger chemicals have a simpler\nrender structure, as opposed to the full render, eg.\n\n\n        H-0-H  --would render as--> H20\n\n- a more advanced protein building system, now accpects\namino acid instruction sets\n\n- atoms now have a unique ID, composed of a molecule ID, and\nan atom id, eg atom 2.15 is atom 15, of group 2\n\n- molecule can no longer bond and incorperate two atoms\nfrom the outside via bonding, molecules can only\ngain atoms from being bonded to\n\n- error fixing in the 'Experiment' class\n\n- more module tests in 'Chem'\n\n------------------------------------------------------\n");
        jScrollPane1.setViewportView(changelog);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Changelog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Changelog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Changelog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Changelog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Changelog().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea changelog;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

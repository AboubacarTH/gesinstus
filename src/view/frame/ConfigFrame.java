/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.frame;

import view.panel.ConfigPanel;
import view.panel.EtudiantPanel;
import view.panel.FiliereOptionPanel;
import view.panel.NotePan;
import view.panel.ProfesseurPanel;
import view.panel.UniteEnseignementElementConstitutifPanel;
import view.panel.UniteEnseignementOptionPanel;

/**
 *
 * @author ATH
 */
public class ConfigFrame extends javax.swing.JFrame {

    /**
     * Creates new form ConfigForm
     */
    public ConfigFrame() {
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

        rSPanelImage1 = new rojerusan.RSPanelImage();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        menu_item_ue = new javax.swing.JMenuItem();
        jMenuItem_ue_option = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        menu_item_eleve = new javax.swing.JMenuItem();
        menu_item_enseignant = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menu_item_gestion_matiere = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Configuration");

        rSPanelImage1.setImagen(new javax.swing.ImageIcon(getClass().getResource("/icon/getty_883231284_200013331818843182490_335833.jpg"))); // NOI18N

        javax.swing.GroupLayout rSPanelImage1Layout = new javax.swing.GroupLayout(rSPanelImage1);
        rSPanelImage1.setLayout(rSPanelImage1Layout);
        rSPanelImage1Layout.setHorizontalGroup(
            rSPanelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1110, Short.MAX_VALUE)
        );
        rSPanelImage1Layout.setVerticalGroup(
            rSPanelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 656, Short.MAX_VALUE)
        );

        jMenu1.setText("Fichier");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edition");

        jMenuItem2.setText("Filière et Option");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);
        jMenu2.add(jSeparator2);

        menu_item_ue.setText("Unité d'enseignement");
        menu_item_ue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_ueActionPerformed(evt);
            }
        });
        jMenu2.add(menu_item_ue);

        jMenuItem_ue_option.setText("Unité d'enseignement par Option");
        jMenuItem_ue_option.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_ue_optionActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem_ue_option);
        jMenu2.add(jSeparator3);

        menu_item_eleve.setText("Etudiant");
        menu_item_eleve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_eleveActionPerformed(evt);
            }
        });
        jMenu2.add(menu_item_eleve);

        menu_item_enseignant.setText("Enseignant");
        menu_item_enseignant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_enseignantActionPerformed(evt);
            }
        });
        jMenu2.add(menu_item_enseignant);
        jMenu2.add(jSeparator1);

        menu_item_gestion_matiere.setText("Gestion des notes");
        menu_item_gestion_matiere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_gestion_matiereActionPerformed(evt);
            }
        });
        jMenu2.add(menu_item_gestion_matiere);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Programmation");

        jMenuItem1.setText("Paramètre");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Help");
        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSPanelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menu_item_eleveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_eleveActionPerformed
        this.setContentPane(new EtudiantPanel());
        this.revalidate();
        this.repaint();
    }//GEN-LAST:event_menu_item_eleveActionPerformed

    private void menu_item_enseignantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_enseignantActionPerformed
        this.setContentPane(new ProfesseurPanel());
        this.revalidate();
        this.repaint();
    }//GEN-LAST:event_menu_item_enseignantActionPerformed

    private void menu_item_ueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_ueActionPerformed
        this.setContentPane(new UniteEnseignementElementConstitutifPanel());
        this.revalidate();
        this.repaint();
    }//GEN-LAST:event_menu_item_ueActionPerformed

    private void menu_item_gestion_matiereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_gestion_matiereActionPerformed
        //this.setContentPane(new CoursPan());
        this.setContentPane(new NotePan());
        this.revalidate();
        this.repaint();
    }//GEN-LAST:event_menu_item_gestion_matiereActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        this.setContentPane(new ConfigPanel());
        this.revalidate();
        this.repaint();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        this.setContentPane(new FiliereOptionPanel());
        this.revalidate();
        this.repaint();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem_ue_optionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_ue_optionActionPerformed
        this.setContentPane(new UniteEnseignementOptionPanel());
        this.revalidate();
        this.repaint();
    }//GEN-LAST:event_jMenuItem_ue_optionActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConfigFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ConfigFrame().setVisible(true);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem_ue_option;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JMenuItem menu_item_eleve;
    private javax.swing.JMenuItem menu_item_enseignant;
    private javax.swing.JMenuItem menu_item_gestion_matiere;
    private javax.swing.JMenuItem menu_item_ue;
    private rojerusan.RSPanelImage rSPanelImage1;
    // End of variables declaration//GEN-END:variables

}

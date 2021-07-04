/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.dialog;

import bean.ElementConstitutif;
import bean.UniteEnseignement;
import controller.ElementConstitutifController;
import controller.UniteEnseignementController;
import javax.swing.JOptionPane;

/**
 *
 * @author ATH
 */
public class ElementConstitutifDialog extends javax.swing.JDialog {

    /**
     * Creates new form EcAdd
     * @param parent
     * @param modal
     */
    public ElementConstitutifDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        elementConstitutifController = new ElementConstitutifController();
        uniteEnseignementController = new UniteEnseignementController();
        initComponents();
        initCbUe();
    }
    public ElementConstitutifDialog(java.awt.Frame parent, boolean modal, UniteEnseignement uniteEnseignement) {
        super(parent, modal);
        elementConstitutifController = new ElementConstitutifController();
        uniteEnseignementController = new UniteEnseignementController();
        initComponents();
        initCbUe();
        try {
            rSComboMetro_sigle_ue.setSelectedItem(uniteEnseignement.getSigle());
        } catch (Exception e) {
        }
    }
    public ElementConstitutifDialog(java.awt.Frame parent, boolean modal, ElementConstitutif elementConstitutif) {
        super(parent, modal);
        elementConstitutifController = new ElementConstitutifController();
        uniteEnseignementController = new UniteEnseignementController();
        this.elementConstitutif = elementConstitutif;
        initComponents();
        initCbUe();
        try {
            rSComboMetro_sigle_ue.setSelectedItem(uniteEnseignementController.getUniteEnseignement(this.elementConstitutif.getId_unite_enseignement()).getSigle());
        } catch (Exception e) {
        }
        rSMTextFull_sigle_ec.setText(this.elementConstitutif.getSigle());
        rSMTextFull_nom.setText(this.elementConstitutif.getNom());
        rSButton_valider.setText("Mettre à jour");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSMTextFull_sigle_ec = new rojeru_san.RSMTextFull();
        jLabel1 = new javax.swing.JLabel();
        rSMTextFull_nom = new rojeru_san.RSMTextFull();
        jLabel2 = new javax.swing.JLabel();
        rSButton_valider = new rojeru_san.RSButton();
        rSComboMetro_sigle_ue = new rojerusan.RSComboMetro();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestion des EC");

        rSMTextFull_sigle_ec.setPlaceholder("");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Sigle élément constitutif");

        rSMTextFull_nom.setPlaceholder("");

        jLabel2.setText("Nom élément constitutif");

        rSButton_valider.setText("Valider");
        rSButton_valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButton_validerActionPerformed(evt);
            }
        });

        rSComboMetro_sigle_ue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSComboMetro_sigle_ueActionPerformed(evt);
            }
        });

        jLabel3.setText("Sigle unité d'enseignement");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rSMTextFull_nom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
                            .addComponent(rSMTextFull_sigle_ec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rSComboMetro_sigle_ue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(rSButton_valider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rSComboMetro_sigle_ue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rSMTextFull_sigle_ec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rSMTextFull_nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rSButton_valider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rSButton_validerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButton_validerActionPerformed
        if(rSMTextFull_nom.getText().length() <= 0 || rSMTextFull_sigle_ec.getText().length() <= 0 || rSComboMetro_sigle_ue.getSelectedIndex() < 0){
            JOptionPane.showMessageDialog(this, "Champ vide.", "Erreur de syntaxe !", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(elementConstitutif == null){
            elementConstitutifController.addElementConstitutif(
                    uniteEnseignementController.getUniteEnseignement(rSComboMetro_sigle_ue.getSelectedItem().toString()).getId(),
                    rSMTextFull_sigle_ec.getText(),
                    rSMTextFull_nom.getText(),
                    0,
                    0
            );
        }else{
            elementConstitutifController.updateElementConstitutif(
                    elementConstitutif.getId(),
                    uniteEnseignementController.getUniteEnseignement(rSComboMetro_sigle_ue.getSelectedItem().toString()).getId(),
                    rSMTextFull_sigle_ec.getText(),
                    rSMTextFull_nom.getText(),
                    0,
                    0
            );
        }
        success_information();
        this.dispose();
    }//GEN-LAST:event_rSButton_validerActionPerformed

    private void rSComboMetro_sigle_ueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSComboMetro_sigle_ueActionPerformed
        if(rSComboMetro_sigle_ue.getSelectedIndex() < 0){
            rSMTextFull_sigle_ec.setText("");
        }else{
            rSMTextFull_sigle_ec.setText(rSComboMetro_sigle_ue.getSelectedItem().toString());
        }
    }//GEN-LAST:event_rSComboMetro_sigle_ueActionPerformed

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
            java.util.logging.Logger.getLogger(ElementConstitutifDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ElementConstitutifDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ElementConstitutifDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ElementConstitutifDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            ElementConstitutifDialog dialog = new ElementConstitutifDialog(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }
    private final ElementConstitutifController elementConstitutifController;
    private ElementConstitutif elementConstitutif;
    private final UniteEnseignementController uniteEnseignementController;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private rojeru_san.RSButton rSButton_valider;
    private rojerusan.RSComboMetro rSComboMetro_sigle_ue;
    private rojeru_san.RSMTextFull rSMTextFull_nom;
    private rojeru_san.RSMTextFull rSMTextFull_sigle_ec;
    // End of variables declaration//GEN-END:variables

    private void initCbUe() {
        rSComboMetro_sigle_ue.removeAllItems();
        uniteEnseignementController.getUniteEnseignements().forEach((u) -> {
            rSComboMetro_sigle_ue.addItem(u.getSigle());
        });
    }
    private void success_information() {
        JOptionPane.showMessageDialog(this, "Opération effectuée avec succes ", "Réussie !", JOptionPane.INFORMATION_MESSAGE);
    }
}

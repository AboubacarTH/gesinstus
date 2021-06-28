/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.dialog;

import bean.Nationalite;
import controller.NationaliteController;
import javax.swing.JOptionPane;

/**
 *
 * @author ATH
 */
public class NationaliteDialog extends javax.swing.JDialog {

    /**
     * Creates new form Nationalite
     * @param parent
     * @param modal
     */
    public NationaliteDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        nationaliteController = new NationaliteController();
        initComponents();
    }
    public NationaliteDialog(java.awt.Frame parent, boolean modal, Nationalite nationalite) {
        super(parent, modal);
        nationaliteController = new NationaliteController();
        this.nationalite = nationalite;
        initComponents();
        rSMTextFull_nationalite.setText(this.nationalite.getNationalite());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSMTextFull_nationalite = new rojeru_san.RSMTextFull();
        btn_valider = new rojeru_san.RSButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        rSMTextFull_nationalite.setPlaceholder("Nationalité");

        btn_valider.setText("Valider");
        btn_valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_validerActionPerformed(evt);
            }
        });

        jLabel1.setText("Nationalité");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rSMTextFull_nationalite, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_valider, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rSMTextFull_nationalite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(btn_valider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_validerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_validerActionPerformed
        if(rSMTextFull_nationalite.getText().length() == 0){
            JOptionPane.showMessageDialog(this, "Renseigner la nationalité !", "Champ vide !", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if(nationalite == null){
            nationaliteController.addNationalite(
                    rSMTextFull_nationalite.getText()
            );
        }else{
            nationaliteController.updateNationalite(nationalite.getId(), 
                    rSMTextFull_nationalite.getText()
            );
        }
        success_information();
        this.dispose();
    }//GEN-LAST:event_btn_validerActionPerformed

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
            java.util.logging.Logger.getLogger(NationaliteDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            NationaliteDialog dialog = new NationaliteDialog(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }
    private Nationalite nationalite;
    private final NationaliteController nationaliteController;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.RSButton btn_valider;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private rojeru_san.RSMTextFull rSMTextFull_nationalite;
    // End of variables declaration//GEN-END:variables
private void success_information() {
        JOptionPane.showMessageDialog(this, "Opération effectuée avec succes ", "Réussie !", JOptionPane.INFORMATION_MESSAGE);
    }
}

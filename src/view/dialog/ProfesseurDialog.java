/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dialog;

import bean.Professeur;
import controller.NationaliteController;
import controller.ProfesseurController;
import java.sql.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author ATH
 */
public class ProfesseurDialog extends javax.swing.JDialog {

    /**
     * Creates new form Eleve
     * @param parent
     * @param modal
     */
    public ProfesseurDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        nationaliteController = new NationaliteController();
        professeurController = new ProfesseurController();
        initComponents();
        initCbNationalite();
        initMatricule();
    }
    
    public ProfesseurDialog(java.awt.Frame parent, boolean modal, String matricule) {
        super(parent, modal);
        nationaliteController = new NationaliteController();
        professeurController = new ProfesseurController();
        professeur = professeurController.getProfesseur(matricule);
        initComponents();
        initCbNationalite();
        initMatricule();
        try {
            rSComboMetro_titre.setSelectedItem(professeur.getTitre());
            rSbComboMetro_nationalite.setSelectedItem(professeur.getNationalite());
            if("Mr".equals(rSComboMetro_titre.getSelectedItem().toString())){
                rSComboMetro_sexe.setSelectedItem("M");
            }else if("Mme".equals(rSComboMetro_titre.getSelectedItem().toString()) || "Mlle".equals(rSComboMetro_titre.getSelectedItem().toString())){
                rSComboMetro_sexe.setSelectedItem("F");
            }
        } catch (Exception e) {
        }
        
        rSMTextFull_contact.setText(professeur.getContact());
        rSMTextFull_nom_prenom.setText(professeur.getNom_prenom());
        rSMTextFull_matricule.setText(professeur.getMatricule());
        jDateChooser_date_de_naissance.setDate(professeur.getDate_de_naissance());
        rSMTextFull_lieu_de_naissance.setText(professeur.getLieu_de_naissance());
        rSMTextFull_diplome.setText(professeur.getDiplome());
        rSMPassView_mot_de_passe.setText(professeur.getMot_de_passe());
        btn_valider.setText("Mettre à jour");
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSMTextFull_nom_prenom = new rojeru_san.RSMTextFull();
        rSMTextFull_contact = new rojeru_san.RSMTextFull();
        rSbComboMetro_nationalite = new rojerusan.RSComboMetro();
        btn_valider = new rojeru_san.RSButton();
        rSMTextFull_matricule = new rojeru_san.RSMTextFull();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jDateChooser_date_de_naissance = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        rSMTextFull_lieu_de_naissance = new rojeru_san.RSMTextFull();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        rSComboMetro_sexe = new rojerusan.RSComboMetro();
        rSComboMetro_titre = new rojerusan.RSComboMetro();
        jLabel10 = new javax.swing.JLabel();
        rSMTextFull_diplome = new rojeru_san.RSMTextFull();
        rSMPassView_mot_de_passe = new rojeru_san.RSMPassView();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestion Enseignant");
        setResizable(false);

        rSMTextFull_nom_prenom.setPlaceholder("Nom et Prénom");

        rSMTextFull_contact.setToolTipText("");
        rSMTextFull_contact.setPlaceholder("Tel.");

        btn_valider.setText("Enrégistrer");
        btn_valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_validerActionPerformed(evt);
            }
        });

        rSMTextFull_matricule.setEditable(false);
        rSMTextFull_matricule.setPlaceholder("");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Matricule");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Nom et Prénom");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Date de Naissance");

        rSMTextFull_lieu_de_naissance.setPlaceholder("");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Lieu de Naissance");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Nationalité");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Contact");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Sexe");

        rSComboMetro_sexe.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "M", "F" }));

        rSComboMetro_titre.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mr", "Mme", "Mlle", "Dr", "Pr" }));
        rSComboMetro_titre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSComboMetro_titreActionPerformed(evt);
            }
        });

        jLabel10.setText("Titre");

        rSMTextFull_diplome.setPlaceholder("Diplome");

        rSMPassView_mot_de_passe.setPlaceholder("Mot de passe");

        jLabel8.setText("Mot de passe");

        jLabel9.setText("Diplome");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_valider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(jLabel1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rSComboMetro_titre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(rSMTextFull_nom_prenom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rSMTextFull_matricule, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(jLabel3))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel5)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rSMTextFull_contact, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(rSbComboMetro_nationalite, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                                    .addComponent(jDateChooser_date_de_naissance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(rSComboMetro_sexe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(rSMTextFull_lieu_de_naissance, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)))
                            .addComponent(rSMTextFull_diplome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rSMPassView_mot_de_passe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(8, 8, 8))
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rSComboMetro_titre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rSMTextFull_matricule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rSMTextFull_nom_prenom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rSMTextFull_lieu_de_naissance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4))
                    .addComponent(jDateChooser_date_de_naissance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(rSbComboMetro_nationalite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(rSComboMetro_sexe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rSMTextFull_diplome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rSMTextFull_contact, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rSMPassView_mot_de_passe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addComponent(btn_valider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_validerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_validerActionPerformed
        if(rSMTextFull_nom_prenom.getText().length() == 0 || rSMTextFull_contact.getText().length() == 0 || rSbComboMetro_nationalite.getSelectedIndex() <0 || rSMTextFull_matricule.getText().length() == 0){
            JOptionPane.showMessageDialog(this, "Champ vide.", "Erreur de syntaxe !", JOptionPane.WARNING_MESSAGE);
        }else{
            if(professeur == null){
                java.sql.Date date = new Date(jDateChooser_date_de_naissance.getDate().getTime());
                professeurController.addProfesseur(rSMTextFull_matricule.getText(), rSMTextFull_nom_prenom.getText(), date, rSMTextFull_lieu_de_naissance.getText(), rSbComboMetro_nationalite.getSelectedItem().toString(), rSMTextFull_contact.getText(), rSComboMetro_titre.getSelectedItem().toString(), rSMTextFull_diplome.getText(), true, rSMPassView_mot_de_passe.getText(), rSComboMetro_sexe.getSelectedItem().toString());
            }else{
                java.sql.Date date = new Date(jDateChooser_date_de_naissance.getDate().getTime());
                professeurController.setProfesseur(professeur, new Professeur(rSMTextFull_matricule.getText(), rSMTextFull_nom_prenom.getText(), date, rSMTextFull_lieu_de_naissance.getText(), rSbComboMetro_nationalite.getSelectedItem().toString(), rSMTextFull_contact.getText(), rSComboMetro_titre.getSelectedItem().toString(), rSMTextFull_diplome.getText(), true, rSMPassView_mot_de_passe.getText(), rSComboMetro_sexe.getSelectedItem().toString()));
            }
            this.dispose();
        }
    }//GEN-LAST:event_btn_validerActionPerformed

    private void rSComboMetro_titreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSComboMetro_titreActionPerformed
        initSexe();
        initMatricule();
    }//GEN-LAST:event_rSComboMetro_titreActionPerformed

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
            java.util.logging.Logger.getLogger(ProfesseurDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
            ProfesseurDialog dialog = new ProfesseurDialog(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }
    private bean.Professeur professeur = null;
    private final NationaliteController nationaliteController;
    private final ProfesseurController professeurController;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.RSButton btn_valider;
    private com.toedter.calendar.JDateChooser jDateChooser_date_de_naissance;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private rojerusan.RSComboMetro rSComboMetro_sexe;
    private rojerusan.RSComboMetro rSComboMetro_titre;
    private rojeru_san.RSMPassView rSMPassView_mot_de_passe;
    private rojeru_san.RSMTextFull rSMTextFull_contact;
    private rojeru_san.RSMTextFull rSMTextFull_diplome;
    private rojeru_san.RSMTextFull rSMTextFull_lieu_de_naissance;
    private rojeru_san.RSMTextFull rSMTextFull_matricule;
    private rojeru_san.RSMTextFull rSMTextFull_nom_prenom;
    private rojerusan.RSComboMetro rSbComboMetro_nationalite;
    // End of variables declaration//GEN-END:variables

    private void initCbNationalite() {
        rSbComboMetro_nationalite.removeAllItems();
        nationaliteController.getListNationalite().forEach((n) -> {
            rSbComboMetro_nationalite.addItem(n.getNationalite());
        });
    }
    
    
    private void initMatricule(){
        int rang = professeurController.getProfesseurCount() + 1;
        String matricule = String.format("%03d", rang) + "/" + rSComboMetro_titre.getSelectedItem().toString().charAt(0);
        rSMTextFull_matricule.setText(matricule);
    }
    private void initSexe(){
        if("Mr".equals(rSComboMetro_titre.getSelectedItem().toString())){
                rSComboMetro_sexe.setSelectedItem("M");
        }else if("Mme".equals(rSComboMetro_titre.getSelectedItem().toString()) || "Mlle".equals(rSComboMetro_titre.getSelectedItem().toString())){
            rSComboMetro_sexe.setSelectedItem("F");
        }
    }
}

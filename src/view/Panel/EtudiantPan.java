/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.Panel;

import bean.Etudiant;
import controller.AnneeScolaireController;
import controller.EtudiantController;
import controller.FiliereController;
import controller.NationaliteController;
import controller.OptionsController;
import dialog.Detail;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import rojerusan.RSPanelImage;

/**
 *
 * @author ATH
 */
public class EtudiantPan extends RSPanelImage {

    /**
     * Creates new form ElevePan
     */
    public EtudiantPan() {
        etudiantController = new EtudiantController();
        nationaliteController = new NationaliteController();
        filiereController = new FiliereController();
        optionsController = new OptionsController();
        anneeScolaireController = new AnneeScolaireController();
        initComponents();
        initCbAnneeScolaire();
        try {
            rSComboMetro_annee.setSelectedItem(anneeScolaireController.getAnneeScolaireEnCours().getAnnee());
        } catch (Exception e) {
        }
        initCbFiliere();
        initCbOption();
        initCbNationalite();
        update_table();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popup_table = new javax.swing.JPopupMenu();
        menu_item_detail = new javax.swing.JMenuItem();
        menu_item_sms = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menu_item_add_etudiant = new javax.swing.JMenuItem();
        menu_item_update_etudiant = new javax.swing.JMenuItem();
        menu_item_remove_etudiant = new javax.swing.JMenuItem();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable_etudiant = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        rSMTextFull_recherche = new rojeru_san.RSMTextFull();
        rSComboMetro_nationalite = new rojerusan.RSComboMetro();
        rSComboMetro_sexe = new rojerusan.RSComboMetro();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        rSComboMetro_filiere = new rojerusan.RSComboMetro();
        rSComboMetro_option = new rojerusan.RSComboMetro();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        rSComboMetro_annee = new rojerusan.RSComboMetro();
        jLabel3 = new javax.swing.JLabel();

        menu_item_detail.setText("Voir détail");
        menu_item_detail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_detailActionPerformed(evt);
            }
        });
        popup_table.add(menu_item_detail);

        menu_item_sms.setText("Contacter");
        menu_item_sms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_smsActionPerformed(evt);
            }
        });
        popup_table.add(menu_item_sms);
        popup_table.add(jSeparator1);

        menu_item_add_etudiant.setText("Ajouter un étudiant");
        menu_item_add_etudiant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_add_etudiantActionPerformed(evt);
            }
        });
        popup_table.add(menu_item_add_etudiant);

        menu_item_update_etudiant.setText("Modifier l'étudiant");
        menu_item_update_etudiant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_update_etudiantActionPerformed(evt);
            }
        });
        popup_table.add(menu_item_update_etudiant);

        menu_item_remove_etudiant.setText("Retirer l'étudiant");
        menu_item_remove_etudiant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_item_remove_etudiantActionPerformed(evt);
            }
        });
        popup_table.add(menu_item_remove_etudiant);

        setImagen(new javax.swing.ImageIcon(getClass().getResource("/icon/getty_655998316_2000149920009280219_363765.jpg"))); // NOI18N
        setPreferredSize(new java.awt.Dimension(1100, 579));

        jScrollPane3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(51, 102, 255)), "Liste des étudiants", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        jScrollPane3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jScrollPane3MouseReleased(evt);
            }
        });

        jTable_etudiant.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°", "MATRICULE", "NOM ET PRENOM", "SEXE", "DATE DE NAISSANCE", "LIEU DE NAISSANCE", "NATIONALITE", "NUM. PARENT/TUTEUR", "ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_etudiant.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable_etudiantMouseReleased(evt);
            }
        });
        jScrollPane3.setViewportView(jTable_etudiant);
        if (jTable_etudiant.getColumnModel().getColumnCount() > 0) {
            jTable_etudiant.getColumnModel().getColumn(0).setMinWidth(50);
            jTable_etudiant.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTable_etudiant.getColumnModel().getColumn(0).setMaxWidth(50);
            jTable_etudiant.getColumnModel().getColumn(1).setMinWidth(125);
            jTable_etudiant.getColumnModel().getColumn(1).setPreferredWidth(125);
            jTable_etudiant.getColumnModel().getColumn(1).setMaxWidth(125);
            jTable_etudiant.getColumnModel().getColumn(3).setMinWidth(75);
            jTable_etudiant.getColumnModel().getColumn(3).setPreferredWidth(75);
            jTable_etudiant.getColumnModel().getColumn(3).setMaxWidth(75);
            jTable_etudiant.getColumnModel().getColumn(4).setMinWidth(150);
            jTable_etudiant.getColumnModel().getColumn(4).setPreferredWidth(150);
            jTable_etudiant.getColumnModel().getColumn(4).setMaxWidth(150);
            jTable_etudiant.getColumnModel().getColumn(5).setMinWidth(160);
            jTable_etudiant.getColumnModel().getColumn(5).setPreferredWidth(160);
            jTable_etudiant.getColumnModel().getColumn(5).setMaxWidth(160);
            jTable_etudiant.getColumnModel().getColumn(6).setMinWidth(150);
            jTable_etudiant.getColumnModel().getColumn(6).setPreferredWidth(150);
            jTable_etudiant.getColumnModel().getColumn(6).setMaxWidth(150);
            jTable_etudiant.getColumnModel().getColumn(7).setMinWidth(150);
            jTable_etudiant.getColumnModel().getColumn(7).setPreferredWidth(150);
            jTable_etudiant.getColumnModel().getColumn(7).setMaxWidth(150);
            jTable_etudiant.getColumnModel().getColumn(8).setMinWidth(10);
            jTable_etudiant.getColumnModel().getColumn(8).setPreferredWidth(10);
            jTable_etudiant.getColumnModel().getColumn(8).setMaxWidth(10);
        }

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), "Filtrage liste élèves", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        rSMTextFull_recherche.setPlaceholder("Rechercher");
        rSMTextFull_recherche.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                rSMTextFull_rechercheKeyReleased(evt);
            }
        });

        rSComboMetro_nationalite.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "NATIONALITE" }));
        rSComboMetro_nationalite.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rSComboMetro_nationalite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSComboMetro_nationaliteActionPerformed(evt);
            }
        });

        rSComboMetro_sexe.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tous", "M", "F" }));
        rSComboMetro_sexe.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rSComboMetro_sexe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSComboMetro_sexeActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Sexe");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Nationalité");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(rSMTextFull_recherche, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rSComboMetro_nationalite, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rSComboMetro_sexe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(rSMTextFull_recherche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(rSComboMetro_nationalite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rSComboMetro_sexe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        rSComboMetro_filiere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSComboMetro_filiereActionPerformed(evt);
            }
        });

        rSComboMetro_option.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSComboMetro_optionActionPerformed(evt);
            }
        });

        jLabel4.setText("Filière");

        jLabel5.setText("Option");

        rSComboMetro_annee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSComboMetro_anneeActionPerformed(evt);
            }
        });

        jLabel3.setText("Année");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rSComboMetro_filiere, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                    .addComponent(rSComboMetro_option, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rSComboMetro_annee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(64, 64, 64))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rSComboMetro_annee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rSComboMetro_filiere, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rSComboMetro_option, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1088, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void menu_item_detailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_detailActionPerformed
        // TODO add your handling code here:
        int row = jTable_etudiant.getSelectedRow();
        String matricule = jTable_etudiant.getValueAt(row, 8).toString();
        Detail detail = new Detail(null, true, etudiantController.getEtudiant(matricule));
        detail.setVisible(true);
    }//GEN-LAST:event_menu_item_detailActionPerformed

    private void menu_item_smsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_smsActionPerformed
        int row = jTable_etudiant.getSelectedRow();
        String matricule = jTable_etudiant.getValueAt(row, 1).toString();
        if(row < 0){
            dialog.ContacterDialog contacter = new dialog.ContacterDialog(null, true);
            contacter.setVisible(true);
        }else{
            dialog.ContacterDialog contacter = new dialog.ContacterDialog(null, true, etudiantController.getEtudiant(matricule));
            contacter.setVisible(true);
        }
    }//GEN-LAST:event_menu_item_smsActionPerformed

    private void menu_item_add_etudiantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_add_etudiantActionPerformed
        dialog.EtudiantDialog etudiant = new dialog.EtudiantDialog(null, true);
        etudiant.setVisible(true);
        update_table();
    }//GEN-LAST:event_menu_item_add_etudiantActionPerformed

    private void menu_item_update_etudiantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_update_etudiantActionPerformed
        int row = jTable_etudiant.getSelectedRow();
        String matricule = jTable_etudiant.getValueAt(row, 8).toString();
        dialog.EtudiantDialog etudiant = new dialog.EtudiantDialog(null, true,matricule);
        etudiant.setVisible(true);
        update_table();
    }//GEN-LAST:event_menu_item_update_etudiantActionPerformed

    private void menu_item_remove_etudiantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_item_remove_etudiantActionPerformed
        int choice = JOptionPane.showConfirmDialog(this, "Etes vous sure de vouloir suprimer l'étudiant " + jTable_etudiant.getValueAt(jTable_etudiant.getSelectedRow(), 2) + " ?", "Action irréversible", JOptionPane.YES_NO_OPTION);
        if(choice == 0){
            etudiantController.removeEtudiant(jTable_etudiant.getValueAt(jTable_etudiant.getSelectedRow(), 8).toString());
        }
        update_table();
    }//GEN-LAST:event_menu_item_remove_etudiantActionPerformed

    private void jScrollPane3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane3MouseReleased
        int r = jTable_etudiant.rowAtPoint(evt.getPoint());
        if(r >=0 && r < jTable_etudiant.getRowCount()){
            jTable_etudiant.setRowSelectionInterval(r, r);

        }else{
            jTable_etudiant.clearSelection();
        }
        int index = jTable_etudiant.getSelectedRow();
        if(index < 0){
            //menu_item_sms.setEnabled(false);
            menu_item_detail.setEnabled(false);
            menu_item_remove_etudiant.setEnabled(false);
            menu_item_update_etudiant.setEnabled(false);
        }else{
            //menu_item_sms.setEnabled(true);
            menu_item_detail.setEnabled(true);
            menu_item_add_etudiant.setEnabled(true);
            menu_item_remove_etudiant.setEnabled(true);
            menu_item_update_etudiant.setEnabled(true);
        }
        if(evt.isPopupTrigger() && evt.getComponent() instanceof JScrollPane){
            popup_table.show(evt.getComponent(), evt.getX(), evt.getY());
            popup_table.setVisible(true);
        }
    }//GEN-LAST:event_jScrollPane3MouseReleased

    private void jTable_etudiantMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_etudiantMouseReleased
        int r = jTable_etudiant.rowAtPoint(evt.getPoint());
        if(r >=0 && r < jTable_etudiant.getRowCount()){
            jTable_etudiant.setRowSelectionInterval(r, r);

        }else{
            jTable_etudiant.clearSelection();
        }
        int index = jTable_etudiant.getSelectedRow();
        if(index < 0){
            //menu_item_sms.setEnabled(false);
            menu_item_detail.setEnabled(false);
            menu_item_remove_etudiant.setEnabled(false);
            menu_item_update_etudiant.setEnabled(false);
        }else{
            //menu_item_sms.setEnabled(true);
            menu_item_detail.setEnabled(true);
            menu_item_add_etudiant.setEnabled(true);
            menu_item_remove_etudiant.setEnabled(true);
            menu_item_update_etudiant.setEnabled(true);
        }
        if(evt.isPopupTrigger() && evt.getComponent() instanceof JTable){
            popup_table.show(evt.getComponent(), evt.getX(), evt.getY());
            popup_table.setVisible(true);
        }
    }//GEN-LAST:event_jTable_etudiantMouseReleased

    private void rSComboMetro_nationaliteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSComboMetro_nationaliteActionPerformed
        update_table();
    }//GEN-LAST:event_rSComboMetro_nationaliteActionPerformed

    private void rSComboMetro_sexeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSComboMetro_sexeActionPerformed
        update_table();
    }//GEN-LAST:event_rSComboMetro_sexeActionPerformed

    private void rSMTextFull_rechercheKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rSMTextFull_rechercheKeyReleased
        update_table();
    }//GEN-LAST:event_rSMTextFull_rechercheKeyReleased

    private void rSComboMetro_filiereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSComboMetro_filiereActionPerformed
        initCbOption();
        update_table();
    }//GEN-LAST:event_rSComboMetro_filiereActionPerformed

    private void rSComboMetro_optionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSComboMetro_optionActionPerformed
        update_table();
    }//GEN-LAST:event_rSComboMetro_optionActionPerformed

    private void rSComboMetro_anneeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSComboMetro_anneeActionPerformed
        update_table();
    }//GEN-LAST:event_rSComboMetro_anneeActionPerformed

    private final EtudiantController etudiantController;
    private final NationaliteController nationaliteController;
    private final FiliereController filiereController;
    private final OptionsController optionsController;
    private final AnneeScolaireController anneeScolaireController;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTable jTable_etudiant;
    private javax.swing.JMenuItem menu_item_add_etudiant;
    private javax.swing.JMenuItem menu_item_detail;
    private javax.swing.JMenuItem menu_item_remove_etudiant;
    private javax.swing.JMenuItem menu_item_sms;
    private javax.swing.JMenuItem menu_item_update_etudiant;
    private javax.swing.JPopupMenu popup_table;
    private rojerusan.RSComboMetro rSComboMetro_annee;
    private rojerusan.RSComboMetro rSComboMetro_filiere;
    private rojerusan.RSComboMetro rSComboMetro_nationalite;
    private rojerusan.RSComboMetro rSComboMetro_option;
    private rojerusan.RSComboMetro rSComboMetro_sexe;
    private rojeru_san.RSMTextFull rSMTextFull_recherche;
    // End of variables declaration//GEN-END:variables

    private void initCbNationalite() {
        rSComboMetro_nationalite.removeAllItems();
        int size = nationaliteController.getListNationalite().size();
        if(size > 1){
            rSComboMetro_nationalite.addItem("Toutes");
            nationaliteController.getListNationalite().forEach((n) -> {
                rSComboMetro_nationalite.addItem(n.getNationalite());
            });
        }else if(size > 0){
            nationaliteController.getListNationalite().forEach((n) -> {
                rSComboMetro_nationalite.addItem(n.getNationalite());
            });
        }
    }

    private void initCbFiliere(){
        rSComboMetro_filiere.removeAllItems();
        filiereController.getListFiliere().forEach((f) -> {
            rSComboMetro_filiere.addItem(f.getFiliere());
        });
        if(rSComboMetro_filiere.getItemCount() > 1){
            rSComboMetro_filiere.addItem("Toutes");
        }
        
    }
    private void success_information() {
        JOptionPane.showMessageDialog(this, "Opération effectuée avec succes ", "Réussie !", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void update_table(){
        String entete[] = {"N°", "MATRICULE", "NOM ET PRENOM", "SEXE", "DATE DE NAISSANCE", "LIEU DE NAISSANCE", "NATIONALITE", "NUM. PARENT/TUTEUR", "ID"};
        DefaultTableModel dt=new DefaultTableModel(null,entete);
        dt.setRowCount(0);
        
        String annee = null, rechercher = null, nationalite = null, sexe = null, option = null, filiere = null;
        if(rSComboMetro_annee.getSelectedIndex() > -1){
            annee = rSComboMetro_annee.getSelectedItem().toString();
        }
        if(rSMTextFull_recherche.getText().length() > 0){
            rechercher = rSMTextFull_recherche.getText();
        }
        if(rSComboMetro_nationalite.getSelectedIndex() > -1){
            nationalite = rSComboMetro_nationalite.getSelectedItem().toString();
        }
        if(rSComboMetro_sexe.getSelectedIndex() > -1){
            sexe = rSComboMetro_sexe.getSelectedItem().toString();
        }
        if(rSComboMetro_option.getSelectedIndex() > -1){
            option = rSComboMetro_option.getSelectedItem().toString();
        }
        if(rSComboMetro_filiere.getSelectedIndex() > -1){
            filiere = rSComboMetro_filiere.getSelectedItem().toString();
        }
        ArrayList<Etudiant> list_etudiant = etudiantController.getListEtudiant(rechercher, nationalite, sexe, option, filiere, annee);
        
        for(int i = 0; i< list_etudiant.size(); i++){
            Object colonne[] = new Object[9];
            colonne[0] = i + 1;
            colonne[1] = list_etudiant.get(i).getMatricule();
            colonne[2] = list_etudiant.get(i).getNom_prenom();
            colonne[3] = list_etudiant.get(i).getSexe();
            colonne[4] = list_etudiant.get(i).getDate_de_naissance();
            colonne[5] = list_etudiant.get(i).getLieu_de_naissance();
            colonne[6] = list_etudiant.get(i).getNationalite();
            colonne[7] = list_etudiant.get(i).getContact();
            colonne[8] = list_etudiant.get(i).getMatricule();
            dt.addRow(colonne);
        }
        
        this.jTable_etudiant.setModel(dt);
        if (jTable_etudiant.getColumnModel().getColumnCount() > 0) {
            jTable_etudiant.getColumnModel().getColumn(0).setMinWidth(50);
            jTable_etudiant.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTable_etudiant.getColumnModel().getColumn(0).setMaxWidth(50);
            jTable_etudiant.getColumnModel().getColumn(1).setMinWidth(125);
            jTable_etudiant.getColumnModel().getColumn(1).setPreferredWidth(125);
            jTable_etudiant.getColumnModel().getColumn(1).setMaxWidth(125);
            jTable_etudiant.getColumnModel().getColumn(3).setMinWidth(75);
            jTable_etudiant.getColumnModel().getColumn(3).setPreferredWidth(75);
            jTable_etudiant.getColumnModel().getColumn(3).setMaxWidth(75);
            jTable_etudiant.getColumnModel().getColumn(4).setMinWidth(150);
            jTable_etudiant.getColumnModel().getColumn(4).setPreferredWidth(150);
            jTable_etudiant.getColumnModel().getColumn(4).setMaxWidth(150);
            jTable_etudiant.getColumnModel().getColumn(5).setMinWidth(160);
            jTable_etudiant.getColumnModel().getColumn(5).setPreferredWidth(160);
            jTable_etudiant.getColumnModel().getColumn(5).setMaxWidth(160);
            jTable_etudiant.getColumnModel().getColumn(6).setMinWidth(150);
            jTable_etudiant.getColumnModel().getColumn(6).setPreferredWidth(150);
            jTable_etudiant.getColumnModel().getColumn(6).setMaxWidth(150);
            jTable_etudiant.getColumnModel().getColumn(7).setMinWidth(150);
            jTable_etudiant.getColumnModel().getColumn(7).setPreferredWidth(150);
            jTable_etudiant.getColumnModel().getColumn(7).setMaxWidth(150);
            jTable_etudiant.getColumnModel().getColumn(8).setMinWidth(10);
            jTable_etudiant.getColumnModel().getColumn(8).setPreferredWidth(10);
            jTable_etudiant.getColumnModel().getColumn(8).setMaxWidth(10);
            jTable_etudiant.setRowHeight(30);
        }
    }

    private void initCbOption() {
        rSComboMetro_option.removeAllItems();
        String filiere = null;
        if(rSComboMetro_filiere.getSelectedIndex() > -1){
            filiere = rSComboMetro_filiere.getSelectedItem().toString();
        }
        optionsController.getListOptions(filiere).forEach((o) -> {
            rSComboMetro_option.addItem(o.getOptions());
        });
        if(rSComboMetro_option.getItemCount() > 1){
            rSComboMetro_option.addItem("Toutes");
        }
    }
    private void initCbAnneeScolaire() {
        rSComboMetro_annee.removeAllItems();
        anneeScolaireController.getListAnneeScolaire().forEach((a) -> {
            rSComboMetro_annee.addItem(a.getAnnee());
        });
    }
}

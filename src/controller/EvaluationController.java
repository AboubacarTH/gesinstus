/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Note;
import form.MainForm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ATH
 */
public class EvaluationController {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    public EvaluationController(){
        this.connection = MainForm.getConnection();
    }
    
    public ArrayList<Note> getColonnes(String annee, String niveau, String semestre, String filiere, String option, String id_ue, String id_ec, String rechercher){
        ArrayList <Note> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM etudiant JOIN ue ON "
                    + "etudiant.filiere = ue.filiere AND etudiant.options = ue.options JOIN ec ON "
                    + "ue.id_ue = ec.id_ue WHERE etudiant.etat = ? ";
            if(annee != null && !"Toutes".equals(annee)){
                req += "AND annee = '"+ annee +"' ";
            }
            if(niveau != null && !"Tous".equals(niveau)){
                req += "AND ue.niveau = '"+ niveau +"' ";
            }
            if(semestre != null && !"Toutes".equals(semestre)){
                req += "AND ue.semestre = '"+ semestre +"' ";
            }
            if(filiere != null && !"Toutes".equals(filiere)){
                req += "AND ue.filiere = '"+ filiere +"' ";
            }
            if(option != null && !"Toutes".equals(option)){
                req += "AND ue.options = '"+ option +"' ";
            }
            if(id_ue != null && !"Toutes".equals(id_ue)){
                req += "AND ue.id_ue = '"+ id_ue +"' ";
            }
            if(id_ec != null && !"Tous".equals(id_ec)){
                req += "AND ec.id_ec = '"+ id_ec +"' ";
            }
            if(rechercher != null){
                req += "AND nom_prenom LIKE '%"+ rechercher +"%' ";
            }
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setBoolean(1, true);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while(resultSet.next()){
                list.add(new Note(resultSet.getString("id_ue"),resultSet.getString("id_ec"), resultSet.getString("matricule"), resultSet.getString("annee"), resultSet.getString("nom_prenom"), resultSet.getString("filiere"), resultSet.getString("semestre")));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(EvaluationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public double getNote(String annee, String matricule, String id_ec, String type_evaluation){
        String type = "note";
        if("SESSION".equals(type_evaluation)){
            type = "session";
        }
        try {
            String req = "SELECT "+ type +" FROM evaluation WHERE id_ec = ? AND matricule = ? AND annee = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, id_ec);
            preparedStatement.setString(2, matricule);
            preparedStatement.setString(3, annee);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return resultSet.getDouble(type);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EvaluationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0.00;
    }
    public void setNote(String annee, String matricule, String id_ec, String type_evaluation, double note){
        String type = "note";
        if("SESSION".equals(type_evaluation)){
            type = "session";
        }
        try {
            String req = "SELECT "+ type +" FROM evaluation WHERE id_ec = ? AND matricule = ? AND annee = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, id_ec);
            preparedStatement.setString(2, matricule);
            preparedStatement.setString(3, annee);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                req = "UPDATE evaluation SET "+ type +" = ? WHERE id_ec = ? AND matricule = ? AND annee = ?";
                preparedStatement = connection.prepareStatement(req);
                preparedStatement.setDouble(1, note);
                preparedStatement.setString(2, id_ec);
                preparedStatement.setString(3, matricule);
                preparedStatement.setString(4, annee);
                preparedStatement.executeUpdate();
            }else{
                req = "INSERT INTO evaluation (id_ec,matricule,annee,"+ type +") VALUES (?,?,?,?)";
                preparedStatement = connection.prepareStatement(req);
                preparedStatement.setString(1, id_ec);
                preparedStatement.setString(2, matricule);
                preparedStatement.setString(3, annee);
                preparedStatement.setDouble(4, note);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(EvaluationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void success_information() {
        JOptionPane.showMessageDialog(null, "Opération effectuée avec succes ", "Réussie !", JOptionPane.INFORMATION_MESSAGE);
    }
    private void error_information(){
        JOptionPane.showMessageDialog(null, "Opération echouée ", "Echec !", JOptionPane.WARNING_MESSAGE);
    }
}

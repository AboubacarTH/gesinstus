/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Options;
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
public class OptionsController {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    
    public OptionsController() {
        this.connection = MainForm.getConnection();
    }
    //c
    public void addOption(Options option){
        try {
            String req = "INSERT INTO options (options,filiere,motif_matricule) VALUES (?,?,?)";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, option.getOptions());
            preparedStatement.setString(2, option.getFiliere());
            preparedStatement.setString(3, option.getMotif_matricule());
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            Logger.getLogger(OptionsController.class.getName()).log(Level.SEVERE, null, ex);
            error_information();
        }
    }
    public void addOption(String option, String filiere, String motif){
        try {
            String req = "INSERT INTO options (options,filiere,motif_matricule) VALUES (?,?,?)";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, option);
            preparedStatement.setString(2, filiere);
            preparedStatement.setString(3, motif);
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            Logger.getLogger(OptionsController.class.getName()).log(Level.SEVERE, null, ex);
            error_information();
        }
    }
    //r
    public Options getOption(Options option){
        try {
            String req = "SELECT * FROM options WHERE options = ? AND filiere = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, option.getOptions());
            preparedStatement.setString(2, option.getFiliere());
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return new Options(resultSet.getString("options"), resultSet.getString("filiere"), resultSet.getString("motif_matricule"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(OptionsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public int getOptionEtudiantCount(Options option){
        try {
            String req = "SELECT COUNT(matricule) AS effectif FROM etudiant WHERE options = ? AND filiere = ? AND etat = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, option.getOptions());
            preparedStatement.setString(2, option.getFiliere());
            preparedStatement.setBoolean(3, true);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return resultSet.getInt("effectif");
            }
        } catch (SQLException ex) {
            Logger.getLogger(OptionsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public int getOptionEtudiantCount(String option, String filiere){
        try {
            String req = "SELECT COUNT(matricule) AS effectif FROM etudiant WHERE options = ? AND filiere = ? AND etat = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, option);
            preparedStatement.setString(2, filiere);
            preparedStatement.setBoolean(3, true);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return resultSet.getInt("effectif");
            }
        } catch (SQLException ex) {
            Logger.getLogger(OptionsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public Options getOption(String option, String filiere){
        try {
            String req = "SELECT * FROM options WHERE options = ? AND filiere = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, option);
            preparedStatement.setString(2, filiere);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return new Options(resultSet.getString("options"), resultSet.getString("filiere"), resultSet.getString("motif_matricule"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(OptionsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ArrayList<Options> getListOptions(String filiere){
        ArrayList<Options> listOptions = new ArrayList<>();
        try {
            String req = "SELECT * FROM options ";
            if(filiere != null && !filiere.equals("Toutes")){
                req += "WHERE filiere = '" + filiere + "' ";
            }
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while(resultSet.next()){
                listOptions.add(new Options(resultSet.getString("options"), resultSet.getString("filiere"), resultSet.getString("motif_matricule")));
            }
            return listOptions;
        } catch (SQLException ex) {
            Logger.getLogger(OptionsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    //u
    public void setOption(Options oldValue,Options newValue){
        try {
            String req = "UPDATE options SET options = ?,filiere = ?, motif_matricule = ? WHERE options = ? AND filiere = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, newValue.getOptions());
            preparedStatement.setString(2, newValue.getFiliere());
            preparedStatement.setString(3, newValue.getMotif_matricule());
            preparedStatement.setString(4, oldValue.getOptions());
            preparedStatement.setString(5, oldValue.getFiliere());
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            Logger.getLogger(OptionsController.class.getName()).log(Level.SEVERE, null, ex);
            error_information();
        }
    }
    public void setOption(String newOption, String newFiliere, String newMotif, String oldOption,String oldFiliere){
        try {
            String req = "UPDATE options SET options = ?,filiere = ?, motif_matricule = ? WHERE options = ? AND filiere = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, newOption);
            preparedStatement.setString(2, newFiliere);
            preparedStatement.setString(3, newMotif);
            preparedStatement.setString(4, oldOption);
            preparedStatement.setString(5, oldFiliere);
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            Logger.getLogger(OptionsController.class.getName()).log(Level.SEVERE, null, ex);
            error_information();
        }
    }
    //d
    public void removeOption(Options options){
        try {
            String req = "DELETE FROM options WHERE options = ? AND filiere = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, options.getOptions());
            preparedStatement.setString(2, options.getFiliere());
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            Logger.getLogger(OptionsController.class.getName()).log(Level.SEVERE, null, ex);
            error_information();
        }
    }
    public void removeOption(String option, String filiere){
        try {
            String req = "DELETE FROM options WHERE options = ? AND filiere = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, option);
            preparedStatement.setString(2, filiere);
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            Logger.getLogger(OptionsController.class.getName()).log(Level.SEVERE, null, ex);
            error_information();
        }
    }
    private void success_information() {
        JOptionPane.showMessageDialog(null, "Opération effectuée avec succes ", "Réussie !", JOptionPane.INFORMATION_MESSAGE);
    }
    private void error_information(){
        JOptionPane.showMessageDialog(null, "Opération echouée ", "Echec !", JOptionPane.WARNING_MESSAGE);
    }
}

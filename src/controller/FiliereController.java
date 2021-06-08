/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Filiere;
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
public class FiliereController {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    public FiliereController(){
        this.connection = MainForm.getConnection();
    }
    //C
    public void addFiliere(Filiere filiere){
        try {
            String req = "INSERT INTO filiere (filiere) VALUES (?)";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, filiere.getFiliere());
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            Logger.getLogger(FiliereController.class.getName()).log(Level.SEVERE, null, ex);
            error_information();
        }
    }
    public void addFiliere(String filiere){
        try {
            String req = "INSERT INTO filiere (filiere) VALUES (?)";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, filiere);
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            Logger.getLogger(FiliereController.class.getName()).log(Level.SEVERE, null, ex);
            error_information();
        }
    }
    //R
    public Filiere getFiliere(Filiere filiere){
        try {
            String req = "SELECT filiere FROM filiere WHERE filiere = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, filiere.getFiliere());
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return new Filiere(resultSet.getString("filiere"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FiliereController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public Filiere getFiliere(String filiere){
        try {
            String req = "SELECT filiere FROM filiere WHERE filiere = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, filiere);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return new Filiere(resultSet.getString("filiere"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FiliereController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public int getFiliereEtudiantCount(String filiere){
        try {
            String req = "SELECT COUNT(matricule) AS effectif FROM etudiant WHERE filiere = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, filiere);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return resultSet.getInt("effectif");
            }
        } catch (SQLException ex) {
            Logger.getLogger(FiliereController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public int getFiliereEtudiantCount(Filiere filiere, boolean etat){
        try {
            String req = "SELECT COUNT(matricule) AS effectif FROM etudiant WHERE filiere = ? AND etat = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, filiere.getFiliere());
            preparedStatement.setBoolean(2, etat);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return resultSet.getInt("effectif");
            }
        } catch (SQLException ex) {
            Logger.getLogger(FiliereController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public int getFiliereEtudiantCount(String filiere, boolean etat){
        try {
            String req = "SELECT COUNT(matricule) AS effectif FROM etudiant WHERE filiere = ? AND etat = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, filiere);
            preparedStatement.setBoolean(2, etat);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return resultSet.getInt("effectif");
            }
        } catch (SQLException ex) {
            Logger.getLogger(FiliereController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public ArrayList<Filiere> getListFiliere(){
        ArrayList<Filiere> listFiliere = new ArrayList<>();
        try {
            String req = "SELECT filiere FROM filiere";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while(resultSet.next()){
                listFiliere.add(new Filiere(resultSet.getString("filiere")));
            }
            return listFiliere;
        } catch (SQLException ex) {
            Logger.getLogger(FiliereController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    //U
    public void setFiliere(Filiere oldValue,Filiere newValue){
        try {
            String req = "UPDATE filiere SET filiere = ? WHERE filiere = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, newValue.getFiliere());
            preparedStatement.setString(2, oldValue.getFiliere());
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            error_information();
            Logger.getLogger(FiliereController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setFiliere(String oldValue,String newValue){
        try {
            String req = "UPDATE filiere SET filiere = ? WHERE filiere = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, newValue);
            preparedStatement.setString(2, oldValue);
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            error_information();
            Logger.getLogger(FiliereController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //D
    public void removeFiliere(Filiere filiere){
        try {
            String req = "DELETE FROM filiere WHERE filiere = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, filiere.getFiliere());
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            error_information();
            Logger.getLogger(FiliereController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void removeFiliere(String filiere){
        try {
            String req = "DELETE FROM filiere WHERE filiere = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, filiere);
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            error_information();
            Logger.getLogger(FiliereController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void success_information() {
        JOptionPane.showMessageDialog(null, "Opération effectuée avec succes ", "Réussie !", JOptionPane.INFORMATION_MESSAGE);
    }
    private void error_information(){
        JOptionPane.showMessageDialog(null, "Opération echouée ", "Echec !", JOptionPane.WARNING_MESSAGE);
    }
}

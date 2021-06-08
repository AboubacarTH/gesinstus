/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Niveau;
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
public class NiveauController {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    
    public NiveauController() {
        this.connection = MainForm.getConnection();
    }
    //C
    public void addNiveau(Niveau niveau){
        try {
            String req = "INSERT INTO niveau (niveau,priorite) VALUES (?,?)";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, niveau.getNiveau());
            preparedStatement.setInt(2, niveau.getPriorite());            
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            Logger.getLogger(NiveauController.class.getName()).log(Level.SEVERE, null, ex);
            error_information();
        }
    }
    public void addNiveau(String niveau, int priorite){
        try {
            String req = "INSERT INTO niveau (niveau,priorite) VALUES (?,?)";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, niveau);
            preparedStatement.setInt(2, priorite);            
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            Logger.getLogger(NiveauController.class.getName()).log(Level.SEVERE, null, ex);
            error_information();
        }
    }
    //R
    public Niveau getNiveau(Niveau niveau){
        try {
            String req = "SELECT * FROM niveau WHERE niveau = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, niveau.getNiveau());
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return new Niveau(resultSet.getString("niveau"), resultSet.getInt("priorite"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NiveauController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public Niveau getNiveau(String niveau){
        try {
            String req = "SELECT * FROM niveau WHERE niveau = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, niveau);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return new Niveau(resultSet.getString("niveau"), resultSet.getInt("priorite"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NiveauController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<Niveau> getListNiveau(){
        ArrayList<Niveau> listNiveau = new ArrayList<>();
        try {
            String req = "SELECT * FROM niveau ORDER BY priorite ASC";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while(resultSet.next()){
                listNiveau.add(new Niveau(resultSet.getString("niveau"), resultSet.getInt("priorite")));
            }
            return listNiveau;
        } catch (SQLException ex) {
            Logger.getLogger(NiveauController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    //U
    public void setNiveau(Niveau oldValue, Niveau newValue){
        try {
            String req = "UPDATE niveau SET niveau = ?,priorite = ? WHERE niveau = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, newValue.getNiveau());
            preparedStatement.setInt(2, newValue.getPriorite());
            preparedStatement.setString(3, oldValue.getNiveau());
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            error_information();
            Logger.getLogger(NiveauController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setNiveau(String newNiveau, int newPriorite, String oldNiveau){
        try {
            String req = "UPDATE niveau SET niveau = ?,priorite = ? WHERE niveau = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, newNiveau);
            preparedStatement.setInt(2, newPriorite);
            preparedStatement.setString(3, oldNiveau);
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            error_information();
            Logger.getLogger(NiveauController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //D
    public void removeNiveau(Niveau niveau){
        try {
            String req = "DELETE FROM niveau WHERE niveau = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, niveau.getNiveau());
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            error_information();
            Logger.getLogger(NiveauController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void removeNiveau(String niveau){
        try {
            String req = "DELETE FROM niveau WHERE niveau = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, niveau);
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            error_information();
            Logger.getLogger(NiveauController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void success_information() {
        JOptionPane.showMessageDialog(null, "Opération effectuée avec succes ", "Réussie !", JOptionPane.INFORMATION_MESSAGE);
    }
    private void error_information(){
        JOptionPane.showMessageDialog(null, "Opération echouée ", "Echec !", JOptionPane.WARNING_MESSAGE);
    }
}

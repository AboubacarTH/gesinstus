/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Semestre;
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
public class SemestreController {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    public SemestreController(Connection connection) {
        this.connection = connection;
    }
    public SemestreController() {
        this.connection = MainForm.getConnection();
    }
    //C
    public void addSemestre(Semestre semestre){
        try {
            String req = "INSERT INTO semestre (semestre,niveau,priorite) VALUES (?,?,?)";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, semestre.getSemestre());
            preparedStatement.setString(2, semestre.getNiveau());
            preparedStatement.setInt(3, semestre.getPriorite());
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            Logger.getLogger(SemestreController.class.getName()).log(Level.SEVERE, null, ex);
            error_information();
        }
    }
    public void addSemestre(String semestre, String niveau, int priorite){
        try {
            String req = "INSERT INTO semestre (semestre,niveau,priorite) VALUES (?,?,?)";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, semestre);
            preparedStatement.setString(2, niveau);
            preparedStatement.setInt(3, priorite);
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            Logger.getLogger(SemestreController.class.getName()).log(Level.SEVERE, null, ex);
            error_information();
        }
    }
    //R
    public Semestre getSemestre(String semestre, String niveau){
        try {
            String req = "SELECT * FROM semestre WHERE semestre = ? AND niveau = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, semestre);
            preparedStatement.setString(2, niveau);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return new Semestre(resultSet.getString("semestre"), resultSet.getString("niveau"), resultSet.getInt("priorite"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SemestreController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public Semestre getSemestre(Semestre semestre){
        try {
            String req = "SELECT * FROM semestre WHERE semestre = ? AND niveau = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, semestre.getSemestre());
            preparedStatement.setString(2, semestre.getNiveau());
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return new Semestre(resultSet.getString("semestre"), resultSet.getString("niveau"), resultSet.getInt("priorite"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SemestreController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<Semestre> getListSemestre(String niveau){
        ArrayList<Semestre> listSemestre = new ArrayList<>();
        try {
            String req = "SELECT * FROM semestre ";
            if(!niveau.equals(null) && !niveau.equals("Tous")){
                req += "WHERE niveau = '" + niveau + "' ";
            }
            req += "ORDER BY priorite ASC";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while(resultSet.next()){
                listSemestre.add(new Semestre(resultSet.getString("semestre"), resultSet.getString("niveau"), resultSet.getInt("priorite")));
            }
            return listSemestre;
        } catch (SQLException ex) {
            Logger.getLogger(SemestreController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    //U
    public void setSemestre(Semestre oldValue,Semestre newValue){
        try {
            String req = "UPDATE semestre SET semestre = ?, niveau = ?, priorite = ? WHERE semestre = ? AND niveau = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, newValue.getSemestre());
            preparedStatement.setString(2, newValue.getNiveau());
            preparedStatement.setInt(3, newValue.getPriorite());
            preparedStatement.setString(4, oldValue.getSemestre());
            preparedStatement.setString(5, oldValue.getNiveau());
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            error_information();
            Logger.getLogger(SemestreController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setSemestre(String newSemestre, String newNiveau, int newPriorite, String oldSemestre,String oldNiveau){
        try {
            String req = "UPDATE semestre SET semestre = ?, niveau = ?, priorite = ? WHERE semestre = ? AND niveau = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, newSemestre);
            preparedStatement.setString(2, newNiveau);
            preparedStatement.setInt(3, newPriorite);
            preparedStatement.setString(4, oldSemestre);
            preparedStatement.setString(5, oldNiveau);
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            error_information();
            Logger.getLogger(SemestreController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //D
    public void removeSemestre(Semestre semestre){
        try {
            String req = "DELETE FROM semestre WHERE semestre = ? AND niveau = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, semestre.getSemestre());
            preparedStatement.setString(2, semestre.getNiveau());
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            error_information();
            Logger.getLogger(SemestreController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void removeSemestre(String semestre, String niveau){
        try {
            String req = "DELETE FROM semestre WHERE semestre = ? AND niveau = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, semestre);
            preparedStatement.setString(2, niveau);
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            error_information();
            Logger.getLogger(SemestreController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void success_information() {
        JOptionPane.showMessageDialog(null, "Opération effectuée avec succes ", "Réussie !", JOptionPane.INFORMATION_MESSAGE);
    }
    private void error_information(){
        JOptionPane.showMessageDialog(null, "Opération echouée ", "Echec !", JOptionPane.WARNING_MESSAGE);
    }
}

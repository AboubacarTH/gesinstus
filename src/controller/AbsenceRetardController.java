/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.AbsenceRetard;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.Main;

/**
 *
 * @author ATH
 */
public class AbsenceRetardController {
    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    
    public AbsenceRetardController(Connection connection) {
        this.connection = connection;
    }
    public AbsenceRetardController() {
        connection = Main.getConnection();
    }
    
    //C
    public void addAbsenceRetard(int id_etudiant, String absence_retard,Date date, String commentaire){
        try {
            String req = "INSERT INTO absence_retard (id_etudiant,absence_retard,date,commentaire,) VALUES (?,?,?,?)";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id_etudiant);
            preparedStatement.setString(2, absence_retard);
            preparedStatement.setDate(3, date);
            preparedStatement.setString(4, commentaire);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AbsenceRetardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //R
    public AbsenceRetard getAbsenceRetard(int id_absence_retard){
        try {
            String req = "SELECT * FROM absence_retard WHERE id_absence_retard = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id_absence_retard);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return new AbsenceRetard(resultSet.getInt("id_absence_retard"), resultSet.getInt("id_etudiant"), resultSet.getString("absence_retard"), resultSet.getDate("date"), resultSet.getString("commentaire"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AbsenceRetardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<AbsenceRetard> getListAbsenceRetard(){
        ArrayList<AbsenceRetard> listAbsenceRetard = new ArrayList<>();
        try {
            String req = "SELECT * FROM absence_retard ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while(resultSet.next()){
                listAbsenceRetard.add(new AbsenceRetard(resultSet.getInt("id_absence_retard"), resultSet.getInt("id_etudiant"), resultSet.getString("absence_retard"), resultSet.getDate("date"), resultSet.getString("commentaire")));
            }
            return listAbsenceRetard;
        } catch (SQLException ex) {
            Logger.getLogger(AbsenceRetardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<AbsenceRetard> getListAbsenceRetard(int id_etudiant){
        ArrayList<AbsenceRetard> listAbsenceRetard = new ArrayList<>();
        try {
            String req = "SELECT * FROM absence_retard WHERE id_etudiant = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id_etudiant);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while(resultSet.next()){
                listAbsenceRetard.add(new AbsenceRetard(resultSet.getInt("id_absence_retard"), resultSet.getInt("id_etudiant"), resultSet.getString("absence_retard"), resultSet.getDate("date"), resultSet.getString("commentaire")));
            }
            return listAbsenceRetard;
        } catch (SQLException ex) {
            Logger.getLogger(AbsenceRetardController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    //D
    public void removeAbsenceRetard(int id_absence_retard){
        try {
            String req = "DELETE FROM absence_retard WHERE id_absence_retard = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id_absence_retard);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AbsenceRetardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

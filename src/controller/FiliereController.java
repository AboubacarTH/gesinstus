/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Filiere;
import java.sql.Connection;
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
public class FiliereController {
    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    public FiliereController(){
        this.connection = Main.getConnection();
    }
    
    /**
     *
     * @param filiere
     * @param sigle
     */
    public void addFiliere(String filiere, String sigle){
        try {
            String req = "INSERT INTO filieres (filiere, sigle) VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, filiere);
            preparedStatement.setString(2, sigle);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FiliereController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     *
     * @param id_filiere
     * @param filiere
     * @param sigle
     */
    public void updateFiliere(int id_filiere, String filiere, String sigle){
        try {
            String req = "UPDATE filieres SET filiere = ?, sigle = ? WHERE id_filiere = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, filiere);
            preparedStatement.setString(2, sigle);
            preparedStatement.setInt(3, id_filiere);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FiliereController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     *
     * @param id_filiere
     */
    public void removeFiliere(int id_filiere){
        try {
            String req = "DELETE FROM filieres WHERE id_filiere = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id_filiere);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FiliereController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     *
     * @param id_filiere
     * @return
     */
    public Filiere getFiliere(int id_filiere){
        try {
            String req = "SELECT * FROM filieres WHERE id_filiere = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id_filiere);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return new Filiere(resultSet.getInt("id_filiere"), resultSet.getString("filiere"), resultSet.getString("sigle"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FiliereController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Filiere getFiliere(String filiere){
        try {
            String req = "SELECT * FROM filieres WHERE filiere = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, filiere);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return new Filiere(resultSet.getInt("id_filiere"), resultSet.getString("filiere"), resultSet.getString("sigle"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FiliereController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Filiere> getFilieres(){
        ArrayList<Filiere> listFiliere = new ArrayList<>();
        try {
            String req = "SELECT * FROM filieres";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while(resultSet.next()){
                listFiliere.add(new Filiere(resultSet.getInt("id_filiere"), resultSet.getString("filiere"), resultSet.getString("sigle")));
            }
            return listFiliere;
        } catch (SQLException ex) {
            Logger.getLogger(FiliereController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

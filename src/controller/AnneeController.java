/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Annee;
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
public class AnneeController {
    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    public AnneeController(Connection connection) {
        this.connection = connection;
    }
    public AnneeController(){
        this.connection = Main.getConnection();
    }
    
    /**
     *
     * @param id
     * @param annee
     */
    public void updateAnnee(int id, String annee){
        try {
            String req = "UPDATE annee_scolaires SET annee = ? WHERE id = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, annee);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AnneeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param id
     * @return Annee
     */
    public Annee getAnnee(int id){
        try {
            String req = "SELECT * FROM annee_scolaires WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return new Annee(resultSet.getInt("id"), resultSet.getString("annee"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnneeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     *
     * @param annee
     * @return Annee
     */
    public Annee getAnnee(String annee){
        try {
            String req = "SELECT * FROM annee_scolaires WHERE annee = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, annee);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return new Annee(resultSet.getInt("id"), resultSet.getString("annee"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnneeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     *
     * @param annee
     */
    public void addAnnee(String annee){
        try {
            String req = "INSERT INTO annee_scolaires (annee) VALUES (?)";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, annee);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AnneeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Annee> getAnnees(){
        ArrayList<Annee> listAnnee = new ArrayList<>();
        try {
            String req = "SELECT * FROM annee_scolaires ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while(resultSet.next()){
                listAnnee.add(new Annee(resultSet.getInt("id"), resultSet.getString("annee")));
            }
            return listAnnee;
        } catch (SQLException ex) {
            Logger.getLogger(AnneeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     *
     * @param id
     */
    public void removeAnnee(int id){
        try {
            String req = "DELETE FROM annee_scolaires WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AnneeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

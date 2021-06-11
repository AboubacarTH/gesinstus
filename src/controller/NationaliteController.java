/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Nationalite;
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
public class NationaliteController {
    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    public NationaliteController(Connection connection) {
        this.connection = connection;
    }
    
    public NationaliteController(){
        this.connection = Main.getConnection();
    }
    
    /**
     *
     * @param nationalite
     */
    public void addNationalite(String nationalite){
        try {
            String req = "INSERT INTO nationalites (nationalite) VALUES (?)";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, nationalite);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NationaliteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //U

    /**
     *
     * @param id_nationalite
     * @param nationalite
     */
    public void updateNationalite(int id_nationalite, String nationalite){
        try {
            String req = "UPDATE nationalites SET nationalite = ? WHERE id_nationalite = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, nationalite);
            preparedStatement.setInt(2, id_nationalite);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NationaliteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     *
     * @param id_nationalite
     */
    public void removeNationalite(int id_nationalite){
        try {
            String req = "DELETE FROM nationalites WHERE id_nationalite = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id_nationalite);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NationaliteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public Nationalite getNationalite(int id_nationalite){
        try {
            String req = "SELECT * FROM nationalites WHERE id_nationalite = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id_nationalite);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return  new Nationalite(resultSet.getInt("id_nationalite"), resultSet.getString("nationalite"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NationaliteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public Nationalite getNationalite(String nationalite){
        try {
            String req = "SELECT * FROM nationalites WHERE nationalite = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, nationalite);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return  new Nationalite(resultSet.getInt("id_nationalite"), resultSet.getString("nationalite"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NationaliteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ArrayList<Nationalite> getNationalites(){
        ArrayList<Nationalite> listNationalite = new ArrayList<>();
        try {
            String req = "SELECT * FROM nationalites ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while(resultSet.next()){
                listNationalite.add(new Nationalite(resultSet.getInt("id_nationalite"), resultSet.getString("nationalite")));
            }
            return listNationalite;
        } catch (SQLException ex) {
            Logger.getLogger(NationaliteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

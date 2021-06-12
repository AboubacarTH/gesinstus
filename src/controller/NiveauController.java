/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Niveau;
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
public class NiveauController {
    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    
    public NiveauController() {
        this.connection = Main.getConnection();
    }
    
    /**
     *
     * @param id_option
     * @param niveau
     * @param priorite
     */
    public void addNiveau(int id_option, String niveau, int priorite){
        try {
            String req = "INSERT INTO niveaux (id_option, niveau, priorite) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id_option);
            preparedStatement.setString(2, niveau);
            preparedStatement.setInt(3, priorite);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NiveauController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     *
     * @param id_niveau
     * @param id_option
     * @param niveau
     * @param priorite
     */
    public void updateNiveau(int id_niveau, int id_option, String niveau, int priorite){
        try {
            String req = "UPDATE niveaux SET id_option = ?, niveau = ?, priorite = ? WHERE id_niveau = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id_option);
            preparedStatement.setString(2, niveau);
            preparedStatement.setInt(3, priorite);
            preparedStatement.setInt(4, id_niveau);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NiveauController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     *
     * @param id_niveau
     */
    public void removeNiveau(int id_niveau){
        try {
            String req = "DELETE FROM niveaux WHERE id_niveau = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id_niveau);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(NiveauController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     *
     * @param id_niveau
     * @return
     */
    public Niveau getNiveau(int id_niveau){
        try {
            String req = "SELECT * FROM niveaux WHERE id_niveau = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id_niveau);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return new Niveau(resultSet.getInt("id_niveau"), resultSet.getInt("id_option"), resultSet.getString("niveau"), resultSet.getInt("priorite"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NiveauController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Niveau getNiveau(int id_option, String niveau){
        try {
            String req = "SELECT * FROM niveaux WHERE id_option = ? AND niveau = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id_option);
            preparedStatement.setString(2, niveau);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return new Niveau(resultSet.getInt("id_niveau"), resultSet.getInt("id_option"), resultSet.getString("niveau"), resultSet.getInt("priorite"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(NiveauController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Niveau> getNiveaux(){
        ArrayList<Niveau> listNiveau = new ArrayList<>();
        try {
            String req = "SELECT * FROM niveaux ORDER BY priorite ASC";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while(resultSet.next()){
                listNiveau.add(new Niveau(resultSet.getInt("id_niveau"), resultSet.getInt("id_option"), resultSet.getString("niveau"), resultSet.getInt("priorite")));
            }
            return listNiveau;
        } catch (SQLException ex) {
            Logger.getLogger(NiveauController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

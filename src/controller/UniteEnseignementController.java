/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.UniteEnseignement;
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
public class UniteEnseignementController {
    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public UniteEnseignementController(Connection connection) {
        this.connection = connection;
    }
    public UniteEnseignementController() {
        this.connection = Main.getConnection();
    }
    
    public void addUniteEnseignement(String sigle, String nom){
        try {
            String req = "INSERT INTO unite_enseignements (sigle, nom) VALUES (?, ?) ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, sigle);
            preparedStatement.setString(2, nom);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UniteEnseignementController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void updateUniteEnseignement(int id, String sigle, String nom){
        try {
            String req = "UPDATE unite_enseignements SET sigle = ?, nom = ? WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, sigle);
            preparedStatement.setString(2, nom);
            preparedStatement.setInt(3, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UniteEnseignementController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void removeUniteEnseignement(int id){
        try {
            String req = "DELETE FROM unite_enseignements WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UniteEnseignementController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public UniteEnseignement getUniteEnseignement(int id_unite_enseignement){
        try {
            String req = "SELECT * FROM unite_enseignements WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id_unite_enseignement);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return new UniteEnseignement(resultSet.getInt("id"), resultSet.getString("sigle"), resultSet.getString("nom"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UniteEnseignementController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public UniteEnseignement getUniteEnseignement(String sigle){
        try {
            String req = "SELECT * FROM unite_enseignements WHERE sigle = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, sigle);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return new UniteEnseignement(resultSet.getInt("id"), resultSet.getString("sigle"), resultSet.getString("nom"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UniteEnseignementController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ArrayList<UniteEnseignement> getUniteEnseignements(){
        try {
            ArrayList<UniteEnseignement> list = new ArrayList<>();
            String req = "SELECT * FROM unite_enseignements ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while(resultSet.next()){
                list.add(new UniteEnseignement(resultSet.getInt("id"), resultSet.getString("sigle"), resultSet.getString("nom")));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(UniteEnseignementController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ArrayList<UniteEnseignement> getUniteEnseignements(String rechercher){
        try {
            ArrayList<UniteEnseignement> list = new ArrayList<>();
            String req = "SELECT * FROM unite_enseignements WHERE id > 0 ";
            if(rechercher != null){
                req += "AND ( sigle LIKE '%" + rechercher + "%' OR nom LIKE '%" + rechercher + "%' ) ";
            }
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while(resultSet.next()){
                list.add(new UniteEnseignement(resultSet.getInt("id"), resultSet.getString("sigle"), resultSet.getString("nom")));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(UniteEnseignementController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

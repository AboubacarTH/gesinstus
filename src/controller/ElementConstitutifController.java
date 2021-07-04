/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.ElementConstitutif;
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
public class ElementConstitutifController {
    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public ElementConstitutifController(Connection connection) {
        this.connection = connection;
    }
    public ElementConstitutifController() {
        this.connection = Main.getConnection();
    }
    
    public void addElementConstitutif(int id_unite_enseignement, String sigle, String nom, double vhe, double credit){
        try {
            String req = "INSERT INTO element_constitutifs (id_unite_enseignement, sigle, nom, vhe, credit) VALUES (?, ?, ?, ?, ?) ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id_unite_enseignement);
            preparedStatement.setString(2, sigle);
            preparedStatement.setString(3, nom);
            preparedStatement.setDouble(4, vhe);
            preparedStatement.setDouble(5, credit);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ElementConstitutifController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void updateElementConstitutif(int id, int id_unite_enseignement, String sigle, String nom, double vhe, double credit){
        try {
            String req = "UPDATE element_constitutifs SET id_unite_enseignement = ?, sigle = ?, nom = ?, vhe = ?, credit = ? WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id_unite_enseignement);
            preparedStatement.setString(2, sigle);
            preparedStatement.setString(3, nom);
            preparedStatement.setDouble(4, vhe);
            preparedStatement.setDouble(5, credit);
            preparedStatement.setInt(6, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ElementConstitutifController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void removeElementConstitutif(int id){
        try {
            String req = "DELETE FROM element_constitutifs WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ElementConstitutifController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ElementConstitutif getElementConstitutif(int id){
        try {
            String req = "SELECT * FROM element_constitutifs WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return new ElementConstitutif(resultSet.getInt("id"), resultSet.getInt("id_unite_enseignement"), resultSet.getString("sigle"), resultSet.getString("nom"), resultSet.getDouble("vhe"), resultSet.getDouble("credit"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ElementConstitutifController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ElementConstitutif getElementConstitutif(String sigle){
        try {
            String req = "SELECT * FROM element_constitutifs WHERE sigle = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, sigle);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return new ElementConstitutif(resultSet.getInt("id"), resultSet.getInt("id_unite_enseignement"), resultSet.getString("sigle"), resultSet.getString("nom"), resultSet.getDouble("vhe"), resultSet.getDouble("credit"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ElementConstitutifController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ArrayList<ElementConstitutif> getElementConstitutifs(){
        try {
            ArrayList<ElementConstitutif> list = new ArrayList<>();
            String req = "SELECT * FROM element_constitutifs ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while(resultSet.next()){
                list.add(new ElementConstitutif(resultSet.getInt("id"), resultSet.getInt("id_unite_enseignement"), resultSet.getString("sigle"), resultSet.getString("nom"), resultSet.getDouble("vhe"), resultSet.getDouble("credit")));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ElementConstitutifController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ArrayList<ElementConstitutif> getElementConstitutifs(int id_unite_enseignement, String rechercher){
        try {
            ArrayList<ElementConstitutif> list = new ArrayList<>();
            String req = "SELECT * FROM element_constitutifs WHERE id > 0 ";
            if(id_unite_enseignement != 0){
                req += "AND id_unite_enseignement = '" + id_unite_enseignement + "' ";
            }
            if(rechercher != null){
                req += "AND ( sigle LIKE '%" + rechercher + "%'  OR nom LIKE '" + rechercher + "%' ) ";
            }
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while(resultSet.next()){
                list.add(new ElementConstitutif(resultSet.getInt("id"), resultSet.getInt("id_unite_enseignement"), resultSet.getString("sigle"), resultSet.getString("nom"), resultSet.getDouble("vhe"), resultSet.getDouble("credit")));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ElementConstitutifController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

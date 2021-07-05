/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Option;
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
public class OptionController {
    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    
    public OptionController() {
        this.connection = Main.getConnection();
    }
    
    /**
     *
     * @param id_filiere
     * @param option
     */
    public void addOption(int id_filiere, String option){
        try {
            String req = "INSERT INTO options (id_filiere, libelle) VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id_filiere);
            preparedStatement.setString(2, option);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param id
     * @param id_filiere
     * @param option
     */
    public void updateOption(int id, int id_filiere, String option){
        try {
            String req = "UPDATE options SET id_filiere = ?, libelle = ? WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id_filiere);
            preparedStatement.setString(2, option);
            preparedStatement.setInt(3, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void removeOption(int id){
        try {
            String req = "DELETE FROM options WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     *
     * @param id
     * @return
     */
    public Option getOption(int id){
        try {
            String req = "SELECT * FROM options WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return new Option(resultSet.getInt("id"), resultSet.getInt("id_filiere"), resultSet.getString("libelle"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(OptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public Option getOption(int id_filiere, String option){
        try {
            String req = "SELECT * FROM options WHERE id_filiere = ? AND libelle = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id_filiere);
            preparedStatement.setString(2, option);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return new Option(resultSet.getInt("id"), resultSet.getInt("id_filiere"), resultSet.getString("libelle"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(OptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Option> getOptions(){
        ArrayList<Option> listOptions = new ArrayList<>();
        try {
            String req = "SELECT * FROM options ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while(resultSet.next()){
                listOptions.add(new Option(resultSet.getInt("id"), resultSet.getInt("id_filiere"), resultSet.getString("libelle")));
            }
            return listOptions;
        } catch (SQLException ex) {
            Logger.getLogger(OptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ArrayList<Option> getOptions(int id_filiere){
        ArrayList<Option> listOptions = new ArrayList<>();
        try {
            String req = "SELECT * FROM options WHERE id > 0 ";
            if(id_filiere != 0){
                req += "AND id_filiere = '" + id_filiere + "' ";
            }
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while(resultSet.next()){
                listOptions.add(new Option(resultSet.getInt("id"), resultSet.getInt("id_filiere"), resultSet.getString("libelle")));
            }
            return listOptions;
        } catch (SQLException ex) {
            Logger.getLogger(OptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

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
            String req = "INSERT INTO options (id_filiere, option) VALUES (?, ?)";
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
     * @param id_option
     * @param id_filiere
     * @param option
     */
    public void updateOption(int id_option, int id_filiere, String option){
        try {
            String req = "UPDATE options SET id_filiere = ?, option = ? WHERE id_option = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id_filiere);
            preparedStatement.setString(2, option);
            preparedStatement.setInt(3, id_option);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void removeOption(int id_option){
        try {
            String req = "DELETE FROM options WHERE id_option = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id_option);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     *
     * @param id_option
     * @return
     */
    public Option getOption(int id_option){
        try {
            String req = "SELECT * FROM options WHERE id_option = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id_option);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return new Option(resultSet.getInt("id_option"), resultSet.getInt("id_filiere"), resultSet.getString("option"));
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
                listOptions.add(new Option(resultSet.getInt("id_option"), resultSet.getInt("id_filiere"), resultSet.getString("option")));
            }
            return listOptions;
        } catch (SQLException ex) {
            Logger.getLogger(OptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

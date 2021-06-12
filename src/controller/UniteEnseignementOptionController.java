/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.UniteEnseignementOption;
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
public class UniteEnseignementOptionController {
    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public UniteEnseignementOptionController(Connection connection) {
        this.connection = connection;
    }
    public UniteEnseignementOptionController() {
        this.connection = Main.getConnection();
    }

    /**
     *
     * @param id_option
     * @param id_unite_enseignement
     */
    public void addUniteEnseignementOption(int id_option, int id_unite_enseignement){
        try {
            String req = "INSERT INTO unite_enseignement_options (id_option, id_unite_enseignement) VALUES (?, ?) ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id_option);
            preparedStatement.setInt(2, id_unite_enseignement);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UniteEnseignementOptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param id_unite_enseignement_option
     * @param id_option
     * @param id_unite_enseignement
     */
    public void updateUniteEnseignementOption(int id_unite_enseignement_option, int id_option, int id_unite_enseignement){
        try {
            String req = "UPDATE unite_enseignement_options SET id_option = ?, id_unite_enseignement = ? WHERE id_unite_enseignement = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id_option);
            preparedStatement.setInt(2, id_unite_enseignement);
            preparedStatement.setInt(3, id_unite_enseignement_option);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UniteEnseignementOptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param id_unite_enseignement_option
     */
    public void removeUniteEnseignementOption(int id_unite_enseignement_option){
        try {
            String req = "DELETE FROM unite_enseignement_options WHERE id_unite_enseignement = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id_unite_enseignement_option);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UniteEnseignementOptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param id_unite_enseignement_option
     * @return
     */
    public UniteEnseignementOption getUniteEnseignementOption(int id_unite_enseignement_option){
        try {
            String req = "SELECT * FROM unite_enseignement_options WHERE id_unite_enseignement_option = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id_unite_enseignement_option);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return new UniteEnseignementOption(resultSet.getInt("id_unite_enseignement_option"), resultSet.getInt("id_option"), resultSet.getInt("id_unite_enseignement"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UniteEnseignementOptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
        
    public ArrayList<UniteEnseignementOption> getUniteEnseignementOptions(){
        try {
            ArrayList<UniteEnseignementOption> list = new ArrayList<>();
            String req = "SELECT * FROM unite_enseignement_options ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while(resultSet.next()){
                list.add(new UniteEnseignementOption(resultSet.getInt("id_unite_enseignement_option"), resultSet.getInt("id_option"), resultSet.getInt("id_unite_enseignement")));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(UniteEnseignementOptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

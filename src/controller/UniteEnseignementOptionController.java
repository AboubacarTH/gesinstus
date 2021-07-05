/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.UniteEnseignementOption;
import bean.UniteEnseignementOptionTable;
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
     * @param id_semestre
     */
    public void addUniteEnseignementOption(int id_option, int id_unite_enseignement, int id_semestre){
        try {
            String req = "INSERT INTO unite_enseignement_options (id_option, id_unite_enseignement, id_semestre) VALUES (?, ?, ?) ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id_option);
            preparedStatement.setInt(2, id_unite_enseignement);
            preparedStatement.setInt(3, id_semestre);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UniteEnseignementOptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param id
     * @param id_option
     * @param id_unite_enseignement
     * @param id_semestre
     */
    public void updateUniteEnseignementOption(int id, int id_option, int id_unite_enseignement, int id_semestre){
        try {
            String req = "UPDATE unite_enseignement_options SET id_option = ?, id_unite_enseignement = ?, id_semestre = ? WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id_option);
            preparedStatement.setInt(2, id_unite_enseignement);
            preparedStatement.setInt(3, id_semestre);
            preparedStatement.setInt(4, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UniteEnseignementOptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param id
     */
    public void removeUniteEnseignementOption(int id){
        try {
            String req = "DELETE FROM unite_enseignement_options WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UniteEnseignementOptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param id
     * @return
     */
    public UniteEnseignementOption getUniteEnseignementOption(int id){
        try {
            String req = "SELECT * FROM unite_enseignement_options WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return new UniteEnseignementOption(resultSet.getInt("id"), resultSet.getInt("id_option"), resultSet.getInt("id_unite_enseignement"), resultSet.getInt("id_semestre"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UniteEnseignementOptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
        
    public ArrayList<UniteEnseignementOption> getUniteEnseignementOptions(int id_option, int id_semestre, String rechercher){
        try {
            ArrayList<UniteEnseignementOption> list = new ArrayList<>();
            String req = "SELECT unite_enseignement_options.id AS id, unite_enseignement_options.id_option AS id_option, unite_enseignement_options.id_unite_enseignement AS id_unite_enseignement, unite_enseignement_options.id_semestre AS id_semestre FROM unite_enseignement_options JOIN unite_enseignements ON unite_enseignement_options.id_unite_enseignement = unite_enseignements.id WHERE unite_enseignement_options.id > '0' ";
            if(id_option != 0){
                req += "AND unite_enseignement_options.id_option = '" + id_option + "' ";
            }
            if(id_semestre != 0){
                req += "AND unite_enseignement_options.id_semestre = '" + id_semestre + "' ";
            }
            if(rechercher != null){
                req += "AND ( unite_enseignements.sigle LIKE '%" + rechercher + "%' OR unite_enseignements.nom LIKE '%" + rechercher + "%' ) ";
            }
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while(resultSet.next()){
                list.add(new UniteEnseignementOption(resultSet.getInt("id"), resultSet.getInt("id_option"), resultSet.getInt("id_unite_enseignement"), resultSet.getInt("id_semestre")));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(UniteEnseignementOptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ArrayList<UniteEnseignementOptionTable> getUniteEnseignementOptionTables(int id_option, int id_semestre, String rechercher){
        try {
            ArrayList<UniteEnseignementOptionTable> list = new ArrayList<>();
            String req = "SELECT unite_enseignement_options.id AS id, unite_enseignement_options.id_option AS id_option, unite_enseignement_options.id_unite_enseignement AS id_unite_enseignement, options.id_filiere AS id_filiere, unite_enseignement_options.id_semestre AS id_semestre FROM unite_enseignement_options "
                    + "JOIN unite_enseignements ON unite_enseignement_options.id_unite_enseignement = unite_enseignements.id "
                    + "JOIN options ON unite_enseignement_options.id_option = options.id "
                    + "WHERE unite_enseignement_options.id > '0' ";
            if(id_option != 0){
                req += "AND unite_enseignement_options.id_option = '" + id_option + "' ";
            }
            if(id_semestre != 0){
                req += "AND unite_enseignement_options.id_semestre = '" + id_semestre + "' ";
            }
            if(rechercher != null){
                req += "AND ( unite_enseignements.sigle LIKE '%" + rechercher + "%' OR unite_enseignements.nom LIKE '%" + rechercher + "%' ) ";
            }
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while(resultSet.next()){
                list.add(new UniteEnseignementOptionTable(resultSet.getInt("id"), resultSet.getInt("id_option"), resultSet.getInt("id_unite_enseignement"), resultSet.getInt("id_filiere"), resultSet.getInt("id_semestre")));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(UniteEnseignementOptionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

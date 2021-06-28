/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Parametre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.Main;

/**
 *
 * @author ATH
 */
public class ParametreController {
    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    public ParametreController(Connection connection) {
        this.connection = connection;
    }
    public ParametreController(){
        this.connection = Main.getConnection();
    }
    public void updateParametre(int id_annee){
        if(getParametre() == null){
            addParametre(id_annee);
        }
        try {
            String req = "UPDATE parametres SET id_annee = ? WHERE id = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id_annee);
            preparedStatement.setInt(2, 1);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AnneeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Parametre getParametre(){
        try {
            String req = "SELECT * parametres WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, 1);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return new Parametre(resultSet.getInt("id"), resultSet.getInt("id_annee"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ParametreController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public void addParametre(int id_annee){
        try {
            String req = "INSERT INTO parametres (id, annee) VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, 1);
            preparedStatement.setInt(2, id_annee);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AnneeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

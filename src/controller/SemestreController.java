/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Semestre;
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
public class SemestreController {
    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    public SemestreController(Connection connection) {
        this.connection = connection;
    }
    public SemestreController() {
        this.connection = Main.getConnection();
    }
    
    /**
     *
     * @param semestre
     * @param priorite
     */
    public void addSemestre(String semestre, int priorite){
        try {
            String req = "INSERT INTO semestres (semestre, priorite) VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, semestre);
            preparedStatement.setInt(2, priorite);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SemestreController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param id_semestre
     * @param semestre
     * @param priorite
     */
    public void updateSemestre(int id_semestre, String semestre, int priorite){
        try {
            String req = "UPDATE semestres SET semestre = ?, priorite = ? WHERE id_semestre = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, semestre);
            preparedStatement.setInt(2, priorite);
            preparedStatement.setInt(3, id_semestre);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SemestreController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param id_semestre
     */
    public void removeSemestre(int id_semestre){
        try {
            String req = "DELETE FROM semestres WHERE id_semestre = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id_semestre);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SemestreController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     *
     * @param id_semestre
     * @return
     */
    public Semestre getSemestre(int id_semestre){
        try {
            String req = "SELECT * FROM semestres WHERE id_semestre = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id_semestre);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return new Semestre(resultSet.getInt("id_semestre"), resultSet.getString("semestre"), resultSet.getInt("priorite"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SemestreController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Semestre> getSemestres(){
        ArrayList<Semestre> listSemestre = new ArrayList<>();
        try {
            String req = "SELECT * FROM semestre ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while(resultSet.next()){
                listSemestre.add(new Semestre(resultSet.getInt("id_semestre"), resultSet.getString("semestre"), resultSet.getInt("priorite")));
            }
            return listSemestre;
        } catch (SQLException ex) {
            Logger.getLogger(SemestreController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

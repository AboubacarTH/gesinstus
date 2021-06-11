/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Evaluation;
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
public class EvaluationController {
    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    
    public EvaluationController(){
        this.connection = Main.getConnection();
    }
    
    /**
     *
     * @param id_etudiant
     * @param id_annee
     * @param id_element_constitufit
     * @param note
     * @param session
     */
    public void addEvaluation(int id_etudiant, int id_annee, int id_element_constitufit, double note, double session){
        try {
            String req = "INSERT INTO evaluations (id_etudiant, id_annee, id_element_constitufit, note, session) VALUES (?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id_etudiant);
            preparedStatement.setInt(2, id_annee);
            preparedStatement.setInt(3, id_element_constitufit);
            preparedStatement.setDouble(4, note);
            preparedStatement.setDouble(5, session);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EvaluationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     *
     * @param id_evaluation
     * @param id_etudiant
     * @param id_annee
     * @param id_element_constitufit
     * @param note
     * @param session
     */
    public void updateEvaluation(int id_evaluation, int id_etudiant, int id_annee, int id_element_constitufit, double note, double session){
        try {
            String req = "UPDATE evaluations SET id_etudiant = ?, id_annee = ?, id_element_constitufit = ?, note = ?, session = ? WHERE id_evaluation = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id_etudiant);
            preparedStatement.setInt(2, id_annee);
            preparedStatement.setInt(3, id_element_constitufit);
            preparedStatement.setDouble(4, note);
            preparedStatement.setDouble(5, session);
            preparedStatement.setInt(6, id_evaluation);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EvaluationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     *
     * @param id_evaluation
     */
    public void removeEvaluation(int id_evaluation){
        try {
            String req = "DELETE FROM evaluations WHERE id_evaluation = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id_evaluation);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EvaluationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     *
     * @param id_evaluation
     * @return Evaluation
     */
    public Evaluation getEvaluation(int id_evaluation){
        try {
            String req = "SELECT * FROM evaluations WHERE id_evaluation = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id_evaluation);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return new Evaluation(resultSet.getInt("id_evaluation"), resultSet.getInt("id_etudiant"), resultSet.getInt("id_annee"), resultSet.getInt("id_element_constitutif"), resultSet.getDouble("note"), resultSet.getDouble("session"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EvaluationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<Evaluation> getEvaluations(){
        try {
            ArrayList<Evaluation> list = new ArrayList<>();
            String req = "SELECT * FROM evaluations ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while(resultSet.next()){
                list.add(new Evaluation(resultSet.getInt("id_evaluation"), resultSet.getInt("id_etudiant"), resultSet.getInt("id_annee"), resultSet.getInt("id_element_constitutif"), resultSet.getDouble("note"), resultSet.getDouble("session")));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(EvaluationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}

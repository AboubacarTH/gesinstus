/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.VolumeHoraireCours;
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
public class VolumeHoraireCoursController {
    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public VolumeHoraireCoursController(Connection connection) {
        this.connection = connection;
    }
    public VolumeHoraireCoursController() {
        this.connection = Main.getConnection();
    }
    
    public void addVolumeHoraireCours(int id_element_constitutif, double cm, double td_tp, double stage){
        try {
            String req = "INSERT INTO volume_horaire_cours (id_element_constitutif, cm, td_tp, stage) VALUES (?, ?, ?, ?) ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id_element_constitutif);
            preparedStatement.setDouble(2, cm);
            preparedStatement.setDouble(3, td_tp);
            preparedStatement.setDouble(4, stage);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VolumeHoraireCoursController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void updateVolumeHoraireCours(int id_volume_horaire_cour, int id_element_constitutif, double cm, double td_tp, double stage){
        try {
            String req = "UPDATE volume_horaire_cours SET id_element_constitutif = ?, cm = ?, td_tp = ?, stage = ? WHERE id_volume_horaire_cour = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id_element_constitutif);
            preparedStatement.setDouble(2, cm);
            preparedStatement.setDouble(3, td_tp);
            preparedStatement.setDouble(4, stage);
            preparedStatement.setInt(5, id_volume_horaire_cour);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VolumeHoraireCoursController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void removeVolumeHoraireCours(int id_volume_horaire_cour){
        try {
            String req = "DELETE FROM volume_horaire_cours WHERE id_volume_horaire_cour = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id_volume_horaire_cour);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VolumeHoraireCoursController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public VolumeHoraireCours getVolumeHoraireCours(int id_volume_horaire_cour){
        try {
            String req = "SELECT * FROM volume_horaire_cours WHERE id_volume_horaire_cour = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id_volume_horaire_cour);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return new VolumeHoraireCours(resultSet.getInt("id_volume_horaire_cour"), resultSet.getInt("id_element_constitutif"), resultSet.getDouble("cm"), resultSet.getDouble("td_tp"), resultSet.getDouble("stage"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(VolumeHoraireCoursController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ArrayList<VolumeHoraireCours> getVolumeHoraireCours(){
        try {
            ArrayList<VolumeHoraireCours> list = new ArrayList<>();
            String req = "SELECT * FROM volume_horaire_cours ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while(resultSet.next()){
                list.add(new VolumeHoraireCours(resultSet.getInt("id_volume_horaire_cour"), resultSet.getInt("id_element_constitutif"), resultSet.getDouble("cm"), resultSet.getDouble("td_tp"), resultSet.getDouble("stage")));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(VolumeHoraireCoursController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void updateNote(int id, String columnName, double valeur) {
        String column;
        switch(columnName){
            case "CM" :
                column = "cm";
                break;
            case "TD_TP" :
                column = "td_tp";
                break;
                default:
                    column = "";
                    break;
        }
        if(getVolumeHoraireCours(id) == null){
            addVolumeHoraireCours(id, 0.0, 0.0, 0.0);
        }
        try {
            String req = "UPDATE volume_horaire_cours SET " + column +" = ? WHERE id_element_constitutif = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setDouble(1, valeur);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(VolumeHoraireCoursController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

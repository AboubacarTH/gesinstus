/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Etudiant;
import java.sql.Connection;
import java.sql.Date;
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
public class EtudiantController {
    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    
    public EtudiantController() {
        this.connection = Main.getConnection();
    }
    public EtudiantController(Connection connection){
        this.connection = connection;
    }
    
    /**
     *
     * @param id_annee
     * @param id_nationalite
     * @param id_niveau
     * @param matricule
     * @param nom_prenom
     * @param date_de_naissance
     * @param lieu_de_naissance
     * @param contact
     * @param sexe
     * @param photo
     * @param mot_de_passe
     */
    public void addEtudiant(int id_annee, int id_nationalite, int id_niveau, String matricule, String nom_prenom, Date date_de_naissance, String lieu_de_naissance, String contact, String sexe, String photo, String mot_de_passe){
        try {
            String req = "INSERT INTO etudiants (id_annee, id_nationalite, id_niveau, matricule, nom_prenom, date_de_naissance, lieu_de_naissance, contact, sexe, photo, mot_de_passe) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id_annee);
            preparedStatement.setInt(2, id_nationalite);
            preparedStatement.setInt(3, id_niveau);
            preparedStatement.setString(4, matricule);
            preparedStatement.setString(5, nom_prenom);
            preparedStatement.setDate(6, date_de_naissance);
            preparedStatement.setString(7, lieu_de_naissance);
            preparedStatement.setString(8, contact);
            preparedStatement.setString(9, sexe);
            preparedStatement.setString(10, photo);
            preparedStatement.setString(11, mot_de_passe);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EtudiantController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     *
     * @param id_etudiant
     * @param id_annee
     * @param id_nationalite
     * @param id_niveau
     * @param matricule
     * @param nom_prenom
     * @param date_de_naissance
     * @param lieu_de_naissance
     * @param contact
     * @param sexe
     * @param photo
     * @param mot_de_passe
     */
    public void updateEtudiant(int id_etudiant, int id_annee, int id_nationalite, int id_niveau, String matricule, String nom_prenom, Date date_de_naissance, String lieu_de_naissance, String contact, String sexe, String photo, String mot_de_passe){
        try {
            String req = "UPDATE etudiants SET id_annee = ?, id_nationalite = ?, id_niveau = ?, matricule = ?, nom_prenom = ?, date_de_naissance = ?, lieu_de_naissance = ?, contact = ?, sexe = ?, photo = ?, mot_de_passe = ? WHERE id_etudiant = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id_annee);
            preparedStatement.setInt(2, id_nationalite);
            preparedStatement.setInt(3, id_niveau);
            preparedStatement.setString(4, matricule);
            preparedStatement.setString(5, nom_prenom);
            preparedStatement.setDate(6, date_de_naissance);
            preparedStatement.setString(7, lieu_de_naissance);
            preparedStatement.setString(8, contact);
            preparedStatement.setString(9, sexe);
            preparedStatement.setString(10, photo);
            preparedStatement.setString(11, mot_de_passe);
            preparedStatement.setInt(2, id_etudiant);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EtudiantController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     *
     * @param id_etudiant
     * @return
     */
    public Etudiant getEtudiant(int id_etudiant){
        try {
            String req = "SELECT * FROM etudiants WHERE id_etudiant = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id_etudiant);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return new Etudiant(resultSet.getInt("id_etudiant"), resultSet.getInt("id_annee"), resultSet.getInt("id_nationalite"), resultSet.getInt("id_niveau"), resultSet.getString("matricule"), resultSet.getString("nom_prenom"), resultSet.getDate("date_de_naissance"), resultSet.getString("lieu_de_naissance"), resultSet.getString("contact"), resultSet.getString("sexe"), resultSet.getString("photo"), resultSet.getString("mot_de_passe"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EtudiantController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     *
     * @return list of students
     */
    public ArrayList<Etudiant> getEtudiants(){
        ArrayList<Etudiant> listEtudiant = new ArrayList<>();
        try {
            String req = "SELECT * FROM etudiants ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setBoolean(1, true);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while(resultSet.next()){
                listEtudiant.add(new Etudiant(resultSet.getInt("id_etudiant"), resultSet.getInt("id_annee"), resultSet.getInt("id_nationalite"), resultSet.getInt("id_niveau"), resultSet.getString("matricule"), resultSet.getString("nom_prenom"), resultSet.getDate("date_de_naissance"), resultSet.getString("lieu_de_naissance"), resultSet.getString("contact"), resultSet.getString("sexe"), resultSet.getString("photo"), resultSet.getString("mot_de_passe")));
            }
            return listEtudiant;
        } catch (SQLException ex) {
            Logger.getLogger(EtudiantController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     *
     * @param id_etudiant
     */
    public void removeEtudiant(int id_etudiant){
        try {
            String req = "DELETE FROM etudiants WHERE id_etudiant = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(2, id_etudiant);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EtudiantController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

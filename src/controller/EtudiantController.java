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
     * @param id_option
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
    public void addEtudiant(int id_annee, int id_nationalite,int id_option, int id_niveau, String matricule, String nom_prenom, Date date_de_naissance, String lieu_de_naissance, String contact, String sexe, String photo, String mot_de_passe){
        try {
            String req = "INSERT INTO etudiants (id_annee, id_nationalite, id_option, id_niveau, matricule, nom_prenom, date_de_naissance, lieu_de_naissance, contact, sexe, photo, mot_de_passe) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id_annee);
            preparedStatement.setInt(2, id_nationalite);
            preparedStatement.setInt(3, id_option);
            preparedStatement.setInt(4, id_niveau);
            preparedStatement.setString(5, matricule);
            preparedStatement.setString(6, nom_prenom);
            preparedStatement.setDate(7, date_de_naissance);
            preparedStatement.setString(8, lieu_de_naissance);
            preparedStatement.setString(9, contact);
            preparedStatement.setString(10, sexe);
            preparedStatement.setString(11, photo);
            preparedStatement.setString(12, mot_de_passe);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EtudiantController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     *
     * @param id
     * @param id_annee
     * @param id_nationalite
     * @param id_option
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
    public void updateEtudiant(int id, int id_annee, int id_nationalite, int id_option, int id_niveau, String matricule, String nom_prenom, Date date_de_naissance, String lieu_de_naissance, String contact, String sexe, String photo, String mot_de_passe){
        try {
            String req = "UPDATE etudiants SET id_annee = ?, id_nationalite = ?, id_option = ?, id_niveau = ?, matricule = ?, nom_prenom = ?, date_de_naissance = ?, lieu_de_naissance = ?, contact = ?, sexe = ?, photo = ?, mot_de_passe = ? WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id_annee);
            preparedStatement.setInt(2, id_nationalite);
            preparedStatement.setInt(3, id_option);
            preparedStatement.setInt(4, id_niveau);
            preparedStatement.setString(5, matricule);
            preparedStatement.setString(6, nom_prenom);
            preparedStatement.setDate(7, date_de_naissance);
            preparedStatement.setString(8, lieu_de_naissance);
            preparedStatement.setString(9, contact);
            preparedStatement.setString(10, sexe);
            preparedStatement.setString(11, photo);
            preparedStatement.setString(12, mot_de_passe);
            preparedStatement.setInt(13, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EtudiantController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     *
     * @param id
     * @return
     */
    public Etudiant getEtudiant(int id){
        try {
            String req = "SELECT * FROM etudiants WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return new Etudiant(resultSet.getInt("id"), resultSet.getInt("id_annee"), resultSet.getInt("id_nationalite"), resultSet.getInt("id_option"), resultSet.getInt("id_niveau"), resultSet.getString("matricule"), resultSet.getString("nom_prenom"), resultSet.getDate("date_de_naissance"), resultSet.getString("lieu_de_naissance"), resultSet.getString("contact"), resultSet.getString("sexe"), resultSet.getString("photo"), resultSet.getString("mot_de_passe"));
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
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while(resultSet.next()){
                listEtudiant.add(new Etudiant(resultSet.getInt("id"), resultSet.getInt("id_annee"), resultSet.getInt("id_nationalite"), resultSet.getInt("id_option"), resultSet.getInt("id_niveau"), resultSet.getString("matricule"), resultSet.getString("nom_prenom"), resultSet.getDate("date_de_naissance"), resultSet.getString("lieu_de_naissance"), resultSet.getString("contact"), resultSet.getString("sexe"), resultSet.getString("photo"), resultSet.getString("mot_de_passe")));
            }
            return listEtudiant;
        } catch (SQLException ex) {
            Logger.getLogger(EtudiantController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<Etudiant> getEtudiants(int id_filiere){
        ArrayList<Etudiant> listEtudiant = new ArrayList<>();
        try {
            String req = "SELECT * FROM etudiants JOIN options ON "
                    + "etudiant.id_option = options.id_option WHERE options.id_filiere = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id_filiere);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while(resultSet.next()){
                listEtudiant.add(new Etudiant(resultSet.getInt("id"), resultSet.getInt("id_annee"), resultSet.getInt("id_nationalite"), resultSet.getInt("id_option"), resultSet.getInt("id_niveau"), resultSet.getString("matricule"), resultSet.getString("nom_prenom"), resultSet.getDate("date_de_naissance"), resultSet.getString("lieu_de_naissance"), resultSet.getString("contact"), resultSet.getString("sexe"), resultSet.getString("photo"), resultSet.getString("mot_de_passe")));
            }
            return listEtudiant;
        } catch (SQLException ex) {
            Logger.getLogger(EtudiantController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<Etudiant> getEtudiants(int id_filiere, int id_option){
        ArrayList<Etudiant> listEtudiant = new ArrayList<>();
        try {
            String req = "SELECT * FROM etudiants JOIN options ON "
                    + "etudiant.id_option = options.id_option WHERE options.id_filiere = ? AND options.id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id_filiere);
            preparedStatement.setInt(2, id_option);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while(resultSet.next()){
                listEtudiant.add(new Etudiant(resultSet.getInt("id"), resultSet.getInt("id_annee"), resultSet.getInt("id_nationalite"), resultSet.getInt("id_option"), resultSet.getInt("id_niveau"), resultSet.getString("matricule"), resultSet.getString("nom_prenom"), resultSet.getDate("date_de_naissance"), resultSet.getString("lieu_de_naissance"), resultSet.getString("contact"), resultSet.getString("sexe"), resultSet.getString("photo"), resultSet.getString("mot_de_passe")));
            }
            return listEtudiant;
        } catch (SQLException ex) {
            Logger.getLogger(EtudiantController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     *
     * @param id
     */
    public void removeEtudiant(int id){
        try {
            String req = "DELETE FROM etudiants WHERE id = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EtudiantController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

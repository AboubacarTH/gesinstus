/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Professeur;
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
public class ProfesseurController {
    private final Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public ProfesseurController(Connection connection) {
        this.connection = connection;
    }
    public ProfesseurController() {
        this.connection = Main.getConnection();
    }
    
    /**
     *
     * @param id_nationalite
     * @param matricule
     * @param nom_prenom
     * @param date_de_naissance
     * @param lieu_de_naissance
     * @param contact
     * @param titre
     * @param diplome
     * @param sexe
     * @param mot_de_passe
     * @param isActif
     */
    public void addProfesseur(int id_nationalite, String matricule, String nom_prenom, Date date_de_naissance, String lieu_de_naissance, String contact, String titre, String diplome, String sexe, String mot_de_passe, boolean isActif){
        try {
            String req = "INSERT INTO professeurs (id_nationalite, matricule, nom_prenom, date_de_naissance, lieu_de_naissance, contact, titre, diplome, sexe, mot_de_passe, actif) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id_nationalite);
            preparedStatement.setString(2, matricule);
            preparedStatement.setString(3, nom_prenom);
            preparedStatement.setDate(4, date_de_naissance);
            preparedStatement.setString(5, lieu_de_naissance);
            preparedStatement.setString(6, contact);
            preparedStatement.setString(7, titre);
            preparedStatement.setString(8, diplome);
            preparedStatement.setString(9, sexe);
            preparedStatement.setString(10, mot_de_passe);
            preparedStatement.setBoolean(11, isActif);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfesseurController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param id_professeur
     * @param id_nationalite
     * @param matricule
     * @param nom_prenom
     * @param date_de_naissance
     * @param lieu_de_naissance
     * @param contact
     * @param titre
     * @param diplome
     * @param sexe
     * @param mot_de_passe
     * @param isActif
     */
    public void updateProfesseur(int id_professeur, int id_nationalite, String matricule, String nom_prenom, Date date_de_naissance, String lieu_de_naissance, String contact, String titre, String diplome, String sexe, String mot_de_passe, boolean isActif){
        try {
            String req = "UPDATE professeurs SET id_nationalite = ?, matricule = ?, nom_prenom = ?, date_de_naissance = ?, lieu_de_naissance = ?, contact = ?, titre = ?, diplome = ?, sexe = ?, mot_de_passe = ?, actif = ? WHERE id_professeur = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id_nationalite);
            preparedStatement.setString(2, matricule);
            preparedStatement.setString(3, nom_prenom);
            preparedStatement.setDate(4, date_de_naissance);
            preparedStatement.setString(5, lieu_de_naissance);
            preparedStatement.setString(6, contact);
            preparedStatement.setString(7, titre);
            preparedStatement.setString(8, diplome);
            preparedStatement.setString(9, sexe);
            preparedStatement.setString(10, mot_de_passe);
            preparedStatement.setBoolean(11, isActif);
            preparedStatement.setInt(12, id_professeur);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfesseurController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param id_professeur
     */
    public void removeProfesseur(int id_professeur){
        try {
            String req = "DELETE FROM professeurs WHERE id_professeur = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id_professeur);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProfesseurController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     *
     * @param id_professeur
     * @return
     */
    public Professeur getProfesseur(int id_professeur){
        try {
            String req = "SELECT * FROM professeurs WHERE id_professeur = ? ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id_professeur);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return new Professeur(resultSet.getInt("id_professeur"), resultSet.getInt("id_nationalite"), resultSet.getString("matricule"), resultSet.getString("nom_prenom"), resultSet.getDate("date_de_naissance"), resultSet.getString("lieu_de_naissance"), resultSet.getString("contact"), resultSet.getString("titre"), resultSet.getString("diplome"), resultSet.getString("sexe"), resultSet.getString("mot_de_passe"), resultSet.getBoolean("actif"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfesseurController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Professeur> getProfesseurs(){
        ArrayList<Professeur> listProfesseur = new ArrayList<>();
        try {
            String req = "SELECT * FROM professeurs ";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while(resultSet.next()){
                listProfesseur.add(new Professeur(resultSet.getInt("id_professeur"), resultSet.getInt("id_nationalite"), resultSet.getString("matricule"), resultSet.getString("nom_prenom"), resultSet.getDate("date_de_naissance"), resultSet.getString("lieu_de_naissance"), resultSet.getString("contact"), resultSet.getString("titre"), resultSet.getString("diplome"), resultSet.getString("sexe"), resultSet.getString("mot_de_passe"), resultSet.getBoolean("actif")));
            }
            return listProfesseur;
        } catch (SQLException ex) {
            Logger.getLogger(ProfesseurController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Etudiant;
import form.MainForm;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ATH
 */
public class EtudiantController {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    
    public EtudiantController() {
        this.connection = MainForm.getConnection();
    }
    public EtudiantController(Connection connection){
        this.connection = connection;
    }
    public void setConnection(Connection connection){
        this.connection = connection;
    }
    
    //C
    public void addEtudiant(String matricule, String annee, String nom_prenom, Date date_de_naissance, String lieu_de_naissance, String nationalite, String contact, String sexe, String option, String filiere){
        try {
            String req = "INSERT INTO etudiant (matricule,annee,nom_prenom,date_de_naissance,lieu_de_naissance,nationalite,contact,sexe,options,filiere) VALUES (?,?,?,?,?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, matricule);
            preparedStatement.setString(2, annee);
            preparedStatement.setString(3, nom_prenom);
            preparedStatement.setDate(4, date_de_naissance);
            preparedStatement.setString(5, lieu_de_naissance);
            preparedStatement.setString(6, nationalite);
            preparedStatement.setString(7, contact);
            preparedStatement.setString(8, sexe);
            preparedStatement.setString(9, option);
            preparedStatement.setString(10, filiere);
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            Logger.getLogger(EtudiantController.class.getName()).log(Level.SEVERE, null, ex);
            error_information();
        }
    }
    //R
    public Etudiant getEtudiant(String matricule){
        try {
            String req = "SELECT * FROM etudiant WHERE matricule = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, matricule);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return new Etudiant(resultSet.getString("matricule"), resultSet.getString("annee"), resultSet.getString("nom_prenom"), resultSet.getDate("date_de_naissance"), resultSet.getString("lieu_de_naissance"), resultSet.getString("nationalite"), resultSet.getString("contact"), resultSet.getString("sexe"), resultSet.getString("options"), resultSet.getString("filiere"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EtudiantController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public Etudiant getEtudiant(Etudiant e){
        try {
            String req = "SELECT * FROM etudiant WHERE matricule = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, e.getMatricule());
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            if(resultSet.next()){
                return new Etudiant(resultSet.getString("matricule"), resultSet.getString("annee"), resultSet.getString("nom_prenom"), resultSet.getDate("date_de_naissance"), resultSet.getString("lieu_de_naissance"), resultSet.getString("nationalite"), resultSet.getString("contact"), resultSet.getString("sexe"), resultSet.getString("options"), resultSet.getString("filiere"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EtudiantController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ArrayList<Etudiant> getListEtudiant(String rechercher, String nationalite, String sexe, String option, String filiere, String annee){
        ArrayList<Etudiant> listEtudiant = new ArrayList<>();
        try {
            String req = "SELECT * FROM etudiant WHERE etat = ? ";
            if(annee != null && !annee.equals("Toutes")){
                req += "AND annee = '" + annee + "' ";
            }
            if(rechercher != null){
                req += "AND (nom_prenom LIKE '%" + rechercher + "%' OR matricule LIKE '%" + rechercher + "%') ";
            }
            if(nationalite != null && !nationalite.equals("Toutes")){
                req += "AND nationalite = '" + nationalite + "' ";
            }
            if(sexe != null && !sexe.equals("Tous")){
                req += "AND sexe = '" + sexe + "' ";
            }
            if(option != null && !option.equals("Toutes")){
                req += "AND options = '" + option + "' ";
            }
            if(filiere != null && !filiere.equals("Toutes")){
                req += "AND filiere = '" + filiere + "' ";
            }
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setBoolean(1, true);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            while(resultSet.next()){
                listEtudiant.add(new Etudiant(resultSet.getString("matricule"), resultSet.getString("annee"), resultSet.getString("nom_prenom"), resultSet.getDate("date_de_naissance"), resultSet.getString("lieu_de_naissance"), resultSet.getString("nationalite"), resultSet.getString("contact"), resultSet.getString("sexe"), resultSet.getString("options"), resultSet.getString("filiere")));
            }
            return listEtudiant;
        } catch (SQLException ex) {
            Logger.getLogger(EtudiantController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    //U
    public void setEtudiant(Etudiant old_e, Etudiant new_e){
        try {
            String req = "UPDATE etudiant SET matricule = ?, annee = ?, nom_prenom = ?, date_de_naissance = ?,lieu_de_naissance = ?, nationalite = ?, contact = ?, sexe = ?, options = ?, filiere = ? WHERE matricule = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, new_e.getMatricule());
            preparedStatement.setString(2, new_e.getAnneeScolaire());
            preparedStatement.setString(3, new_e.getNom_prenom());
            preparedStatement.setDate(4, new_e.getDate_de_naissance());
            preparedStatement.setString(5, new_e.getLieu_de_naissance());
            preparedStatement.setString(6, new_e.getNationalite());
            preparedStatement.setString(7, new_e.getContact());
            preparedStatement.setString(8, new_e.getSexe());
            preparedStatement.setString(9, new_e.getOption());
            preparedStatement.setString(10, new_e.getFiliere());
            preparedStatement.setString(11, old_e.getMatricule());
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            error_information();
            Logger.getLogger(EtudiantController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setEtudiant(String old_matricule, String matricule, String annee, String nom_prenom, Date date, String lieu, String nationalite, String contact, String sexe, String option, String filiere){
        try {
            String req = "UPDATE etudiant SET matricule = ?, annee = ?, nom_prenom = ?, date_de_naissance = ?,lieu_de_naissance = ?, nationalite = ?, contact = ?, sexe = ?, options = ?, filiere = ? WHERE matricule = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, matricule);
            preparedStatement.setString(2, annee);
            preparedStatement.setString(3, nom_prenom);
            preparedStatement.setDate(4, date);
            preparedStatement.setString(5, lieu);
            preparedStatement.setString(6, nationalite);
            preparedStatement.setString(7, contact);
            preparedStatement.setString(8, sexe);
            preparedStatement.setString(9, option);
            preparedStatement.setString(10, filiere);
            preparedStatement.setString(11, old_matricule);
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            error_information();
            Logger.getLogger(EtudiantController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //D
    public void removeEtudiant(String matricule){
        try {
            String req = "UPDATE etudiant SET etat = ? WHERE matricule = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setBoolean(1, false);
            preparedStatement.setString(2, matricule);
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            error_information();
            Logger.getLogger(EcController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void removeEtudiant(Etudiant e){
        try {
            String req = "UPDATE etudiant SET etat = ? WHERE matricule = ?";
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setBoolean(1, false);
            preparedStatement.setString(2, e.getMatricule());
            preparedStatement.executeUpdate();
            success_information();
        } catch (SQLException ex) {
            error_information();
            Logger.getLogger(EcController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void success_information() {
        JOptionPane.showMessageDialog(null, "Opération effectuée avec succes ", "Réussie !", JOptionPane.INFORMATION_MESSAGE);
    }
    private void error_information(){
        JOptionPane.showMessageDialog(null, "Opération echouée ", "Echec !", JOptionPane.WARNING_MESSAGE);
    }
}

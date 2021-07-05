/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.Date;

/**
 *
 * @author ATH
 */
public class Professeur {
    private int id;
    private int id_nationalite;
    private String matricule;
    private String nom_prenom;
    private Date date_de_naissance;
    private String lieu_de_naissance;
    private String contact;
    private String titre;
    private String diplome;
    private String sexe;
    private String mot_de_passe;

    public Professeur() {
    }

    /**
     *
     * @param id
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
     * @param actif
     */
    public Professeur(int id, int id_nationalite, String matricule, String nom_prenom, Date date_de_naissance, String lieu_de_naissance, String contact, String titre, String diplome, String sexe, String mot_de_passe) {
        this.id = id;
        this.id_nationalite = id_nationalite;
        this.matricule = matricule;
        this.nom_prenom = nom_prenom;
        this.date_de_naissance = date_de_naissance;
        this.lieu_de_naissance = lieu_de_naissance;
        this.contact = contact;
        this.titre = titre;
        this.diplome = diplome;
        this.sexe = sexe;
        this.mot_de_passe = mot_de_passe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_nationalite() {
        return id_nationalite;
    }

    public void setId_nationalite(int id_nationalite) {
        this.id_nationalite = id_nationalite;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom_prenom() {
        return nom_prenom;
    }

    public void setNom_prenom(String nom_prenom) {
        this.nom_prenom = nom_prenom;
    }

    public Date getDate_de_naissance() {
        return date_de_naissance;
    }

    public void setDate_de_naissance(Date date_de_naissance) {
        this.date_de_naissance = date_de_naissance;
    }

    public String getLieu_de_naissance() {
        return lieu_de_naissance;
    }

    public void setLieu_de_naissance(String lieu_de_naissance) {
        this.lieu_de_naissance = lieu_de_naissance;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDiplome() {
        return diplome;
    }

    public void setDiplome(String diplome) {
        this.diplome = diplome;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }    
}

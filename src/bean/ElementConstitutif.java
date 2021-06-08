/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author ATH
 */
public class ElementConstitutif {
    private int id;
    private int id_unite_enseignement;
    private String sigle;
    private String nom;
    private double vhe;
    private double credit;

    public ElementConstitutif() {
    }

    public ElementConstitutif(int id, int id_unite_enseignement, String sigle, String nom, double vhe, double credit) {
        this.id = id;
        this.id_unite_enseignement = id_unite_enseignement;
        this.sigle = sigle;
        this.nom = nom;
        this.vhe = vhe;
        this.credit = credit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_unite_enseignement() {
        return id_unite_enseignement;
    }

    public void setId_unite_enseignement(int id_unite_enseignement) {
        this.id_unite_enseignement = id_unite_enseignement;
    }

    public String getSigle() {
        return sigle;
    }

    public void setSigle(String sigle) {
        this.sigle = sigle;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getVhe() {
        return vhe;
    }

    public void setVhe(double vhe) {
        this.vhe = vhe;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }
    
}

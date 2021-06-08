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
public class Evaluation {
    private int id;
    private int id_etudiant;
    private int id_annee;
    private int id_element_constitutif;
    private double note;
    private double session;

    public Evaluation() {
    }

    public Evaluation(int id, int id_etudiant, int id_annee, int id_element_constitutif, double note, double session) {
        this.id = id;
        this.id_etudiant = id_etudiant;
        this.id_annee = id_annee;
        this.id_element_constitutif = id_element_constitutif;
        this.note = note;
        this.session = session;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_etudiant() {
        return id_etudiant;
    }

    public void setId_etudiant(int id_etudiant) {
        this.id_etudiant = id_etudiant;
    }

    public int getId_annee() {
        return id_annee;
    }

    public void setId_annee(int id_annee) {
        this.id_annee = id_annee;
    }

    public int getId_element_constitutif() {
        return id_element_constitutif;
    }

    public void setId_element_constitutif(int id_element_constitutif) {
        this.id_element_constitutif = id_element_constitutif;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }

    public double getSession() {
        return session;
    }

    public void setSession(double session) {
        this.session = session;
    }
    
}

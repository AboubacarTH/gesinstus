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
public class AbsenceRetard {
    private int id;
    private int id_etudiant;
    private String absence_retard;
    private Date date;
    private String commentaire;

    public AbsenceRetard() {
    }

    public AbsenceRetard(int id, int id_etudiant, String absence_retard, Date date, String commentaire) {
        this.id = id;
        this.id_etudiant = id_etudiant;
        this.absence_retard = absence_retard;
        this.date = date;
        this.commentaire = commentaire;
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

    public String getAbsence_retard() {
        return absence_retard;
    }

    public void setAbsence_retard(String absence_retard) {
        this.absence_retard = absence_retard;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
    
    
}

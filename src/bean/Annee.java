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
public class Annee {
    private int id;
    private String annee;

    public Annee() {
    }

    public Annee(int id, String annee) {
        this.id = id;
        this.annee = annee;
    }

    public String getAnnee() {
        return annee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }
    
}

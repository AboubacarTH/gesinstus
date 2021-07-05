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
public class Parametre {
    private int id;
    private int id_annee;

    public Parametre() {
    }

    public Parametre(int id, int id_annee) {
        this.id = id;
        this.id_annee = id_annee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_annee() {
        return id_annee;
    }

    public void setId_annee(int id_annee) {
        this.id_annee = id_annee;
    }
    
}

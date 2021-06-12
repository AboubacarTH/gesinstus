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
public class Niveau {
    private int id;
    private int id_option;
    private String niveau;
    private int priorite;

    public Niveau() {
    }

    public Niveau(int id, int id_option, String niveau, int priorite) {
        this.id = id;
        this.id_option = id_option;
        this.niveau = niveau;
        this.priorite = priorite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_option() {
        return id_option;
    }

    public void setId_option(int id_option) {
        this.id_option = id_option;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public int getPriorite() {
        return priorite;
    }

    public void setPriorite(int priorite) {
        this.priorite = priorite;
    }
    
}

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
public class UniteEnseignementOptionTable {
    private int id;
    private int id_unite_enseignement;
    private int id_option;
    private int id_filiere;
    private int id_semestre;

    public UniteEnseignementOptionTable() {
    }

    public int getId() {
        return id;
    }

    public UniteEnseignementOptionTable(int id, int id_unite_enseignement, int id_option, int id_filiere, int id_semestre) {
        this.id = id;
        this.id_unite_enseignement = id_unite_enseignement;
        this.id_option = id_option;
        this.id_filiere = id_filiere;
        this.id_semestre = id_semestre;
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

    public int getId_option() {
        return id_option;
    }

    public void setId_option(int id_option) {
        this.id_option = id_option;
    }

    public int getId_filiere() {
        return id_filiere;
    }

    public void setId_filiere(int id_filiere) {
        this.id_filiere = id_filiere;
    }

    public int getId_semestre() {
        return id_semestre;
    }

    public void setId_semestre(int id_semestre) {
        this.id_semestre = id_semestre;
    }
}

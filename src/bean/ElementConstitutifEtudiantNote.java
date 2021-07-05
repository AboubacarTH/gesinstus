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
public class ElementConstitutifEtudiantNote {
    private int id_etudiant;
    private int id_unite_enseignement_option;
    private int id_element_constitutif;

    public ElementConstitutifEtudiantNote(int id_etudiant, int id_unite_enseignement_option, int id_element_constitutif) {
        this.id_etudiant = id_etudiant;
        this.id_unite_enseignement_option = id_unite_enseignement_option;
        this.id_element_constitutif = id_element_constitutif;
    }

    public int getId_etudiant() {
        return id_etudiant;
    }

    public void setId_etudiant(int id_etudiant) {
        this.id_etudiant = id_etudiant;
    }

    public int getId_unite_enseignement_option() {
        return id_unite_enseignement_option;
    }

    public void setId_unite_enseignement_option(int id_unite_enseignement_option) {
        this.id_unite_enseignement_option = id_unite_enseignement_option;
    }

    public int getId_element_constitutif() {
        return id_element_constitutif;
    }

    public void setId_element_constitutif(int id_element_constitutif) {
        this.id_element_constitutif = id_element_constitutif;
    }
    
}

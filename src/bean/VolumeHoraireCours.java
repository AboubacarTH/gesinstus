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
public class VolumeHoraireCours {
    private int id;
    private int id_element_constitutif;
    private double cm;
    private double td_tp;
    private double stage;

    public VolumeHoraireCours() {
    }

    public VolumeHoraireCours(int id, int id_element_constitutif, double cm, double td_tp, double stage) {
        this.id = id;
        this.id_element_constitutif = id_element_constitutif;
        this.cm = cm;
        this.td_tp = td_tp;
        this.stage = stage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_element_constitutif() {
        return id_element_constitutif;
    }

    public void setId_element_constitutif(int id_element_constitutif) {
        this.id_element_constitutif = id_element_constitutif;
    }

    public double getCm() {
        return cm;
    }

    public void setCm(double cm) {
        this.cm = cm;
    }

    public double getTd_tp() {
        return td_tp;
    }

    public void setTd_tp(double td_tp) {
        this.td_tp = td_tp;
    }

    public double getStage() {
        return stage;
    }

    public void setStage(double stage) {
        this.stage = stage;
    }
    
}

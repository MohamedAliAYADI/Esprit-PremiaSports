/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.entities;

import java.util.Date;

/**
 *
 * @author user
 */
public class Commandes {

    private int id_cmd;
    
    private String etat_cmd;
    private String libelle;
    //private int montantCmd;
    //private produits prod ;

    public Commandes() {
    }

    public Commandes(String etat_cmd, String libelle) {
        this.etat_cmd = etat_cmd;
        this.libelle = libelle;
    }

    public Commandes(String etat_cmd, String libelle, int montantCmd) {
        this.etat_cmd = etat_cmd;
        this.libelle = libelle;
        //this.montantCmd = montantCmd;
    }

    public Commandes(int id_cmd, String etat_cmd, String libelle, int montantCmd) {
        this.id_cmd = id_cmd;
        this.etat_cmd = etat_cmd;
        this.libelle = libelle;
        //this.montantCmd = montantCmd;
    }

    public int getId_cmd() {
        return id_cmd;
    }

    public Commandes(int id_cmd, String etat_cmd) {
        this.id_cmd = id_cmd;
        this.etat_cmd = etat_cmd;
    }

    public void setId_cmd(int id_cmd) {
        this.id_cmd = id_cmd;
    }

    public String getEtat_cmd() {
        return etat_cmd;
    }

    public void setEtat_cmd(String etat_cmd) {
        this.etat_cmd = etat_cmd;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    //public int getMontantCmd() {
        //return montantCmd;

    @Override
    public String toString() {
        return "commandes{" + "id_cmd=" + id_cmd + ", etat_cmd=" + etat_cmd + ", libelle=" + libelle + '}';
    }
    }

    //public void setMontantCmd(int montantCmd) {
        //this.montantCmd = montantCmd;


    
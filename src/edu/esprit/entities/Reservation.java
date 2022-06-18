/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.entities;

/**
 *
 * @author bouss
 */

/**
 *
 * @author bouss
 */
public class Reservation {
    private int idReservation;
    private String DateReservation;
    private int nombredeParticipant;
    private int prix;
    private Promotion prom;

    public Reservation() {
    }

    public Reservation(int idReservation, String DateReservation, int nombredeParticipant, int prix, Promotion prom) {
        this.idReservation = idReservation;
        this.DateReservation = DateReservation;
        this.nombredeParticipant = nombredeParticipant;
        this.prix = prix;
        this.prom = prom;
    }

    public Reservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public Reservation(int idReservation, String DateReservation, int nombredeParticipant, int prix) {
        this.idReservation = idReservation;
        this.DateReservation = DateReservation;
        this.nombredeParticipant = nombredeParticipant;
        this.prix = prix;
    }

     

    
    public Reservation(String DateReservation, int nombredeParticipant, int prix, Promotion prom) {

        this.DateReservation = DateReservation;
        this.nombredeParticipant = nombredeParticipant;
        this.prix = prix;
        this.prom = prom;
    
    }

    public Reservation(String DateReservation, int nombredeParticipant, int prix) {
        this.DateReservation = DateReservation;
        this.nombredeParticipant = nombredeParticipant;
        this.prix = prix;
    }
    

    public Promotion getProm() {
        return prom;
    }

    public void setProm(Promotion prom) {
        this.prom = prom;
    }


    public int getIdReservation() {
        return idReservation;
    }

    public int getNombredeParticipant() {
        return nombredeParticipant;
    }

    public int getPrix() {
        return prix;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public void setDateReservation(String DateReservation) {
        this.DateReservation = DateReservation;
    }

    public String getDateReservation() {
        return DateReservation;
    }

    public void setNombredeParticipant(int nombredeParticipant) {
        this.nombredeParticipant = nombredeParticipant;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "reservation{" + "idReservation=" + idReservation + ", DateReservation=" + DateReservation + ", nombredeParticipant=" + nombredeParticipant + ", prix=" + prix + '}';
    }

    public static int resTotalPrix(Reservation r) {
        return r.getPrix()*r.getNombredeParticipant();
    }
    
}

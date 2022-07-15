
package edu.esprit.entities;


import java.util.Date;

    
public class Reclamation {    private int id;
    private int user_id;
    private String sujet;
    private String  description;
    private String    date;
 
    private String  statut;
    

    public Reclamation() {
        
        
    }

    public Reclamation(String description) {
       
        this.description = description;
       
    }

    public Reclamation(int id, String sujet, String description, String statut) {
        this.id = id;
        this.sujet = sujet;
        this.description = description;
        this.statut = statut;
    }

    public Reclamation(String sujet, String description, String statut) {
        this.sujet = sujet;
        this.description = description;
        this.statut = statut;
    }

    public Reclamation(int id, int user_id, String sujet, String description, String date, String statut) {
        this.id = id;
        this.user_id = user_id;
        this.sujet = sujet;
        this.description = description;
        this.date = date;
        this.statut = statut;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "id=" + id + ", user_id=" + user_id + ", sujet=" + sujet + ", description=" + description + ", date=" + date + ", statut=" + statut + '}';
    }

}
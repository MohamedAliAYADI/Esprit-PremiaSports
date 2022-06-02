/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.entities;

/**
 *
 * @author garbo
 */
public class Terrain {
    
    
    public int id;
    public String nom;
    public String type ;
    public String  adresse ;
    public String infos ;
    public String contact ;

   

    
    public Terrain() {
    }

    public Terrain(String nom, String type, String adresse, String infos,  String contact) {
        this.nom = nom;
        this.type = type;
        this.adresse = adresse;
        this.infos = infos;
    
        this.contact = contact;
    }

    public Terrain(int id, String nom, String type, String adresse, String infos, String contact) {
        this.id = id;
        this.nom = nom;
        this.type = type;
        this.adresse = adresse;
        this.infos = infos;
        this.contact = contact;
    }
    
    



   
    
    
   
   

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setInfos(String infos) {
        this.infos = infos;
    }

    

    public void setConatct(String contact) {
        this.contact = contact;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getType() {
        return type;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getInfos() {
        return infos;
    }

    
    
     public String getConatct() {
        return contact;
    }

    @Override
    public String toString() {
        return "Terrain{" + "id=" + id + ", nom=" + nom + ", type=" + type + ", adresse=" + adresse + ", infos=" + infos + ", contact=" + contact + '}';
    }
   
 
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.entities;

import java.util.Date;

/**
 *
 * @author emy
 */
public class Produits {


    private  int id_prod ;
    private  String nom_prod ;
    
    private String Image_prod;
      private  String prix ;

    public Produits(String nom_prod, String Image_prod, String prix) {
        this.nom_prod = nom_prod;
        this.Image_prod = Image_prod;
        this.prix = prix;
    }

    public Produits() {
    }

    public Produits(int id_prod, String nom_prod, String Image_prod, String prix) {
        this.id_prod = id_prod;
        this.nom_prod = nom_prod;
        this.Image_prod = Image_prod;
        this.prix = prix;
    }

    public Produits(String nom_prod, String prix) {
        this.nom_prod = nom_prod;
        this.prix = prix;
    }

    public Produits(int id_prod, String nom_prod, String prix) {
        this.id_prod = id_prod;
        this.nom_prod = nom_prod;
        this.prix = prix;
    }



    public int getId_prod() {
        return id_prod;
    }

    public void setId_prod(int id_prod) {
        this.id_prod = id_prod;
    }

    public String getNom_prod() {
        return nom_prod;
    }

    public void setNom_prod(String nom_prod) {
        this.nom_prod = nom_prod;
    }

    public String getImage_prod() {
        return Image_prod;
    }

    public void setImage_prod(String Image_prod) {
        this.Image_prod = Image_prod;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Produits{" + "id_prod=" + id_prod + ", nom_prod=" + nom_prod + ", Image_prod=" + Image_prod + ", prix=" + prix + '}';
    }
}

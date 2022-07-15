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

    private int id_prod;
    
    private String nom_prod;
   
    private String reference_prod;
    
     private String description;
    
    private String prix;
    private String quantite;
    private Categories id_catg;
    private String Image_prod;

    public Produits(int id_prod, String nom_prod, String reference_prod, String description, String prix, String quantite, String Image_prod) {
        this.id_prod = id_prod;
        this.nom_prod = nom_prod;
        this.reference_prod = reference_prod;
        this.description = description;
        this.prix = prix;
        this.quantite = quantite;
        this.Image_prod = Image_prod;
    }

    public Produits(int id_prod, String nom_prod, String reference_prod, String description, String prix, String quantite, Categories id_catg, String Image_prod) {
        this.id_prod = id_prod;
        this.nom_prod = nom_prod;
        this.reference_prod = reference_prod;
        this.description = description;
        this.prix = prix;
        this.quantite = quantite;
        this.id_catg = id_catg;
        this.Image_prod = Image_prod;
    }
    
    
    

    public Produits() {
    }

    public Produits(int id_prod, String nom_prod, String reference_prod, String description, String prix, String quantite, Categories id_catg) {
        this.id_prod = id_prod;
        this.nom_prod = nom_prod;
        this.reference_prod = reference_prod;
        this.description = description;
        this.prix = prix;
        this.quantite = quantite;
        this.id_catg = id_catg;
    }

    public Produits(String nom_prod, String reference_prod, String description, String prix, String quantite) {
        this.nom_prod = nom_prod;
        this.reference_prod = reference_prod;
        this.description = description;
        this.prix = prix;
        this.quantite = quantite;
    }

    public Produits(int id_prod, String nom_prod, String reference_prod, String description, String prix, String quantite) {
        this.id_prod = id_prod;
        this.nom_prod = nom_prod;
        this.reference_prod = reference_prod;
        this.description = description;
        this.prix = prix;
        this.quantite = quantite;
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

    public String getReference_prod() {
        return reference_prod;
    }

    public void setReference_prod(String reference_prod) {
        this.reference_prod = reference_prod;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getQuantite() {
        return quantite;
    }

    public void setQuantite(String quantite) {
        this.quantite = quantite;
    }

    public Categories getId_catg() {
        return id_catg;
    }

    public void setId_catg(Categories id_catg) {
        this.id_catg = id_catg;
    }

    public String getImage_prod() {
        return Image_prod;
    }

    public void setImage_prod(String Image_prod) {
        this.Image_prod = Image_prod;
    }

    public Produits(int id_prod, String nom_prod, String description, String prix, String quantite) {
        this.id_prod = id_prod;
        this.nom_prod = nom_prod;
        this.description = description;
        this.prix = prix;
        this.quantite = quantite;
    }

    public Produits(int id_prod, String nom_prod, String description, String prix) {
        this.id_prod = id_prod;
        this.nom_prod = nom_prod;
        this.description = description;
        this.prix = prix;
    }
    
    

}
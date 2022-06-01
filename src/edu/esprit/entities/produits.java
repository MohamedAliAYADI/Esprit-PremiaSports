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
public class produits {
    
    private  int id_prod ;
    private  String nom_prod ;
    
    private String Image_prod;
      private  int prixprod ;

    private categories categories;
    
   private Date DateAjoutProd ;

    public produits() {
    }

    public produits(String nom_prod, String Image_prod) {
        this.nom_prod = nom_prod;
        this.Image_prod = Image_prod;
    }

    public produits(String nom_prod, String Image_prod, int prixprod, categories categories, Date DateAjoutProd) {
        this.nom_prod = nom_prod;
        this.Image_prod = Image_prod;
        this.prixprod = prixprod;
        this.categories = categories;
        this.DateAjoutProd = DateAjoutProd;
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

    public int getPrixprod() {
        return prixprod;
    }

    public void setPrixprod(int prixprod) {
        this.prixprod = prixprod;
    }

    public categories getCategories() {
        return categories;
    }

    public void setCategories(categories categories) {
        this.categories = categories;
    }

    public Date getDateAjoutProd() {
        return DateAjoutProd;
    }

    public void setDateAjoutProd(Date DateAjoutProd) {
        this.DateAjoutProd = DateAjoutProd;
    }

    @Override
    public String toString() {
        return "produits{" + "id_prod=" + id_prod + ", nom_prod=" + nom_prod + ", Image_prod=" + Image_prod + ", prixprod=" + prixprod + ", categories=" + categories + ", DateAjoutProd=" + DateAjoutProd + '}';
    }
}

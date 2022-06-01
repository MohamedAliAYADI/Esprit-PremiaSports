
package edu.esprit.entities;

import java.util.Date;


public class categories {
    private  int id_catg ;
    private String  type ; 
    private String nom_cat ;

    public categories() {
    }

    public categories(String type, String nom_cat) {
        this.type = type;
        this.nom_cat = nom_cat;
    }

    public categories(int id_catg, String type, String nom_cat) {
        this.id_catg = id_catg;
        this.type = type;
        this.nom_cat = nom_cat;
    }

    public int getId_catg() {
        return id_catg;
    }

    public void setId_catg(int id_catg) {
        this.id_catg = id_catg;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNom_cat() {
        return nom_cat;
    }

    public void setNom_cat(String nom_cat) {
        this.nom_cat = nom_cat;
    }

    @Override
    public String toString() {
        return "categories{" + "id_catg=" + id_catg + ", type=" + type + ", nom_cat=" + nom_cat + '}';
    }

}
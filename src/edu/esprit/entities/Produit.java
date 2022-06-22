
package edu.esprit.entities;

public class Produit {

    private int id_produit;
    private int id_categorie;
    private int id_user;
    private String nom;
    private String description;
    private float prix;
    
    private int quantite;

    public Produit(int id_produit, int id_categorie, int id_user, String nom, String description, float prix, int quantite) {
        this.id_produit = id_produit;
        this.id_categorie = id_categorie;
        this.id_user = id_user;
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.quantite = quantite;
    }

    public Produit(int id_categorie, int id_user, String nom, String description, float prix, int quantite) {
        this.id_categorie = id_categorie;
        this.id_user = id_user;
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.quantite = quantite;
    }

    public Produit() {
    }

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public int getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "Produit{" + "id_produit=" + id_produit + ", id_categorie=" + id_categorie + ", id_user=" + id_user + ", nom=" + nom + ", description=" + description + ", prix=" + prix + ", quantite=" + quantite + '}';
    }
}
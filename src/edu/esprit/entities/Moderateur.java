/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.entities;

import java.sql.Date;

/**
 *
 * @author Slimen OUNI
 */
public class Moderateur {
    
       private int id;
    private String pseudo;
    private String password;
    private String nom ;
    private String prenom;
    private Date DOB;
    private String email;
    private String adress;
    private String telephone;
    private String civilite;
    private int genre;
    private int taille;
    private int poids;
    private String profession;
    private String img;
    private int role;

    public Moderateur() {
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public Moderateur(int id, String pseudo, String password, String nom, String prenom, Date DOB, String email, String adress, String telephone, String civilite, int genre, int taille, int poids, String profession, String img, int role) {
        this.id = id;
        this.pseudo = pseudo;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.DOB = DOB;
        this.email = email;
        this.adress = adress;
        this.telephone = telephone;
        this.civilite = civilite;
        this.genre = genre;
        this.taille = taille;
        this.poids = poids;
        this.profession = profession;
        this.img = img;
        this.role=role;
    }

    public Moderateur(String pseudo, String password, String nom, String prenom, Date DOB, String email, String adress, String telephone, String civilite, int genre, int taille, int poids, String profession, String img, int role) {
        this.pseudo = pseudo;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.DOB = DOB;
        this.email = email;
        this.adress = adress;
        this.telephone = telephone;
        this.civilite = civilite;
        this.genre = genre;
        this.taille = taille;
        this.poids = poids;
        this.profession = profession;
        this.img = img;
        this.role=role;
    }

    public Moderateur(String pseudo, String password, String nom, String prenom) {
        this.pseudo = pseudo;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCivilite() {
        return civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    public int getGenre() {
        return genre;
    }

    public void setGenre(int genre) {
        this.genre = genre;
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public int getPoids() {
        return poids;
    }

    public void setPoids(int poids) {
        this.poids = poids;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Moderateur{" + "id=" + id + ", pseudo=" + pseudo + ", password=" + password + ", nom=" + nom + ", prenom=" + prenom + ", DOB=" + DOB + ", email=" + email + ", adress=" + adress + ", telephone=" + telephone + ", civilite=" + civilite + ", genre=" + genre + ", taille=" + taille + ", poids=" + poids + ", profession=" + profession + ", img=" + img + '}';
    }
    
    
    
    
    
}

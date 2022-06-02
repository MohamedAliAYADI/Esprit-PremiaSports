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
public class Avis {
    
    private int id ;
    private String commentaire ;
    private int note ;

    public Avis() {
    }

    public Avis(String commentaire, int note) {
        this.commentaire = commentaire;
        this.note = note;
    }

    public Avis(int id, String commentaire, int note) {
        this.id = id;
        this.commentaire = commentaire;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Avis{" + "id=" + id + ", commentaire=" + commentaire + ", note=" + note + '}';
    }
    
}



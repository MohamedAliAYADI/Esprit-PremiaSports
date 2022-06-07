/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.entities;

/**
 *
 * @author nemya
 */
public class Participation {
    private int idParticipation;
    public  String comment;
    private Event event;
    public Participation(){
        
    }

    public Participation(int idParticipation,String comment, Event event) {
        this.idParticipation = idParticipation;
        this.comment=comment;
        this.event = event;
    }

    public Participation(String comment,Event event) {
        this.comment=comment;
        this.event = event;
    }

    public int getIdParticipation() {
        return idParticipation;
    }

    public String getComment() {
        return comment;
    }
    

    public Event getEvent() {
        return event;
    }

    public void setIdParticipation(int idParticipation) {
        this.idParticipation = idParticipation;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    
    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "Participation{" + "idParticipation=" + idParticipation + ", comment=" + comment + ", event=" + event + '}';
    }
   
    
}

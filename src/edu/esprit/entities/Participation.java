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
    private Event event;

    public Participation(int idParticipation, Event event) {
        this.idParticipation = idParticipation;
        this.event = event;
    }

    public Participation(Event event) {
        this.event = event;
    }

    public int getIdParticipation() {
        return idParticipation;
    }

    public Event getEvent() {
        return event;
    }

    public void setIdParticipation(int idParticipation) {
        this.idParticipation = idParticipation;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
   
    
}

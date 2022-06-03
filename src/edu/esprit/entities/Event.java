/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.entities;

public class Event {
    private int eventId;
    private String eventTitle;
    private String eventDescription;
    private String startDate;
    private String endDate;
      public Event() {
    }

    public Event(int eventId, String eventTitle, String eventDescription, String startDate, String endDate) {
        this.eventId = eventId;
        this.eventTitle = eventTitle;
        this.eventDescription = eventDescription;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Event(String eventTitle, String eventDescription, String startDate, String endDate) {
        this.eventTitle = eventTitle;
        this.eventDescription = eventDescription;
        this.startDate = startDate;
        this.endDate = endDate;
    }

  

    public int getEventId() {
        return eventId;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Event{" + "eventId=" + eventId + ", eventTitle=" + eventTitle + ", eventDescription=" + eventDescription + ", startDate=" + startDate + ", endDate=" + endDate + '}';
    }
    
    
    
    
    
}


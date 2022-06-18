/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.entities;

import java.util.List;

/**
 *
 * @author k.saidani
 */
public class Clubs {
    private int id;
    private String name;
    private String adress;
    private String phone_Number;
    //private String activities;
    private List<Activity> activities;

    public Clubs() {
    }

    public Clubs(String name, String adress, String phone_Number, List<Activity> activities) {
        this.name = name;
        this.adress = adress;
        this.phone_Number = phone_Number;
        this.activities = activities;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    
    

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

  

    public String getPhone_Number() {
        return phone_Number;
    }

    public void setPhone_Number(String phone_Number) {
        this.phone_Number = phone_Number;
    }

    @Override
    public String toString() {
        return "Clubs{" + "id=" + id + ", name=" + name + ", adress=" + adress + ", phone_Number=" + phone_Number + ", activities=" + activities + '}';
    }

 

    
    
}

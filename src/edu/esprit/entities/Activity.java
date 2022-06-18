/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.entities;

/**
 *
 * @author k.saidani
 */
public class Activity {
    private int idActivity;
    private String nomActivity;

    public Activity() {
    }
   

    public Activity(int idActivity, String nomActivity) {
        this.idActivity = idActivity;
        this.nomActivity = nomActivity;
        
    }

        public Activity(String nomActivity) {
        this.nomActivity = nomActivity;
   
    }

    public int getIdActivity() {
        return idActivity;
    }

    public void setIdActivity(int idActivity) {
        this.idActivity = idActivity;
    }

    public String getNomActivity() {
        return nomActivity;
    }

    public void setNomActivity(String nomActivity) {
        this.nomActivity = nomActivity;
    }

   

    @Override
    public String toString() {
        return "Activity{" + "idActivity=" + idActivity + ", nomActivity=" + nomActivity +  '}';
    }
    
        
    
}

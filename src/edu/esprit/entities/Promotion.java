/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.entities;

/**
 *
 * @author bouss
 */

public class Promotion {

    public int idPromotion;
    private String type;
    private Float promo;
    

    public Promotion() {
        
    }

    public Promotion(String type,Float promo) {
        this.type = type;
        this.promo=promo;
    }
    

    public Promotion(int idPromotion, String type,Float promo) {
        this.idPromotion = idPromotion;
        this.type = type;
        this.promo=promo;
    }

    public int getIdPromotion() {
        return idPromotion;
    }

    public String getType() {
        return type;
    }

    public double getPromo() {
        return promo;
    }
    

    public void setIdPromotion(int idPromotion) {
        this.idPromotion = idPromotion;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPromo(Float promo) {
        this.promo = promo;
    }

    @Override
    public String toString() {
        return "Promotion{" + "idPromotion=" + idPromotion + ", type=" + type + ", promo=" + promo + '}';
    }
    
}

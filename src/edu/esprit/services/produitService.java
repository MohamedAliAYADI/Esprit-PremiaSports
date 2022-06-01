/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;

import edu.esprit.entities.categories;
import edu.esprit.services.categorieService;
import edu.esprit.entities.produits;
import edu.esprit.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



public class produitService {

    Connection cnx = MyConnection.getInstance().getCnx();

    public produits ajouterproduits(produits p) { 

        
        try {
            String req = "INSERT INTO `produits`( `nom_prod`, `image_prod`, `prix`) VALUES (?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, p.getNom_prod());
            ps.setString(2, p.getImage_prod());
            ps.setInt(3, p.getPrixprod());

            ps.executeUpdate();
            System.out.println("prodle added successfully!");
        }

         catch (SQLException ex) {
            Logger.getLogger(categorieService.class.getName()).log(Level.SEVERE, null, ex); 
           
           }
        return p ;
        
        
    }
    public produits getCategoryByID(int id){
        
        produits p = new produits ();
        
        try {
            String req = "SELECT * FROM `produits` WHERE id_catg = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {                
                p.setId_prod(rs.getInt(1));
                p.setNom_prod(rs.getString(2));
                p.setImage_prod(rs.getString(3));
                p.setPrixprod(rs.getInt(4));
               
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(categorieService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return p;
    
    
    
}
    public produits effacerProduit (){
         produits c = new produits ();
          try {
           
            String req = " DELETE FROM `produits` WHERE `nom_cat` ='informatique' ";
            
            PreparedStatement statement = cnx.prepareStatement(req);
            
           
            try {
                statement.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(categorieService.class.getName()).log(Level.SEVERE, null, ex);
            }
 
                System.out.println("Produits Supprimé avec succé");}
         catch (SQLException ex) {
            Logger.getLogger(categorieService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c ;
 }}
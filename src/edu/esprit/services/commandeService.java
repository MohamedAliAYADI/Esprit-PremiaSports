/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;


import edu.esprit.entities.categories;
import edu.esprit.entities.commandes;
import edu.esprit.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;







public class commandeService {

    Connection cnx = MyConnection.getInstance().getCnx();
     public commandes ajouterCommande (commandes c) { 
         
     
        try {
            String req = "INSERT INTO `commandes`(`etat_cmd`, `libelle`)VALUES (?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, c.getEtat_cmd());
            ps.setString(2, c.getLibelle());

            ps.executeUpdate();
            System.out.println("commandes added successfully!");
            
 }

         catch (SQLException ex) {
            Logger.getLogger(commandeService.class.getName()).log(Level.SEVERE, null, ex); 
           
           }
        return c ;
        
        
    }
    public commandes getCategoryByID(int id){
        
        commandes c = new commandes  ();
        
        try {
            String req = "SELECT * FROM `commandes` WHERE id_cmd = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {                
                c.setId_cmd(rs.getInt(1));
                c.setLibelle(rs.getString(2));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(categorieService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return c;
    
    }
 public categories effacecommande (){
       
       categories c = new categories ();
        try {
           
            String req = " DELETE FROM `commande` WHERE `libelle` ='Informatique' ";
            
            PreparedStatement statement = cnx.prepareStatement(req);
            
            
           
            try {
                statement.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(categorieService.class.getName()).log(Level.SEVERE, null, ex);
            }
           
                System.out.println("Commandes Supprimé avec succé");}
         catch (SQLException ex) {
            Logger.getLogger(categorieService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c ;
        
 }

}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;



import edu.esprit.entities.categories;
import edu.esprit.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class categorieService {

    Connection cnx = MyConnection.getInstance().getCnx();

    public categories ajouterCategories(categories c) { 

        
        try {
            String req = "INSERT INTO `categories`( `type`, `nom_cat`) VALUES (?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, c.getType());
            ps.setString(2, c.getNom_cat());

            ps.executeUpdate();
            System.out.println("categorie ajouté avec succé!");
        }

         catch (SQLException ex) {
            Logger.getLogger(categorieService.class.getName()).log(Level.SEVERE, null, ex); 
           
           }
        return c ;
        
        
    }
    public categories getCategoryByID(int id){
        
        categories c = new categories ();
        
        try {
            String req = "SELECT * FROM `categories` WHERE id_catg = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {                
                c.setId_catg(rs.getInt(1));
                c.setNom_cat(rs.getString(2));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(categorieService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return c;
    
    
    
}
 public categories select (int id  , int idd  ){
        
        categories c = new categories ();
        
        try {
            String req = "SELECT * FROM `categories`";
            PreparedStatement ps = cnx.prepareStatement(req);
           
            ResultSet result = ps.executeQuery();
           
while (result.next()){
    String type = result.getString(2);
    String nom_cat = result.getString(3);
      //String LocalDate  = result.getDate(LocalDate.now() ); 

    
     

  
   
   
               
    System.out.println ("le nom de la categories est " +nom_cat+""  );
    System.out.println ("le type de la categorie est  " +type+""  );
     //System.out.println ("la date d'ajout est  " +LocalDate+""  );
          
    
}
            
            
        } catch (SQLException ex) {
            Logger.getLogger(categorieService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return c;
    


}


 public categories effacer (){
       
       categories c = new categories ();
        try {
           
            String req = " DELETE FROM `categories` WHERE `nom_cat` ='ballon' ";
            
            PreparedStatement statement = cnx.prepareStatement(req);
            
            
           
            try {
                statement.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(categorieService.class.getName()).log(Level.SEVERE, null, ex);
            }
           
                System.out.println("Categorie Supprimé avec succé");}
         catch (SQLException ex) {
            Logger.getLogger(categorieService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c ;
 }

 
 

  public categories updatecat (){
       
       categories c = new categories ();
        try {
           
            String req = " UPDATE `categories` SET nom_cat='UPDAAAAAAATETEST'  WHERE `type` ='tennis' ";
            
            PreparedStatement statement = cnx.prepareStatement(req);
            
            
           
            try {
                statement.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(categorieService.class.getName()).log(Level.SEVERE, null, ex);
            }
           
                System.out.println("Categorie Supprimé avec succé");}
         catch (SQLException ex) {
            Logger.getLogger(categorieService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c ;
 }
 
 
}

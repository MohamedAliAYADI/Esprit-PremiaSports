
package edu.esprit.services;
import edu.esprit.entities.Categories;
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

public class CategorieService {

    Connection cnx = MyConnection.getInstance().cnx;
    
//*INSERT**************************************************************
    public void insertCategories(Categories c) { 

        try {
            String req = "INSERT INTO `categories`(`type`, `nom_cat`) VALUES (?,?)";
            
            PreparedStatement ps = cnx.prepareStatement(req);
            
            ps.setString(1, c.getType());
            ps.setString(2, c.getNom_cat());

            ps.executeUpdate();
            System.out.println("Categorie ajouté !");
        }

         catch (SQLException ex) {
            Logger.getLogger(CategorieService.class.getName()).log(Level.SEVERE, null, ex); 
           
           }

    }
    
    //***********************GETBY ID CATEGORIES ************************
    
    public Categories getCategoryByID(int id){
       
        Categories c = new Categories();
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
            Logger.getLogger(CategorieService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return c;
   
}
   //SELECT ALL **************************CATEGORIES 
    //*************************************************//
    
 public Categories selectall (){
        
        Categories c = new Categories ();
        
        try {
            String req = "SELECT * FROM `categories`";
            PreparedStatement ps = cnx.prepareStatement(req);
           
            ResultSet result = ps.executeQuery();
           
while (result.next()){
    String type = result.getString(2);
    String nom_cat = result.getString(3);
            
    System.out.println ("le nom de la categories est " +nom_cat+""  );
    System.out.println ("le type de la categorie est  " +type+""  );
    
          
    
}
            
            
        } catch (SQLException ex) {
            Logger.getLogger(CategorieService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return c;
    


}


 //**************UPDATE CATEGORIES ************************************************
 

  public void updatecat (Categories c){
       
     
       
        try {
           
            String req = "UPDATE `categories` SET `nom_cat` = ?  WHERE `id_Catg` = ?";
            
            PreparedStatement statement = cnx.prepareStatement(req);
            statement.setString(1, c.getNom_cat());
            statement.setInt(2, c.getId_catg());
            statement.executeUpdate();
            
           
        
           
                System.out.println("Categorie est a jour avec succé");
        }
         catch (SQLException ex) {
            Logger.getLogger(CategorieService.class.getName()).log(Level.SEVERE, null, ex);
        }
     
 }
 
 
//****************Delete CATEGORIES 

  public Categories DeleteCategories (Categories c){
       
    
       
        try {
           
            String req = " DELETE FROM `categories` WHERE `id_Catg` =? ";
            
            PreparedStatement statement = cnx.prepareStatement(req);
            //statement.setString(1, c.getNom_cat());
            statement.setInt(1, c.getId_catg());
            statement.executeUpdate();
            
           
        
           
                System.out.println("Categorie supprimé avec  succé");
        }
         catch (SQLException ex) {
            Logger.getLogger(CategorieService.class.getName()).log(Level.SEVERE, null, ex);
        }
         return c ;
     
 }
 
 
}

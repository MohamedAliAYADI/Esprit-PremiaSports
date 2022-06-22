
package edu.esprit.services;


import edu.esprit.entities.Categories;
import edu.esprit.entities.Commandes;
import edu.esprit.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;




public class CommandeService {

    Connection cnx = MyConnection.getInstance().cnx;
    public Commandes insertCommandes (Commandes c) { 
         
     
        try {
            String req = "INSERT INTO `commandes`(`etat_cmd`, `libelle`)VALUES (?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, c.getEtat_cmd());
            ps.setString(2, c.getLibelle());

            ps.executeUpdate();
            System.out.println("commandes ajouté avec succé !");
            
 }

         catch (SQLException ex) {
            Logger.getLogger(CommandeService.class.getName()).log(Level.SEVERE, null, ex); 
           
           }
        return c ;
        
        
    }
    public Commandes getCategoryByID(Commandes cmd){
        
        
        try {
            String req = "SELECT * FROM `commandes` WHERE id_cmd = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, cmd.getId_cmd());
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {                
                cmd.setId_cmd(rs.getInt(1));
                cmd.setLibelle(rs.getString(2));
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(CategorieService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cmd;
    
    }

 
  public void updatecommande (Commandes c){
       
     
       
        try {
           
            String req = "UPDATE `commandes` SET `etat_cmd` = ?  WHERE `id_cmd` = ?";
            
            PreparedStatement statement = cnx.prepareStatement(req);
            statement.setString(1, c.getEtat_cmd());
            statement.setInt(2, c.getId_cmd());
            statement.executeUpdate();
            
           
        
           
                System.out.println("Commandes mise à jour avec succé");
        }
         catch (SQLException ex) {
            Logger.getLogger(CategorieService.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        
        
        
        
 }
      
 public Commandes selectAllaCommandes (){
        
        Commandes cmd = new Commandes ();
        
        try {
            String req = "SELECT * FROM `commandes`";
            PreparedStatement ps = cnx.prepareStatement(req);
           
            ResultSet result = ps.executeQuery();
           
while (result.next()){
    String etat_cmd= result.getString(2);
    String libelle = result.getString(3);
            
    System.out.println ("l'etat de la commandes " +etat_cmd+""  );
    System.out.println (" Libelle  " +libelle+""  );

}
      
        } catch (SQLException ex) {
            Logger.getLogger(CategorieService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cmd;
    


}

 
 
 
 
 
 
  public Commandes DeleteCommandes (Commandes c){
       
    
       
        try {
           
            String req = " DELETE FROM `commandes` WHERE `id_cmd` =? ";
            
            PreparedStatement statement = cnx.prepareStatement(req);
           
            statement.setInt(1, c.getId_cmd());
            statement.executeUpdate();
            
           
        
           
                System.out.println("Commandes supprimé avec  succé");
        }
         catch (SQLException ex) {
            Logger.getLogger(CategorieService.class.getName()).log(Level.SEVERE, null, ex);
        }
         return c ;
     
 }
 
}
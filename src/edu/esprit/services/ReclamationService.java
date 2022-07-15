package edu.esprit.services;

import edu.esprit.entities.Categories;
import edu.esprit.entities.Reclamation;
import edu.esprit.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static jdk.nashorn.internal.objects.NativeJava.type;

public class ReclamationService {

    Connection cnx = MyConnection.getInstance().cnx;

//*INSERT**************************************************************
    public void insertReclamation(Reclamation c) {

        try {
            String req = "INSERT INTO `reclamation`(`sujet`, `description`) VALUES (?,?)";

            PreparedStatement ps = cnx.prepareStatement(req);
 ps.setString(1, c.getSujet());
            ps.setString(2, c.getDescription());
    

            ps.executeUpdate();
            System.out.println("Reclamation ajouté !");
        } catch (SQLException ex) {
            Logger.getLogger(CategorieService.class.getName()).log(Level.SEVERE, null, ex);

        }
    }
        
        
        
          public List<Reclamation> selectall() {

        List<Reclamation> list = new ArrayList<Reclamation>();

        try {
            String req = "SELECT * FROM `reclamation`";
            PreparedStatement ps = cnx.prepareStatement(req);
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                int id = result.getInt(1);
                String sujet = result.getString(2);
                String description = result.getString(3);
                                String statut = result.getString(4);

                list.add(new Reclamation(id, sujet, description, statut));
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(CategorieService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;

    }
  public Reclamation Delete(Reclamation c) {

        try {

            String req = " DELETE FROM `reclamation` WHERE `id` =? ";

            PreparedStatement statement = cnx.prepareStatement(req);
            statement.setInt(1, c.getId());
            statement.executeUpdate();

            System.out.println("reclamation supprimé avec  succé");
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;

    }
 public void Update(Reclamation p)  {
         try {
            String req = "UPDATE `reclamation`"+" SET `statut`=?"+" WHERE id=?";
            PreparedStatement ps;
            ps = cnx.prepareStatement(req);
           
            ps.setString(1, p.getStatut());
           
             ps.setInt(2, p.getId());
            ps.executeUpdate();
            System.out.println("modifier avec succes");
        } catch (SQLException ex) {
            Logger.getLogger(Reclamation.class.getName()).log(Level.SEVERE, null, ex);
        
        

     }   
         
    }

}
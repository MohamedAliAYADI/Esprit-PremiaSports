/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;

import edu.esprit.entities.Client;
import edu.esprit.entities.User;
import edu.esprit.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Slimen OUNI
 */
public class ModerateurService implements UserServicesInterface{

        Connection cnx = MyConnection.getInstance().getCnx();

    @Override
    public void addUser(Object o) {
      Client c;
         c = (Client)o;
                   try {
            String req = "INSERT INTO `moderateur`(`nom`, `prenom`) VALUES (?,?)";

            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, c.getNom());
            ps.setString(2, c.getPrenom());
            ps.executeUpdate();

            System.out.println("User "
                    + c.getNom()+ " added successfully" );

        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public void updateUser(Object o, int id) {
        Client c;
         c = (Client)o;
                 try {
              
              String sql = "UPDATE `moderateur` SET `nom`= ? ,`prenom`= ?  WHERE id = ?";
           PreparedStatement ps = cnx.prepareStatement(sql);
           ps.setString(1, c.getNom());
           ps.setString(2, c.getPrenom());
           ps.setInt(3, id);
            ps.executeUpdate();
                     System.out.println("User "+ c.getNom() +" Updated successfully");
             
       } catch (SQLException ex) {
           System.out.println("error updating" + ex);
       }

    }

    @Override
    public void removeUser(int id) {
       try {
           String q1 = "DELETE FROM moderateur WHERE id = ?";
           PreparedStatement prepDelete = cnx.prepareStatement(q1);
           prepDelete.setInt(1, id);
           prepDelete.execute();
           System.out.println("User Deleted Successfully" );
       } catch (SQLException ex) {
           System.out.println("error deleting" + ex );
       }

    }

    @Override
    public List<Object> listUsers() {
             List clients = new ArrayList<>();
        
        try {

            String req = "SELECT * FROM moderateur";

            PreparedStatement ps = cnx.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                
                Client c = new Client();
                c.setId(rs.getInt(1));
                c.setPseudo(rs.getString("nom"));
                c.setPassword(rs.getString("prenom"));
                System.out.println("adding");
                clients.add(c);
                
            }

        } catch (SQLException ex) {
            System.out.println("error adding " + ex );
            }

        return clients;  
    }

    
    public Object listUsersById(int id) {
            Client c = new Client();
        try {
            String req = "SELECT * FROM moderateur where id = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                c.setId(rs.getInt(1));
                c.setPseudo(rs.getString("nom"));
                c.setPassword(rs.getString("prenom"));
                                   }
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }


        
        return c;




    }

   

   
}

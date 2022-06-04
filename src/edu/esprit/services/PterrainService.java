/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;

import edu.esprit.entities.Client;
import edu.esprit.entities.Pterrain;
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
public class PterrainService implements UserServicesInterface{

    Connection cnx = MyConnection.getInstance().getCnx();

    @Override
    public void addUser(Object o) {
      Pterrain pt;
         pt = (Pterrain)o;
                   try {
            String req = "INSERT INTO `pterrain`(`pseudo`, `nom` , `prenom` , `password`) VALUES (?,?,?,?)";

            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, pt.getNom());
            ps.setString(2, pt.getPrenom());
            ps.executeUpdate();

            System.out.println("User "
                    + pt.getNom()+ " added successfully" );

        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    public void updateUser(Object o) {
       Pterrain pt;
         pt = (Pterrain)o;
                 try {
              
              String sql = "UPDATE `pterrain` SET `pseudo`= ?,`password`= ? ,`nom`= ? ,`prenom`= ?  WHERE id = ?";
           PreparedStatement ps = cnx.prepareStatement(sql);
            ps.setString(1, pt.getPseudo());
           ps.setString(2, pt.getPassword());
           ps.setString(3, pt.getNom());
           ps.setString(4, pt.getPrenom());
           ps.setInt(5, pt.getId());
            ps.executeUpdate();
                     System.out.println("User "+ pt.getNom() +" Updated successfully");
             
       } catch (SQLException ex) {
           System.out.println("error updating" + ex);
       }

    }

    @Override
    public void removeUser(Object o) {
         Pterrain pt;
         pt = (Pterrain)o;
       try {
           String q1 = "DELETE FROM pterrain WHERE id = ?";
           PreparedStatement prepDelete = cnx.prepareStatement(q1);
           prepDelete.setInt(1, pt.getId());
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

            String req = "SELECT * FROM pterrain";

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

    
    @Override
    public Object listUsersById(Object o) {
            Pterrain pt;
         pt = (Pterrain)o;
        try {
            String req = "SELECT * FROM pterrain where id = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, pt.getId());
            ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                pt.setId(rs.getInt(1));
                pt.setPseudo(rs.getString("nom"));
                pt.setPassword(rs.getString("prenom"));
                                   }
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }


        
        return pt;




    }

   

   
}

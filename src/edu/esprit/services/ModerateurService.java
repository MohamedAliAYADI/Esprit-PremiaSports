/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;

import edu.esprit.entities.Client;
import edu.esprit.entities.Moderateur;
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
      Moderateur m;
         m = (Moderateur)o;
                   try {
            String req = "INSERT INTO `moderateur`(`pseudo`, `nom` , `prenom` , `password`) VALUES (?,?,?,?)";

            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, m.getPseudo());
            ps.setString(2, m.getNom());
            ps.setString(3, m.getPrenom());
            ps.setString(4, m.getPassword());
            ps.executeUpdate();

            System.out.println("moderateur "
                    + m.getNom()+ " added successfully" );

        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
        @Override
    public void updateUser(Object o, int id) {
        Moderateur m;
         m = (Moderateur)o;
                 try {
              
              String sql = "UPDATE `moderateur` SET `pseudo`= ?,`password`= ? ,`nom`= ? ,`prenom`= ?  WHERE id = ?";
           PreparedStatement ps = cnx.prepareStatement(sql);
            ps.setString(1, m.getPseudo());
           ps.setString(2, m.getPassword());
           ps.setString(3, m.getNom());
           ps.setString(4, m.getPrenom());
           ps.setInt(5, id);
            ps.executeUpdate();
                     System.out.println("moderateur "+ m.getNom() +" Updated successfully");
             
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
           System.out.println("moderateur Deleted Successfully" );
       } catch (SQLException ex) {
           System.out.println("error deleting" + ex );
       }

    }

    @Override
    public List<Object> listUsers() {
             List mods = new ArrayList<>();
        
        try {

            String req = "SELECT * FROM moderateur";

            PreparedStatement ps = cnx.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                
                Moderateur m = new Moderateur();
                m.setId(rs.getInt(1));
                m.setPseudo(rs.getString("nom"));
                m.setPassword(rs.getString("prenom"));
                System.out.println("adding");
                mods.add(m);
                
            }

        } catch (SQLException ex) {
            System.out.println("error adding " + ex );
            }

        return mods;  
    }

    
        @Override
    public Object listUsersById(int id) {
            Moderateur m = new Moderateur();
        try {
            String req = "SELECT * FROM moderateur where id = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                m.setId(rs.getInt(1));
                m.setPseudo(rs.getString("nom"));
                m.setPassword(rs.getString("prenom"));
                                   }
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }


        
        return m;




    }

   

   
}

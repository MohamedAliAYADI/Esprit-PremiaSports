/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;

import edu.esprit.entities.Coach;
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
public class CoachService implements UserServicesInterface{

           MyConnection cn= MyConnection.getInstance();

    @Override
    public void addUser(Object o) {
      Coach c;
         c = (Coach)o;
         try {
            String req = "INSERT INTO `coach`(`pseudo`, `password`, `nom`, "
                    + "`prenom`, `dob`, `email`, `adress`, `telephone`, "
                    + "`civilite`, `genre`, `taille`, `poids`, `profession`, "
                    + "`role`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement ps = cn.cnx.prepareStatement(req);
            ps.setString(1, c.getPseudo());
            ps.setString(2, c.getPassword());
            ps.setString(3, c.getNom());
            ps.setString(4, c.getPrenom());
            ps.setString(5, c.getDOB().toString());
            ps.setString(6, c.getEmail());
            ps.setString(7, c.getAdress());
            ps.setString(8, c.getTelephone());
            ps.setString(9, c.getCivilite());
            ps.setInt(10, c.getGenre());
            ps.setInt(11, c.getTaille());
            ps.setInt(12, c.getPoids());
            ps.setString(13, c.getProfession());
            ps.setInt(14, c.getRole());
            ps.executeUpdate();

            System.out.println("Coach "
                    + c.getNom()+ " added successfully" );

        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    public void updateUser(Object o) {
        Coach c;
         c = (Coach)o;
                 try {
              
              String sql = "UPDATE `coach` SET `pseudo`= ?,`password`= ? ,`nom`= ? ,`prenom`= ?  WHERE id = ?";
           PreparedStatement ps = cn.cnx.prepareStatement(sql);
           ps.setString(1, c.getPseudo());
           ps.setString(2, c.getPassword());
           ps.setString(3, c.getNom());
           ps.setString(4, c.getPrenom());
           ps.setInt(5, c.getId());
            ps.executeUpdate();
                     System.out.println("Coach "+ c.getNom() +" Updated successfully");
             
       } catch (SQLException ex) {
           System.out.println("error updating" + ex);
       }

    }

    @Override
    public void removeUser(Object o) {
         Coach c;
         c = (Coach)o;
       try {
           String q1 = "DELETE FROM coach WHERE id = ?";
           PreparedStatement prepDelete = cn.cnx.prepareStatement(q1);
           prepDelete.setInt(1, c.getId());
           prepDelete.execute();
           System.out.println("Coach Deleted Successfully" );
       } catch (SQLException ex) {
           System.out.println("error deleting" + ex );
       }

    }

    @Override
    public List<Object> listUsers() {
             List coachs = new ArrayList<>();
        
        try {

            String req = "SELECT * FROM coach";

            PreparedStatement ps = cn.cnx.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                
                Coach c = new Coach();
                c.setId(rs.getInt(1));
                c.setPseudo(rs.getString("nom"));
                c.setPassword(rs.getString("prenom"));
                System.out.println("adding");
                coachs.add(c);
                
            }

        } catch (SQLException ex) {
            System.out.println("error adding " + ex );
            }

        return coachs;  
    }

    
    @Override
    public Object listUsersById(Object o) {
            Coach c = new Coach();
        try {
            String req = "SELECT * FROM coach where id = ?";
            PreparedStatement ps = cn.cnx.prepareStatement(req);
            ps.setInt(1, c.getId());
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

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

           MyConnection cn= MyConnection.getInstance();

    @Override
    public void addUser(Object o) {
      Pterrain pt;
         pt = (Pterrain)o;
          try {
            String req = "INSERT INTO `pterrain`(`pseudo`, `password`, `nom`, "
                    + "`prenom`, `dob`, `email`, `adress`, `telephone`, "
                    + "`civilite`, `genre`, `taille`, `poids`, `profession`, "
                    + "`role`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement ps = cn.cnx.prepareStatement(req);
            ps.setString(1, pt.getPseudo());
            ps.setString(2, pt.getPassword());
            ps.setString(3, pt.getNom());
            ps.setString(4, pt.getPrenom());
            ps.setString(5, pt.getDOB().toString());
            ps.setString(6, pt.getEmail());
            ps.setString(7, pt.getAdress());
            ps.setString(8, pt.getTelephone());
            ps.setString(9, pt.getCivilite());
            ps.setInt(10, pt.getGenre());
            ps.setInt(11, pt.getTaille());
            ps.setInt(12, pt.getPoids());
            ps.setString(13, pt.getProfession());
            ps.setInt(14, pt.getRole());
            ps.executeUpdate();

            System.out.println("pterrain "
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
           PreparedStatement ps = cn.cnx.prepareStatement(sql);
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
           PreparedStatement prepDelete = cn.cnx.prepareStatement(q1);
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

            PreparedStatement ps = cn.cnx.prepareStatement(req);
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
            PreparedStatement ps = cn.cnx.prepareStatement(req);
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

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

           MyConnection cn= MyConnection.getInstance();

    @Override
    public void addUser(Object o) {
      Moderateur m;
         m = (Moderateur)o;
          try {
            String req = "INSERT INTO `moderateur`(`pseudo`, `password`, `nom`, "
                    + "`prenom`, `dob`, `email`, `adress`, `telephone`, "
                    + "`civilite`, `genre`, `taille`, `poids`, `profession`, "
                    + "`role`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement ps = cn.cnx.prepareStatement(req);
            ps.setString(1, m.getPseudo());
            ps.setString(2, m.getPassword());
            ps.setString(3, m.getNom());
            ps.setString(4, m.getPrenom());
            ps.setString(5, m.getDOB().toString());
            ps.setString(6, m.getEmail());
            ps.setString(7, m.getAdress());
            ps.setString(8, m.getTelephone());
            ps.setString(9, m.getCivilite());
            ps.setInt(10, m.getGenre());
            ps.setInt(11, m.getTaille());
            ps.setInt(12, m.getPoids());
            ps.setString(13, m.getProfession());
            ps.setInt(14, m.getRole());
            ps.executeUpdate();

            System.out.println("Moderator "
                    + m.getNom()+ " added successfully" );

        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
        @Override
    public void updateUser(Object o) {
        Moderateur m;
         m = (Moderateur)o;
                 try {
              
              String sql = "UPDATE `moderateur` SET `pseudo`= ?,`password`= ? ,`nom`= ? ,`prenom`= ?  WHERE id = ?";
           PreparedStatement ps = cn.cnx.prepareStatement(sql);
            ps.setString(1, m.getPseudo());
           ps.setString(2, m.getPassword());
           ps.setString(3, m.getNom());
           ps.setString(4, m.getPrenom());
           ps.setInt(5, m.getId());
            ps.executeUpdate();
                     System.out.println("moderateur "+ m.getNom() +" Updated successfully");
             
       } catch (SQLException ex) {
           System.out.println("error updating" + ex);
       }

    }

    @Override
    public void removeUser(Object o) {
         Moderateur m;
         m = (Moderateur)o;
       try {
           String q1 = "DELETE FROM moderateur WHERE id = ?";
           PreparedStatement prepDelete = cn.cnx.prepareStatement(q1);
           prepDelete.setInt(1, m.getId());
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

            PreparedStatement ps = cn.cnx.prepareStatement(req);
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
    public Object listUsersById(Object o) {
            Moderateur m = new Moderateur();
        try {
            String req = "SELECT * FROM moderateur where id = ?";
            PreparedStatement ps = cn.cnx.prepareStatement(req);
            ps.setInt(1, m.getId());
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

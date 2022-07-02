/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;

import edu.esprit.entities.Pclub;
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
public class PclubService implements UserServicesInterface{

           MyConnection cn= MyConnection.getInstance();

    @Override
    public void addUser(Object o) {
      Pclub pc;
         pc = (Pclub)o;
           try {
            String req = "INSERT INTO `pclub`(`pseudo`, `password`, `nom`, "
                    + "`prenom`, `dob`, `email`, `adress`, `telephone`, "
                    + "`civilite`, `genre`, `taille`, `poids`, `profession`, "
                    + "`role`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement ps = cn.cnx.prepareStatement(req);
            ps.setString(1, pc.getPseudo());
            ps.setString(2, pc.getPassword());
            ps.setString(3, pc.getNom());
            ps.setString(4, pc.getPrenom());
            ps.setString(5, pc.getDOB().toString());
            ps.setString(6, pc.getEmail());
            ps.setString(7, pc.getAdress());
            ps.setString(8, pc.getTelephone());
            ps.setString(9, pc.getCivilite());
            ps.setInt(10, pc.getGenre());
            ps.setInt(11, pc.getTaille());
            ps.setInt(12, pc.getPoids());
            ps.setString(13, pc.getProfession());
            ps.setInt(14, pc.getRole());
            ps.executeUpdate();

            System.out.println("pclub "
                    + pc.getNom()+ " added successfully" );

        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    public void updateUser(Object o) {
        Pclub pc;
         pc = (Pclub)o;
                 try {
              
              String sql = "UPDATE `pclub` SET `pseudo`= ?,`password`= ? ,`nom`= ? ,`prenom`= ?  WHERE id = ?";
           PreparedStatement ps = cn.cnx.prepareStatement(sql);
            ps.setString(1, pc.getPseudo());
           ps.setString(2, pc.getPassword());
           ps.setString(3, pc.getNom());
           ps.setString(4, pc.getPrenom());
           ps.setInt(5, pc.getId());
            ps.executeUpdate();
                     System.out.println("pclub "+ pc.getNom() +" Updated successfully");
             
       } catch (SQLException ex) {
           System.out.println("error updating" + ex);
       }

    }

    @Override
    public void removeUser(Object o) {
           Pclub pc;
         pc = (Pclub)o;
       try {
           String q1 = "DELETE FROM pclub WHERE id = ?";
           PreparedStatement prepDelete = cn.cnx.prepareStatement(q1);
           prepDelete.setInt(1,pc.getId());
           prepDelete.execute();
           System.out.println("pclub Deleted Successfully" );
       } catch (SQLException ex) {
           System.out.println("error deleting" + ex );
       }

    }

    @Override
    public List<Object> listUsers() {
             List pclubs = new ArrayList<>();
        
        try {

            String req = "SELECT * FROM pclub";

            PreparedStatement ps = cn.cnx.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                
                Pclub pc = new Pclub();
                pc.setId(rs.getInt(1));
                pc.setPseudo(rs.getString("nom"));
                pc.setPassword(rs.getString("prenom"));
                System.out.println("adding");
                pclubs.add(pc);
                
            }

        } catch (SQLException ex) {
            System.out.println("error adding " + ex );
            }

        return pclubs;  
    }

    
    @Override
    public Object listUsersById(Object o) {
           Pclub pc;
         pc = (Pclub)o;
        try {
            String req = "SELECT * FROM pclub where id = ?";
            PreparedStatement ps = cn.cnx.prepareStatement(req);
            ps.setInt(1, pc.getId());
            ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                pc.setId(rs.getInt(1));
                pc.setPseudo(rs.getString("nom"));
                pc.setPassword(rs.getString("prenom"));
                                   }
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }


        
        return pc;




    }

   

   
    
}

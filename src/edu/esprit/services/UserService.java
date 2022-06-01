/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;

import edu.esprit.entities.User;
import edu.esprit.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Slimen OUNI
 */
public class UserService {
    
    Connection cnx = MyConnection.getInstance().getCnx();

    public UserService() {
    }
    
    
     public void updateUser(int id) {
         
          try {
           Statement stUpdate = cnx.createStatement();
             String Qupdate = "UPDATE `client` SET `firstName`='[value-2]',`lastName`='[value-3]',`email`='[value-4]',`age`='[value-5]' WHERE 1";
       } catch (SQLException ex) {
           System.out.println("error updating" + ex);
       }
         
            
     }

    public void addUser(User u) {
       
            try {
            String req = "INSERT INTO `user`(`pseudo`, `password`) VALUES (?,?)";

            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, u.getPseudo());
            ps.setString(2, u.getPassword());
            ps.executeUpdate();

            System.out.println("User "
                    + u.getPseudo() + " added successfully with " );

        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removeUser(int id) {
                try {
           String q1 = "DELETE FROM user WHERE id = ?";
           PreparedStatement prepDelete = cnx.prepareStatement(q1);
           prepDelete.setInt(1, id);
           prepDelete.execute();
       } catch (SQLException ex) {
           System.out.println("error deleting" + ex );
       }
    }
    
      public List<User> listUsers() {
          
        List<User> users = new ArrayList<>();
        
        try {

            String req = "SELECT * FROM user";

            PreparedStatement ps = cnx.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                
                User u = new User();
                u.setId(rs.getInt(1));
                u.setPseudo(rs.getString("pseudo"));
                u.setPassword(rs.getString("password"));
                System.out.println("adding");
                users.add(u);
                
            }

        } catch (SQLException ex) {
            System.out.println("error adding " + ex );
            }

        return users;
    }

    public User listUsersById(int id) {
        User usr = new User();
        
        try {
            String req = "SELECT * FROM user where id = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                usr.setId(rs.getInt(1));
                usr.setPseudo(rs.getString("pseudo"));
                usr.setPassword(rs.getString("password"));
                                   }
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
   
        
        
        return usr;

    
}

   
    
}

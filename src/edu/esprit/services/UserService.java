/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;


import edu.esprit.entities.User;
import edu.esprit.utils.MyConnection;
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
public class UserService implements UserServicesInterface{
    
      MyConnection cn= MyConnection.getInstance();


    public UserService() {
    }

    @Override
    public void updateUser(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addUser(Object o) {
       User u;
         u = (User)o;
                   try {
            String req = "INSERT INTO `user`"
                    + "(`pseudo`, `password`, `email`, `role`)"
                    + " VALUES (?,?,?,?);";

            PreparedStatement ps = cn.cnx.prepareStatement(req);
            ps.setString(1, u.getPseudo());
            ps.setString(2, u.getPassword());
            ps.setString(3, u.getEmail());
            ps.setInt(4, u.getRole());
            ps.executeUpdate();
            System.out.println("User " + u.getPseudo()+ " added successfully" );
        
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void removeUser(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> listUsers() {
            List users = new ArrayList<>();
        
        try {

            String req = "SELECT * FROM user";

            PreparedStatement ps = cn.cnx.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                
                User u = new User();
                u.setId(rs.getInt(1));
                u.setPseudo(rs.getString("pseudo"));
                u.setPassword(rs.getString("password"));
                u.setEmail(rs.getString("email"));
                System.out.println("adding");
                users.add(u);
                
            }

        } catch (SQLException ex) {
            System.out.println("error adding " + ex );
            }

        return users;  
    }

     public List<User> listUsersA1() {
            List<User> users = new ArrayList<User>();
        
        try {

            String req = "SELECT * FROM user";

            PreparedStatement ps = cn.cnx.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                
                User u = new User();
                u.setId(rs.getInt(1));
                u.setPseudo(rs.getString("pseudo"));
                u.setPassword(rs.getString("password"));
                u.setEmail(rs.getString("email"));
                System.out.println("adding");
                users.add(u);
                
            }

        } catch (SQLException ex) {
            System.out.println("error adding " + ex );
            }

        return users;  
    }
    

    @Override
    public Object listUsersById(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Object listUserByPseudo(Object o){  
         User u;
         u = (User)o;
     try {
            String req = "SELECT * FROM user where pseudo = ?";
            PreparedStatement ps = cn.cnx.prepareStatement(req);
            ps.setInt(1, u.getId());
            ResultSet rs = ps.executeQuery();
                while (rs.next()) {
             
                u.setId(rs.getInt(1));
                u.setPseudo(rs.getString("pseudo"));
                u.setPassword(rs.getString("password"));
                u.setRole(rs.getInt("role"));
                 
                                   }
                
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        

        
        return u;
    }
    
    
 
   
    
}

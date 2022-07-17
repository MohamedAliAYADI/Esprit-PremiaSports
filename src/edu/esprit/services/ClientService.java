/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;




import edu.esprit.entities.Client;
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
public class ClientService implements UserServicesInterface{
           MyConnection cn= MyConnection.getInstance();
           
    @Override
    public void addUser(Object o) {
      Client c;
         c = (Client)o;
        
                   try {
            String req = "INSERT INTO `client`(`pseudo`, `password`, `nom`, "
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

            System.out.println("User "
                    + c.getNom()+ " added successfully" );
                    
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    public void updateUser(Object o) {
        Client c;
         c = (Client)o;
                 try {
              
              String sql = "UPDATE `client` SET `nom`= ? ,`prenom`= ?  WHERE id = ?";
           PreparedStatement ps = cn.cnx.prepareStatement(sql);
           ps.setString(1, c.getNom());
           ps.setString(2, c.getPrenom());
           ps.setInt(3, c.getId());
            ps.executeUpdate();
                     System.out.println("User "+ c.getNom() +" Updated successfully");
             
       } catch (SQLException ex) {
           System.out.println("error updating" + ex);
       }

    }

    @Override
    public void removeUser(Object o) {
            Client c;
         c = (Client)o;
       try {
           String q1 = "DELETE FROM client WHERE id = ?";
           PreparedStatement prepDelete = cn.cnx.prepareStatement(q1);
           prepDelete.setInt(1, c.getId());
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

            String req = "SELECT * FROM client";

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
            Client c;
         c = (Client)o;
            
        try {
            String req = "SELECT * FROM client where id = ?";
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

     public List<Object> listUsersPseudos() {
             List clientsPsueods = new ArrayList<>();
        
        try {

            String req = "SELECT `id`,`pseudo` FROM client";

            PreparedStatement ps = cn.cnx.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                
                Client c = new Client();
                c.setId(rs.getInt(1));
                c.setPseudo(rs.getString("pseudo"));
                System.out.println("adding user pseudos");
                clientsPsueods.add(c);
                
            }

        } catch (SQLException ex) {
            System.out.println("error adding " + ex );
            }

        return clientsPsueods;  
    }

     
       // @Override
    public List<Object> listUsersToLogin(String pseudo,String password) {
                 List clientsPsueodsAndPassword = new ArrayList<>();
        
        try {

            String req = "SELECT `pseudo`,`password` FROM client where `pseudo` = ? and `password` = ?";

            PreparedStatement ps = cn.cnx.prepareStatement(req);
            ps.setString(1, pseudo);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            Client c = new Client();
              while (rs.next()) {
              c.setPassword(rs.getString("pseudo"));
              c.setPassword(rs.getString("password"));
              System.out.println("adding user pseudosAndPasswords");
              clientsPsueodsAndPassword.add(c);
              }
        } catch (SQLException ex) {
            System.out.println("error fetching user pseudos and passwords " + ex );
            }

        return clientsPsueodsAndPassword;  
    }
   
  
}

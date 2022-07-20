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
import java.sql.Statement;
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
   
    }
    
    
      public void updatesetAccountStatus(int x, boolean b) {
     
                 try {
              
              String sql = "UPDATE `user` SET `AccountLocked`= ?   WHERE id = ?";
           PreparedStatement ps = cn.cnx.prepareStatement(sql);
           if (b){
           ps.setInt(1, 1);
           ps.setInt(2, x);
           
         
           }
           else {
           ps.setInt(1, 0);
           ps.setInt(2, x);
            }
           
           ps.executeUpdate();
           System.out.println("User "+ x +" Updated successfully");
       } catch (SQLException ex) {
           System.out.println("error updating id: "+ x + ex);
       }

    }

    
    
      public void updateUserCodeAuth(User u) {
     
                 try {
              
              String sql = "UPDATE `user` SET `randCode`= ?   WHERE email = ?";
           PreparedStatement ps = cn.cnx.prepareStatement(sql);
           ps.setString(1, u.getRandCode());
           ps.setString(2, u.getEmail());
            ps.executeUpdate();
                     System.out.println("User "+ u.getId()+" Updated successfully");
             
       } catch (SQLException ex) {
           System.out.println("error updating" + ex);
       }

    }
      
        public void updateUserPassword(User u) {
     
                 try {
              
              String sql = "UPDATE `user` SET `password`= ?  ,  randCode = ? WHERE id = ?";
           PreparedStatement ps = cn.cnx.prepareStatement(sql);
           ps.setString(1, u.getPassword());
           ps.setString(2, null);
           ps.setInt(3, u.getId());
            ps.executeUpdate();
                     System.out.println("User "+ u.getId()+" Updated successfully");
             
       } catch (SQLException ex) {
           System.out.println("error updating" + ex);
       }

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
                u.setRole(rs.getInt("role"));
                u.setRandCode(rs.getString("randCode"));
                System.out.println("LISTIN USERS");
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
    
    public User listUserByEmail(User u) {
        User u1 = new User();
           
        try {
            String req = "SELECT * FROM user where email = ?";
            PreparedStatement ps = cn.cnx.prepareStatement(req);
            ps.setString(1, u.getEmail());
            ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                u1.setId(rs.getInt(1));
                u1.setPseudo(rs.getString("pseudo"));
               u1.setPseudo(rs.getString("password"));
                u1.setEmail(rs.getString("email"));
                u1.setRandCode(rs.getString("randCode"));
                
              }
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }


        
        return u1;



    }
    
    public Object listUserByPseudo(Object o){  
         User u;
         u = (User)o;
     try {
            String req = "SELECT * FROM user where pseudo = ?";
            PreparedStatement ps = cn.cnx.prepareStatement(req);
            ps.setString(1, u.getPseudo());
            ResultSet rs = ps.executeQuery();
                while (rs.next()) {
             
                u.setId(rs.getInt(1));
                u.setPseudo(rs.getString("pseudo"));
                u.setPassword(rs.getString("password"));
                u.setRole(rs.getInt("role"));
                u.setStatus(rs.getInt("AccountLocked"));
                 
                                   }
                
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        

        
        return u;
    }
    
    
 
      public List<User> recherchePseudoEmailRoleUser(String filtrePseudo, String filterEmail, String filterRole) {
        List<User> myList = new ArrayList<User>();
        String requete = "";
        try { // LES var declaré dans le try ne sont vue que dans le try, et inversement pour en dhors du try
            if (!filtrePseudo.equals("") ) {
                requete = "SELECT * from user where `pseudo` like'%" + filtrePseudo + "%'"; //MAJUSCULE NON OBLIGATOIRE 
            }
////                else if(!filterEmail.equals("")){
////                requete = "SELECT * from user where `email` like'%" + filterEmail + "%'"; //MAJUSCULE NON OBLIGATOIRE 
////           }
//          else {
//          requete = "SELECT * from user where `role` =  " + filterRole; //MAJUSCULE NON OBLIGATOIRE 
//            }
            Statement pst = MyConnection.cnx.prepareStatement(requete) ;// import java.sql.Statement
            ResultSet rs = pst.executeQuery(requete);
            while (rs.next()) {
                User p2 = new User();

                p2.setId(rs.getInt(1));// soit numero , soit nom de la colonne , comme id => numero (index ) =1

                User c = new User();

                String requete2 = "SELECT * from user WHERE id=? ";
                PreparedStatement pst2 = cn.cnx.prepareStatement(requete2); // import java.sql.Statement
                pst2.setInt(1, rs.getInt(1));
                ResultSet rs2 = pst2.executeQuery();
                while (rs2.next()) {
                    c.setPseudo(rs2.getString("pseudo"));
                    c.setEmail(rs2.getString("email"));
                    c.setRole(rs2.getInt("role"));
                }

               //c.setLibelle("jj");
               
                myList.add(c);

            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;

    }
    
}

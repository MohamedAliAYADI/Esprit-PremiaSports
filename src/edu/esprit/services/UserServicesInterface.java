/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;


import java.util.List;

/**
 *
 * @author Slimen OUNI
 */
public interface UserServicesInterface {
    
    
        public void updateUser(Object o, int id);


    public  void addUser(Object o);
//            try {
//            String req = "INSERT INTO `user`(`pseudo`, `password`) VALUES (?,?)";
//
//            PreparedStatement ps = cnx.prepareStatement(req);
//            ps.setString(1, u.getPseudo());
//            ps.setString(2, u.getPassword());
//            ps.executeUpdate();
//
//            System.out.println("User "
//                    + u.getPseudo() + " added successfully with " );
//
//        } catch (SQLException ex) {
//            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
//        }

    public  void removeUser(int id);


      public  List<Object> listUsers();


    public  Object listUsersById(int id);

}

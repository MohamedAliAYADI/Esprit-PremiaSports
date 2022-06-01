/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Default;

import edu.esprit.entities.User;
import edu.esprit.services.UserService;

/**
 *
 * @author Geekz
 */
public class EspritPremiaSports {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        //Instanciating a user service
        UserService us = new UserService();
        User u = new User("safsoufa", "slimenhobi");
        User u1 = new User();
        // Listing all users;
        //System.out.println(us.listUsers());
        
       // Listing a User BY ID
       // System.out.println(us.listUsersById(1));
        
        //Add User to DB
        //us.addUser(u);
        
        //Remove User from DB
        us.removeUser(1);
        //Update User 
       //us.updateUser(1);
      
        
        

    }
    
}

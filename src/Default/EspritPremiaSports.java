/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Default;

import edu.esprit.entities.Client;
import edu.esprit.services.ClientService;

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
        ClientService cs = new ClientService();

        
        Client c = new Client("test", "i");
         Client cupdate = new Client("update", "update");
        // Listing all users;
        System.out.println(cs.listUsers());
        
       // Listing a User BY ID
     //  System.out.println(cs.listUsersById(1));
        
        //Add User to DB
        //cs.addUser(c);
        
        //Remove User from DB
        //cs.removeUser(3);
        //Update User 
     // cs.updateUser(cupdate,1);
      
        
        

    }
    
}

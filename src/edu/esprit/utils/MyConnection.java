/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Geekz
 */
public class MyConnection {

    public String url="jdbc:mysql://localhost:3306/premia_sports";
    public String login="root";
    public String pwd="";
    public static Connection cnx;
    
    static MyConnection instance=null;
   private MyConnection() {
        
        try {
           cnx=DriverManager.getConnection(url, login, pwd);
            System.out.println("Connexion etablie");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
      
    }

    public static MyConnection getInstance() {
      if(instance ==null)
          instance =new MyConnection();
      
          return instance;
      
    }
}
    
    


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

    public String USERNAME = "root";
    public String PASSWORD = "";
    public String URL = "jdbc:mysql://localhost:3306/premia_sports";
    private com.mysql.jdbc.Connection cnx;
    static MyConnection instance = null;

    public MyConnection() {

        try {
            cnx = (com.mysql.jdbc.Connection) DriverManager.getConnection(URL,USERNAME ,PASSWORD);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

        System.out.println("Base de donné connecté avec succé ");
    }

    public com.mysql.jdbc.Connection getCnx() {
        return cnx;
    }

    public static MyConnection getInstance() {
        if(instance == null)
            instance = new MyConnection();

        return instance;
    }



}
    
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.esprit.entities.Activity;
import edu.esprit.utils.MyConnection;

/**
 *
 * @author k.saidani
 */
public class ActivityDAO {
  private Connection connection;
public ActivityDAO(Connection cnx) {
     connection= cnx;
    }

    public ActivityDAO() {
        connection=MyConnection.getInstance().cnx;
    }  
    public void updateActivity (Activity a1,int id) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update Activities set nom_activity=?" +
                            "where id=?");
            // Parameters start with 1
            preparedStatement.setString(1, a1.getNomActivity());
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void DeleteActivity (int id){
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from Activities where id=?");
          
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
   
    } 
            
   public List<Activity> getAllActivity() {
        List<Activity> activities = new ArrayList<Activity>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from Activities");
            while (rs.next()) {
                Activity activity = new Activity();
                activity.setIdActivity(rs.getInt("id_activity"));
                activity.setNomActivity(rs.getString("nom_activity"));
                activities.add(activity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return activities;
    }
   
    public Activity getActivity(String name ) {
        try {
           PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT * FROM `activities` WHERE `nom_activity`=?");
            preparedStatement.setString(1,name);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.first()){
                        Activity activity = new Activity();

                System.out.println(rs.first());
                activity.setIdActivity(rs.getInt("id_activity"));
                activity.setNomActivity(rs.getString("nom_activity"));
                        return activity;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return null;
    }
          
    public  void AddActivity(Activity a1){
    // Clubs c=new Clubs("California Gym", "centre urbain", "71111000", "sprint");
    List<Activity> activity;

try{
 String req = "INSERT INTO `activities`(`nom_activity`)"
            + " VALUES (?)";
    PreparedStatement ps = connection.prepareStatement(req);
    ps.setString(1, a1.getNomActivity());
 
 
    ps.executeUpdate();
    
    System.out.println("Activity ajouté avec succes");
    } 
catch (SQLException ex) {
    ex.printStackTrace();
}
}

    void addRelation(int idActivity, int id) {
        try{
 String req = "INSERT INTO `r_activity_clubs`(`idActivity`,`id`)"
            + " VALUES (?,?)";
    PreparedStatement ps = connection.prepareStatement(req);
    ps.setInt(1, idActivity);
    ps.setInt(2, id);
    
    ps.executeUpdate();
    
    System.out.println("Activity ajouté avec succes");
    } 
catch (SQLException ex) {
    ex.printStackTrace();
}
    }
}

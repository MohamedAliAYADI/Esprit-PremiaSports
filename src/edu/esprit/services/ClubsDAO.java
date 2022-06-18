/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;

import edu.esprit.entities.Activity;
import edu.esprit.entities.Clubs;
import edu.esprit.utils.MyConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author k.saidani
 */
public class ClubsDAO {
    private Connection connection;

    public ClubsDAO(Connection cnx) {
     connection= cnx;
    }

    public ClubsDAO() {
        connection=MyConnection.getInstance().cnx;
    }
    public void updateClubs (Clubs c1,int id) {
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update club set adress=?, phone_number=?" +
                            "where id=?");
            // Parameters start with 1
            preparedStatement.setString(1, c1.getAdress());
            preparedStatement.setString(2, c1.getPhone_Number());
            preparedStatement.setInt(3, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void DeleteClubs (int id){
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from club where id=?");
          
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
   
    } 
            
   public List<Clubs> getAllClubs() {
        List<Clubs> clubs = new ArrayList<Clubs>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from club");
            while (rs.next()) {
                Clubs club = new Clubs();
                club.setName(rs.getString("name"));
                club.setAdress(rs.getString("adress"));
                club.setPhone_Number(rs.getString("phone_number"));
            
                clubs.add(club);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return clubs;
    }
          public Clubs getClub(String name) {
     Clubs club = new Clubs();
        try {
           PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT * FROM `club` WHERE `name`=?");
            preparedStatement.setString(1,name);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                club.setId(rs.getInt("id"));
                club.setName(rs.getString("name"));
                club.setAdress(rs.getString("adress"));
                club.setPhone_Number(rs.getString("phone_number"));
            
             
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
 
        return club;
    }
    public  void AddClubS(Clubs c1){
    // Clubs c=new Clubs("California Gym", "centre urbain", "71111000", "sprint");
   ActivityDAO activityDao = new ActivityDAO();

try{
 String req = "INSERT INTO `club`(`name`, `adress`, `phone_number`)"
            + " VALUES (?,?,?)";
    PreparedStatement ps = connection.prepareStatement(req);
    ps.setString(1, c1.getName());
    ps.setString(2, c1.getAdress());
    ps.setString(3, c1.getPhone_Number());
     ps.executeUpdate();
     Clubs club =getClub(c1.getName());
    for (Activity activity:c1.getActivities())
    {
        Activity selectedActivity=activityDao.getActivity(activity.getNomActivity());
        if (selectedActivity==null)
        {
            
            System.out.println("activity is null");
        activityDao.AddActivity(activity);
     
        }
           Activity ac1=new Activity();
           System.out.println("act");
           ac1= activityDao.getActivity(activity.getNomActivity());
           System.out.println("act1");
           activityDao.addRelation(ac1.getIdActivity(),club.getId());
    }

   
    
    System.out.println("Club ajouté avec succes");
    } 
catch (SQLException ex) {
    ex.printStackTrace();
}
}
}

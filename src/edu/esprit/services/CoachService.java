package edu.esprit.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.esprit.entities.Coach;
import edu.esprit.utils.MyConnection;

public class CoachService {
    Connection cnx = MyConnection.getInstance().cnx;

    public void addCoach(Coach c) {
        try {
            String req = "INSERT INTO `coach`(`first_name`, `last_name` , `gender` , `birthday`, `email`, `post_work`, `company_name`) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, c.getFirst_name());
            ps.setString(2, c.getLast_name());
            ps.setString(3, c.getGender());
            ps.setDate(4, (java.sql.Date) c.getBirthday());
            ps.setString(5, c.getEmail());
            ps.setString(6, c.getPost_work());
            ps.setString(7, c.getCompany_name());
            ps.executeUpdate();

            System.out.println("Coach added successfully" );

        } catch (SQLException e) {
        	
            System.out.println(e);
        }
    }

    
    public void updateCoach(Coach c, int id) {
        try {
           String sql = "UPDATE `coach` SET `first_name`= ?,`last_name`= ? ,`gender`= ? ,`birthday`= ? ,`email`= ? ,`post_work`= ? ,`company_name`= ?  WHERE id = ?";
           PreparedStatement ps = cnx.prepareStatement(sql);
           ps.setString(1, c.getFirst_name());
           ps.setString(2, c.getLast_name());
           ps.setString(3, c.getGender());
           ps.setDate(4, (java.sql.Date) c.getBirthday());
           ps.setString(5, c.getEmail());
           ps.setString(6, c.getPost_work());
           ps.setString(7, c.getCompany_name());
           ps.setInt(8, id);
           ps.executeUpdate();
           System.out.println("Coach Updated successfully");
             
        } catch (SQLException e) {
        	
            System.out.println(e);
        }

    }

    public void removeCoach(int id) {
       try {
    	   
           String sq1 = "DELETE FROM coach WHERE id = ?";
           PreparedStatement prepDelete = cnx.prepareStatement(sq1);
           prepDelete.setInt(1, id);
           prepDelete.execute();
           System.out.println("Coach Deleted Successfully" );
           
       } catch (SQLException e) {
           System.out.println(e);
       }

    }

    public List<Coach> listCoachs() {
    	
             List<Coach> coachs = new ArrayList<>();
        
        try {

            String req = "SELECT * FROM coach";

            PreparedStatement ps = cnx.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                
                Coach c = new Coach();
                c.setId(rs.getInt(1));
                c.setFirst_name(rs.getString("first_name"));
                c.setLast_name(rs.getString("last_name"));
                c.setGender(rs.getString("gender"));
                c.setEmail(rs.getString("email"));
                c.setBirthday(rs.getDate("birthday"));
                c.setPost_work(rs.getString("post_work"));
                c.setCompany_name(rs.getString("company_name"));                
                coachs.add(c);
                
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return coachs;  
    }

    
    public Coach getCoachById(int id) {
        Coach c = new Coach();
        try {
            String req = "SELECT * FROM coach where id = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               c.setId(rs.getInt(1));
               c.setFirst_name(rs.getString("first_name"));
               c.setLast_name(rs.getString("last_name"));
               c.setGender(rs.getString("gender"));
               c.setEmail(rs.getString("email"));
               c.setBirthday(rs.getDate("birthday"));
               c.setPost_work(rs.getString("post_work"));
               c.setCompany_name(rs.getString("company_name")); 
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return c;

    }  
}
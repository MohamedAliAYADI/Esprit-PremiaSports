package edu.esprit.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.esprit.entities.Coach;
import edu.esprit.entities.Reservation;
import edu.esprit.utils.MyConnection;

public class ReservationService {
    Connection cnx = MyConnection.getInstance().cnx;
    
    public void addReservation(Reservation r) {
    	try {
    		
            String req = "INSERT INTO `reservation`(`user_id`, `coach_id`, `title`, `type`, `state`, `end_time`, `start_time`, `price`) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, r.getUser_id());
            ps.setInt(2, r.getCoach_id());
            ps.setString(3, r.getTitle());
            ps.setString(4, r.getType());
            ps.setString(5, r.getState());
            ps.setDate(6, (java.sql.Date) r.getEnd_time());
            ps.setDate(7, (java.sql.Date) r.getStart_time());
            ps.setDouble(8, r.getPrice());
            ps.executeUpdate();

            System.out.println("Reservation added successfully" );

        } catch (SQLException e) {
        	
            System.out.println(e);
        }
    }

    public void updateReservation(Reservation r, int id) {
        try {
            String sql = "UPDATE `reservation` SET `user_id`= ?,`coach_id`= ? ,`title`= ? ,`type`= ? ,`state`= ? ,`end_time`= ? ,`start_time`= ?  ,`price`= ?  WHERE id = ?";
            PreparedStatement ps = cnx.prepareStatement(sql);
            ps.setInt(1, r.getUser_id());
            ps.setInt(2, r.getCoach_id());
            ps.setString(3, r.getTitle());
            ps.setString(4, r.getType());
            ps.setString(5, r.getState());
            ps.setDate(6, (java.sql.Date) r.getEnd_time());
            ps.setDate(7, (java.sql.Date) r.getStart_time());
            ps.setDouble(8, r.getPrice());
            ps.setInt(9, id);
            ps.executeUpdate();
            System.out.println("Reservation Updated successfully");
              
         } catch (SQLException e) {
         	
             System.out.println(e);
         }
    }
    
    public void removeReservation(int id) {
        try {
     	   
            String sq1 = "DELETE FROM reservation WHERE id = ?";
            PreparedStatement prepDelete = cnx.prepareStatement(sq1);
            prepDelete.setInt(1, id);
            prepDelete.execute();
            System.out.println("Reservation Deleted Successfully" );
            
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List<Reservation> listReservationByUserId(int id) {
        List<Reservation> reservations = new ArrayList<>();
        try {

            String req = "SELECT * FROM coach WHERE user_id = ?";

            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                
            	Reservation r = new Reservation();
                r.setId(rs.getInt(1));
                r.setUser_id(rs.getInt("user_id"));
                r.setCoach_id(rs.getInt("coach_id"));
                r.setTitle(rs.getString("title"));
                r.setState(rs.getString("state"));
                r.setEnd_time(rs.getDate("end_time"));
                r.setStart_time(rs.getDate("start_time"));
                r.setPrice(rs.getFloat("price")); 
                
                reservations.add(r);
                
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return reservations;
    }

    public List<Reservation> listReservationByCoachId(int id) {
        List<Reservation> reservations = new ArrayList<>();
        try {

            String req = "SELECT * FROM coach WHERE coach_id = ?";

            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                
            	Reservation r = new Reservation();
                r.setId(rs.getInt(1));
                r.setUser_id(rs.getInt("user_id"));
                r.setCoach_id(rs.getInt("coach_id"));
                r.setTitle(rs.getString("title"));
                r.setState(rs.getString("state"));
                r.setEnd_time(rs.getDate("end_time"));
                r.setStart_time(rs.getDate("start_time"));
                r.setPrice(rs.getFloat("price")); 
                
                reservations.add(r);
                
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return reservations;
    }
}

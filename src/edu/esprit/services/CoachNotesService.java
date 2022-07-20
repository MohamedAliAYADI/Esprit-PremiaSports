package edu.esprit.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.esprit.entities.CoachNotes;
import edu.esprit.utils.MyConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CoachNotesService {

    Connection cnx = MyConnection.getInstance().cnx;
    
    public void createCoachNotes(CoachNotes coachNotes) {
    	try {
    		
            String req = "INSERT INTO `coach_notes`(`coach_id`, `title`, `description`, `title_1`, `description_1`, `title_2`, `description_2`, `title_3`, `description_3`, `title_4`, `description_4`, `title_5`, `description_5` ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, coachNotes.getCoach_id());
            ps.setString(2, coachNotes.getTitle());
            ps.setString(3, coachNotes.getDescription());
            ps.setString(4, coachNotes.getTitle_1());
            ps.setString(5, coachNotes.getDescription_1());
            ps.setString(6, coachNotes.getTitle_2());
            ps.setString(7, coachNotes.getDescription_2());
            ps.setString(8, coachNotes.getTitle_3());
            ps.setString(9, coachNotes.getDescription_3());
            ps.setString(10, coachNotes.getTitle_4());
            ps.setString(11, coachNotes.getDescription_4());
            ps.setString(12, coachNotes.getTitle_5());
            ps.setString(13, coachNotes.getDescription_5());
            ps.executeUpdate();

            System.out.println("Code promo created successfully" );

        } catch (SQLException e) {
        	
            System.out.println(e);
        }
    }
 
    public void updateCoachNote(int id, CoachNotes coachNotes) {
        try {
                String sql = "UPDATE `coach_notes` SET `title`= ? , `description`= ? , `title_1`= ? , `description_1`= ? , `title_2`= ? , `description_2`= ? , `title_3`= ? , `description_3`= ?  , `title_4`= ? , `description_4`= ? , `title_5`= ? , `description_5`= ? WHERE id = ?";
                PreparedStatement ps2 = cnx.prepareStatement(sql);
                ps2.setString(1, coachNotes.getTitle());
                ps2.setString(2, coachNotes.getDescription());
                ps2.setString(3, coachNotes.getTitle_1());
                ps2.setString(4, coachNotes.getDescription_1());
                ps2.setString(5, coachNotes.getTitle_2());
                ps2.setString(6, coachNotes.getDescription_2());
                ps2.setString(7, coachNotes.getTitle_3());
                ps2.setString(8, coachNotes.getDescription_3());
                ps2.setString(9, coachNotes.getTitle_4());
                ps2.setString(10, coachNotes.getDescription_4());
                ps2.setString(11, coachNotes.getTitle_5());
                ps2.setString(12, coachNotes.getDescription_5());
                ps2.setInt(13, id);
  
                ps2.executeUpdate();
                System.out.println("Promo Updated successfully");	
                
        } catch (SQLException e) {
        	System.out.println(e);
        }
    }
    
    public void deleteCoachNotes(int id){

        try {
            String q1 = "DELETE FROM coach_notes WHERE id = ?";
            PreparedStatement prepDelete = cnx.prepareStatement(q1);
			prepDelete.setInt(1, id);
	        prepDelete.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  
    }        
    
    public ObservableList<CoachNotes> getListCoachNotes(int id) {
    	ObservableList<CoachNotes> CoachNotesList = FXCollections.observableArrayList();
        try {

            String req = "SELECT * FROM coach_notes WHERE coach_id= ?";

            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                
            	CoachNotes coachNotes = new CoachNotes();
            	coachNotes.setId(Integer.parseInt(rs.getString("id")));
            	coachNotes.setTitle(rs.getString("title"));
            	coachNotes.setDescription(rs.getString("description"));
            	coachNotes.setTitle_1(rs.getString("title_1"));
            	coachNotes.setDescription_1(rs.getString("description_1"));
            	coachNotes.setTitle_2(rs.getString("title_2"));
            	coachNotes.setDescription_2(rs.getString("description_2"));
            	coachNotes.setTitle_3(rs.getString("title_3"));
            	coachNotes.setDescription_3(rs.getString("description_3"));
            	coachNotes.setTitle_4(rs.getString("title_4"));
            	coachNotes.setDescription_4(rs.getString("description_4"));
            	coachNotes.setTitle_5(rs.getString("title_5"));
            	coachNotes.setDescription_5(rs.getString("description_5"));     
            	CoachNotesList.add(coachNotes);
                
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return CoachNotesList;
    }
    
    
    public CoachNotes getCoachNotesById(int id) {
    	CoachNotes coachNotes = new CoachNotes();
        try {

            String req = "SELECT * FROM coach_notes WHERE id = ?";

            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                
            	coachNotes.setId(Integer.parseInt(rs.getString("id")));
            	coachNotes.setTitle(rs.getString("title"));
            	coachNotes.setDescription(rs.getString("description"));
            	coachNotes.setTitle_1(rs.getString("title_1"));
            	coachNotes.setDescription_1(rs.getString("description_1"));
            	coachNotes.setTitle_2(rs.getString("title_2"));
            	coachNotes.setDescription_2(rs.getString("description_2"));
            	coachNotes.setTitle_3(rs.getString("title_3"));
            	coachNotes.setDescription_3(rs.getString("description_3"));
            	coachNotes.setTitle_4(rs.getString("title_4"));
            	coachNotes.setDescription_4(rs.getString("description_4"));
            	coachNotes.setTitle_5(rs.getString("title_5"));
            	coachNotes.setDescription_5(rs.getString("description_5"));

            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return coachNotes;
    }

}

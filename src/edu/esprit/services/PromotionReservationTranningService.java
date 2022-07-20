package edu.esprit.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.esprit.entities.PromotionReservationTranning;
import edu.esprit.entities.ReservationTraining;
import edu.esprit.utils.MyConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PromotionReservationTranningService {

    Connection cnx = MyConnection.getInstance().cnx;
    
    public void createCodePromo(PromotionReservationTranning prt) {
    	try {
    		
            String req = "INSERT INTO `code_promo`(`code`, `organizer`, `nb`, `percent`) VALUES (?,?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, prt.getCode());
            ps.setString(2, prt.getOrganizer());
            ps.setInt(3, prt.getNb());
            ps.setString(4, prt.getPercent());
            ps.executeUpdate();

            System.out.println("Code promo created successfully" );

        } catch (SQLException e) {
        	
            System.out.println(e);
        }
    }
    
    public void deleteCodePromo(int id){

        try {
            String q1 = "DELETE FROM code_promo WHERE id = ?";
            PreparedStatement prepDelete = cnx.prepareStatement(q1);
			prepDelete.setInt(1, id);
	        prepDelete.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  
    }  
    
    public void updateCodePromo(int id, PromotionReservationTranning prt) {
    	try {
    		
            String req = "UPDATE `code_promo` SET `code`= ? , `organizer`= ? , `nb`= ? , `percent`= ? WHERE id=?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, prt.getCode());
            ps.setString(2, prt.getOrganizer());
            ps.setInt(3, prt.getNb());
            ps.setString(4, prt.getPercent());
            ps.setInt(5, id);
            ps.executeUpdate();

            System.out.println("Code promo created successfully" );

        } catch (SQLException e) {
        	
            System.out.println(e);
        }
    }  
    public void useCodePromo(String code) {
        int code_nb = 0;
        int id = -1;
        try {
        	String req = "SELECT * FROM code_promo where code = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, code);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
             	id = rs.getInt("id");
             	code_nb = rs.getInt("nb");
            }
            if(code_nb > 0) {
                String sql = "UPDATE `code_promo` SET `nb`= ?  WHERE code = ?";
                PreparedStatement ps2 = cnx.prepareStatement(sql);
                ps2.setInt(1, code_nb-1);
                ps2.setString(2, code);
                ps2.executeUpdate();
                System.out.println("Promo Updated successfully");	
            }
            else {
            	if(id == -1) {
                    System.out.println("Code promo not found");		
            	}
            	else {
                    System.out.println("Code promo already used");		
            	}
            }
        } catch (SQLException e) {
        	System.out.println(e);
        }
    }
    
    public ObservableList<PromotionReservationTranning> getListPromotionReservationTranning() {
    	ObservableList<PromotionReservationTranning> promotionReservationTranning = FXCollections.observableArrayList();
        try {

            String req = "SELECT * FROM code_promo";

            PreparedStatement ps = cnx.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                
            	PromotionReservationTranning r = new PromotionReservationTranning();
                r.setId(rs.getInt("id"));
                r.setCodeForList(rs.getString("code"));
                r.setOrganizer(rs.getString("organizer"));
                r.setNb(rs.getInt("nb"));
                r.setPercent(rs.getString("percent"));
                
                promotionReservationTranning.add(r);
                
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return promotionReservationTranning;
    }
    
    
    public PromotionReservationTranning getCodePromoById(int id) {
    	PromotionReservationTranning promotionReservationTranning = new PromotionReservationTranning();
        try {

            String req = "SELECT * FROM code_promo WHERE id = ?";

            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                
            	promotionReservationTranning.setCodeForList(rs.getString("code"));
            	promotionReservationTranning.setOrganizer(rs.getString("organizer"));
            	promotionReservationTranning.setNb(rs.getInt("nb"));
            	promotionReservationTranning.setPercent(rs.getString("percent"));
                
                
            }

        } catch (SQLException e) {
            System.out.println(e);
        }

        return promotionReservationTranning;
    }
    public boolean isCodePromo(String code) {
        int code_nb = 0;
        int id = -1;
        try {
        	String req = "SELECT * FROM code_promo where code = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, code);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
             	id = rs.getInt("id");
             	code_nb = rs.getInt("nb");
            }
            if(code_nb > 0) {
            	return true;
            }
            else {
            	if(id == -1) {
                	return false;
            	}
            	else {
                	return false;
            	}
            }
        } catch (SQLException e) {
        	System.out.println(e);
        	return false;
        }
    }
}

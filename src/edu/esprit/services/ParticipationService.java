/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;

import edu.esprit.utils.MyConnection;
import edu.esprit.entities.Participation;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nemya
 */
public class ParticipationService {
    MyConnection mc= MyConnection.getInstance();
    EventService es=new EventService();
    
    
    public void inserteParticipation(Participation p){
        String req= "insert into `participation` (`comment`,`id _event`) values (?,?)";
        try {
            PreparedStatement ps=mc.cnx.prepareStatement(req);
            ps.setString(1, p.getComment());
            ps.setInt(2, p.getEvent().getEventId());
            ps.executeUpdate();
            System.out.println("Participation added successfully");
        } catch (SQLException ex) {
            Logger.getLogger(ParticipationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<Participation> displayParticipations(){
                List<Participation> participations = new ArrayList<>();
                String req = "SELECT * FROM participation";
                PreparedStatement ps;
        try {
            ps = mc.cnx.prepareStatement(req);
             ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                
                Participation p = new Participation();
                p.setIdParticipation(rs.getInt(1));
                p.setComment(rs.getString(2));
                p.setEvent(es.getEventByID(rs.getInt(3)));
                
                participations.add(p);
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(ParticipationService.class.getName()).log(Level.SEVERE, null, ex);
        }
         return participations;
    }
    
    public void updateParticipation(){
        
    }
     public void deleteParticipation(){
        
    }
    
    
    
}

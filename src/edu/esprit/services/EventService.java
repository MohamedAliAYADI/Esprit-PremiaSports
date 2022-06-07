/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;

import edu.esprit.entities.Event;
import edu.esprit.utils.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Geekz
 */
public class EventService {
           MyConnection mc= MyConnection.getInstance();
           public String insertNewEventReq,
                         getAllEventReq,
                         updateEvent,
                         deleteEvent;
         
           public void insertEvent1(Event event){
                  insertNewEventReq="INSERT  INTO `event` (`title`,`description`,`startDate`,`endDate`) VALUES ('" 
                  + event.getEventTitle()+ "','"
                  + event.getEventDescription()+ "','"
                   + event.getStartDate() + "','"
                  + event.getEndDate() + "')";
               try {
                   Statement st=mc.cnx.createStatement();
                   st.executeUpdate(insertNewEventReq);
                   System.out.println("Event added succefully");

               } catch (SQLException ex) {
                   Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
               }  
           }
           public void insertEvent2(Event event){
                  insertNewEventReq="INSERT  INTO `event` (`title`,`description`,`startDate`,`endDate`)"  + " VALUES (?,?,?,?)";
              
               try {
                   PreparedStatement st=mc.cnx.prepareStatement(insertNewEventReq);
                   st.setString(1, event.getEventTitle());
                   st.setString(2, event.getEventDescription());
                   st.setString(3, event.getStartDate());
                   st.setString(4, event.getEndDate());
                   st.executeUpdate();
                   System.out.println("Event added succefully");

               } catch (SQLException ex) {
                   Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
               }  
           }
           
           
           
           public List<Event> displayEvent(){
               List<Event> events=new ArrayList<>();
                getAllEventReq="select * from event";
               try {
                   Statement px=mc.cnx.createStatement();
                   ResultSet rs= px.executeQuery(getAllEventReq);
                   while(rs.next()){
                       Event ev=new Event();
                       ev.setEventTitle(rs.getString("title"));
                       ev.setEventDescription(rs.getString("description"));
                       ev.setStartDate(rs.getString("startDate"));
                       ev.setEndDate(rs.getString("endDate"));
                       
                       events.add(ev);
                   }
               } catch (SQLException ex) {
                   Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
               }
                return events;
           }
           public void modifyEvent(Event e,String newDate){
               updateEvent="update event set endDate='"
                       +newDate+ "' where id="
                      + e.getEventId() + "";
                   Statement st;
               try {
                   st = mc.cnx.createStatement();
                   st.executeUpdate(updateEvent);
                   System.out.println("event updated successfully");
               } catch (SQLException ex) {
                   Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
               }
               
               
           }
           public void deleteEvent(Event e){
                     deleteEvent="delete from event where id="+e.getEventId();
                   Statement st;
                   int rowAffected = 0;
                   
               try {
                   st = mc.cnx.createStatement();
                  rowAffected = st.executeUpdate(deleteEvent); 
               } catch (SQLException ex) {
                   Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
               }
               if(rowAffected == 1)
                   System.out.println("event deleted succesfully");
               else
                   System.out.println("event don't exist");
              
               
               
           }

 public Event getEventByID(int id){
        
        Event e = new Event();
        
        try {
            String req = "SELECT * from event WHERE id = ?";
            PreparedStatement ps = mc.cnx.prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {                
                e.setEventId(rs.getInt(1));
                e.setEventTitle(rs.getString(2));
                e.setEventDescription(rs.getString(3));
                e.setStartDate(rs.getString(4));
                e.setEventTitle(rs.getString(5));


            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return e;
    }           

    
}

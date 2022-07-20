/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;



import edu.esprit.entities.Reservation;
import edu.esprit.utils.MyConnection;
import static edu.esprit.utils.MyConnection.cnx;
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
 * @author bouss
 */
public class Reservationservices {
    public PromotionServices promotionServices;
    public void InsertIntoReservation(Reservation R){
        try{
            MyConnection connectionDB = new MyConnection();
            String req = "INSERT INTO `reservation`(`DateReservation`, `nombredeParticipant`, `prix`,`promotion`) VALUES (?,?,?,?)";
            PreparedStatement ps;
            try {
                ps = connectionDB.cnx.prepareStatement(req);
                ps.setString(1, R.getDateReservation());
                ps.setInt(2, R.getNombredeParticipant());
                ps.setInt(3, R.getPrix());
                ps.setInt(4,12);
             
                ps.executeUpdate();            
                System.out.println("Reservation ajoutée avec succes" );
            } catch (SQLException ex) {
                Logger.getLogger(Reservationservices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        catch(Exception e){
                System.out.println(e);
        }
    }
    public List<Reservation> displayReservation(){
        List<Reservation> list=new ArrayList<>();
        String req="select * from reservation";
        
                    MyConnection connectionDB = new MyConnection();

try {
    Statement st=connectionDB.cnx.createStatement();
                   ResultSet rs= st.executeQuery(req);
                   while(rs.next()){
                       Reservation rse=new Reservation();
                       rse.setDateReservation(rs.getString("DateReservation"));
                       rse.setNombredeParticipant(rs.getInt("NombreDeParticipant"));
                       rse.setPrix(rs.getInt("prix"));
                       rse.setProm(rse.getProm());
                       
                       list.add(rse);
                   }
               } catch (SQLException ex) {
                  Logger.getLogger(Reservationservices.class.getName()).log(Level.SEVERE, null, ex);
               }
                return list;
    }
   public void DeleteReservation(Reservation R){
        try{
            MyConnection connectionDB = new MyConnection();
              String req = " DELETE FROM `reservation` WHERE `idReservation` =1";
            
            PreparedStatement ps = cnx.prepareStatement(req);
            try {
                ps = connectionDB.cnx.prepareCall(req);
          
                ps.executeUpdate();            
                System.out.println("Reservation supprimer avec succes");
            } catch (SQLException ex) {
               // Logger.getLogger(Reservationservices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        catch(Exception e){
                System.out.println(e);
        }
    }
   public void GetReservationByID(){
        try{
            Reservation R=new Reservation();
            MyConnection connectionDB = new MyConnection();
              String req = " SELECT * FROM `reservation` WHERE `idReservation` =?";
            
            PreparedStatement ps = connectionDB.cnx.prepareStatement(req);
            try {
                ps = connectionDB.cnx.prepareCall(req);
          ps.setInt(1, R.getIdReservation());
               ResultSet rs =      ps.executeQuery();         
                while (rs.next()) {                
                R.setIdReservation(rs.getInt(1));
            }
                System.out.println("Reservation id est"+" "+R.getIdReservation());
            } catch (SQLException ex) {
                Logger.getLogger(Reservationservices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        catch(Exception e){
                System.out.println(e);
        }
        
    }
}



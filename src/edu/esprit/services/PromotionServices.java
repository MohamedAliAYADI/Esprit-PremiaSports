/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;
import edu.esprit.entities.Promotion;
import edu.esprit.entities.Reservation;
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
 * @author bouss
 */
public class PromotionServices {
    public void InsertIntoPromotion(Promotion p){
        try{
            MyConnection connectionDB = new MyConnection();
            String req = "INSERT INTO `promotion`(`type_promotion`,`promo`) VALUES (?,?)";
            PreparedStatement ps;
            try {
            
                ps = connectionDB.cnx.prepareStatement(req, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, p.getType()); 
                ps.setInt(2, p.getPromo());
                ps.executeUpdate();            
                System.out.println("Promotion ajoutée avec succes");
                try(ResultSet generatedKeys = ps.getGeneratedKeys())
                {
                    if(generatedKeys.next())
                    {
                        int  idq=generatedKeys.getInt(1);
                        Reservation R=new Reservation("11/12/2022", 5, 100,idq);
                    Reservationservices rev =new Reservationservices();
                rev.InsertIntoReservation(R);

                    }
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(Reservationservices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        catch(Exception e){
                System.out.println(e);
        }
 
    }
        public List<Promotion> displayPromotion(){
        List<Promotion> list=new ArrayList<>();
        String req="select * from promotion";
        
                    MyConnection connectionDB = new MyConnection();

try {
    Statement st=connectionDB.cnx.createStatement();
                   ResultSet rs= st.executeQuery(req);
                   while(rs.next()){
                       Promotion rse=new Promotion();
                       rse.setType(rs.getString("type_promotion"));
                       rse.setPromo(rs.getInt("promo"));
                       list.add(rse);
                   }
               } catch (SQLException ex) {
                   Logger.getLogger(Reservationservices.class.getName()).log(Level.SEVERE, null, ex);
               }
                return list;
    }
/*public static int prixApresPromotion(Reservation r,Promotion p){
    if(p.getType().equalsIgnoreCase("enfant")){
    return r.getPrix()-p.getPromo();
    }
      if(p.getType().equalsIgnoreCase("jeune"))  
          return
              1;
        return 0;
}*/
   public void DeletePromotion(Promotion P){
        try{
            MyConnection connectionDB = new MyConnection();
              String req = " DELETE FROM `promotion` WHERE `id_promotion` =9";
            
            PreparedStatement ps = MyConnection.cnx.prepareStatement(req);
            try {
                ps = connectionDB.cnx.prepareCall(req);
          
                ps.executeUpdate();            
                System.out.println("Promotion supprimer avec succes");
            } catch (SQLException ex) {
                Logger.getLogger(Reservationservices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        catch(Exception e){
                System.out.println(e);
        }
    }
    public Promotion GetPromotionByID(){
        Promotion P=new Promotion();
        try{
            MyConnection connectionDB = new MyConnection();
              String req = " SELECT * FROM `promotion` WHERE `id_promotion` ='30'";
            
            PreparedStatement ps = MyConnection.cnx.prepareStatement(req);
            try {
                ps = connectionDB.cnx.prepareCall(req);
               // ps.setInt(1, P.getIdPromotion());
               ResultSet rs = ps.executeQuery();         
                while (rs.next()) {                
               P.setIdPromotion(rs.getInt("id_promotion"));
               P.setType(rs.getString("type_promotion"));
               P.setPromo(rs.getInt("promo"));

                }
                System.out.println("id_promotion est"+" "+P.getIdPromotion());
            } catch (SQLException ex) {
                Logger.getLogger(Reservationservices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        catch(Exception e){
                System.out.println(e);
        }
        return P;
       
    }
     public void UpdatePromotion(Promotion p){
        try{
            MyConnection connectionDB = new MyConnection();
            String req = "UPDATE `promotion` SET `promo`='30' WHERE id_promotion='30'";
            PreparedStatement ps;
            try {
                ps = connectionDB.cnx.prepareStatement(req);
                ps.executeUpdate();            
                System.out.println("Promotion modifier avec succes");
            } catch (SQLException ex) {
                Logger.getLogger(Reservationservices.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        catch(Exception e){
                System.out.println(e);
        }
 
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;

import edu.esprit.entities.Promotion;
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

    public void InsertIntoReservation(Reservation R,Promotion p) {
        try {
            MyConnection connectionDB = new MyConnection();
            String req = "INSERT INTO `reservation`(`DateReservation`, `nombredeParticipant`,`prix`,`promotion`) VALUES (?,?,?,?)";
            PreparedStatement ps;

            ps = connectionDB.cnx.prepareStatement(req);
            ps.setString(1, R.getDateReservation());
            ps.setInt(2, R.getNombredeParticipant());
            ps.setInt(3, R.getPrix());
            ps.setInt(4, p.getIdPromotion());
            

            ps.executeUpdate();
            System.out.println("Reservation ajoutée avec succes");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<Reservation> displayReservation() {
        List<Reservation> list = new ArrayList<>();
        String req = "select * from reservation";

        MyConnection connectionDB = new MyConnection();

        try {
            Statement st = connectionDB.cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Reservation rse = new Reservation();
                rse.setIdReservation(rs.getInt("idReservation"));
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

    public void DeleteReservation(Reservation r) {
        try {
            MyConnection connectionDB = new MyConnection();
            String req = " DELETE FROM `reservation` WHERE `idReservation` =?";

            PreparedStatement ps = cnx.prepareStatement(req);

            ps = connectionDB.cnx.prepareCall(req);
            ps.setInt(1, r.getIdReservation());
            ps.executeUpdate();
            System.out.println("Reservation supprimer avec succes");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Reservation GetReservationByID(int id) {
        Reservation R = new Reservation();
        try {

            MyConnection connectionDB = new MyConnection();
            String req = " SELECT * FROM `reservation` WHERE `idReservation` =?";

            PreparedStatement ps = connectionDB.cnx.prepareStatement(req);

            ps = connectionDB.cnx.prepareCall(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                R.setIdReservation(rs.getInt(1));
                R.setDateReservation(rs.getString("DateReservation"));
                R.setPrix(rs.getInt("prix"));
                R.setNombredeParticipant(rs.getInt("nombreDeParticipant"));
            }
            System.out.println("Reservation id est" + " " + R.getIdReservation());
        } catch (Exception e) {
            System.out.println(e);
        }
        return R;
    }

    public void UpdateReservation(Reservation R, Promotion P) {
        try {
            MyConnection connectionDB = new MyConnection();
            String req = "UPDATE `reservation` SET `DateReservation`=?,"
                    + "`nombredeParticipant`=?,`prix`=?,`promotion`=? WHERE idReservation=? ";
            PreparedStatement ps;

            ps = connectionDB.cnx.prepareStatement(req);
            ps.setString(1, R.getDateReservation());
            ps.setInt(2, R.getNombredeParticipant());
            ps.setInt(3, R.getPrix());
            ps.setInt(4, R.getProm().getIdPromotion());
            ps.setInt(5, R.getIdReservation());

            ps.executeUpdate();
            System.out.println("Reservation modifier avec succes");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
     public void UpdateReservationUser(Reservation R) {
        try {
            MyConnection connectionDB = new MyConnection();
            String req = "UPDATE `reservation` SET `DateReservation`=?,"
                    + "`nombredeParticipant`=?,`prix`=? WHERE idReservation=? ";
            PreparedStatement ps;

            ps = connectionDB.cnx.prepareStatement(req);
            ps.setString(1, R.getDateReservation());
            ps.setInt(2, R.getNombredeParticipant());
            ps.setInt(3, R.getPrix());
            ps.setInt(4, R.getIdReservation());

            ps.executeUpdate();
            System.out.println("Reservation modifier avec succes");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

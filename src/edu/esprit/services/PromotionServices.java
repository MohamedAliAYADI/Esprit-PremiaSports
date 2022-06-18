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
public class PromotionServices {

    public void InsertIntoPromotion(Promotion p) {
        try {
            MyConnection connectionDB = new MyConnection();
            String req = "INSERT INTO `promotion`(`id_promotion`,`type_promotion`,`promo`) VALUES (?,?,?)";
            PreparedStatement ps;

            ps = connectionDB.cnx.prepareStatement(req);
            ps.setInt(1, p.getIdPromotion());
            ps.setString(2, p.getType());
            ps.setDouble(3, p.getPromo());
            ps.executeUpdate();
            System.out.println("Promotion ajoutée avec succes");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<Promotion> displayPromotion() {
        List<Promotion> list = new ArrayList<>();
        String req = "select * from promotion";

        MyConnection connectionDB = new MyConnection();

        try {
            Statement st = connectionDB.cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Promotion rse = new Promotion();
                rse.setIdPromotion(rs.getInt("id_promotion"));
                rse.setType(rs.getString("type_promotion"));
                rse.setPromo(rs.getFloat("promo"));
                list.add(rse);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Reservationservices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

   

    public void DeletePromotion(Promotion p) {
        try {
            MyConnection connectionDB = new MyConnection();
            String req = " DELETE FROM `promotion` WHERE `id_promotion` =?";

            PreparedStatement ps = cnx.prepareStatement(req);

            ps = connectionDB.cnx.prepareCall(req);
            ps.setInt(1, p.getIdPromotion());
            ps.executeUpdate();
            System.out.println("Promotion supprimer avec succes");
        } catch (SQLException ex) {
            Logger.getLogger(Reservationservices.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Promotion GetPromotionByID(int id) {
        Promotion P = new Promotion();
        try {
            MyConnection connectionDB = new MyConnection();
            String req = " SELECT * FROM `promotion` WHERE `id_promotion` =?";

            PreparedStatement ps = MyConnection.cnx.prepareStatement(req);
            try {
                ps = connectionDB.cnx.prepareCall(req);
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {

                    P.setIdPromotion(rs.getInt("id_promotion"));
                    P.setType(rs.getString("type_promotion"));
                    P.setPromo(rs.getFloat("promo"));

                }
                System.out.println("id_promotion est" + " " + P.getIdPromotion());
            } catch (SQLException ex) {
                Logger.getLogger(Reservationservices.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return P;

    }

    public void UpdatePromotion(Promotion p) {
        try {
            MyConnection connectionDB = new MyConnection();
            String req = "UPDATE `promotion`"+" SET `Type_promotion`=?, `promo`=?"+" WHERE id_promotion=?";
            PreparedStatement ps;
            ps = connectionDB.cnx.prepareStatement(req);
            ps.setInt(3, p.getIdPromotion());
            ps.setString(1, p.getType());
            ps.setDouble(2, p.getPromo());
            ps.executeUpdate();
            System.out.println("Promotion modifier avec succes");
        } catch (SQLException ex) {
            Logger.getLogger(Reservationservices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

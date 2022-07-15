/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;

import edu.esprit.entities.Panier;
import edu.esprit.entities.Produits;
import edu.esprit.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;

/**
 *
 * @author user
 */
public class PanierService {

    Connection cnx = MyConnection.getInstance().cnx;


    public List<Panier> listp() {
        List<Panier> myList = new ArrayList();

        try {
            String requete = "SELECT * FROM panier ";
            PreparedStatement ps = cnx.prepareStatement(requete);
            ResultSet rs = ps.executeQuery(requete);
            while (rs.next()) {
                Panier p = new Panier();
                p.setId(rs.getInt(1));
                p.setQtpanier(rs.getInt(2));
                p.setValid(rs.getInt(3));
                p.setId_prod(rs.getInt(4));
                p.setIdUser(rs.getInt(5));

                myList.add(p);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return myList;

    }

    public Produits getproduitorlist(int id_prod) {
        Produits p = new Produits();
        try {
            String requete1 = "SELECT * FROM produits WHERE produits.id_prod=" + id_prod + "";
            PreparedStatement ps = cnx.prepareStatement(requete1);

            ResultSet rs = ps.executeQuery(requete1);
            while (rs.next()) {
                p.setId_prod(rs.getInt(1));
                p.setNom_prod(rs.getString(2));
                p.setDescription(rs.getString(3));
                p.setPrix(rs.getString(4));
                p.setQuantite(rs.getString(5));
                p.setReference_prod(rs.getString(6));

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return p;
    }

    public int nbproduit() {
        Produits p = new Produits();
        try {
            String requete1 = "SELECT count(id) AS x FROM panier ";
            PreparedStatement ps = cnx.prepareStatement(requete1); 
            ResultSet rs = ps.executeQuery(requete1);
            if (rs.next()) {
                return rs.getInt("x");

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return 0;
    }



    public void supprimer(int id) {

        String requete = "DELETE FROM panier WHERE panier.id=?";

        try {
             PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }


}

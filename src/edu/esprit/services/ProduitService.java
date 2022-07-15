/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;

import edu.esprit.entities.Categories;
import edu.esprit.entities.Commandes;
import edu.esprit.services.CategorieService;
import edu.esprit.entities.Produits;
import edu.esprit.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProduitService {

    Connection cnx = MyConnection.getInstance().cnx;
 
//***************1) ISERT PRODUIT ****************
    public void insertProduits(Produits p) {

        try {
       String req = "INSERT INTO `produits`(`nom_prod`,`reference_prod`, `description` , `prix` ,`quantite`) VALUES (?,?,?,?,?)";

          PreparedStatement ps = cnx.prepareStatement(req);

            ps.setString(1, p.getNom_prod());

            ps.setString(2, p.getReference_prod());
          
           ps.setString(3, p.getDescription());
          
         ps.setString(4, p.getPrix());
        
         
         ps.setString(5, p.getQuantite());  
//         ps.setInt(6, p.getId_catg().getId_catg());
          //ps.setString(7, p.getId_catg());  
  
            ps.executeUpdate();
            
            System.out.println("produit ajouté !");
        } catch (SQLException ex) {
            Logger.getLogger(CategorieService.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

//*****************2) Select*************************
    public List<Produits> selectall() {

        List<Produits> l = new ArrayList<Produits>();

        try {
            String req = "SELECT * FROM `produits`";
            PreparedStatement ps = cnx.prepareStatement(req);
            ResultSet result = ps.executeQuery();

            while (result.next()) {
                int id_prod = result.getInt(1);
                String nom_prod = result.getString(2);
                String reference_prod = result.getString(3);
                 String description = result.getString(4);
                String prix = result.getString(5);
                String Image_prod = result.getString(6);
                 String quantite = result.getString(7);
                 String id_catg = result.getString(8);

                l.add(new Produits(id_prod,nom_prod, reference_prod,description,prix,quantite));

            }

        } catch (SQLException ex) {
            Logger.getLogger(CategorieService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return l;

    }

    //3)GET BY ID 
    //********************GETBYID**************PRODUIT ***************
    public Produits getProduitByID(Produits p1) {

        try {
            String req = "SELECT * FROM `produits` WHERE id_prod = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, p1.getId_prod());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                p1.setId_prod(rs.getInt(1));
                p1.setNom_prod(rs.getString(2));
            }

        } catch (SQLException ex) {
            Logger.getLogger(CategorieService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return p1;

    }

    //4) DELETE 
    //*******************DELET PRODUIT **************************************
    public Produits DeleteProduits(Produits c) {
        try {

            String req = " DELETE FROM `produits` WHERE `id_prod` =? ";

            PreparedStatement statement = cnx.prepareStatement(req);
            statement.setInt(1, c.getId_prod());

            try {
                statement.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(CategorieService.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("Produits Supprimé avec succé");
        } catch (SQLException ex) {
            Logger.getLogger(CategorieService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }

    // **************************UPDATE PRODUIT  *******************
    public void updateProduit(Produits p) {

        try {

        
            String req = "UPDATE `produits`" + " SET `nom_prod`=?, `reference_prod`=? ,`description`=?,`prix`=?, `quantite`=?" + " WHERE id_prod=?";

            PreparedStatement statement = cnx.prepareStatement(req);
            statement.setString(1, p.getNom_prod());
            statement.setString(2, p.getReference_prod());
            statement.setString(3, p.getDescription());
             statement.setString(4, p.getPrix());
             statement.setString(5, p.getQuantite());
           statement.setInt(6, p.getId_prod());

            statement.executeUpdate();

            System.out.println("Produit modifié avec succé");
        } catch (SQLException ex) {
            Logger.getLogger(CategorieService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
//*********************SELECT ALL PRODUIT **************************

    public Produits selectAllaProduits() {

        Produits p2 = new Produits();

        try {
            String req = "SELECT * FROM `produits`";
            PreparedStatement ps = cnx.prepareStatement(req);

            ResultSet result = ps.executeQuery();

            while (result.next()) {
                String nom_prod = result.getString(2);
                String Image_prod = result.getString(3);

                System.out.println("IMAGE PRODUIT  " + Image_prod + "");
                System.out.println("le nom de produit est   " + nom_prod + "");

            }

        } catch (SQLException ex) {
            Logger.getLogger(CategorieService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return p2;

    }

    // *******************
}

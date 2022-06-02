/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.services;

import edu.esprit.entities.Reservation;
import edu.esprit.entities.Terrain;
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
 * @author garbo
 */
public class TerrainService {
    
    
     public void InsertIntoTerrain(Terrain terrain){
        try{
            MyConnection connectionDB = new MyConnection();
            String req = "INSERT INTO `terrain`(`nom`, `type`, `adresse`,`infos`,`contact`) VALUES (?,?,?,?,?)";
            PreparedStatement ps;
            try {
                ps = connectionDB.cnx.prepareStatement(req);
                ps.setString(1, terrain.getNom());
                ps.setString(2, terrain.getType());
                ps.setString(3, terrain.getAdresse());
                ps.setString(4,terrain.getInfos());
                ps.setString(5, terrain.getConatct());
             
                ps.executeUpdate();            
                System.out.println("Terrain ajouter avec succes" );
            } catch (SQLException ex) {
                Logger.getLogger(TerrainService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        catch(Exception e){
                System.out.println(e);
        }
    }
     
     public List<Terrain> displayTerrain(){
         //instance liste de terrain
        List<Terrain> list=new ArrayList<>();
        //ecrire requete sql pour recuperer les terrains
        String req="select * from terrain";
        // etablir la cnx a la base de donéé
                    MyConnection connectionDB = new MyConnection();

try {
    //creation de statement
    Statement st=connectionDB.cnx.createStatement();
    // executer la requette et recuperer le resultat 
                   ResultSet rs= st.executeQuery(req);
                   // tant que on a un resultat
                   while(rs.next()){
                       Terrain terrain=new Terrain();
                       terrain.setAdresse(rs.getString("adresse"));
                       terrain.setConatct(rs.getString("contact"));
                       terrain.setInfos(rs.getString("infos"));
                      terrain.setNom(rs.getString("nom"));
                      terrain.setId(rs.getInt("id"));
                      terrain.setType(rs.getString("type"));
                       //ajouter a la liste
                       list.add(terrain);
                   }
               } catch (SQLException ex) {
                   Logger.getLogger(TerrainService.class.getName()).log(Level.SEVERE, null, ex);
               }
                return list;
    }
    
    
     public void DeleteTerrain(int idTerrain){
        try{
            MyConnection connectionDB = new MyConnection();
              String req = " DELETE FROM `terrain` WHERE `id` ="+idTerrain;
            
            PreparedStatement ps = cnx.prepareStatement(req);
            try {
                ps = connectionDB.cnx.prepareCall(req);
          
                ps.executeUpdate();            
                System.out.println("terrain supprimer avec succes");
            } catch (SQLException ex) {
                Logger.getLogger(TerrainService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        catch(Exception e){
                System.out.println(e);
        }
    }
     
         public void updateTerrain(Terrain terrain)  {

             MyConnection connectionDB = new MyConnection();
            String requete = "UPDATE `terrain` SET nom='" + terrain.getNom() + "' "
                    + ",type='" + terrain.getType() +"',infos='"+terrain.getInfos()+ "' ,contact='" + terrain.getConatct() + "'  "
                    + ",adresse='" + terrain.getAdresse() +"'"
                    + " where id= " + terrain.getId() + " ;";
            Statement st;
         try {
             st = connectionDB.cnx.createStatement();
         
       
            st.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(TerrainService.class.getName()).log(Level.SEVERE, null, ex);
        }
            System.out.println("Mise à jour effectuée avec succès");


        
    }
    
}








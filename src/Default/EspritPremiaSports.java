/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Default;

import edu.esprit.entities.Terrain;
import edu.esprit.services.Reservationservices;
import edu.esprit.services.TerrainService;
import edu.esprit.utils.MyConnection;
import java.sql.SQLException;

/**
 *
 * @author Geekz
 */
public class EspritPremiaSports {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("EspritPremiaSports !");
  MyConnection mc= MyConnection.getInstance();
        Reservationservices rse=new Reservationservices();
        System.out.println(rse.displayReservation());

        Terrain terrain =new Terrain("sansiro", "foot", "ariana", "jour", "712547889");

        TerrainService terrainservcie =new TerrainService();
        
       terrainservcie.InsertIntoTerrain(terrain);
       
       System.out.println(terrainservcie.displayTerrain());
       terrainservcie.DeleteTerrain(1);
       
       Terrain terrainmodifier=new Terrain(3,"camp nou", "foot", "ariana", "jour", "712547889");
       
       terrainservcie.updateTerrain(terrainmodifier);
    }
    
    
}

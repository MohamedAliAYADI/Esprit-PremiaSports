/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Default;

import java.io.IOException;
import java.util.logging.Level;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import edu.esprit.services.ParticipationService;
import edu.esprit.services.Reservationservices;
import edu.esprit.utils.MyConnection;

/**
 *
 * @author Geekz
 */
public class EspritPremiaSports extends Application {

    /**
     * @param args the command line arguments
     */
    	@Override
        public void start(Stage primaryStage) {
           
            
            try {
                
            //Parent root = new FXMLLoader().load(getClass().getResource("..//GUI/UpdatePromotionReservationTranning.fxml"));
            Parent root = new FXMLLoader().load(getClass().getResource("..//GUI/ListCoachNotes.fxml"));
            //Parent root = new FXMLLoader().load(getClass().getResource("..//GUI/UpdatePromotionReservationTranning.fxml"));
                Scene scene = new Scene(root, 1100, 570);
                primaryStage.setScene(scene);
                primaryStage.show();
            } catch (IOException ex) {
                //Logger.getLogger(EspritPremiaSports.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        /**
         * @param args the command line arguments
         */
        public static void main(String[] args) {
            launch(args);
        }
    
}

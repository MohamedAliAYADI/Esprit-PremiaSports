package edu.esprit.tests;

import java.util.Date;

import edu.esprit.entities.ReservationTraining;
import edu.esprit.services.ReservationTranningService;
import edu.esprit.utils.MyConnection;

public class MainClassCoaching {
    public static void main(String[] args) {

        System.out.println("Coaching ClassMain test");
     	// create instance
        MyConnection mc= MyConnection.getInstance();
        // testing some entity
              
        ReservationTraining rt = new ReservationTraining(21, 10,"Mach footbal red vs blue","Match football", "in progress", "2022-11-28 23:55:59.342380","2022-11-28 23:55:59.342380", 19);
        ReservationTranningService rts = new ReservationTranningService();
        
        rts.addReservation(rt);
        
     }
}
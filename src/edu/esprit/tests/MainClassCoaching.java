package edu.esprit.tests;

import java.util.Date;

import edu.esprit.entities.Coach;
import edu.esprit.entities.ReservationTraining;
import edu.esprit.services.CoachService;
import edu.esprit.services.ReservationTranningService;
import edu.esprit.utils.MyConnection;

public class MainClassCoaching {
    public static void main(String[] args) {

        System.out.println("Coaching ClassMain test");
     	// create instance
        MyConnection mc= MyConnection.getInstance();
        // testing some entity
              
        Coach c = new Coach("Mohamed Ali", "Ayadi", "male" , "01/03/2020", "ayadi.mohamedali@esprit.tn", "Referee", "Freelancer");

        ReservationTraining rt = new ReservationTraining(21, 10,"Mach footbal red vs blue","Match football", "in progress", "2022-11-28 23:55:59.342380","2022-11-28 23:55:59.342380", 19);
        CoachService cs = new CoachService();
        ReservationTranningService rts = new ReservationTranningService();
        
        cs.addCoach(c);
        rts.addReservation(rt);
        
     }
}
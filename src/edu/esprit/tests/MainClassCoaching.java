package edu.esprit.tests;

import java.util.Date;

import edu.esprit.entities.Coach;
import edu.esprit.entities.ReservationTraining;
import edu.esprit.utils.MyConnection;

public class MainClassCoaching {
    public static void main(String[] args) {

        System.out.println("Coaching ClassMain test");
     	// create instance
        MyConnection mc= MyConnection.getInstance();
        // testing some entity
              
        Coach e = new Coach("Mohamed Ali", "Ayadi", "male" , new Date(), "ayadi.mohamedali@esprit.tn", "Referee", "Freelancer");
        ReservationTraining rt = new ReservationTraining();

     }
}
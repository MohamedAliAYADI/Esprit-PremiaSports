/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Default;

import edu.esprit.entities.Participation;
import edu.esprit.services.EventService;
import edu.esprit.services.ParticipationService;
import edu.esprit.services.Reservationservices;
import edu.esprit.utils.MyConnection;

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
 // MyConnection mc= MyConnection.getInstance();
//        Reservationservices rse=new Reservationservices();
//        System.out.println(rse.displayReservation());
        
        
        //********** event and participation ************
            EventService es=new EventService();
            ParticipationService ps=new ParticipationService();
            edu.esprit.entities.Event event1=new edu.esprit.entities.Event(29,"Basket ball", "Basket ball", "20/09/2022", "5/06/2022");
            Participation p=new Participation("I'm intrested with this event", event1);
            
           
         
       
           //*****event crud
           
           edu.esprit.entities.Event event2=new edu.esprit.entities.Event("Basket ball", "Basket ball", "20/09/2022", "5/06/2022");
           // add event first method
           //es.insertEvent1(event1);
           // add event secand method
           //es.insertEvent2(event1);
           // select all events
           //System.out.println(es.displayEvent());
           // update event 
           //es.modifyEvent(event1, "20/2000000000000");
           //delete event
           //es.deleteEvent(event1);
           
           //******participation crud
           
           //add participation
           //ps.inserteParticipation(p);
           //display all participations
           //System.out.println(ps.displayParticipations());
    }
    
}

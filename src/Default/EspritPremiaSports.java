/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Default;

import edu.esprit.entities.Promotion;
import edu.esprit.entities.Reservation;
import edu.esprit.services.PromotionServices;
import edu.esprit.services.Reservationservices;
import edu.esprit.utils.MyConnection;

public class EspritPremiaSports {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("EspritPremiaSports !");
        MyConnection mc = MyConnection.getInstance();
        Reservationservices rse = new Reservationservices();

        Reservation r1 = new Reservation();
  
        Promotion pr = new Promotion();
       
      
        // rse.InsertIntoReservation(r2,pr3);
        //  rse.DeleteReservation(56);
        //  System.out.println( rse.displayReservation());

        // System.out.println(rse.GetReservationByID(68));
        //rse.UpdateReservation(r5, pr);
        //***************promotion************
         //prs.DeletePromotion(44);
        // System.out.println(prs.GetPromotionByID(1));
        // prs.InsertIntoPromotion(pr4);
        //  System.out.println( prs.displayPromotion());
        //prs.UpdatePromotion(pr3);
    }

}

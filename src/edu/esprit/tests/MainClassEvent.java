package edu.esprit.tests;

import edu.esprit.entities.Event;
import edu.esprit.utils.MyConnection;


/**
 *
 * @author Geekz
 */
public class MainClassEvent {
    public static void main(String[] args) {

       System.out.println("Event ClassMain test");
    	// create instance
       MyConnection mc= MyConnection.getInstance();
       // testing some entity
       Event e = new Event();
    }
    
}

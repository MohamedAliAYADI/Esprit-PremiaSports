package edu.esprit.tests;

import edu.esprit.entities.EntityTest;
import edu.esprit.utils.MyConnection;



public class MainClassEvent {
    public static void main(String[] args) {

    	MyConnection connectDB = MyConnection.getInstance();
    	EntityTest et = new EntityTest(12);
    	System.out.println(et.toString());
    }
    
}

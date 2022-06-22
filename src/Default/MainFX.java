/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Default;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class MainFX extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        try {
            
        String myMobile ="90680010";
        String SMS="hello";
        String mySender="mySender";
        String Url="https://www.tunisiesms.tn/client/Api/Api.aspx?fct=sms&key=OrGLZv3yXPMfWZnPn6YgcBUiVxCbXCGEuHJpIUtlGT8Fd3DomSsKqpZvNKpmfRMPS/-//-/kRVsJDSSodVKBIEHtRnhxbGBZVcaC";
        Url=Url.replace("21690680010", myMobile);
        Url=Url.replace("hello", SMS);
        
        URL myURL   = new URL   (Url);
        URLConnection myURLConnection = myURL.openConnection();
        myURLConnection.connect();
        
            //root 
            Parent  root = FXMLLoader.load(getClass().getResource("..//gui//loginpage.fxml"));
      
            Scene scene = new Scene(root);
            //scen yconnsomi f root
            
        primaryStage.setTitle("PremiaSports");
        primaryStage.setScene(scene);
        primaryStage.show(); 
        
        
        
        } catch (IOException ex) {
            Logger.getLogger(MainFX.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        
    }
    
}

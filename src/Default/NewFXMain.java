/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Default;


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Slimen OUNI
 */
public class NewFXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("..//GUI//Login.fxml"));
            
            primaryStage.initStyle(StageStyle.UNDECORATED);
            
            Scene scene = new Scene(root, 520, 420);
           
           // primaryStage.setTitle("PremiaSports");
            primaryStage.setScene(scene);
            primaryStage.show();
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(NewFXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
       
    }
    
}

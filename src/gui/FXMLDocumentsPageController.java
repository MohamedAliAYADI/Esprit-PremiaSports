/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLDocumentsPageController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void CommandePagedisplay(ActionEvent event) {
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("loginpage.fxml"));
        Scene scene = new Scene(root);
        Stage stage =(Stage)((Node) event.getSource()).getScene().getWindow();  
        stage.setScene(scene);
        stage.show();
        
    }

    @FXML
    private void Categoriesds(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("CategoriesDisplay.fxml"));
        Scene scene = new Scene(root);
        Stage stage =(Stage)((Node) event.getSource()).getScene().getWindow();  
        stage.setScene(scene);
        stage.show();
    }

   

    @FXML
    private void gotodispolayprod(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ProduitDisplay.fxml"));
        Scene scene = new Scene(root);
        Stage stage =(Stage)((Node) event.getSource()).getScene().getWindow();  
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void gotoreclamation(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("clientReclamation.fxml"));
        Scene scene = new Scene(root);
        Stage stage =(Stage)((Node) event.getSource()).getScene().getWindow();  
        stage.setScene(scene);
        stage.show();
    }
}

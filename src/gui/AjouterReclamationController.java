/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import edu.esprit.entities.Reclamation;
import edu.esprit.services.ReclamationService;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class AjouterReclamationController implements Initializable {

    @FXML
    private Button SubmitButton;
    @FXML
    private Text deco;
    @FXML
    private TextArea sujet;
    @FXML
    private TextArea statut;
    @FXML
    private TextArea description;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AjouterReclamation(ActionEvent event) {
         if (sujet.getText().isEmpty() || description.getText().isEmpty()  ) {
            Alert a = new Alert(Alert.AlertType.ERROR, "Vous avez rien noté", ButtonType.OK);
            a.showAndWait();
        } else {
           
         
        
        
        ReclamationService rs= new ReclamationService();
       Reclamation r = new Reclamation ( sujet.getText() , description.getText(), statut.getText());
       
                Alert a = new Alert(Alert.AlertType.INFORMATION, "Reclamation ajouté!", ButtonType.OK);
                a.showAndWait();
        
        rs.insertReclamation(r);
        
    }
    }

    @FXML
    private void deco(MouseEvent event) {
    }

    @FXML
    private void goback(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Reclamation.fxml"));
        Scene scene = new Scene(root);
        Stage stage =(Stage)((Node) event.getSource()).getScene().getWindow();  
        stage.setScene(scene);
        stage.show();
    }
    
}

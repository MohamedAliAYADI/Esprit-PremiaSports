/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import edu.esprit.entities.Categories;
import edu.esprit.services.CategorieService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author user
 */
public class CommandeDisplayController implements Initializable {

    @FXML
    private ListView<?> lsvProducts;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;
          

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
        
    }    

    @FXML
    private void updateButton(ActionEvent event) {
    }

    @FXML
    private void deleteButton(ActionEvent event) {
        
    }
    
}

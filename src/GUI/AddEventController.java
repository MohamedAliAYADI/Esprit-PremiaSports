/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author nemya
 */
public class AddEventController implements Initializable {
     @FXML
    private JFXTextField nameFld;
    @FXML
    private JFXDatePicker birthFld;
    @FXML
    private JFXTextField adressFld;
    @FXML
    private JFXTextField emailFld;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void save(MouseEvent event) {
    }

    @FXML
    private void clean(MouseEvent event) {
    }
    
}

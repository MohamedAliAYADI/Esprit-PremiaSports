/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author user
 */
public class MofidierReclamationController implements Initializable {

    @FXML
    private Label Rtype;
    @FXML
    private TextField Sujet;
    @FXML
    private TextField NUAreclamer;
    @FXML
    private TextArea Description;
    @FXML
    private Button SubmitButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void usertoclaimsearch(MouseEvent event) {
    }

    @FXML
    private void ModifierR(ActionEvent event) {
    }

    @FXML
    private void retourimg(MouseEvent event) {
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;

/**
 * FXML Controller class
 *
 * @author Slimen OUNI
 */
public class ChangePasswordController implements Initializable {

    @FXML
    private PasswordField PasswordIn;
    @FXML
    private PasswordField PasswordInConfirm;
    @FXML
    private Button CancelBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void RetoutAction(ActionEvent event) {
    }

    @FXML
    private void ValidateChangeAction(ActionEvent event) {
    }

    @FXML
    private void Quit(ActionEvent event) {
    }
    
}

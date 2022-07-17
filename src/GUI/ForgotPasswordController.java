/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import edu.esprit.services.EmailServices.MailSender;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.mail.MessagingException;
import se.mbaeumer.fxmessagebox.MessageBox;
import se.mbaeumer.fxmessagebox.MessageBoxResult;
import se.mbaeumer.fxmessagebox.MessageBoxType;

/**
 * FXML Controller class
 *
 * @author Slimen OUNI
 */
public class ForgotPasswordController implements Initializable {

    @FXML
    private Button CancelBtn;
    @FXML
    private TextField emailIn;
    
       private Stage stage;
 private Scene scene;
 private Parent root;   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void RetoutAction(ActionEvent event) throws IOException {
          root = FXMLLoader.load(getClass().getResource("Login.fxml"));
  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
    }

    @FXML
    private void CancelBtnAction(ActionEvent event) {
  MessageBox mb = new MessageBox("Voulez-vous vraiment quitter?", MessageBoxType.OK_CANCEL);
mb.showAndWait();
if (mb.getMessageBoxResult() == MessageBoxResult.OK){
      Stage stage = (Stage) CancelBtn.getScene().getWindow();
        stage.close();
	System.out.println("Application Closed");
}else{
	System.out.println("Cancel");
}
     
    }

    @FXML
    private void ValiderEmailAction(ActionEvent event) throws MessagingException {
        validation();
        MailSender.SendSOSMail(emailIn.getText(),emailIn.getText());
        EmailSentSuccess();
        
    }
    
        public void validation(){                

    if((emailIn.getText().compareTo("") == 0)){
        Alert fail= new Alert(Alert.AlertType.INFORMATION);
        fail.setHeaderText("Erreur");
        fail.setContentText("tu n'as rien tapé");
        fail.showAndWait();
    } 
}
                public void EmailSentSuccess(){                

  
        Alert fail= new Alert(Alert.AlertType.CONFIRMATION);
        fail.setHeaderText("Email envoyé avec success");
        fail.setContentText("vérifier votre boîte de réception");
        fail.showAndWait();
    } 

    
}

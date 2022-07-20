/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import edu.esprit.entities.User;
import edu.esprit.services.UserService;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.management.Notification;
import org.apache.commons.codec.digest.DigestUtils;
import org.controlsfx.control.Notifications;
import tray.animations.AnimationType;
import tray.notification.TrayNotification;

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
    private ImageView passwordCheckMark;
    @FXML
    private ImageView passwordCheckMarkBis;
    private Object root;
    private Stage stage;
    private Scene scene;
    @FXML
    private Label id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


      
    public void Myfunction(int idd){
   id.setText(String.valueOf(idd));
    }
    
    
    @FXML
    private void ValidateChangeAction(ActionEvent event) throws IOException {
        
        if(!testSaisie()){
            Emptynotif();
        }
        
        else {
        UserService us = new UserService();
        User u = new User();
        u.setPassword(DigestUtils.shaHex(PasswordIn.getText()));
            System.out.println("Change Password id :"+ id.getText());
            int i = Integer.parseInt(id.getText());
        u.setId(i);
        us.updateUserPassword(u);
        
         root = FXMLLoader.load(getClass().getResource("Login.fxml"));
  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  scene = new Scene((Parent) root);
  stage.setScene(scene);
  stage.show();
  
            ChangedPassWithSuccess();
        
        } 
    }

    @FXML
    private void RetoutAction(MouseEvent event) throws IOException {
                       root = FXMLLoader.load(getClass().getResource("Login.fxml"));
  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  scene = new Scene(   (Parent) root);
  stage.setScene(scene);
  stage.show();
    }

    
        public void Emptynotif() {
    Image whatsAppImg = new Image("GUI/assets/img/alarm.png");

        TrayNotification tray = new TrayNotification();
        tray.setTitle("Les champs sont vides!");
	tray.setMessage("Vous n'a rien entrer");
	tray.setRectangleFill(Paint.valueOf("#FF0000"));
        AnimationType type = AnimationType.SLIDE;
	tray.setAnimationType(type);
	tray.setImage(whatsAppImg);
	tray.showAndDismiss(Duration.seconds(3));
    }
        
             public void ChangedPassWithSuccess() {
    Image whatsAppImg = new Image("GUI/assets/img/alarm.png");

        TrayNotification tray = new TrayNotification();
        tray.setTitle("Your password was changed with success");
	tray.setMessage("You may login now with your new password");
	tray.setRectangleFill(Paint.valueOf("#FF0000"));
        AnimationType type = AnimationType.SLIDE;
	tray.setAnimationType(type);
	tray.setImage(whatsAppImg);
	tray.showAndDismiss(Duration.seconds(3));
    }
    
     @FXML
    private Boolean testPassword() {
            
   String passwordRegex = "^(?=.*[A-Z].*[A-Z])"
           + "(?=.*[!@#$&*])"
           + "(?=.*[0-9].*[0-9])"
           + "(?=.*[a-z].*[a-z].*[a-z])"
           + ".{8,}$";

        Pattern pat = Pattern.compile(passwordRegex);
        if (PasswordIn.getText() == null) {
            return false;
        }

        if (pat.matcher(PasswordIn.getText()).matches() == false) {
            passwordCheckMark.setImage(new Image("GUI/assets/img/erreurcheckMark.png"));
//                erreur = erreur + ("Veuillez verifier votre adresse email\n");
            return false;
//            

        } else {
           passwordCheckMark.setImage(new Image("GUI/assets/img/checkMark.png"));
        }
        
      
        
        return true;
    }

    @FXML
    private boolean testpass2() {
       String passwordRegex = "^(?=.*[A-Z].*[A-Z])"
           + "(?=.*[!@#$&*])"
           + "(?=.*[0-9].*[0-9])"
           + "(?=.*[a-z].*[a-z].*[a-z])"
           + ".{8,}$";

        Pattern pat = Pattern.compile(passwordRegex);
        if (PasswordIn.getText() == null) {
            return false;
        }

        if (pat.matcher(PasswordIn.getText()).matches() == false) {
            passwordCheckMark.setImage(new Image("GUI/assets/img/erreurcheckMark.png"));
//                erreur = erreur + ("Veuillez verifier votre adresse email\n");
            return false;
//            

        } else {
           passwordCheckMark.setImage(new Image("GUI/assets/img/checkMark.png"));
        }
        
         if(PasswordIn.getText().compareTo(PasswordInConfirm.getText()) == 0){
            passwordCheckMarkBis.setImage(new Image("GUI/assets/img/checkMark.png"));
        } else {
             passwordCheckMarkBis.setImage(new Image("GUI/assets/img/erreurcheckMark.png"));
        }
        
      
        
        return true;
    }
    
    
       private boolean testSaisie() {
        String erreur = "";
        if (testPassword()) {
            erreur = erreur + "Veuillez verifier que votre code est juste \n";
        }
        if(testpass2()){
         erreur = erreur + "Veuillez verifier que votre email est juste \n";
        }
        if ( !testPassword() || !testpass2()) {
         Notifications n = Notifications.create()
                    .title("Erreur de format")
                    .text(erreur)
                    .graphic(null)
                    .position(Pos.TOP_CENTER)
                    .hideAfter(Duration.seconds(6));
                    n.showWarning();
        }

        return testPassword()&& testpass2();
    }
    

    @FXML
    private void Quit(MouseEvent event) {
                 Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Vous allez quitter l'application");
        alert.setHeaderText("Vous allez quitter l'application");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            System.exit(0);
        } else {
            alert.close();
        }
    }

  
    
    
}

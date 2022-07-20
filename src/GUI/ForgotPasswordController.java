/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import edu.esprit.entities.User;
import edu.esprit.services.EmailServices.MailSender;
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
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.mail.MessagingException;
import org.controlsfx.control.Notifications;
import tray.animations.AnimationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author Slimen OUNI
 */
public class ForgotPasswordController implements Initializable {

    private Button CancelBtn;
    @FXML
    private TextField emailIn;
    
       private Stage stage;
 private Scene scene;
 private Parent root;   
    @FXML
    private ImageView emailCheckMark;
    private Notifications n;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

        UserService us = new UserService();
        User u = new User();
        //u.setEmail(emailIn.getText());
    
    @FXML
    private void ValiderEmailAction(ActionEvent event) throws MessagingException, IOException {
        if(!testSaisie()){
            Emptynotif();
        }
        else {
        User u = new User();
        User u1 = new User();
        UserService us = new UserService();
        u.setEmail(emailIn.getText());
        u1 = us.listUserByEmail(u);
            System.out.println(u1);
            if(u1.getEmail() == null){
                 
                     NotifEmailNotUsed(emailIn.getText());
            }
            else {
                 MailSender.SendRandCodeEmail(u1.getEmail(), u1.getEmail(), u1);
                  NotifEmail(emailIn.getText());
                     root = FXMLLoader.load(getClass().getResource("RandCodeGuiInput.fxml"));
  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
            }
        }
    }
    
    
            public void NotifEmailNotUsed(String email) {
    Image whatsAppImg = new Image("GUI/assets/img/man.png");

        TrayNotification tray = new TrayNotification();
        tray.setTitle("Sorry this email doesn't exsit");
	tray.setMessage("verfiy your email please");
	tray.setRectangleFill(Paint.valueOf("#FF0000"));
        AnimationType type = AnimationType.SLIDE;
	tray.setAnimationType(type);
	tray.setImage(whatsAppImg);
	tray.showAndDismiss(Duration.seconds(3));
                emailCheckMark.setImage(new Image("GUI/assets/img/erreurcheckMark.png"));

    }
    
    
    
         public void NotifEmail(String email) {
    Image whatsAppImg = new Image("GUI/assets/img/man.png");

        TrayNotification tray = new TrayNotification();
        tray.setTitle("Forgot password email is sent!!");
	tray.setMessage("Check your inbox");
	tray.setRectangleFill(Paint.valueOf("#FF0000"));
        AnimationType type = AnimationType.SLIDE;
	tray.setAnimationType(type);
	tray.setImage(whatsAppImg);
	tray.showAndDismiss(Duration.seconds(3));
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
  
    
          public void EmailSentSuccess(){                

  
        Alert fail= new Alert(Alert.AlertType.CONFIRMATION);
        fail.setHeaderText("Email envoyé avec success");
        fail.setContentText("vérifier votre boîte de réception");
        fail.showAndWait();
    } 

    @FXML
    private void RetoutAction(MouseEvent event) throws IOException {
                  root = FXMLLoader.load(getClass().getResource("Login.fxml"));
  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
    }

    @FXML
    private void CancelBtnAction(MouseEvent event) {
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

    @FXML
    private Boolean testMail() {
           String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."
                + "[a-zA-Z0-9_+&*-]+)*@"
                + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
                + "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (emailIn.getText() == null) {
            return false;
        }

        if (pat.matcher(emailIn.getText()).matches() == false) {
            emailCheckMark.setImage(new Image("GUI/assets/img/erreurcheckMark.png"));
    //  erreur = erreur + ("Veuillez verifier votre adresse email\n");
            return false;
//            

        } else {
           emailCheckMark.setImage(new Image("GUI/assets/img/checkMark.png"));
        }
        return true;
        
    }
    
         private boolean testSaisie() {
        String erreur = "";
        if (testMail()) {
            erreur = erreur + "Veuillez verifier que votre adresse email est de la forme : ***@***.** \n";
        }
        if (!testMail()) {
            n = Notifications.create()
                    .title("Erreur de format")
                    .text(erreur)
                    .graphic(null)
                    .position(Pos.TOP_CENTER)
                    .hideAfter(Duration.seconds(6));
            n.showWarning();
        }

        return testMail() ;
    }

    }

    


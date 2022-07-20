/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Loader;
import javafx.scene.image.Image;
import edu.esprit.entities.Client;
import edu.esprit.entities.User;
import edu.esprit.services.ClientService;
import edu.esprit.services.UserService;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import se.mbaeumer.fxmessagebox.MessageBox;
import se.mbaeumer.fxmessagebox.MessageBoxResult;
import se.mbaeumer.fxmessagebox.MessageBoxType;
import tray.animations.AnimationType;
import tray.notification.TrayNotification;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Paint;
import javafx.scene.image.ImageView;
import org.apache.commons.codec.digest.DigestUtils;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Slimen OUNI
 */
public class LoginController implements Initializable {

    @FXML
    private TextField pseudoIn;
    @FXML
    private PasswordField passwordIn;
    private Button CancelBtn;
    
    
 private Stage stage;
 private Scene scene;
 private Parent root;
    @FXML
    private ImageView pseudoCheckMark;
    @FXML
   private ImageView PasswordCheckMark;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
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
        public void NotifLogin(String pseudo, String role, String message,String salutation) {
    Image whatsAppImg = new Image("GUI/assets/img/"+role+".png");

        TrayNotification tray = new TrayNotification();
        tray.setTitle(salutation+" "+pseudo);
	tray.setMessage(message);
	tray.setRectangleFill(Paint.valueOf("#FF0000"));
        AnimationType type = AnimationType.SLIDE;
	tray.setAnimationType(type);
	tray.setImage(whatsAppImg);
	tray.showAndDismiss(Duration.seconds(3));
    }
    
      public void GrantedAccessnotif() {
          
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
      
        
      public void UknownUserNotif() {
          
    Image whatsAppImg = new Image("GUI/assets/img/error.png");

        TrayNotification tray = new TrayNotification();
        tray.setTitle("Utilisateur inconnue");
	tray.setMessage("cette utilisateur n'exsite pas");
	tray.setRectangleFill(Paint.valueOf("#FF0000"));
        AnimationType type = AnimationType.SLIDE;
	tray.setAnimationType(type);
	tray.setImage(whatsAppImg);
	tray.showAndDismiss(Duration.seconds(3));
    }
      
      
    @FXML
    private void LoginAction(ActionEvent event) throws IOException {
        
        
        
       if(!testSaisie()) {
            Emptynotif();
       }
       else {
        User u = new User();
        User u1 = new User();
        UserService us = new UserService();
        u.setPseudo(pseudoIn.getText());
        u.setPassword(DigestUtils.shaHex(passwordIn.getText()));
        //u.setPassword(passwordIn.getText());
       u1 = (User) us.listUserByPseudo(u);
        System.out.println("ff"+u1);
        if( u1.getStatus() == 0){
          NotifLogin(u1.getPseudo(), "padlock", "Account Locked", "Bonjour");
          System.out.println("Account Locked");
      }
        else {
      if (!u1.getPseudo().equals(pseudoIn.getText()) && !u1.getPassword().equals(passwordIn.getText())){
         
          System.out.println("Unknown User");
          UknownUserNotif();
      }
     
      else {  
          if(u1.getRole() == 1 ) {
              NotifLogin(u1.getPseudo(), "groom", "Vous etes connecté en tant que client", "Bonjour");
                FXMLLoader loader =new FXMLLoader(getClass().getResource("ClientGuiHomePage.fxml"));
               Parent root = (Parent) loader.load();
                ClientGuiHomePageController ClientCont = loader.getController();
                ClientCont.Myfunction(pseudoIn.getText());
  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
 scene = new Scene(root);
 stage.setScene(scene);
 stage.show();
          }
           else   if(u1.getRole() == 2 ) {
            NotifLogin(u1.getPseudo(), "manager", "Vous etes connecté en tant que moderateur", "Bonjour");
                FXMLLoader loader =new FXMLLoader(getClass().getResource("ClientGuiHomePage.fxml"));
               Parent root = (Parent) loader.load();
                ClientGuiHomePageController ClientCont = loader.getController();
                ClientCont.Myfunction(pseudoIn.getText());
  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
 scene = new Scene(root);
 stage.setScene(scene);
 stage.show();
              }
              else    if(u1.getRole() == 3 ) {
            NotifLogin(u1.getPseudo(), "businessman", "Vous etes connecté en tant que prop de club", "Bonjour");
               FXMLLoader loader =new FXMLLoader(getClass().getResource("ClientGuiHomePage.fxml"));
               Parent root = (Parent) loader.load();
                ClientGuiHomePageController ClientCont = loader.getController();
                ClientCont.Myfunction(pseudoIn.getText());
  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
 scene = new Scene(root);
 stage.setScene(scene);
 stage.show();
                  }
                else      if(u1.getRole() == 4 ) {
           NotifLogin(u1.getPseudo(), "businessman", "Vous etes connecté en tant que prop de complexe", "Bonjour");
         
                            FXMLLoader loader =new FXMLLoader(getClass().getResource("ClientGuiHomePage.fxml"));
               Parent root = (Parent) loader.load();
                ClientGuiHomePageController ClientCont = loader.getController();
                ClientCont.Myfunction(pseudoIn.getText());
  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
 scene = new Scene(root);
 stage.setScene(scene);
 stage.show();
                      
                      }
                      else    if(u1.getRole() == 5 ) {
             NotifLogin(u1.getPseudo(), "man", "Vous etes connecté en tant que coach", "Bonjour");
                                FXMLLoader loader =new FXMLLoader(getClass().getResource("ClientGuiHomePage.fxml"));
               Parent root = (Parent) loader.load();
                ClientGuiHomePageController ClientCont = loader.getController();
                ClientCont.Myfunction(pseudoIn.getText());
  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
 scene = new Scene(root);
 stage.setScene(scene);
 stage.show();
                          }
                          
                         else {
                NotifLogin(u1.getPseudo(), "man", "Vous etes connecté en tant que ADMIN", "Bonjour");
             FXMLLoader loader =new FXMLLoader(getClass().getResource("UserManagement.fxml"));
               Parent root = (Parent) loader.load();
//                ClientGuiHomePageController ClientCont = loader.getController();
//                ClientCont.Myfunction(pseudoIn.getText());
  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
 scene = new Scene(root);
 stage.setScene(scene);
 stage.show();
                          }
        

      
      } 
        }
    }
    }
    
    
    

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
    private void PseudoFogot(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("ForgotPseudo.fxml"));
  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
    }

    
    @FXML
    private void PasswordForgot(ActionEvent event) throws IOException {
    
        
root = FXMLLoader.load(getClass().getResource("ForgotPassword.fxml"));
  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
  
    }

    @FXML
    private void SignUpAction(ActionEvent event) throws IOException {
    root = FXMLLoader.load(getClass().getResource("Signup.fxml"));
  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
    }

  

    @FXML
    private void closeApplication(MouseEvent event) {
        
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
    private Boolean testPseudo() {
        int nbNonChar = 0;
        for (int i = 1; i < pseudoIn.getText().trim().length(); i++) {
            char ch = pseudoIn.getText().charAt(i);
            if (!Character.isLetter(ch)) {
                nbNonChar++;
            }
        }

        if (nbNonChar == 0 && pseudoIn.getText().trim().length() >= 3) {
            pseudoCheckMark.setImage(new Image("GUI/assets/img/checkMark.png"));
            return true;
        } else {
            pseudoCheckMark.setImage(new Image("GUI/assets/img/erreurcheckMark.png"));
//                erreur = erreur + ("Pas de caractere permit dans le telephone\n");
            return false;

        }

    }

       @FXML
    private Boolean testPassword() {
   String passwordRegex = "^(?=.*[A-Z].*[A-Z])"
           + "(?=.*[!@#$&*])"
           + "(?=.*[0-9].*[0-9])"
           + "(?=.*[a-z].*[a-z].*[a-z])"
           + ".{8,}$";

        Pattern pat = Pattern.compile(passwordRegex);
        if (passwordIn.getText() == null) {
            return false;
        }

        if (pat.matcher(passwordIn.getText()).matches() == false) {
            PasswordCheckMark.setImage(new Image("GUI/assets/img/erreurcheckMark.png"));
//                erreur = erreur + ("Veuillez verifier votre adresse email\n");
            return false;
//            

        } else {
           PasswordCheckMark.setImage(new Image("GUI/assets/img/checkMark.png"));
        }
        
      
        
        return true;
    }
    
    
     private Boolean testSaisie() {
        String erreur = "";
          if (!testPseudo()) {
            erreur = erreur + ("Veuillez verifier votre Pseudo");
        }
          if(!testPassword()){
           erreur = erreur + ("Veuillez verifier votre Mot de pass");

          }
   

        if (!testPseudo()||!testPassword()) {
            Notifications n = Notifications.create()
                    .title("Erreur de format")
                    .text(erreur)
                    .graphic(null)
                    .position(Pos.TOP_CENTER)
                    .hideAfter(Duration.seconds(6));
            n.showWarning();
        }

        return testPassword() && testPseudo();
    }


    
    

}

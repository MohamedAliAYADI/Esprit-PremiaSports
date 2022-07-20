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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import tray.animations.AnimationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author Slimen OUNI
 */
public class RandCodeGuiInputController implements Initializable {

        private Stage stage;
 private Scene scene;
 private Parent root; 
    @FXML
    private TextField codeIn;
    @FXML
    private ImageView codeCheckMark;
    private Notifications n;
    @FXML
    private TextField emailIn;
    @FXML
    private ImageView emailCheckMark;
    @FXML
    private Label id;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

        @FXML
    private void RetoutAction(MouseEvent event) throws IOException {
        
        
        
        
 
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
    private boolean testCode() {
            String emailRegex = "[a-z]{10,}";

        Pattern pat = Pattern.compile(emailRegex);
        if (codeIn.getText() == null) {
            return false;
        }

        if (pat.matcher(codeIn.getText()).matches() == false) {
            codeCheckMark.setImage(new Image("GUI/assets/img/erreurcheckMark.png"));
    //  erreur = erreur + ("Veuillez verifier votre adresse email\n");
            return false;
//            

        } else {
           codeCheckMark.setImage(new Image("GUI/assets/img/checkMark.png"));
        }
        return true;
    }
    
     @FXML
    private boolean testMail() {
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
        if (testCode()) {
            erreur = erreur + "Veuillez verifier que votre code est juste \n";
        }
        if(testMail()){
         erreur = erreur + "Veuillez verifier que votre email est juste \n";
        }
        if (!testCode()) {
            n = Notifications.create()
                    .title("Erreur de format")
                    .text(erreur)
                    .graphic(null)
                    .position(Pos.TOP_CENTER)
                    .hideAfter(Duration.seconds(6));
            n.showWarning();
        }

        return testCode() && testMail() ;
    }
    
private void Emptynotif() {
    Image whatsAppImg = new Image("GUI/assets/img/alarm.png");

        TrayNotification tray = new TrayNotification();
        tray.setTitle("Le champs code est vide!");
	tray.setMessage("Vous n'a rien entrer");
	tray.setRectangleFill(Paint.valueOf("#FF0000"));
        AnimationType type = AnimationType.SLIDE;
	tray.setAnimationType(type);
	tray.setImage(whatsAppImg);
	tray.showAndDismiss(Duration.seconds(3));
}

private void UselessCodeNotif() {
    Image whatsAppImg = new Image("GUI/assets/img/alarm.png");

        TrayNotification tray = new TrayNotification();
        tray.setTitle("This code is useless");
	tray.setMessage("verify your code, because this one is wrong and useless");
	tray.setRectangleFill(Paint.valueOf("#FF0000"));
        AnimationType type = AnimationType.SLIDE;
	tray.setAnimationType(type);
	tray.setImage(whatsAppImg);
	tray.showAndDismiss(Duration.seconds(3));
        codeCheckMark.setImage(new Image("GUI/assets/img/erreurcheckMark.png"));
}



private void SuccessNotif() {
    Image whatsAppImg = new Image("GUI/assets/img/alarm.png");

        TrayNotification tray = new TrayNotification();
        tray.setTitle("Code est juste");
	tray.setMessage("You will be redirected to change password");
	tray.setRectangleFill(Paint.valueOf("#FF0000"));
        AnimationType type = AnimationType.SLIDE;
	tray.setAnimationType(type);
	tray.setImage(whatsAppImg);
	tray.showAndDismiss(Duration.seconds(3));
}

    @FXML
    private void ValiderCodeAction(ActionEvent event) throws IOException {
        
         if(!testSaisie()){
            Emptynotif();
        }
         else {
             User u = new User();
             u.setEmail(emailIn.getText());
             
            UserService us = new UserService();
             User MatchingUser = new User();
              MatchingUser = us.listUserByEmail(u);
          
              if(!MatchingUser.getRandCode().equals(codeIn.getText())){
              UselessCodeNotif();
              }
              else{
                  int i = MatchingUser.getId();
                  
                  id.setText(String.valueOf(i));
                  System.out.println("RancCode id :"+id.getText());
                        SuccessNotif();
        FXMLLoader loader =new FXMLLoader(getClass().getResource("ChangePassword.fxml"));
        Parent root = (Parent) loader.load();
        ChangePasswordController cpc = loader.getController();
        int ii = Integer.parseInt(id.getText());
        cpc.Myfunction(i);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
 scene = new Scene(root);
 stage.setScene(scene);
 stage.show();
 
              }
      
     }
    }

   

    

    
}

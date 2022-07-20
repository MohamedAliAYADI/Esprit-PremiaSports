/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import edu.esprit.entities.Client;
import edu.esprit.entities.Coach;
import edu.esprit.entities.Moderateur;
import edu.esprit.entities.Pclub;
import edu.esprit.entities.Pterrain;
import edu.esprit.entities.User;
import edu.esprit.services.ClientService;
import edu.esprit.services.CoachService;
import edu.esprit.services.EmailServices.MailSender;
import edu.esprit.services.ModerateurService;
import edu.esprit.services.PclubService;
import edu.esprit.services.PterrainService;
import edu.esprit.services.UserService;
import edu.esprit.utils.MyConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
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
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.mail.MessagingException;
import org.apache.commons.codec.digest.DigestUtils;
import org.controlsfx.control.Notifications;
import se.mbaeumer.fxmessagebox.MessageBox;
import se.mbaeumer.fxmessagebox.MessageBoxResult;
import se.mbaeumer.fxmessagebox.MessageBoxType;
import tray.animations.AnimationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author Slimen OUNI
 */
public class SignupController implements Initializable {

    @FXML
    private TextField PseudoIn;
    @FXML
    private TextField PasswordIn;
    @FXML
    private TextField EmailIn;
    @FXML
    private TextField EmailInConfirmation;
    @FXML
    private TextField PasswordInConfirmation;
    @FXML
    private ChoiceBox<String> Role;
    @FXML
    private TextField NameIn;
    @FXML
    private TextField FirstNameIn;
    @FXML
    private DatePicker DOB;
    @FXML
    private TextField AdressIn;
    @FXML
    private TextField phoneIn;
    @FXML
    private TextField weightIn;
    @FXML
    private TextField heightIn;
    @FXML
    private TextField professionIn;
    private Button CancelBtn;
    @FXML
    private ChoiceBox<String> Gender;
    
    
     Notifications n;
    String erreur;
    private Stage stage;
 private Scene scene;
 private Parent root;    
    @FXML
    private ImageView emailCheckMark;
    @FXML
    private ImageView nomCheckMark;
    @FXML
    private ImageView emailCheckMarkBis;
    @FXML
    private ImageView roleCheckMark;
    @FXML
    private ImageView prenomCheckMark;
    @FXML
    private ImageView addressCheckMark;
    @FXML
    private ImageView genderCheckMark;
    @FXML
    private ImageView heightCheckMark;
    @FXML
    private ImageView professCheckMark;
    @FXML
    private ImageView pseudoCheckMark;
    @FXML
    private ImageView passwordCheckMark;
    @FXML
    private ImageView passwordCheckMarkBis;
    @FXML
    private ImageView dobCheckMark;
    @FXML
    private ImageView telCheckMark;
    @FXML
    private ImageView weightCheckMark;
    @FXML
    private ImageView emaik;

            
            
            
 
 
 
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     MyConnection cn = MyConnection.getInstance();
        try {

            String req = "SELECT * FROM role";
            PreparedStatement ps = cn.cnx.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                
             String role ;
             role = rs.getString(2);
             Role.getItems().add(role);
                
            }

        } catch (SQLException ex) {
            System.out.println("Error fetching roles" + ex );
                          Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error fetching roles");
        alert.setHeaderText("Erreur lors de la récupération des rôles à partir de \n" +
                "la base de données, l'application ne fonctionnera pas comme prévu.");
    if(true) {
        alert.showAndWait().ifPresent(rs -> {
            if(rs == ButtonType.OK){
                System.out.println("Pressed OK");
            }
        });

    }
            }
         try {

            String req = "SELECT * FROM genre";
            PreparedStatement ps = cn.cnx.prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                
             String gender ;
             gender = rs.getString(2);
             Gender.getItems().add(gender);
                
            }

        } catch (SQLException ex) {
            System.out.println("Error fetching genders" + ex );
                                     Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error fetching genders");
        alert.setHeaderText("Erreur lors de la récupération des genres à partir de \n" +
                "la base de données, l'application ne fonctionnera pas comme prévu.");
    if(true) {
        alert.showAndWait().ifPresent(rs -> {
            if(rs == ButtonType.OK){
                System.out.println("Pressed OK");
            }
        });

    }
            }
         
    }    
    
    
    
       public Boolean validation(){                

    if((PseudoIn.getText().compareTo("") == 0) || (PasswordIn.getText().compareTo("")==0)||
            (EmailIn.getText().compareTo("") == 0) || (EmailInConfirmation.getText().compareTo("") == 0)||
            (PasswordInConfirmation.getText().compareTo("") == 0) || (NameIn.getText().compareTo("") == 0)||
            (FirstNameIn.getText().compareTo("") == 0) || (AdressIn.getText().compareTo("") == 0) 
           ){
        Alert fail= new Alert(Alert.AlertType.INFORMATION);
        fail.setHeaderText("Erreur");
        fail.setContentText("tu n'as rien tapé");
        fail.showAndWait();
        return false;
    } 
    else {
    return true;
    }
}
    
    
    

   
    private void Quit(ActionEvent event) {
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
       
       
             public void EmailUserExists() {
    Image whatsAppImg = new Image("GUI/assets/img/huser.png");

        TrayNotification tray = new TrayNotification();
        tray.setTitle("changer email pour avancer");
	tray.setMessage("Ce email existe déjà essayer un autre.");
	tray.setRectangleFill(Paint.valueOf("#FF0000"));
        AnimationType type = AnimationType.FADE;
	tray.setAnimationType(type);
	tray.setImage(whatsAppImg);
	tray.showAndDismiss(Duration.seconds(3));
    }
 public void PseudoUserExists() {
    Image whatsAppImg = new Image("GUI/assets/img/huser.png");

        TrayNotification tray = new TrayNotification();
        tray.setTitle("Changer le psuedo pour avancer");
	tray.setMessage("Ce pseudo existe déjà essayer un autre.");
	tray.setRectangleFill(Paint.valueOf("#FF0000"));
        AnimationType type = AnimationType.POPUP;
	tray.setAnimationType(type);
	tray.setImage(whatsAppImg);
	tray.showAndDismiss(Duration.seconds(3));
    }
       
       

    @FXML
    private void SignInAction(ActionEvent event) throws MessagingException, IOException {
   
    
     
       if(testSaisie()) {
        if(Role.getValue().equals("Client")){
            System.out.println("Client Selected");
             List<User> users = new ArrayList<User>();
            ClientService cs = new ClientService();
            Client c = new Client();
            UserService us = new UserService();
            User u = new User();
            u.setEmail(EmailIn.getText());
            u.setPassword(DigestUtils.shaHex(PasswordIn.getText()));
            u.setPseudo(PseudoIn.getText());
            u.setRole(1);
              users=us.listUsersA1();
           
              List<User> MatchinUsers = users.stream()
                      .filter(p -> (p.getPseudo().equals(PseudoIn.getText()) ||
                              p.getEmail().equals(EmailIn.getText())))
                      .collect(Collectors.toList());
              
            if(MatchinUsers.isEmpty()){
                     us.addUser(u);
                      c.setPseudo(PseudoIn.getText());
                      if(PasswordIn.getText().equals(PasswordInConfirmation.getText())){
                  String pass = DigestUtils.shaHex(PasswordIn.getText());
                  c.setPassword(pass);
            }
            if(EmailIn.getText().equals(EmailInConfirmation.getText())){
                c.setEmail(EmailIn.getText());
            }
            c.setNom(NameIn.getText());
            c.setPrenom(FirstNameIn.getText());
            String d = DOB.getValue().toString();
            Date dd = Date.valueOf(d);
            c.setDOB(dd);
            c.setAdress(AdressIn.getText());
            c.setTelephone(phoneIn.getText());
            if(Gender.getValue().equals("Homme")) {
                c.setCivilite("M");            
                c.setGenre(1);
            }
               if(Gender.getValue().equals("Femme")) {
                c.setCivilite("Mme");            
                c.setGenre(2);
            }
            
            c.setTaille(Integer.parseInt(heightIn.getText()));
            c.setPoids(Integer.parseInt(weightIn.getText()));
            c.setRole(1);
            c.setProfession(professionIn.getText());
            cs.addUser(c);
            
            MailSender.SendVerifMail(EmailIn.getText(),NameIn.getText());
           
  root = FXMLLoader.load(getClass().getResource("ClientGuiHomePage.fxml"));
  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
                }
            
          
            
            
            else  {
                
                if(MatchinUsers.stream().anyMatch(ux -> ux.getPseudo().equals(PseudoIn.getText()))) {
                    pseudoCheckMark.setImage(new Image("GUI/assets/img/erreurcheckMark.png"));
                
                    n = Notifications.create()
                    .title("Utilisateur Existe déjà!!")
                    .text("Ce pseudo existe déjà essayer un autre.")
                    .graphic(null)
                    .position(Pos.TOP_CENTER)
                    .hideAfter(Duration.seconds(8));
            n.showConfirm();
            
                PseudoUserExists();
            
            }
           if(MatchinUsers.stream().anyMatch(ux -> ux.getEmail().equals(EmailIn.getText()))) {
                    emailCheckMark.setImage(new Image("GUI/assets/img/erreurcheckMark.png"));
                    n = Notifications.create()
                    .title("Utilisateur Existe déjà!!")
                    .text("Ce email existe déjà essayer un autre.")
                    .graphic(null)
                    .position(Pos.TOP_CENTER)
                    .hideAfter(Duration.seconds(8));
            n.showConfirm();
            
                EmailUserExists();
            
            }
            }
           
           
        }
         
           
           
           
           
           
           
                   if(Role.getValue().equalsIgnoreCase("Moderateur")){
            System.out.println("Moderateur Selected");
            
                  ModerateurService ms = new ModerateurService();
            Moderateur m = new Moderateur();
            m.setPseudo(PseudoIn.getText());
            if(PasswordIn.getText().equals(PasswordInConfirmation.getText())){
                  m.setPassword(PasswordIn.getText());
            }
            if(EmailIn.getText().equals(EmailInConfirmation.getText())){
                m.setEmail(EmailIn.getText());
            }
            m.setNom(NameIn.getText());
            m.setPrenom(FirstNameIn.getText());
            String d = DOB.getValue().toString();
            Date dd = Date.valueOf(d);
            m.setDOB(dd);
            m.setAdress(AdressIn.getText());
            m.setTelephone(phoneIn.getText());
            if(Gender.getValue().equals("Homme")) {
                m.setCivilite("M");            
                m.setGenre(1);
            }
               if(Gender.getValue().equals("Femme")) {
                m.setCivilite("Mme");            
                m.setGenre(2);
            }
            
            m.setTaille(Integer.parseInt(heightIn.getText()));
            m.setPoids(Integer.parseInt(weightIn.getText()));
            m.setRole(2);
            
            ms.addUser(m);
            
              MailSender.SendVerifMail(EmailIn.getText(),NameIn.getText());
            
                       
  root = FXMLLoader.load(getClass().getResource("Login.fxml"));
  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
  
    n = Notifications.create()
                    .title("Création du compte client avec succès.")
                    .text("Félicitations, vous pouvez vous connecter maintenant")
                    .graphic(null)
                    .position(Pos.TOP_CENTER)
                    .hideAfter(Duration.seconds(10));
            n.showConfirm();
            
            
            
        }
           
           
           
           
                 if(Role.getValue().equalsIgnoreCase("Propriétaire de club")){
            System.out.println("Propriétaire de club Selected");
                        
            
            PclubService pcs = new PclubService();
            Pclub pc = new Pclub();
            pc.setPseudo(PseudoIn.getText());
            if(PasswordIn.getText().equals(PasswordInConfirmation.getText())){
                  pc.setPassword(PasswordIn.getText());
            }
            if(EmailIn.getText().equals(EmailInConfirmation.getText())){
                pc.setEmail(EmailIn.getText());
            }
            pc.setNom(NameIn.getText());
            pc.setPrenom(FirstNameIn.getText());
            String d = DOB.getValue().toString();
            Date dd = Date.valueOf(d);
            pc.setDOB(dd);
            pc.setAdress(AdressIn.getText());
            pc.setTelephone(phoneIn.getText());
            if(Gender.getValue().equals("Homme")) {
                pc.setCivilite("M");            
                pc.setGenre(1);
            }
               if(Gender.getValue().equals("Femme")) {
                pc.setCivilite("Mme");            
                pc.setGenre(2);
            }
            
            pc.setTaille(Integer.parseInt(heightIn.getText()));
            pc.setPoids(Integer.parseInt(weightIn.getText()));
            pc.setRole(3);
            
            pcs.addUser(pc);
            
              MailSender.SendVerifMail(EmailIn.getText(),NameIn.getText());
            
            
                       
  root = FXMLLoader.load(getClass().getResource("Login.fxml"));
  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
  
    n = Notifications.create()
                    .title("Création du compte client avec succès.")
                    .text("Félicitations, vous pouvez vous connecter maintenant")
                    .graphic(null)
                    .position(Pos.TOP_CENTER)
                    .hideAfter(Duration.seconds(10));
            n.showConfirm();
            
            
        }
           
           
           
           
           
      
                    if(Role.getValue().equalsIgnoreCase("propriétaire de complexe")){
            System.out.println("propriétaire de complexe Selected");
                       
            
            PterrainService pts = new PterrainService();
            Pterrain pt = new Pterrain();
            User u = new User();
            pt.setPseudo(PseudoIn.getText());
            if(PasswordIn.getText().equals(PasswordInConfirmation.getText())){
                  pt.setPassword(PasswordIn.getText());
            }
            if(EmailIn.getText().equals(EmailInConfirmation.getText())){
                pt.setEmail(EmailIn.getText());
            }
            pt.setNom(NameIn.getText());
            pt.setPrenom(FirstNameIn.getText());
            String d = DOB.getValue().toString();
            Date dd = Date.valueOf(d);
            pt.setDOB(dd);
            pt.setAdress(AdressIn.getText());
            pt.setTelephone(phoneIn.getText());
            if(Gender.getValue().equals("Homme")) {
                pt.setCivilite("M");            
                pt.setGenre(1);
            }
               if(Gender.getValue().equals("Femme")) {
                pt.setCivilite("Mme");            
                pt.setGenre(2);
            }
            
            pt.setTaille(Integer.parseInt(heightIn.getText()));
            pt.setPoids(Integer.parseInt(weightIn.getText()));
            pt.setRole(4);
            
            pts.addUser(pt);
            
              MailSender.SendVerifMail(EmailIn.getText(),NameIn.getText());
            
                       
  root = FXMLLoader.load(getClass().getResource("Login.fxml"));
  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
  
    n = Notifications.create()
                    .title("Création du compte client avec succès.")
                    .text("Félicitations, vous pouvez vous connecter maintenant")
                    .graphic(null)
                    .position(Pos.TOP_CENTER)
                    .hideAfter(Duration.seconds(10));
            n.showConfirm();
            
            
            
        }
                    
                      if(Role.getValue().equalsIgnoreCase("Coach")){
            System.out.println("Coach Selected");
            
            
               CoachService cs = new CoachService();
            Coach c = new Coach();
            c.setPseudo(PseudoIn.getText());
            if(PasswordIn.getText().equals(PasswordInConfirmation.getText())){
                  c.setPassword(PasswordIn.getText());
            }
            if(EmailIn.getText().equals(EmailInConfirmation.getText())){
                c.setEmail(EmailIn.getText());
            }
            c.setNom(NameIn.getText());
            c.setPrenom(FirstNameIn.getText());
            String d = DOB.getValue().toString();
            Date dd = Date.valueOf(d);
            c.setDOB(dd);
            c.setAdress(AdressIn.getText());
            c.setTelephone(phoneIn.getText());
            if(Gender.getValue().equals("Homme")) {
                c.setCivilite("M");            
                c.setGenre(1);
            }
               if(Gender.getValue().equals("Femme")) {
                c.setCivilite("Mme");            
                c.setGenre(2);
            }
            
            c.setTaille(Integer.parseInt(heightIn.getText()));
            c.setPoids(Integer.parseInt(weightIn.getText()));
            c.setRole(5);
            
            cs.addUser(c);
            
              MailSender.SendVerifMail(EmailIn.getText(),NameIn.getText());
            
                       
  root = FXMLLoader.load(getClass().getResource("Login.fxml"));
  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
  
    n = Notifications.create()
                    .title("Création du compte client avec succès.")
                    .text("Félicitations, vous pouvez vous connecter maintenant")
                    .graphic(null)
                    .position(Pos.TOP_CENTER)
                    .hideAfter(Duration.seconds(10));
            n.showConfirm();
            
            
            
        }
           
        
      
        }
       
       
       
       
    
    }
     @FXML
    private boolean testMail() {

        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."
                + "[a-zA-Z0-9_+&*-]+)*@"
                + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
                + "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (EmailIn.getText() == null) {
            return false;
        }

        if (pat.matcher(EmailIn.getText()).matches() == false) {
            emailCheckMark.setImage(new Image("GUI/assets/img/erreurcheckMark.png"));
    //  erreur = erreur + ("Veuillez verifier votre adresse email\n");
            return false;
//            

        } else {
           emailCheckMark.setImage(new Image("GUI/assets/img/checkMark.png"));
        }
        return true;

    }
    
    
    @FXML
    private Boolean testMail2() {
        
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."
                + "[a-zA-Z0-9_+&*-]+)*@"
                + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
                + "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (EmailInConfirmation.getText() == null) {
            return false;
        }

        if (pat.matcher(EmailInConfirmation.getText()).matches() == false) {
            emailCheckMarkBis.setImage(new Image("GUI/assets/img/erreurcheckMark.png"));
//                erreur = erreur + ("Veuillez verifier votre adresse email\n");
            return false;
//            

        } else {
           emailCheckMarkBis.setImage(new Image("GUI/assets/img/checkMark.png"));
        }
        
        if(EmailIn.getText().compareTo(EmailInConfirmation.getText()) == 0){
            emailCheckMarkBis.setImage(new Image("GUI/assets/img/checkMark.png"));
        } else {
             emailCheckMarkBis.setImage(new Image("GUI/assets/img/erreurcheckMark.png"));
        }
        
        return true;

        
    }
    
       @FXML
    private Boolean testNom() {
        int nbNonChar = 0;
        for (int i = 1; i < NameIn.getText().trim().length(); i++) {
            char ch = NameIn.getText().charAt(i);
            if (!Character.isLetter(ch)) {
                nbNonChar++;
            }
        }

        if (nbNonChar == 0 && NameIn.getText().trim().length() >= 3) {
            nomCheckMark.setImage(new Image("GUI/assets/img/checkMark.png"));
            return true;
        } else {
            nomCheckMark.setImage(new Image("GUI/assets/img/erreurcheckMark.png"));
//                erreur = erreur + ("Pas de caractere permit dans le telephone\n");
            return false;

        }

    }
    
    
         @FXML
    private Boolean testPseudo() {
        int nbNonChar = 0;
        for (int i = 1; i < PseudoIn.getText().trim().length(); i++) {
            char ch = PseudoIn.getText().charAt(i);
            if (!Character.isLetter(ch)) {
                nbNonChar++;
            }
        }

        if (nbNonChar == 0 && PseudoIn.getText().trim().length() >= 3) {
            pseudoCheckMark.setImage(new Image("GUI/assets/img/checkMark.png"));
            return true;
        } else {
            pseudoCheckMark.setImage(new Image("GUI/assets/img/erreurcheckMark.png"));
//                erreur = erreur + ("Pas de caractere permit dans le telephone\n");
            return false;

        }

    }
    


    @FXML
    private Boolean testPrenom() {
           int nbNonChar = 0;
        for (int i = 1; i < PseudoIn.getText().trim().length(); i++) {
            char ch = PseudoIn.getText().charAt(i);
            if (!Character.isLetter(ch)) {
                nbNonChar++;
            }
        }

        if (nbNonChar == 0 && PseudoIn.getText().trim().length() >= 3) {
            pseudoCheckMark.setImage(new Image("GUI/assets/img/checkMark.png"));
            return true;
        } else {
            pseudoCheckMark.setImage(new Image("GUI/assets/img/erreurcheckMark.png"));
//                erreur = erreur + ("Pas de caractere permit dans le telephone\n");
            return false;

        }
    }

    @FXML
    private Boolean testAddres() {
           int nbNonChar = 0;
        for (int i = 1; i < PseudoIn.getText().trim().length(); i++) {
            char ch = PseudoIn.getText().charAt(i);
            if (!Character.isLetter(ch)) {
                nbNonChar++;
            }
        }

        if (nbNonChar == 0 && PseudoIn.getText().trim().length() >= 3) {
            pseudoCheckMark.setImage(new Image("GUI/assets/img/checkMark.png"));
            return true;
        } else {
            pseudoCheckMark.setImage(new Image("GUI/assets/img/erreurcheckMark.png"));
//                erreur = erreur + ("Pas de caractere permit dans le telephone\n");
            return false;

        }
    }

    @FXML
    private Boolean testTel() {
      String telRegex = "^[0-9]{8}$";
      Pattern pat = Pattern.compile(telRegex);
        if(phoneIn.getText() == null){
            return false;
        }
          if (pat.matcher(phoneIn.getText()).matches() == false) {
            telCheckMark.setImage(new Image("GUI/assets/img/erreurcheckMark.png"));
//                erreur = erreur + ("Veuillez verifier votre adresse email\n");
            return false;
//            

        } else {
           telCheckMark.setImage(new Image("GUI/assets/img/checkMark.png"));
        }
        
      
        
        return true;
        
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
    private Boolean testPass2() {
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
        
         if(PasswordIn.getText().compareTo(PasswordInConfirmation.getText()) == 0){
            passwordCheckMarkBis.setImage(new Image("GUI/assets/img/checkMark.png"));
        } else {
             passwordCheckMarkBis.setImage(new Image("GUI/assets/img/erreurcheckMark.png"));
        }
        
      
        
        return true;
    }
    
        
     private Boolean testSaisie() {
        erreur = "";
        if (!testMail()) {
            erreur = erreur + ("Veuillez verifier que votre adresse email est de la forme : ***@***.** \n");
        }
         if (!testMail2()) {
            erreur = erreur + ("Veuillez verifier la confirmation que votre adresse email est de la forme : ***@***.** \n");
        }
        if (!testTel()) {
            erreur = erreur + ("Telephone doit avoir 8 chiffres et ne doit pas contenir des caracteres \n");
        }
        if(!testPassword()){
            erreur = erreur + ("Mot de pass doit avoir 2 majus au min ,un symbol, deux chiffres, et du longeur 8 au min ");
        }
        if(!testPass2()){
          erreur = erreur + ("Mot de pass doit avoir 2 majus au min ,un symbol, deux chiffres, et du longeur 8 au min ");
        }

        if (!testNom()) {
            erreur = erreur + ("Veuillez verifier votre Nom: seulement des caractères et de nombre >= 3 \n");
        }
          if (!testPseudo()) {
            erreur = erreur + ("Veuillez verifier votre Pseudo: seulement des caractères et de nombre >= 3 \n");
        }
        if (!testPrenom()) {
            erreur = erreur + ("Veuillez verifier votre Prenom: seulement des caractères et de nombre >= 3");
        }

        if (!testMail() || !testMail2()|| !testTel() ||  !testNom() || !testPrenom() || !testPseudo() || !testPassword() || !testPass2()) {
            n = Notifications.create()
                    .title("Erreur de format")
                    .text(erreur)
                    .graphic(null)
                    .position(Pos.TOP_CENTER)
                    .hideAfter(Duration.seconds(6));
            n.showWarning();
        }

        return testMail() && testMail2() && testTel() &&  testNom() && testPrenom() && testPseudo() && testPass2() && testPassword();
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
    private void RetourAction(MouseEvent event) throws IOException {
  root = FXMLLoader.load(getClass().getResource("Login.fxml"));
  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  scene = new Scene(   (Parent) root);
  stage.setScene(scene);
  stage.show();
    }
    
    
    }
    
    


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class HomeController implements Initializable {

    @FXML
    private Pane panedhash;
    @FXML
    private ImageView imgdhash;
    @FXML
    private ImageView imgshop;
    @FXML
    private ImageView imgpromotion;
    @FXML
    private Pane paneavis;
    @FXML
    private ImageView imgmessage;
    @FXML
    private ImageView imgpanier;
    @FXML
    private Text deco;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void dashbordexit(MouseEvent event) {
    }

    @FXML
    private void dashbordentred(MouseEvent event) {
    }

    @FXML
    private void dashclik(MouseEvent event) {
    }

    @FXML
    private void shopexit(MouseEvent event) {
    }

    @FXML
    private void shopentred(MouseEvent event) {
    }

    @FXML
    private void shopclik(MouseEvent event) {
    }

    @FXML
    private void promotionexit(MouseEvent event) {
    }

    @FXML
    private void promotionentred(MouseEvent event) {
    }

    @FXML
    private void promoclik(MouseEvent event) {
    }

    @FXML
    private void evenemtionexit(MouseEvent event) {
    }

    @FXML
    private void evenemtionentred(MouseEvent event) {
    }

    @FXML
    private void evenementclik(MouseEvent event) {
    }

    @FXML
    private void livraisonexit(MouseEvent event) {
    }

    @FXML
    private void livraisonentred(MouseEvent event) {
    }

    @FXML
    private void livclik(MouseEvent event) {
    }

    @FXML
    private void avisexit(MouseEvent event) {
    }

    @FXML
    private void avisentred(MouseEvent event) {
    }

    @FXML
    private void avisclik(MouseEvent event) {
    }

    @FXML
    private void wishlistexit(MouseEvent event) {
    }

    @FXML
    private void wishlistentred(MouseEvent event) {
    }

    @FXML
    private void wishclik(MouseEvent event) {
    }

    @FXML
    private void messagexit(MouseEvent event) {
    }

    @FXML
    private void messagentred(MouseEvent event) {
    }

    @FXML
    private void messeclik(MouseEvent event) {
    }

    @FXML
    private void deco(MouseEvent event) {
    }

    @FXML
    private void gotoreclamationpage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Reclamation.fxml"));
        Scene scene = new Scene(root);
        Stage stage =(Stage)((Node) event.getSource()).getScene().getWindow();  
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void panier(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("panierList.fxml"));
        Scene scene = new Scene(root);
        Stage stage =(Stage)((Node) event.getSource()).getScene().getWindow();  
        stage.setScene(scene);
        stage.show();
    }
    
}

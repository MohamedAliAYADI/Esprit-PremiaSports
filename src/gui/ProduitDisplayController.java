/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import edu.esprit.entities.Produits;
import edu.esprit.services.ProduitService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class ProduitDisplayController implements Initializable {

    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;
    @FXML
    private TableView<Produits> table;
    @FXML
    private TableColumn<Produits, Integer> id_prod;
    @FXML
    private TableColumn<Produits, String> nom_prod;
    @FXML
    private TableColumn<Produits, String> Image_prod;
    @FXML
    private TableColumn<Produits, String> prix;
ProduitService p = new ProduitService () ; 
    @FXML
    private Text deco;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        id_prod.setCellValueFactory(new PropertyValueFactory<>("id_prod"));
        nom_prod.setCellValueFactory(new PropertyValueFactory<>("nom_prod"));
        Image_prod.setCellValueFactory(new PropertyValueFactory<>("Image_prod"));
       prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        
                             
 ObservableList<Produits> data;
        data = FXCollections.observableArrayList(p.selectall());
    table.setItems(data);
        
        
        
        
    }    

    @FXML
    private void updateButton(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("Update_Product.fxml"));
        Scene scene = new Scene(root);
        Stage stage =(Stage)((Node) event.getSource()).getScene().getWindow();  
        stage.setScene(scene);
        stage.show();
    }
    

    @FXML
    private void deleteButton(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("SupProduit.fxml"));
        Scene scene = new Scene(root);
        Stage stage =(Stage)((Node) event.getSource()).getScene().getWindow();  
        stage.setScene(scene);
        stage.show();
    }

   
    @FXML
    private void returnn(ActionEvent event) throws IOException {
        
        
         Parent root = FXMLLoader.load(getClass().getResource("FXMLDocumentsPage.fxml"));
        Scene scene = new Scene(root);
        Stage stage =(Stage)((Node) event.getSource()).getScene().getWindow();  
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void gotonewproduit(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("ajoutProduits.fxml"));
        Scene scene = new Scene(root);
        Stage stage =(Stage)((Node) event.getSource()).getScene().getWindow();  
        stage.setScene(scene);
        stage.show();
        
    }

    @FXML
    private void deco(MouseEvent event) {
    }

   
    
}

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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class SupProduitController implements Initializable {

    @FXML
    private Text deco;
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
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtDescription;
    @FXML
    private TextField txtid;
    @FXML
    private TextField txtPrice;
    @FXML
    private Button btnCancel;
ProduitService p = new ProduitService ();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nom_prod.setCellValueFactory(new PropertyValueFactory<>("nom_prod"));
        Image_prod.setCellValueFactory(new PropertyValueFactory<>("Image_prod"));
        prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
        id_prod.setCellValueFactory(new PropertyValueFactory<>("id_prod"));

        ObservableList<Produits> data;
        data = FXCollections.observableArrayList(p.selectall());
        table.setItems(data);

    }    

    @FXML
    private void delete(ActionEvent event) {
    }

    @FXML
    private void deco(MouseEvent event) {
    }

    @FXML
    private void select(ActionEvent event) {
    }

    @FXML
    private void Cancel_button(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("ProduitDisplay.fxml"));
        Scene scene = new Scene(root);
        Stage stage =(Stage)((Node) event.getSource()).getScene().getWindow();  
        stage.setScene(scene);
        stage.show();
    }
    
}

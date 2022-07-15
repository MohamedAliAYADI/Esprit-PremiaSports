/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author user
 */
public class ProduitClientController implements Initializable {

    @FXML
    private TableView<?> table;
    @FXML
    private TableColumn<?, ?> id_prod;
    @FXML
    private TableColumn<?, ?> nom_prod;
    @FXML
    private TableColumn<?, ?> reference_prod;
    @FXML
    private TableColumn<?, ?> description;
    @FXML
    private TableColumn<?, ?> prix;
    @FXML
    private TableColumn<?, ?> quantite;
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
    private void ajouterPanier(ActionEvent event) {
    }

    @FXML
    private void returnn(ActionEvent event) {
    }

    @FXML
    private void deco(MouseEvent event) {
    }
    
}

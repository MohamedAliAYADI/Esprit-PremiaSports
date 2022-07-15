/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import edu.esprit.entities.Reclamation;
import edu.esprit.services.ReclamationService;
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
public class StatuReclamationController implements Initializable {

    @FXML
    private TableView<Reclamation> table;
    @FXML
    private TableColumn<Reclamation, Integer> id;
    @FXML
    private TableColumn<Reclamation, String> sujet;
    @FXML
    private TableColumn<Reclamation, String> description;
    @FXML
    private TableColumn<Reclamation, String> statut;
    @FXML
    private Text deco;
    ReclamationService cs = new ReclamationService () ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         id.setCellValueFactory(new PropertyValueFactory<>("id"));
        sujet.setCellValueFactory(new PropertyValueFactory<>("sujet"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
          statut.setCellValueFactory(new PropertyValueFactory<>("statut"));
       
        ObservableList<Reclamation> data;
        data = FXCollections.observableArrayList(cs.selectall());
    table.setItems(data);
        // TODO
    }    

    @FXML
    private void returnn(ActionEvent event) throws IOException {
        
         Parent root = FXMLLoader.load(getClass().getResource("Reclamation.fxml"));
        Scene scene = new Scene(root);
        Stage stage =(Stage)((Node) event.getSource()).getScene().getWindow();  
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void deco(MouseEvent event) {
    }
    
}

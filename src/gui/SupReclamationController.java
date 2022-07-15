/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import edu.esprit.entities.Categories;
import edu.esprit.entities.Reclamation;
import edu.esprit.services.CategorieService;
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
public class SupReclamationController implements Initializable {

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
    private TextField txtdescription;
    @FXML
    private TextField txtstatut;
    @FXML
    private Text deco;
    @FXML
    private TextField txtsujet;

 ReclamationService   cs=new ReclamationService ();
    @FXML
    private TextField txtid;
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
    private void delete(ActionEvent event) {
         ReclamationService cs = new ReclamationService();

        Reclamation c = new Reclamation();
        c.setSujet(txtsujet.getText());
        c.setDescription(txtdescription.getText());
        c.setStatut(txtstatut.getText());
    c.setId(Integer.parseInt(txtid.getText()));

//      
       cs.Delete(c);

        ObservableList<Reclamation> data;
        data = FXCollections.observableArrayList(cs.selectall());
        table.setItems(data);
    }

    @FXML
    private void deco(MouseEvent event) {
    }

    @FXML
    private void selectdelet(ActionEvent event) {
                                  
 Reclamation css1 = table.getSelectionModel().getSelectedItem();

      
        String a = css1.getSujet();
         String b = css1.getDescription();
          String c = css1.getStatut();
          String d = String.valueOf(css1.getId());
       
               txtsujet.setText(a);
               txtdescription.setText(b);
               txtstatut.setText(c);
               txtid.setText(d);
               
    
    }
 
}

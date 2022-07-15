/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import edu.esprit.entities.Categories;
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
public class UpdateReclamationController implements Initializable {

    @FXML
    private TextField idr;
    @FXML
    private TextField txtstatut;
    @FXML
    private TextField txtsujet;
    @FXML
    private Text deco;
    @FXML
    private TextField txtdsc;
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
    ReclamationService cs = new ReclamationService ();

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
    private void select(ActionEvent event) {
            Reclamation css1 = table.getSelectionModel().getSelectedItem();

        String b = css1.getSujet();
        String c = css1.getDescription();
        String d = css1.getStatut();
        String a = String.valueOf(css1.getId());

        txtsujet.setText(b);
        txtdsc.setText(c);
        txtstatut.setText(d);
        idr.setText(a);

    }
    

    @FXML
    private void modif(ActionEvent event) { 
        ReclamationService cs = new ReclamationService();

        Reclamation c = new Reclamation();

        c.setStatut(txtstatut.getText());
        c.setDescription(txtdsc.getText());
           c.setSujet(txtsujet.getText());
        c.setId(Integer.parseInt(idr.getText()));
        cs.Update(c);

        ObservableList<Reclamation> data;
        data = FXCollections.observableArrayList(cs.selectall());
        table.setItems(data);
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
    private void deco(MouseEvent event) {
    }
    
}

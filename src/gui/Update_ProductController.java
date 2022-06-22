/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import edu.esprit.entities.Categories;
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
import javafx.scene.control.Label;
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
public class Update_ProductController implements Initializable {

    @FXML
    private TextField txtName;
    @FXML
    private TextField txtDescription;
    @FXML
    private TextField txtPrice;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnCancel;
    ProduitService p = new ProduitService();
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
    private TextField txtid;
    @FXML
    private Text deco;

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
    private void Update_button(ActionEvent event) {

        ProduitService cs = new ProduitService();

        Produits c = new Produits();

        c.setNom_prod(txtName.getText());
        c.setImage_prod(txtDescription.getText());
        c.setPrix(txtPrice.getText());
        c.setId_prod(Integer.parseInt(txtid.getText()));

        cs.updateProduit(c);
        ObservableList<Produits> data;
        data = FXCollections.observableArrayList(cs.selectall());
        table.setItems(data);

    }

    @FXML
    private void Cancel_button(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("ProduitDisplay.fxml"));
        Scene scene = new Scene(root);
        Stage stage =(Stage)((Node) event.getSource()).getScene().getWindow();  
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void select(ActionEvent event) {
        Produits css1 = table.getSelectionModel().getSelectedItem();

        String a = css1.getNom_prod();
        String b = css1.getImage_prod();
        String c = css1.getPrix();
       String d = String.valueOf(css1.getId_prod());

        txtName.setText(a);
        txtDescription.setText(b);
        txtPrice.setText(c);
        txtid.setText(d);

    }

    @FXML
    private void deco(MouseEvent event) {
    }

}

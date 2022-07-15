/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import edu.esprit.entities.Produits;
import edu.esprit.services.ProduitService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author user
 */
public class Update_ProductController implements Initializable {

    @FXML
    private TextField txtNom;
    @FXML
    private TextField txtRef;
    @FXML
    private TextField txtid;
    @FXML
    private TextField txtPrix;
    @FXML
    private TextField txtDes;
    @FXML
    private TextField txtQ;
    @FXML
    private TableView<Produits> table;
    @FXML
    private TableColumn<Produits, Integer> id_prod;
    @FXML
    private TableColumn<Produits, String> nom_prod;
    @FXML
    private TableColumn<Produits, String> reference_prod;
    @FXML
    private TableColumn<Produits, String> description;
    @FXML
    private TableColumn<Produits, String> prix;
    @FXML
    private TableColumn<Produits, String> quantite;
    @FXML
    private Text deco;
ProduitService p = new ProduitService();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //   
        id_prod.setCellValueFactory(new PropertyValueFactory<>("id_prod"));
        nom_prod.setCellValueFactory(new PropertyValueFactory<>("nom_prod"));
        reference_prod.setCellValueFactory(new PropertyValueFactory<>("reference_prod"));
            description.setCellValueFactory(new PropertyValueFactory<>("description"));
               prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
                quantite.setCellValueFactory(new PropertyValueFactory<>("quantite"));
      

        ObservableList<Produits> data;
        data = FXCollections.observableArrayList(p.selectall());
        table.setItems(data);
    }    

    @FXML
    private void deco(MouseEvent event) {
    }

    @FXML
    private void updateProdi(ActionEvent event) {
        
        Produits c = new Produits();
c.setId_prod(Integer.parseInt(txtid.getText()));
        c.setNom_prod(txtNom.getText());
     c.setReference_prod(txtRef.getText());
        c.setDescription(txtDes.getText());
        c.setPrix(txtPrix.getText());
        c.setPrix(txtQ.getText());
       
p.updateProduit(c);
        ObservableList<Produits> data;
        data = FXCollections.observableArrayList(p.selectall());
        table.setItems(data);

    }

    @FXML
    private void select(ActionEvent event) {

        Produits p = table.getSelectionModel().getSelectedItem();
   String a = String.valueOf(p.getId_prod());
        String b= p.getNom_prod();
        
        String c = p.getReference_prod();
        String d = p.getDescription();
        
        String e = p.getPrix();
        String f = p.getQuantite();
    
  txtid.setText(a);
        txtNom.setText(b);
        
        txtRef.setText(c);
        txtDes.setText(d);
        txtPrix.setText(e);
        txtQ.setText(f);
        
     

        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import edu.esprit.entities.Categories;
import edu.esprit.entities.Produits;
import edu.esprit.services.CategorieService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableArrayList;
import static javafx.collections.FXCollections.observableList;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class CategoriesDisplayController implements Initializable {

    @FXML
    private Button btnDelete;
    @FXML
    private TableView<Categories> table;
    @FXML
    private TableColumn<Categories,String> type;
    CategorieService cs = new  CategorieService ();
    Categories c = new Categories ();
    @FXML
    private TableColumn<Categories, Integer> id_catg;
    @FXML
    private TableColumn<Categories, String> nom_cat;
    @FXML
    private Text deco;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

         id_catg.setCellValueFactory(new PropertyValueFactory<>("id_catg"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        nom_cat.setCellValueFactory(new PropertyValueFactory<>("nom_cat"));
       
        ObservableList<Categories> data;
        data = FXCollections.observableArrayList(cs.selectall());
    table.setItems(data);
 
    }

   

    @FXML
    private void deleteButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SupCatg.fxml"));
        Scene scene = new Scene(root);
        Stage stage =(Stage)((Node) event.getSource()).getScene().getWindow();  
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void gototnewcatpage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("NewCategori.fxml"));
        Scene scene = new Scene(root);
        Stage stage =(Stage)((Node) event.getSource()).getScene().getWindow();  
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void gotofxmldocument(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocumentsPage.fxml"));
        Scene scene = new Scene(root);
        Stage stage =(Stage)((Node) event.getSource()).getScene().getWindow();  
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void updatee(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("updcateg.fxml"));
        Scene scene = new Scene(root);
        Stage stage =(Stage)((Node) event.getSource()).getScene().getWindow();  
        stage.setScene(scene);
        stage.show();
        
    }

    @FXML
    private void deco(MouseEvent event) {
    }

    

    

  
}

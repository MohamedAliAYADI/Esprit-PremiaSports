/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import edu.esprit.entities.Categories;
import edu.esprit.services.CategorieService;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class NewCategoriController implements Initializable {

    @FXML
    private TextField txtName;
    @FXML
    private Button btnUpdate;
    @FXML
    private ImageView image;
    CategorieService c = new CategorieService ();
    @FXML
    private TextField txtType;
    @FXML
    private Button vider;
    @FXML
    private TableView<Categories> table;
    @FXML
    private TableColumn<Categories, Integer> id_catg;
    @FXML
    private TableColumn<Categories,String> type;
    @FXML
    private TableColumn<Categories, String> nom_cat;
    CategorieService cs = new CategorieService ();
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
      
        // TODO
    }    

    @FXML
    private void Create_button(ActionEvent event) {
        
          
        
         if (txtType.getText().isEmpty() || txtName.getText().isEmpty()) {
            Alert a = new Alert(Alert.AlertType.ERROR, "vous devez remplir tout les champs  ", ButtonType.OK);
            a.showAndWait();
        } else {
            
                
            
        
         Categories cc = new Categories(txtType.getText(), txtName.getText());
        c.insertCategories(cc);
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Categories Ajouté !", ButtonType.OK);
                a.showAndWait();
         
           ObservableList<Categories> data;
        data = FXCollections.observableArrayList(cs.selectall()); 
       table.setItems(data);
        
        
    }
    }

    @FXML
    private void returnn(ActionEvent event) throws IOException {
        
         Parent root = FXMLLoader.load(getClass().getResource("CategoriesDisplay.fxml"));
        Scene scene = new Scene(root);
        Stage stage =(Stage)((Node) event.getSource()).getScene().getWindow();  
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void vider_button(ActionEvent event) {
        txtName.setText("");
        txtType.setText("");
        
        
    }

    @FXML
    private void deco(MouseEvent event) {
    }

    
    }
    


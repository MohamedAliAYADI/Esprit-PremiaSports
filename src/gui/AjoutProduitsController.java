/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import edu.esprit.entities.Categories;
import edu.esprit.entities.Produits;
import edu.esprit.services.CategorieService;
import edu.esprit.services.ProduitService;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class AjoutProduitsController implements Initializable {

    @FXML
    private ImageView image;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnUploadImage;
    @FXML
    private Button btnCancel;
    @FXML
    private Text txtImage;
    @FXML
    private TextField nom_prod;
 
    @FXML
    private TextField prix;
     
    private ChoiceBox<Categories> listcat;
    @FXML
    private Text deco;
    @FXML
    private TextField reference_prod;
    @FXML
    private TextField description;
    @FXML
    private TextField quantite;
ProduitService ps = new ProduitService ();
    @FXML
    private ComboBox<Categories> list_catg;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Categories cs = new Categories () ; 
        CategorieService cc = new CategorieService () ;
        cc.selectall() ;
    System.out.println () ;
    
        // TODO
    }    

    @FXML
    private void ajouterproduit(ActionEvent event) {
   
        
         if (nom_prod.getText().isEmpty() || reference_prod.getText().isEmpty() || description.getText().isEmpty() || prix.getText().isEmpty() || quantite.getText().isEmpty() ) {
            Alert a = new Alert(Alert.AlertType.ERROR, "vous devez remplir tout les champs  ", ButtonType.OK);
            a.showAndWait();
        } else {
            
                
        
         Produits cc = new Produits (nom_prod.getText(), reference_prod.getText() , description.getText(), prix.getText(), quantite.getText());
        ps.insertProduits(cc);
            Alert a = new Alert(Alert.AlertType.INFORMATION, "produit Ajouté !", ButtonType.OK);
                a.showAndWait();
         
         
        
        
    }
    }

    @FXML
    private void uploadImage(ActionEvent event) {
        
        		FileChooser fileChooser = new FileChooser();
		File selectedFile = fileChooser.showOpenDialog(null);

		    txtImage.setText("File selected: " + selectedFile.getName());
		    Image temp = new Image(selectedFile.toURI().toString());
		    image.setImage(temp);
		   
		}
    

    @FXML
    private void Cancel_button(ActionEvent event) {
         nom_prod.setText("");
        description.setText("");
        prix.setText("");
        reference_prod.setText("");
        quantite.setText("");
        image.setImage(null);
 System.gc();
    }

    @FXML
    private void rt(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("ProduitDisplay.fxml"));
        Scene scene = new Scene(root);
        Stage stage =(Stage)((Node) event.getSource()).getScene().getWindow();  
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void deco(MouseEvent event) {
    }

    
}

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
public class UpdcategController implements Initializable {

    @FXML
    private TableView<Categories> table;
    @FXML
    private TableColumn<Categories, Integer> id_catg;
    @FXML
    private TableColumn<Categories, String> type;
    @FXML
    private TableColumn<Categories, String> nom_cat;
    @FXML
    private TextField id_cat;
    @FXML
    private TextField txttype;
    @FXML
    private TextField txtname;
    CategorieService cs = new CategorieService();
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
    private void actUpdate(ActionEvent event) {

        Categories css1 = table.getSelectionModel().getSelectedItem();

        String a = css1.getType();
        String b = css1.getNom_cat();
        String c = String.valueOf(css1.getId_catg());

        txttype.setText(a);
        txtname.setText(b);
        id_cat.setText(c);

    }

    @FXML
    private void modif(ActionEvent event) {

        CategorieService cs = new CategorieService();

        Categories c = new Categories();

        c.setType(txttype.getText());
        c.setNom_cat(txtname.getText());
        c.setId_catg(Integer.parseInt(id_cat.getText()));
        cs.Update(c);

        ObservableList<Categories> data;
        data = FXCollections.observableArrayList(cs.selectall());
        table.setItems(data);
    }

    @FXML
    private void returnn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CategoriesDisplay.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void deco(MouseEvent event) {
    }

}

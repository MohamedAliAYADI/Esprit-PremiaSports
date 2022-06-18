/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import edu.esprit.entities.Promotion;
import edu.esprit.services.PromotionServices;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author bouss
 */
public class PromotionAController implements Initializable {

 private final ObservableList<Promotion> aff = FXCollections.observableArrayList();
    @FXML
    private TableView<Promotion> promotions;
    @FXML
    private TextField inpid;
    @FXML
    private TextField inpType;
    @FXML
    private TextField inpPromo;
    private Label label;
    private Label labellist;
    @FXML
    private TableColumn<Promotion, Integer> idcol;
    @FXML
    private TableColumn<Promotion, String> typecol;
    @FXML
    private TableColumn<Promotion, Integer> promocol;
    @FXML
    private Button btnADD;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDisplay;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         PromotionServices ser = new PromotionServices();
        List<Promotion> list = ser.displayPromotion();
        aff.addAll(list);
        promotions.getItems().clear();
        promotions.setItems(aff);
        idcol.setCellValueFactory(new PropertyValueFactory<Promotion, Integer>("id_promotion"));
      typecol.setCellValueFactory(new PropertyValueFactory<Promotion, String>("type_promotion"));
        promocol.setCellValueFactory(new PropertyValueFactory<Promotion, Integer>("promo"));
    }    

    @FXML
    private void Add(ActionEvent event) {
           int id=Integer.parseInt(inpid.getText());
        String Type=inpType.getText();
        Float promo=Float.parseFloat(inpPromo.getText());
        Promotion P=new Promotion(id, Type, promo);
        PromotionServices pst=new PromotionServices();
        pst.InsertIntoPromotion(P);
    }

    @FXML
    private void Delete(ActionEvent event) {
            PromotionServices pst=new PromotionServices();
                pst.DeletePromotion((Promotion) promotions.getSelectionModel().getSelectedItem());
        promotions.getItems().remove(promotions.getSelectionModel().getSelectedItem());
 
    }

    @FXML
    private void Update(ActionEvent event) {
                int id=Integer.parseInt(inpid.getText());
        String Type=inpType.getText();
       Float promo=Float.parseFloat(inpPromo.getText());
        Promotion P=new Promotion(id, Type, promo);
        PromotionServices pst=new PromotionServices();
        pst.UpdatePromotion(P);
    }

    @FXML
    private void Display(ActionEvent event) {
    }
    
}

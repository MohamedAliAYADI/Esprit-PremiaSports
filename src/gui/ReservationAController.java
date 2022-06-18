/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import edu.esprit.entities.Promotion;
import edu.esprit.entities.Reservation;
import edu.esprit.services.PromotionServices;
import edu.esprit.services.Reservationservices;
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
import javafx.scene.control.ListView;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
/**
 * FXML Controller class
 *
 * @author bouss
 */
public class ReservationAController implements Initializable {
 private final ObservableList<Reservation> aff = FXCollections.observableArrayList();

    @FXML
    private TableView<Reservation> reservations;
    @FXML
    private TableColumn<Reservation, Integer> colid;
    @FXML
    private TableColumn<Reservation, String> coldate;
    @FXML
    private TableColumn<Reservation, Integer> colnombre;
    @FXML
    private TableColumn<Reservation, Integer> colprix;
    @FXML
    private TableColumn<Reservation, Integer> colpromo;
    @FXML
    private Button addBtn;
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
              Reservationservices res = new Reservationservices();
        List<Reservation> list = res.displayReservation();
        aff.addAll(list);
        reservations.getItems().clear();
        reservations.setItems(aff);
        colid.setCellValueFactory(new PropertyValueFactory<Reservation, Integer>("idReservation"));
      colnombre.setCellValueFactory(new PropertyValueFactory<Reservation, Integer>("nombredeParticipant"));
      coldate.setCellValueFactory(new PropertyValueFactory<Reservation, String>("DateReservation"));
        colprix.setCellValueFactory(new PropertyValueFactory<Reservation, Integer>("prix"));
        colpromo.setCellValueFactory(new PropertyValueFactory<Reservation, Integer>("promotion"));
 
      
    }   
    
 



  
    @FXML
    private void AddReservation(ActionEvent event) {
    }


    



 

    

}

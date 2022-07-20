package edu.esprit.utils;

import javafx.scene.input.MouseEvent;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import edu.esprit.entities.PromotionReservationTranning;
import edu.esprit.services.PromotionReservationTranningService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;



public class PromotionReservationTranningController implements Initializable {
        
    @FXML
    private TableView<PromotionReservationTranning> PromoTable;
    @FXML
    private TableColumn<PromotionReservationTranning, String> id_code;
    @FXML
    private TableColumn<PromotionReservationTranning, String> id_organizer;
    @FXML
    private TableColumn<PromotionReservationTranning, String> id_nb;
    @FXML
    private TableColumn<PromotionReservationTranning, String> id_percent;
    @FXML
    private TableColumn<PromotionReservationTranning, ?> id_id;

    ObservableList<PromotionReservationTranning>  PromoList = FXCollections.observableArrayList();
    
    
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		loadDate();
		
	}
	
	@FXML
    void onClickRow (MouseEvent event) {

			try {
				PromotionReservationTranning clickedPromo = PromoTable.getSelectionModel().getSelectedItem();
				System.out.print(String.valueOf(clickedPromo.getId()));
				SharedSession.promoCode_id = clickedPromo.getId();
		        Parent root = FXMLLoader.load(getClass().getResource("/GUI/UpdatePromotionReservationTranning.fxml"));
		        Scene scene = new Scene(root);
		        Stage stage =(Stage)((Node) event.getSource()).getScene().getWindow();  
		        stage.setScene(scene);
		        stage.show();   
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


	}
    @FXML
	private void refreshTable() {
		PromotionReservationTranningService prts = new PromotionReservationTranningService();
		PromoList = prts.getListPromotionReservationTranning();
		System.out.print(PromoList);
		PromoTable.setItems(PromoList);
	}
    
    public void DeleteAction(ActionEvent event) {
    	
    }
    
    @FXML
    private void getAddView(ActionEvent event) throws  IOException{
       try {
           Parent root = FXMLLoader.load(getClass().getResource("/GUI/AddPromotionReservationTranning.fxml"));
           Scene scene = new Scene(root);
           Stage stage =(Stage)((Node) event.getSource()).getScene().getWindow();  
           stage.setScene(scene);
           stage.show();
          

       } catch (IOException ex) {
            System.out.print("We Cant open Widows Add promo code");
        }
    }
    private void loadDate() {
        refreshTable();
       
        id_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        id_code.setCellValueFactory(new PropertyValueFactory<>("code"));
        id_organizer.setCellValueFactory(new PropertyValueFactory<>("organizer"));
        id_nb.setCellValueFactory(new PropertyValueFactory<>("nb"));
        id_percent.setCellValueFactory(new PropertyValueFactory<>("percent"));

       }
    
    
	@FXML
	public void getUpdateCodePromoView (ActionEvent event) {
	       try {
	           Parent root = FXMLLoader.load(getClass().getResource("/GUI/UpdatePromotionReservationTranning.fxml"));
               Scene scene = new Scene(root, 1100, 570);
	           Stage stage =(Stage)((Node) event.getSource()).getScene().getWindow();  
	           stage.setScene(scene);
	           stage.show();
	          

	       } catch (IOException ex) {
	            System.out.print("We Cant open Widows Add promo code");
	        }
	}
	@FXML
	public void getAddCodePromoVView (ActionEvent event) {
	       try {
	           Parent root = FXMLLoader.load(getClass().getResource("/GUI/AddPromotionReservationTranning.fxml"));
               Scene scene = new Scene(root, 1100, 570);
	           Stage stage =(Stage)((Node) event.getSource()).getScene().getWindow();  
	           stage.setScene(scene);
	           stage.show();
	          

	       } catch (IOException ex) {
	            System.out.print("We Cant open Widows Add promo code");
	       }
	}
	@FXML
	public void getListCodePromoView (ActionEvent event) {
	       try {
	           Parent root = FXMLLoader.load(getClass().getResource("/GUI/PromotionReservationTranning.fxml"));
               Scene scene = new Scene(root, 1100, 570);
	           Stage stage =(Stage)((Node) event.getSource()).getScene().getWindow();  
	           stage.setScene(scene);
	           stage.show();
	          

	       } catch (IOException ex) {
	            System.out.print("We Cant open Widows Add promo code");
	       }
		
	}
	@FXML
	public void getListCoachNotesView (ActionEvent event) {
	       try {
	           Parent root = FXMLLoader.load(getClass().getResource("/GUI/ListCoachNotes.fxml"));
               Scene scene = new Scene(root, 1100, 570);
	           Stage stage =(Stage)((Node) event.getSource()).getScene().getWindow();  
	           stage.setScene(scene);
	           stage.show();
	          

	       } catch (IOException ex) {
	            System.out.print("We Cant open Widows Add promo code");
	       }
		
	}
	
	@FXML
	private void goGeneralChat () {
	    try {
			Desktop.getDesktop().browse(new URI("https://permia-sport.vercel.app"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@FXML
	public void getAddCoachNotesView (ActionEvent event) {
	       try {
	           Parent root = FXMLLoader.load(getClass().getResource("/GUI/AddCoachNotes.fxml"));
               Scene scene = new Scene(root, 1100, 570);
	           Stage stage =(Stage)((Node) event.getSource()).getScene().getWindow();  
	           stage.setScene(scene);
	           stage.show();
	          

	       } catch (IOException ex) {
	            System.out.print("We Cant open Widows Add promo code");
	       }
		
	}
}

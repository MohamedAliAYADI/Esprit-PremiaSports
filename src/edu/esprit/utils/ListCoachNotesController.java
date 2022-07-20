package edu.esprit.utils;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

import edu.esprit.entities.CoachNotes;
import edu.esprit.entities.PromotionReservationTranning;
import edu.esprit.services.CoachNotesService;
import edu.esprit.services.PromotionReservationTranningService;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ListCoachNotesController implements Initializable {
    
@FXML
private TableView<CoachNotes> CoachNotesTable;
@FXML
private TableColumn<CoachNotes, String> id_title;
@FXML
private TableColumn<CoachNotes, String> id_description;
@FXML
private TableColumn<CoachNotes, ?> id_id;

ObservableList<CoachNotes>  CoachNotesTableList = FXCollections.observableArrayList();


public void initialize(URL arg0, ResourceBundle arg1) {
	// TODO Auto-generated method stub
	loadDate();
	
}

@FXML
void onClickRow (MouseEvent event) {

		try {
			CoachNotes clickedPromo = CoachNotesTable.getSelectionModel().getSelectedItem();
			System.out.print("4f4f4f4f4f4f4f");
			System.out.print(String.valueOf(clickedPromo.getId()));
			SharedSession.coachNote_id = clickedPromo.getId();
	        Parent root = FXMLLoader.load(getClass().getResource("/GUI/UpdateCoachNotes.fxml"));
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
	CoachNotesService prts = new CoachNotesService();
	CoachNotesTableList = prts.getListCoachNotes(0);
	CoachNotesTable.setItems(CoachNotesTableList);
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

private void loadDate() {
    refreshTable();
   
    id_id.setCellValueFactory(new PropertyValueFactory<>("id"));
    id_title.setCellValueFactory(new PropertyValueFactory<>("title"));
    id_description.setCellValueFactory(new PropertyValueFactory<>("description"));
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
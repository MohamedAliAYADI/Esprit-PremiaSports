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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddCoachNotesController implements Initializable {
	//id_description_4
    @FXML
    private TextField id_title;
    @FXML
    private TextField id_description;
    @FXML
    private TextField id_title_1;
    @FXML
    private TextField id_description_1;
    @FXML
    private TextField id_title_2;
    @FXML
    private TextField id_description_2;
    @FXML
    private TextField id_title_3;
    @FXML
    private TextField id_description_3;
    @FXML
    private TextField id_title_4;
    @FXML
    private TextField id_description_4;
    @FXML
    private TextField id_title_5;
    @FXML
    private TextField id_description_5;
	
    MyConnection mc= MyConnection.getInstance();          
    CoachNotesService coachNotesService = new CoachNotesService();
    CoachNotes rt;
    
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		rt = new CoachNotes();

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
	public void onSubmit (ActionEvent event) {
        if(!id_title.getText().isEmpty() || !id_description.getText().isEmpty()) {
			try {
	        	rt.setTitle(id_title.getText().toString());
	        	rt.setDescription(id_description.getText().toString());
	        	rt.setTitle_1(id_title_1.getText().toString());
	        	rt.setDescription_1(id_description_1.getText().toString());
	        	rt.setTitle_2(id_title_2.getText().toString());
	        	rt.setDescription_2(id_description_2.getText().toString());
	        	rt.setTitle_3(id_title_3.getText().toString());
	        	rt.setDescription_3(id_description_3.getText().toString());
	        	rt.setTitle_4(id_title_4.getText().toString());
	        	rt.setDescription_4(id_description_4.getText().toString());
	        	rt.setTitle_5(id_title_5.getText().toString());
	        	rt.setDescription_5(id_description_5.getText().toString());
	        	rt.setCoach_id(0);
	        	coachNotesService.createCoachNotes(rt);
			    Alert a=new Alert(Alert.AlertType.INFORMATION.WARNING,"Note Coach added successfully" , ButtonType.OK);
			    a.showAndWait();
	            Parent root;
				root = new FXMLLoader().load(getClass().getResource("/GUI/ListCoachNotes.fxml"));
	            Scene scene = new Scene(root, 1100, 570);
		        Stage stage =(Stage)((Node) event.getSource()).getScene().getWindow();  
		        stage.setScene(scene);
		        stage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		else {
		    Alert a=new Alert(Alert.AlertType.INFORMATION.ERROR,"Enter all data" , ButtonType.OK);
		    a.showAndWait();
		    return;
		}	
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

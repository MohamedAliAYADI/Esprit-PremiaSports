package edu.esprit.utils;

import java.awt.Desktop;
import java.awt.TextArea;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import edu.esprit.entities.PromotionReservationTranning;
import edu.esprit.entities.ReservationTraining;
	import edu.esprit.services.PromotionReservationTranningService;
	import edu.esprit.services.ReservationTranningService;
	import javafx.event.ActionEvent;
	import javafx.event.EventHandler;
	import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
	import javafx.scene.control.ButtonType;
	import javafx.scene.control.DatePicker;
	import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddPromotionTrainingReservationController  implements Initializable {
		
	    @FXML
	    private TextField id_code;
	    @FXML
	    private TextField id_orginizer;
	    @FXML
	    private TextField id_nb;
	    @FXML
	    private TextField id_percent;	    
	 	// create instance
	    MyConnection mc= MyConnection.getInstance();          
	    PromotionReservationTranning rt;
	    PromotionReservationTranningService PromoTrainngService = new PromotionReservationTranningService();
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			rt = new PromotionReservationTranning();
			id_code.setText(rt.getCode());
		}
		
	    
		public void onSubmit() {
	        
	        if(!id_code.getText().isEmpty() || !id_orginizer.getText().isEmpty() || !id_nb.getText().isEmpty() || !id_percent.getText().isEmpty()) {
	        	rt.setNb(Integer.parseInt(id_nb.getText().toString()));
	        	rt.setOrganizer(id_orginizer.getText().toString());
	        	rt.setPercent(id_percent.getText().toString()+"%");
	        	PromoTrainngService.createCodePromo(rt);
			    Alert a=new Alert(Alert.AlertType.INFORMATION.WARNING,"Code promo created successfully" , ButtonType.OK);
			    a.showAndWait();
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
	}

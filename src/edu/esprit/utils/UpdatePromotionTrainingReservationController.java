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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

	public class UpdatePromotionTrainingReservationController  implements Initializable {
		


	    
	    @FXML
	    private TextField id_input_code;
	    @FXML
	    private TextField id_input_orginizer;
	    @FXML
	    private TextField id_input_nb;
	    @FXML
	    private TextField id_input_percent;
	    @FXML
	    private Button id_input_search_btn;
	 	// create instance
	    
	    MyConnection mc= MyConnection.getInstance();          
	    PromotionReservationTranningService PromoTrainngService = new PromotionReservationTranningService();
	    PromotionReservationTranning rt;

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			SearchGetUser();
			rt = new PromotionReservationTranning();

		}
		@FXML
		public void SearchGetUser() {
			int idSearcher = SharedSession.promoCode_id;
			PromotionReservationTranning rtGet = new PromotionReservationTranning();
			rtGet.setOrganizer(this.PromoTrainngService.getCodePromoById(idSearcher).getOrganizer());
			rtGet.setCode(this.PromoTrainngService.getCodePromoById(idSearcher).getOrganizer());
			rtGet.setNb(this.PromoTrainngService.getCodePromoById(idSearcher).getNb());
			rtGet.setPercent(this.PromoTrainngService.getCodePromoById(idSearcher).getPercent());
			System.out.print(rtGet.getOrganizer());
			
			if(this.PromoTrainngService.getCodePromoById(idSearcher).getOrganizer() != null) {
				id_input_orginizer.setText(rtGet.getOrganizer());
				id_input_percent.setText(rtGet.getPercent());
				id_input_nb.setText(String.valueOf(rtGet.getNb()));
				id_input_code.setText(rtGet.getCode());
			}
			else {
			    Alert a=new Alert(Alert.AlertType.INFORMATION.ERROR,"Not found !" , ButtonType.OK);
			    a.showAndWait();
			    return;
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
		public void deleteCodePromo(ActionEvent event) {
		    
			try {
				int idSearcher = SharedSession.promoCode_id;
				PromoTrainngService.deleteCodePromo(idSearcher);
			    Alert a=new Alert(Alert.AlertType.INFORMATION.ERROR,"Not found !" , ButtonType.OK);
			    a.showAndWait();
		        Parent root;
				root = FXMLLoader.load(getClass().getResource("/GUI/ListCoachNotes.fxml"));
	            Scene scene = new Scene(root, 1100, 570);
		        Stage stage =(Stage)((Node) event.getSource()).getScene().getWindow();  
		        stage.setScene(scene);
		        stage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
		
		
		public void onSubmit(ActionEvent event) {
	        
	        if(!id_input_code.getText().isEmpty() || !id_input_orginizer.getText().isEmpty() || !id_input_nb.getText().isEmpty() || !id_input_percent.getText().isEmpty()) {

				try {
		        	rt.setNb(Integer.parseInt(id_input_nb.getText().toString()));
		        	rt.setOrganizer(id_input_orginizer.getText().toString());
		        	rt.setPercent(id_input_percent.getText().toString());
		        	//PromoTrainngService.createCodePromo(rt);
		        	PromoTrainngService.updateCodePromo(SharedSession.promoCode_id, rt);
				    Alert a=new Alert(Alert.AlertType.INFORMATION.WARNING,"Code promo update successfully" , ButtonType.OK);
				    a.showAndWait();
			        Parent root;
					root = FXMLLoader.load(getClass().getResource("/GUI/ListCoachNotes.fxml"));
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

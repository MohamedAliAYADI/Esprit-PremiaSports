/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import edu.esprit.entities.Promotion;
import edu.esprit.entities.Reservation;
import edu.esprit.services.PromotionServices;
import edu.esprit.services.Reservationservices;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author bouss
 */
public class ReservationUserController implements Initializable {
private final ObservableList<Reservation> aff = FXCollections.observableArrayList();
    @FXML
    private TextField inputdate;
    @FXML
    private TextField inputpart;
    @FXML
    private TextField inputprix;
    private TextField inputpromo;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnUpdate;
    @FXML
    private TableView<Reservation> TableD;
    @FXML
    private TableColumn<Reservation, Integer> PromoCol;
    @FXML
    private TableColumn<Reservation, String> datecol;
    @FXML
    private TableColumn<Reservation, Integer> nombrecol;
    @FXML
    private TableColumn<Reservation, Integer> prixcol;
    @FXML
    private TableColumn<Reservation, Integer> PromoCol12;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
 
        
        Reservationservices ser = new Reservationservices();
        List<Reservation> list = ser.displayReservation();
        aff.addAll(list);
        TableD.getItems().clear();
        TableD.setItems(aff);
        datecol.setCellValueFactory(new PropertyValueFactory<Reservation, String>("DateReservation"));
      nombrecol.setCellValueFactory(new PropertyValueFactory<Reservation, Integer>("nombredeParticipant"));
        prixcol.setCellValueFactory(new PropertyValueFactory<Reservation, Integer>("prix"));
        PromoCol.setCellValueFactory(new PropertyValueFactory<Reservation, Integer>("promotion"));
    }    

    @FXML
    private void AddReservation(ActionEvent event) {
        
        
        Stage primaryStage=new Stage();
      QRCodeWriter qrCodeWriter = new QRCodeWriter();
        String name = "OUssama";
        int width = 300;
        int height = 300;
        String fileType = "png";
        
        BufferedImage bufferedImage = null;
        try {
            BitMatrix byteMatrix = qrCodeWriter.encode(name, BarcodeFormat.QR_CODE, width, height);
            bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            bufferedImage.createGraphics();
            
            Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();
            graphics.setColor(Color.WHITE);
            graphics.fillRect(0, 0, width, height);
            graphics.setColor(Color.BLACK);
            
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (byteMatrix.get(i, j)) {
                        graphics.fillRect(i, j, 1, 1);
                    }
                }
            }
            
            System.out.println("Success...");
            
        } catch (WriterException ex) {
            Logger.getLogger(JavaFX_QRCodeWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ImageView qrView = new ImageView();
        qrView.setImage(SwingFXUtils.toFXImage(bufferedImage, null));
        
        StackPane root = new StackPane();
        root.getChildren().add(qrView);
        
        Scene scene = new Scene(root, 350, 350);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
        
        PromotionServices pservice=new PromotionServices();
         String Date_Reservation=inputdate.getText();
        int nbrParticipant=Integer.parseInt(inputpart.getText());
          int prix=Integer.parseInt(inputprix.getText());
        Promotion p=pservice.GetPromotionByID(1);
         
      Reservation R=new Reservation( Date_Reservation, nbrParticipant, prix);
        Reservationservices rs=new Reservationservices();
        rs.InsertIntoReservation(R,p);
    }

    @FXML
    private void Delete(ActionEvent event) {
         Reservationservices rs=new Reservationservices();
                 rs.DeleteReservation((Reservation)TableD.getSelectionModel().getSelectedItem());
        TableD.getItems().remove(TableD.getSelectionModel().getSelectedItem());

    }

    @FXML
    private void Update(ActionEvent event) {
        String Date_Reservation=inputdate.getText();
        int nbrParticipant=Integer.parseInt(inputpart.getText());
          int prix=Integer.parseInt(inputprix.getText());
            int updid=Integer.parseInt(inputpromo.getText());
            Reservation R=new Reservation(updid, Date_Reservation, nbrParticipant, prix);
             Reservationservices rs=new Reservationservices();
             rs.UpdateReservationUser(R);
    }

 

    @FXML
    private void Display(SortEvent<Reservation> event) {
    }
    
    
    
}

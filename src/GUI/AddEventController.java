/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import edu.esprit.entities.Event;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import edu.esprit.services.EventService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import javafx.scene.Node;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author nemya
 */
public class AddEventController implements Initializable {
    
    @FXML
    private JFXTextField titleTf;
    @FXML
    private TextArea descriptionTe;
    @FXML
    private JFXDatePicker startDateDatePicker;
    @FXML
    private JFXDatePicker endDateDatePicker;
    
    public static boolean update;
    int id;
    
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");



    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void save(MouseEvent event) {

        
                if(titleTf.getText().isEmpty()){
                    Alert a=new Alert(Alert.AlertType.INFORMATION.ERROR,"Title is empty" , ButtonType.OK);
                    a.showAndWait();
                    return;
                }if(descriptionTe.getText().isEmpty()){
                     Alert a=new Alert(Alert.AlertType.INFORMATION.ERROR,"Description is empty" , ButtonType.OK);
                    a.showAndWait();
                    return;
                }if(startDateDatePicker.getValue() == null){
                     Alert a=new Alert(Alert.AlertType.INFORMATION.ERROR,"Start Date is empty" , ButtonType.OK);
                    a.showAndWait();
                    return;
                }
                if(endDateDatePicker.getValue() == null){
                     Alert a=new Alert(Alert.AlertType.INFORMATION.ERROR,"End Date is empty" , ButtonType.OK);
                    a.showAndWait();
                    return;
                }
                                        int res=startDateDatePicker.getValue().compareTo(endDateDatePicker.getValue());

                if(res == 0 ){
                    Alert a=new Alert(Alert.AlertType.INFORMATION.ERROR,"Start date is equal to end date" , ButtonType.OK);
                    a.showAndWait();
                    return; 
                }
                if (res > 0){
                    Alert a=new Alert(Alert.AlertType.INFORMATION.ERROR,"End date should be afted start date , Please Verify !!!" , ButtonType.OK);
                    a.showAndWait();
                    return; 
                }else if(update ==true){
                    System.out.println("add service");
        EventService es=new EventService();
        String title=titleTf.getText();
        String description=descriptionTe.getText();
        String startDate=startDateDatePicker.getValue().toString();
        String endDate=endDateDatePicker.getValue().toString();
        Event e=new Event(title, description, startDate, endDate);
        es.insertEvent1(e);
        Alert a=new Alert(Alert.AlertType.CONFIRMATION,"Event Added Succesfully" , ButtonType.OK);
        Optional<ButtonType> result= a.showAndWait();
        if(!result.isPresent()){
            
        }
    // alert is exited, no button has been pressed.
        else if(result.get() == ButtonType.OK){
                     Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
            
        }
     //oke button is pressed
         else if(result.get() == ButtonType.CANCEL){
             
         }                  
                }else if (update==false){
                            EventService es=new EventService();

                        String title=titleTf.getText();
        String description=descriptionTe.getText();
        String startDate=startDateDatePicker.getValue().toString();
        String endDate=endDateDatePicker.getValue().toString();
                Event e=new Event(id,title, description, startDate, endDate);

          es.modifyEvent(e);
              Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
                }
  
        
    }
        void setTextField(int id, String  title, String desc, String startDate, String endDate) {
            this.id=id;
        titleTf.setText(title);
        descriptionTe.setText(desc);
        startDateDatePicker.setValue(LocalDate.parse(startDate, formatter));
        endDateDatePicker.setValue(LocalDate.parse(endDate, formatter));
    }

    @FXML
    private void clean(MouseEvent event) {
        titleTf.setText(null);
        descriptionTe.setText(null);
        startDateDatePicker.setValue(null);
        endDateDatePicker.setValue(null);
        
    }
        @FXML
    private void close(MouseEvent event) {
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    void setUpdate(boolean b) {
      this.update=b;   
    }
    }
    

    


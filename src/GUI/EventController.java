/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import edu.esprit.entities.Event;
import edu.esprit.services.EventService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author nemya
 */
public class EventController implements Initializable {

    @FXML
    private TextField titleTf;
    @FXML
    private TextArea descriptionTe;
    @FXML
    private DatePicker startDateDatePicker;
    @FXML
    private DatePicker endDateDatePicker;
    @FXML
    private Button addbtn;
    @FXML
    private Button canclebtn;
    @FXML
    private AnchorPane back;
    


    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    

    @FXML
    private void addEvent(ActionEvent event) {

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
        EventService es=new EventService();
        String title=titleTf.getText();
        String description=descriptionTe.getText();
        String startDate=startDateDatePicker.getValue().toString();
        String endDate=endDateDatePicker.getValue().toString();
        Event e=new Event(title, description, startDate, endDate);
        es.insertEvent1(e);
         Alert a=new Alert(Alert.AlertType.CONFIRMATION,"Event Added Succesfully" , ButtonType.OK);
                    a.showAndWait();
        

        
    }



    
}

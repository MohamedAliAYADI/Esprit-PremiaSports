/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import edu.esprit.entities.Event;
import edu.esprit.services.EventService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author nemya
 */
public class TableViewController implements Initializable {

    @FXML
    private TableView<Event> studentsTable;
    @FXML
    private TableColumn<Event, String> nameCol;
    @FXML
    private TableColumn<Event, String> birthCol;
    @FXML
    private TableColumn<Event, String> adressCol;
    @FXML
    private TableColumn<Event, String> emailCol;
    ObservableList<Event>  StudentList = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Event, String> editCol;
    Event ev=null;
    @FXML
    private TableColumn<Event, String> idCol;




    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadDate();
        // TODO
    }    
             @FXML
    private void print(MouseEvent event) {
    
    }

    @FXML
    private void close(MouseEvent event) {
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void getAddView(MouseEvent event) {
        AddEventController.update=true;
                try {
            Parent parent = FXMLLoader.load(getClass().getResource("..//GUI//addEvent.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            
        }
    }

    @FXML
    private void refreshTable() {
        EventService eventService=new EventService();
       StudentList= eventService.displayEvent(); 
       studentsTable.setItems(StudentList);
        
        
    }
       private void loadDate() {
        
        refreshTable();
        idCol.setCellValueFactory(new PropertyValueFactory<>("eventId"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("eventTitle"));
        birthCol.setCellValueFactory(new PropertyValueFactory<>("eventDescription"));
        adressCol.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("endDate"));
         Callback<TableColumn<Event, String>, TableCell<Event, String>> cellFoctory = (TableColumn<Event, String> param) -> {
              final TableCell<Event ,String > cell=new  TableCell<Event,String>(){
                  @Override
                  protected void updateItem(String item, boolean empty) {
                      super.updateItem(item, empty); //To change body of generated methods, choose Tools | Templates.
                           if (empty) {
                        setGraphic(null);
                        setText(null);

                    }else {

                        FontAwesomeIconView deleteIcon = new FontAwesomeIconView(FontAwesomeIcon.TRASH);
                        FontAwesomeIconView editIcon = new FontAwesomeIconView(FontAwesomeIcon.PENCIL_SQUARE);

                        deleteIcon.setStyle(
                                " -fx-cursor: hand ;"
                                + "-glyph-size:28px;"
                                + "-fx-fill:#ff1744;"
                        );
                        editIcon.setStyle(
                                " -fx-cursor: hand ;"
                                + "-glyph-size:28px;"
                                + "-fx-fill:#00E676;"
                        );
                 deleteIcon.setOnMouseClicked((MouseEvent event) -> {
                     ev=studentsTable.getSelectionModel().getSelectedItem();
                     EventService es=new EventService();
                     es.deleteEvent(ev);
                     refreshTable();
                 });
                 editIcon.setOnMouseClicked((MouseEvent event) -> {
                     AddEventController.update=false;
                     ev=studentsTable.getSelectionModel().getSelectedItem();
                     FXMLLoader loader = new FXMLLoader ();
                     loader.setLocation(getClass().getResource("/GUI/addEvent.fxml"));
                              try {
                                loader.load();
                            } catch (IOException ex) {
                                Logger.getLogger(TableViewController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                              AddEventController addEventController=loader.getController();
                              addEventController.setTextField(ev.getEventId(),ev.getEventTitle(), ev.getEventDescription(), ev.getStartDate(), ev.getEndDate());
                            Parent parent = loader.getRoot();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(parent));
                            stage.initStyle(StageStyle.UTILITY);
                            stage.show();


                     
                 });
                        HBox managebtn = new HBox(editIcon, deleteIcon);
                        managebtn.setStyle("-fx-alignment:center");
                        HBox.setMargin(deleteIcon, new Insets(2, 2, 0, 3));
                        HBox.setMargin(editIcon, new Insets(2, 3, 0, 2));

                        setGraphic(managebtn);

                        setText(null);
                  }
                 
                 
                  
              }
         
       };
                 return cell;
     };
                  editCol.setCellFactory(cellFoctory);
                           studentsTable.setItems(StudentList);


}
}
 

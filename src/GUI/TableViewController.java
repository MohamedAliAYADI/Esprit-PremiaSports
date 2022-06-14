/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import edu.esprit.entities.Event;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author nemya
 */
public class TableViewController implements Initializable {

    @FXML
    private TableView<?> studentsTable;
    @FXML
    private TableColumn<?, ?> idCol;
    @FXML
    private TableColumn<?, ?> nameCol;
    @FXML
    private TableColumn<?, ?> birthCol;
    @FXML
    private TableColumn<?, ?> adressCol;
    @FXML
    private TableColumn<?, ?> emailCol;
    @FXML
    private TableColumn<?, ?> editCol;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void close(MouseEvent event) {
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    private void getAddView(MouseEvent event) {
                try {
            Parent parent = FXMLLoader.load(getClass().getResource("..//GUI//addEvent.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(tableView.TableViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void refreshTable(MouseEvent event) {
    }

    @FXML
    private void print(MouseEvent event) {
    }
    



    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import edu.esprit.entities.User;
import edu.esprit.services.UserService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import edu.esprit.services.UserService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;
/**
 * FXML Controller class
 *
 * @author Slimen OUNI
 */
public class SearchUsersController implements Initializable {

    @FXML
    private TableColumn<User, String> pseudo;
    @FXML
    private TableColumn<User, String> email;
    @FXML
    private TableColumn<Object, String> role;
    @FXML
    private TableView<User> userList;
    private final ObservableList<User> dataList = FXCollections.observableArrayList();
    @FXML
    private TextField filterField;
           private Stage stage;
 private Scene scene;
 private Parent root;   
 private Button CancelBtn;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        searchAndFilter();
    }    


    
    public void searchAndFilter(){
    
        
          UserService us;
        us = new UserService();
        List<User> users = new ArrayList<User>();
        users = us.listUsersA1();
            pseudo.setCellValueFactory(new PropertyValueFactory<>("pseudo"));
        email.setCellValueFactory(new PropertyValueFactory("email"));
        role.setCellValueFactory(new PropertyValueFactory<>("role"));
          for (User user : users) {
             dataList.add(user);
        }
    
          FilteredList<User> filteredData = new FilteredList<>(dataList, b -> true);
          
          	filterField.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(user -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (user.getPseudo().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} else if (user.getEmail().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
				else if (String.valueOf(user.getRole()).indexOf(lowerCaseFilter)!=-1)
				     return true;
				     else  
				    	 return false; // Does not match.
			});
		});
    
    
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<User> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(userList.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		userList.setItems(sortedData);
    
    }

    

    @FXML
    private void logout(MouseEvent event)  {
                           Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Vous allez quitter l'application");
        alert.setHeaderText("Vous allez quitter l'application");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            System.exit(0);
        } else {
            alert.close();
        }
    }

    @FXML
    private void back(MouseEvent event) throws IOException {
              root = FXMLLoader.load(getClass().getResource("UserManagement.fxml"));
  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
   
    }

 
}


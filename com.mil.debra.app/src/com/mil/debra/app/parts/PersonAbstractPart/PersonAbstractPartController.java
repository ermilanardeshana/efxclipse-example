package com.mil.debra.app.parts.PersonAbstractPart;

import com.mil.debra.app.parts.PersonDetailedInfoPart.PersonDetailedInfoPartController;

import ch.makery.address.model.Person;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class PersonAbstractPartController {
    @FXML
    private TableView<Person> personTable;


//    @FXML
//    private Label firstNameLabel;
//    @FXML
//    private Label lastNameLabel;
//    @FXML
//    private Label streetLabel;
//    @FXML
//    private Label postalCodeLabel;
//    @FXML
//    private Label cityLabel;
//    @FXML
//    private Label birthdayLabel;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public PersonAbstractPartController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
//    	 FXMLLoader loader = new FXMLLoader(
//    			 PersonAbstractPartController.class.getResource(
//    			      "PersonDetailedInfoPart.fxml"
//    			    )
//    			  );
//    	PersonDetailedInfoPartController detailedPartController = 
//    		    loader.<PersonDetailedInfoPartController>getController();
        // Initialize the person table with the two columns.
       
        // Clear person details.
//        showPersonDetails(null);

        // Listen for selection changes and show the person details when changed.
//        personTable.getSelectionModel().selectedItemProperty().addListener(
//                (observable, oldValue, newValue) -> Platform.runLater(new Runnable() {
//                    @Override
//                    public void run() {
//                    	  detailedPartController.showPersonDetails(newValue);
//                    }
//                  })       );
//        
        //added by milam
        //set peron data created and stored jm ;olk/
//        personTable.setItems(pol.getPersonData());
    }

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
//    public void setMainApp(MainApp mainApp) {
//        this.mainApp = mainApp;
//
//        // Add observable list data to the table
//        personTable.setItems(mainApp.getPersonData());
//    }
    
    /**
     * Fills all text fields to show details about the person.
     * If the specified person is null, all text fields are cleared.
     * 
     * @param person the person or null
     */
    private void showPersonDetails(Person person) {
        if (person != null) {
            // Fill the labels with info from the person object.
//            firstNameLabel.setText(person.getFirstName());
//            lastNameLabel.setText(person.getLastName());
//            streetLabel.setText(person.getStreet());
//            postalCodeLabel.setText(Integer.toString(person.getPostalCode()));
//            cityLabel.setText(person.getCity());
//            birthdayLabel.setText(DateUtil.format(person.getBirthday()));
        } else {
            // Person is null, remove all the text.
//            firstNameLabel.setText("");
//            lastNameLabel.setText("");
//            streetLabel.setText("");
//            postalCodeLabel.setText("");
//            cityLabel.setText("");
//            birthdayLabel.setText("");
        }
    }
    
    /**
     * Called when the user clicks on the delete button.
     */
//    @FXML
//    private void handleDeletePerson() {
//        int selectedIndex = personTable.getSelectionModel().getSelectedIndex();
//        if (selectedIndex >= 0) {
//            personTable.getItems().remove(selectedIndex);
//        } else {
//            // Nothing selected.
//            Alert alert = new Alert(AlertType.WARNING);
//            alert.initOwner(mainApp.getPrimaryStage());
//            alert.setTitle("No Selection");
//            alert.setHeaderText("No Person Selected");
//            alert.setContentText("Please select a person in the table.");
//            
//            alert.showAndWait();
//        }
//    }
    
    /**
     * Called when the user clicks the new button. Opens a dialog to edit
     * details for a new person.
     */
//    @FXML
//    private void handleNewPerson() {
//        Person tempPerson = new Person();
//        boolean okClicked = mainApp.showPersonEditDialog(tempPerson);
//        if (okClicked) {
//            mainApp.getPersonData().add(tempPerson);
//        }
//    }

    /**
     * Called when the user clicks the edit button. Opens a dialog to edit
     * details for the selected person.
     */
//    @FXML
//    private void handleEditPerson() {
//        Person selectedPerson = personTable.getSelectionModel().getSelectedItem();
//        if (selectedPerson != null) {
//            boolean okClicked = mainApp.showPersonEditDialog(selectedPerson);
//            if (okClicked) {
//                showPersonDetails(selectedPerson);
//            }
//
//        } else {
//            // Nothing selected.
//            Alert alert = new Alert(AlertType.WARNING);
//            alert.initOwner(mainApp.getPrimaryStage());
//            alert.setTitle("No Selection");
//            alert.setHeaderText("No Person Selected");
//            alert.setContentText("Please select a person in the table.");
//            
//            alert.showAndWait();
//        }
//    }
}
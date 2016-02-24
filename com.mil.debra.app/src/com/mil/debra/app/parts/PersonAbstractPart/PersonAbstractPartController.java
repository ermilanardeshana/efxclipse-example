package com.mil.debra.app.parts.PersonAbstractPart;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.ContextInjectionFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;

import ch.makery.address.model.Person;
import ch.makery.address.model.PersonListModel;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class PersonAbstractPartController {
	@FXML
	private TableView<Person> personTable;

	@FXML
	private TableColumn<Person, String> firstNameColumn;
	@FXML
	private TableColumn<Person, String> lastNameColumn;

	@FXML
	@Inject
	private ESelectionService selectionService;
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
		firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
		lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
		personTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Person>() {

			@Override
			public void changed(ObservableValue<? extends Person> observable, Person oldValue, Person newValue) {
				selectionService.setSelection(newValue);
				System.out.println("set: " + newValue); 
			}
		});
		personTable.itemsProperty().bind(Bindings.createObjectBinding(()->FXCollections.observableArrayList(PersonListModel.getInstance().getModelList())));
//		personTable.itemsProperty().bind();
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
	public void setItems(ObservableList<Person> value){
		personTable.setItems(value);
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
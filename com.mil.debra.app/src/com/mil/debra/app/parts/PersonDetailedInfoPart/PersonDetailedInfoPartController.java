package com.mil.debra.app.parts.PersonDetailedInfoPart;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EModelService;

import ch.makery.address.model.Person;
import ch.makery.address.model.PersonListModel;
import ch.makery.address.util.DateUtil;
import javafx.beans.binding.Bindings;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

public class PersonDetailedInfoPartController {
	@FXML
	private TableView<Person> personTable;
	//    @FXML
	//    private TableColumn<Person, String> firstNameColumn;
	//    @FXML
	//    private TableColumn<Person, String> lastNameColumn;

	@Inject
	EModelService modelService;
	@Inject
	MApplication application;
	private Person selectedPerson;
	@FXML
	private Label firstNameLabel;
	@FXML
	private Label lastNameLabel;
	@FXML
	private Label streetLabel;
	@FXML
	private Label postalCodeLabel;
	@FXML
	private Label cityLabel;
	@FXML
	private Label birthdayLabel;
	@FXML
	private Button newButton;
	@FXML
	private Button editButton;
	@FXML
	private Button deleteButton;
	@FXML
	private Button cancelButton;
	@FXML
	private Button okButton;
	private ObservableList<Person> modelList;

	/**
	 * The constructor.
	 * The constructor is called before the initialize() method.
	 */
	public PersonDetailedInfoPartController() {
	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {

		//    		firstNameLabel.setText(selectedPerson.getFirstName());
		//            lastNameLabel.setText(selectedPerson.getLastName());
		//            streetLabel.setText(selectedPerson.getStreet());
		//            postalCodeLabel.setText(Integer.toString(selectedPerson.getPostalCode()));
		//            cityLabel.setText(selectedPerson.getCity());
		//            birthdayLabel.setText(DateUtil.format(selectedPerson.getBirthday()));


		// Initialize the person table with the two columns.
		//        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
		//        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());

		// Clear person details.
		//        showPersonDetails(null);

		// Listen for selection changes and show the person details when changed.
		//        personTable.getSelectionModel().selectedItemProperty().addListener(
		//                (observable, oldValue, newValue) -> showPersonDetails(newValue));
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
//	public void showPersonDetails(Person person) {
//		if (person != null) {
//			// Fill the labels with info from the person object.
//			firstNameLabel.setText(person.getFirstName());
//			lastNameLabel.setText(person.getLastName());
//			streetLabel.setText(person.getStreet());
//			postalCodeLabel.setText(Integer.toString(person.getPostalCode()));
//			cityLabel.setText(person.getCity());
//			birthdayLabel.setText(DateUtil.format(person.getBirthday()));
//		} else {
//			// Person is null, remove all the text.
//			firstNameLabel.setText("");
//			lastNameLabel.setText("");
//			streetLabel.setText("");
//			postalCodeLabel.setText("");
//			cityLabel.setText("");
//			birthdayLabel.setText("");
//		}
//	}

	/**
	 * Called when the user clicks on the delete button.
	 */
	@FXML
	private void handleDeletePerson() {
		if (null != selectedPerson) {
			modelList = PersonListModel.getInstance().getPersonList();
			System.out.println(modelList.size());
			PersonListModel.getInstance().removePerson(selectedPerson);
			modelList = PersonListModel.getInstance().getPersonList();
			System.out.println(modelList.size());
		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("No Selection");
			alert.setHeaderText("No Person Selected");
			alert.setContentText("Please select a person in the table.");

			alert.showAndWait();
		}
	}

	/**
	 * Called when the user clicks the new button. Opens a dialog to edit
	 * details for a new person.
	 */
	@FXML
	private void handleNewPerson() {
		//        Person tempPerson = new Person();
		//        boolean okClicked = mainApp.showPersonEditDialog(tempPerson);
		//        if (okClicked) {
		//            mainApp.getPersonData().add(tempPerson);
		//        }
	}

	/**
	 * Called when the user clicks the edit button. Opens a dialog to edit
	 * details for the selected person.
	 */
	@FXML
	private void handleEditPerson() {
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
	}

	/**
	 * Validates the user input in the text fields.
	 * 
	 * @return true if the input is valid
	 */
	// private boolean isInputValid() {
	//     String errorMessage = "";
	//
	//     if (firstNameField.getText() == null || firstNameField.getText().length() == 0) {
	//         errorMessage += "No valid first name!\n"; 
	//     }
	//     if (lastNameField.getText() == null || lastNameField.getText().length() == 0) {
	//         errorMessage += "No valid last name!\n"; 
	//     }
	//     if (streetField.getText() == null || streetField.getText().length() == 0) {
	//         errorMessage += "No valid street!\n"; 
	//     }
	//
	//     if (postalCodeField.getText() == null || postalCodeField.getText().length() == 0) {
	//         errorMessage += "No valid postal code!\n"; 
	//     } else {
	//         // try to parse the postal code into an int.
	//         try {
	//             Integer.parseInt(postalCodeField.getText());
	//         } catch (NumberFormatException e) {
	//             errorMessage += "No valid postal code (must be an integer)!\n"; 
	//         }
	//     }
	//
	//     if (cityField.getText() == null || cityField.getText().length() == 0) {
	//         errorMessage += "No valid city!\n"; 
	//     }
	//
	//     if (birthdayField.getText() == null || birthdayField.getText().length() == 0) {
	//         errorMessage += "No valid birthday!\n";
	//     } else {
	//         if (!DateUtil.validDate(birthdayField.getText())) {
	//             errorMessage += "No valid birthday. Use the format dd.mm.yyyy!\n";
	//         }
	//     }
	//
	//     if (errorMessage.length() == 0) {
	//         return true;
	//     } else {
	//         // Show the error message.
	//         Alert alert = new Alert(AlertType.ERROR);
	//         alert.setTitle("Invalid Fields");
	//         alert.setHeaderText("Please correct invalid fields");
	//         alert.setContentText(errorMessage);
	//         
	//         alert.showAndWait();
	//         
	//         return false;
	//     }
	// }

	@Inject
	void setSelection(@Optional @Named(IServiceConstants.ACTIVE_SELECTION) Person selectedPerson) {
		System.out.println("readSelection: " + selectedPerson);
		this.selectedPerson = selectedPerson;
		if(null != selectedPerson){
			firstNameLabel.textProperty().bind(selectedPerson.firstNameProperty());
			lastNameLabel.textProperty().bind(selectedPerson.lastNameProperty());
			streetLabel.textProperty().bind(selectedPerson.streetProperty());
			postalCodeLabel.textProperty().bind(Bindings.convert(selectedPerson.postalCodeProperty()));
			cityLabel.textProperty().bind(selectedPerson.cityProperty());
			birthdayLabel.textProperty().bind(Bindings.convert(selectedPerson.birthdayProperty()));
		}
	}
}
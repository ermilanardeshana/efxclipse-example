package com.mil.debra.app.parts.PersonDetailedInfoPart;

import java.io.IOException;

import javax.inject.Inject;

import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.workbench.modeling.EModelService;

import com.mil.debra.app.Observer.IPersonListener;
import com.mil.debra.app.Observer.PersonListObserver;

import ch.makery.address.model.Person;
import ch.makery.address.model.PersonListModel;
import ch.makery.address.util.DateUtil;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PersonDetailedInfoPartController  implements IPersonListener{
	@FXML
	private TableView<Person> personTable;

	@Inject
	EModelService modelService;
	@Inject
	MApplication application;
	
	private static Person selectedPerson;
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
		PersonListObserver.observer.register(this);
	}

	/**
	 * Called when the user clicks on the delete button.
	 */
	@FXML
	private void handleDeletePerson() {
		if (null != selectedPerson) {
			if( 0 ==  PersonListModel.getInstance().getPersonList().size()){
				selectedPerson = null;
			}
			PersonListModel.getInstance().removePerson(selectedPerson);
			
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
	 * @throws IOException 
	 */
	@FXML
	private boolean handleNewPerson() throws IOException {
		        Person tempPerson = new Person();
				 FXMLLoader loader = new FXMLLoader();
		         loader.setLocation(PersonDetailedInfoPartController.class.getResource("PersonEditDialog.fxml"));
		         AnchorPane page = (AnchorPane) loader.load();

		         // Create the dialog Stage.
		         Stage dialogStage = new Stage();
		         dialogStage.setTitle("Edit Person");
		         dialogStage.initModality(Modality.APPLICATION_MODAL);
		         Scene scene = new Scene(page);
		         dialogStage.setScene(scene);

		         // Set the person into the controller.
		         PersonEditDialogueController controller = loader.getController();
		         controller.setDialogStage(dialogStage);
		         controller.setPerson(tempPerson);
		         
		         // Set the dialog icon.
		         dialogStage.getIcons().add(new Image("file:resources/images/edit.png"));

		         // Show the dialog and wait until the user closes it
		         dialogStage.showAndWait();
		         
		         return controller.isOkClicked();
	}

	/**
	 * Called when the user clicks the edit button. Opens a dialog to edit
	 * details for the selected person.
	 * @throws IOException 
	 */
	@FXML
	private boolean handleEditPerson() throws IOException {
		 if(null ==selectedPerson){
			// Nothing selected.
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("No Selection");
				alert.setHeaderText("No Person Selected");
				alert.setContentText("Please select a person in the table.");
				alert.showAndWait();
				return false;
		 }
		 FXMLLoader loader = new FXMLLoader();
         loader.setLocation(PersonDetailedInfoPartController.class.getResource("PersonEditDialog.fxml"));
         AnchorPane page = (AnchorPane) loader.load();

         // Create the dialog Stage.
         Stage dialogStage = new Stage();
         dialogStage.setTitle("Edit Person");
         dialogStage.initModality(Modality.APPLICATION_MODAL);
         Scene scene = new Scene(page);
         dialogStage.setScene(scene);

         // Set the person into the controller.
         PersonEditDialogueController controller = loader.getController();
         controller.setDialogStage(dialogStage);
         controller.setPerson(selectedPerson);
         
         // Set the dialog icon.
         dialogStage.getIcons().add(new Image("file:resources/images/edit.png"));

         // Show the dialog and wait until the user closes it
         dialogStage.showAndWait();
         
         return controller.isOkClicked();
	}

	@Override
	public void selectionChanged(Person person) {
		this.selectedPerson = person;
		if (selectedPerson != null) {
			// Fill the labels with info from the person object.
			firstNameLabel.setText(selectedPerson.getFirstName());
			lastNameLabel.setText(selectedPerson.getLastName());
			streetLabel.setText(selectedPerson.getStreet());
			postalCodeLabel.setText(Integer.toString(selectedPerson.getPostalCode()));
			cityLabel.setText(selectedPerson.getCity());
			birthdayLabel.setText(DateUtil.format(selectedPerson.getBirthday()));
		} else {
			// Person is null, remove all the text.
			firstNameLabel.setText("");
			lastNameLabel.setText("");
			streetLabel.setText("");
			postalCodeLabel.setText("");
			cityLabel.setText("");
			birthdayLabel.setText("");
		}
	}
}
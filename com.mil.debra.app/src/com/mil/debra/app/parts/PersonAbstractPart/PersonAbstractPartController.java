package com.mil.debra.app.parts.PersonAbstractPart;

import com.mil.debra.app.Observer.IPersonListener;
import com.mil.debra.app.Observer.PersonListObserver;

import ch.makery.address.model.Person;
import ch.makery.address.model.PersonListModel;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class PersonAbstractPartController implements IPersonListener{
	@FXML
	private TableView<Person> personTable;

	@FXML
	private TableColumn<Person, String> firstNameColumn;
	@FXML
	private TableColumn<Person, String> lastNameColumn;

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
		ObservableList<Person> personList = PersonListModel.getInstance().getPersonList();

		
		firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
		lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
		personTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Person>() {

			@Override
			public void changed(ObservableValue<? extends Person> observable, Person oldValue, Person newValue) {
				PersonListObserver.observer.select(newValue);
				personTable.getSelectionModel().select(newValue);
				System.out.println("set: " + newValue.getFirstName()); 
			}
		});
		
		
//		personList.addListener(new ListChangeListener<Person>() {
//
//			@Override
//			public void onChanged(javafx.collections.ListChangeListener.Change<? extends Person> c) {
//					TableViewSelectionModel<Person> selectionModel = personTable.getSelectionModel();
//					selectionModel.select(0);
//					//selectionModel.focus(0);
//				Person selectedItem = selectionModel.getSelectedItem();
//					selectionService.setSelection(selectedItem);
//				
//			}
//		});
		personTable.setItems(personList);
//		personList.addListener(new ListChangeListener<Person>(){
//			 
//
//			@Override
//			public void onChanged(Change<? extends Person> c) {
////				System.out.println(c.getFrom());
////				if(personTable.getItems().size()>c.getFrom()){
////					personTable.getSelectionModel().select(c.getFrom());
////				}else{
////					personTable.getSelectionModel().select(c.getFrom()-1);
////				}
//////				personTable.getSelectionModel().select();
////				System.out.println("removed person");
////			}
//				
//			}
//		});
		
//		personTable.itemsProperty().bind(Bindings.createObjectBinding(()->FXCollections.observableArrayList(PersonListModel.getInstance().getPersonList())));
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

	@Override
	public void selectionChanged(Person person) {
		personTable.getSelectionModel().select(person);
		System.out.println("set: " + person.getFirstName()); 
		
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
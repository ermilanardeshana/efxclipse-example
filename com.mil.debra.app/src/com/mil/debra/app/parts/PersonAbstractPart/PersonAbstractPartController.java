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
		PersonListObserver.observer.register(this);
		ObservableList<Person> personList = PersonListModel.getInstance().getPersonList();
		firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
		lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
		personTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Person>() {

			@Override
			public void changed(ObservableValue<? extends Person> observable, Person oldValue, Person newValue) {
				if(null != newValue){
					PersonListObserver.observer.select(newValue);
					personTable.getSelectionModel().select(newValue);
					//add test case
					System.out.println("set: " + newValue.getFirstName());
				}else{
					PersonListObserver.observer.select(null);
				}
			}
		});
		personTable.setItems(personList);
	}
	public void setItems(ObservableList<Person> value){
		personTable.setItems(value);
	}

	@Override
	public void selectionChanged(Person person) {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public void selectionChanged(Person person) {
//		personTable.getSelectionModel().select(person);
//		System.out.println("set: " + person.getFirstName()); 
//
//	}


}
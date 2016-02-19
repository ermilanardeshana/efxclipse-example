
package com.mil.debra.app.parts.PersonAbstractPart;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.ui.workbench.modeling.ESelectionService;

import ch.makery.address.model.Person;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class PersonAbstractPart {
	@Inject
	public PersonAbstractPart() {

	}
    @FXML
    private TableColumn<Person, String> firstNameColumn;
    @FXML
    private TableColumn<Person, String> lastNameColumn;
	@FXML
    private TableView<Person> personTable;
	@Inject
	private ESelectionService selectionService;
	@SuppressWarnings("unchecked")
	@PostConstruct
	public void postConstruct(BorderPane parent) {
		Parent root;
		try {
			root = FXMLLoader.load(PersonAbstractPart.class.getResource("PersonAbstractPart.fxml"));
			AnchorPane box=(AnchorPane)root;
			parent.setTop(box);
			Node splitpane = box.getChildren().get(0);
			SplitPane spnode = (SplitPane)splitpane;
			Node anchornode = spnode.getItems().get(0);
			AnchorPane anchorPane = (AnchorPane)anchornode;
			personTable=(TableView<Person>)anchorPane.getChildren().get(0);
			firstNameColumn= (TableColumn<Person, String>)personTable.getColumns().get(0);
			lastNameColumn= (TableColumn<Person, String>)personTable.getColumns().get(1);
			firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
		    lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
		        
			System.out.println("***"+personTable);
			personTable.setItems(createList());
			personTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Person>() {

				@Override
				public void changed(ObservableValue<? extends Person> observable, Person oldValue, Person newValue) {
					selectionService.setSelection(newValue);
					System.out.println("set: " + newValue); 
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}



	}

	private static ObservableList<Person> createList() {
		ObservableList<Person> personData = FXCollections.observableArrayList();
		personData.add(new Person("Hans", "Muster"));
        personData.add(new Person("Ruth", "Mueller"));
        personData.add(new Person("Heinz", "Kurz"));
        personData.add(new Person("Cornelia", "Meier"));
        personData.add(new Person("Werner", "Meyer"));
        personData.add(new Person("Lydia", "Kunz"));
        personData.add(new Person("Anna", "Best"));
        personData.add(new Person("Stefan", "Meier"));
        personData.add(new Person("Martin", "Mueller"));
		return personData;
	}

}
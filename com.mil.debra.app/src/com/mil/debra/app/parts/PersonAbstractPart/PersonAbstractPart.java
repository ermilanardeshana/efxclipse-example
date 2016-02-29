
package com.mil.debra.app.parts.PersonAbstractPart;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.fx.ui.di.FXMLLoader;
import org.eclipse.fx.ui.di.FXMLLoaderFactory;

import ch.makery.address.model.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 * 
 * @author Milan
 *
 */
public class PersonAbstractPart {
	@Inject
	IEclipseContext eclipseContext;
	@Inject
	public PersonAbstractPart() {

	}

	@FXML
    private TableView<Person> personTable;
//	@Inject
//	private ESelectionService selectionService;
	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init(BorderPane parent,  @FXMLLoader FXMLLoaderFactory factory) {
		Parent root;
		try {
			root = (Parent) factory.loadRequestorRelative("PersonAbstractPart.fxml").load();
			AnchorPane box=(AnchorPane)root;
			parent.setTop(box);
//			Node splitpane = box.getChildren().get(0);
//			SplitPane spnode = (SplitPane)splitpane;
//			Node anchornode = spnode.getItems().get(0);
//			AnchorPane anchorPane = (AnchorPane)anchornode;
//			personTable=(TableView<Person>)anchorPane.getChildren().get(0);
//			firstNameColumn= (TableColumn<Person, String>)personTable.getColumns().get(0);
//			lastNameColumn= (TableColumn<Person, String>)personTable.getColumns().get(1);
			
		        
//			personTable.setItems(createList());
//			personTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Person>() {
//
//				@Override
//				public void changed(ObservableValue<? extends Person> observable, Person oldValue, Person newValue) {
//					selectionService.setSelection(newValue);
//					System.out.println("set: " + newValue); 
//				}
//			});
		} catch (IOException e) {
			e.printStackTrace();
		}



	}



}
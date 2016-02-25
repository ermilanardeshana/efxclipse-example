 
package com.mil.debra.app.parts.PersonEditDialogue;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.services.IServiceConstants;

import com.mil.debra.app.parts.PersonAbstractPart.PersonAbstractPart;

import ch.makery.address.model.Person;
import ch.makery.address.util.DateUtil;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class PersonEditDialogue {
	@Inject
	public PersonEditDialogue() {
		
	}
	TextField firstNameField;
    TextField lastNameField;
    TextField streetField;
    TextField cityField;
    TextField postalCodeField;
    TextField birthdayField;
	@PostConstruct
	public void postConstruct(BorderPane parent) {
		Parent root;
		try {
			root = FXMLLoader.load(PersonEditDialogue.class.getResource("PersonEditDialog.fxml"));
			AnchorPane box=(AnchorPane)root;
			parent.setTop(box);
			Node splitpane = box.getChildren().get(0);
			GridPane gridPanenode = (GridPane)splitpane;
			Node firstNameFieldNode = gridPanenode.getChildren().get(6);
			firstNameField = (TextField) firstNameFieldNode;
			Node lastNameFieldNode = gridPanenode.getChildren().get(7);
			lastNameField = (TextField) lastNameFieldNode;
			Node streetFieldNode = gridPanenode.getChildren().get(8);
			streetField = (TextField) streetFieldNode;
			Node cityFieldNode = gridPanenode.getChildren().get(9);
			cityField = (TextField) cityFieldNode;
			Node postalCodeFieldNode = gridPanenode.getChildren().get(10);
			postalCodeField = (TextField) postalCodeFieldNode;
			Node birthdayFieldNode = gridPanenode.getChildren().get(11);
			birthdayField = (TextField) birthdayFieldNode;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	@Inject
	void setSelection(@Optional @Named(IServiceConstants.ACTIVE_SELECTION) Person selectedPerson) {
	System.out.println("readSelection: " + selectedPerson);
	if (selectedPerson != null && null != firstNameField ) {
		firstNameField.setText(selectedPerson.getFirstName());
		lastNameField.setText(selectedPerson.getLastName());
		streetField.setText(selectedPerson.getStreet());
		cityField.setText(Integer.toString(selectedPerson.getPostalCode()));
		postalCodeField.setText(selectedPerson.getCity());
		birthdayField.setText(DateUtil.format(selectedPerson.getBirthday()));
	} 
	}
	
}
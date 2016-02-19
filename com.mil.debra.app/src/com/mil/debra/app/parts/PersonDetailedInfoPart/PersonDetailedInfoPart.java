 
package com.mil.debra.app.parts.PersonDetailedInfoPart;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.services.IServiceConstants;

import ch.makery.address.model.Person;
import ch.makery.address.util.DateUtil;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class PersonDetailedInfoPart {
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

	
	@Inject
	public PersonDetailedInfoPart() {
		
	}
	
	@PostConstruct
	public void postConstruct(BorderPane parent) {
		Parent root;
		try {
			root = FXMLLoader.load(PersonDetailedInfoPart.class.getResource("PersonDetailedInfoPart.fxml"));
			AnchorPane box=(AnchorPane)root;
			parent.setTop(box);
			Node splitPaneNode = box.getChildren().get(0);
			SplitPane splitPane = (SplitPane)splitPaneNode;
			Node anchorPane2node = splitPane.getItems().get(0);
			AnchorPane anchorPane2 = (AnchorPane) anchorPane2node;
			Node greedpanenode = anchorPane2.getChildren().get(1);
			GridPane gridPane = (GridPane) greedpanenode;
			Node firstNamenode = gridPane.getChildren().get(6);
			firstNameLabel = (Label) firstNamenode;
			Node lastNameLabelNode = gridPane.getChildren().get(7);
			lastNameLabel = (Label) lastNameLabelNode;
			Node streetLabelNode = gridPane.getChildren().get(8);
			streetLabel = (Label) streetLabelNode;
			Node postalCodeLabelNode = gridPane.getChildren().get(9);
			postalCodeLabel = (Label) postalCodeLabelNode;
			Node cityLabelNode = gridPane.getChildren().get(10);
			cityLabel = (Label) cityLabelNode;
			Node birthdayLabelNode = gridPane.getChildren().get(11);
			birthdayLabel = (Label) birthdayLabelNode;
		} catch (IOException e) {
			e.printStackTrace();
		}
			
	}
	
	@Inject
	void setSelection(@Optional @Named(IServiceConstants.ACTIVE_SELECTION) Person selectedPerson) {
	System.out.println("readSelection: " + selectedPerson);
	if (selectedPerson != null) {
		firstNameLabel.setText(selectedPerson.getFirstName());
        lastNameLabel.setText(selectedPerson.getLastName());
        streetLabel.setText(selectedPerson.getStreet());
        postalCodeLabel.setText(Integer.toString(selectedPerson.getPostalCode()));
        cityLabel.setText(selectedPerson.getCity());
        birthdayLabel.setText(DateUtil.format(selectedPerson.getBirthday()));
	} 
	}
	
}
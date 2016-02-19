 
package com.mil.debra.app.handlers;

import org.eclipse.e4.core.di.annotations.Execute;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class aboutHandler {
	@Execute
	public void execute() {
		  FXMLLoader loader = new FXMLLoader();
//		Stage stage = new Stage();
//		stage.show();
//		stage.showAndWait();
	  	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("AddressApp");
    	alert.setHeaderText("About");
    	alert.setContentText("Author: Marco Jakob\nWebsite: http://code.makery.ch");
    	alert.showAndWait();
	}
		
}
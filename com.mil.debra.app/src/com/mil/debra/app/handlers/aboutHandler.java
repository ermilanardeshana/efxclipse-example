
package com.mil.debra.app.handlers;

import org.eclipse.e4.core.di.annotations.Execute;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
/**
 * @author Milan
 *
 */
public class aboutHandler {
	@Execute
	public void execute() {
	  	Alert alert = new Alert(AlertType.INFORMATION);
    	alert.setTitle("AddressApp");
    	alert.setContentText("Author: Milan Ardeshana\nWebsite: https://milanardeshana.wordpress.com/");
    	alert.setHeaderText("About");
    	alert.showAndWait();
	}

}
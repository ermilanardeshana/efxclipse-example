
package com.mil.debra.app.parts.PersonDetailedInfoPart;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.fx.ui.di.FXMLLoader;
import org.eclipse.fx.ui.di.FXMLLoaderFactory;

import ch.makery.address.model.Person;
import ch.makery.address.util.DateUtil;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * @author Milan
 *
 */
public class PersonDetailedInfoPart {


	@Inject
	public PersonDetailedInfoPart() {

	}

	@PostConstruct
	public void postConstruct(BorderPane parent, @FXMLLoader FXMLLoaderFactory factory) {
		Parent root;
		try {
			root = (Parent) factory.loadRequestorRelative("PersonDetailedInfoPart.fxml").load();
			
			AnchorPane box=(AnchorPane)root;
			parent.setTop(box);
//			Node splitPaneNode = box.getChildren().get(0);
//			SplitPane splitPane = (SplitPane)splitPaneNode;
//			Node anchorPane2node = splitPane.getItems().get(0);
//			AnchorPane anchorPane2 = (AnchorPane) anchorPane2node;
//			Node greedpanenode = anchorPane2.getChildren().get(1);
//			GridPane gridPane = (GridPane) greedpanenode;
//			Node firstNamenode = gridPane.getChildren().get(6);
//			firstNameLabel = (Label) firstNamenode;
//			Node lastNameLabelNode = gridPane.getChildren().get(7);
//			lastNameLabel = (Label) lastNameLabelNode;
//			Node streetLabelNode = gridPane.getChildren().get(8);
//			streetLabel = (Label) streetLabelNode;
//			Node postalCodeLabelNode = gridPane.getChildren().get(9);
//			postalCodeLabel = (Label) postalCodeLabelNode;
//			Node cityLabelNode = gridPane.getChildren().get(10);
//			cityLabel = (Label) cityLabelNode;
//			Node birthdayLabelNode = gridPane.getChildren().get(11);
//			birthdayLabel = (Label) birthdayLabelNode;
//
//			Node buttonBarNode = anchorPane2.getChildren().get(2);
//			ButtonBar buttonBar = (ButtonBar)  buttonBarNode;
//			newButton = (Button) buttonBar.getButtons().get(0);
//			editButton = (Button) buttonBar.getButtons().get(1);
//			deleteButton = (Button) buttonBar.getButtons().get(2);

//			editButton.setOnAction(new EventHandler<ActionEvent>() {
//
//				
//				private boolean okClicked = false;
//				
//				 /**
//			     * Returns true if the user clicked OK, false otherwise.
//			     * 
//			     * @return
//			     */
//			    public boolean isOkClicked() {
//			        return okClicked;
//			    }
//			    
//				@Override
//				public void handle(ActionEvent event) {
//					Parent root;
//					try {
//						
////						Not having enough knowledge of service usage moving to conventional javafx dialogue creaton
////						LightWeightDialogueService dialog = new LightWeightDialogueService();
////						dialog.showDialog(container, containerNode, dialogOverlayContainer, grayArea, dialog, finished);
////						dialog.showDialog(application, staticLayoutNode, this.overlayContainer, this.overlayContainer, (Node)dialogNode, null);
//						
//						root = FXMLLoader.load(PersonDetailedInfoPart.class.getResource("PersonEditDialog.fxml"));
//						AnchorPane anchorPane=(AnchorPane)root;
//						Stage dialogStage = new Stage();
//						dialogStage.setTitle("Edit Person");
//						dialogStage.initModality(Modality.APPLICATION_MODAL);
//						//				            dialogStage.initOwner(primaryStage);
//						Scene scene = new Scene(anchorPane);
//						dialogStage.setScene(scene);
//
//						Node gridPane = anchorPane.getChildren().get(0);
//						GridPane gridPanenode = (GridPane)gridPane;
//						Node firstNameFieldNode = gridPanenode.getChildren().get(6);
//						firstNameField = (TextField) firstNameFieldNode;
//						Node lastNameFieldNode = gridPanenode.getChildren().get(7);
//						lastNameField = (TextField) lastNameFieldNode;
//						Node streetFieldNode = gridPanenode.getChildren().get(9);
//						streetField = (TextField) streetFieldNode;
//						Node cityFieldNode = gridPanenode.getChildren().get(10);
//						cityField = (TextField) cityFieldNode;
//						Node postalCodeFieldNode = gridPanenode.getChildren().get(11);
//						postalCodeField = (TextField) postalCodeFieldNode;
//						Node birthdayFieldNode = gridPanenode.getChildren().get(12);
//						birthdayField = (TextField) birthdayFieldNode;
//						Node buttonBar = anchorPane.getChildren().get(1);
//						ButtonBar buttonBarNode = (ButtonBar) buttonBar;
//						okButton = (Button) buttonBarNode.getButtons().get(0);
//						cancelButton = (Button) buttonBarNode.getButtons().get(1);
//
//						okButton.setOnAction(new EventHandler<ActionEvent>() {
//							
//							@Override
//							public void handle(ActionEvent event) {
//
//
//						        if (isInputValid()) {
//						        	selectedPerson.setFirstName(firstNameField.getText());
//						        	selectedPerson.setLastName(lastNameField.getText());
//						        	selectedPerson.setStreet(streetField.getText());
//						        	selectedPerson.setPostalCode(Integer.parseInt(postalCodeField.getText()));
//						        	selectedPerson.setCity(cityField.getText());
//						        	selectedPerson.setBirthday(DateUtil.parse(birthdayField.getText()));
//
//						            okClicked = true;
//						            dialogStage.close();
//						        }
//						    
//							}
//						});
//						System.out.println("readSelection: " + selectedPerson);
//						if (selectedPerson != null && null != firstNameField ) {
//							firstNameField.setText(selectedPerson.getFirstName());
//							lastNameField.setText(selectedPerson.getLastName());
//							streetField.setText(selectedPerson.getStreet());
//							postalCodeField.setText(Integer.toString(selectedPerson.getPostalCode()));
//							cityField.setText(selectedPerson.getCity());
//							birthdayField.setText(DateUtil.format(selectedPerson.getBirthday()));
//							// Set the dialog icon.
//							dialogStage.getIcons().add(new Image("resources/images/edit.png"));
//							// Show the dialog and wait until the user closes it
//							dialogStage.showAndWait();
//						}else if(null != firstNameField){
//							Alert alert = new Alert(AlertType.WARNING);
////							alert.initOwner(mainApp.getPrimaryStage());
//							alert.setTitle("No Selection");
//							alert.setHeaderText("No Person Selected");
//							alert.setContentText("Please select a person in the table.");
//							alert.showAndWait();
//						} 
//
//						// Set the person into the controller.
//						//				            PersonEditDialogController controller = loader.getController();
//						//				            controller.setDialogStage(dialogStage);
//						//				            controller.setPerson(person);
//						
//			
//
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//
//					//			            
//
//
//
//
//					/*JAVFx thread not able to access the application ui model this way	
//					System.out.println( application.getDialogs());
//   				    MDialog mydialogue = application.getDialogs().get(0); */
//					//					Platform.runLater(new Runnable() {
//					//						
//					//						@Override
//					//						public void run() {
//					//							MUIElement find = modelService.find("com.mil.debra.app.dialog.editdialogue", application);
//					//							System.out.println(find);
//					//							MDialog mydialogue = (MDialog) modelService.cloneElement(find, application);
//					//							mydialogue.setVisible(true);
//					//							mydialogue.setOnTop(true);
//					//							mydialogue.setToBeRendered(true);
//					////							modelService.bringToTop(mydialogue);
//					//						}
//					//					});
//					//
//					//					MUIElement otw = ms.find("com.lookup2.streams.trimmedwindow.0", application);
//					//					MWindow ntw = (MWindow) ms.cloneElement(otw, application);
//					//					ntw.setToBeRendered(true);
//					//					ntw.setVisible(true);
//					//					ntw.setOnTop(true);
//					//					application.getChildren().add(ntw);
//					//					ms.bringToTop(ntw);
//				}
//			});
		} catch (IOException e) {
			e.printStackTrace();
		}

	}



}
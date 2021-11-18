package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class PediatricOfficeSystemPatientController {

	// Event Listener on Button.onAction
	@FXML
	public void editContactInfo(ActionEvent event) {
		// TODO Autogenerated
		try {
			Parent editContact = FXMLLoader.load(getClass().getResource("Edit Patient Information.fxml"));
			Stage stage = new Stage();
			stage.setTitle("Edit Contact Information");
			stage.setScene(new Scene(editContact));
			stage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("ERROR: Can not load Window");
		}
	}
	// Event Listener on Button.onAction
	@FXML
	public void sendMessageDoctor(ActionEvent event) {
		try {
			Parent doctorMssg = FXMLLoader.load(getClass().getResource("Message Center.fxml"));
			Stage stage = new Stage();
			stage.setTitle("Messages | Doctor");
			stage.setScene(new Scene(doctorMssg));
			stage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("ERROR: Can not load Window");
		}
	}
	// Event Listener on Button.onAction
	@FXML
	public void sendMessageNurse(ActionEvent event) {
		// TODO Autogenerated
		try {
			Parent nurseMssg = FXMLLoader.load(getClass().getResource("Message Center.fxml"));
			Stage stage = new Stage();
			stage.setTitle("Messages | Nurse");
			stage.setScene(new Scene(nurseMssg));
			stage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("ERROR: Can not load Window");
		}
	}
}

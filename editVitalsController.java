package application;

import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;

public class editVitalsController {
	@FXML
	private TextField heightTxtBox;
	@FXML
	private TextField WeightTxtBox;
	@FXML
	private TextField tempTxtBox;
	@FXML
	private TextField bpTxtBox;
	@FXML
	private Button okbutton;
	@FXML
	private Button cancelbutton;
	@FXML
	private TextArea reasonTxtBox;
	@FXML
	private TextField dateBox;
	
	private Patient patient;
	private Visit visit;

	// Event Listener on Button[#okbutton].onAction
	@FXML
	public Visit submitVitals(ActionEvent event) {
		//Creating new vitals and passing in data for the object
		Vitals temp = new Vitals(WeightTxtBox.getText(), heightTxtBox.getText(), tempTxtBox.getText(),bpTxtBox.getText());
		//Creating a visit, and will add the date, vitals, and reason for the visit.
		Visit visit = new Visit(dateBox.getText(), temp, reasonTxtBox.getText());
		
		//Then, we will push the visit onto the ArrayList for the corresponding patient
		return visit;
		
	}
	// Event Listener on Button[#cancelbutton].onAction
	@FXML
	public void cancelVitals(ActionEvent event) {
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.close();
	}
	
	public Visit getVisit(){
		return visit;
	}
    
    public void setPatient(Patient p) {
    	this.patient = p;
    }
	
}

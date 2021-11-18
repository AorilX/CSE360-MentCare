package application;

import javafx.fxml.FXML;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class EditInsuranceController {
	@FXML
	private TextArea editIns;
	
	private Patient patient;

	// Event Listener on Button.onAction
    @FXML
    void exitStage(ActionEvent event) {
    	Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	stage.close();    	
    }

    @FXML
    void saveChanges(ActionEvent event) {
    	Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	if(!editIns.getText().isEmpty())
    		patient.setInsurance(editIns.getText());
    	stage.close();
    }
    
    
    public void setEditIns(String i) {
    	editIns.setText(i);
    }
    
    public void setPatient(Patient p) {
    	patient = p;
    }
}


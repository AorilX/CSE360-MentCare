package application;
import javafx.scene.Node;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class EditVisitSummaryController {
	@FXML
	private TextField txtBox;
	@FXML
	private Button okbutton;
	@FXML
	private Button cancelbutton;
	
	private Patient patient;

	// Event Listener on Button[#okbutton].onAction
	@FXML
	public void Submit(ActionEvent event) {
		
		//set the visit summary field corresponding to a patient and a visit
    	Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	if(!txtBox.getText().isEmpty())
    		patient.setVisitSummary(txtBox.getText());
    	stage.close();
  
		
		
	}
	// Event Listener on Button[#cancelbutton].onAction
	@FXML
	public void closeWindow(ActionEvent event) {
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		stage.close();
	}
	
	public void setVisitSum(String pi) {
    	txtBox.setText(pi);
    }
    
    public void setPatient(Patient p) {
    	patient = p;
    }
	
}


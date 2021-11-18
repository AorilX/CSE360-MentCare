package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class EditPhysicalController {

    @FXML
    private TextArea editPhy;
    
    private Visit visit;

    @FXML
    void exitStage(ActionEvent event) {
    	Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	stage.close();    	
    }

    @FXML
    void saveChanges(ActionEvent event) {
    	Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    	if(!editPhy.getText().isEmpty())
    		visit.setPhysTestInfo(editPhy.getText());
    	stage.close();
    }
    
    
    public void setEditPhy(String pi) {
    	editPhy.setText(pi);
    }
    
    public void setVisit(Visit v) {
    	visit = v;
    }

}


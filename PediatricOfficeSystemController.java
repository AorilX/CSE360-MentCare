package application;



import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.util.*;




public class PediatricOfficeSystemController {
	private List<Patient> patients;

    @FXML
    private TextArea insurance;

    @FXML
    private TextArea medication;

    @FXML
    private TextArea patientInfo;

    @FXML
    private TextArea physicalInfo;

    @FXML
    private TextArea visitSummary;
    
    @FXML
    private ListView<String> viewPatList;

    @FXML
    private ListView<Visit> viewVisit;
    
    private int patientIdx;
    private int visitIdx;
	
	public void loadPatients(List<Patient> p) {
    	patients = p;
    	for(int i = 0; i < patients.size(); i++) {
    		String name = String.format("%s %s %s", patients.get(i).getFirstname(), patients.get(i).getLastname(), patients.get(i).getBirthdate());
    		viewPatList.getItems().add(name);
    	}
    	System.out.println("TEST");
    	
    	viewPatList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

		@Override
		public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
			patientIdx = viewPatList.getSelectionModel().getSelectedIndex();
			displayMedication(patients.get(patientIdx));
			displayInsurance(patients.get(patientIdx));
			displayPatientInfo(patients.get(patientIdx));
			
		}
    		
    	});
    }
   /* 
    public void displayVisitHistory(Patient pat) {
    	List<Visit> visitHist = pat.getVisitList();
    	viewVisit.getItems().clear();
    	for(int i = 0; i < visitHist.size(); i++) {
    		String date = visitHist.get(i).getDate();
    		viewVisit.getItems().add(date);
    	}
    	
    	viewVisit.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				// TODO Auto-generated method stub
				patientIdx = viewPatList.getSelectionModel().getSelectedIndex();
				visitIdx = viewVisit.getSelectionModel().getSelectedIndex();
				displayPhysicalInfo(patients.get(patientIdx).getVisitList().get(visitIdx));
				displayVisitSummary(patients.get(patientIdx).getVisitList().get(visitIdx));
			}
    		
    	});
    	
    	
    	
    }
    */
    
    
    public void displayPatientInfo(Patient pat) {
    	String name = "Name:\t\t" + pat.getFirstname() + " " + pat.getLastname();
    	String dob = "DOB:\t\t" + pat.getBirthdate();
    	String add = "Address:\t\t" + pat.getAddress();
    	String num = "Phone Number:\t\t" + pat.getPhoneNumber();
    	String email = "Email:\t\t" + pat.getEmail();
    	
    	patientInfo.setText(String.format("%s\n%s\n%s\n%s\n%s", name, dob, add, num, email));
    }
    
    public void displayPhysicalInfo(Visit vis) {
    	String physical = vis.getPhysTestInfo();
    	
    	physicalInfo.setText(physical);
    }
    
    public void displayMedication(Patient pat) {
    	medication.setText(pat.getMedication());
    }
    
    public void displayInsurance(Patient pat) {
    	String ins = pat.getInsurance();
    	
    	insurance.setText(ins);
    }
    
    public void displayVisitSummary(Visit vis) {
    	String visitSum = vis.getVisitSummary();
    	
    	visitSummary.setText(visitSum);
    }
    
	
	@FXML
	public void addPatient (ActionEvent event){
		try {
			FXMLLoader patientLoader = FXMLLoader.load(getClass().getResource("Paitient Sign up.fxml"));
			Parent addingpatient = patientLoader.load();
			editVitalsController vitalsController = patientLoader.getController();
			Stage stage = new Stage();
			
			
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("ERROR: Can not load Window");
		}
	}
	
	@FXML
	public void addVisit (ActionEvent event){
		try {
			FXMLLoader visitLoader = FXMLLoader.load(getClass().getResource("edit vitals.fxml"));
			Parent addingvisit = visitLoader.load();
			editVitalsController vitalsController = visitLoader.getController();
			Stage stage = new Stage();

			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setTitle("Add Patient");
			stage.setScene(new Scene(addingvisit));
			
			//setting up controller
			patientIdx = viewPatList.getSelectionModel().getSelectedIndex();
			
			System.out.println(patientIdx);
			if(patientIdx != -1) {
				vitalsController.setPatient(patients.get(patientIdx)); 
				Visit temp = vitalsController.getVisit();
				patients.get(patientIdx).addVisit(temp);
			}
			else System.out.println("ERROR: Must Select A Patient!");
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("ERROR: Can not load Window");
		}
	}
	
	@FXML
	public void deletePatient (ActionEvent event){
		patientIdx = viewPatList.getSelectionModel().getSelectedIndex();
		viewPatList.getItems().remove(patientIdx);
	}
	
	@FXML
	public void deleteVisit (ActionEvent event){
		visitIdx = viewVisit.getSelectionModel().getSelectedIndex();
		viewVisit.getItems().remove(visitIdx);
	}
		
	// Event Listener on Button.onAction
	@FXML
	public void editPatientInfo(ActionEvent event) {
		try {
			Parent editPatient = FXMLLoader.load(getClass().getResource("Edit Patient Information.fxml"));
			Stage stage = new Stage();
			stage.setTitle("Edit Patient Information");
			stage.setScene(new Scene(editPatient));
			stage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("ERROR: Can not load Window");
		}
	}
	
	// Event Listener on Button.onAction
	
	@FXML
	public void editVisit(ActionEvent event) {
		try {
			FXMLLoader sumLoader = FXMLLoader.load(getClass().getResource("Edit Visit Summary.fxml"));
			Parent editVisitSum = sumLoader.load();
			EditVisitSummaryController editSumController = sumLoader.getController();
			Stage stage = new Stage();
			
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setTitle("Edit Visit Summary");
			stage.setScene(new Scene(editVisitSum));
			
			//setting up controller
			patientIdx = viewPatList.getSelectionModel().getSelectedIndex();
			visitIdx = viewVisit.getSelectionModel().getSelectedIndex();
			
			System.out.println(patientIdx);
			if(patientIdx != -1) {
				editSumController.setPatient(patients.get(patientIdx)); 
				editSumController.setVisitSum(patients.get(patientIdx).getVisitList().get(visitIdx).getVisitSummary());
				stage.showAndWait();
				displayVisitSummary(patients.get(patientIdx).getVisitList().get(visitIdx));
			}
			else System.out.println("ERROR: Must Select A Patient!");	
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("ERROR: Can not load Window");
		}
	}
	
	// Event Listener on Button.onAction
	@FXML
	public void editInsurance(ActionEvent event) {
		try {
			FXMLLoader insrLoader = new FXMLLoader(getClass().getResource("Edit Insurance.fxml"));
			Parent editInsurance = insrLoader.load();
			EditInsuranceController insuranceController = insrLoader.getController();
			Stage stage = new Stage();
			
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setTitle("Edit Insurance Information");
			stage.setScene(new Scene(editInsurance));
			
			patientIdx = viewPatList.getSelectionModel().getSelectedIndex();
			if(patientIdx != -1) {
				insuranceController.setPatient(patients.get(patientIdx));
				insuranceController.setEditIns(patients.get(patientIdx).getInsurance());
			
				stage.showAndWait();
				displayInsurance(patients.get(patientIdx));
			}
			else System.out.println("ERROR: Must Select A Patient!");
			
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("ERROR: Can not load Window");
		}
	}
	
	@FXML
	public void handleMessages(ActionEvent event) {
		try {
			Parent mssg = FXMLLoader.load(getClass().getResource("Message Center.fxml"));
			Stage stage = new Stage();
			stage.setTitle("Messages | Patient");
			stage.setScene(new Scene(mssg));
			stage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("ERROR: Can not load Window");
		}
	}
}

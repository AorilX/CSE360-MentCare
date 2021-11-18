package application;

import java.io.IOException;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PediatricOfficeSystemDoctorController {
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
    private ListView<String> viewVisit;
    
    private int patientIdx;
    private int visitIdx;
    
    public void loadPatients(List<Patient> p) {
    	patients = p;
    	for(int i = 0; i < patients.size(); i++) {
    		String name = String.format("%s %s %s", patients.get(i).getFirstname(), patients.get(i).getLastname(), patients.get(i).getBirthdate());
    		viewPatList.getItems().add(name);
    	}
    	
    	viewPatList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				// TODO Auto-generated method stub
				patientIdx = viewPatList.getSelectionModel().getSelectedIndex();
				displayMedication(patients.get(patientIdx));
				displayInsurance(patients.get(patientIdx));
				displayPatientInfo(patients.get(patientIdx));
				displayVisitHistory(patients.get(patientIdx));
			}
    		
    	});
    }
    
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

	// Event Listener on Button.onAction
	@FXML
	public void editPhysical(ActionEvent event)	{
		try {
			//creating fxml loader, controller instance, and stage
			FXMLLoader phyLoader = new FXMLLoader(getClass().getResource("Edit Physical.fxml"));
			Parent editPhysical = phyLoader.load();
			EditPhysicalController editPhyController = phyLoader.getController();
			Stage stage = new Stage();
			
			//setting stage properties
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setTitle("Edit Physical");
			stage.setScene(new Scene(editPhysical));
			
			//setting up controller
			patientIdx = viewPatList.getSelectionModel().getSelectedIndex();
			visitIdx = viewVisit.getSelectionModel().getSelectedIndex();
			System.out.println(patientIdx);
			if(patientIdx != -1) {
				editPhyController.setVisit(patients.get(patientIdx).getVisitList().get(visitIdx)); 
				editPhyController.setEditPhy(patients.get(patientIdx).getVisitList().get(visitIdx).getPhysTestInfo());
			
				//display stage and update info on close
				stage.showAndWait();
				displayPhysicalInfo(patients.get(patientIdx).getVisitList().get(visitIdx));
			}
			else System.out.println("ERROR: Must Select A Patient!");
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("ERROR: Can not load Edit Physical");
		}
		
	}
	// Event Listener on Button.onAction
	@FXML
	public void prescribe(ActionEvent event) {
		// TODO Autogenerated
		try {
			FXMLLoader pLoader = new FXMLLoader(getClass().getResource("Prescribed Medication.fxml"));
			Parent prscrb = pLoader.load();
			PrescribedMedicationController preMedController = pLoader.getController();
			Stage stage = new Stage();
			
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setTitle("Prescribed Medication");
			stage.setScene(new Scene(prscrb));
			
			patientIdx = viewPatList.getSelectionModel().getSelectedIndex();
			if(patientIdx != -1) {
				preMedController.setPatient(patients.get(patientIdx));
				stage.showAndWait();
				patients.get(patientIdx).setMedication();
				displayMedication(patients.get(patientIdx));
			}
			else System.out.println("ERROR: Must Select A Patient!");
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("ERROR: Can not load Prescribed Medication Window");
		}
	}
	// Event Listener on Button.onAction
	@FXML
	public void editInsurance(ActionEvent event) {
		// TODO Autogenerated
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
	public void handlePatientQueue(ActionEvent event) {
		try {
			Parent patientQueue = FXMLLoader.load(getClass().getResource("Patient Queue.fxml"));
			Stage stage = new Stage();
			stage.setTitle("Patient Queue");
			stage.setScene(new Scene(patientQueue));
			stage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("ERROR: Can not load queue");
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

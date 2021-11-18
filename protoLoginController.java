package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class protoLoginController {
	
	Patient p1 = new Patient("1", "password", "Joe", "Smith", "js@gmail.com", 1234567, 0, "01/01/01");
	Patient p2 = new Patient("2", "password", "Beth", "Johnson", "bj@gmail.com", 1047565, 0, "01/01/99");
	Patient p3 = new Patient("3", "password", "Sam", "Warner", "js@gmail.com", 1234098, 0, "02/02/02");
	
	Visit p1v1 = new Visit("10/05/21", new Vitals("160", "5'10", "98", "pressure"), "Because");
	Visit p1v2 = new Visit("11/07/21", new Vitals("160", "5'10", "98", "pressure"), "Because");
	Visit p2v1 = new Visit("9/21/20", new Vitals("160", "5'10", "98", "pressure"), "Because");
	Visit p3v1 = new Visit("1/30/19", new Vitals("160", "5'10", "98", "pressure"), "Because");
	
	
	List<Patient> patients = new ArrayList<Patient>();
	List<Visit> visits1 = new ArrayList<Visit>();
	List<Visit> visits2 = new ArrayList<Visit>();
	List<Visit> visits3 = new ArrayList<Visit>();

	// Event Listener on Button.onAction
	@FXML
	public void openPatient(ActionEvent event) {
		try {
			Parent patient = FXMLLoader.load(getClass().getResource("PatientLogin.fxml"));
			Stage stage = new Stage();
			stage.setTitle("Pediatric Office - Patient Log in");
			stage.setScene(new Scene(patient));
			stage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("ERROR: Cannot Open Patient UI");
		}
	}
	// Event Listener on Button.onAction
	@FXML
	public void openDoctor(ActionEvent event) {
		visits1.add(p1v1);
		visits1.add(p1v2);
		visits2.add(p2v1);
		visits3.add(p3v1);
		
		p1.setVisitList(visits1);
		p2.setVisitList(visits2);
		p3.setVisitList(visits3);
		
		patients.add(p1);
		patients.add(p2);
		patients.add(p3);
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Pediatric Office System(Doctor).fxml"));
			Parent doctor = loader.load();
			PediatricOfficeSystemDoctorController posdc = loader.getController();
			posdc.loadPatients(patients);
			Stage stage = new Stage();
			stage.setTitle("Pediatric Office - Doctor");
			stage.setScene(new Scene(doctor));
			stage.show();
			
			/*stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
				@Override
				public void handle(WindowEvent e) {
					PatientStorage.SaveData((ArrayList<Patient>) patients);
					System.out.println("Saved...");
				}
			});*/
			
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("ERROR: Cannot Open Doctor UI");
		}
	}
	// Event Listener on Button.onAction
	@FXML
	public void openNurse(ActionEvent event) {
		try {
			Parent nurse = FXMLLoader.load(getClass().getResource("Pediatric Office System.fxml"));
			Stage stage = new Stage();
			stage.setTitle("Pediatric Office - Nurse");
			stage.setScene(new Scene(nurse));
			stage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("ERROR: Cannot Open Nurse UI");
		}
	}
}

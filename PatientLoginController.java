package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;

public class PatientLoginController implements Initializable{
	
	  @FXML private TextField firstName;
	  @FXML
	  private TextField lastName;
	  @FXML
	  private TextField DOB;
	  @FXML
	  private TextField sex;
	  @FXML
	  private TextField phone;
	  @FXML
	  private TextField mail;
	  @FXML
	  private TextField address;
	  @FXML
	  private TextField city;
	  @FXML
	  private TextField state;
	  @FXML
	  private TextField zip;
	// Event Listener on Button.onAction
		@FXML
		public void patientSignup(ActionEvent event) {
			try {
				Parent signUp = FXMLLoader.load(getClass().getResource("Paitient Sign up.fxml"));
				Stage stage = new Stage();
				stage.setTitle("Patient Sign up");
				stage.setScene(new Scene(signUp));
				stage.show();
			}
			catch(Exception e) {
				e.printStackTrace();
				System.out.println("ERROR: Cannot Sign Up");
			}
		}
		
		// Event Listener on Button.onAction
				@FXML
				public void patientLogin(ActionEvent event) {
					try {
						Parent login = FXMLLoader.load(getClass().getResource("Patient Log in Window.fxml"));
						Stage stage = new Stage();
						stage.setTitle("Patient Sign up");
						stage.setScene(new Scene(login));
						stage.show();
					}
					catch(Exception e) {
						e.printStackTrace();
						System.out.println("ERROR: Cannot Log in");
					}
				}
				// Event Listener on Button.onAction
				@FXML
				public void createAccount(ActionEvent event) {
					try {
						String s = "";
						System.out.println(s);
						System.out.println(lastName.getText());
						System.out.println(sex.getText());
						
						s= firstName.getText() + lastName.getText() + DOB.getText();
						(new File("PatientInfo")).mkdir();
						String fileName = s + ".txt";
						String path = "PatientInfo" + File.separator + s + File.separator;
						
						File file = new File( path );
						file.mkdirs();
						
						path = "PatientInfo" + File.separator + s + File.separator + fileName;
						try {
							 
						      File myObj = new File(path);
						      if (myObj.createNewFile()) {
						        System.out.println("File created: " + myObj.getName());
						      } else {
						        System.out.println("File already exists.");
						      }
						    } catch (IOException e) {
						      System.out.println("An error occurred.");
						      e.printStackTrace();
						    }
						
					}
					catch(Exception e) {
						e.printStackTrace();
						System.out.println("ERROR: Cannot Log in");
					}
				}

				@Override
				public void initialize(URL arg0, ResourceBundle arg1) {
					// TODO Auto-generated method stub
					
				}
				
				
				
	@FXML
	public void patientLoginOK(ActionEvent event) {
		try {
			Parent patient = FXMLLoader.load(getClass().getResource("Pediatric Office System (Patient).fxml"));
			Stage stage = new Stage();
			stage.setTitle("Pediatric Office - Patient");
			stage.setScene(new Scene(patient));
			stage.show();
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("ERROR: Cannot Open Patient UI");
		}
	} 

}

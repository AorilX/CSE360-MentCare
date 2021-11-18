package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import java.util.*;



public class Main extends Application {

	
	ArrayList<Patient> patientList = PatientStorage.LoadData();
	
	
	@Override
	public void start(Stage primaryStage) {
		
		try {
			Parent root = FXMLLoader.load(getClass().getResource("protoLogin.fxml"));
			primaryStage.setTitle("UI Selector");
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

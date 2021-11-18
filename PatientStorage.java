package application;
import java.util.*;
import java.io.*;

public class PatientStorage implements java.io.Serializable{
    private static final long serialVersionUID = 1L;
    
	
    public static void SaveData(ArrayList<Patient> patients){
        //Writing to disk
		try {
       FileOutputStream f_out = new FileOutputStream("patientstorage.ser");
       //Writing object 
       ObjectOutputStream obj_out = new ObjectOutputStream(f_out);
       
       //Write object to disk
       obj_out.writeObject(obj_out);
       obj_out.close();
       }
       catch (Exception e){
           e.printStackTrace();
           System.out.println("There was an error saving data.");
       }
    }
    
    
    
    
    public static ArrayList<Patient> LoadData(){
        ArrayList<Patient> patientstorage = new ArrayList<>();
        
        try {
            // Read from disk using FileInputStream
			FileInputStream fis = new FileInputStream("patientstorage.ser");
			// Read object using ObjectInputStream
			ObjectInputStream ois = new ObjectInputStream(fis);
			// Read an object
			patientstorage = (ArrayList<Patient>) ois.readObject();
			ois.close();
			return patientstorage;
        }
        catch (Exception e){
           e.printStackTrace();
           System.out.println("There was an error loading data.");
       }
       
    return patientstorage;
        
    }
    


}

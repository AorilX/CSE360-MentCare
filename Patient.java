package application;
import java.util.*;
import java.io.*;

public class Patient extends User implements Serializable {
	private static final long serialVersionUID = 1L;
	private String address;
	private List<Visit> visitList;
	private List<Prescription> medsPrescribed;
	private int gender;
	private String birthdate;
	private String visitHistory = "";
	private String medication = "";
	private String insurance = "";
	
	
	
	public Patient(String userID, String password, String firstname, String lastname, String email, int phoneNumber, int gender, String birthdate) {
		super(userID, password, firstname, lastname, email, phoneNumber);
		this.gender = gender;
		this.birthdate = birthdate;
		
		
	}
	
	public void addVisit(Visit visit){
		visitList.add(visit);
	}
	
	
    public void setMedication() {
    	String med = "", medNm, dos, amnt, date, rsn, note;
    	int size = medsPrescribed.size();
    	for(int i = 0; i < size; i++) {
    	medNm = medsPrescribed.get(i).getMedName();
    	dos = Integer.toString(medsPrescribed.get(i).getDosage());
    	amnt = Integer.toString(medsPrescribed.get(i).getAmount());
    	date = medsPrescribed.get(i).getDatePrescribed();
    	rsn = medsPrescribed.get(i).getReason();
    	note = medsPrescribed.get(i).getNote();
    	med += String.format(""
    			+ "Medication Name:\t\t\t\t%s\n"
    			+ "Dosage:\t\t\t\t%s\n"
    			+ "Amount:\t\t\t\t%s\n"
    			+ "Prescribed on:\t\t\t\t%s\n"
    			+ "Reason:\t\t\t\t%s\n"
    			+ "Note:\t\t\t\t%s\n\n", medNm, dos, amnt, date, rsn, note);
    	}
    	medication = med;
    }
    	
	public String getMedication() {
		return medication;
	}
	
	public String getInsurance() {
		return insurance;
	}
	
	public void setInsurance(String i) {
		insurance = i;
	}
	
	public String getVisitHistory() {
		return visitHistory;
	}
	
	public void setVisitHistory(String vh) {
		visitHistory = vh;
	}

	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	public List<Visit> getVisitList() {
		return visitList;
	}
	public void setVisitList(List<Visit> visitList) {
		this.visitList = visitList;
	}
	public List<Prescription> getPrescriptionList(){
		return medsPrescribed;
	}
	public void setPrescriptionList(List<Prescription> pl) {
		medsPrescribed = pl;
	}

	
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	
	
}

package application;
import java.io.*;

public class Prescription implements Serializable{
	private static final long serialVersionUID = 1L;
	private Doctor prescribedBy;
	private String medName;
	private String note;
	private int dosage;
	private int amount;
	private String datePrescribed;
	private String reason;
	
	public Prescription(String mn, String n, int dos, int amnt, String date, String rsn) {
		medName = mn;
		note = n;
		dosage = dos;
		amount = amnt;
		datePrescribed = date;
		reason = rsn;
	}
	
	public String getNote() {
		return this.note;
	}
	
	public void setNote(String note){
		this.note = note;
	}
	
	public Doctor getPrescribedBy() {
		return prescribedBy;
	}
	public void setPrescribedBy(Doctor prescribedBy) {
		this.prescribedBy = prescribedBy;
	}
	public String getMedName() {
		return medName;
	}
	public void setMedName(String medName) {
		this.medName = medName;
	}
	public int getDosage() {
		return dosage;
	}
	public void setDosage(int dosage) {
		this.dosage = dosage;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getDatePrescribed() {
		return datePrescribed;
	}
	public void setDatePrescribed(String datePrescribed) {
		this.datePrescribed = datePrescribed;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
}

package application;

import java.util.*;

public class Staff extends User{
	protected ArrayList<Patient> patients;
	
	public Staff(String userID, String password, String firstname, String lastname, String email, int phoneNumber) {
		super(userID, password, firstname, lastname, email, phoneNumber);
	}


}

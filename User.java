package application;

public class User {
	protected String userID;
	protected String password;
	protected String firstname;
	protected String lastname;
	protected String email;
	protected int phoneNumber;
	
	
	
	public User(String userID, String password, String firstname, String lastname, String email, int phoneNumber) {
	super();
	this.userID = userID;
	this.password = password;
	this.firstname = firstname;
	this.lastname = lastname;
	this.email = email;
	this.phoneNumber = phoneNumber;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String name) {
		this.firstname = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String name) {
		this.lastname = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public void Login(String userID, String password) {
		
	}
	
	public void Logout() {
		
	}
	
}

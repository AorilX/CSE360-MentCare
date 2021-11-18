package application;
import java.io.*;

public class Vitals implements Serializable{
	private static final long serialVersionUID = 1L;
	private String weight;
	private String height;
	private String temperature;
	private String bloodPressure;
	
	
	public Vitals(String weight, String height, String temperature, String bloodPressure) {
		super();
		this.weight = weight;
		this.height = height;
		this.temperature = temperature;
		this.bloodPressure = bloodPressure;
	}
	
	
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getBloodPressure() {
		return bloodPressure;
	}
	public void setBloodPressure(String bloodPressure) {
		this.bloodPressure = bloodPressure;
	}
	
	
}

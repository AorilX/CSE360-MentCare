package application;
import java.util.*;
import java.io.*;

public class Visit implements Serializable{
	private static final long serialVersionUID = 1L;
	private String date;
	private Vitals vital;
	private String PhysTestInfo;
	private String visitReason;
	private String visitSummary;
	
		public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Vitals getVital() {
		return vital;
	}

	public void setVital(Vitals vital) {
		this.vital = vital;
	}

	public String getPhysTestInfo() {
		return PhysTestInfo;
	}

	public void setPhysTestInfo(String physTestInfo) {
		PhysTestInfo = physTestInfo;
	}

	public String getVisitReason() {
		return visitReason;
	}

	public void setVisitReason(String visitReason) {
		this.visitReason = visitReason;
	}

	public String getVisitSummary() {
		return visitSummary;
	}

	public void setVisitSummary(String visitSummary) {
		this.visitSummary = visitSummary;
	}

		public Visit(String date, Vitals vital, String visitReason) {
		super();
		this.date = date;
		this.vital = vital;
		this.visitReason = visitReason;
		this.PhysTestInfo = "";
		this.visitSummary = "";
	}
	
}

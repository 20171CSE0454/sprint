package com.cap.capgeminibatch2.capgeminibatch2.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Program {
	
	@Id
	@SequenceGenerator(name="program_sequence",allocationSize=1)
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "program_sequence")
	private int programId;
	private String programName;
	private String eligibility;
	private String duration;
	private String degreeOffered;
	
	public Program() {
		
	}
	
	public Program(String programName,String eligibility, String duration,String degreeOffered) {
		this.programName=programName;
		this.eligibility=eligibility;
		this.duration=duration;
		this.degreeOffered=degreeOffered;
	}
	
	public Program(int programId,String programName,String eligibility, String duration,String degreeOffered) {
		this.programId=programId;
		this.programName=programName;
		this.eligibility=eligibility;
		this.duration=duration;
		this.degreeOffered=degreeOffered;
	}

	public int getProgramId() {
		return programId;
	}

	public void setProgramId(int programId) {
		this.programId = programId;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public String getEligibility() {
		return eligibility;
	}

	public void setEligibility(String eligibility) {
		this.eligibility = eligibility;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getDegreeOffered() {
		return degreeOffered;
	}

	public void setDegreeOffered(String degreeOffered) {
		this.degreeOffered = degreeOffered;
	}

	@Override
	public String toString() {
		return "Program [programId=" + programId + ", programName=" + programName + ", eligibility=" + eligibility
				+ ", duration=" + duration + ", degreeOffered=" + degreeOffered + "]";
	}
	
	

}

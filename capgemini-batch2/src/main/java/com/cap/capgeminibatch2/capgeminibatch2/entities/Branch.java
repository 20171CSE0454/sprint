package com.cap.capgeminibatch2.capgeminibatch2.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Branch {
	
	@Id
	@SequenceGenerator(name="branch_sequence",allocationSize=1)
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "branch_sequence")
	@Column(name="BRANCH_ID")
	private int branchId;
	private String branchName;
	private String branchDescription;
	
	public Branch() {
		
	}
	
	public Branch(String branchName,String branchDescription) {
		this.branchName=branchName;
		this.branchDescription=branchDescription;
	}
	
	public Branch(int branchId,String branchName,String branchDescription) {
		this.branchId=branchId;
		this.branchName=branchName;
		this.branchDescription=branchDescription;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getBranchDescription() {
		return branchDescription;
	}

	public void setBranchDescription(String branchDescription) {
		this.branchDescription = branchDescription;
	}

	@Override
	public String toString() {
		return "Branch [branchId=" + branchId + ", branchName=" + branchName + ", branchDescription="
				+ branchDescription + "]";
	}	

}

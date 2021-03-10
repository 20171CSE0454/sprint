package com.cap.capgeminibatch2.capgeminibatch2.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class College {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int collegeRegId;
	
	 @Column(name = "collegeName")
	    private String collegeName;
	 
	 public College() {
		 
	 }

	public College(int collegeRegId, String collegeName) {
		super();
		this.collegeRegId = collegeRegId;
		this.collegeName = collegeName;
	}

	@Override
	public String toString() {
		return "College [collegeRegId=" + collegeRegId + ", collegeName=" + collegeName + "]";
	}
	 
	 

}

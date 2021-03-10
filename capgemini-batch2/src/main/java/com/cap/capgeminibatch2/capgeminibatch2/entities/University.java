package com.cap.capgeminibatch2.capgeminibatch2.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class University {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	int universityId;
	String name;
	
	public University() {
		
	}
	
	public University(String name, int universityId) {
		super();
		this.name = name;
		this.universityId = universityId;
	}

	@Override
	public String toString() {
		return "University [name=" + name + ", universityId=" + universityId + "]";
	}
	
	

}

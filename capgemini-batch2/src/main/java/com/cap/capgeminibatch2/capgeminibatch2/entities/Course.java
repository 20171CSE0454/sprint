package com.cap.capgeminibatch2.capgeminibatch2.entities;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import java.util.List;

@Entity
public class Course {
	
	@Id
	@SequenceGenerator(name="course_sequence",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO,generator = "course_sequence")
	private int courseId;
	private String courseName;
	private String eligibility;
//	@OneToOne(cascade = CascadeType.PERSIST)  
//	@JoinColumn(name="courseId")
//	private College college;
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "branchId")
	private List<Branch> branches;
	
	public Course() {
		
	}
	
	public Course(String courseName, String eligibility, ArrayList<Branch> branches) {
		this.courseName=courseName;
		this.eligibility=eligibility;
//		this.college=college;
		this.branches=branches;
	}
	
	public Course(int courseId,String courseName, String eligibility,ArrayList<Branch> branches) {
		this.courseId=courseId;
		this.courseName=courseName;
		this.eligibility=eligibility;
//		this.college=college;
		this.branches=branches;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getEligibility() {
		return eligibility;
	}

	public void setEligibility(String eligibility) {
		this.eligibility = eligibility;
	}

//	public College getCollege() {
//		return college;
//	}
//	
//	public void setCollege(College college) {
//		this.college = college;
//	}

	public List<Branch> getBranches() {
		return branches;
	}

	public void setBranches(ArrayList<Branch> branches) {
		this.branches = branches;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", eligibility=" + eligibility
				+ ", branches=" + branches + "]";
	}
	
	

}

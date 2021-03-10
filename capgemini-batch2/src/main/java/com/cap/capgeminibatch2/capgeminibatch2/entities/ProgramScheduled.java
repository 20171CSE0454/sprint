package com.cap.capgeminibatch2.capgeminibatch2.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class ProgramScheduled {
	
	@Id
	@SequenceGenerator(name="programscheduled_sequence",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO,generator = "programscheduled_sequence")
	private int scheduleId;
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="branchId")
	private Branch branch;
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="courseId")
	private Course course;
	@OneToOne(cascade = CascadeType.PERSIST)  
	@JoinColumn(name="programId")
	private Program program;
	@ManyToOne
	College college;
	@ManyToOne
	University university;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate startDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate endDate;
	
	public ProgramScheduled() {
		
	}

	public ProgramScheduled(int scheduleId, Branch branch, Course course, Program program, College college,
		University university, LocalDate startDate, LocalDate endDate) {
	super();
	this.scheduleId = scheduleId;
	this.branch = branch;
	this.course = course;
	this.program = program;
	this.college = college;
	this.university = university;
	this.startDate = startDate;
	this.endDate = endDate;
}
	
	public ProgramScheduled(Branch branch, Course course, Program program, College college,
			University university, LocalDate startDate, LocalDate endDate) {
		super();
		this.branch = branch;
		this.course = course;
		this.program = program;
		this.college = college;
		this.university = university;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

	public University getUniversity() {
		return university;
	}

	public void setUniversity(University university) {
		this.university = university;
	}

	public int getScheduleId() {
		return scheduleId;
	}
	
	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "ProgramScheduled [scheduleId=" + scheduleId + ", branch=" + branch + ", course=" + course + ", program="
				+ program + ", college=" + college + ", university=" + university + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}

	
	

}

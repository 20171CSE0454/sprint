package com.cap.capgeminibatch2.test;

import java.util.ArrayList;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cap.capgeminibatch2.capgeminibatch2.entities.Branch;
//import com.cap.capgeminibatch2.capgeminibatch2.entities.College;
import com.cap.capgeminibatch2.capgeminibatch2.entities.Course;
import com.cap.capgeminibatch2.exception.AlreadyExistsException;
import com.cap.capgeminibatch2.exception.CourseNotFoundException;
import com.cap.capgeminibatch2.serviceimplementation.CourseServiceImplementation;

@SpringBootTest
class TestCourse {
	Course course;
//	College college;
	ArrayList<Branch> branch;
	
	@Autowired
	CourseServiceImplementation courseServiceImplementation;
	
	@BeforeEach
	void setUp() {
//		college=new College("Presidency University");
		Branch b1=new Branch("Mech","Machines");
		Branch b2=new Branch("Electronics","Circuits");
		branch=new ArrayList<Branch>();
		branch.add(b1);
		branch.add(b2);
		Course course=new Course();
		course.setCourseId(1);
		course.setCourseName("B tech");
		course.setEligibility("Passed 10+2");
		course.setBranches(branch);
	}

	@Test
	@Transactional
	public void testAddCourse() throws AlreadyExistsException {
		try {
			Branch b1=new Branch("Mech","Machines");
			Branch b2=new Branch("Electronics","Circuits");
			branch=new ArrayList<Branch>();
			branch.add(b1);
			branch.add(b2);
	//		Course course=new Course();
//			course.setCourseId(1);
//			course.setCourseName("B tech");
//			course.setEligibility("Passed 10+2");
//			course.setBranches(branch);
        	Course course=new Course("B tech","Passed 10+2",branch);
			Course course1=courseServiceImplementation.addCourse(course);	
			System.out.println(course1);
		}
		catch(NoResultException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testViewAllCourseDetails() throws CourseNotFoundException {
		courseServiceImplementation.viewAllCourseDetails();
	}
	
	@Test
	public void testGetCourseDetailsByCourseName() {
		String name="B Tech";
	    courseServiceImplementation.getCourseDetailsByCourseName(name);
	}
	
	@Test
	public void testGetCourseDetailsByEligibility() {
		String eligibility="Passed 10+2";
		ArrayList<Course> course=courseServiceImplementation.getCourseDetailsByEligibility(eligibility);
		System.out.println(course);
	}
	
	@Test
	public void testGetCourseDetailsByCourseId() {
		int id=3;
		Course course=courseServiceImplementation.getCourseDetailsByCourseId(id);
		System.out.println(course);
	}
	
	@Test
	public void testDeleteCourseById() {
		int id=3;
		courseServiceImplementation.deleteCourseById(id);
		System.out.println("Course deleted");
	}
	
	@Test
	public void testDeleteCourseByName() {
		String name="B Tech";
		courseServiceImplementation.deleteCourseByName(name);
		System.out.println("Course deleted");
	}
	
	@Test
	public void testUpdateCourseDetails() {
		Course course=courseServiceImplementation.getCourseDetailsByCourseId(6);
		course.setCourseName("MS");
		courseServiceImplementation.updateCourseDetails(course);
		System.out.println("Course updated");
	}

}

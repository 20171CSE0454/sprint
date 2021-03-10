package com.cap.capgeminibatch2.capgeminibatch2.service;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.cap.capgeminibatch2.capgeminibatch2.entities.Course;
import com.cap.capgeminibatch2.exception.CourseNotFoundException;

@Component
public interface ICourseService {
	
	public Course addCourse(Course course);
	
	public ArrayList<Course> viewAllCourseDetails() throws CourseNotFoundException;
	
	public ArrayList<Course> getCourseDetailsByCourseName(String courseName);
	
	public ArrayList<Course> getCourseDetailsByCollegeName(String collegeName);
	
	public ArrayList<Course> getCourseDetailsByEligibility(String eligibility);
	
	public Course getCourseDetailsByCourseId(int courseId);
	
	public int deleteCourseById(int courseId);
	
	public int deleteCourseByName(String courseName);
	
	public int updateCourseDetails(Course course);
	
}

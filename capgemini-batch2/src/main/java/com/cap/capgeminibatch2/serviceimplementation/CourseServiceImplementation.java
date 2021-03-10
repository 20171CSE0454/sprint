package com.cap.capgeminibatch2.serviceimplementation;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.capgeminibatch2.capgeminibatch2.entities.Branch;
import com.cap.capgeminibatch2.capgeminibatch2.entities.Course;
//import com.cap.capgeminibatch2.capgeminibatch2.repository.ICollegeRepository;
import com.cap.capgeminibatch2.capgeminibatch2.repository.ICourseRepository;
import com.cap.capgeminibatch2.capgeminibatch2.service.ICourseService;
import com.cap.capgeminibatch2.exception.CourseNotFoundException;

@Service
public class CourseServiceImplementation implements ICourseService{
	
	@Autowired
	ICourseRepository courseRepository;
	
//	@Autowired
//	IBranchRepository branchRepository;
	
	@Override
	public Course addCourse(Course course){
		courseRepository.save(course);
		return course;
	}

	@Override
	public ArrayList<Course> viewAllCourseDetails() throws CourseNotFoundException {
		ArrayList<Course> courses = new ArrayList<Course>(courseRepository.findAll());
		if(courses.isEmpty()) {
			throw new CourseNotFoundException("Course Not Found");
		}
		return courses;
	}

	@Override
	public ArrayList<Course> getCourseDetailsByCourseName(String courseName) {
		ArrayList<Course> course =new ArrayList<Course>(courseRepository.findByCourseName(courseName));
		return course;
	}

	@Override
	public ArrayList<Course> getCourseDetailsByEligibility(String eligibility) {
		ArrayList<Course> course =new ArrayList<Course>(courseRepository.findByEligibility(eligibility));
		return course;
	}

	@Override
	public Course getCourseDetailsByCourseId(int courseId) {
		Optional<Course> course = courseRepository.findById(courseId);
		if(course.isPresent()) {
		return course.get();
    }
		return null;
	}

	@Override
	public int deleteCourseById(int courseId) {
		Optional<Course> course = courseRepository.findById(courseId);
		Course cr = null;
		if(course.isPresent()) {
			cr = course.get();
			courseRepository.delete(cr);
			return course.get().getCourseId();
		}
		return 0;
	}

	@Override
	public int deleteCourseByName(String courseName) {
		ArrayList<Course> course = courseRepository.findByCourseName(courseName);
		if (!course.isEmpty())
		{
			for(Course cr: course)
			{
				courseRepository.delete(cr);
				return cr.getCourseId();
			}
		}
		return 0;
	}

	@Override
	public int updateCourseDetails(Course course) {
		Optional<Course> courseFind = courseRepository.findById(course.getCourseId());
		Course cr=null;
		if(courseFind.isPresent()) {
			cr=courseFind.get();
			if(course.getCourseId()!=0) {
				cr.setCourseId(course.getCourseId());
			}
			if(course.getCourseName()!=null) {
				cr.setCourseName(course.getCourseName());
			}
			if(course.getEligibility()!=null) {
				cr.setEligibility(course.getEligibility());
			}
			if(course.getBranches()!=null) {
				cr.setBranches((ArrayList<Branch>) course.getBranches());
			}
		}
		return 0;
	}

	@Override
	public ArrayList<Course> getCourseDetailsByCollegeName(String collegeName) {
		// TODO Auto-generated method stub
		return null;
	}


}

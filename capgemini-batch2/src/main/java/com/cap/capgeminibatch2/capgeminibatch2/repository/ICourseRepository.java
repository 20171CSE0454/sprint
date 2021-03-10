package com.cap.capgeminibatch2.capgeminibatch2.repository;

import java.util.ArrayList;
//import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cap.capgeminibatch2.capgeminibatch2.entities.Course;

@Repository
public interface ICourseRepository extends JpaRepository<Course,Integer>{

	ArrayList<Course> findByCourseName(String courseName);

	ArrayList<Course> findByEligibility(String eligibility);

//	Collection<? extends Course> findByCollegeName();


}

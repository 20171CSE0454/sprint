package com.cap.capgeminibatch2.capgeminibatch2.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cap.capgeminibatch2.capgeminibatch2.entities.Program;

@Repository
public interface IProgramRepository extends JpaRepository<Program, Integer>{

	ArrayList<Program> findByProgramName(String programName);

	ArrayList<Program> findByEligibility(String eligibility);
	
	

}

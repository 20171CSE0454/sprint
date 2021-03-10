package com.cap.capgeminibatch2.capgeminibatch2.repository;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cap.capgeminibatch2.capgeminibatch2.entities.College;
import com.cap.capgeminibatch2.capgeminibatch2.entities.ProgramScheduled;

@Repository
public interface ICollegeRepository extends JpaRepository<College, Integer> {


	ArrayList<ProgramScheduled> findByCollegeName(String collegeName);

}

package com.cap.capgeminibatch2.capgeminibatch2.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cap.capgeminibatch2.capgeminibatch2.entities.ProgramScheduled;

@Repository
public interface IProgramScheduleRepository extends JpaRepository<ProgramScheduled, Integer> {


	List<ProgramScheduled> findByStartDate(LocalDate date);
	

}

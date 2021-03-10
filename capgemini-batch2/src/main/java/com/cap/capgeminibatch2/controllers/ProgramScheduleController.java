package com.cap.capgeminibatch2.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cap.capgeminibatch2.capgeminibatch2.entities.ProgramScheduled;
import com.cap.capgeminibatch2.serviceimplementation.ProgramScheduledServiceImplementation;

@RestController
@RequestMapping(path = "/api/v1")
public class ProgramScheduleController {

	@Autowired
	ProgramScheduledServiceImplementation programScheduledServiceImplementation;
	
	@PostMapping("/programSchedules")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ProgramScheduled addProgramSchedule(@RequestBody ProgramScheduled programSchedule) {
		programScheduledServiceImplementation.addProgramSchedule(programSchedule);
		return programSchedule;
	}
	
	@GetMapping("/programSchedules")
	@ResponseStatus(code = HttpStatus.OK)
	public ArrayList<ProgramScheduled> viewAllProgramScheduleDetails() {
		return programScheduledServiceImplementation.viewAllProgramScheduleDetails();
	}
	
	@GetMapping("/programScheduleByName/{collegeName}")
	@ResponseStatus(code = HttpStatus.OK)
	public ArrayList<ProgramScheduled> getProgramScheduleByCollegeName(@PathVariable("collegeName") String collegeName) {
		return programScheduledServiceImplementation.getProgramScheduleByCollegeName(collegeName);
	}
	
	@GetMapping("/programScheduleByDate/{date}")
	@ResponseStatus(code = HttpStatus.OK)
	public List<ProgramScheduled> getProgramScheduleByDate(@PathVariable("date") LocalDate date) {
		return programScheduledServiceImplementation.getProgramScheduleByDate(date);
	}
	
	@DeleteMapping("/deleteProgramScheduledById/{scheduleId}")
	@ResponseStatus(code = HttpStatus.OK)
	public int deleteProgramScheduleById(@PathVariable("scheduleId") int scheduleId) {
		return programScheduledServiceImplementation.deleteProgramScheduleById(scheduleId);
	}
	
	@GetMapping("/programScheduleById/{scheduleId}")
	@ResponseStatus(code = HttpStatus.OK)
	public ProgramScheduled getProgramScheduleById(@PathVariable("scheduleId") int scheduleId) {
		return programScheduledServiceImplementation.getProgramScheduleById(scheduleId);
	}

	@PutMapping("/programSchedules")
	@ResponseStatus(code = HttpStatus.OK)
	@Transactional
	public int updateProgramSchedule(ProgramScheduled programSchedule) {
		return programScheduledServiceImplementation.updateProgramSchedule(programSchedule);
	}
}

package com.cap.capgeminibatch2.capgeminibatch2.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cap.capgeminibatch2.capgeminibatch2.entities.ProgramScheduled;

@Component
public interface IProgramScheduleService {
	
	public ProgramScheduled addProgramSchedule(ProgramScheduled programschedule);
	
	public ArrayList<ProgramScheduled> viewAllProgramScheduleDetails();
	
	public ArrayList<ProgramScheduled> getProgramScheduleByCollegeName(String collegeName);
	
	public List<ProgramScheduled> getProgramScheduleByDate(LocalDate date);
	
	public int deleteProgramScheduleById(int scheduleId);
	
	public ProgramScheduled getProgramScheduleById(int scheduleId);
	
	public int updateProgramSchedule(ProgramScheduled programSchedule);

}

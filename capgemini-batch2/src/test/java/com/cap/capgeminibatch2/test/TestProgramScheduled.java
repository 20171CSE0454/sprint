package com.cap.capgeminibatch2.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cap.capgeminibatch2.capgeminibatch2.entities.Branch;
import com.cap.capgeminibatch2.capgeminibatch2.entities.College;
import com.cap.capgeminibatch2.capgeminibatch2.entities.Course;
import com.cap.capgeminibatch2.capgeminibatch2.entities.Program;
import com.cap.capgeminibatch2.capgeminibatch2.entities.ProgramScheduled;
import com.cap.capgeminibatch2.capgeminibatch2.entities.University;
import com.cap.capgeminibatch2.serviceimplementation.ProgramScheduledServiceImplementation;

@SpringBootTest
class TestProgramScheduled {
	
	Branch branch;
	Course course;
	Program program;
	College collegeName;
	University university;

	@Autowired
	ProgramScheduledServiceImplementation programScheduledServiceImplementation;
	
	@BeforeEach
	void setUp() {
		Branch b1=new Branch("Mech","Machines");
		Branch b2=new Branch("Electronics","Circuits");
		ArrayList<Branch> branch=new ArrayList<Branch>();
		branch.add(b1);
		branch.add(b2);
		Course course=new Course();
		course.setCourseId(1);
		course.setCourseName("B tech");
		course.setEligibility("Passed 10+2");
		course.setBranches(branch);
		Program program=new Program();
		program.setDegreeOffered("Masters");
		program.setDuration("2 years");
		program.setEligibility("Undergraduate");
		program.setProgramName("MBA");
	}
	
	@Test
	void testAddProgramSchedule() {
		try {
			
			ProgramScheduled programScheduled=new ProgramScheduled(branch,course,program,collegeName,university, LocalDate.of(2021,03,02),LocalDate.of(2021,03,02));
			programScheduledServiceImplementation.addProgramSchedule(programScheduled);
		}
		catch(NoResultException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	void testViewAllProgramScheduleDetails() {
		List<ProgramScheduled> programScheduled=programScheduledServiceImplementation.viewAllProgramScheduleDetails();
		System.out.println(programScheduled);
	}
	
	@Test
	void testGetProgramScheduleByCollegeName() {
		String name="MBA";
	    programScheduledServiceImplementation.getProgramScheduleByCollegeName(name);
	}
	
	@Test
	void testGetProgramScheduleByDate() {
		LocalDate date=LocalDate.of(2021, 03, 07);
		List<ProgramScheduled> pS=programScheduledServiceImplementation.getProgramScheduleByDate(date);
		System.out.println(pS);
	}
	
	@Test
	void testDeleteProgramScheduleById() {
		int id=1;
		programScheduledServiceImplementation.deleteProgramScheduleById(id);
		System.out.println("Program deleted");
	}
	
	@Test
	void testGetProgramScheduleById() {
		int id=1;
		ProgramScheduled programSchedule=programScheduledServiceImplementation.getProgramScheduleById(id);
		System.out.println(programSchedule);
	}
	
	@Test
	void testUpdateProgramSchedule() {
		
		ProgramScheduled programS=programScheduledServiceImplementation.getProgramScheduleById(2);
		programS.setStartDate(LocalDate.of(2021,05,12));
		programScheduledServiceImplementation.updateProgramSchedule(programS);
//		ProgramScheduled programScheduled=new ProgramScheduled(branch,course,program,collegeName, university, LocalDate.of(2021,03,02),LocalDate.of(2021,03,02));
//		programScheduledServiceImplementation.updateProgramSchedule(programScheduled);
		System.out.println("Program scheduled updated");
	}
	
	
}

package com.cap.capgeminibatch2.serviceimplementation;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cap.capgeminibatch2.capgeminibatch2.entities.Program;
import com.cap.capgeminibatch2.capgeminibatch2.repository.IProgramRepository;
import com.cap.capgeminibatch2.capgeminibatch2.service.IProgramService;
import com.cap.capgeminibatch2.exception.AlreadyExistsException;

@Service
public class ProgramServiceImplementation implements IProgramService{
	
	@Autowired
	IProgramRepository programRepository;

	@Override
	public Program addProgram(Program program) throws AlreadyExistsException {
		ArrayList<Program> pr=programRepository.findByProgramName(program.getProgramName());
		if(pr.isEmpty()) {
			programRepository.save(program);	
		}else {
			throw new AlreadyExistsException("Branch " +program.getProgramName()+" already exists");
		}
		return program;
	}

	@Override
	public ArrayList<Program> viewAllProgramDetails() {
		ArrayList<Program> programs = new ArrayList<Program>(programRepository.findAll());
		return programs;
	}

	@Override
	public ArrayList<Program> getApplicationDetailsByCollegeName(String collegeName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Program> getProgramDetailsByName(String programName) {
		ArrayList<Program> program =new ArrayList<Program>(programRepository.findByProgramName(programName));
		return program;
	}

	@Override
	public ArrayList<Program> getProgramDetailsByEligibility(String eligibility) {
		ArrayList<Program> program =new ArrayList<Program>(programRepository.findByEligibility(eligibility));
		return program;
	}

	@Override
	public int deleteProgramById(int programId) {
		Optional<Program> program = programRepository.findById(programId);
		Program pr = null;
		if(program.isPresent()) {
			pr = program.get();
			programRepository.delete(pr);
			return program.get().getProgramId();
		}
		return 0;
	}

	@Override
	public int deleteProgramByName(String programName) {
		ArrayList<Program> program = programRepository.findByProgramName(programName);
		if (!program.isEmpty())
		{
			for(Program pr: program)
			{
				programRepository.delete(pr);
				return pr.getProgramId();
			}
		}
		return 0;
	}

	@Override
	public Program getProgramById(int programId) {
		Optional<Program> program = programRepository.findById(programId);
		if(program.isPresent()) {
			return program.get();
//		return program.get().getProgramId();
    }
		return null;
	}

	@Override
	public int updateProgramStatus(Program program) {
		Optional<Program> programFind = programRepository.findById(program.getProgramId());
		Program pr=null;
		if(programFind.isPresent()) {
			pr=programFind.get();
			if(program.getProgramId()!=0) {
				pr.setProgramId(program.getProgramId());
			}
			if(program.getProgramName()!=null) {
				pr.setProgramName(program.getProgramName());
			}
			if(program.getDegreeOffered()!=null) {
				pr.setDegreeOffered(program.getDegreeOffered());
			}
			if(program.getDuration()!=null) {
				pr.setDuration(program.getDuration());
			}
			if(program.getEligibility()!=null) {
				pr.setEligibility(program.getEligibility());
			}
		}
		return 0;
	}

}

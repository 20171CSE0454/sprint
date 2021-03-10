package com.cap.capgeminibatch2.serviceimplementation;

import java.util.ArrayList;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.capgeminibatch2.capgeminibatch2.entities.Branch;
import com.cap.capgeminibatch2.capgeminibatch2.repository.IBranchRepository;
import com.cap.capgeminibatch2.capgeminibatch2.service.IBranchService;
import com.cap.capgeminibatch2.exception.AlreadyExistsException;
import com.cap.capgeminibatch2.exception.BranchNotFoundException;

@Service
public class BranchServiceImplementation implements IBranchService {
	
	@Autowired
	IBranchRepository branchRepository;

	@Override
	public Branch addBranch(Branch branch) throws AlreadyExistsException {
		ArrayList<Branch> br=branchRepository.findByBranchName(branch.getBranchName());
		if(br.isEmpty()) {
			branchRepository.save(branch);
		}else {
			throw new AlreadyExistsException("Branch " +branch.getBranchName()+" already exists");
		}
		return branch;
	}
	
	@Override
	public ArrayList<Branch> viewAllBranchDetails(){
		ArrayList<Branch> branches = new ArrayList<Branch>(branchRepository.findAll());
		if(branches.isEmpty()) {
			throw new BranchNotFoundException("Branch not Found");
		}
		return branches;
	}
	
	@Override
	public ArrayList<Branch> getBranchDetailsByName(String branchName){
		ArrayList<Branch> branch =branchRepository.findByBranchName(branchName);
		return branch;
	}
	
	@Override
	public int deleteBranchById(int branchId) {
		Optional<Branch> branch = branchRepository.findById(branchId);
		Branch br = null;
		if(branch.isPresent()) {
			br = branch.get();
			branchRepository.delete(br);
			return branch.get().getBranchId();
		}
		return 0;
	}
	
	@Override
	public Branch getBranchById(int branchId) {
		Optional<Branch> branch = branchRepository.findById(branchId);
		if(branch.isEmpty()) {
			throw new BranchNotFoundException("Branch not found");
    }
		return branch.get();
	}
	
	@Override
	public int deleteBranchByName(String branchName) {
		ArrayList<Branch> branch = branchRepository.findByBranchName(branchName);
		if (!branch.isEmpty())
		{
			for(Branch br: branch)
			{
				branchRepository.delete(br);
				return br.getBranchId();
			}
		}
		return 0;
	}

	@Override
	@Transactional
	public int updateBranch(Branch branch) {
		Optional<Branch> branchFind = branchRepository.findById(branch.getBranchId());
		Branch br=null;
		if(branchFind.isPresent()) {
			br=branchFind.get();
			if(branch.getBranchName()!=null) {
				br.setBranchName(branch.getBranchName());
			}
			if(branch.getBranchId()!=0) {
				br.setBranchId(branch.getBranchId());
			}
			if(branch.getBranchDescription()!=null) {
				br.setBranchDescription(branch.getBranchDescription());
			}
		}
		return 0;
	}
	
}
	
	
	

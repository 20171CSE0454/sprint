package com.cap.capgeminibatch2.capgeminibatch2.service;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.cap.capgeminibatch2.capgeminibatch2.entities.Branch;
import com.cap.capgeminibatch2.exception.AlreadyExistsException;

@Component
public interface IBranchService {
	
	public Branch addBranch(Branch branch) throws AlreadyExistsException;
	
	public ArrayList<Branch> viewAllBranchDetails();
	
	public ArrayList<Branch> getBranchDetailsByName(String branchName);
	
	public int deleteBranchById(int branchId);
	
	public Branch getBranchById(int branchId);
	
	public int deleteBranchByName(String branchName);
	
	public int updateBranch(Branch branch);


}
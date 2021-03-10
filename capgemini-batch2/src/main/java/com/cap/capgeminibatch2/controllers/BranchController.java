package com.cap.capgeminibatch2.controllers;

import java.util.ArrayList;

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

import com.cap.capgeminibatch2.capgeminibatch2.entities.Branch;
import com.cap.capgeminibatch2.exception.AlreadyExistsException;
import com.cap.capgeminibatch2.serviceimplementation.BranchServiceImplementation;

@RestController
@RequestMapping(path = "/api/v1")
public class BranchController {
	
	@Autowired
	BranchServiceImplementation branchServiceImplementation;
	
	@PostMapping("/branches")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Branch addBranch(@RequestBody Branch branch) throws AlreadyExistsException {
		branchServiceImplementation.addBranch(branch);
		return branch;
	}
	
	@GetMapping("/branches")
	@ResponseStatus(code = HttpStatus.OK)
	public ArrayList<Branch> viewAllBranchDetails(){
		return branchServiceImplementation.viewAllBranchDetails();	
	}
	
	@GetMapping("/branchByName/{branchName}")
	@ResponseStatus(code = HttpStatus.OK)
	public ArrayList<Branch> getBranchDetailsByName(@PathVariable("branchName") String branchName){
		return branchServiceImplementation.getBranchDetailsByName(branchName);
	}
	
	@DeleteMapping("/deleteBranchById/{branchId}")
	@ResponseStatus(code = HttpStatus.OK)
	public int deleteBranchById(@PathVariable("branchId") int branchId) {
		return branchServiceImplementation.deleteBranchById(branchId);
	}
	
	@GetMapping("/branchById/{branchId}")
	@ResponseStatus(code = HttpStatus.OK)
	public Branch getBranchById(@PathVariable("branchId") int branchId) {
		return branchServiceImplementation.getBranchById(branchId);
	}
	
	@DeleteMapping("/deleteBranchByName/{branchName}")
	@ResponseStatus(code = HttpStatus.OK)
	public int deleteBranchByName(@PathVariable("branchName") String branchName) {
		return branchServiceImplementation.deleteBranchByName(branchName);
	}
	
	@PutMapping("/branches")
	@ResponseStatus(code = HttpStatus.OK)
	@Transactional
	public int updateBranch(@RequestBody Branch branch) {
		return branchServiceImplementation.updateBranch(branch);
	}
	
	

}

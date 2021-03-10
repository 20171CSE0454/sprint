package com.cap.capgeminibatch2.test;

import java.util.List;

import javax.persistence.NoResultException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cap.capgeminibatch2.capgeminibatch2.entities.Branch;
import com.cap.capgeminibatch2.exception.AlreadyExistsException;
import com.cap.capgeminibatch2.serviceimplementation.BranchServiceImplementation;

@SpringBootTest
class TestBranch {
	
	@Autowired
	BranchServiceImplementation branchServiceImplementation;
	

//	@Test
	public void testAddBranch() throws AlreadyExistsException {
		try {
			Branch branch=new Branch("abc","def");
			branchServiceImplementation.addBranch(branch);	
		}
		catch(NoResultException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testViewAllBranchDetails() {
		List<Branch> branches=branchServiceImplementation.viewAllBranchDetails();
		System.out.println(branches);
	}
	
	@Test
	public void testGetBranchDetailsByName() {
		String name="Computer Science";
	    branchServiceImplementation.getBranchDetailsByName(name);
	}
	
	@Test
	public void testDeleteBranchById() {
		int id=2;
		branchServiceImplementation.deleteBranchById(id);
		System.out.println("Branch deleted!");
	}
	
	@Test
	public void testGetBranchById() {
		int id=3;
		Branch branch=branchServiceImplementation.getBranchById(id);
		System.out.println(branch);
	}
	
	@Test
	public void testDeleteBranchByName() {
		String name="Electricals";
		branchServiceImplementation.deleteBranchByName(name);
		System.out.println("Branch deleted");
	}
	
	@Test
	public void testUpdateBranch() {
//		Branch branch=new Branch("Mechanical","Mechanical Systems");
		Branch branch=branchServiceImplementation.getBranchById(3);
		branch.setBranchName("EC");
		branchServiceImplementation.updateBranch(branch);
		System.out.println("Branch Updated");
	}



}

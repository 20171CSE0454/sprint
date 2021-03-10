package com.cap.capgeminibatch2.capgeminibatch2.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cap.capgeminibatch2.capgeminibatch2.entities.Branch;

@Repository
public interface IBranchRepository extends JpaRepository<Branch,Integer>{
	
    public ArrayList<Branch> findByBranchName(String branchName);

	public Branch findByBranchId(int branchId);

}
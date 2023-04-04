package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.BankDetails;
@Repository
public interface BankRepository extends JpaRepository<BankDetails, Integer>{

	@Query("select bd.balance from BankDetails bd where bd.bid=?1")
	    public int findBalanceByID(int bid);
} 

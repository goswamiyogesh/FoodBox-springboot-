package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.BankDetails;
import com.example.demo.repository.BankRepository;

@Service
public class BankDAO {
@Autowired
private	BankRepository brepo ;

public BankDetails insert(BankDetails bd) {
	return brepo.save(bd);
}
public int findBalanceById(int id) {
	return brepo.findBalanceByID(id);
}
}

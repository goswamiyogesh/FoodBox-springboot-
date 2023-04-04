package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.BankDetails;

import com.example.demo.service.BankDAO;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/api/bank/")
public class BankController {
@Autowired
private BankDAO bdao;

@PostMapping("/addBank")
public ResponseEntity<BankDetails> addBank(@RequestBody BankDetails b){
	
	BankDetails bank= bdao.insert(b);
	
	if(bank!=null)

		return new ResponseEntity<BankDetails>(bank,HttpStatus.CREATED);
	else
		return new ResponseEntity<BankDetails>(bank,HttpStatus.INTERNAL_SERVER_ERROR);
	
}
@GetMapping("/getBankDetails/{id}")
public int getBankById(@PathVariable int id) {
	return bdao.findBalanceById(id);
}
}

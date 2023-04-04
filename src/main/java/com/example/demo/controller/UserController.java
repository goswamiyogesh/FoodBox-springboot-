package com.example.demo.controller;

import java.util.List;


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


import com.example.demo.model.User;
import com.example.demo.service.UserDAO;
@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/api/user/")
public class UserController {
@Autowired
	private UserDAO udao;

@PostMapping("/addUser")
public ResponseEntity<User> adduser(@RequestBody User u){
	
	User user= udao.addUser(u);
	
	if(user!=null)
		return new ResponseEntity<User>(user,HttpStatus.CREATED);
	else
		return new ResponseEntity<User>(user,HttpStatus.INTERNAL_SERVER_ERROR);
	
}
@GetMapping("/getAllUser")
public List<User> getAllUser(){
	return udao.getAllUser();
}

@GetMapping("/getUserByUsername/{username}")
public User getUser(@PathVariable String username) {
	return udao.findByUsername(username);
}
@GetMapping("/getAllUserByEmail/{keyword}")
public List<User> getAllUserByEmail(@PathVariable String keyword){
		return udao.findByEmail(keyword);

}
}
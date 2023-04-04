package com.example.demo.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserDAO {
@Autowired
private	UserRepository urepo;

public User addUser(User u) {
	return urepo.save(u);
}

public List<User> getAllUser(){
	return urepo.findAll();
}

public User findByUsername(String username) {
	return urepo.findByName(username);

}

public List<User> findByEmail(String keyword){
	return urepo.findByEmail(keyword);
	
}
}


	


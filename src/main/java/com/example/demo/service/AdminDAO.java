package com.example.demo.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Admin;
import com.example.demo.repository.AdminRepository;

@Service
public class AdminDAO {
@Autowired
	private AdminRepository  arepo;

public Admin addAdmin(Admin a) {
	return arepo.save(a);
}

public Admin findByUsername(String username) {
	return arepo.findByusername(username);

}

}
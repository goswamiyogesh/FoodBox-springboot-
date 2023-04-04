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
import com.example.demo.model.Admin;
import com.example.demo.service.AdminDAO;


@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/api/admin")
public class AdminController {
	@Autowired
	private AdminDAO adao;
	
	
	@PostMapping("/addAdmin")
	public ResponseEntity<Admin> addadmin(@RequestBody Admin a){
		
		Admin admin= adao.addAdmin(a);
		
		if(admin!=null)
			return new ResponseEntity<Admin>(admin,HttpStatus.CREATED);
		else
			return new ResponseEntity<Admin>(admin,HttpStatus.INTERNAL_SERVER_ERROR);

	}
	 
	@GetMapping("/getAdminByUsername/{username}")
	public Admin getAdmin(@PathVariable String username) {
		return adao.findByUsername(username);
	}
	
}

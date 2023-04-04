package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Admin;
@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{
	
	@Query("select a from Admin a where a.username=?1")
	  public Admin findByusername(String username);
}

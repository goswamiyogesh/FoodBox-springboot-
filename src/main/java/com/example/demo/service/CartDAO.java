package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Cart;
import com.example.demo.repository.CartRepository;

@Service
public class CartDAO {
	@Autowired
private	CartRepository crepo;
	
	public Cart insert(Cart c) {
		return crepo.save(c);
	}
	
	public List<Cart> findAll(){
		return crepo.findAll();
	}
	
	public boolean deleteAllFromCart() {
		crepo.deleteAll();
		return true;
	}
}

package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Cart;

import com.example.demo.service.CartDAO;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/api/cart/")
public class CartController {
@Autowired
private CartDAO cdao;

@PostMapping("/addToCart")
public ResponseEntity<Cart> addToCart(@RequestBody Cart c){
	
	Cart  cart= cdao.insert(c);
	
	if(cart!=null)

		return new ResponseEntity<Cart>(cart,HttpStatus.CREATED);
	else
		return new ResponseEntity<Cart>(cart,HttpStatus.INTERNAL_SERVER_ERROR);
	
}
@GetMapping("/getAllCart")
public List<Cart> getCart(){
	return cdao.findAll();
}
@DeleteMapping("/Delete")
public ResponseEntity<String> deleteAllFromCart(){
	boolean result=cdao.deleteAllFromCart();
	if(result)
		return new ResponseEntity<String>("Cart item Deleted",HttpStatus.OK);
	else
		return new ResponseEntity<String>("No Cart found to Delete",HttpStatus.NOT_FOUND);
				
}
}

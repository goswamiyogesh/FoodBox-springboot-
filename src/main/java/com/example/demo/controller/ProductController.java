package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.service.ProductDAO;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/api/product")
public class ProductController {
	@Autowired
private ProductDAO pdao;
	
	@PostMapping("/addProduct")
	public ResponseEntity<Product> addproduct(@RequestBody Product p){
		
		Product  product= pdao.insert(p);
		
		if(product!=null)

			return new ResponseEntity<Product>(product,HttpStatus.CREATED);
		else
			return new ResponseEntity<Product>(product,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@GetMapping("/getProductById/{id}")
	public Product getProductById(@PathVariable int id) {
		return pdao.findById(id);
}
	
	@GetMapping("/getAllProduct")
	public List<Product> getAllProduct(){
		return pdao.findAll();
	}
	@DeleteMapping("/productDelete/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable int id){
		boolean result=pdao.deleteProduct(id);
		if(result)
			return new ResponseEntity<String>("Product Deleted",HttpStatus.OK);
		else
			return new ResponseEntity<String>("No Product found to Delete",HttpStatus.NOT_FOUND);
					
	}
	@GetMapping("/productUpdate/{id}")
	public ResponseEntity<Object> updateProduct(@PathVariable int id,@RequestBody Product newpro){
		Product pro=pdao.updateProduct(id ,newpro);
		if(pro!=null)
			return new ResponseEntity<Object>("pro",HttpStatus.OK);
		else
			return new ResponseEntity<Object>("No Product found to Update",HttpStatus.NOT_FOUND);
					
}
	@GetMapping("/getAllProductByFoodname/{keyword}")
public List<Product> getAllProductByFoodname(@PathVariable String keyword){
		return pdao.findByFoodname(keyword);
		
	}
	@GetMapping("/getAllProductByCategory/{keyword}")
	public List<Product> getAllProductByCategory(@PathVariable String keyword){
		return pdao.findByCategory(keyword);
	}
}
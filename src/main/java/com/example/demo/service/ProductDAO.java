package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;

import com.example.demo.repository.ProductRepository;

@Service
public class ProductDAO {
@Autowired
private	ProductRepository prepo;

public Product insert(Product p) {
	return prepo.save(p);
}


public List<Product> findAll(){
	return prepo.findAll();
}

public Product findById(int id) {
	return prepo.findbyId(id);

}


public Product updateProduct(int id, Product newpro) {
	if(prepo.findById(id).isPresent()){
		Product oldpro= prepo.findById(id).get();
		oldpro.setFoodname(newpro.getFoodname());
		oldpro.setFoodprice(newpro.getFoodprice());
		oldpro.setCategory(newpro.getCategory());
		oldpro.setImagepath(newpro.getImagepath());
		
		return prepo.save(oldpro);
	}
	else {
		return null;
}
}
public boolean deleteProduct(int id) {
	if(prepo.findById(id).isPresent()){
	prepo.deleteById(id);	
	return true;
	}
	else {
		return false;
	}
}
public List<Product> findByFoodname(String keyword){
	return prepo.findByFoodname(keyword);
	
}
public List<Product> findByCategory(String keyword){
	return prepo.findByCategory(keyword);
}
}

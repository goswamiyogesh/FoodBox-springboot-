package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
@Query("select p from Product p where p.foodname=?1")
public List<Product> findByFoodname(String keyword);

@Query("select p from Product p where p.category=?1")
public List<Product> findByCategory(String keyword);

@Query("select p from Product p where p.id=?1")
public Product findbyId(int id);
}


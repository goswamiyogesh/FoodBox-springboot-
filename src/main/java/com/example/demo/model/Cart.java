package com.example.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


import lombok.Data;
@Data
@Entity

public class Cart {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	private int id; 
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="product_id")
	private Product pro;
}

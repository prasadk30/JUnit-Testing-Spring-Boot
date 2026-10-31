package com.testing.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {
	
	 	@Id
	    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
	    private Long id;

	    private String name;

	    private double price;

	    private int stock;
}

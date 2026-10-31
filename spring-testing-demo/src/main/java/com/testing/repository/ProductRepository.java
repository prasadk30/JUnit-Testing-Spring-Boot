package com.testing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testing.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	boolean existsByName(String name);
}

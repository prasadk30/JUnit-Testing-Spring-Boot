package com.testing.service;

import org.springframework.stereotype.Service;

import com.testing.entity.Product;
import com.testing.repository.ProductRepository;

@Service
public class ProductService {
	
	private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    
    public Product getProductById(Long id) {

        return productRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Product not found: " + id)
                );
    }

    public Product createProduct(Product product) {

        boolean alreadyExists =
                    productRepository.existsByName(product.getName());

        if (alreadyExists) {
            throw new IllegalArgumentException(
                    "Product already exists"
            );
        }

        return productRepository.save(product);
    }
}

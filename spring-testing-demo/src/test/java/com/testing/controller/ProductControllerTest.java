package com.testing.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.testing.entity.Product;
import com.testing.service.ProductService;

@WebMvcTest
public class ProductControllerTest {
	 	
	@Autowired
	private MockMvc mockMvc;
	
	@MockitoBean
	private ProductService productService;
	
	@Test
	void shouldReturnProductIfProductExist() throws Exception {
		// Arrange
		
		Product product =
				new Product(1L,"Laptop",50000,10);
		
		when(productService.getProductById(1L))
		.thenReturn(product);
		

		// Act 
		mockMvc.perform(
				get("/api/product/1")
					.accept(MediaType.APPLICATION_JSON) 
				
				) .andExpect(status().isOk())
				  .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				  .andExpect(jsonPath("$.id").value(1))
				  .andExpect(jsonPath("$.name").value("Laptop"))
				  .andExpect(jsonPath("$.price").value(50000))
				  .andExpect(jsonPath("$.stock").value(10));
						  
		verify(productService).getProductById(1L);
		
		
		// Assert
	}
	 
}

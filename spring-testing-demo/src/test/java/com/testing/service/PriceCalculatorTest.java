package com.testing.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PriceCalculatorTest {
	
	private PriceCalculator priceCalculator;
	
	@BeforeEach
	void setup() {
		priceCalculator =new PriceCalculator();
	}
	
	@Test
	void shouldApplyDiscountToPrice() {
		// arrange -> Initial Input  
		double price = 1000;
		double discount=20;
		
				
		//Action -> Action performed
		double actualPrice = priceCalculator.calculatePrice(price, discount);
		
		
		// assertion -> Expected output
		assertEquals(800,actualPrice);
		//assertEquals(700,actualPrice);
				
	}
	
	@Test
	void shouldRejectDiscountAboveHundred() {
		
		IllegalArgumentException exception =
				assertThrows(IllegalArgumentException.class, 
				() -> priceCalculator.calculatePrice(100, 120));
		
		assertEquals("Discount should be within 0 to 100", 
				exception.getMessage());
	}
}

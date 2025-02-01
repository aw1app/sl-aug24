package com.sl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {

	@Test
	void testAdd() {
		Calculator cal = new Calculator();
		
		int input1 = 4;
		int input2 = 5;
		
		int result = cal.add(input1, input2); // should be 9
		
		assertEquals(result, 9);		
	}
	
	//CHALLENGE: Write a TC for Divide method 

}

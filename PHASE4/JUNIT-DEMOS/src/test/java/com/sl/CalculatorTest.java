package com.sl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {

	@Test
	void testAdd() {
		Calculator cal = new Calculator();
		
		int input1 = 4;
		int input2 = 5;
		
		int expectedResult = 9;
		
		int result = cal.add(input1, input2); // should be 9
		
		assertEquals(result, expectedResult);		
	}
	
	@Test
	void testAdd1() {
		Calculator cal = new Calculator();
		
		int input1 = 11;
		int input2 = -25;
		
		int expectedResult = -14;
		
		int result = cal.add(input1, input2); // should be -14
		
		assertEquals(result, expectedResult);		
	}
	
	//CHALLENGE: Write a TC for Divide method 

}

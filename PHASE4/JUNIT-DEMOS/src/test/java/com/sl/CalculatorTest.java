package com.sl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;


class CalculatorTest {
	Calculator cal;

	@BeforeEach
	void myBeforeEach() {
		System.out.println(" INSIDE myBeforeEach. This method will run before each test case in this class  ");
		cal = new Calculator();
	}
	
	@AfterEach
	void myAfterEach() {
		System.out.println(" INSIDE myAfterEach. This method will run after each test case in this class  ");
		cal = null;
	}


	@Test
	void testAdd1() {
		System.out.println(" INSIDE testAdd1 TC");
		//Calculator cal = new Calculator();

		int input1 = 4;
		int input2 = 5;

		int expectedResult = 9;

		int result = cal.add(input1, input2); // should be 9

		assertEquals(expectedResult , result );
	}

	@Test
	@Disabled
	void testAdd2() {
		System.out.println(" INSIDE testAdd2 TC");
		//Calculator cal = new Calculator();

		int input1 = 11;
		int input2 = -25;

		int expectedResult = -14;

		int result = cal.add(input1, input2); // should be -14

		assertEquals(expectedResult , result );
	}

	// CHALLENGE: Write a TC for Divide method

}

package com.sl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ParameterizedDemo {

	
	@ParameterizedTest
	@CsvSource(
			{ 
				"1, 1, 2",
				"-2, 3, 1",
				"10, -5, 5" 
			}
			)
	void test(int a, int b, int expectedResult) {
		System.out.printf("Adding %s and %s ", a, b);
		
		Calculator calulator1 = new Calculator();

		int actualResult = calulator1.add(a, b);
		
		System.out.printf("resulted in %s \n ", actualResult);
		
		assertEquals(expectedResult, actualResult);

	}

}

package com.sl;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class AssertionsDemo {
	
	@Test
	void test() {
		
		String str = null;
		String str2 = "some value";
		
		String[] a1 = { "A", "B" };
		String[] a2 = { "A", "B" };
		
		int a = 4;
		int b = 0;
		
		assertTrue(a > b);
		
		assertFalse(5 < 1);
		
		assertNull(str);
		assertNotNull(str2);
		
		
		assertSame(str, str);
		assertNotSame(str, str2);
		
		assertEquals(5, 5);
		assertNotEquals(5, 6);
		
		assertArrayEquals(a1, a2);
		
		assertThrows(ArithmeticException.class, () -> {
			new Calculator().divide(10, 1);
		});		
		
	}
	

}

package com.beepscore.LongFromString;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.beepscore.LongFromString.LongFromString;

public class LongFromStringTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLongDirectFromString() {
		//fail("Not yet implemented");
	}

	@Test
	public void testIntDigitFromChar() {
		//fail("Not yet implemented");
	}

	@Test
	public void testTenToIntPower() {
		//fail("Not yet implemented");
	}

	@Test
	public void testLongFromString() {

		long actual;
		actual = LongFromString.longFromString("123");
		assertTrue(123 == actual);

		
//		assertTrue(0 == HelloWorld.addFive(-5.0));

	}

}

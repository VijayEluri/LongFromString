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

		long expected = 123;
		long actual;
		actual = LongFromString.longFromString("123");
		assertTrue(expected == actual);

		assertTrue(0 == LongFromString.longFromString("0"));
		assertTrue(-1 == LongFromString.longFromString("-1"));
		
		// must add suffix L to force literal to be long not integer
		// ref http://java.sun.com/docs/books/jls/third_edition/html/lexical.html#3.10.1		
		assertTrue(9223372036854775807L == LongFromString.longFromString("9223372036854775807"));

		assertTrue(Long.MAX_VALUE == LongFromString.longFromString("9223372036854775807"));

	}

}

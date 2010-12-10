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
		
		// duplicate tests from testLongFromString
		long expected = 123;
		long actual;
		actual = LongFromString.longDirectFromString("123");
		assertTrue(expected == actual);

		assertTrue(0 == LongFromString.longDirectFromString("0"));
		assertTrue(-1 == LongFromString.longDirectFromString("-1"));
		
		// must add suffix L to force literal to be long not integer
		// ref http://java.sun.com/docs/books/jls/third_edition/html/lexical.html#3.10.1		
		assertTrue(9223372036854775807L == LongFromString.longDirectFromString("9223372036854775807"));

		assertTrue(Long.MAX_VALUE == LongFromString.longDirectFromString("9223372036854775807"));
	}

	@Test
	public void testIntDigitFromChar() {

		int expected = 0;
		int actual;
		actual = LongFromString.intDigitFromChar('0');
		assertTrue(expected == actual);

		assertTrue(1 == LongFromString.intDigitFromChar('1'));
		assertTrue(2 == LongFromString.intDigitFromChar('2'));
		assertTrue(9 == LongFromString.intDigitFromChar('9'));
		
		
		// if error, intDigitFromChar should return -1
		assertTrue(-1 == LongFromString.intDigitFromChar('a'));
		assertTrue(-1 == LongFromString.intDigitFromChar('x'));

		// I tried pasting a Chinese character, couldn't save file!
		// Need to prefix with escape character.		
		
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

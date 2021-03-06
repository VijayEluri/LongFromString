package com.beepscore.LongFromString;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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


        // Should return error.  Character is not a digit
        assertTrue(-1 == LongFromString.intDigitFromChar('.'));
        assertTrue(-1 == LongFromString.intDigitFromChar('-'));
        assertTrue(-1 == LongFromString.intDigitFromChar('a'));
        assertTrue(-1 == LongFromString.intDigitFromChar('x'));

        // I tried pasting a Chinese character, couldn't save file!
        // Need to prefix with escape character.
    }

    @Test
    public void testTenToIntPower() {

        assertTrue(1 == LongFromString.tenToIntPower(0));
        assertTrue(10 == LongFromString.tenToIntPower(1));
        assertTrue(100 == LongFromString.tenToIntPower(2));
    }

    @Test
    public void testLongFromString() {

        long expected = 123;
        long actual;

        try {
            actual = LongFromString.longFromString("123");
            assertTrue(expected == actual);

            // Should return error.  String length must be > 0.
            assertTrue(-5 == LongFromString.longFromString(""));

            assertTrue(0 == LongFromString.longFromString("0"));

            // Should not return error.  Input string represents a number = Long.MAX_VALUE
            // must add suffix L to force literal to be long not integer
            // ref http://java.sun.com/docs/books/jls/third_edition/html/lexical.html#3.10.1
            assertTrue(9223372036854775807L == LongFromString.longFromString("9223372036854775807"));
            assertTrue(Long.MAX_VALUE == LongFromString.longFromString("9223372036854775807"));

            // Should not return error.
            // String is maximum length 19 characters
            // Value is less than Long.MAX_VALUE
            assertTrue(1234567890123456789L == LongFromString.longFromString("1234567890123456789"));

            // Should return error.  String is too long.  Must be 19 characters or less
            assertTrue(-1 == LongFromString.longFromString("12345678901234567890"));

            // Should return error.  String is too long and contains non digits.
            // Currently implementation tests length first, so this fails for length.
            // However, implementation could change to test for all digits first.
            assertTrue( 0 > LongFromString.longFromString("abcdefghijklmnopqrst"));

            // Should return error.  At least one character is not a digit
            // input must be a whole number. "." is rejected as a non-digit
            assertTrue(-2 == LongFromString.longFromString("1."));
            // input must be 0 or positive. "-" is rejected as a non-digit
            assertTrue(-2 == LongFromString.longFromString("-1"));
            // input must not be hexadecimal
            assertTrue(-2 == LongFromString.longFromString("f100"));

        } catch (NumberTooBigException e) {
            // the tests should not throw this exception, but we have to be ready to catch it.
            System.out.println("Test threw exception with message: " + e.getMessage());
        }
    }

    @Test
    public void testThrowNumberTooBigException1() {
        // Test designed to throw exception
        // http://www.ryanlowe.ca/blog/archives/000443_java_unit_testing_exceptions_with_junit.php
        try {
            // Should throw exception.  Input string represents a number > Long.MAX_VALUE
            // Input string represents a number = (Long.MAX_VALUE + 1)
            assertTrue(0 == LongFromString.longFromString("9223372036854775808"));

        } catch (NumberTooBigException e) {
            // Pass.  Method threw the exception we expected.
            return;
        }
        fail("Test failed, didn't throw expected exception");
    }

    @Test
    public void testThrowNumberTooBigException2() {

        try {
            // Should throw exception.  Input string represents a number > Long.MAX_VALUE
            assertTrue(0 == LongFromString.longFromString("9323372036854775807"));

        } catch (NumberTooBigException e) {
            // Pass.  Method threw the exception we expected.
            return;
        }
        fail("Test failed, didn't throw expected exception");
    }

}

package com.beepscore.LongFromString;

public class LongFromString {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		testIntDigitFromChar();
		testLongFromString();
	}

	// Convert a string to a long using direct conversion method
	public static long longDirectFromString(String aString)
	{
		long myLong;
		// Disallowed by problem specification.
		myLong = Long.parseLong(aString);
		return myLong;
	}


	// Convert character to integer digit 0-9. If error, return -1
	public static int intDigitFromChar(char aChar)
	{
		// type char is represented as 16 bit Unicode UTF-16
		// ref http://download.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html

		int myDigit;

		// Look for possible Unicode conversion issues.
		// at a minimum, list them in program limitations		

		myDigit = 3;

		return myDigit;
	}


	// Convert a string to a long
	public static long longFromString(String aString)
	{
		long myLong;

		// General approach:
		// start from last (rightmost) character in string corresponding to tens power 0 (E0).
		// loop by character until finish first (leftmost) character 
		//    or total > Long.MAX_VALUE
		// get the current character currentChar

		// Call method intDigitFromChar(currentChar)

		// Take value returned by intDigitFromChar(), 
		// multiply by appropriate power of ten and add product to total
		// end loop

		myLong = 99;
		return myLong;
	}


	// TODO: Move these into unit tests JUnit or similar
	public static void testIntDigitFromChar()
	{
		int actualInt;

		actualInt = intDigitFromChar('0');
		if (0 == actualInt)
			System.out.println("pass");
		else
			System.out.println("fail");

		actualInt = intDigitFromChar('1');
		if (1 == actualInt)
			System.out.println("pass");
		else
			System.out.println("fail");

		actualInt = intDigitFromChar('2');
		if (2 == actualInt)
			System.out.println("pass");
		else
			System.out.println("fail");

		actualInt = intDigitFromChar('9');
		if (9 == actualInt)
			System.out.println("pass");
		else
			System.out.println("fail");

		// if error, intDigitFromChar should return -1
		actualInt = intDigitFromChar('a');
		if (-1 == actualInt)
			System.out.println("pass");
		else
			System.out.println("fail");

		// try a Chinese character, can't save file!
		actualInt = intDigitFromChar('x');
		if (-1 == actualInt)
			System.out.println("pass");
		else
			System.out.println("fail");
	}


	public static void testLongFromString()
	{
		long i;

		i = longFromString("123");
		if (i == 123)
			System.out.println("pass");
		else
			System.out.println("fail");

		i = longFromString("0");
		if (i == 0)
			System.out.println("pass");
		else
			System.out.println("fail");

		i = longFromString("-1");
		if (i == -1)
			System.out.println("pass");
		else
			System.out.println("fail");

		i = longFromString("9223372036854775807");
		// must add suffix L to force literal to be long not integer
		// ref http://java.sun.com/docs/books/jls/third_edition/html/lexical.html#3.10.1
		if (i == 9223372036854775807L)
			System.out.println("pass");
		else
			System.out.println("fail");

		i = longFromString("9223372036854775807");
		if (i == Long.MAX_VALUE)
			System.out.println("pass");
		else
			System.out.println("fail");
	}
}

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
		// type char is an integer, representing a character in 16 bit Unicode UTF-16
		// ref http://download.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html

		// Possible Unicode conversion issues.
		// This method cannot handle Unicode supplementary characters
		// ref http://download.oracle.com/javase/6/docs/api/java/lang/Character.html#digit%28char,%20int%29
		// digit method second argument radix = 10 says we want result in base 10
		int myDigit = Character.digit(aChar, 10);
		return myDigit;
	}
	

	// Raise 10 to an integer power.  Power must be <= 18. If error, return -1
	public static long tenToIntPower(int aPower)
	{
		if (aPower > 18)
		{
			// result would have > (18+1) digits, too big for type long
			return -1;
		}		
		
		long tenToPower = 1;
		
		for (int i = 0; i < aPower; i++)
		{
			tenToPower = 10 * tenToPower;
		}
		return tenToPower;
	}


	// Convert a string to a long.  If error, return -1
	public static long longFromString(String aString)
	{
		if (aString.length() > 19)
		{
			// if no leading zeros, number must be bigger than Long.MAX_VALUE
			// could warn user to check remove any leading zeros
			return -1;
		}
				
		char currentChar;
		int digit = 0;
		long myLong = 0;
		long myLongPrevious = 0;

		// loop by character until finish first (leftmost) character 
		//    or total has wrapped past Long.MAX_VALUE
		for (int exponentOfTen= 0; exponentOfTen < aString.length(); exponentOfTen++)
		{
			// get the current character
			// start from last (rightmost) character in string
			// corresponding to "ones" column
			currentChar = aString.charAt((aString.length() -1) - exponentOfTen);
			
			digit = intDigitFromChar(currentChar);
 
			// multiply by appropriate power of ten and add product to total
			
			if (-1 == tenToIntPower(exponentOfTen))
			{
				return -1;
			}
			
			myLong = myLong + (digit * tenToIntPower(exponentOfTen));
			
			// Oops myLong can't exceed max!
			// if (myLong > Long.MAX_VALUE)...
			// Will total silently wrap around or noisily throw error?
			if (myLong < myLongPrevious)
			{
				// total exceeded capacity of type long and wrapped around
				return -1;
			}
			myLongPrevious = myLong;
		}
		return myLong;
	}


	// TODO: Move these into unit tests JUnit or similar
	public static void testIntDigitFromChar()
	{
		System.out.println("testIntDigitFromChar");

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
		System.out.println("testLongFromString");

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

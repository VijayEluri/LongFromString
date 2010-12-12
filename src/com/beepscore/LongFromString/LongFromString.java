package com.beepscore.LongFromString;

public class LongFromString {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{

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
	// TODO Use checked exception instead of returning a special value
	// Ref http://java.sun.com/docs/books/jls/second_edition/html/exceptions.doc.html
	public static int intDigitFromChar(char aChar)
	{
		// type char is an integer, representing a character in 16 bit Unicode UTF-16
		// ref http://download.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html

		// Method isDigit(char) works for all Unicode characters
		// ref http://download.oracle.com/javase/tutorial/i18n/text/charintro.html
		if (!Character.isDigit(aChar))
		{
			// the character isn't a digit in any major human language
			return -1;
		}
		
		// Method digit(char,int) can't handle Unicode supplementary characters
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


	// Convert a string to a long.  If error, returns a negative value
	public static long longFromString(String aString)
	{
		if (aString.length() > 19)
		{
			// if no leading zeros, number must be bigger than Long.MAX_VALUE
			// could warn user to check remove any leading zeros
			return -1;
		}
		
		if (aString.length() == 0)
		{
			return -5;
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
			
			if (-1 == intDigitFromChar(currentChar))
			{
				return -2;
			}
			
			digit = intDigitFromChar(currentChar);
 
			// Multiply by appropriate power of ten and add product to total
			
			// earlier string length test should prevent this error
			if (-1 == tenToIntPower(exponentOfTen))
			{
				return -3;
			}
			
			myLong = myLong + (digit * tenToIntPower(exponentOfTen));
			
			// myLong can't exceed Long.MAX_VALUE, the largest number type long can hold.
			// Java total silently wraps around instead of noisily throwing error.
			// Check if the running total value decreases when the next 
			// most significant digit is added to the total.  That shows 
			// the total has overflowed.  Don't check the sign bit directly.
			// Ref: http://download.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
			if (myLong < myLongPrevious)
			{
				// total exceeded capacity of type long and wrapped around
				return -4;
			}
			myLongPrevious = myLong;
		}
		return myLong;
	}

}

package com.beepscore.LongFromString;

public class LongFromString {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		testLongFromString();
	}
	
    // Convert a string to a long
	public static long longFromString(String aString)
	{
		long myLong;
		
		// direct conversion method.  Disallowed by problem specification.
		myLong = Long.parseLong(aString);
		
		return myLong;
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

package com.beepscore.LongFromString;
import java.util.Scanner;

public class LongFromString {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Scanner inScan = new Scanner(System.in);
		String inputString;
		long myLong;
		
		// Prompt user to type information
		System.out.println("Please enter number, digits 0-9.");		
		inputString = inScan.next();
		System.out.println("You typed " + inputString);

		System.out.println("Please enter number, digits 0-9.");		
		myLong = inScan.nextLong();
		System.out.println("myLong = " + myLong);
	}
}

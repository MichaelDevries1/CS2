package toolbox;

import java.util.Scanner;

public class MyTools {
	
//====================================================================
//================= Template for Method Documentation ================
//====================================================================

// Replace <bracketed items>

/** 	<Method Name>
     <Method Purpose>
            
     Spec Reference

     Input
       @param
         
     Process    1.
                2.
                3.
         
     Output
       @return
         
     Note       (Special comments about the method: usage, behavior, etc.)
*/

	
	public MyTools () { }
//=========================================================
/*	File Location
 * 	This method requests the name of a file.
 * 	
 * 	Output
 * 	  @Scanner string
 */
	public String fileLocation (Scanner scn) {
		p("What is the location and name of your file?", 2);
		String file = scn.next();
		
		return file;
	} // end location
//=========================================================
/*	Prime Check
 * 	This method returns true if a number is a prime
 * 
 *  	Input:
 *  		@param	The number to check.
 *  
 *  	Process:
 *  		1. Check if the number is 2 (the only even prime)
 *  		2. Check every odd number from 3 to the 
 *  			square root of n
 *  
 *  	Output:
 *  		@return	True or False on whether the 
 *  					number is prime or not	
 *  	
 *  Note: Code made by Oscar Sanchez.
 *  	https://www.mkyong.com/java/how-to-determine-a-prime-number-in-java/
 */
	
	public boolean primeCheck (int n) {		
		if (n % 2 == 0) return false;
		for (int i = 3; i*i <= n; i+=2) {
			if (n % i == 0) {
				return false;
			} // end if
		} // end for
		return true;
	} // end primeCheck
//=========================================================
	public int closestPrime (int n) {
		int num1 = 0;
		int num2 = 0;
		StringBuffer result = new StringBuffer("");
		
		for (int i = 0;; i++) {
			if (primeCheck(n+i)) {
				num1 = n + i;
				break;
			} // end if
			if (primeCheck(n-i)) {
				num2 = n - i;
				break;
			} // end if
		} // end for
		
		if (!primeCheck(n)) {
			result.append("The number you input is not prime. "
					+ "The nearest prime number is ");
			if (num1 > num2) {
				result.append(num1 + ".");
				p (result, 1);
				return num1;
			} else {
				result.append(num2 + ".");
				p (result, 1);
				return num2;
			} // end if/else
		} else {
			result.append("Your number is Prime!");
			p (result, 1);
			return n;
		} // end if/else
	} // end closestPrime
//=========================================================
	public int sumAscii (String s) {
		int sum = 0;
		
		for (int i = 0; i < s.length(); i++) {
			sum =+ (int) s.charAt(i);
		} // end for
		return sum;
	} // end sumAscii
//=========================================================

//=========================================================
	public void p (String s, int n) {
		if (n == 1) {
			System.out.println(s);
		} else {
			System.out.print(s);
		} // end if/else
	} // end String p
//=========================================================
	public void p (StringBuffer s, int n) {
		if (n == 1) {
			System.out.println(s);
		} else {
			System.out.print(s);
		} // end if/else
	} // end StringBuffer p
} // end MyTools

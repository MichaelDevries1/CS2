/* Program: Merge and Internal Sorts using Random Numbers and Strings
   Created by:  Michael DeVries
   Created on: 10/2017
   This program requests the length of a list and the range that the random number generator can fill the lists with. It fills 3 lists 
   	with integers, doubles, and strings and times them during a user made merge sort and an internal sort of java. It produces a 
   	table with the time results.
*/

package hw6;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class HW6 {
	public static void main (String[] args) {
		Scanner scn = new Scanner(System.in);
		int i = 0;												// Counter
		int size = 0;												// Size of the array
		int big = -1;												// Range size
		StringBuffer results = new StringBuffer();						// The collection of the results
		
		// Create the merge instances
		MergeSort<Integer> iMerge = new MergeSort<>();
		MergeSort<Double> dMerge = new MergeSort<>();
		MergeSort<String> sMerge = new MergeSort<>();
		
		// Request size
		sop("What is the size of the list? (Numbers greater than 0.)");
		while (size <= 0) {											// Check if the size is valid
			size = scn.nextInt();
			if (size <= 0) {
				sop("***Invalid number. Please enter a number greater than 0.***");
			} // end if
		} // end while
		// Request big
		sop("What is the range of your value? (0-?)");
		while (big < 0) {											// Check if the value is less than 0
			big = scn.nextInt();
			if (big < 0) {
				sop("***Invalid number. Please enter a number greater than 0.***");
			} // end if
		} // end while
		
		
		// Create the Arrays
		Integer[] iArr = new Integer[size];
		Double[] dArr = new Double[size];
		String[] sArr = new String[size];
		
		// Fill the arrays
		for (i = 0; i < size; i++) {
			iArr[i] = fill(big);
			dArr[i] = fill((double) big);
			sArr[i] = fill();
		} // end for
		
		// Printing for testing
		//test(iArr, dArr, sArr, size);
		
		// Time the merge sorts
		// Start time
		long swMerge = System.currentTimeMillis();
		long scMerge = System.nanoTime();
		// use the user created merge sort
		iMerge.sort(iArr, 0, iArr.length - 1);
		dMerge.sort(dArr, 0, dArr.length - 1);	
		sMerge.sort(sArr, 0, sArr.length - 1);
		// End time
		long ewMerge = System.currentTimeMillis();
		long ecMerge = System.nanoTime();
		
		// Printing for testing
		//test(iArr, dArr, sArr, size);
		
		// Fill the arrays again
		for (i = 0; i < size; i++) {
			iArr[i] = fill(big);
			dArr[i] = fill((double) big);
			sArr[i] = fill();
		} // end for
		
		// Time the internal sorts
		// Start time
		long swInternal = System.currentTimeMillis();
		long scInternal = System.nanoTime();
		// Use the Internal sort 
		Arrays.sort(iArr);
		Arrays.sort(dArr);
		Arrays.sort(sArr);
		// End time
		long ewInternal = System.currentTimeMillis();
		long ecInternal = System.nanoTime();
		
		// Calculate times
		long MergeWTime = ewMerge - swMerge;
		long MergeCTime = ecMerge - scMerge;
		
		long internalWTime = ewInternal - swInternal;
		long internalCTime = ecInternal - scInternal;
		
		// Add the times to the print string
		results.append("Wall Time: \n\tMerge:    " + 
				String.format("%02d min %02d sec", 
				TimeUnit.MILLISECONDS.toMinutes(MergeWTime),
				TimeUnit.MILLISECONDS.toSeconds(MergeWTime) - 
				TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(MergeWTime))) + 
				"\n\tInternal:  " +
				String.format("%02d min %02d sec", 
				TimeUnit.MILLISECONDS.toMinutes(internalWTime),
				TimeUnit.MILLISECONDS.toSeconds(internalWTime) - 
				TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(internalWTime))) + 
				"\n\nCPU Time: \n\tBubble:    " + MergeCTime + 
				" nanoseconds\n\tInternal:  " + internalCTime +
				" nanoseconds");

		sop(results);													// Display results
		
		// Close scanner
		scn.close();
	} // end main
//=========================================================================================================================================
	public static int fill (int big) {
		Random rand = new Random(System.nanoTime());							// Create a new RNG
		int num = rand.nextInt(big + 1);									// Generate the new integer
		return num;													// Place number in array
	} // end fill (int)
//=========================================================================================================================================
	public static double fill (double big) {
		Random rand = new Random(System.nanoTime());							// Create a new RNG
		double num = rand.nextDouble() * big;								// Generate the new double
		return num;													// Place number in array
	} // end fill (double)
//=========================================================================================================================================	
	public static String fill () {
		String s = new String();											// The current string
		String values = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";	// The characters available 
		Random rand = new Random(System.nanoTime());							// Create a new RNG
		
		while (s.length() < 6) {											// Create 6 new characters
			int current = (int) (rand.nextDouble() * values.length());			// Generate a new random number
			s = s + values.charAt(current);								// Add character at the random location into string
		} // end while
		
		return s;														// Place string in array
	} // end fill (String)
//=========================================================================================================================================
	public static void test(Integer[] iArr, Double[] dArr, String[] sArr, int size) {
		// The print statements for each element in the array
		for (int i = 0; i < size; i++) {									
			sop(iArr[i] + "\t" + dArr[i] + "\t" + sArr[i]);					// Print out each current value in all 3 arrays
		} // end for
		sop("");														// seperate the wald through from the normal results
	} // end test
//=========================================================================================================================================
	public static void sop (String s) { System.out.println(s); }			// General print statements
	public static void sop (StringBuffer s ) { System.out.println(s); }
} // end HW6

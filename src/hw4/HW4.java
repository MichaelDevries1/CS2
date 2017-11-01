/* Program: Bubble and Internal Sorts
   Created by:  Michael DeVries
   Created on: 10/2017
   This program requests a text file from the user and times bubble sort and java's internal sort. It produces the number of words
    	sorted and how fast each sort was achieved using both wall time and CPU time.
*/

package hw4;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.io.*;

public class HW4 {
	public static void main (String [] args) throws IOException {
		// Ask which file to use
		Scanner location = new Scanner (System.in);
		sop("What is the location and name of the file you wish to sort?");
		
		// Create string of the file
		String fileLocation = location.next();  
		@SuppressWarnings("resource")
		String fullBook = new Scanner (new FileReader(fileLocation)).useDelimiter("\\Z").next();
		
		// Create Results buffer
		StringBuffer results = new StringBuffer("Filename: ");
		results.append(fileLocation + "\n");
		
		// Remove all special characters and returns
		fullBook = fullBook.replaceAll("[-+.^:,\"*/()@;\'?$%&!_\t]","");
		fullBook = fullBook.replaceAll("\\s+", " ");
		

		// Split string into arrays and duplicate
		String[] bubbleList = fullBook.trim().split(" ");
		String[] javaList = new String[bubbleList.length];
		
		for (int i = 0; i < javaList.length; i++) {
			javaList[i] = bubbleList[i];
		}
		
		// Add number of words to results
		results.append("Number of Words: " + javaList.length + "\n");
																	// Start times:
		long bubbleWST = System.currentTimeMillis();							// Wall time
		long bubbleCST = System.nanoTime();								// CPU time
		bubbleSort(bubbleList);											// Use bubble sort
																	// End times:
		long bubbleWET = System.currentTimeMillis();							// Wall time
		long bubbleCET = System.nanoTime();								// CPU time
		
																	// Start times:
		long javaWST = System.currentTimeMillis();							// Wall time
		long javaCST = System.nanoTime();									// CPU time
		Arrays.sort(javaList);											// Use Built-in sort
																	// End times:
		long javaWET = System.currentTimeMillis();							// Wall time
		long javaCET = System.nanoTime();									// CPU time
		
		// Calculate bubble time
		long bubbleWTime = (bubbleWET - bubbleWST)/1000;
		long bubbleCTime = (bubbleCET - bubbleCST);
		
		// Calculate built-in time 
		long javaWTime = (javaWET - javaWST)/1000;
		long javaCTime = (javaCET - javaCST);
		
		results.append("Wall Time: \n\tBubble:    " + 
				String.format("%02d min %02d sec", 
				TimeUnit.MILLISECONDS.toMinutes(bubbleWTime),
				TimeUnit.MILLISECONDS.toSeconds(bubbleWTime) - 
				TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(bubbleWTime))) + 
				"\n\tInternal:  " +
				String.format("%02d min %02d sec", 
				TimeUnit.MILLISECONDS.toMinutes(javaWTime),
				TimeUnit.MILLISECONDS.toSeconds(javaWTime) - 
				TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(javaWTime))) + 
				"\n\nCPU Time: \n\tBubble:    " +bubbleCTime + 
				" nanoseconds\n\tInternal:  " + javaCTime +
				" nanoseconds");

		sop(results);													// Display results
		
		location.close();
	} // end main
//=========================================================================================================================================
	static void bubbleSort(String[] arr) {  
		sop("**Working**");												// Verify that it is indeed running
	    String temp = "";  												// Temporary storage for sorting
	    for (int i = 0; i < arr.length - 1; i++) {								
            for (int j = 0; j < arr.length - i -1; j++) {
                if(arr[j + 1].compareTo(arr[j])<0) {							// Compare two objects 
                    temp = arr[j];											// Switch them if the +1 is greater
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                } // end if
            } // end for
        } // end for
	} // end bubbleSort
//=========================================================================================================================================
	public static void sop (String s) { System.out.println(s); } 				// General print statements
	public static void sop (StringBuffer s) { System.out.println(s); }
} // end HW4
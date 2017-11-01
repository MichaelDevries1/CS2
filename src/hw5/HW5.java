package hw5;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/* Program: Concordance of a text file
   Created by:  Michael DeVries
   Created on: 10/2017
   This program pulls in a text file and sorts the individual words counting how many times each word was used and removing the duplicates.
   	It produces a file of the sorted words and how many times each word was used.
*/
public class HW5 {
	public static void main(String[] args) throws IOException {
		// Create output file
		PrintWriter output = new PrintWriter(new FileWriter("HW5.txt"));
		
		// Ask which file to use
		Scanner location = new Scanner (System.in);
		sop("What is the location and name of the file you wish to sort?");
		
		// Create string of the file
		String fileLocation = location.next();  
		@SuppressWarnings ("resource")
		String fullBook = new Scanner (new FileReader(fileLocation)).useDelimiter("\\Z").next();

		// Create Results buffer
		StringBuffer results = new StringBuffer("Filename: ");
		results.append(fileLocation + "\n");
		
		// Remove all special characters and returns and make it all lower case
		fullBook = fullBook.replaceAll("[^a-zA-Z0-9'\\s]", "");
		fullBook = fullBook.replaceAll("\\s+", " ");
		fullBook = fullBook.toLowerCase();
		
		// Create ArrayList and Linked List
		List<WordCount> alConcord = new ArrayList<WordCount>();
		LinkedList<WordCount> llConcord = new LinkedList<WordCount>();
		
		// Create temporary lists
		List<String> word = new ArrayList<String>						// Split book into individual words
			(Arrays.asList(fullBook.split(" ")));
		List<String> unique = new ArrayList<String>();					// Create a temporary list for unique words
		
		alConcord = checkWord(alConcord, word, unique);					// Fill in and sort array list
		llConcord = checkWordLL(llConcord, word, unique);					// Fill in and sort linked list
		
		results.append("Number of words: " + alConcord.size());
		
		print(alConcord, results, output);								// Prints HW5.txt and console
		
			
		location.close();
	} // end main
//=========================================================================================================================================
	public static List<WordCount> checkWord (List<WordCount> arr, List<String> word, List<String> unique) {
		// Creates the array list
		unique = collectSort(word, unique);							// Finds unique words and sorts them
		
		Iterator<String> itr = unique.iterator();						// Create iterator for unique list
		
		while (itr.hasNext()) {										// Add unique words and their counts to arr
			String move = itr.next();								// Step through unique list
			int freq = Collections.frequency(word, move);				// Find number of times word was used in book
			WordCount temp = new WordCount(move, freq);					// Add word and count to new instance of WordCount
			arr.add(temp);											// Add the instance to arr
		} // end while
		
		return arr;												// Return filled array list
	} // end checkWord
//=========================================================================================================================================
	public static LinkedList<WordCount> checkWordLL (LinkedList<WordCount> list, 
			List<String> word, List<String> unique) {
		// Creates the linked list
		unique = collectSort(word, unique);							// Finds unique words and sorts them
		
		Iterator<String> itr = unique.iterator();						// Create iterator for unique list
		
		while (itr.hasNext()) {										// Add unique words and their counts to list
			String move = itr.next();								// Step through unique list
			int freq = Collections.frequency(word, move);				// Find number of times word was used in book
			WordCount temp = new WordCount(move, freq);					// Add word and count to new instance of WordCount
			list.add(temp);										// Add the instance to list
		} // end while
		
		return list;												// Return filled linked list
	} // end checkWordLL
//=========================================================================================================================================
	public static List<String> collectSort (List<String> word, List<String> unique) {
		Iterator<String> witr = word.iterator();						// Create iterator for word list

		while (witr.hasNext()) {										// Find unique words
			String newWord = (String) witr.next();						// Step through word list
			if (!unique.contains(newWord)) {							// Check if unique
				unique.add(newWord);								// if unique add to arr
			} // end if
		} // end while
		
		Collections.sort(unique);									// Sort unique list
		
		return unique;												// Return sorted unique words
	} // end collectSort
//=========================================================================================================================================
	public static void print (List<WordCount> arr, StringBuffer results, PrintWriter output) throws IOException {
		// Prints the results
		Iterator<WordCount> itr = arr.iterator();						// Create iterator for printing
		
		while (itr.hasNext()) {										// Print to HW5.txt 
			WordCount wc = itr.next();								// Step through the array list
			output.println(padString(wc.word, 20, "", " ") + wc.count);		// Print current word and count
		} // end while
		
		sop(results);												// Prints results on console
	}
//=========================================================================================================================================
	public static String padString(String str, int width, String padLeft, String padRight) { 
		// Create a pad to the left or right of a string for formating		
		String strPad = str;         // String to be returned
		int charsToPad;              // The number of characters to pad

		// Using the length of the String str, calculate the number of characters
		// to pad on the left. Note the number could be <= 0
		charsToPad = width - strPad.length();

		// Pad str by spaces on the left and/or right so that the
		// resulting length of strPad is 'width' characters
		for (int i = 0;  i < charsToPad;  i++) {
			strPad = padLeft + strPad + padRight;
		} // End for
		
		return strPad;
	} // end padString
//=========================================================================================================================================
	public static void sop (String s) { System.out.println(s); }			// General print statements
	public static void sop (StringBuffer s ) {System.out.println(s); }
	
} // end HW5

package hw7;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import toolbox.*;

public class HW7_ {
	
	static MyTools mt = new MyTools();									// Holds the tools for:
																// 	-requesting file name
																//   -print statements
																//	-ascii totals
	static UniqueItems ui = new UniqueItems();							// Holds the tools for:
																//	-obtaining the unique words
	
	public static void main (String[] args) {
		int prime = 0;												// Testing figure
		double alpha = 0.0;											// Testing figure
		
		String fullDocument = null;									// Full document to be scanned in
		List<String> unique = new ArrayList<>();						// List of unique words in document
		Scanner scn = new Scanner(System.in);							// Alpha and prime request
		
		// Testing values
		mt.sop("Alpha value ", 0);
		alpha = scn.nextDouble();
		mt.sop("What number would you like to hash with? ", 0);
		prime = scn.nextInt();
		
		prime = mt.closestPrime(prime);
		
		try {
			String location = mt.fileLocation();							// Users input file name
			Scanner file = new Scanner (new FileReader(location)).useDelimiter("\\Z");
			fullDocument = file.next();
			
			file.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} // end try/catch
		
		unique = ui.findUnique(fullDocument);
		
		HashTable_ ht = new HashTable_(alpha, unique.size());
		
		Iterator<String> itr = unique.iterator();
		
		while (itr.hasNext()) {
			String c = itr.next();
			ht.put(c, prime);
		} // end while
		
		try {
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream("UniqueHash.ser"));
			
			
			for (int i = 0; i < 5; i++) {
				out.writeObject(ht.table[i]);
			} // end for
			out.close();
		} catch (IOException i) {
			i.printStackTrace();
		} // end try/catch
	} // end main
} // end HW 7

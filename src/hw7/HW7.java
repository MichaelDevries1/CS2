package hw7;

import java.io.*;
import java.util.*;
import toolbox.*;

public class HW7 {
	
	static MyTools mt = new MyTools();									// Holds the tools for:
																// 	-requesting file name
																// 	-print statements
																// 	-ASCII totals
	static UniqueItems ui = new UniqueItems();							// Holds the tools for:
																// 	-obtaining the unique words
	
	public static void main (String[] args) {
		Scanner scn = new Scanner (System.in);
		String location = mt.fileLocation(scn);
		String fullDocument = null;
		List<String> unique = new ArrayList<>();
		final String TESTOUTPUT = "HW7out.txt";
		
		mt.p("What prime number would you like to hash with? ", 0);
		int prime = scn.nextInt();
		
		prime = mt.closestPrime(prime); 
				
		try {
			Scanner file = new Scanner (new FileReader(location)).useDelimiter("\\Z");
			fullDocument = file.next();
		} catch (FileNotFoundException e){
			e.printStackTrace();
		} // end Try/Catch
		
		try {
			PrintWriter out = new PrintWriter (new FileWriter(TESTOUTPUT));
		
		
		unique = ui.findUnique(fullDocument);
		
		Hashtable<Integer, String> internal = new Hashtable<Integer, String>(unique.size());
		MyHashTable h = new MyHashTable((int)(unique.size()/5.5));
		
		h.setPrime(prime);
		
		Iterator<String> itr = unique.iterator();
		
		while (itr.hasNext()) {
			String word = itr.next();
			h.put(word);
			internal.put(prime, word);
		} // end while
		
		out.println("Personal HashTable: ");
		for (int i = 0; i < h.size(); i++) {
			h.printList(i, out);
		} // end for
		
//		out.println("\n\nInternal HashTable: ");
//		for (int i = 0; i < 5; i++) {
//			out.print("\tKey " + i + ": ");
//			out.println("" + internal.get(i));
//		}
		out.close();
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		scn.close();
	} // end main
} // end 

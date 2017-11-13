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
			PrintWriter out = new PrintWriter (new FileWriter("HW7out.txt"));
		
		
		unique = ui.findUnique(fullDocument);
		
		MyHashTable h = new MyHashTable(unique.size());
		
		Iterator<String> itr = unique.iterator();
		
		while (itr.hasNext()) {
			String word = itr.next();
			h.put(word, prime);
		} // end while
		
		mt.p("Personal HashTable: ", 1);
		for (int i = 0; i < unique.size(); i++) {
			h.printList(i, out);
		} // end for
		
		out.close();
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		scn.close();
	} // end main
} // end 

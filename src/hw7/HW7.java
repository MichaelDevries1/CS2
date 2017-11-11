package hw7;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import toolbox.HashTable;
import toolbox.MyTools;
import toolbox.UniqueItems;

public class HW7 {
	
	static MyTools mt = new MyTools();									// Holds the tools for:
																// 	-requesting file name
																// 	-print statements
																// 	-ascii totals
	static UniqueItems ui = new UniqueItems();							// Holds the tools for:
																// 	-obtaining the unique words
	
	public static void main (String[] args) {
		Scanner p = new Scanner (System.in);
		String location = mt.fileLocation();
		String fullDocument = null;
		List<String> unique = new ArrayList<>();
		
		mt.sop("What prime number would you like to hash with? ", 0);
		int prime = p.nextInt();
		
		
		prime = mt.closestPrime(prime); 
				
		try {
			Scanner file = new Scanner (new FileReader(location)).useDelimiter("\\Z");
			fullDocument = file.next();
		} catch (FileNotFoundException e){
			e.printStackTrace();
		} // end Try/Catch
		
		unique = ui.findUnique(fullDocument);
		
		HashTable h = new HashTable(unique.size());
		
		Iterator<String> itr = unique.iterator();
		
		while (itr.hasNext()) {
			String word = itr.next();
			h.put(word, prime);
		} // end while
		
		for (int i = 0; i < unique.size(); i++) {
			h.printList(i);
		} // end for
		p.close();
	} // end main
} // end 

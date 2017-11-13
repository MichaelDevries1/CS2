package toolbox;

import java.io.PrintWriter;

public class MyHashTable {
	private MyLL[] hashArray;
	private int size;
	
	public MyHashTable (int n) {
		size = n;
		hashArray = new MyLL[size];
		for (int i = 0; i < size; i++) {
			hashArray[i] = new MyLL();
		} // end for
	} // end HashTable constructor
	
	//====================================================
	
	private int computeHash (String s, int prime) {
		int hash = 0;
		
		for (int i = 0; i < s.length(); i++) {
			hash += s.charAt(i);
		} // end for
		return hash % (size);
	} // end computeHash
	
	//====================================================
	
	public boolean containsString (String target, int prime) {
		int hash = computeHash(target, prime);
		MyLL list = hashArray[hash];
		if (!list.contains(target)) {
			return true;
		} // end if
		return false;
	} // end containsString
	
	//====================================================
	
	public void put (String s, int prime) {
		int hash = computeHash(s, prime);
		 MyLL list = hashArray[hash];
		 if (!list.contains(s)) {
			 hashArray[hash].addFirst(s);
		 } // end if
	} // end put
	
	//====================================================
	
	public void printList(int n) {
		MyLL list = hashArray[n];
		System.out.print("Key " + n + ":");
		if (!list.isEmpty()) {
			list.outputList();
		} // end if
		System.out.println("");
	} // end printList
	
	//====================================================
	
	public void printList(int n, PrintWriter p) {
		MyLL list = hashArray[n];
		p.print("Key " + n + ":");
		if (!list.isEmpty()) {
			list.outputList(p);
		} // end if
		p.println("");
	} // end printList
} // end HashTable Class
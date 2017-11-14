package toolbox;

import java.io.PrintWriter;

public class MyHashTable {
	private MyLL[] hashArray;
	private int size;
	private double alpha = 5.51;
	private int prime = 0;
	
	public MyHashTable (int n) {
		size = (int)(n/alpha);
		hashArray = new MyLL[size];
		for (int i = 0; i < size; i++) {
			hashArray[i] = new MyLL();
		} // end for
	} // end HashTable constructor
	
	//====================================================
	
	public void setPrime (int sp) {
		prime = sp;
	} // end setPrime
	
	//====================================================
	
	public int size () {
		return size;
	}
	//====================================================
	
	private int computeHash (String s) {
		int hash = 0;
		
		for (int i = 0; i < s.length(); i++) {
			hash += s.charAt(i);
		} // end for
		hash = hash % prime;
		
		while (hash > size) {
			hash -= size;
		} // end while
		
		return hash;
	} // end computeHash
	
	//====================================================
	
	public boolean containsString (String target) {
		int hash = computeHash(target);
		MyLL list = hashArray[hash];
		if (!list.contains(target)) {
			return true;
		} // end if
		return false;
	} // end containsString
	
	//====================================================
	
	public void put (String s) {
		int hash = computeHash(s);
		 MyLL list = hashArray[hash];
		 if (!list.contains(s)) {
			 hashArray[hash].addFirst(s);
		 } // end if
	} // end put
	
	//====================================================
	
	public void printList(int n) {
		MyLL list = hashArray[n];
		System.out.print("\tKey " + n + ": ");
		if (!list.isEmpty()) {
			list.outputList();
		} else {
			System.out.print("null");
		}// end if/else
		System.out.println("");
	} // end printList
	
	//====================================================
	
	public void printList(int n, PrintWriter p) {
		MyLL list = hashArray[n];
		p.print("\tKey " + n + ":");
		if (!list.isEmpty()) {
			list.outputList(p);
		} else {
			p.print("null");
		}// end if/else
		p.println("");
	} // end printList
} // end HashTable Class
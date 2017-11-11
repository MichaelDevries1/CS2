package toolbox;

public class HashTable {
	private MyLL[] hashArray;
	public int size;
	private int prime = 17;
	
	public HashTable (int size) {
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
		return hash % (size + prime);
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
} // end HashTable Class
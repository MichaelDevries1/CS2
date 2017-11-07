package toolbox;

public class HashTable {

	HashLink[] table;
	
	// Testing 
	public HashTable(double alpha, int size) {
		int len = (int) ((double) size / alpha);
		table = new HashLink[len];
		for (int i = 0; i < len; i++) {table[i] = null;}
	} // end constructor
//=========================================================
	public String get (int key, int prime) {
		int hash = key % prime;										// Calculate the prime
		if (table[hash] == null) {									// Check if the current hash's LL is null
			return null;
		} else {													// If the hash's LL is not null
			HashLink current = table[hash];							// Marks the current pointer in the LL
			while (current != null && current.getKey() != key) {			
				current = current.getNext();							// go to the next
			} // end while
			if (current == null) {
				return null;
			} else {
				return current.getValue();
			} // end if/else
		} // end if else
	}// end get
//=========================================================
	public void put (int key, String value, int prime) {
		int hash = key % prime;
		if (table[hash] == null) {
			table[hash] = new HashLink (key, value);
		} else {
			HashLink current = table[hash];
			while (current.getNext() != null && current.getKey() != key) {
				current = current.getNext();
			} // end while
			if (current.getKey() == key) {
				current.setValue(value);
			} else {
				current.setNext(new HashLink(key, value));
			} // end if/else
		} // end if/else
	} // end put
//=========================================================
	public void remove (int key, int prime) {
		int hash = key % prime;
		if (table[hash] != null) {
			HashLink prev = null;
			HashLink current = table[hash];
			while (current.getNext() != null && current.getKey() != key) {
				prev = current;
				current = current.getNext();
			} // end while
			if (current.getKey() == key) {
				if (prev == null) {
					table[hash] = current.getNext();
				} else {
					prev.setNext(current.getNext());
				} // end if/else
			} // end if
		} // end if
	} // end remove
} // end HashTable

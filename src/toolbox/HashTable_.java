package toolbox;

public class HashTable_ {

	public HashLink_[] table;
	
	// Testing 
	public HashTable_(double alpha, int size) {
		int len = size / 2 + (int) ((double) size / alpha);
		table = new HashLink_[len];
		for (int i = 0; i < len; i++) {table[i] = null;}
	} // end constructor
//=========================================================
	public String get (int key, int prime) {
		int hash = key % prime;										// Calculate the prime
		if (table[hash] == null) {									// Check if the current hash's LL is null
			return null;
		} else {													// If the hash's LL is not null
			HashLink_ current = table[hash];							// Marks the current pointer in the LL
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
	public void put (String value, int prime) {
		HashLink_ current = new HashLink_(value);
		int hash = current.getKey(value) % prime;
		
		if (table[hash] == null) {
			table[hash] = current;
		} else {
			current.setNext(table[hash]);
			table[hash] = current;
		} // end if/else
	} // end put
//=========================================================
} // end HashTable

package toolbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class UniqueItems {
	public UniqueItems () {	} // end constructor
//===================================================================
	public List<String> findUnique (String s) {
		return collectSort(splitToAL(onlyText(s)));
	} // end findUnique
//===================================================================
/*	 Removes all special character except ', converts it to 
	 	lowercase, and removes all separate lines.
*/
	public String onlyText (String s) {
		s.replaceAll("[^a-zA-Z0-9'\\s]", "");
		s.replaceAll("\\s+", " ");
		s.toLowerCase();
		return s;
	} // end onlyText
//===================================================================
/*	Creates an array list filled with individual words.
 */
	public List<String> splitToAL (String s) {
		List<String> wordList = new ArrayList<String> 
			(Arrays.asList(s.split(" ")));
		return wordList;
	} // end splitToAL
//===================================================================
	public static List<String> collectSort (List<String> word) {
		List<String> unique = new ArrayList<>();
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
} // end UniqueItems

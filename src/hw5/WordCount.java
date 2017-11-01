package hw5;

public class WordCount {
	public String word = null;
	public int count = 0;
	
	public WordCount () {} 
	
	public WordCount (String w, int c) {
		word = w;
		count = c;
	}
	
	public WordCount (String w) {
		word = w;
	}
	
	public WordCount (int c) {
		count = c;
	}
}

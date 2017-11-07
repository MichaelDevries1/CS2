package toolbox;

public class HashLink {
	private int key;
	private String value;
	private HashLink next;
	
	HashLink (int key, String value) {
		this.key = key;
		this.value = value;
		this.next = null;
	} // end constructor
//=========================================================
	public String getValue () {
		return value;
	} // end getValue
//=========================================================
	public void setValue (String value) {
		this.value = value;
	} // end setValue
//=========================================================
	public int getKey () {
		return key;
	} // end getKey
//=========================================================
	public HashLink getNext () {
		return next;
	} // end getNext
//=========================================================
	public void setNext (HashLink next) {
		this.next = next;
	} // end 
//=========================================================
	
}

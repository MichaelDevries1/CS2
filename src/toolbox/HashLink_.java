package toolbox;

public class HashLink_ implements java.io.Serializable {
	private int key;
	private String value;
	private HashLink_ next;
	
	MyTools mt = new MyTools();
	
	HashLink_ (String value) {
		this.key = mt.sumAscii(value);
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
	public int getKey (String Value) {
		return mt.sumAscii(value);
	} // end getKey
//=========================================================
	public HashLink_ getNext () {
		return next;
	} // end getNext
//=========================================================
	public void setNext (HashLink_ next) {
		this.next = next;
	} // end 
//=========================================================
}

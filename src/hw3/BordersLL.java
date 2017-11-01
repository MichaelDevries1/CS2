package hw3;

public class BordersLL {
	public String country1;
	public String country2;
	public BordersLL next;
	
	public void emptyNode() {
		this.next = null;
	} // end emptyNode
	
	public BordersLL (String c1, String c2) {
		this.country1 = c1;
		this.country2 = c2;
	} // end node
}

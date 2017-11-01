package hw2;

public class BordersLL extends Borders {
	public BordersLL next;
	
	public void emptyNode() {
		this.next = null;
	} // end emptyNode
	
	public void node (String c1, String c2, BordersLL next) {
		this.country1 = c1;
		this.country2 = c2;
		this.next = next;
	} // end node
}

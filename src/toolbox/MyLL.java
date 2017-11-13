package toolbox;

import java.io.PrintWriter;
import java.util.NoSuchElementException;

public class MyLL {
	private class Node {
		private String data;
		private Node next;
		
		public Node() {											// Creates an empty node
			this.data = null;
			this.next = null;
		} // end Node constructor
		
		//===============================================
		
		public Node (String newItem, Node nextNode) {						// Creates a filled node
			this.data = newItem;
			this.next = nextNode;
		} // end Node
	} // end Node class
//*******************************************************************************************************************************
	private class Iterator {
		private Node position;
		private Node previous;
		
		public Iterator () {
			position = head;
			previous = null;
		} // end Iterator constructor
		
		//===============================================
		
		public void restart () {
			position = head;
			previous = null;
		} // end restart
		
		//===============================================
		
		public boolean hasNext () {
			return (position != null);
		} // end hasNext
		
		//===============================================
		
		public String next () {
			if (!hasNext()) {
				throw new NoSuchElementException();
			} // end if
			
			String toReturn = position.data;
			previous = position;
			position = position.next;
			return toReturn;
		} // end next
		
		//===============================================
		
		public String peek () {										// Returns the next value to be returned by next
			if (!hasNext()) {
				throw new IllegalStateException();
			} // end if
			return position.data;
		} // end peek
	} // end Iterator
//*******************************************************************************************************************************
	private Node head;
	
	public MyLL() {
		head = null;
	} // end LinkedList constructor
	
	public void addFirst (String value) {								// Adds a node to the start of the list.
		head = new Node (value, head);								// This will be the first Node in the list
	} // end addFirst
	
	//===============================================
	
	public boolean deleteHead () {									// Deletes head node and returns true if the list
		if (head != null) {											// contained at least 1 node. False if the list
			head = head.next;										// is empty.
			return true;
		} else {
			return false;
		} // end if/else
	} // end deleteHead
	
	//===============================================
	
	public int size () {											// Gives the current size of the list
		int count = 0;
		Node position = head;										// Start the pointer at the head of the list
		
		while (position != null) {
			count++;												// Increments the counter by 1
			position = position.next;								// Move the pointer to the next position
		} // end while												
		
		return count;
	} // end size
	
	//===============================================
	
	public Node find (String target) {									// Finds a value within the list
		Node position = head;										// Start position at the head
		String itemPosition;											// Position of item
		
		while (position != null) {									// While it hasn't reached the end of the list
			itemPosition = position.data;								// The value of the current node
			if(itemPosition.equals(target)) {
				return position;									// Target was found
			} // end if
			position = position.next;
		} // end while
		
		return null;												// Target was not found
	} // end find
	
	//===============================================
	
	public boolean contains (String item) {									// True if its in the list
		return (find(item) != null);
	} // end contains
	
	//===============================================
	
	public String findData (String target) {									// Finds the first node containing the target
		Node result = find(target);								// and returns the reference to that node.
		if (result == null) {
			return null;
		} else {
			return result.data;
		} // end if/else
	} // end findData
	
	//===============================================
	
	public void outputList () {										// Prints out the current list
		Node position = head;
		while (position != null) {
			System.out.print(" " + position.data);
			position = position.next;
		} // end while
	} // end outputList
	
	//===============================================
	
	public void outputList (PrintWriter p) {										// Prints out the current list
		Node position = head;
		while (position != null) {
			p.print(" " + position.data);
			position = position.next;
		} // end while
	} // end outputList
	
	//===============================================
	
	public boolean isEmpty () {										// Checks to see if the list is empty
		return (head == null);
	} // end isEmpty
	
	//===============================================
	
	public void clear () {											// Empties the list
		head = null;
	} // end clear
} // end LinkedList class

package hw3;

import java.util.*;

public class LinkedListHW3<AnyType> implements Iterable<AnyType>{
	private Node<AnyType> head;
	
	// Constructs an empty list
	public void LinkedList() {
		head = null;
	} // end LinkedList
	
	// Returns true if the list is empty
	public boolean isEmpty() {
		return head == null;
	} // end isEmpty
	
	// Inserts a new node at the beginning of this list
	public void addFirst(AnyType item) {
		head = new Node<AnyType>(item, head);
	} // end addFirst
	
	// Inserts a new country info node at the beginning of this list
	public void addFirst(String piece, String piece2, String piece3, 
				int i, int j, double d, int k) {
		head = new Node<AnyType>(piece, piece2, piece3, i, j, d,
				k, head);
		
	} // end addFirst
	
	// Returns the first element in the list
	public AnyType getFirst() {
		if (head == null) throw new NoSuchElementException();
		return head.data;
	} // end getFirst
	
	// Removes the first element in the list.
	public AnyType removeFirst() {
		AnyType tmp = getFirst();
		head = head.next;
		return tmp;
	} // end removeFirst
	
	// Inserts a new node to the end of this list.
	public void addLast(AnyType item) {
		if (head == null) {
			addFirst(item);
		} // end if
		else {
			Node<AnyType> tmp = head;
			while (tmp.next != null) {
				tmp = tmp.next;
			} // end while
			tmp.next = new Node<AnyType> (item, null);
		} // end else
	} // end addLast
	
	// Inserts a new Countries info node to the end of this list.
	public void addLast(String piece, String piece2, String piece3, 
			int i, int j, double d, int k) {
		if (head == null) {
			addFirst(piece, piece2, piece3, i, j, d,
					k);
		} // end if
		else {
			Node<AnyType> tmp = head;
			while (tmp.next != null) {
				tmp = tmp.next;
			} // end while
			tmp.next = new Node<AnyType> (piece, piece2, piece3, i, j, d,
					k, null);
		} // end else
	} // end addLast
	// Returns the last element in the list.
	public AnyType getLast() {
		if (head == null) {
			throw new NoSuchElementException();
		} // end if
		
		Node<AnyType> tmp = head;
		while (tmp.next != null) {
			tmp = tmp.next;
		} // end while
		return tmp.data;
	} // end getLast
	
	// Removes all nodes from the list.
	public void clear() {
		head = null;
	} // end clear
	
	// Returns true if this list contains the specified element.
	public boolean conatins(AnyType x) {
		for (AnyType tmp : this) {
			if (tmp.equals(x)) {
				return true;
			} // end if
		} // end for
		return false;
	} // end contains
	
	// Returns the data at the specified position in the list
	public AnyType get(int pos) {
		if (head == null) {
			throw new IndexOutOfBoundsException();
		} // end if
		Node<AnyType> tmp = head;
		for (int i = 0; i < pos; i++) {
			tmp = tmp.next;
		} // end for
		if (tmp == null) {
			throw new IndexOutOfBoundsException();
		} // end if
		return tmp.data;
	} // end get
	
	
	public String toString() { 
		StringBuffer result = new StringBuffer();
		for(Object x : this) {
			result.append("" + this.countryName + this.latitude + this.longitude + this.countryArea + this.countryPopulation + this.countryGDP + this.countryYear);
		}
	}
	
	// Returns a string representation.
/*	public String toString() {
		StringBuffer result = new StringBuffer();
		for (Object x : this) {
			result.append(x + " ");
		} // end for
		return result.toString();
	} // end toString
*/	
	// Inserts a new node after a node containing the key.
 	public void insertAfter(AnyType key, AnyType toInsert) {
		Node<AnyType> tmp = head;
		while (tmp != null && !tmp.data.equals(key)) {
			tmp = tmp.next;
		} // end while
		if (tmp != null) {
			tmp.next = new Node<AnyType> (toInsert, tmp.next);
		} // end if
	} // end insertAfter
	
	// Inserts a new node after a node containing the key.
	public void insertAfter(AnyType key, String piece, String piece2,  
			String piece3, int i, int j, double d, int k) {
		Node<AnyType> tmp = head;
		while (tmp != null && !tmp.data.equals(key)) {
			tmp = tmp.next;
		} // end while
		if (tmp != null) {
			tmp.next = new Node<AnyType> (piece, piece2, piece3, i, j, d,
					k, tmp.next);
		} // end if
	} // end insertAfter
	
	// Removes the first occurrence of the specified element in this list.
	public void remove(AnyType key) {
		if (head == null) {
			throw new RuntimeException("cannot delete");
		} // end if
		if (head.data.equals(key)) {
			head = head.next;
			return;
		} // end if
		Node<AnyType> cur = head;
		Node<AnyType> prev = null;
		while (cur != null && !cur.data.equals(key)) {
			prev = cur;
			cur = cur.next;
		} // end while
		if (cur == null) {
			throw new RuntimeException("cannot delete");
		} // end if
		// Delete cur node
		prev.next = cur.next;
	} // end remove
	
	// The Node class
	private static class Node<AnyType> {
		private AnyType data;
		private String countryName;
		private String latitude;
		private String longitude;
		private int countryArea;
		private int countryPopulation;
		private double countryGDP;
		private int countryYear;
		private AnyType data9;
		private Node<AnyType> next;
		
		public Node(AnyType data, Node<AnyType> next) {
			this.data = data;
			this.next = next;
		} // end Node
		
		public Node(String data, String data2, String data3, int data4,
				int data5, double data6, int data7, Node<AnyType> next) {
			this.countryName = data;
			this.latitude = data2;
			this.longitude = data3;
			this.countryArea = data4;
			this.countryPopulation = data5;
			this.countryGDP = data6;
			this.countryYear = data7;
			this.next = next;
		} // end Node
	} // end Node Class
	
	// The Iterator class
	public Iterator<AnyType> iterator() {
		return new LinkedListIterator();
	} // end iterator
	
	private class LinkedListIterator implements Iterator<AnyType> {
		private Node<AnyType> nextNode;
		
		public LinkedListIterator() {
			nextNode = head;
		} // end LinkedListIterator
		
		public boolean hasNext() {
			return nextNode != null;
		} // end hasNext
		
		public AnyType next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			} // end if
			AnyType res = nextNode.data;
			nextNode = nextNode.next;
			return res;
		} // end next
		
		public void remove() {
			throw new UnsupportedOperationException();
		} // end remove
	} // end LinkedListIterator class
} // end LinkedList Class

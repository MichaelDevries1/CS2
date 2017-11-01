package hw6;

import java.util.ArrayList;
import java.util.List;

// The base idea of this code came from  Rajat Mishra at http://ide.geeksforgeeks.org/index.php

class MergeSort<E extends Comparable>
{
	// Merges two sub arrays of arr[].
	// First sub array is arr[l..m] and second sub array is arr[m+1..r]
	void merge(E arr[], int left, int middle, int right) {
		// Find sizes of two sub arrays to be merged
		int n1 = middle - left + 1;
		int n2 = right - middle;

		// Create the temp arrays 
		List<E> leftArr = new ArrayList<E>();
		List<E> rightArr = new ArrayList<E>();

		// Copy data to temp arrays
		for (int i = 0; i < n1; i++) {
			leftArr.add(arr[left + i]); 
		} // end for
		for (int j = 0; j < n2; j++) {
			rightArr.add(arr[middle + 1 + j]);
		} // end for

		// Merge the temp arrays 
		// Initial elements of first and second sub arrays
		int i = 0, j = 0;

		// Initial element of merged sub array
		int k = left;
		while (i < n1 && j < n2) {									// Make sure your still in the arrays
			// Check which value is larger
			if (leftArr.get(i).compareTo(rightArr.get(j)) <= 0) {			
				arr[k] = leftArr.get(i);						
				i++;												// Move along the left array
			} // end if
			else	{
				arr[k] = rightArr.get(j);
				j++;												// Move along the right array
			} // end else
			k++;													// Move along the new array
		} // end while

		// Copy remaining elements of leftArr if any 
		while (i < n1)	{
			arr[k] = leftArr.get(i);
			i++;
			k++;
		} // end while

		// Copy remaining elements of rightArr if any 
		while (j < n2)	{
			arr[k] = rightArr.get(j);
			j++;
			k++;
		} // end while
	} // end merge
	
	// Main function that sorts arr[l..r] using merge()
	void sort(E[] arr, int left, int right) {
		if (left < right) {
			int middle = (left + right) / 2;							// Find the middle point

			// Sort first and second halves
			sort(arr, left, middle);
			sort(arr , middle + 1, right);

			merge(arr, left, middle, right);							// Merge the sorted halves
		} // end if
	} // end sort

	// A utility function to print array of size n 
	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		} // end for
		System.out.println();
	} // end printArray
} // end MergeSort
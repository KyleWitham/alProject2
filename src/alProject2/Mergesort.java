package alProject2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/* Java program for Merge Sort */
class Mergesort 
{ 
	// Merges two subarrays of arr[]. 
	// First subarray is arr[l..m] 
	// Second subarray is arr[m+1..r] 
	void merge(int arr[], int l, int m, int r) 
	{ 
		// Find sizes of two subarrays to be merged 
		int n1 = m - l + 1; 
		int n2 = r - m; 

		/* Create temp arrays */
		int L[] = new int [n1]; 
		int R[] = new int [n2]; 

		/*Copy data to temp arrays*/
		for (int i=0; i<n1; ++i) 
			L[i] = arr[l + i]; 
		for (int j=0; j<n2; ++j) 
			R[j] = arr[m + 1+ j]; 


		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays 
		int i = 0, j = 0; 

		// Initial index of merged subarry array 
		int k = l; 
		while (i < n1 && j < n2) 
		{ 
			if (L[i] <= R[j]) 
			{ 
				arr[k] = L[i]; 
				i++; 
			} 
			else
			{ 
				arr[k] = R[j]; 
				j++; 
			} 
			k++; 
		} 

		/* Copy remaining elements of L[] if any */
		while (i < n1) 
		{ 
			arr[k] = L[i]; 
			i++; 
			k++; 
		} 

		/* Copy remaining elements of R[] if any */
		while (j < n2) 
		{ 
			arr[k] = R[j]; 
			j++; 
			k++; 
		} 
	} 

	// Main function that sorts arr[l..r] using 
	// merge() 
	void sort(int arr[], int l, int r) 
	{ 
		if (l < r) 
		{ 
			// Find the middle point 
			int m = (l+r)/2; 

			// Sort first and second halves 
			sort(arr, l, m); 
			sort(arr , m+1, r); 

			// Merge the sorted halves 
			merge(arr, l, m, r); 
		} 
	} 

	/* A utility function to print array of size n */
	static void printArray(int arr[]) 
	{ 
		int n = arr.length; 
		for (int i=0; i<n; ++i) 
			System.out.print(arr[i] + " "); 
		System.out.println(); 
	} 

	// Driver method 
	public static void main(String args[]) 
	{ 
		String filename = null;
		Scanner scan = new Scanner(System.in);
		
		//Ask for file name
		System.out.print("What is the file name?  ");
		filename = scan.next();
		
		//Ask for how many items will be in the array
		System.out.print("How big is the array?  ");
		int size = scan.nextInt();
		
		//create array
		int[] arr = new int[size];
		
		try {
			File myObj = new File(filename + ".txt");
			Scanner myReader = new Scanner(myObj);
			
			//Start Timer
			long startTime = System.nanoTime();
			
			//Get values from the files and input them into the array
			for (int i = 0; myReader.hasNextInt(); i++) {
				arr[i]= myReader.nextInt();
			}
			myReader.close();
			
			//Sort the contents of the array
	        Mergesort ob = new Mergesort(); 
	        ob.sort(arr, 0, arr.length-1); 
	  
			//End timer and print time
			long endTime = System.nanoTime();
			long timeElapsed = endTime - startTime;
			System.out.print("Time in nanoseconds: " + timeElapsed);	
			
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
} 
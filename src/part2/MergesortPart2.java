package part2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/* Java program for Merge Sort */
class MergesortPart2
{ 
	static int counter = 0;
	// Merges two subarrays of arr[]. 
	// First subarray is arr[l..m] 
	// Second subarray is arr[m+1..r] 
	void merge(int arr[], int l, int m, int r) 
	{ 
		// Find sizes of two subarrays to be merged 
		int n1 = m - l + 1;
		counter++;
		int n2 = r - m; 
		counter++;
		/* Create temp arrays */
		int L[] = new int [n1]; 
		counter++;
		int R[] = new int [n2]; 
		counter++;
		/*Copy data to temp arrays*/
		for (int i=0; i<n1; ++i) 
			L[i] = arr[l + i]; 
			counter++;
		for (int j=0; j<n2; ++j) 
			R[j] = arr[m + 1+ j]; 
			counter++;

		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays 
		int i = 0, j = 0; 
		counter++;
		
		// Initial index of merged subarry array 
		int k = l; 
		counter++;
		while (i < n1 && j < n2) 
		{ 
			if (L[i] <= R[j]) 
			{ 
				arr[k] = L[i]; 
				i++;
				counter++;
			} 
			else
			{ 
				arr[k] = R[j]; 
				j++; 
				counter++;
			} 
			k++; 
			counter++;
		} 

		/* Copy remaining elements of L[] if any */
		while (i < n1) 
		{ 
			arr[k] = L[i]; 
			i++; 
			k++; 
			counter++;
		} 

		/* Copy remaining elements of R[] if any */
		while (j < n2) 
		{ 
			arr[k] = R[j]; 
			j++; 
			k++; 
			counter++;
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
			counter++;
			// Sort first and second halves 
			sort(arr, l, m);
			counter++;
			sort(arr , m+1, r); 
			counter++;
			// Merge the sorted halves 
			merge(arr, l, m, r); 
			counter++;
		} 
	} 

	// Driver method 
	public static void main(String args[]) 
	{ 
		String filename = null;
		counter++;
		Scanner scan = new Scanner(System.in);
		counter++;
		//Ask for file name
		System.out.print("What is the file name?  ");
		filename = scan.next();
		counter++;
		//Ask for how many items will be in the array
		System.out.print("How big is the array?  ");
		int size = scan.nextInt();
		counter++;
		//create array
		int[] arr = new int[size];
		
		try {
			File myObj = new File(filename + ".txt");
			counter++;
			Scanner myReader = new Scanner(myObj);
			counter++;
			
			//Get values from the files and input them into the array
			for (int i = 0; myReader.hasNextInt(); i++) {
				arr[i]= myReader.nextInt();
				counter++;
			}
			myReader.close();
			
			//Sort the contents of the array
	        MergesortPart2 ob = new MergesortPart2();
	        counter++;
	        ob.sort(arr, 0, arr.length-1); 
	        counter = counter + arr.length;
	        System.out.println("The counter is: " + counter);
	        
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
} 
package alProject2;

import java.io.*;
import java.util.Scanner;

class InsertionArrays {
	private static final int[] InsertionArrays = null;

	void sort(int[] arr) {
		int n = arr.length;
		
		//Splits the array into individual parts
		for(int i = 1; i < n; ++i) {
			int key = arr[i];
			int j = i - 1;
			
			//Sort and then combine the part
			while(j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
	}
	

	public static void main(String[] args) {
		String filename = null;
		InsertionArrays is = new InsertionArrays();
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
			
			//Sort the array
			is.sort(arr);
			
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

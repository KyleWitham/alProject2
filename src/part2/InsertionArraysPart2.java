package part2;

import java.io.*;
import java.util.Scanner;

class InsertionArraysPart2 {
	static int counter = 0;
	private static final int[] InsertionArrays = null;
	
	void sort(int[] arr) {
		int n = arr.length;
		counter++;
		//Splits the array into individual parts
		for(int i = 1; i < n; ++i) {
			int key = arr[i];
			counter++;
			int j = i - 1;
			counter++;
			//Sort and then combine the part
			while(j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				counter++;
				j = j - 1;
				counter++;
			}
			arr[j + 1] = key;
			counter++;
		}
	}
	

	public static void main(String[] args) {
		String filename = null;
		counter++;
		InsertionArraysPart2 is = new InsertionArraysPart2();
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
		counter++;
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
			
			//Sort the array
			is.sort(arr);
			counter++;
			
			System.out.println("The count is: " + counter);
			
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	
	}

}

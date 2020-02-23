package alProject2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class InsertionLinkedLists
{ 
	node head; 
	node sorted; 

	class node 
	{ 
		int val; 
		node next; 

		public node(int val) 
		{ 
			this.val = val; 
		} 
	} 

	void push(int val) 
	{ 
		/* allocate node */
		node newnode = new node(val); 
		/* link the old list off the new node */
		newnode.next = head; 
		/* move the head to point to the new node */
		head = newnode; 
	} 

	// function to sort a singly linked list using insertion sort 
	void insertionSort(node headref) 
	{ 
		// Initialize sorted linked list 
		sorted = null; 
		node current = headref; 
		// Traverse the given linked list and insert every 
		// node to sorted 
		while (current != null) 
		{ 
			// Store next for next iteration 
			node next = current.next; 
			// insert current in sorted linked list 
			sortedInsert(current); 
			// Update current 
			current = next; 
		} 
		// Update head_ref to point to sorted linked list 
		head = sorted; 
	} 

	/* 
	* function to insert a new_node in a list. Note that 
	* this function expects a pointer to head_ref as this 
	* can modify the head of the input linked list 
	* (similar to push()) 
	*/
	void sortedInsert(node newnode) 
	{ 
		/* Special case for the head end */
		if (sorted == null || sorted.val >= newnode.val) 
		{ 
			newnode.next = sorted; 
			sorted = newnode; 
		} 
		else
		{ 
			node current = sorted; 
			/* Locate the node before the point of insertion */
			while (current.next != null && current.next.val < newnode.val) 
			{ 
				current = current.next; 
			} 
			newnode.next = current.next; 
			current.next = newnode; 
		} 
	} 

	/* Function to print linked list */
	void printlist(node head) 
	{ 
		while (head != null) 
		{ 
			System.out.print(head.val + "\n"); 
			head = head.next; 
		} 
	} 
	
	// Driver program to test above functions 
	public static void main(String[] args) 
	{ 
		String filename = null;
		InsertionLinkedLists is = new InsertionLinkedLists(); 
		Scanner scan = new Scanner(System.in);
		
		//Ask for file name
		System.out.print("What is the file name?  ");
		filename = scan.next();
		
		try {
			File myObj = new File(filename + ".txt");
			Scanner myReader = new Scanner(myObj);
			
			//Start Timer
			long startTime = System.nanoTime();
			
			//Get values from the files and input them into the array
			for (int i = 0; myReader.hasNextInt(); i++) {
				is.push(myReader.nextInt());
			}
			myReader.close();
			
		    is.insertionSort(is.head); 
			
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
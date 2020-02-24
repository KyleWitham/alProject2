package part2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class InsertionLinkedListPart2
{ 
	static int counter = 0;
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
		counter++;
		/* link the old list off the new node */
		newnode.next = head;
		counter++;
		/* move the head to point to the new node */
		head = newnode; 
		counter++;
	} 

	// function to sort a singly linked list using insertion sort 
	void insertionSort(node headref) 
	{ 
		// Initialize sorted linked list 
		sorted = null;
		counter++;
		node current = headref; 
		counter++;
		// Traverse the given linked list and insert every 
		// node to sorted 
		while (current != null) 
		{ 
			// Store next for next iteration 
			node next = current.next; 
			counter++;
			// insert current in sorted linked list 
			sortedInsert(current); 
			counter++;
			// Update current 
			current = next; 
			counter++;
		} 
		// Update head_ref to point to sorted linked list 
		head = sorted;
		counter++;
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
			counter++;
			sorted = newnode; 
			counter++;
		} 
		else
		{ 
			node current = sorted; 
			counter++;
			/* Locate the node before the point of insertion */
			while (current.next != null && current.next.val < newnode.val) 
			{ 
				current = current.next; 
				counter++;
			} 
			newnode.next = current.next;
			counter++;
			current.next = newnode; 
			counter++;
		} 
	} 

	/* Function to print linked list */
	void printlist(node head) 
	{ 
		while (head != null) 
		{ 
			System.out.print(head.val + "\n"); 
			head = head.next; 
			counter++;
		} 
	} 
	
	// Driver program to test above functions 
	public static void main(String[] args) 
	{ 
		String filename = null;
		counter++;
		InsertionLinkedListPart2 is = new InsertionLinkedListPart2(); 
		counter++;
		Scanner scan = new Scanner(System.in);
		counter++;
		//Ask for file name
		System.out.print("What is the file name?  ");
		filename = scan.next();
		counter++;
		try {
			File myObj = new File(filename + ".txt");
			counter++;
			Scanner myReader = new Scanner(myObj);
			counter++;
		
			//Get values from the files and input them into the array
			for (int i = 0; myReader.hasNextInt(); i++) {
				is.push(myReader.nextInt());
				counter++;
			}
			myReader.close();
			
		    is.insertionSort(is.head); 
			counter++;
			
			System.out.print("The count is: " + counter);	
			
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
		
	} 
} 
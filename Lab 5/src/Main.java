import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
/** 
 * This class contains the dynamically allocated array and it's processing
 * Student Name: Hoang Do
 * Student Number:  040961749
 * Course: CST8130 - Data Structures     :  CET-CS-Level 3
 * @author/Professor James Mwangi PhD. 
 * @author Linda Crane
 * @author Melissa Sienkiewicz
 */

public class Main {
	private static Scanner keyboard = new Scanner(System.in);
	private static DecimalFormat df = new DecimalFormat("0.0");
	private static ArrayList<Integer> list = new ArrayList<Integer>();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String choice = "";
		do {
			displayMainMenu();

			choice = keyboard.nextLine();
			while(choice.equals(null) || choice.equals("") || choice.equals("\t") || !choice.equals("1") && !choice.equals("2") 
					&& !choice.equals("3") && !choice.equals("4")) {
				System.out.println("Invalid! Please enter 1-9: ");
				choice = keyboard.nextLine();
				continue;
			}

			if(choice.equals("1")) {
				//Add
				addValue(input);
			} else if (choice.equals("2")) {
				//Search
				int target = 0;
				while(true) {
					try {
						System.out.println("Please specify an Integer:");
						target = input.nextInt();
						break;
					}catch(InputMismatchException e) {
						System.out.println("Invalid");
						input.next();
						continue;
					}
				}
				int result = searchItem(list, 0, list.size() - 1, target); 
				if (result == -1) 
					System.out.println("Element not present"); 
				else
					System.out.println("Element found at index " + result); 

			} else if (choice.equals("3")) {
				//Display
				System.out.print("[");
				printing();
				System.out.println("]");
			} else {
				continue;
			}
		}while(choice.equals("1") || choice.equals("2") || choice.equals("3"));
		System.out.println("Exitting...");

	}
	
	/**
	 * searching item in sorted list by binary search
	 * @param list2, left, right, target
	 * @return int
	 */
	private static int searchItem(ArrayList<Integer> list2, int left, int right, int target) {
		if (left <= right) { 
			int mid = (left + right) / 2; 

			if (list2.get(mid) == target) {
				return mid; 		//find
			} else if (list2.get(mid) > target) {	
				right = mid - 1;	//high
			} else {
				left = mid + 1;		//low
			}
			return searchItem(list2, left, right, target); 
		} 

		// We reach here when element is not present 
		// in array 
		return -1; 
	}
	/**
	 * This is main menu displaying the choices for user
	 * @param args
	 */
	private static void displayMainMenu()  {
		System.out.println("");
		System.out.println("Please enter:");
		System.out.println("1: Add Item");
		System.out.println("2: Search for Item");
		System.out.println("3: Display Listy");
		System.out.println("4: To exit");
	}
	/**
	 * adding value to the list
	 * @param input
	 */
	private static void addValue(Scanner input) {
		int userInput = 0;
		while(true) {
			try {
				System.out.println("Please specify an Integer:");
				userInput = input.nextInt();
				break;
			}catch(InputMismatchException e) {
				System.out.println("Invalid");
				input.next();
				continue;
			}
		}
		list.add(userInput);
	}

	/**
	 * listing item in sorted list 
	 */
	private static void printing() {
		Collections.sort(list);
		/* String str = ""; */
		for(int i = 0; i < list.size(); i++) {
			if(i == (list.size()-1)) {
				System.out.print(list.get(i));
			}else {
				System.out.print(list.get(i) + ", ");
			}
		}
	}


}
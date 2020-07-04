import java.util.InputMismatchException;
import java.util.Scanner;
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

public class Test {
	private static Scanner keyboard = new Scanner(System.in);
	private static DecimalFormat df = new DecimalFormat("0.0");
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * Numbers numbers = new Numbers(0); numbers.addValue(keyboard);
		 * numbers.calcAverage();
		 */
		displayMainMenu();
	}

	private static void displayMainMenu()  {
		Numbers numbers = new Numbers();
		String choice = "";
		do {
			System.out.println("");
			System.out.println("Please select one of the following:");
			System.out.println("1: Initailize a default array");
			System.out.println("2: To specify the max size of the array");
			System.out.println("3: Add value to the array");
			System.out.println("4: Display values in the array");
			System.out.println("5: Display the average of the values");
			System.out.println("6: To exit");
			choice = keyboard.nextLine();
			while(choice.equals(null) || choice.equals("") || choice.equals("\t") || !choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4") && !choice.equals("5") && !choice.equals("6")) {
				System.out.println("Invalid! Please enter 1-6: ");
				choice = keyboard.next();
				continue;
			}

			if(choice.equals("1")) {
				//Initialize a df array
				numbers = new Numbers();
			} else if (choice.equals("2")) {
				//Specify the max size
				System.out.println("Enter new size of array: ");
				int maxSize = keyboard.nextInt();
				numbers = new Numbers(maxSize);
			} else if (choice.equals("3")) {
				//Add
				numbers.addValue(keyboard);
			} else if (choice.equals("4")) {
				//Display
				System.out.println(numbers.toString());
			} else if (choice.equals("5")) {
				System.out.println(df.format(numbers.calcAverage()));
			} else {
				continue;
			}
		}while(choice.equals("1") || choice.equals("2") || choice.equals("3") || choice.equals("4") || choice.equals("5"));
		System.out.println("Exitting...");
	}

}
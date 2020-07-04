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
	private static DecimalFormat df = new DecimalFormat("#,#");
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Numbers numbers = new Numbers();
		String choice = "";
		do {
			displayMainMenu();

			choice = keyboard.nextLine();
			while(choice.equals(null) || choice.equals("") || choice.equals("\t") || !choice.equals("1") && !choice.equals("2") 
					&& !choice.equals("3") && !choice.equals("4") && !choice.equals("5") && !choice.equals("6")) {
				System.out.println("Invalid! Please enter 1-6: ");
				choice = keyboard.nextLine();
				continue;
			}

			if(choice.equals("1")) {
				//Initialize a df array
				numbers = new Numbers();
			} else if (choice.equals("2")) {
				//Specify the max size
				System.out.println("Enter new size of array: ");
				int maxSize = input.nextInt();
				numbers = new Numbers(maxSize);

			} else if (choice.equals("3")) {
				//Add
				//Check bug!!! space
				numbers.addValue(keyboard);
			} else if (choice.equals("4")) {
				//Display
				System.out.println("Numbers are: ");
				System.out.println(numbers.toString());
			} else if (choice.equals("5")) {
				numbers.displayAvg();
				System.out.println();
			} else {
				continue;
			}
		}while(choice.equals("1") || choice.equals("2") || choice.equals("3") || choice.equals("4") || choice.equals("5"));
		System.out.println("Exitting...");

	}
	/**
	 * This is main menu displaying the choices for user
	 * @param args
	 */
	private static void displayMainMenu()  {
		System.out.println("");
		System.out.println("Please select one of the following:");
		System.out.println("1: Initailize a default array");
		System.out.println("2: To specify the max size of the array");
		System.out.println("3: Add value to the array");
		System.out.println("4: Display values in the array");
		System.out.println("5: Display the average of the values");
		System.out.println("6: To exit");


	}

}
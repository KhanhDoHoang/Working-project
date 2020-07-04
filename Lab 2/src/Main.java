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
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String nameFile = "";
		Numbers numbers = new Numbers();
		String choice = "";
		do {
			displayMainMenu();

			choice = keyboard.nextLine();
			while(choice.equals(null) || choice.equals("") || choice.equals("\t") || !choice.equals("1") && !choice.equals("2") 
					&& !choice.equals("3") && !choice.equals("4") && !choice.equals("5") && !choice.equals("6") && !choice.equals("7") 
					&& !choice.equals("8") && !choice.equals("9")) {
				System.out.println("Invalid! Please enter 1-9: ");
				choice = keyboard.nextLine();
				continue;
			}

			if(choice.equals("1")) {
				//Initialize a df array
				numbers = new Numbers();
			} else if (choice.equals("2")) {
				//Specify the max size
				int maxSize = 0;
				//not check space yet
				System.out.println("Enter new size of array: ");
				try {
					maxSize = input.nextInt();
					numbers = new Numbers(maxSize);
				}catch(InputMismatchException e) {
					System.out.println("Invalid!");
					input = new Scanner(System.in);
				}
			} else if (choice.equals("3")) {
				//Add
				numbers.addValue(keyboard);
			} else if (choice.equals("4")) {
				//Display
				System.out.println("Numbers are: ");
				System.out.println(numbers.toString());
			} else if (choice.equals("5")) {
				numbers.displayAvgAndMaximum();
				System.out.println();
			} else if (choice.equals("6")) {
				numbers.addMultiValue(input);
			} else if (choice.equals("7")){
				System.out.println("Name of the file to read from: ");
				nameFile = input.next();
				numbers.readFromFile(nameFile);
			} else if (choice.equals("8")) {
				System.out.println("Name of the file to save to: ");
				nameFile = input.next();
				try {
					PrintWriter printWriter = new PrintWriter("C:\\CST8130\\" + nameFile);
					numbers.print(printWriter);
					printWriter.close();
					//input.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			} else {
				continue;
			}
		}while(choice.equals("1") || choice.equals("2") || choice.equals("3") || choice.equals("4") || choice.equals("5") || choice.equals("6") || choice.equals("7") || choice.equals("8"));
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
		System.out.println("6: Enter multiple values");
		System.out.println("7: Read values from file");
		System.out.println("8: Save values to file");
		System.out.println("9: To exit");


	}

}
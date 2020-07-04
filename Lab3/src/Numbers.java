import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * This class contains the dynamically allocated array and it's processing
 * Student Name: Hoang Do
 * Student Number:  040961749
 * Course: CST8130 - Data Structures     :  CET-CS-Level 3
 * @author/Professor James Mwangi PhD. 
 * @author Linda Crane
 * @author Melissa Sienkiewicz
 */
public class Numbers {
	DecimalFormat df = new DecimalFormat("#,#");
	/**
	 * Stores Float values.
	 */
	private Float [] numbers;
	/**
	 * Store the number of items currently in the array.
	 */
	private int numItems;
	//Max size
	private int size;
	/**
	 * Default Constructor
	 */
	public Numbers() {
		this.size = -1;
		this.numItems = 0;
		this.numbers = new Float[numItems];
	}

	/**
	 * Constructor that initializes the numbers array.
	 * @param size - Max size of the numbers array
	 */
	public Numbers(int size) {
		this.numItems = 0;
		this.size = size;
		this.numbers = new Float[size];
	}

	/**
	 * Adds a value in the array
	 * @param keyboard - Scanner object to use for input
	 */
	public void addValue(Scanner keyboard) {
		keyboard = new Scanner(System.in);
		float userInput = 0.0f;		
		System.out.print("Enter value: ");

		//Check if it is a digit or not
		String s = keyboard.nextLine();
		try {
			userInput = Float.parseFloat(s);
		}catch(NumberFormatException e) {
			System.out.println("That's not the float!");
			return;
		}

		//Check if there is a space or tab
		while(s.equals(null) || s.equals(" ") || s.equals("\t")) {
			System.out.println("That's not the float!");
			System.out.print("Enter value: ");
			s = keyboard.nextLine();
		}
		userInput = Float.parseFloat(s);
		//check
		if(size < 0) {
			Float[] array2 = new Float[numItems+1]; //numItems = 0 + 1 //default constructor
			for(int i = 0; i < numItems; i++) {		//loop through original // i = 0 < 1 = numItems
				array2[i] = numbers[i];				//Copy
			}
			array2[numItems++] = userInput;			//lastItem = userInput =>append
			numbers = array2;						//put it back to mama
		} else {
			try {
				numbers[numItems++] = userInput;	//parameter constructor//not -1//lastItem gonna be added
			}catch(IndexOutOfBoundsException e) {
				System.out.println("Array full");
				numItems--;
			}catch(Exception e) {
				//return;
			}
		}
		return;
	}
	/**
	 * Adds multiple value in the array
	 * @param keyboard - Scanner object to use for input
	 */
	public void addMultiValue(Scanner kb) {
		//try catch bugs
		int count = 0;

		System.out.println("How many values do you wish to add?");
		count = kb.nextInt();

		for (int i = 0; i < count; i++) {
			addValue(kb);
		}
	}
	/**
	 * Adds a value in the array
	 * @param printWriter - PrintWriter to print to the file
	 */
	public void print(PrintWriter printWriter) throws FileNotFoundException {
		printWriter.print(toString());
	}
	/**
	 * Adds a value in the array
	 * @param nameFile - String name of a file being read
	 */
	public void readFromFile(String nameFile) {
		try(Scanner file = new Scanner(new File(("C:\\CST8130\\" + nameFile)))){
			//List<String> ignoreAll = Arrays.asList(" ", "\t","");
			int count = 0;
			while(file.hasNext()) {
				//String line = file.next(); //Scan for the following line

				float userInput = 0;
				try {
					userInput = file.nextFloat();
				}catch(InputMismatchException e) {
					System.out.println("");
				}
				if(size < 0) {
					Float[] array2 = new Float[numItems+1]; //numItems = 0 + 1 //default constructor
					for(int i = 0; i < numItems; i++) {		//loop through original // i = 0 < 1 = numItems
						array2[i] = numbers[i];				//Copy
					}
					array2[numItems++] = userInput;			//lastItem = userInput =>append
					numbers = array2;						//put it back to mama
				} else {
					try {
						numbers[numItems++] = userInput;	//parameter constructor//not -1//lastItem gonna be added
					}catch(IndexOutOfBoundsException e) {
						if(count == 0) {
							System.out.println("Array full");
						}
						numItems--;
						count++;
					}catch(Exception e) {
						//return;
					}
				}
				//return;

			}
		}catch(FileNotFoundException e) {
			e.getMessage();
		}
		//return;
	}

	/**s
	 * Calculates the average of all the values in the numbers array.
	 * @return float value that represents the average
	 */
	public float calcAverage() {
		float sum = 0;
		for(int i = 0; i < numItems; i++) {
			sum += numbers[i];
		}
		return sum / numItems;
	}
	/**
	 * Display the average
	 */
	public void displayAvgAndMaximum() {
		try {
			if(numItems == 0) {
				System.out.print("Average is: " + 0.0f);
				System.out.println();
			} 
			else {
				System.out.println("Average is: " + calcAverage());
			}

		}catch(ArithmeticException e) {
			System.out.print("");
		}
		float maximum = 0;
		for(int i = 0; i < numItems; i++) {
			if(numbers[i] > maximum) {
				maximum = numbers[i];
			}
		}
		System.out.println("Maximum number is: " + maximum);
	}
	/**
	 * Sorting numbers in the array from minimum to maximum
	 */
	public void selectionSort() {
		//Make a copy of an unsorted array then sort it
		//Selection sort
		Float[] array2 = new Float[numItems]; 
		for(int i = 0; i < numItems; i++) {		
			array2[i] = numbers[i];				
		}						
		
		for (int i = 0; i < array2.length; i++) {
			float min = array2[i];
			int minId = i;
			for (int j = i + 1; j < array2.length; j++) {
				if(array2[j] < min) {
					min = array2[j];
					minId = j;
				}
			}
			//swapping
			float temp = array2[i];
			array2[i] = min;
			array2[minId] = temp;
		}
		//print
		String str = "";
		for(int i = 0; i < numItems; i++) {
			str += array2[i] + "\n";
		}
		System.out.println(str);
	}
	/**
	 * Sorting numbers in the array from minimum to maximum
	 */
	public void bubbleSort() {
		Float[] array2 = new Float[numItems]; 
		for(int i = 0; i < numItems; i++) {		
			array2[i] = numbers[i];				
		}	
//		String str = "";
//		for(int i = 0; i < numItems; i++) {
//			str += array2[i] + "\n";
//		}
//		System.out.println(str);
		for(int i = 0; i < numItems - 1; i++) {
			for(int j = 0; j < numItems-i-1; j++) {
				if(array2[j] > array2[j+1]) {
					float temp = array2[j];
					array2[j] = array2[j+1];
					array2[j+1] = temp;
				}
			}
		}
		String str1 = "";
		for(int i = 0; i < numItems; i++) {
			str1 += array2[i] + "\n";
		}
		System.out.println(str1);
	}
	/**
	 * Sorting numbers in the array from minimum to maximum
	 */
	public void insertionSort() {
		Float[] array2 = new Float[numItems]; 
		for(int i = 0; i < numItems; i++) {		
			array2[i] = numbers[i];				
		}	
		
		for(int i = 1; i < numItems; ++i) {
			float id = array2[i];
			int j = i - 1;
			//Moving
			while(j >= 0 && array2[j] > id) {
				array2[j+1] = array2[j];
				j = j - 1;
			}
			array2[j+1] = id;
		}

		String str = "";
		for(int i = 0; i < numItems; i++) {
			str += array2[i] + "\n";
		}
		System.out.println(str);
	}

	/**
	 * Adds a value in the array
	 * @return String
	 */
	@Override
	public String toString() {
		String str = "";
		for(int i = 0; i < numItems; i++) {
			str += numbers[i] + "\n";
		}
		return str.toString();
	}

}


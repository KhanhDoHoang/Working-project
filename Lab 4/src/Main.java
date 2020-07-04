import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * This program using recursion to check string palindrome
 * @author hoang do
 * @version 1.2
 */
public class Main {
//	private static int beginIndex = 0;
	public static void main(String[]args) {
		Scanner scanner = new Scanner(System.in);
		String userInput = "";

		while (!userInput.equals("exit")) { 
			try { 
				System.out.println("Please enter a palindrome or exit to terminate the program:");
				userInput = scanner.next();
				if(userInput.equals("exit")) {
					break;
				}
				else {

					if(isPalindrome(userInput)) {
						System.out.println("String is a palindrome.");
					}else{
						System.out.println("String is not a palindrome.");
					}
				}
			} 
			catch (InputMismatchException e) { 
				System.out.println("Invalid entry");
				scanner.next(); 
				continue; 
			}
		}

	}
	public static boolean isPalindrome(String input) {
		int length = input.length();

		if(length == 0 || length == 1) {
			return true;
		}
		if(input.charAt(0) == input.charAt(length - 1)) {
			return isPalindrome(input.substring(1, length - 1));
		}
		return false;
	}

}

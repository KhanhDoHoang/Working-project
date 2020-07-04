import java.awt.print.Book;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main2 {
//	private static void disposeCars(Collection<String> collection1, Collection<String> collection2) {
//		Iterator iterator = collection1.iterator();
//		while(iterator.hasNext()) {
//			if(collection2.contains(iterator.next())) {
//				iterator.remove();
//			}
//		}
//	}
//	private static void main() {
//		String returnString = new String("Books in Library:\n");
//		if(numBooks == 0) {
//			returnString += "None";
//			return returnString;
//		}
//		Arrays.sort(books, new TitleComparators());
//		for(Book book: books) {
//			returnString += book.toString() + "\n";
//		}
//		return returnString;
//		
//	}
//	public static void main(String[]args) {
//		System.out.println(doSomething(5));
//	}
//	static int doSomething(int n) {
//		int val = 0;
//		for (int i= 0; i < n ; i++) {
//			for(int j = 0; j<i;j++) {
//				val = i + j;
//			}
//		}
//		return val;
//	}
	public static void main(String[]args) {
		double x = 5.0 + 3/2;
		System.out.println(x);
		System.out.println(recmeth(5));
	}
	public static int recmeth(int x) {
		if(x < 2) {
			return x;
		}
		return x + recmeth(x-1);
	}
	
}
















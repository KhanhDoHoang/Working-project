
public class selectionSort {
	
	public static void main (String[]args) {
		sortingArray();
	}
 	public static void sortingArray() {
		//Selection sort
 		int[] numbers = {1 , 10 , 5};
		for (int i = 0; i < numbers.length; i++) {
			int min = numbers[i];
			System.out.println(min);
			int minId = i;
			System.out.println(minId);
			for (int j = i + 1; j < numbers.length; j++) {
				if(numbers[j] < min) {
					min = numbers[j];
					minId = j;
					System.out.println(min);
					System.out.println(minId);
				}
			}
			//swapping
			int temp = numbers[i];
			numbers[i] = min;
			numbers[minId] = temp;
			System.out.println(temp);
			System.out.println(numbers[i]);
			System.out.println(numbers[minId]);
		}
		
		
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i]+" ");
		}
	}
}

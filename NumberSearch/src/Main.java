
public class Main {
	public static void main(String[]args) {
		int[] list = {1, 2, 4, 6, 7, 9};
		int target = 6;
		System.out.print("list: ");
		for(int i = 0; i < list.length; i++) {
			System.out.print(list[i]);
		}
		System.out.println();
		System.out.println(binSearch(list, target));

	}

	public static int binSearch(int[] list, int target) {
		int left = 0;
		int right = list.length - 1;


		while(left <= right) {
			int middle = (left + right) / 2;

			if(target < list[middle]) {
				right = middle - 1; //too high

			}
			else if (target > list[middle]) {
				left = middle + 1; //too low

			}
			else {
				return middle;
			}
		}
		return -1;
	}
}

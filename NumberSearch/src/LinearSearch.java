
public class LinearSearch {

	public static void main(String[]agrs) {
		int[] list = {3, 5, 9, 8, 16};
		int target = 8;
		System.out.println(search(list, target));
 	}
	public static int search(int[] list, int target) {
		for(int i = 0; i < list.length; i++) {
			if(list[i] == target) {
				return i+1;
			}
		}
		return -1;
	}
}

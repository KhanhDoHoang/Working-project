
public class Main {
	public static void main(String[]args) {
		int[] list = new int[10];
		int n = 10;
		for(int i = 0; i< n; i++) {
			for(int j = 0; j < n-i-1; j++) {
				if(list[j] > list[j+1]) {
					int temp = list[j];
					list[j+1] = temp;
				}
				System.out.println(list[j]);
			}
		}
	}
}

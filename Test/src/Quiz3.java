
public class Quiz3 {

	public static void main(String[]args) {
		int n = 17;
		for (int i=1; i < n; i*=2) {
		    int j = n; 
		    while ( j>0) {
		        System.out.println (" " + i + " " + j );
		        j-=2;
		    }
		    System.out.print ("\n");
		}
		System.out.println();
		
		n = 6;
		for (int i = 0; i < n; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		for(int j = n; j > 0; j--) {
			System.out.print( j + " ");
		}
		System.out.println();
		System.out.println();
		
		for(int i = 0; i < n; i++) {
			System.out.print(i + " ");
			for(int j = n; j > i; j--) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}
}

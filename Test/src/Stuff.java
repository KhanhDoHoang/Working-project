
public class Stuff {
	private int n = 100;
	private String s = "initial";
	
	public Stuff(int n) {
		this.n = n/4;
	}
	
	public void setString(String s) {
		this.s = s;
		s = "set";
		System.out.println(s);
	}
	
	public String toString() {
		return "Stuff has n: " + n + ", s: " + s;
	}
}

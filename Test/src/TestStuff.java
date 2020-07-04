
public class TestStuff {
	public static void main(String[]args) {
		Stuff myStuff = new Stuff(18);
		System.out.println(myStuff);
		String s = "changed";
		myStuff.setString(s);
		System.out.println(s);
		System.out.println(myStuff);

	}
}

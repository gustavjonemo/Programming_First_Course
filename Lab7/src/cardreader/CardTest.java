package cardreader;

public class CardTest {
	
	
	public static void main(String[] Args){
		UserTable tb = new UserTable();
		User u1 = new User(99973, "Viktor Lödderkvist");
		tb.add(u1);
		User u2 = new User(99986, "Hej Hejsson");
		tb.add(u2);
		User u3 = tb.find(24072);
		User u4 = tb.find(24073);
		User u5 = tb.find(24074);
		User u6 = tb.findByName("Jens Holmgren");
		tb.print();
		System.out.println(tb.find(99973));
		System.out.println(tb.find(99986));
		System.out.println(u3);
		System.out.println(u4);
		System.out.println(u5);
		System.out.println(u6);
	}
}

package coinpurse;

public class test {
	public static void main(String[] args) {
		Coin c = new Coin(10,"Baht");
		System.out.println(c.toString());
		BankNote n = new BankNote(40,"Baht");
		System.out.println(n.toString());
	}
	
}

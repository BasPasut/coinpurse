package coinpurse;

import java.util.Arrays;

import coinpurse.Coin;

public class test {
public static void main(String[] args) {
//	Coin coin1 = new Coin(1);
//	Coin coin2 = new Coin(5);
//	Coin coin3 = new Coin(0.5, "Riggits");
//	System.out.println(coin1.toString());
//	System.out.println(coin1.compareTo(coin2));
//	System.out.println(coin2.compareTo(coin1));
//	System.out.println(coin1.equals(coin2));
	Purse purse = new Purse(3);
	System.out.println(purse.getBalance());
	System.out.println(purse.count());
	System.out.println(purse.isFull());
	System.out.println(purse.insert(new Coin (5)));
	System.out.println(purse.insert(new Coin (10)));
	System.out.println(purse.insert(new Coin (0)));
	System.out.println(purse.insert(new Coin (1)));
	System.out.println(purse.insert(new Coin (5)));
	System.out.println(purse.count());
	System.out.println(purse.isFull());
	System.out.println(purse.getBalance());
	System.out.println(purse.toString());
	System.out.println(purse.withdraw(12));
	System.out.println(Arrays.toString(purse.withdraw(11)));
	
	}
}

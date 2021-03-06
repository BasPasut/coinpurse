package coinpurse;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Some Coin utility methods for practice using Lists and Comparator.
 * 
 * @author Pasut Kittiprapas
 */
public class CoinUtil {

	/**
	 * Method that examines all the coins in a List and returns only the coins
	 * that have a currency that matches the parameter value.
	 * 
	 * @param coinlist
	 *            is a List of Coin objects. This list is not modified.
	 * @param currency
	 *            is the currency we want. Must not be null.
	 * @return a new List containing only the elements from coinlist that have
	 *         the requested currency.
	 */
	public static List<Valuable> filterByCurrency(final List<Valuable> coinlist, String currency) {
		List<Valuable> currencyCoin = new ArrayList<>();
		for (int i = 0; i < coinlist.size(); i++) {
			if (coinlist.get(i).getCurrency().equalsIgnoreCase(currency)) {
				currencyCoin.add(coinlist.get(i));
			}
		}
		return currencyCoin;
	}

	/**
	 * Method to sort a list of coins by currency. On return, the list (coins)
	 * will be ordered by currency.
	 * 
	 * @param coins
	 *            A List of Coin objects we want to sort.
	 */
	public static void sortByCurrency(List<Valuable> coins) {
		Collections.sort(coins, new Comparator<Valuable>() {

			@Override
			public int compare(Valuable c1, Valuable c2) {
				return c1.getCurrency().compareToIgnoreCase(c2.getCurrency());
			}

		});

	}

	/**
	 * Sum coins by currency and print the sum for each currency. Print one line
	 * for the sum of each currency.
	 * 
	 * @param valuables
	 *            A List of Coin objects we want to sum.
	 */
	public static void sumByCurrency(List<Valuable> valuables) {
		
		Map<String , Double> sumByMap = new HashMap<>();
		for(Valuable v : valuables){
//			if(sumByMap.containsKey(v.getCurrency())){
//				sumByMap.put(v.getCurrency(), v.getValue()+sumByMap.get(v.getCurrency()));
//			}
//			else{
//				sumByMap.put(v.getCurrency(), v.getValue());
//			}
			sumByMap.put(v.getCurrency(), sumByMap.getOrDefault(v.getCurrency(), 0.0) + v.getValue());
		}
		for(String current : sumByMap.keySet()){
			System.out.println(current + " - " + sumByMap.get(current) );
		}
//		sortByCurrency(coins);
//		String currency = coins.get(0).getCurrency();
//		double currentValue = 0.0;
//		for (int i = 0; i < coins.size(); i++) {
//			if (currency.equalsIgnoreCase(coins.get(i).getCurrency())) {
//				currentValue += coins.get(i).getValue();
//			} 
//			
//			else {
//				System.out.println(currentValue + " " + currency);
//				currentValue = 0.0;
//				currentValue += coins.get(i).getValue();
//				currency = coins.get(i).getCurrency();
//			}
//		}
//		System.out.println(currentValue + " " + currency);
	}

	/**
	 * This method contains some code to test the above methods.
	 * 
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {
		String currency = "Rupee";
		System.out.println("Filter coins by currency of " + currency);
		List<Valuable> coins = makeInternationalCoins();
		int size = coins.size();
		System.out.print(" INPUT: ");
		printList(coins, " ");
		List<Valuable> rupees = filterByCurrency(coins, currency);
		System.out.print("RESULT: ");
		printList(rupees, " ");
		if (coins.size() != size)
			System.out.println("Error: you changed the original list.");

		System.out.println("\nSort coins by currency");
		coins = makeInternationalCoins();
		System.out.print(" INPUT: ");
		printList(coins, " ");
		sortByCurrency(coins);
		System.out.print("RESULT: ");
		printList(coins, " ");

		System.out.println("\nSum coins by currency");
		coins = makeInternationalCoins();
		System.out.print("coins= ");
		printList(coins, " ");
		sumByCurrency(coins);

	}

	/** Make a list of coins containing different currencies. */
	public static List<Valuable> makeInternationalCoins() {
		List<Valuable> money = new ArrayList<Valuable>();
		money.addAll(makeCoins("Baht", 0.25, 1.0, 2.0, 5.0, 10.0, 10.0));
		money.addAll(makeCoins("Ringgit", 2.0, 50.0, 1.0, 5.0));
		money.addAll(makeCoins("Rupee", 0.5, 0.5, 10.0, 1.0));
		// randomize the elements
		Collections.shuffle(money);
		return money;
	}

	/** Make a list of coins using given values. */
	public static List<Valuable> makeCoins(String currency, double... values) {
		List<Valuable> list = new ArrayList<Valuable>();
		for (double value : values)
		list.add(new Coin(value, currency));
		return list;
	}

	/** Print the list on the console, on one line. */
	public static void printList(List items, String separator) {
		Iterator iter = items.iterator();
		while (iter.hasNext()) {
			System.out.print(iter.next());
			if (iter.hasNext())
				System.out.print(separator);

		}
		System.out.println(); // end the line
	}
}

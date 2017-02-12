package coinpurse;

//TODO fix this Javadoc. It should be written as a COMPLETE SENTENCE WITH PERIOD.
/**
 * A coin with a fix value and currency.
 * 
 * @author Pasut Kittiprapas
 */
public class Coin implements Comparable<Coin> {
	public static final String DEFAULT_CURRENCY = "Baht";
	/** Value of the coin. */
	private double value;
	/** The currency, of course. */
	private String currency;

	/**
	 * A coin with given value using the default currency.
	 * 
	 * @param value
	 */
	public Coin(double value) {
		this.value = value;
		this.currency = DEFAULT_CURRENCY;
	}

	/**
	 * A coin with given value and currency.
	 * 
	 * @param value
	 * @param currency
	 */
	public Coin(double value, String currency) {
		this.value = value;
		this.currency = currency;
	}

	/**
	 * Get the value of a coin.
	 * 
	 * @return the value of a coin.
	 */
	public double getValue() {
		return this.value;
	}

	/**
	 * Get the currency of a coin.
	 * 
	 * @return the currency of a coin.
	 */
	public String getCurrency() {
		return this.currency;
	}

	/**
	 * This method test whether two coins have the same value or not. If it's
	 * equal, return true. If not, return false.
	 * 
	 * @param obj
	 *            coin that we want to compare.
	 * 
	 * @return true if two coins are equal and false if it's not equal.
	 */
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj.getClass() != this.getClass())
			return false;
		Coin coin = (Coin) obj;
		if ((coin.value == this.value) && (coin.currency.equalsIgnoreCase(this.currency)))
			return true;
		return false;
	}

	/**
	 * Return the value and the currency of the coin.
	 * 
	 * @return String of the value and the currency of the coin.
	 */
	public String toString() {
		return this.value + "-" + this.currency;
	}

	/**
	 * This method test that this coin and another coin which has more value. If
	 * this coin has more value, return 1. If it's equal, return 0. If it has
	 * less value, return -1.
	 * 
	 * @param o
	 *            is the coin that we want to compare
	 * @return 1 if this coin has more value and return 0 if it's equal and
	 *         return -1 if it has less value.
	 */
	@Override
	public int compareTo(Coin o) {
		if (o == null)
			return -1;
		if (this.value == o.value)
			return 0;
		if (this.value - o.value < 0)
			return -1;
		return 1;

	}

}

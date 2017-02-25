package coinpurse;

/**
 * A coin is a class that contain value and currency .
 * 
 * @author Pasut Kittiprapas
 */
public class Coin extends AbstractValuable implements Valuable {
	public static final String DEFAULT_CURRENCY = "Baht";
	/** Value of the coin. */
	double value;
	/** The currency, of course. */
	String currency;

	/**
	 * A coin with given value using the default currency.
	 * 
	 * @param value
	 */
	public Coin(double value) {
		super(value);
	}

	/**
	 * A coin with given value and currency.
	 * 
	 * @param value
	 * @param currency
	 */
	public Coin(double value, String currency) {
		super(value, currency);
	}

	/**
	 * Return the value and the currency of the coin.
	 * 
	 * @return String of the value and the currency of the coin.
	 */
	public String toString() {
		if (super.currency.equals("Ringgit")) {
			return super.value * 100 + " Sen" + " coin";
		} else if (super.currency.equals("Baht")) {
			if (super.value < 1) {
				return super.value * 100 + " Satang coin";
			}
		}

		return super.value + " " + super.currency + " coin";

	}
}

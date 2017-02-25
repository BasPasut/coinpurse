package coinpurse;

/**
 * A BankNote is a class that contains value , currency and serial number.
 * 
 * @author Pasut Kittiprapas
 *
 */
public class BankNote extends AbstractValuable implements Valuable {
	private double value;
	private final static String DEFAULT_CURRENCY = "Baht";
	private String currency;
	private long serialNumber;

	/**
	 * Construct the banknote with the value and currency.
	 * 
	 * @param value
	 *            is the value of the banknote.
	 * @param currency
	 *            is the currency of the banknote.
	 */
	public BankNote(double value, String currency) {
		super(value);
		super.currency = currency;
		serialNumber = 0;
	}

	/**
	 * Construct the banknote with the value and serial number.
	 * 
	 * @param value
	 *            is the value of the banknote.
	 * @param serial
	 *            is the serial number of the banknote.
	 */
	public BankNote(double value, long serial) {
		super(value);
		serialNumber = serial;
	}

	/**
	 * Construct the banknote with the value , currency and serial number.
	 * 
	 * @param value
	 *            is the value of the banknote.
	 * @param currency
	 *            is the currency of the banknote.
	 * @param serial
	 *            is the serial number of the banknote.
	 */
	public BankNote(double value, String currency, long serial) {
		super(value, currency);
		serialNumber = serial;
	}

	/**
	 * This method will return the serial number of the banknote.
	 * 
	 * @return the serial number of the banknote.
	 */
	public long getSerial() {
		return this.serialNumber;

	}

	/**
	 * This method will return the String of the description of the banknote.
	 * 
	 * @return the description of the banknote.
	 */
	public String toString() {
		return super.value + "-" + super.currency + " note " + "[" + getSerial() + "]";
	}
}

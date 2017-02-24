package coinpurse;

public class AbstractValuable implements Valuable{
	
	protected double value;
	protected String currency;
	protected final String DEFAULT_CURRENCY = "Baht";

	public AbstractValuable(double value){
		this.currency = DEFAULT_CURRENCY;
		this.value = value;
	}
	
	public AbstractValuable(double value, String currency) {
		this.value = value;
		this.currency = currency;
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
		Valuable money = (Valuable) obj;
		if ((money.getValue() == this.getValue()) && money.getCurrency().equalsIgnoreCase(this.getCurrency()))
			return true;
		return false;
	}
	

	@Override
	public double getValue() {
		return this.value;
	}

	@Override
	public String getCurrency() {
		return this.currency;
	}

	/**
	 * This method test that this money and another money which has more value. If
	 * this money has more value, return 1. If it's equal, return 0. If it has
	 * less value, return -1.
	 * 
	 * @param o
	 *            is the coin that we want to compare
	 * @return 1 if this coin has more value and return 0 if it's equal and
	 *         return -1 if it has less value.
	 */
	@Override
	public int compareTo(Valuable v) {
		if(v == null) return -1;
		if(this.value < v.getValue()) return -1;
		else if(this.value > v.getValue()) return 1;
		return 0;
		
	}

}
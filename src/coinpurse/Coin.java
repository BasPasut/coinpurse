package coinpurse;
//TODO fix this Javadoc. It should be written as a COMPLETE SENTENCE WITH PERIOD.
/**
 * a coin with a monetary value and currency
 * @author Pasut Kittiprapas
 */
//TODO declare that Coin implements Comparable<Coin>
public class Coin implements Comparable<Coin> {
	public static final String DEFAULT_CURRENCY = "Baht";
    /** Value of the coin. */
    private double value;
    /** The currency, of course. */
    private String currency;
    
    /**
     * A coin with given value using the default currency.
     * @param value
     */
    public Coin (double value){
    	this.value = value;
    	this.currency = DEFAULT_CURRENCY;
    }
    
    /**
     * A coin with given value and currency.
     * @param value
     * @param currency
     */
    public Coin( double value, String currency ) {
    	this.value = value;
    	this.currency = currency;
    }

//TODO Write a getValue() method and javadoc.
    public double getValue( ) {
    	return this.value;
    } 
    
//TODO Write a getCurrency() method and javadoc.
    public String getCurrency() { 
    	return this.currency;
    }
    

    public boolean equals(Object obj) {
    	if (obj == null) return false;
    	if(obj.getClass() != this.getClass()) return false;
    	Coin coin = (Coin) obj; 
    	if((coin.value == this.value) && (coin.currency.equalsIgnoreCase(this.currency))) return true;
    	return false;
    }
    
    public String toString() {
    	return this.value + "-" + this.currency;
    }

@Override
public int compareTo(Coin o) {
	if(o == null) return -1;
	if(this.value == o.value) return 0;
	if(this.value - o.value < 0) return -1;
	return 1;
		
}
    
//TODO Write good Javadoc comments on all methods.
    
}
//TODO remove the TODO comments after you complete them! Including this one!

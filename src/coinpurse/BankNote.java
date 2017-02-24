package coinpurse;

public class BankNote extends AbstractValuable implements Valuable {
	private double value;
	private final static String DEFAULT_CURRENCY = "Baht";
	private String currency;
	private long serialNumber;
	
	public BankNote(double value , long serial){
		super(value);
		serialNumber = serial;
	}
	public BankNote(double value, String currency , long serial){
		super(value , currency);
		serialNumber = serial;
	}
	
	public long getSerial(){
		return this.serialNumber;
		
	}
	
	public String toString(){
		return super.value +"-" + super.currency + " note " + "[" + getSerial() + "]";
	}
}

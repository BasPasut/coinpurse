package coinpurse;

public class BankNote implements Valuable{
	private static long nextSerialNumber = 1000000;
	private double value;
	private String currency = "Baht";
	private long serialNumber;
	
	public BankNote(double value){
		this.serialNumber = nextSerialNumber++;
		this.value = value;
	}
	public BankNote(double value, String currency){
		this.value = value;
		this.currency = currency;
		this.serialNumber = nextSerialNumber++;
	}
	
	@Override
	public double getValue() {
		return this.value;
	}
	
	@Override
	public String getCurrency(){
		return this.currency;
	}
	
	public long getSerial(){
		return this.serialNumber;
		
	}
	
	public boolean equals (Object obj){
		if (obj == null)
			return false;
		if (obj.getClass() != this.getClass())
			return false;
		BankNote banknote = (BankNote) obj;
		if ((banknote.value == this.value) && (banknote.currency.equalsIgnoreCase(this.currency)))
			return true;
		return false;
		
	}
	
	public String toString(){
		return this.value +"-currency note " + "[" + this.serialNumber + "]";
	}
}

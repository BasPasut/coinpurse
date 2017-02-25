package coinpurse;
import java.util.ResourceBundle;

/**
 * This class have responsible to create any kind of money.
 * 
 * @author Pasut Kittiprapas
 *
 */
public abstract class MoneyFactory {
	private static MoneyFactory instance;
	
	
	protected MoneyFactory() {
		
	}
	
	/**
	 * This method will returns a instance depending on the properties file.
	 * 
	 * @return MoneyFactory instance
	 */
	public static MoneyFactory getInstance(){
		if (instance == null) {
			System.exit(1);
		}
		return instance;
	}
	
	/**
	 * Create money depend on a value.
	 * 
	 * @param value
	 *            is the amount of money to be created
	 *            
	 * @return a Valuable object of the specified amount
	 * 
	 */
	abstract Valuable createMoney(double value);
	
	/**
	 * Create money in String and cast it to double depend on its value.
	 * 
	 * @param value
	 *            is the amount of money to be created
	 * @return a Valuable object of the specified amount
	 * 
	 */
	Valuable createMoney(String value){
		return createMoney(Double.parseDouble(value));
		
	}
	
	/**
	 * Set the MoneyFactory depending on the properties file.
	 */
	static void setMoneyFactory(MoneyFactory moneyfactory){
		instance = moneyfactory;
	}
	
	
}

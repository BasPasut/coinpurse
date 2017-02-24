package coinpurse;
import java.util.ResourceBundle;

public abstract class MoneyFactory {
	private static MoneyFactory instance;
	
	
	protected MoneyFactory() {
		
	}
	
	public static MoneyFactory getInstance(){
		if (instance == null) {
			System.exit(1);
		}
		return instance;
	}
	
	abstract Valuable createMoney(double value);
	
	
	Valuable createMoney(String value){
		return createMoney(Double.parseDouble(value));
		
	}
	
	static void setMoneyFactory(MoneyFactory moneyfactory){
		instance = moneyfactory;
	}
	
	
}

package coinpurse;

/**
 * This class is a MoneyFactory that create only Thai money.
 * 
 * @author Pasut Kittiprapas
 *
 */
public class ThaiMoneyFactory extends MoneyFactory {
	
	private static long nextSerialNumber = 1000000;
	@Override
	Valuable createMoney(double value) {
		Valuable thaiMoney = null;
		if(value == 0.25 || value == 0.50 || value == 1 || value == 2 || value == 5 || value == 10){
			return new Coin(value);
		}
		else if (value == 20 || value == 50 || value == 100 || value == 500 || value == 1000){
			return new BankNote(value,nextSerialNumber++);
		}
		
		else{
			throw new IllegalArgumentException();
		}
	}
		
	
}

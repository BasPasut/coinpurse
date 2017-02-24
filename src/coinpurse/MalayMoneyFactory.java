package coinpurse;

public class MalayMoneyFactory extends MoneyFactory {
	private static long nextSerialNumber = 1000000;
	@Override
	Valuable createMoney(double value) {
		Valuable malayMoney = null;
		if(value == 0.05 || value == 0.10 || value == 0.20 || value == 0.50){
			return new Coin(value , "Ringgit");
		}
		else if(value == 1 || value == 2 || value == 5 || value == 10 || value == 20 || value == 50 || value == 100){
			return new BankNote(value , "Ringgit",nextSerialNumber++);
		}
		else{
			throw new IllegalArgumentException();
		}
	}
	
	
}

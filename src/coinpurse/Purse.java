package coinpurse;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * A coin purse contains coins. You can insert coins, withdraw money, check the
 * balance, and check if the purse is full. When you withdraw money, the coin
 * purse decides which coins to remove.
 * 
 * @author Pasut Kittiprapas
 */
public class Purse{
	/** Collection of objects in the purse. */
	public List<Valuable> money;
	/**
	 * Capacity is maximum number of coins the purse can hold. Capacity is set
	 * when the purse is created and cannot be changed.
	 */
	private final int capacity;

	/**
	 * Create a purse with a specified capacity.
	 * 
	 * @param capacity
	 *            is maximum number of coins you can put in purse.
	 */
	public Purse(int capacity) {
		this.capacity = capacity;
		this.money = new ArrayList<>();

	}

	/**
	 * Count and return the number of coins in the purse. This is the number of
	 * coins, not their value.
	 * 
	 * @return the number of coins in the purse
	 */
	public int count() {
		if (this.money == null)
			return 0;
		return this.money.size();
	}

	/**
	 * Get the total value of all items in the purse.
	 * 
	 * @return the total value of items in the purse.
	 */
	public double getBalance() {
		double balance = 0;
		if (this.money == null)
			return 0.0;
		for (int i = 0; i < this.money.size(); i++) {
			balance += this.money.get(i).getValue();
		}
		return balance;
	}

	/**
	 * Return the capacity of the coin purse.
	 * 
	 * @return the capacity
	 */
	public int getCapacity() {
		return this.capacity;

	}

	/**
	 * Test whether the purse is full. The purse is full if number of items in
	 * purse equals or greater than the purse capacity.
	 * 
	 * @return true if purse is full.
	 */
	public boolean isFull() {
		if (this.capacity - this.money.size() > 0) {
			return false;
		}
		return true;
	}

	/**
	 * Insert a coin into the purse. The coin is only inserted if the purse has
	 * space for it and the coin has positive value. No worthless coins!
	 * 
	 * @param valuable
	 *            is a Coin object to insert into purse
	 * @return true if coin inserted, false if can't insert
	 */
	public boolean insert(Valuable valuable) {
		if (isFull() == true) {
			return false;
		}
		if (valuable.getValue() == 0) {
			return false;
		}
		this.money.add(valuable);
		return true;
	}

	/**
	 * Withdraw the requested amount of money. Return an array of Coins
	 * withdrawn from purse, or return null if cannot withdraw the amount
	 * requested.
	 * 
	 * @param amount
	 *            is the amount to withdraw
	 * @return array of Coin objects for money withdrawn, or null if cannot
	 *         withdraw requested amount.
	 */
	public Valuable[] withdraw(double amount) {
		Collections.sort(this.money , new Comparator<Valuable>() {

			@Override
			public int compare(Valuable o1, Valuable o2) {
				if (o1 == null || o2 == null)
					return -1;
				if (o1.getValue() == o2.getValue())
					return 0;
				if (o1.getValue() - o2.getValue() < 0)
					return -1;
				return 1;
			}
		});

		List<Valuable> usedValuable = new ArrayList<>();
		for (int i = this.money.size() - 1; i >= 0; i--) {
			if (amount >= this.money.get(i).getValue()) {
				amount -= this.money.get(i).getValue();
				usedValuable.add(this.money.get(i));
			}
		}

		if (amount == 0) {
			for (int i = 0; i < usedValuable.size(); i++) {
				money.remove(usedValuable.get(i));
			}
			return usedValuable.toArray(new Valuable[0]);

		}
		return null;
	}

	/**
	 * Return the capacity and the balance of the purse.
	 * 
	 * @return the capacity and the balance of the purse.
	 */
	public String toString() {
		return this.capacity + " coins with the value " + getBalance();
	}

}

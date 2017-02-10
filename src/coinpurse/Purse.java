package coinpurse;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

//TODO import ArrayList and Collections (so you can use Collections.sort())

/**
 * A coin purse contains coins. You can insert coins, withdraw money, check the
 * balance, and check if the purse is full. When you withdraw money, the coin
 * purse decides which coins to remove.
 * 
 * @author Pasut Kittiprapas
 */
public class Purse {
	/** Collection of objects in the purse. */
	private List<Coin> money;
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
	 * @param coin
	 *            is a Coin object to insert into purse
	 * @return true if coin inserted, false if can't insert
	 */
	public boolean insert(Coin coin) {
		if (isFull() == true) {
			return false;
		}
		if (coin.getValue() == 0) {
			return false;
		}
		this.money.add(coin);
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
	public Coin[] withdraw(double amount) {
		Collections.sort(this.money);

		List<Coin> usedCoin = new ArrayList<>();
		for (int i = this.money.size() - 1; i >= 0; i--) {
			if (amount >= this.money.get(i).getValue()) {
				amount -= this.money.get(i).getValue();
				usedCoin.add(this.money.get(i));
			}
		}

		if (amount == 0) {
			for (int i = 0; i < usedCoin.size(); i++) {
				money.remove(usedCoin.get(i));
			}
			return usedCoin.toArray(new Coin[0]);

		}
		return null;
	}
	
	/**
	 * 
	 */
	public String toString() {
		return this.capacity + " coins with the value " + getBalance();
	}

}
// TODO remove the TODO comments after you complete them.
// TODO When you are finished, there should not be any TODO. Including this one.

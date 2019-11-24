package entity;

public class Wallet {
	private int userId;
	private int balance;
	
	public Wallet(int userId, int balance) {
		super();
		this.userId = userId;
		this.balance = balance;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
}

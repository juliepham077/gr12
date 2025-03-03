package unit3;
/*
 * Julie Pham
 * Account Template
 * Nov 9, 2023
 */
import java.util.Random;
public class Account {
	Random rand = new Random();
	int num = rand.nextInt(9000) + 1000; //account number
	String name; //account name
	double balance; //account balance
	double wFee, oFee;
	
	Account() {
		balance = 0;
		wFee = 0;
		oFee = 0;
	}
	
	/**
	 * Create Account
	 * @param name 		name of account
	 * @param balance 	balance of account
	 */
	Account(String name, double balance) {
		this.name = name;
		this.balance = balance;
	}
	
	/**
	 * set account name
	 * @param name 		name of account
	 */
	void setName(String name) {
		this.name = name;
	}
	
	String getName() {
		return this.name;
	}
	
	int getAccountNumber() {
		return this.num;
	}
	
	double getBalance() {
		return this.balance;
	}
	
	double deposit(double dep) {
		balance += dep;
		return balance;
	}
	
	double withdraw(double draw) {
		balance -= draw;
		balance -= wFee;
		overdraft(draw);
		return balance;
	}
	
	void overdraft(double draw) {
		if (draw > balance) balance -= oFee;
	}
	
	void updateBalance(double bal) {
		this.balance = bal;
	}
	
	void showInfo() {
		System.out.printf("Account #%d belonging to %S with balance $%.2f.%n", num, name, balance);
	}
}

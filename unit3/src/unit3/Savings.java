package unit3;
/*
 * Julie Pham
 * Savings Account
 * Nov 9, 2023
 */
public class Savings extends Account {
	double interest;
	Savings() {
		super();
	}
	
	Savings(String name, double balance, double i) {
		super(name, balance);
		this.name = name;
		this.interest = i;
	}
	
	String getName() {
		return this.name;
	}
	
	void setInterest(double interest) {
		this.interest = interest;
	}
	
	double getInterest() {
		return this.interest;
	}
	
	double collectInterest(double i) {
		return balance *= Math.pow(1+(i/12), 12);
	}

	void showInfo() {
		System.out.printf("Account #%d belonging to %S with balance $%.2f, interest of %.2f%%.%n", num, name, balance, interest*100);
	}
}

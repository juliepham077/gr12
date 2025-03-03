package unit3;
/*
 * Julie Pham
 * Chequing Account
 * Nov 9, 2023
 */
public class Chequing extends Account {
	
	Chequing() {
		super();
	}
	
	Chequing(String name, double balance) {
		super(name, balance);
	}
	
	void showInfo() {
		System.out.printf("Account #%d belonging to %S with balance $%.2f.%n", num, name, balance);
	}
}

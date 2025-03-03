package unit3;

import java.util.*;
public class LCB {
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		
		//Create an account for chequing and savings
		LCBSystem chequing = new LCBSystem();
		LCBSystem savings = new LCBSystem();
		
		//add info to the accounts
		chequing.addAccount(new Chequing("Diego Martin", 668.57));
		chequing.addAccount(new Chequing("Michael Rose", 37.65));
		savings.addAccount(new Savings("Kylie Walter", 120.00, 0.019));

		int option = 0, acc;
		String name;
		boolean play = true;
		
		System.out.println("Menu: ");
		while (play) {
			//Display menu and get user choice
			System.out.println("==============================================");
			menu();
			System.out.print("Your choice: ");
			option = input.nextInt();
			input.nextLine();
			
			//perform chosen menu option
			switch (option) {
			//Add new Account
			case 1:
				System.out.print("1 Chequing or 2 Savings: ");
				acc = input.nextInt();
				input.nextLine();
				System.out.print("Account name: ");
				name = input.nextLine();
				System.out.print("Balance: ");
				double bal = input.nextDouble();
				if (acc == 1) chequing.addAccount(new Chequing(name, bal));
				else if (acc == 2) {
					System.out.print("Interest %: ");
					double interest = input.nextDouble()/100;
					savings.addAccount(new Savings(name, bal, interest));
					savings.addSavings(new Savings(name, bal, interest));
				}
				else System.out.println("Invalid option.");
				break;
			
			//Deposit
			case 2:
				System.out.print("1 Chequing or 2 Savings: ");
				acc = input.nextInt();
				input.nextLine();
				System.out.print("Name of account: ");
				name = input.nextLine();
				System.out.print("Deposit amount: ");
				double dep = input.nextDouble();
				if (acc == 1) chequing.addDeposit(name, dep);
				else if (acc == 2) savings.addDeposit(name, dep);
				else System.out.println("Invalid option.");
				break;
				
			//Withdraw
			case 3:
				System.out.print("1 Chequing or 2 Savings: ");
				acc = input.nextInt();
				input.nextLine();
				System.out.print("Name of account: ");
				name = input.nextLine();
				System.out.print("Withdraw amount: ");
				double draw = input.nextDouble();
				if (acc == 1) chequing.subWithdraw(name, draw);
				else if (acc == 2) savings.subWithdraw(name, draw);
				else System.out.println("Invalid option.");
				break;
			
			//Display account info
			case 4:
				System.out.print("1 Chequing or 2 Savings: ");
				acc = input.nextInt();
				input.nextLine();
				System.out.print("Name of Account: ");
				name = input.nextLine();
				if (acc == 1) chequing.showAccount(name);
				else if (acc == 2) savings.showAccount(name);
				else System.out.println("Invalid option.");
				break;
			
			//Show all accounts
			case 5:
				chequing.showSystem();
				savings.showSystem();
				break;
				
			//Interest
			case 6:
				System.out.print("Name of Account: ");
				name = input.nextLine();
				savings.addInterest(name);
				break;
			
			//Quit
			case 7:
				play = false;
				break;
			default:
				System.out.println("Invalid option - please select either 1, 2, 3, 4, 5, 6, or 7.");
			}
		}
		System.out.println("==============================================");
		System.out.println("Session Terminated.");
		input.close();
	}//end main()
	
	
	/**
	 * Display the menu of options for the software
	 */
	static void menu() {
		System.out.println("""
				1. Add new Account
				2. Deposit
				3. Withdraw
				4. Display info for an account
				5. Display all accounts info
				6. Calculate and collect monthly interest
				7. Quit
				""");
	}//end menu()
}

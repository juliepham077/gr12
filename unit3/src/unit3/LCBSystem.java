package unit3;

import java.util.ArrayList;

public class LCBSystem {
	
	//Create ArrayLists for all Accounts and Savings Accounts
	ArrayList<Account> lcbSystem;
	ArrayList<Savings> sAcc;
	
	LCBSystem() {
		lcbSystem = new ArrayList<Account>();
		sAcc = new ArrayList<Savings>();
	}
	
	//Add accounts to arraylists
	void addAccount(Account a) {
		lcbSystem.add(a);
	}
	
	void addSavings(Savings s) {
		sAcc.add(s);
	}
	
	
	Account findAccount(String name) {
		for (int i = 0; i < lcbSystem.size(); i++) {
			if (lcbSystem.get(i).getName().equals(name)) return lcbSystem.get(i);
		}
		return null;
	}
	
	Savings findSavings(String name) {
		for (int i = 0; i < sAcc.size(); i++) {
			if (sAcc.get(i).getName().equals(name)) return sAcc.get(i);
		}
		return null;
	}
	
	double addDeposit(String name, double dep) {
		return findAccount(name).deposit(dep);
		 
	}
	
	double subWithdraw(String name, double draw) {
		return findAccount(name).withdraw(draw);
	}
	
	void showAccount(String name) {
		findAccount(name).showInfo();
	}
	
	void addInterest(String name) {
		double bal = findSavings(name).collectInterest(findSavings(name).getInterest());
		findAccount(name).updateBalance(bal);
	}
	
	void showSystem() {
		for (Account a: lcbSystem) {
			a.showInfo();
		}
	}
}

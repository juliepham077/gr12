package unit3;
import java.util.ArrayList;

public class Inventory {
	ArrayList<Item> inventory;
	
	Inventory() {
		inventory = new ArrayList<Item>();
	}
	
	int getQuantity(int stockNum) {
		int index = findItem(stockNum);
		if (index < 0) return -1;
		else return inventory.get(index).getQuantity();
	}
	
	void addItem(Item i) {
		inventory.add(i);
	}
	
	void discontinue(int stockNum) {
		int index = findItem(stockNum);
		inventory.get(index).discontinue();
	}
	
	public int findItem(int stockNum) {
		for (int i = 0; i < inventory.size(); i++) {
			if (inventory.get(i).getStockNumber() == stockNum) return i;
		}
		return -1;
	}
	
	void showInventory() {
		for (Item i: inventory) {
			i.showInfo();
		}
	}
	
	void checkLowInventory() {
		for (Item i: inventory) {
			if (i.getQuantity() < 10) {
				i.showInfo();
			}
		}
	}
}


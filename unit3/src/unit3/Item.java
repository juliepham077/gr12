package unit3;

public class Item {
	int stockNum, quantity;
	String name;
	static int nextStockNum = 0;
	
	Item() {
		name = "";
		quantity = 0;
		stockNum = nextStockNum++;
	}
	
	Item(String name, int amount) {
		this.name = name;
		this.quantity = amount;
		stockNum = nextStockNum++;
	}
	
	void discontinue() {
		name = "DISCONTINUED" + name;
		quantity = 0;
	}
	
	int getStockNumber() {
		return this.stockNum;
	}
	
	int getQuantity() {
		return this.quantity;
	}
	
	String getName() {
		return this.name;
	}
	
	void setName(String name) {
		this.name = name;
	}
	
	void setQuantity(int amount) {
		this.quantity = amount;
	}
	
	void showInfo() {
		System.out.printf("Item #: %d, %S: %d in stock.%n", stockNum, name, quantity);
	}
	
	boolean equals(Item i) {
		if (this.name.equalsIgnoreCase(i.name) && this.quantity == i.quantity && this.stockNum == i.stockNum ) return true;
		else return false;
	}
	
}

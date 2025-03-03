package unit3;


public class Electronics extends Item{
	String brand;
	
	Electronics() {
		super();
		brand = "";
	}
	
	Electronics(String name, int quantity, String brand) {
		super(name, quantity);
		this.brand = brand;
	}
	
	void setBrand(String brand) {
		this.brand = brand;
	}
	
	String getBrand() {
		return this.brand;
	}
	
	void showInfo() {
		System.out.printf("Item #: %d, %S %S: %d in stock.%n", stockNum, brand, name, quantity);
	}
}


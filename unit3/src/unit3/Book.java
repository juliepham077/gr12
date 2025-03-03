package unit3;

public class Book extends Item{
	String author;
	
	Book() {
		super();
		author = "";
	}
	
	Book(String name, int quantity, String author) {
		super(name, quantity);
		this.author = author;
	}
	
	void setAuthor(String author) {
		this.author = author;
	}
	
	String getAuthor() {
		return this.author;
	}
	
	void showInfo() {
		System.out.printf("Item #: %d, %S by %S: %d in stock.%n", stockNum, name, author, quantity);
	}
}

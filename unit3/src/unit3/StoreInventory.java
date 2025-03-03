package unit3;

import java.util.*;
public class StoreInventory {
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		//Create an inventory for each department
		Inventory books = new Inventory();
		Inventory electronics = new Inventory();
		
		//add a few items to the inventory
		electronics.addItem(new Electronics("55-inch TV", 50, "Samsung"));
		electronics.addItem(new Electronics("iPhone 12", 50, "Apple"));
		books.addItem(new Book("The Sunlit Man", 20, "Brandon Sanderson"));
		books.addItem(new Book("Spare", 20, "Prince Harry"));
		
		int option = 0, stock;
		boolean play = true;
		
		System.out.println("           Store Inventory Program           ");
		while (play) {
			//Display menu and get user choice
			System.out.println("==============================================");
			menu();
			System.out.print("Your choice: ");
			option = input.nextInt();
			input.nextLine();
			
			//perform chosen menu option
			switch (option) {
			//Add a new inventory item
			case 1:
				System.out.print("1 Electronics or 2 Books: ");
				int dept = input.nextInt();
				input.nextLine();
				if (dept == 1) addItem(electronics, 1);
				else if (dept == 2) addItem(books, 2);
				else System.out.println("Invalid option.");
				break;
			
				//Check for low inventory
			case 2:
				System.out.println("Low inventory - consider ordering more:");
				electronics.checkLowInventory();
				books.checkLowInventory();
				break;
				
			//Discontinue an item
			case 3:
				System.out.print("Enter stock number of item to discontinue: ");
				stock = input.nextInt();
				if (electronics.findItem(stock) > 0) electronics.discontinue(stock);
				else if (books.findItem(stock) > 0) books.discontinue(stock);
				else System.out.println("No such item in inventory.");
				break;
			
			//Search for the amount of a particular item
			case 4:
				System.out.print("Enter stock number: ");
				stock = input.nextInt();
				if (electronics.findItem(stock) > 0) electronics.getQuantity(stock);
				else if (books.findItem(stock) > 0) books.getQuantity(stock);
				else System.out.println("No such item in inventory.");
			
			//Show all items in the inventory
			case 5:
				electronics.showInventory();
				books.showInventory();
				break;
				
			//Quit program
			case 6:
				play = false;
				break;
			default:
				System.out.println("Invalid option - please select either 1, 2, 3, 4, or 5.");
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
				1. Add new Item
				2. Check Low Inventory
				3. Discontinue an Item
				4. Check Item Inventory
				5. Show All Inventory Items
				6. Quit
				""");
	}//end menu()
	
	
	/**
	 * Add a new item to the inventory
	 * @param inv	The new item to add
	 * @param dept	The department inventory to add the item to
	 */
	static void addItem(Inventory inv, int dept) {
		System.out.print("Item name: ");
		String name = input.nextLine();
		System.out.print("Quantity: ");
		int amount = input.nextInt();
		input.nextLine();
		if (dept == 1) {
			System.out.print("Brand: ");
			String brand = input.nextLine();
			inv.addItem(new Electronics(name, amount, brand));
		} else if (dept == 2) {
			System.out.print("Author: ");
			String author = input.nextLine();
			inv.addItem(new Book(name, amount, author));
		} else {
			System.out.println("Invalid option.");
		}
	}//end addItem()

}


package unit2;
/*
 * Julie Pham
 * Sept 14, 2023
 * search Classlist
 */
import java.util.*;
import java.io.*;
public class Classlist {
	static Scanner input = new Scanner(System.in);	
	static String first, last, full, name, id, mark;
	static int totalStudents = 0;
	public static void main(String[] args) {
		while (true) {
			File classlist = new File("G:\\My Drive\\2023-2024\\CS\\unit2\\Classlist.txt");
			System.out.println("What would you like to do?"
					+ "\n [1] Create a classlist"
					+ "\n [2] Add new students"
					+ "\n [3] Search for a student"
					+ "\n [4] Create a class report"
					+ "\n [5] Delete classlist");
			System.out.print("Please enter a number: ");
			int action = input.nextInt();
			switch (action) {
			case 1:
				createClasslist(classlist);
				break;
			case 2:
				writeClasslist(classlist);
				break;
			case 3:
				getStudentInfo(classlist);
				break;
			case 4:
			case 5:
				deleteClasslist(classlist);
				break;
			default: System.out.println("Invalid option.");
			}
		}
	}
	public static void createClasslist(File classlist) {
		if (classlist.exists()) {
			System.out.println("Classlist already exists.");
		} else {
			try {
				classlist.createNewFile();
				System.out.println("New classlist created.");
				writeClasslist(classlist);
			} catch (IOException e) {
				System.out.println("File could not be created.");
				System.out.println("IOException: " + e.getMessage());
			}
		}
	}
	public static void writeClasslist(File classlist) {		
		System.out.print("Number of students: ");
		int students = input.nextInt();
			try {
				FileWriter out = new FileWriter(classlist);
			    BufferedWriter myWriter = new BufferedWriter(out);
			    for (int i = 0; i < students; i++) {
			    	totalStudents ++;
			    	System.out.println("_____________________________"
			    		 + "\nSTUDENT #" + totalStudents);
					System.out.print("Enter first name: ");
					myWriter.write(input.next() + " ");
					System.out.print("Enter last name: ");
					myWriter.write(input.next() + "\n");
					System.out.print("Enter id number: ");
					myWriter.write("ID number: " + input.next() + "\n");
					System.out.print("Enter mark: ");
					myWriter.write("Mark: " + input.next() + "%\n");
					myWriter.write("_____________________________\n");
			      }
			      myWriter.close();
			      out.close();
			      System.out.println("Successfully added new students.");
			    } catch (IOException e) {
			      System.out.println("Problem writing to file.");
			      System.out.println("IOException: " + e.getMessage());
			    }
		}

	public static void getStudentInfo(File classlist) {	
		System.out.println("STUDENT SEARCH PROGRAM"
				+ "\n Search options:"
				+ "\n [1] By first and last name"
				+ "\n [2] By ID number");
		System.out.print("How would you like to search? [1] or [2]: ");
		int option = input.nextInt();
		
		switch (option) {
		case 1:
			System.out.print("Enter first name: ");
			first = input.next();
			System.out.print("Enter last name: ");
			last = input.next();
			full = first + " " + last;
			searchByName(classlist);
			break;
		case 2:
			System.out.print("Enter ID number: ");
			id = input.next();
			searchById(classlist);
			break;
		default:
			System.out.println("Invalid option.");
			getStudentInfo(classlist);
		}
	}
	public static void searchByName(File classlist) {
		try {
			Scanner myReader = new Scanner(classlist);
			while (myReader.hasNextLine()) {
		        name = myReader.nextLine();
		        if (name.equals(full)) {
		        	id = myReader.nextLine();
		        	mark = myReader.nextLine();
		        	displayInfo(classlist);
		        }
			} 
			myReader.close();
		} catch (FileNotFoundException e) {
		      System.out.println("File does not exist or could not be found.");
		      System.err.println("FileNotFoundException: " + e.getMessage());
		} catch (IOException e) {
			      System.out.println("Problem reading file.");
			      System.err.println("IOException: " + e.getMessage());
		}
	}
	public static void searchById(File classlist) {
		
			
		try {
			Scanner myReader = new Scanner(classlist);
			while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
			} 
			myReader.close();
		} catch (FileNotFoundException e) {
		      System.out.println("File does not exist or could not be found.");
		      System.err.println("FileNotFoundException: " + e.getMessage());
		} catch (IOException e) {
			      System.out.println("Problem reading file.");
			      System.err.println("IOException: " + e.getMessage());
		}
	}
	public static void displayInfo(File classlist) {
		System.out.println(name);
		System.out.println("ID number: " + id);
		System.out.println("Mark: " + mark);
	}
	public static void deleteClasslist(File classlist) {
		if (classlist.delete()) { 
			totalStudents = 0;
		    System.out.println("Classlist deleted.");
		} else {
		    System.out.println("Failed to delete the file.");
		} 
	}
}

package review;
/*
 * Julie Pham
 * Sept 22, 2023
 * Clickbait generator
 */

import java.util.Random;
import java.util.Scanner;

public class assignment2 {

	public static void main(String[] args) {
		
		boolean play = true; //if user wants to keep playing
		int headlines =-1; //# of headlines user wants
		String[] nouns = {"Clown", "Girl", "Mouse", "Pig"};
		String[] nouns2 = {"Boy", "Teacher", "Baby", "Elephant"};
		String[] places = {"New York", "London", "Tokyo", "Texas"};
		String[] verbs = {"eats", "kills", "fights", "bullies"};
		int noun = 1, noun2 = 1, place = 1, verb = 1, headline; //selected words
		
		Scanner input = new Scanner(System.in);
		Random rand = new Random();
		
		System.out.println("HEADLINE GENERATOR\r\n"
				+ "==================================================\r\n"
				+ "Here at Clix.com, we are all about getting people to look at our ads!");
		
		//main loop
		while (play) {
		//error handling
		do {
			try {
				System.out.print("Enter the number of clickbait headlines to generate: ");
				headlines = input.nextInt();
				//if integer entered but out of range, throw exception
				if (headlines < 0) throw new ArithmeticException();
			} catch (ArithmeticException e) {
				System.out.println("Please ensure your integer is a positive number.");
			//Catch any non-integer input
			} catch (Exception e) {
				System.out.println("You must enter an integer.");
				input.nextLine();
				headlines = -1;
			}
		} while (headlines < 0);
		
		System.out.println("==================================================\r\n"
				+ "HEADLINES\r\n"
				+ "==================================================");
		
		//generating headlines
		for (int i = 0; i < headlines; i++) {			
			headline = rand.nextInt(3) +1;
			switch (headline) {
			case 1: believe(rand, noun, noun2, verb, place, nouns, nouns2, verbs, places); break;
			case 2: reasons(rand, noun, noun2, verb, place, nouns, nouns2, verbs, places); break;
			case 3: know(rand, noun, noun2, verb, place, nouns, nouns2, verbs, places); break;
			}
		}
		
		//ask if user wants more headlines
		boolean invalid = true;
		while (invalid) {
				System.out.print("Would you like to generate more headlines? [y] or [n]: ");
				String more = input.next();
				if (more.equals("y") || more.equals("Y")) {
					play = true;
					invalid = false;
				}
				else if (more.equals("n") || more.equals("N")) {
					play = false;
					invalid = false;
				}
				else {
					System.out.println("Invalid input.");
					invalid = true;
				}
		}
	}
		input.close();
		System.out.print("Goodbye.");
	}
	
	public static void believe(Random rand, int noun, int noun2, int verb, int place, String[] nouns, String[] nouns2, String[] verbs,String[] places) {
		noun = rand.nextInt(4);
		noun2 = rand.nextInt(4);
		verb = rand.nextInt(4);
		place = rand.nextInt(4);
		System.out.println("You won't believe how " + nouns[noun] + " "+verbs[verb]+" "+ nouns2[noun2] + " in "+places[place]+".");
	}
	public static void reasons(Random rand, int noun, int noun2, int verb, int place, String[] nouns, String[] nouns2, String[] verbs,String[] places) {
		noun = rand.nextInt(4);
		noun2 = rand.nextInt(4);
		verb = rand.nextInt(4);
		place = rand.nextInt(4);
		System.out.println("3 Reasons Why " + nouns[noun] + " "+verbs[verb]+" "+ nouns2[noun2] + " in "+places[place]+".");
	}
	public static void know(Random rand, int noun, int noun2, int verb, int place, String[] nouns, String[] nouns2, String[] verbs,String[] places) {
		noun = rand.nextInt(4);
		noun2 = rand.nextInt(4);
		verb = rand.nextInt(4);
		place = rand.nextInt(4);
		System.out.println("Did you know " + nouns[noun] + " "+verbs[verb]+" "+ nouns2[noun2] + " in "+places[place]+".");
	}
}

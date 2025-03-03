package review;

import java.util.Scanner;
import java.util.Random;

public class activity1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random rand = new Random();
		
		System.out.print("What's your name? ");
		String name = input.nextLine();
		System.out.print("How old are you? ");
		int age = input.nextInt();
		System.out.println("Hi " +name+ "\nYou are " +age+ " years old");
		
		if (age > 17) {
			System.out.println("You can vote!");
		}
		else {
			System.out.println("You can't vote...");
		}
		
		int secret = rand.nextInt(20) +1;
		System.out.print("Let's play a guessing game! \nGuess a number between 1-20: ");
		int guess = input.nextInt();
		
		while (guess != secret) {
			if (guess > secret) {
				System.out.println("too high");
			}
			if (guess < secret) {
				System.out.println("too low");
			}
			System.out.println("Guess again: ");
			guess = input.nextInt();
		}
		
		System.out.println("just right!");
		
		System.out.print("What is your grade? ");
		int grade = input.nextInt() /10;
		switch (grade) {
		case 0: 
		case 1: 
		case 2:
		case 3: 
		case 4: System.out.println("F"); break;
		case 5: System.out.println("E"); break;
		case 6: System.out.println("D"); break;
		case 7: System.out.println("C"); break;
		case 8: System.out.println("B"); break;
		case 9: 
		case 10: System.out.println("A"); break;
		default: System.out.println("Something's wrong :("); break;
		}
		
		input.close();

	}

}

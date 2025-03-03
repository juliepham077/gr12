package review;

import java.util.Random;
import java.util.Scanner;

public class activity2 {

	public static void main(String[] args) {
		// while loop: print 1-5
		int num = 1;
		while (num < 6) {
			System.out.println(num);
			num ++;
		}
		
		// do while loop: print 1-5
		int num2 = 1;
		do {
			System.out.println(num2);
			num2 ++;
		} while (num2 < 6);
		
		// for loop: print 1-5
		for (int i=1; i<6; i++) {
			System.out.println(i);
		}
		
		Random rand = new Random();
		int guessMe = rand.nextInt(20) +1;
		System.out.println(guessMe);
		for (int i = 1; i < 22; i=i+2) {
			if (i < guessMe) {
				System.out.println("too low" + i);
			}
			else if (i == guessMe) {
				System.out.println("found it!" + i);
				break;
			}
			else if (i > guessMe) {
				System.out.println("oops!" + i);
				break;
			}
		}

		Scanner input = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int userNum = input.nextInt();
		int sum = 0;
		for (int i = 1; i < userNum +1; i++) {
			System.out.println(i);
			sum += i;
		}
		System.out.println("The sum is: " +sum);
		
		System.out.print("Enter a number: ");
		int num3 = input.nextInt();
		boolean prime=true;
		for (int i = 2; i < num3; i++) {
			if (num3%i == 0) {
				System.out.print("This number is not prime."); prime=false; break;
			}
		}
		if (prime) System.out.print("This number is prime.");
		
		input.close();
	}

}

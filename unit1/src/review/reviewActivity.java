package review;

import java.util.Random;
import java.util.Scanner;

public class reviewActivity {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random rand = new Random();
		
		int wins = 0, losses = 0, ties = 0;
		int play, comp;
		String[] choice = {"Rock", "Paper", "Scissors", "Lizard", "Spock"};
		
		System.out.print("Rock, Paper, Scissors, Lizard, Spock\r\n"
				+ "====================================\r\n"
				+ "Rules of the Game:\r\n"
				+ "You will choose your throw. I will choose my throw. The winner will be determined based on the the following rules:\r\n"
				+ "ROCK breaks SCISSORS and crushes LIZARD\r\n"
				+ "PAPER covers ROCK and disproves SPOCK\r\n"
				+ "SCISSORS cuts PAPER and decapitates LIZARD\r\n"
				+ "LIZARD poisons SPOCK and eats PAPER\r\n"
				+ "SPOCK breaks SCISSORS and vaporizes ROCK\r\n"
				+ "==========================================\r\n");
		
		showRecords (wins, losses, ties);
		
		System.out.println("\nWhat do you throw: 1 = ROCK, 2 = PAPER, 3 = SCISSORS, 4 = LIZARD, 5 = SPOCK");
		System.out.print("Choice: ");
		play = input.nextInt() -1;
		comp = rand.nextInt(5);
		System.out.println(choice[play] + " versus... " + choice[comp] +"!");
		getResult(play, comp, wins, losses, ties);
		
	}

	public static void showRecords (int wins, int losses, int ties) {
		int games = wins + losses + ties;
		System.out.println("Current Record:");
		System.out.println("Total Games Played: " + games);
		System.out.println("Wins: " + wins + "   Losses: " + losses + "   Ties: " + ties);
	}
	
	public static void getResult(int play, int comp, int wins, int losses, int ties) {
		if (play == comp) {
			System.out.println("It's a tie!");
		}
		else {
			int win = 0, loss = 0;
			switch (play) {
			case 0:
				if (comp == 2 || comp == 3) win = 1;
				else loss = 1;
				break;
			case 1:
				if (comp == 0 || comp == 4) win = 1;
				else if (comp == 2) loss = 1;
				break;
			case 2:
				if (comp == 1 || comp == 3) win = 1;
				else loss = 1;
				break;
			case 3:
				if (comp == 1 || comp == 4) win = 1;
				else loss = 1;
				break;
			case 4:
				if (comp == 2 || comp == 0) win = 1;
				else loss = 1;
				break;
			}
			if (win == 1) System.out.println("You win!");
			else if (loss == 1) System.out.println("You lose!");
			else System.out.println("something's wrong");
		}
	}
}
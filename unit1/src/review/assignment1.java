package review;
/*
 * Julie Pham
 * Sept 14, 2023
 * Dice Roll Simulation
 */
import java.util.Random;
import java.util.Scanner;
public class assignment1 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		Random rand = new Random();
		int[] dice = new int[6]; //create dice array of 6
		int outcome; //outcome of dice roll
		boolean sim; //simulation true/false
		String play; //user input play Y/N
		
		//intro
		System.out.print("Welcome to the Dice Roll Simulator\r\n"
				+ "==================================\r\n");
		
		//main loop
		do {
		
		// set outcome to 0
		for (int i = 0; i<6; i++) {
			dice[i] =0;
		}
			
		System.out.print("How many times would you like the simulation to run? (e.g. 1000) > "); //prompt user for # of rolls
		int times = input.nextInt();
		
		System.out.println("Running simulation...");
		
		//roll and count each roll
		for (int rolls=0; rolls<times; rolls++) {
			outcome = rand.nextInt(6);
			dice[outcome] +=1;
		}
		
		System.out.println("Simulation complete.\r\n"
				+ "==================================");
		
		//display rolls
		for (int i = 1; i<=6; i++) {
			System.out.println(i+ " was rolled " + dice[i-1] +" times.");
		}
		
		//ask to play again
		System.out.print("==================================\r\n"
				+ "Would you like to run another simulation? Y or N > ");
		play = input.next();
			if (play.equals("Y")) {
				sim = true;
			}
			else sim=false;
			
		} while (sim);
		
		System.out.print("==================================\r\n"
				+ "Session Terminated...Goodbye\r\n"); //end
		input.close();
	}

}

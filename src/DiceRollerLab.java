import java.util.Random;
import java.util.Scanner;

/**
 * Dice Roller Lab
 * 
 * Assignment:
 * Ask the user to enter the number of sides for a pair of dice. Prompt the user
 * to roll the dice. “Roll” two n-sided dice, display the results of each, and
 * then ask the user if he/she wants to roll the dice again.
 * 
 * Extra Challenges:
 * Display special messages for craps, snake eyes, and box cars.
 * 
 * @author Brendan
 *
 */
public class DiceRollerLab {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome to the Grand Circus Casino!");
		System.out.println("How many sides should each die have?");
		
		int sides = scanner.nextInt();
		int rolls = 0;
		
		do {
			rolls++;
			int diceA = generateRandomDieRoll(sides);
			int diceB = generateRandomDieRoll(sides);
			System.out.println("Roll " + rolls + ":");
			System.out.println(diceA);
			System.out.println(diceB);
			generateMessage(diceA, diceB);
			System.out.println("Roll again? (y/n)");
		} while (scanner.next().toLowerCase().startsWith("y"));
		
		System.out.println("Goodbye!");

		scanner.close();
	}

	/**
	 * Displays a message if the user rolled Snake Eyes, Craps, or Box Cars.
	 * If dice A and B are equal to 1, for example, "Snake Eyes!" will print to console.
	 * 
	 * @param diceA The first dice roll
	 * @param diceB The second dice roll
	 */
	public static void generateMessage(int diceA, int diceB) {
		int sum = diceA + diceB;
		if (diceA == 1 && diceB == 1) {
			System.out.println("Snake Eyes!");
		}
		if (sum == 2 || sum == 3 || sum == 12) {
			System.out.println("Craps!");
		}
		if (diceA == 6 && diceB == 6) {
			System.out.println("Boxcars!");
		}
	}

	/**
	 * Rolls a dice based on how many sides were provided.  This will always return a number
	 * greater than 0 because dice typically don't have 0
	 * 
	 * @param sides The amount of sides on the dice to roll
	 * @return A random number between 
	 */
	public static int generateRandomDieRoll(int sides) {
		Random random = new Random();
		int roll = random.nextInt(sides);
		do {
			roll = random.nextInt(sides);
		} while(roll == 0);
		return roll;
	}
}

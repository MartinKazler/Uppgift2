import java.util.Random;
import java.util.Scanner;

public class VeckanUppgift22 {

	public static final String ROCK = "R";
	public static final String PAPER = "P";
	public static final String SCISSORS = "S";

	public static void main(String[] args) {
		String response = null;
		Scanner scan = new Scanner(System.in);
		System.out.println("Hey, let's play Rock, Paper, Scissors!\n" + "Please enter a move.\n"
				+ "Rock = R\nPaper= P\n" + "Scissors = S.\n");
		while (scan.hasNext()) {
			System.out.println("Enter your play: ");
			response = scan.next().toUpperCase();
			if (response.equals(PAPER) || response.equals(ROCK) || response.equals(SCISSORS)) {
				String output = printDescision(response, getComputerPlay());
				System.out.println(output);
				if (output.contains("lose")) {
					break;
				}
			} else {
				System.out.println("Invalid Input " + response);
			}
		}
		System.out.println("Exiting Game");
		System.exit(0);
	}

	public static String getComputerPlay() {
		int computerInt;
		String DatorFan = "";
		Random generator = new Random();
		computerInt = generator.nextInt(3) + 1;
		if (computerInt == 1)
			DatorFan = ROCK;
		else if (computerInt == 2)
			DatorFan = PAPER;
		else if (computerInt == 3)
			DatorFan = SCISSORS;
		return DatorFan;
	}

	public static String printDescision(String personPlay, String computerPlay) {
		String output = "";
		System.out.println("Computer play is: " + computerPlay);
		if (personPlay.equals(computerPlay))
			output = "It's a tie!";
		else if (personPlay.equals(ROCK)) {
			if (computerPlay.equals(SCISSORS))
				output = "Rock crushes scissors. You win!!";
			else if (computerPlay.equals(PAPER))
				output = "Paper eats rock. You lose!!";
		} else if (personPlay.equals(PAPER)) {
			if (computerPlay.equals(SCISSORS))
				output = "Scissor cuts paper. You lose!!";
			else if (computerPlay.equals(ROCK))
				output = "Paper eats rock. You win!!";
		} else if (personPlay.equals(SCISSORS)) {
			if (computerPlay.equals(PAPER))
				output = "Scissor cuts paper. You win!!";
			else if (computerPlay.equals(ROCK))
				output = "Rock breaks scissors. You lose!!";
		} else {
			output = "Invalid user input.";
		}
		return output;
	}
}
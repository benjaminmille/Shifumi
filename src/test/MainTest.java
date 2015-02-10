package test;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import main.Trick;

import org.junit.AfterClass;
import org.junit.Test;


public class MainTest {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int scoreUser = 0;
		int scoreAI = 0;
		int nbTry = 0;
		int[] gameInfo = new int[3];
		
		Scanner sc = new Scanner(System.in);
		System.out.println("The game begin.\nEntert:\n- R for Rock\n- F for Paper\n- S for Scissors\n- E to leave the game.");
		
		while (nbTry != 10)
		{	
			String str = "";
			System.out.println("\nEnter your choice:");
			str = sc.next();
			if (str.equals("R") || str.equals("P") || str.equals("S")) {
				scoreUser = gameInfo[0]; scoreAI = gameInfo[1]; nbTry = gameInfo[2];
			} else if (str.equals("E")) {
				endGame(scoreUser, scoreAI);
			} else {
				System.out.printf("\nInvalid input.");
			}
		}
		sc.close();
		endGame(scoreUser, scoreAI);
	}
	
	/**
	 * @param scoreUser The user score.
	 * @param scoreAI The AI score.
	 */
	public static boolean endGame(int scoreUser, int scoreAI) {
		try {
			if (scoreUser > scoreAI) {
				System.out.printf("\nYou win the game: " + scoreUser + "-" + scoreAI);
			} else if (scoreUser < scoreAI) {
				System.out.printf("\nYou lose the game: " + scoreUser + "-" + scoreAI);
			} else {
				System.out.printf("\nNo winner for this game: " + scoreUser + "-" + scoreAI);
			}
		    return true;
		}
		catch (Exception e){
			return false;
		}
	}
	/**
	 * @return rdm A random number.
	 */
	public static int randomNb() {
		Random ran = new Random(new Date().getTime());
		int rdm = ran.nextInt(3);
	    return rdm;
	}
	/**
	 * @param str The input of the user.
	 * @param scoreUser The user score.
	 * @param scoreAI The AI score.
	 * @return gameInfo An array with the scores and the number of try.
	 */
	public static boolean game(String str, int scoreUser, int scoreAI, int nbTry) {
		try {
			int rdm = randomNb();
			int[] gameInfo = new int[3];
			Trick TrickUser = null;
			String TrickAI = "";
			String result = "";
			
			if (str.equals("R")){
				TrickUser = Trick.R;
			} else if (str.equals("P")) {
				TrickUser = Trick.P;
			} else if (str.equals("S")) {
				TrickUser = Trick.S;
			}
			
			switch (rdm) {
				case 0:
					result = TrickUser.getResRock();
					TrickAI = "Rock";
				break;
				case 1:
					result = TrickUser.getResPaper();
					TrickAI = "Paper";
				break;
				case 2:
					result = TrickUser.getResScissors();
					TrickAI = "Scissors";
			}
			
			switch (result) {
				case "You win":
					scoreUser++;
				break;
				case "You lose":
					scoreAI++;
				break;
			}
			nbTry++;
			System.out.printf("You: " + TrickUser.getName() + "\nAI: " + TrickAI + "\n" + result + ".\nYou still: " + (10 - nbTry) + " tries.");
			gameInfo[0] = scoreUser;
			gameInfo[1] = scoreAI;
			gameInfo[2] = nbTry;
			return true;
		}
		catch (Exception e){
			return false;
		}
	}
}

package main;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author bmille
 *
 */
public class MainClass {
	/**
	 * @param args Argument.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainClass main = new MainClass();
		main.runShifu();
	}
	
	/** Run the shifu. */
	public void runShifu() {
		int scoreUser = 0;
		int scoreAI = 0;
		int nbTry = 0;
		final int zero = 0;
		final int un = 1;
		final int deux = 2;
		final int nbGameInfo = 3;
		final int valueTry = 10;
		int[] gameInfo = new int[nbGameInfo];
		
		Scanner sc = new Scanner(System.in);
		System.out.println("The game begin.\nEnter:\n- R for rock\n- F for "
						+ "paper\n- S for scissors\n- E to leave the game.");
		
		while (nbTry != valueTry) {	
			String str = "";
			System.out.println("\nEnter your choice:");
			str = sc.next();
			if (str.equals("R") || str.equals("P") || str.equals("S")) {
				gameInfo = game(str, scoreUser, scoreAI, nbTry);
				scoreUser = gameInfo[zero]; 
				scoreAI = gameInfo[un]; 
				nbTry = gameInfo[deux];
			} else if (str.equals("E")) {
				endGame(scoreUser, scoreAI);
			} else {
				System.out.printf("\nInvalid input.");
			}
		}
		sc.close();
		endGame(scoreUser, scoreAI);
		System.exit(0);
	}
	/**
	 * @param scoreUser The user score.
	 * @param scoreAI The AI score.
	 */
	public String endGame(int scoreUser, int scoreAI) {
		String str = "";
		if (scoreUser > scoreAI) {
			str = "%nYou win the game: " + scoreUser + "-" + scoreAI;
		} else if (scoreUser < scoreAI) {
			str = "%nYou lose the game: " + scoreUser + "-" + scoreAI;
		} else {
			str = "%nNo winner for this game: " + scoreUser + "-" + scoreAI;
		}
	    return str;
	}
	/**
	 * @return rdm A random number.
	 */
	public static int randomNb() {
		final int trois = 3;
		Random ran = new Random(new Date().getTime());
		int rdm = ran.nextInt(trois);
		return rdm;
	}
	/**
	 * @param str The input of the user.
	 * @param scoreUser The user score.
	 * @param scoreAI The AI score.
	 * @param nbTry The number of try of the user.
	 * @return gameInfo An array with the scores and the number of try.
	 */
	public static int[] game(String str, int scoreUser, int scoreAI, 
							int nbTry) {
		int rdm = randomNb();
		final int trois = 3;
		final int dix = 10;
		int[] gameInfo = new int[trois];
		Trick trickUser = null;
		String trickAI = "";
		String result = "";
		
		if (str.equals("R")) {
			trickUser = Trick.R;
		} else if (str.equals("P")) {
			trickUser = Trick.P;
		} else if (str.equals("S")) {
			trickUser = Trick.S;
		}
		
		switch (rdm) {
			case 0:
				result = trickUser.getResRock();
				trickAI = "Rock";
			break;
			case 1:
				result = trickUser.getResPaper();
				trickAI = "Paper";
			break;
			case 2:
				result = trickUser.getResScissors();
				trickAI = "Scissors";
			default:
		}
		
		switch (result) {
			case "You win":
				scoreUser++;
			break;
			case "You lose":
				scoreAI++;
			break;
			default:
		}
		nbTry++;
		System.out.printf("You: " + trickUser.getName() + "%nAI: " + trickAI 
				+ "%n" + result + ".%nYou still: " 
				+ (dix - nbTry) + " tries.");
		gameInfo[0] = scoreUser;
		gameInfo[1] = scoreAI;
		gameInfo[2] = nbTry;
		return gameInfo;
	}
}

package main;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;

public class MainTest {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	@Test
	public void endGameTest() {
		int scoreUser = 3;
		int scoreAI = 6;
		MainClass main = new MainClass();
		
		String str = main.endGame(scoreUser, scoreAI);
		
		Assert.assertEquals("%nYou lose the game: " + scoreUser + "-" + scoreAI, str);
	}
	
	@Test
	public void randomNbTest() {
		int ranNb = MainClass.randomNb();
		boolean test = false;
		
		if (ranNb > -1 && ranNb < 3) {
			test = true;
		}
		
		Assert.assertTrue(test);
	}
	
	@Test
	public void gameTest() {
		String trick = "R";
		int scoreUser = 0;
		int scoreAI = 0;
		int nbTry = 0;
		
		int gameInfo[] = MainClass.game(trick, scoreUser, scoreAI, nbTry);
		
		Assert.assertEquals(gameInfo[2], 1);
	}
}

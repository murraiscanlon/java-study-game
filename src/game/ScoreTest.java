package game;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
/**
 * Test for Score class
 * @author Team 30
 *
 */
class ScoreTest {

	// Test that initial score is zero and that the points are added correctly
	@Test
	void testAddPoints() {
		Score score = new Score();
		assertEquals(score.getCurrentScore(), 0);
		score.addPoints(3);
		assertEquals(score.getCurrentScore(), 3);		
		score.addPoints(5);
		assertEquals(score.getCurrentScore(), 8);		}

	// Test that the number of wrong questions is incremented correctly
	@Test
	void testIncrementWrongQuestions() {
		Score score = new Score();
		assertEquals(score.getNumberOfQuestionsWrong(), 0);
		score.incrementWrongQuestions();
		assertEquals(score.getNumberOfQuestionsWrong(), 1);
		score.incrementWrongQuestions();
		assertEquals(score.getNumberOfQuestionsWrong(), 2);
	}

	/* Score holds the treasures that the player has.  Test that the score
	 * has the treasure and can access the points correctly
	 */
	@Test
	void testGetTreasures() {
		Score score = new Score();
		Treasure t1 = new Treasure("Gold", 5, null);
		Treasure t2 = new Treasure("Silver", 3, null);
		score.addTreasure(t1);
		score.addTreasure(t2);
		ArrayList<Treasure> ts = score.getTreasures();
		assertEquals(ts.get(0).getTreasureType(), "Gold");
		assertEquals(ts.get(1).getTreasureType(), "Silver");
		assertEquals(ts.get(0).getPoints(), 5);
		assertEquals(ts.get(1).getPoints(), 3);
	}

	// Set the score to one point below target and make sure that the game continues
	// Add one more point and make sure the game status changed to GameOverWin
	@Test
	void testCheckGameStatus_Win() {
		Score score = new Score();
		score.addPoints(score.scoreTarget - 1);
		assertEquals(score.checkGameStatus(), GameStatus.GAME_CONTINUE);		
		score.addPoints(1);
		assertEquals(score.checkGameStatus(), GameStatus.GAME_OVER_WIN);				
	}
	
	// Increment wrong questions to one less than target to lose and verify game continues
	// Increment one more wrong question and verify that the game status changes to GameOverLose
	@Test
	void testCheckGameStatus_Lose() {
		Score score = new Score();
		for (int i = 1; i<score.wronqQuestionTarget; i++) {
			score.incrementWrongQuestions();
		}
		assertEquals(score.checkGameStatus(), GameStatus.GAME_CONTINUE);		
		score.incrementWrongQuestions();
		assertEquals(score.checkGameStatus(), GameStatus.GAME_OVER_LOSE);				
	}
}

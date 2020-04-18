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

	@Test
	void testAddPoints() {
		Score score = new Score();
		assertEquals(score.getCurrentScore(), 0);
		score.addPoints(3);
		assertEquals(score.getCurrentScore(), 3);		
		score.addPoints(5);
		assertEquals(score.getCurrentScore(), 8);		}

	@Test
	void testIncrementWrongQuestions() {
		Score score = new Score();
		assertEquals(score.getNumberOfQuestionsWrong(), 0);
		score.incrementWrongQuestions();
		assertEquals(score.getNumberOfQuestionsWrong(), 1);
		score.incrementWrongQuestions();
		assertEquals(score.getNumberOfQuestionsWrong(), 2);
	}

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

	@Test
	void testCheckGameStatus_Win() {
		Score score = new Score();
		score.addPoints(score.scoreTarget - 1);
		assertEquals(score.checkGameStatus(), GameStatus.GameContinue);		
		score.addPoints(score.scoreTarget - 1);
		assertEquals(score.checkGameStatus(), GameStatus.GameOverWin);				
	}
	
	@Test
	void testCheckGameStatus_Lose() {
		Score score = new Score();
		for (int i = 1; i<score.wronqQuestionTarget; i++) {
			score.incrementWrongQuestions();
		}
		assertEquals(score.checkGameStatus(), GameStatus.GameContinue);		
		score.incrementWrongQuestions();
		assertEquals(score.checkGameStatus(), GameStatus.GameOverLose);				
	}

}

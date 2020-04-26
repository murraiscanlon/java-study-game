package game;

import java.util.ArrayList;

/**
 * Score class adds Treasure points, maintains running score & displays final
 * score
 * 
 * @author Team 30
 *
 */
public class Score {
	/**
	 * Instance Variables for Score class
	 */
	private ArrayList<Treasure> treasures = new ArrayList<Treasure>();
	private int currentScore = 0;
	private int numberOfQuestionsWrong = 0;
	private String name = "";
	// constants are not set to private for ability to test class
	final int scoreTarget = 20;
	final int wronqQuestionTarget = 3;

	/**
	 * Constructor
	 */
	public Score() {
	}

	/**
	 * Method adds points when the player correctly answers a question
	 * 
	 * @param points - number of points to add
	 * @return - current score
	 */
	public int addPoints(int points) {
		currentScore += points;
		return currentScore;
	}

	/**
	 * Method returns current score
	 * 
	 * @return - current score
	 */
	public int getCurrentScore() {
		return currentScore;
	}

	/**
	 * Method to increment the number questions player got wrong
	 */
	public void incrementWrongQuestions() {
		numberOfQuestionsWrong++;
	}

	/**
	 * Method to return the number of questions player got wrong
	 * 
	 * @return - number of questions player got wrong
	 */
	public int getNumberOfQuestionsWrong() {
		return numberOfQuestionsWrong;
	}

	/**
	 * Method to add treasure to the list of treasures player won
	 * 
	 * @param t : treasure to add
	 */
	public void addTreasure(Treasure t) {
		treasures.add(t);
	}

	/**
	 * Method to get the ArrayList of treasures
	 * 
	 * @return ArrayList of treasures
	 */
	public ArrayList<Treasure> getTreasures() {
		return treasures;
	}

	/**
	 * Method to get the name of the player
	 * 
	 * @return player name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Method to set the name of the player
	 * 
	 * @param name - player name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Method to return game status Use GameStatus enum to return the game status
	 * 
	 * @return GameStatus
	 */
	public GameStatus checkGameStatus() {
		if (numberOfQuestionsWrong >= wronqQuestionTarget) { // Player loses if too many wrong questions
			return GameStatus.GAME_OVER_LOSE;
		} else if (currentScore >= scoreTarget) { // Player wins if they get target number of points
			return GameStatus.GAME_OVER_WIN;
		} else {
			return GameStatus.GAME_CONTINUE;
		}
	}
}

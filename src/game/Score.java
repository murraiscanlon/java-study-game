package game;

import java.util.ArrayList;

/**
 * Score class adds Treasure points, maintains running score & displays final score
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
	final int scoreTarget = 5;
	final int wronqQuestionTarget = 20;
	private String name = "Bob";
    
    /**
     * Constructor
     * @param
     */
    public Score() {        
    }
    
    /**
     * Method adds points when the player correctly answers a question
     * @return
     */
    public int addPoints(int points) {
    	currentScore+= points;
        return currentScore;
    }

    /**
     * Method returns running score of points received
     * @param addPoints
     * @return
     */
    public int getCurrentScore() {
        return currentScore;
    }
    
    /**
     * Method to increment the number of wrong questions
     */
    public void incrementWrongQuestions() {
    	numberOfQuestionsWrong ++;
    }
    
    public int getNumberOfQuestionsWrong() {
    	return numberOfQuestionsWrong;
    }
    
    /**
     * Method to add treasure to the list
     * @param t : treasure to add
     */
    public void addTreasure(Treasure t) {
    	treasures.add(t);
    }
    
    /**
     * Method to get the ArrayList of treasures
     * @return ArrayList of treasures
     */
    public ArrayList<Treasure> getTreasures(){
    	return treasures;
    }
    
    public String getName() {
    	return name;
    }
    
    public void setName(String name) {
    	this.name = name;
    }

    /**
     * Method to return game status
     * Use GameStatus enum to return the game status
     * @return GameStatus
     */
    public GameStatus checkGameStatus() {
    	if(numberOfQuestionsWrong >= wronqQuestionTarget) {
    		return GameStatus.GameOverLose;
    	}
    	else if (currentScore >= scoreTarget) {
    		return GameStatus.GameOverWin;
    	} 
    	else {
    		return GameStatus.GameContinue;
    	}
    }
}

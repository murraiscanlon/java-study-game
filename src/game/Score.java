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
	final int scoreTarget = 20;
	final int wronqQuestionTarget = 3;
    
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
     * Method subtracts points when the player uses a hint to help answer a question
     * @return
     */
    public int losePoints(int points) {
    	currentScore-= points;
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
    
    /**
     * Method to return game status
     * 0 : game in progress
     * 1 : player received enough point and won
     * 2 : player had too many wrong questions and lost
     * @return int with status
     */
    public int checkGameStatus() {
    	if(numberOfQuestionsWrong >= wronqQuestionTarget) {
    		return 2;
    	}
    	else if (currentScore >= scoreTarget) {
    		return 1;
    	} 
    	else {
    		return 0;
    	}
    }

}

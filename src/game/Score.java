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
	Treasures t = new Treasures();
	static int currentScore;
	
    
    /**
     * Constructor
     * @param
     */
    public Score() {
    	//this.currentScore = 0;
        
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
    * Method sums up Treasure inventory at end of game
    * @param inventoryOfTreasures
    * @return
    */
    public int finalScore(ArrayList<Treasure> inventoryOfTreasures) {
        return 0;
    }

}

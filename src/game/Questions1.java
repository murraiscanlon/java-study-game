package game;

import java.util.ArrayList;

/**
 * 
 * The Questions class generates questions for the player to answer.
 *
 */

public class Questions1 {
	// Instance variables
	ArrayList<Question> qlist;
	static int questionCounter;
	Question currentQuestion;
	String currentHint;

	// Constructor
	Questions1() {
		this.qlist = QuestionReader.readCSVFile();
		this.questionCounter = 0;
		this.currentHint = " ";
		// this.currentQuestion ;
	}

	// Methods

	
	/**
	 * This method returns all components of the current question and then 
	 * removes all the components related to that question from the list of 
	 * available questions.
	 * 
	 * When we run out of questions, the game will be over. Another class will deal with that issue.
	 * 
	 */
	public Question getCurrentQuestion() {
		if (questionCounter < qlist.size()) {
			currentQuestion = qlist.get(questionCounter);
			qlist.remove(currentQuestion);
			questionCounter++;
			return currentQuestion;
		} else {
			return null; // game over??

		}

	}
	
	
	
	public String getCurrentHint() {
		
		for (Question q : qlist) {
			String locateHint = q.getHint();
			if (questionCounter == locateHint.indexOf(locateHint)) {
				currentHint = locateHint;
				//break;
			}
		}
		return currentHint;
	}
	
	
	
	

	// main method for testing
	public static void main(String[] args) {
		Questions1 q1 = new Questions1();
		System.out.println(q1.getCurrentQuestion());
		System.out.println(q1.getCurrentQuestion());
		System.out.println(q1.getCurrentHint());

	}

}

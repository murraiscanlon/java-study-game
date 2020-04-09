package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * The Questions class uses the data from QuestionReader to generate
 * a package of variables using the getCurrentQuestion method.
 */

public class Questions1 {
	// Instance variables
	ArrayList<Question> questions;
	static int questionCounter;
	Question currentQuestion;
	HashMap<String, String> hints;//not currently in use

	
	// Constructor
	Questions1() {
		this.questions = QuestionReader.readCSVFile();
		questionCounter = 0;
		//this.currentHint = " ";
		this.hints =  new HashMap<String, String>();
		
		//fill hints hashMap
		for (Question q : questions) {
			hints.put(q.getQuestion(), q.getHint());
		}
	}
	
	

	// Methods
	
	
	/**
	 * Method to provide random questions
	 * 
	 * @param questions
	 */
	public void shuffleQuestions(ArrayList<Question> questions) {
		Collections.shuffle(questions);
	}


	
	/**
	 * This method returns all components of the question class
	 * question, answer1 - 3, hint, and correctAnswer
	 * for one question at a time.
	 * 
	 */
	public Question getCurrentQuestion() {
		if (questionCounter < questions.size()) {
			currentQuestion = questions.get(questionCounter);
			questionCounter++;
			return currentQuestion;
		} else {
			return null; // game over??

		}

	}
		

//	// main method for testing
//	public static void main(String[] args) {
//		Questions1 q1 = new Questions1();
//		System.out.println(q1.getCurrentQuestion());
//		
//
//	}

}

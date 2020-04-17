package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * The Questions class uses the data from QuestionReader to generate
 * a package of variables using the getCurrentQuestion method.
 * @author Team 30
 */

public class Questions1 {
	/**
	 * Instance variables 
	 */
	private ArrayList<Question> questions;
	static int questionCounter; //does this need to be private?
	private Question currentQuestion;
	private HashMap<String, String> hints;//not currently in use

	
	/**
	 * Constructor
	 */
	public Questions1() {
		this.questions = QuestionReader.readCSVFile();
		questionCounter = 0;
		//this.currentHint = " ";
		this.hints =  new HashMap<String, String>();
		
		//fill hints hashMap
		for (Question q : questions) {
			hints.put(q.getQuestion(), q.getHint());
		}
	}
	
	/**
	 * Method to provide random questions
	 * 
	 * @param questions
	 */
	public void shuffleQuestions() {
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
			questionCounter = 0;
			return currentQuestion;

		}

	}
		
//TODO delete later
//	// main method for testing
//	public static void main(String[] args) {
//		Questions1 q1 = new Questions1();
//		System.out.println(q1.getCurrentQuestion());
//		
//
//	}

}

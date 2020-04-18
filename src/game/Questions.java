package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Questions reads in question file and generates question Interacts with
 * Characters
 * 
 * @author Team 30
 */
public class Questions {

	private ArrayList<Question> questions = new ArrayList<Question>();
	private int questionCounter;

	/**
	 * Constructor
	 */
	public Questions() {
		this.questions = QuestionReader.readCSVFile();
		this.questionCounter++;

	}

	/**
	 * Method will generate question from list Player will be provided multiple
	 * choice answers
	 * 
	 * @param questions
	 * @return
	 */
	public String generateQuestion(ArrayList<Question> questions) {
		Question currentQuestion = questions.get(questionCounter);
		if (questionCounter < questions.size()) {
			return currentQuestion.toString();

		} else {
			questionCounter = 0;
			return currentQuestion.toString();
		}

	}

	/**
	 * Method to provide random questions
	 * 
	 * @param questions
	 */
	public void shuffleQuestions(ArrayList<Question> questions) {
		Collections.shuffle(questions);
	}

	/**
	 * Check if answer is correct
	 * 
	 * @param answer
	 * @return
	 */
	public boolean isCorrect(String answer) {// do we need this?
		if (answer == "correct") {
			return true;
		} else
			return false;
	}

	/**
	 * Method will allow Player to ask for hint on question
	 * 
	 * @return
	 */
	public String getHint() {
		return null;
	}

	/**
	 * Getters and Setters
	 * 
	 * @return
	 */

	public ArrayList<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(ArrayList<Question> questions) {
		this.questions = questions;
	}

}

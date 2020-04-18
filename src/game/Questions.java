package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * The Questions class uses the data from QuestionReader to generate a package
 * of variables using the getCurrentQuestion method.
 * 
 * @author Team 30
 */

public class Questions {
	/**
	 * Instance variables
	 */
	private ArrayList<Question> questions;
	private int questionCounter;
	private Question currentQuestion;
	private HashMap<String, String> hints;

	/**
	 * Constructor
	 */
	public Questions() {
		this.questions = QuestionReader.readCSVFile();
		questionCounter = 0;
		this.hints = new HashMap<String, String>();

		// fill hints hashMap
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
	 * This method returns all components of the question class question, answer1 -
	 * 4, hint, and correctAnswer for one question at a time.
	 * 
	 */
	public Question getCurrentQuestion() {
		if (questionCounter < questions.size()) {
			currentQuestion = questions.get(questionCounter);
			questionCounter++;
			return currentQuestion;
		} else {
			questionCounter = 0; // Should not run out of questions but reset counter to avoid null question
			return currentQuestion;
		}
	}

	/*
	 * Return Question counter for JUnit testing
	 */
	public int getQuestionCounter() {
		return questionCounter;
	}
}

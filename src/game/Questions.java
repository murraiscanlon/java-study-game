package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Questions {

	/**
	 * Questions reads in question file and generates question Interacts with
	 * Characters
	 * 
	 * @author Team 30
	 */
	HashMap<String, String> hints = new HashMap<String, String>();
	static ArrayList<Question> questions = new ArrayList<Question>();
	static int questionCounter;
	

	/**
	 * Constructor
	 * 
	 * @param hints
	 * @param questions
	 */
	public Questions(HashMap<String, String> hints, ArrayList<Question> questions) {
		this.hints = hints;
		this.questions = questions;

	}
	
	//Contructor2
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

	public boolean isCorrect(String answer) {
		if (answer == "correct") {
			return true;
		} else
			return false;
	}

	/**
	 * Method to return Question w/multiple choice answers
	 * 
	 * @return
	 */
	public String formatQuestionOutput() {
		// Works with generateQuestion method
		
		

		return null;
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

	public HashMap<String, String> getHints() {
		return hints;
	}

	public void setHints(HashMap<String, String> hints) {
		this.hints = hints;
	}

	public ArrayList<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(ArrayList<Question> questions) {
		this.questions = questions;
	}

	
	//main method for testing
	public static void main(String[] args) {

	}
}

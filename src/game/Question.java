package game;

/**
 * Contains the question and multiple choice answers Player must correctly
 * answer to retrieve Treasures Fairy GodTA will provide hints on request
 * 
 * @author Team 30
 */
public class Question {
	/**
	 * Instance Variables
	 */
	private String question;
	private String answer1;
	private String answer2;
	private String answer3;
	private String answer4;
	private int correctAnswer;
	private String hint;

	/**
	 * Constructor
	 * 
	 * @param question - Question to ask the player
	 * @param answer1 - Answer option 1
	 * @param answer2 - Answer option 2
	 * @param answer3 - Answer option 3
	 * @param answer4 - Answer option 4
	 * @param hint - Player hint
	 * @param correctAnswer - contains the number of the correct answer
	 */
	public Question(String question, String answer1, String answer2, 
	                String answer3, String answer4, String hint, int correctAnswer) {
		this.question = question;
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.answer3 = answer3;
		this.answer4 = answer4;
		this.correctAnswer = correctAnswer;
		this.hint = hint;
	}

	/**
	 * Getters
	 * 
	 * @return - specified value
	 */

	public String getQuestion() {
		return question;
	}

	public String getAnswer1() {
		return answer1;
	}

	public String getAnswer2() {
		return answer2;
	}

	public String getAnswer3() {
		return answer3;
	}

	public String getAnswer4() {
		return answer4;
	}

	public int getCorrectAnswer() {
		return correctAnswer;
	}

	public String getHint() {
		return hint;
	}
}

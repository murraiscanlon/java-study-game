package game;

import java.util.ArrayList;
import java.util.HashMap;

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
	HashMap<String, String> hints;

	// Constructor
	Questions1() {
		this.qlist = QuestionReader.readCSVFile();
		this.questionCounter = 0;
		this.currentHint = " ";
		// this.currentQuestion ;
		this.hints =  new HashMap<String, String>();
		
		//fill hints hashMap
		for (Question q : qlist) {
			hints.put(q.getQuestion(), q.getHint());
		}
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
	
	/**
	 * This method uses the hashmap of questions and hints to return the currentHint
	 * that matches the currentQuestion
	 * @return
	 */
	
	public String getCurrentHint() {
		System.out.println("in the method");
		for (String h : hints.keySet()) {
			System.out.println("in the for loop");
			if (h.equals(currentQuestion)) {
				System.out.println("in the if");
				String locateHint = hints.get(h);
				currentHint = locateHint;
				return currentHint;
			}
			
		} return null;
		
		
		
		
		
	}
	
	
	/**
	 * this is attempt 1 and I can't get into the if condition. .. So now I am trying the hashmap
	 * @param args
	 */
		
//		for (Question q : qlist) {
//			//System.out.println("in the hint loop");
//			String locateHint = q.getHint();
//			//System.out.println(locateHint);
//			if (this.currentQuestion.getHint().contains(locateHint) ) {
//				System.out.println("in the if");
//				currentHint = locateHint;
//				break;
//			}
//		}
//		return currentHint;

	
	
	
	

	// main method for testing
	public static void main(String[] args) {
		Questions1 q1 = new Questions1();
		//System.out.println(q1.getCurrentQuestion());
		System.out.println(q1.getCurrentQuestion());
		System.out.println(q1.getCurrentHint());
		//System.out.println(q1.hints);
		//q1.getCurrentHint();

	}

}

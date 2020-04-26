package game;

import java.util.EventObject;

/**
 * Subclass of EventObject used by the QuestionBoxDialog Class to pass the
 * results of the question asked back to the SwingRoom Class so that the score
 * can be updated correctly.
 * 
 * @author Team 30
 *
 */
public class QuestionBoxEvent extends EventObject {

	private static final long serialVersionUID = 1L;
	private GameStatus scoreIndicator;

	/**
	 * Constructor
	 * 
	 * @param source         - calling class instance
	 * @param scoreIndicator - indicator of if the player answered the question
	 *                       correctly and with or without a hint
	 */
	public QuestionBoxEvent(Object source, GameStatus scoreIndicator) {
		super(source);
		this.scoreIndicator = scoreIndicator;
	}

	/**
	 * Getter for the score Indicator
	 * 
	 * @return scoreIndicator - indicator of if the player answered the question
	 *         correctly and with or without a hint
	 */
	public GameStatus getScoreIndicator() {
		return scoreIndicator;
	}
}

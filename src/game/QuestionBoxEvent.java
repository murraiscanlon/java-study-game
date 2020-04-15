package game;

import java.util.EventObject;
/**
 * Part of the QuestionBoxDialog setup
 * 
 * @author Team 30
 *
 */
public class QuestionBoxEvent extends EventObject{

	private static final long serialVersionUID = 1L;
	private GameStatus scoreIndicator;
	
	/**
	 * Constructor
	 * @param source
	 * @param scoreIndicator
	 */
	public QuestionBoxEvent(Object source, GameStatus scoreIndicator) {
		super(source);
		this.scoreIndicator = scoreIndicator;
	}
	public GameStatus getScoreIndicator() {
		return scoreIndicator;
	}
}

package game;

import java.util.EventObject;

public class QuestionBoxEvent extends EventObject{

	private static final long serialVersionUID = 1L;
	private GameStatus scoreIndicator;
	public QuestionBoxEvent(Object source, GameStatus scoreIndicator) {
		super(source);
		this.scoreIndicator = scoreIndicator;
	}
	public GameStatus getScoreIndicator() {
		return scoreIndicator;
	}
}

package game;

import java.util.EventObject;

public class QuestionBoxEvent extends EventObject{

	private static final long serialVersionUID = 1L;
	private int scoreIndicator;
	public QuestionBoxEvent(Object source, int scoreIndicator) {
		super(source);
		this.scoreIndicator = scoreIndicator;
	}
	public int getScoreIndicator() {
		return scoreIndicator;
	}
	
//	private static final long serialVersionUID = 1L;
//	private String text;
//	public QuestionBoxEvent(Object source, String text) {
//		super(source);
//		this.text = text;
//	}
//	public String getText() {
//		return text;
//	}
}

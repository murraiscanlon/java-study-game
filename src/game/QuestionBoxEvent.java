package game;

import java.util.EventObject;

public class QuestionBoxEvent extends EventObject{

	private static final long serialVersionUID = 1L;
	private String text;
	public QuestionBoxEvent(Object source, String text) {
		super(source);
		this.text = text;
	}
	public String getText() {
		return text;
	}
}

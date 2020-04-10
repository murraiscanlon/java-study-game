package game;

import java.util.EventListener;

public interface QuestionBoxListener extends EventListener{

	public void questionBoxEventOccurred(QuestionBoxEvent event);
}

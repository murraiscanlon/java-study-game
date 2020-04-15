package game;

import java.util.EventListener;
/**
 * Interface to extend the listener
 * @author Team 30
 *
 */
public interface QuestionBoxListener extends EventListener{
    /**
     * Extends the event listener
     * @param event
     */
	public void questionBoxEventOccurred(QuestionBoxEvent event);
}

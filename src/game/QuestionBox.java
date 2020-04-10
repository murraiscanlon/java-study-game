package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.EventListenerList;

public class QuestionBox extends JPanel {

	private static final long serialVersionUID = 1L;
	JLabel question;
	JLabel answer1;
	JLabel answer2;
	JLabel answer3;
	JLabel answer4;
	JLabel hint;
	JLabel correctAnswer;
	JButton returnButton;
	
	private EventListenerList listenerList = new EventListenerList();
	
	public QuestionBox() {
		
		GridBagConstraints c = new GridBagConstraints(); // Create a constraint variable to define interface
		c.anchor = GridBagConstraints.LINE_START; 
		c.insets = new Insets(5, 5, 5, 5);
		
		setBounds(50, 100, 800, 600);
		setBackground(Color.CYAN);
		setLayout(new GridBagLayout());

		question = new JLabel("");
		c.gridx = 0; c.gridy = 0;
		add(question,c);
		
		answer1 = new JLabel("");
		c.gridx = 0; c.gridy = 1;
		add(answer1,c);
		
		answer2 = new JLabel("");
		c.gridx = 0; c.gridy = 2;
		add(answer2,c);
		
		answer3 = new JLabel("");
		c.gridx = 0; c.gridy = 3;
		add(answer3,c);
		
		answer4 = new JLabel("");
		c.gridx = 0; c.gridy = 4;
		add(answer4,c);
		
		//add event listener for hint/fairy popup here??
		hint = new JLabel("");
		c.gridx = 0; c.gridy = 5;
		add(hint,c);
		
		returnButton = new JButton("Go Back!");
		c.gridx = 0; c.gridy = 6;
		add(returnButton,c);
		returnButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String text = "This is the info I want to return.";
				fireQBEvent(new QuestionBoxEvent(this,text));
			}
		});
	}
	
	public void setUpLabels(Question q) {
		question.setText(q.getQuestion());
		answer1.setText(q.getAnswer1());
		answer2.setText(q.getAnswer2());
		answer3.setText(q.getAnswer3());
		answer4.setText(q.getAnswer4());
		hint.setText("Need a Hint?");//connect to a new action listener for hint to appear maybe
	}

	public void fireQBEvent(QuestionBoxEvent event) {
		Object[] listeners = listenerList.getListenerList();
		
		for(int i = 0; i< listeners.length; i+=2) {
			if(listeners[i] == QuestionBoxListener.class) {
				((QuestionBoxListener)listeners[i+1]).questionBoxEventOccurred(event);
			}
		}
	}
	
	public void addQuestionBoxListener(QuestionBoxListener listener) {
		listenerList.add(QuestionBoxListener.class, listener);
	}
	
	public void removeQuestionBoxListener(QuestionBoxListener listener) {
		listenerList.remove(QuestionBoxListener.class, listener);	
	}
}

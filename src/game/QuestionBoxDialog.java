package game;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.event.EventListenerList;


public class QuestionBoxDialog extends JDialog implements ActionListener, PropertyChangeListener {

	private static final long serialVersionUID = 1L;
	private JPanel questionPanel;
	JLabel questLabel;
	JRadioButton[] radioButtons;
	ButtonGroup group;
	JButton selectButton;
	Treasure treasure;
	
	private EventListenerList listenerList = new EventListenerList();

	
	public QuestionBoxDialog(Frame aFrame) {
		super(aFrame, true);
		
		
		questLabel = new JLabel("Q");
		radioButtons = new JRadioButton[4];
		group = new ButtonGroup();
		selectButton = null;
		
		final String a1command = "a1";
		final String a2command = "a2";
		final String a3command = "a3";
		final String a4command = "a4";
		
		radioButtons[0] = new JRadioButton("A1");
		radioButtons[0].setActionCommand(a1command);
		radioButtons[1] = new JRadioButton("A2");
		radioButtons[1].setActionCommand(a2command);
		radioButtons[2] = new JRadioButton("A3");
		radioButtons[2].setActionCommand(a3command);
		radioButtons[3] = new JRadioButton("A4");
		radioButtons[3].setActionCommand(a4command);
		
        for (int i = 0; i < 4; i++) {
            group.add(radioButtons[i]);
        }	
		radioButtons[0].setSelected(true);
		selectButton = new JButton("OK!");
		selectButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String text = "This is the info I want to return.";
				fireQBEvent(new QuestionBoxEvent(this,text));
			}
		});
		
		questionPanel = new JPanel();
		questionPanel.add(questLabel);
        for (int i = 0; i < 4; i++) {
            questionPanel.add(radioButtons[i]);
        }
        questionPanel.add(selectButton);
        
        setContentPane(questionPanel);
	}
	
	public void setUpQuestion(Question q) {
		questLabel.setText(q.getQuestion());
		radioButtons[0].setText(q.getAnswer1());
		radioButtons[1].setText(q.getAnswer2());
		radioButtons[2].setText(q.getAnswer3());
		radioButtons[3].setText(q.getAnswer4());
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
	
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}

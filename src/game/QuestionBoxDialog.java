package game;

import java.awt.Component;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class QuestionBoxDialog extends JDialog implements ActionListener, PropertyChangeListener {

	private static final long serialVersionUID = 1L;
	private SwingRoom sw;
	private JOptionPane optionPane;
	private JPanel questionPanel;

	public QuestionBoxDialog(Frame aFrame, SwingRoom parent, Question q) {
		super(aFrame, true);
		sw = parent;
		
		JLabel questLabel = new JLabel(q.getQuestion());
		JRadioButton[] radioButtons = new JRadioButton[4];
		final ButtonGroup group = new ButtonGroup();
		JButton selectButton = null;
		
		final String a1command = "a1";
		final String a2command = "a2";
		final String a3command = "a3";
		final String a4command = "a4";
		
		radioButtons[0] = new JRadioButton(q.getAnswer1());
		radioButtons[0].setActionCommand(a1command);
		radioButtons[1] = new JRadioButton(q.getAnswer2());
		radioButtons[1].setActionCommand(a2command);
		radioButtons[2] = new JRadioButton(q.getAnswer3());
		radioButtons[2].setActionCommand(a3command);
		radioButtons[3] = new JRadioButton(q.getAnswer4());
		radioButtons[3].setActionCommand(a4command);
		
        for (int i = 0; i < 4; i++) {
            group.add(radioButtons[i]);
        }	
		radioButtons[0].setSelected(true);
		selectButton = new JButton("OK!");
		
		questionPanel.add(questLabel);
        for (int i = 0; i < 4; i++) {
            questionPanel.add(radioButtons[i]);
        }
        questionPanel.add(selectButton);
        
        setContentPane(questionPanel);
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
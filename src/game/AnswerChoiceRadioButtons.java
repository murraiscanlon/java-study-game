package game;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JRadioButton;

/**
 * This class extends JRadioButton to create formatting for answer choice buttons in the QuestionBoxDialog class.
 * @author Team 30
 *
 */
public class AnswerChoiceRadioButtons extends JRadioButton {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * This method improves readability in questionBoxDialog class by storing code that is used multiple places.
	 * @param y - The y coordinate for the answer choice radio button
	 */
	public AnswerChoiceRadioButtons(int y) {
		
		this.setBounds(35, y, 275, 40);
		this.setBackground(Color.LIGHT_GRAY);
		this.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.setOpaque(true);
	}

}

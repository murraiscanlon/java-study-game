package game;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JRadioButton;

public class AnswerChoiceFormat extends JRadioButton {
	
	private static final long serialVersionUID = 1L;
	
	public AnswerChoiceFormat(int y) {
		
		this.setBounds(35, y, 275, 40);
		this.setBackground(Color.LIGHT_GRAY);
		this.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.setOpaque(true);
	}

}

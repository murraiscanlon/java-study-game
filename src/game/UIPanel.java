package game;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 * Subclass JPanel used in QuestionBoxDialog and Instructions 
 * 
 * @author Team 30
 *
 */
public class UIPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * UIPanel constructor
	 * @param w - width of the panel
	 * @param h - height of the pannel
	 */
	UIPanel(int w, int h){
		this.setBounds(0, 0, w, h);
		this.setBorder(new LineBorder(new Color(153, 153, 153), 2));
		this.setBackground(Color.gray);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		this.setSize(500, 500);
	}
}



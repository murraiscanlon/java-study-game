package game;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
/**
 * Class to consolidate button parameters
 * @author Team 30
 *
 */
public class DirectionButton extends JButton {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Sets the direction buttons (north, east, south, west)
	 * @param dir
	 * @param x
	 * @param y
	 */
	public DirectionButton(String dir, int x, int y) {

//TODO delete before submission
//		this.setText(dir);
//		this.setIcon(null);
//		this.setForeground(new Color(0, 0, 0));
//		this.setBackground(new Color(128, 128, 128));
//		this.setOpaque(true);
//		this.setBounds(x, y, 80, 41);
//		this.setEnabled(true);
		
		this.setText(dir);
        this.setBorder(new LineBorder(new Color(153, 153, 153), 2));
        this.setFont(new Font("Tahoma", Font.BOLD, 18));
        this.setBackground(new Color(0, 60, 0));
        this.setForeground(Color.WHITE);
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setOpaque(true);
        this.setBounds(x, y, 80, 41);
		
	
	}
		
}

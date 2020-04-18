package game;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 * Class to consolidate button parameters
 * 
 * @author Team 30
 *
 */
public class DirectionButton extends JButton {

	private static final long serialVersionUID = 1L;

	/**
	 * Sets up the look and text for the direction buttons (north, east, south,
	 * west)
	 * 
	 * @param dir - N/S/E/W
	 * @param x   - Button x location
	 * @param y   - Button y location
	 */
	public DirectionButton(String dir, int x, int y) {

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

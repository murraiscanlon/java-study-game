package game;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
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

		this.setText(dir);
		this.setIcon(null);
		this.setForeground(new Color(0, 0, 0));
		this.setBackground(new Color(60, 0, 0));
		this.setOpaque(true);
		this.setBounds(x, y, 80, 41);
		this.setEnabled(true);
	}
	
	//just playing around with polymorphism
	public DirectionButton(String text, int x, int y, int h, int w) {
		this.setText(text);
		this.setIcon(null);
		this.setBackground(new Color(60, 0, 0));
		this.setForeground(Color.white);
		//this.setForeground(new Color(0, 0, 0));
		//this.setBackground(new Color(128, 128, 128));
		this.setOpaque(true);
		this.setBounds(x, y, h, w);
		this.setEnabled(true);
		this.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
	}
	
}

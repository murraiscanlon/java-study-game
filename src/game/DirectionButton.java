package game;

import java.awt.Color;

import javax.swing.JButton;

public class DirectionButton extends JButton {

	private static final long serialVersionUID = 1L;
	
	public DirectionButton(String dir, int x, int y) {

		this.setText(dir);
		this.setIcon(null);
		this.setForeground(new Color(0, 0, 0));
		this.setBackground(new Color(128, 128, 128));
		this.setOpaque(true);
		this.setBounds(x, y, 80, 41);
		this.setEnabled(true);
	}
}

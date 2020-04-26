package game;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class UIPanel extends JPanel {
	

	
	//private static final long serialVersionUID = 1L;
	
	UIPanel(int w, int h){
		
		
		this.setBounds(0, 0, w, h);
		this.setBorder(new LineBorder(new Color(153, 153, 153), 2));
		this.setBackground(Color.gray);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		this.setSize(500, 500);
		
		
	}
	


}



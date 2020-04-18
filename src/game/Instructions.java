package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 * Class to create Game Play Instructions Pop-up Box
 * 
 * @author Team 30
 *
 */
public class Instructions extends JDialog {
	/**
	 * Instance variables
	 */
	private static final long serialVersionUID = 1L;
	private JLayeredPane layeredPane;
	private JPanel contentPane;
	private JLabel javaMonsterImageLabel;
	private JButton okButton;

	/**
	 * Constructor for Instruction Box
	 * 
	 * @param aFrame - Frame passed in from caller
	 */
	public Instructions(Frame aFrame) {
		super(aFrame, true);

		/***** Creates the Base Frames *****/
		setUpUIFoundation();
		
		/***** Set Up Ok Button *****/
		setUpOkButton();
		
		/***** Set Up Monster Images *****/
		setUpMonsterImageBackground();
	}

	/**
	 * Method to establish the frame background
	 */
	private void setUpUIFoundation() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 665, 670);
		contentPane = new JPanel();
		contentPane.setSize(645, 705);
		contentPane.setBackground(Color.gray);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setContentPane(contentPane);

		layeredPane = new JLayeredPane();
		layeredPane.setSize(500, 500);
		layeredPane.setBackground(Color.red);
		layeredPane.setBounds(0, 0, 645, 695);

		contentPane.add(layeredPane);
	}

	/*
	 * This method creates the OK button
	 */
	private void setUpOkButton() {
		okButton = new JButton("OK!");
		okButton.setBounds(275, 507, 110, 35);
		okButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		okButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		layeredPane.add(okButton);
	}

	/*
	 * This method creates the monster background
	 */
	private void setUpMonsterImageBackground() {

		/**
		 * Displays monster image as a background for the box frame
		 */
		javaMonsterImageLabel = new JLabel("");
		javaMonsterImageLabel.setVerticalAlignment(SwingConstants.TOP);
		javaMonsterImageLabel.setIcon(new ImageIcon("images/immortalBlock.png"));
		javaMonsterImageLabel.setBounds(0, 0, 645, 695);
		layeredPane.add(javaMonsterImageLabel);
		javaMonsterImageLabel.setVisible(true);

		setContentPane(contentPane);
	}
}

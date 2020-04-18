package game;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 * Class to initiate Game Start with an entrance page
 * 
 * @author Team 30
 *
 */
public class SwingEnterPage {

	private JFrame frame;
	private JTextField textNameField;
	private JLabel gameTitle;
	private JLabel bgImage;
	private JButton startButton;
	private String playerName = "";

	/**
	 * Constructor for SwingEnterPage Creates and initialize the application.
	 * Establishes Start button and Text Field to enter name
	 */
	public SwingEnterPage() {
		/**** Initializes the game window *****/
		initFrame();

		/***** Creates the Start button with action *****/
		setUpStartbutton();

		/***** Sets up the name input field and label *****/
		setUpPlayer();

		/***** Sets up the background image and game title *****/
		setUpPageImagery();
	}

	/**
	 * Method to establish window frame
	 */
	public void initFrame() {
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 600);
		frame.setBackground(Color.BLACK);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	/**
	 * Method to set up Start button
	 */
	public void setUpStartbutton() {
		// Sets the button to go to next screen
		startButton = new JButton("START");
		startButton.setBorder(new LineBorder(new Color(153, 153, 153), 2));
		startButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		startButton.setBackground(new Color(60, 0, 0));
		startButton.setForeground(Color.WHITE);
		startButton.setHorizontalAlignment(SwingConstants.CENTER);
		startButton.setOpaque(true);
		startButton.setBounds(360, 460, 150, 45);

		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent click) {
				// Event closes the Enter Page and brings up the story page
				playerName = textNameField.getText();
				StoryPage page2 = new StoryPage(playerName);// link to second page
				page2.setVisible(true); // brings up next screen
				frame.setVisible(false);// closes enter page window
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(startButton);
	}

	/**
	 * Method to set up Player Name input
	 */
	public void setUpPlayer() {
		// Text Field for player to enter name
		textNameField = new JTextField();
		textNameField.setText("Enter Player Name");
		textNameField.setBackground(Color.LIGHT_GRAY);
		textNameField.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textNameField.setHorizontalAlignment(SwingConstants.CENTER);
		textNameField.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent arg0) {
				// Overwrites the prompt when player types in name
				if (textNameField.getText().trim().equals("Enter Player Name")) {
					textNameField.setText("");
					playerName = textNameField.getText();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// Method Not used but required for KeyListener
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// Method Not used but required for KeyListener
			}
		});
		textNameField.setForeground(Color.DARK_GRAY);
		textNameField.setBounds(360, 400, 150, 35);
		frame.getContentPane().add(textNameField);
		textNameField.setColumns(10);
	}

	/**
	 * Method to set up background look Sets title and picture
	 */
	public void setUpPageImagery() {
		// Sets up Game title
		gameTitle = new JLabel("J A V E N T U R E");
		gameTitle.setForeground(Color.GRAY);
		gameTitle.setFont(new Font("Castellar", gameTitle.getFont().getStyle(), 43));
		gameTitle.setBounds(232, 45, 455, 49);
		frame.getContentPane().add(gameTitle);

		// Sets up background image
		bgImage = new JLabel(new ImageIcon("images/enterpic.jpg"), JLabel.CENTER);
		bgImage.setBounds(0, 0, 900, 600);
		frame.getContentPane().add(bgImage);
	}

	/**
	 * Main method Launches the game application window *
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingEnterPage window = new SwingEnterPage();
					window.frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

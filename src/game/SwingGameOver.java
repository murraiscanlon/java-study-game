package game;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.border.LineBorder;

/**
 * Class to establish the final window of game Shows win/loss status
 * 
 * @author Team 30
 *
 */
public class SwingGameOver extends JFrame {

	/**
	 * Instance variables
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel scroll;
	private JLabel bgLabel;
	private JLabel scrollText;
	private JLabel wizardPlace;
	private JLabel wizardPlace1;
	private JLabel scoreLabel;
	private JButton exitButton;
	private JButton playAgain;
	private Score score;
	private JTextArea winMsg;
	private JTextArea loseMsg;

	/**
	 * Constructor for the Game Over page
	 * 
	 * @param score - score instance
	 */
	public SwingGameOver(Score score) {

		this.score = score;
		/***** Sets up initial frame *****/
		initGameOver();

		/***** Sets up scroll *****/
		setUpScroll();

		/***** Sets up Win message when player wins *****/
		setUpWinMsg();

		/***** Sets up Lose message when player loses *****/
		setUpLoseMsg();

		/***** Sets up quit game button *****/
		setUpQuitButton();

		/***** Sets up play again button *****/
		setUpPlayAgainButton();

		/***** Sets up score display *****/
		setUpScoreDisplay();

		/***** Sets up background image *****/
		setUpBackground();
	}

	/**
	 * Displays winning message and hides losing message
	 * Called from SwingRoom
	 */
	public void getWinMsg() {

		wizardPlace.setVisible(true);
		wizardPlace1.setVisible(false);
		winMsg.setVisible(true);
		loseMsg.setVisible(false);
	}

	/**
	 * Displays losing message and hides winning message
	 * Called from SwingRoom
	 */
	public void getLoseMsg() {

		loseMsg.setVisible(true);
		winMsg.setVisible(false);
		wizardPlace1.setVisible(true);
		wizardPlace.setVisible(false);
	}

	/**
	 * Method to initialize Game Over page
	 */
	private void initGameOver() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	/**
	 * Method to set up Game Over banner
	 */
	private void setUpScroll() {
		scrollText = new JLabel();
		scrollText.setFont(new Font("Castellar", scrollText.getFont().getStyle(), 32));
		scrollText.setText("GAME OVER!");
		scrollText.setBounds(134, 34, 600, 100);
		scrollText.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(scrollText);

		// Sets scroll location top center with image
		scroll = new JLabel();
		scroll.setIcon(new ImageIcon("images/scroll2.png"));
		scroll.setBounds(150, 30, 650, 125);
		contentPane.add(scroll);
		setVisible(true);
	}

	/**
	 * Method to establish Quit button
	 */
	private void setUpQuitButton() {
		// Exit button upper right corner, has same format as Direction Button
		exitButton = new DirectionButton("QUIT", 775, 0);
		exitButton.setFont(new Font("Times New Roman", Font.BOLD, 20));
		exitButton.setBounds(761, 10, 113, 37);

		exitButton.addActionListener(e -> {
			System.exit(0);
		});
		contentPane.add(exitButton);
	}

	/**
	 * Method to set up Play Again option Includes button with action
	 */
	private void setUpPlayAgainButton() {
		playAgain = new JButton("PLAY AGAIN");
		playAgain.setFont(new Font("Times New Roman", Font.BOLD, 12));
		playAgain.setBorder(new LineBorder(new Color(153, 153, 153), 2));
		playAgain.setForeground(Color.WHITE);
		playAgain.setBackground(new Color(0, 60, 0));// get color
		playAgain.setBounds(10, 10, 119, 37);
		playAgain.setOpaque(true);
		playAgain.addActionListener(e -> {
				// close current frame here
				dispose();
				// opens SwingEnterPage
				new SwingGameRunner();
		});
		contentPane.add(playAgain);
	}

	/**
	 * Method to set up the Win message from Wizard Arvind
	 */
	private void setUpWinMsg() {
		// Places the winning wizard pose
		wizardPlace = new JLabel();
		wizardPlace.setHorizontalAlignment(SwingConstants.CENTER);
		wizardPlace.setIcon(new ImageIcon("images/wizard1S.png"));
		wizardPlace.setBounds(382, 145, 400, 405);
		wizardPlace.setVisible(false);
		contentPane.add(wizardPlace);

		winMsg = new JTextArea();
		winMsg.setBorder(new LineBorder(new Color(204, 204, 204), 2));
		winMsg.setBounds(new Rectangle(0, 0, 2, 2));
		winMsg.setLineWrap(true);
		winMsg.setWrapStyleWord(true);
		winMsg.setFont(new Font("Tahoma", Font.PLAIN, 14));
		winMsg.setText("Wizard Arvind: Thank you for saving me! "
		                + "Your exemplary Java knowledge exceeded my expectations."
		                + "  Best wishes on  your journey.");
		winMsg.setForeground(Color.WHITE);
		winMsg.setBackground(Color.DARK_GRAY);
		winMsg.setEditable(false);
		winMsg.setBounds(123, 253, 297, 61);
		winMsg.setVisible(false);
		contentPane.add(winMsg);
	}

	/**
	 * Method to set up the Lose message from Wizard Arvind
	 */
	private void setUpLoseMsg() {
		// Sets losing message
		loseMsg = new JTextArea();
		loseMsg.setBorder(new LineBorder(new Color(204, 204, 204), 2));
		loseMsg.setBounds(new Rectangle(0, 0, 2, 2));
		loseMsg.setLineWrap(true);
		loseMsg.setWrapStyleWord(true);
		loseMsg.setFont(new Font("Tahoma", Font.PLAIN, 14));
		loseMsg.setText("Wizard Arvind: Your Java knowledge is lacking. " 
		                + "Play again to free me from the Java Monsters!");
		loseMsg.setForeground(Color.WHITE);
		loseMsg.setBackground(Color.DARK_GRAY);
		loseMsg.setEditable(false);
		loseMsg.setVisible(false);
		loseMsg.setBounds(430, 266, 309, 48);
		contentPane.add(loseMsg);

		// Sets wizard image for losing pose
		wizardPlace1 = new JLabel();
		wizardPlace1.setHorizontalAlignment(SwingConstants.CENTER);
		wizardPlace1.setIcon(new ImageIcon("images/wizard2S.png"));
		wizardPlace1.setBounds(108, 145, 400, 405);
		wizardPlace1.setVisible(false);
		contentPane.add(wizardPlace1);
	}

	/**
	 * Set up the score display
	 */
	private void setUpScoreDisplay() {
		String scoreOutput = "";
		if (score.getName().equals("Enter Player Name")) {
			scoreOutput += "";
		} else if (!score.getName().contentEquals("")) {
			scoreOutput += score.getName() + "'s ";
		}

		scoreOutput += "Score: " + score.getCurrentScore();
		scoreLabel = new JLabel(scoreOutput);
		scoreLabel.setBorder(new LineBorder(new Color(153, 153, 153), 2));
		scoreLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		scoreLabel.setBackground(new Color(60, 0, 0));
		scoreLabel.setForeground(Color.WHITE);
		scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scoreLabel.setOpaque(true);
		scoreLabel.setBounds(360, 123, 200, 54);
		contentPane.add(scoreLabel);
	}

	/**
	 * Method to set up Background image
	 */
	private void setUpBackground() {
		bgLabel = new JLabel();
		bgLabel.setIcon(new ImageIcon("images/GameOver.jpg"));
		bgLabel.setBounds(0, 0, 900, 600);
		contentPane.add(bgLabel);

	}
}

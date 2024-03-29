package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.event.EventListenerList;

/**
 * Class to extend JDialog. Creates a pop-up Question box that generates random
 * questions Java Monsters are integrated as part of the background of dialog
 * box User must answer multiple choice question to collect treasure User may
 * request 'hint' from Fairy GodTA by clicking button
 * 
 * @author Team 30
 *
 */
public class QuestionBoxDialog extends JDialog {
	/**
	 * Instance variables
	 */
	private static final long serialVersionUID = 1L;
	private EventListenerList listenerList = new EventListenerList();
	private JLayeredPane layeredPane;
	private JPanel contentPane;
	private JLabel currentQuestion;
	private JLabel hintRevealedLabel;
	private JLabel javaMonsterImageLabel;
	private JLabel fairyRevealLabel;
	private JRadioButton radioButton1;
	private JRadioButton radioButton2;
	private JRadioButton radioButton3;
	private JRadioButton radioButton4;
	private JButton hintButton;
	private JButton submitButton;
	private ButtonGroup bg2;
	private Question question;
	private boolean hintTaken;
	private JOptionPane incorrectAnswerJP;
	private ImageIcon dragonImage;

	/**
	 * Constructor displays a new window when the player pushed the
	 * treasureBoxButton. The new window includes a java question, four answer
	 * choices, and a hint option.
	 * 
	 * @param aFrame
	 */
	public QuestionBoxDialog(Frame aFrame) {
		super(aFrame, true);

		/***** Creates the Base Frames *****/
		setUpUIFoundation(670, 760);

		/***** Positions Current Question *****/
		setUpCurrentQuestionElements();

		/***** Positions Answer Choice Buttons *****/
		setUpAnswerChoiceButtons();

		/***** Set Up Submit Button *****/
		setUpSubmitButton();

		/***** Set Up Hint Button *****/
		setUpHintButton();

		/***** Set Up Monster Images *****/
		setUpMonsterImageBackground();
	}

	/**
	 * This method sets up the base frame components for the main question window
	 */
	public void setUpUIFoundation(int w, int h) {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, w, h);
		contentPane = new UIPanel(w, h);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, w, h);
		contentPane.add(layeredPane);
	}

	/**
	 * This methods sets up the question information when the dialog box is shown
	 * 
	 * @param q : Question object containing the question the player must answer
	 */
	public void setUpQuestion(Question q) {
		question = q;
		currentQuestion.setText("<HTML>" + q.getQuestion() + "</HTML>");
		radioButton1.setText("<HTML>" + q.getAnswer1() + "</HTML>");
		radioButton2.setText("<HTML>" + q.getAnswer2() + "</HTML>");
		radioButton3.setText("<HTML>" + q.getAnswer3() + "</HTML>");
		radioButton4.setText("<HTML>" + q.getAnswer4() + "</HTML>");
		javaMonsterImageLabel.setIcon(new ImageIcon(monsterGenerator()));
		hintRevealedLabel.setText(
				"<HTML>" + "<em> Your FairyGodTA Jami, says: </em>  " + "\" " + q.getHint() + "\" " + "</HTML>");
		hintTaken = false;
		hintButton.setVisible(true);
		hintRevealedLabel.setVisible(false);
		fairyRevealLabel.setVisible(false);
	}

	/**
	 * This positions all elements for the current question
	 */
	public void setUpCurrentQuestionElements() {
		currentQuestion = new JLabel("Q");
		currentQuestion.setBackground(Color.LIGHT_GRAY);
		currentQuestion.setFont(new Font("Tahoma", Font.PLAIN, 18));
		currentQuestion.setOpaque(true);
		currentQuestion.setBounds(35, 350, 573, 40);
		layeredPane.add(currentQuestion);
	}

	/**
	 * This method creates the answer choices
	 */
	public void setUpAnswerChoiceButtons() {

		// sets button position and format
		radioButton1 = new AnswerChoiceRadioButtons(410);
		layeredPane.add(radioButton1);

		radioButton2 = new AnswerChoiceRadioButtons(460);
		layeredPane.add(radioButton2);

		radioButton3 = new AnswerChoiceRadioButtons(510);
		layeredPane.add(radioButton3);

		radioButton4 = new AnswerChoiceRadioButtons(560);
		layeredPane.add(radioButton4);

		// groups the buttons so only one can be selected at a time
		bg2 = new ButtonGroup();
		bg2.add(radioButton1);
		bg2.add(radioButton2);
		bg2.add(radioButton3);
		bg2.add(radioButton4);
	}

	/**
	 * This method creates the SUBMIT button
	 */
	public void setUpSubmitButton() {
		submitButton = new JButton("SUBMIT");
		submitButton.setBounds(365, 568, 110, 35);
		submitButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		submitButton.addActionListener(e -> {
			GameStatus scoreIndicator = GameStatus.NA; // Default to init the variable
			if (checkAnswer(question) && (!hintTaken)) { // Correct with no hint
				scoreIndicator = GameStatus.QUESTION_CORRECT;
			} else if (checkAnswer(question) && (hintTaken)) { // Correct with hint
				scoreIndicator = GameStatus.QUESTION_WITH_HINT;
			} else { // Incorrect
				scoreIndicator = GameStatus.QUESTION_WRONG;
				dragonImage = new ImageIcon("images/dragon2.jpg");
				JOptionPane.showMessageDialog(incorrectAnswerJP, // popUp window for incorrect answer
						"", "Incorrect Answer", JOptionPane.INFORMATION_MESSAGE, dragonImage);
			}
			// Reset hint buttons and labels
			bg2.clearSelection();
			hintRevealedLabel.setVisible(false);
			fairyRevealLabel.setVisible(false);
			hintButton.setVisible(true);
			// Event to send scoreIndicator back to SwingRoom
			fireQBEvent(new QuestionBoxEvent(this, scoreIndicator));
		});
		layeredPane.add(submitButton);
	}

	/**
	 * Hint button click method to help with core indicator in submit button
	 */
	public void hintButtonClicked() {
		hintTaken = true;
		hintRevealedLabel.setVisible(true);
		fairyRevealLabel.setVisible(true);
	}

	/**
	 * This method creates the HINT button and HINT TEXT
	 */
	public void setUpHintButton() {
		// reveals the current hint at the bottom of the box

		hintRevealedLabel = new JLabel("");
		hintRevealedLabel.setBounds(100, 650, 450, 40);
		hintRevealedLabel.setForeground(Color.black);
		hintRevealedLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		layeredPane.add(hintRevealedLabel);
		hintRevealedLabel.setVisible(false);

		// reveals the fairy picture at the bottom of the box
		fairyRevealLabel = new JLabel("");
		fairyRevealLabel.setIcon(new ImageIcon("images/fairyS.png"));
		fairyRevealLabel.setBounds(5, 580, 180, 163);
		layeredPane.add(fairyRevealLabel);
		fairyRevealLabel.setVisible(false);

		// reveals hint when clicked
		hintButton = new JButton("HINT");
		hintButton.setBounds(505, 568, 100, 35);
		hintButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		hintButton.addActionListener(e -> {
			hintButtonClicked();
		});
		layeredPane.add(hintButton);
	}

	/**
	 * This method creates the monster background
	 */
	public void setUpMonsterImageBackground() {

		/**
		 * Displays monster image as a background for the box frame
		 */
		javaMonsterImageLabel = new JLabel("");
		javaMonsterImageLabel.setVerticalAlignment(SwingConstants.TOP);
		javaMonsterImageLabel.setIcon(new ImageIcon(monsterGenerator()));
		javaMonsterImageLabel.setBounds(0, 0, 645, 695);
		layeredPane.add(javaMonsterImageLabel);
		javaMonsterImageLabel.setVisible(true);

		setContentPane(contentPane);
	}

	/**
	 * Compares the selected radioButton/answerchoice to the current correctAnswer.
	 * 
	 * @param q - current question
	 * @return - true if the answer is correct, false otherwise
	 */
	public boolean checkAnswer(Question q) {
		question = q;
		int correctAnswerNumber = q.getCorrectAnswer();
		// isCorrect = false;
		switch (correctAnswerNumber) {
		case 1:
			return radioButton1.isSelected();
		case 2:
			return radioButton2.isSelected();
		case 3:
			return radioButton3.isSelected();
		case 4:
			return radioButton4.isSelected();
		default:
			return false;
		}
	}

	/**
	 * Generates a random monster picture for the background of the question dialog
	 * box
	 */
	public String monsterGenerator() {
		Random randomMonster = new Random();
		String[] monsterArr = {"images/assassinBlock.png", "images/headlessBlock.png",
		                       "images/ghostBlock.png","images/ogreBlock.png", 
		                       "images/gremlinBlock.png", "images/dragonBlock.png",
		                       "images/mummyBlock.png", "images/zombieBlock.png"
		        
		};
		ArrayList<String> javaMonsters = new ArrayList<String>();
		Collections.addAll(javaMonsters, monsterArr);
		int randomChoice = randomMonster.nextInt(javaMonsters.size());
		String currentMonster = javaMonsters.get(randomChoice);
		return currentMonster;
	}

	/**
	 * Swing listeners that tracks and processes events
	 * 
	 * @param event
	 */
	public void fireQBEvent(QuestionBoxEvent event) {
		Object[] listeners = listenerList.getListenerList();

		for (int i = 0; i < listeners.length; i += 2) {
			if (listeners[i] == QuestionBoxListener.class) {
				((QuestionBoxListener) listeners[i + 1]).questionBoxEventOccurred(event);
			}
		}
	}

	/**
	 * Question Box Listener to add Question to queue
	 * 
	 * @param listener
	 */
	public void addQuestionBoxListener(QuestionBoxListener listener) {
		listenerList.add(QuestionBoxListener.class, listener);
	}

	/**
	 * Question Box listener to remove question from list
	 * 
	 * @param listener
	 */
	public void removeQuestionBoxListener(QuestionBoxListener listener) {
		listenerList.remove(QuestionBoxListener.class, listener);
	}
}

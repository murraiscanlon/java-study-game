package game;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.EventListenerList;

public class QuestionBoxDialog extends JDialog implements ActionListener, PropertyChangeListener {

	private static final long serialVersionUID = 1L;
	private EventListenerList listenerList = new EventListenerList();
	private JLayeredPane layeredPane;
	private JPanel contentPane;
	private JLabel currentQuestion;
	private JLabel hintRevealedLabel;
	private JLabel treasureImageLabel;
	private JLabel collectTreasureLabel;
	private JLabel javaMonsterImageLabel;
	private JLabel fairyRevealLabel;
	private JRadioButton radioButton1;
	private JRadioButton radioButton2;
	private JRadioButton radioButton3;
	private JRadioButton radioButton4;
	private JButton returnButton;
	private JButton hintButton;
	private JButton submitButton;
	private ButtonGroup bg2;
	private Treasure treasure;
	private Question question;
	private Score s;
	private Room treasure1;// testing this out
	boolean isCorrect;// may not need this

	/**
	 * This class displays a new window when the player pushed the
	 * treasureBoxButton. The new window includes a java question, four answer
	 * choices, and a hint option.
	 */
	public QuestionBoxDialog(Frame aFrame) {
		super(aFrame, true);

		/***** Creates the Base Frames *****/
		setUpUIFoundation();
		/***** Positions Current Question *****/
		setUpCurrentQuestionPosition();
		/***** Positions Answer Choice Buttons *****/
		setUpAnswerChoiceButtons();
		/***** Set Up Submit Button *****/
		setUpSubmitButton();
		/***** Set Up Return Button *****/
		setUpReturnButton();
		/***** Set Up Hint Button *****/
		setUpHintButton();
		/***** Set Up Monster Images *****/
		setUpMonsterImageBackground();

	}

	/*
	 * This method sets up the base frame components for the main question window
	 */
	public void setUpUIFoundation() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 691, 762);
		contentPane = new JPanel();
		contentPane.setSize(500, 500);
		contentPane.setBackground(Color.black);
		contentPane.setBorder(new EmptyBorder(5, 100, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		layeredPane = new JLayeredPane();
		layeredPane.setSize(500, 500);
		layeredPane.setBackground(Color.red);
		layeredPane.setBounds(10, 10, 657, 700);
		contentPane.add(layeredPane);
	}

	/*
	 * This method creates the current question label
	 */
	public void setUpCurrentQuestionPosition() {
		currentQuestion = new JLabel("Q");
		currentQuestion.setOpaque(true);
		currentQuestion.setBounds(35, 400, 573, 21);
		layeredPane.add(currentQuestion);
	}

	/*
	 * This method creates the answer choices
	 */
	public void setUpAnswerChoiceButtons() {

		// sets button position and format
		radioButton1 = new JRadioButton("R1");
		radioButton1.setBounds(35, 440, 573, 21);
		layeredPane.add(radioButton1);

		radioButton2 = new JRadioButton("R2");
		radioButton2.setBounds(35, 470, 573, 21);
		layeredPane.add(radioButton2);

		radioButton3 = new JRadioButton("R3");
		radioButton3.setBounds(35, 500, 573, 21);
		layeredPane.add(radioButton3);

		radioButton4 = new JRadioButton("R4");
		radioButton4.setBounds(35, 530, 573, 21);
		layeredPane.add(radioButton4);

		// groups the buttons so only one can be selected at a time
		bg2 = new ButtonGroup();
		bg2.add(radioButton1);
		bg2.add(radioButton2);
		bg2.add(radioButton3);
		bg2.add(radioButton4);

	}

	/*
	 * This method creates the SUBMIT button
	 */
	public void setUpSubmitButton() {
		submitButton = new JButton("Submit");
		submitButton.setBounds(270, 584, 100, 21);
		submitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String checkAnswerString = "";
				if (checkAnswer(question)) {
					checkAnswerString = "TRUE";
				} else {
					checkAnswerString = "FALSE";
				}
				bg2.clearSelection();
				int scoreIndicator = 0;
				fireQBEvent(new QuestionBoxEvent(this, scoreIndicator));
			}
		});
		
		
		layeredPane.add(submitButton);
	}

	/*
	 * This method creates the RETURN button
	 */
	public void setUpReturnButton() {
		returnButton = new JButton("Return");
		returnButton.setBounds(475, 584, 100, 21);
		returnButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				String text = "This is the info I want to return.";
//				fireQBEvent(new QuestionBoxEvent(this,text));
			}
		});
		layeredPane.add(returnButton);
	}

	/*
	 * This method creates the HINT button and HINT TEXT
	 */
	public void setUpHintButton() {

		// reveals the current hint at the bottom of the box
		hintRevealedLabel = new JLabel("");
		hintRevealedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		hintRevealedLabel.setBounds(175, 636, 391, 28);
		hintRevealedLabel.setForeground(Color.white);
		layeredPane.add(hintRevealedLabel);
		hintRevealedLabel.setVisible(false);

		// reveals the fairy picture at the bottom of the box
		fairyRevealLabel = new JLabel("");
		fairyRevealLabel.setIcon(new ImageIcon("fairy.png"));
		fairyRevealLabel.setBounds(5, 547, 180, 163);
		layeredPane.add(fairyRevealLabel);
		fairyRevealLabel.setVisible(false);

		// reveals hint when clicked
		hintButton = new JButton("HINT");
		hintButton.setBounds(70, 584, 100, 21);
		hintButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				if (s.currentScore > 0) {
//					s.losePoints(1);
//					System.out.println("current score " + s.getCurrentScore());// testing
//				} else {
//					// TODO game over?
//				}
				hintRevealedLabel.setVisible(true);
				fairyRevealLabel.setVisible(true);
				hintButton.setVisible(false);

			}
		});
		

		layeredPane.add(hintButton);
	}

	/*
	 * This method creates the treasure image and message to the player
	 */
	public void setUpTreasureImage() {

		// replaces monster picture with the current treasure collected
		treasureImageLabel = new JLabel("");
		treasureImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		// Need to link the Room/Treasure association
		treasureImageLabel.setIcon(new ImageIcon("diamond2.png"));
		treasureImageLabel.setBounds(212, 50, 243, 180);
		layeredPane.add(treasureImageLabel);
		treasureImageLabel.setVisible(true);

		// sends the player a message that the treasure has been collected
		collectTreasureLabel = new JLabel("Message to Player");
		collectTreasureLabel.setHorizontalAlignment(SwingConstants.CENTER);
		collectTreasureLabel.setBounds(212, 200, 267, 98);
		layeredPane.add(collectTreasureLabel);
		collectTreasureLabel.setVisible(false);
	}

	/*
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
	 * Updates all elements in the question box with current information
	 */
	public void setUpQuestion(Question q) {
		question = q;
		currentQuestion.setText(q.getQuestion());
		radioButton1.setText(q.getAnswer1());
		radioButton2.setText(q.getAnswer2());
		radioButton3.setText(q.getAnswer3());
		radioButton4.setText(q.getAnswer4());
		javaMonsterImageLabel.setIcon(new ImageIcon(monsterGenerator()));
		hintRevealedLabel.setText("<HTML>" + q.getHint() + "</HTML>");
	}

	/*
	 * Not sure about this one
	 */
	public void setUpTreasure(Treasure t) {
		treasure = t;
	}

	/**
	 * Compares the selected radioButton/answerchoice to the current correctAnswer.
	 */
	public boolean checkAnswer(Question q) {
		question = q;
		int correctAnswerNumber = q.getCorrectAnswer();
		isCorrect = false;
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
			System.out.println("Problem in checkAnswer method");
			return false;
		}
	}

	/**
	 * Generates a random monster picture for the background of the question dialog
	 * box
	 */
	public String monsterGenerator() {
		Random randomMonster = new Random();
		ArrayList<String> javaMonsters = new ArrayList<String>();
		javaMonsters.add("assassinBlock.png");
		javaMonsters.add("headlessBlock.png");
		javaMonsters.add("ghostBlock.png");
		javaMonsters.add("ogreBlock.png");
		javaMonsters.add("gremlinBlock.png");
		javaMonsters.add("dragonBlock.png");
		javaMonsters.add("mummyBlock.png");
		javaMonsters.add("zombieBlock.png");
		int randomChoice = randomMonster.nextInt(javaMonsters.size());
		String currentMonster = javaMonsters.get(randomChoice);
		return currentMonster;
	}

	/*
	 * Swing listeners that track and process events
	 */

	public void fireQBEvent(QuestionBoxEvent event) {
		Object[] listeners = listenerList.getListenerList();

		for (int i = 0; i < listeners.length; i += 2) {
			if (listeners[i] == QuestionBoxListener.class) {
				((QuestionBoxListener) listeners[i + 1]).questionBoxEventOccurred(event);
			}
		}
	}

	public void addQuestionBoxListener(QuestionBoxListener listener) {
		listenerList.add(QuestionBoxListener.class, listener);
	}

	public void removeQuestionBoxListener(QuestionBoxListener listener) {
		listenerList.remove(QuestionBoxListener.class, listener);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}

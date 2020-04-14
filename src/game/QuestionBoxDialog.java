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
	private Room treasure1;//testing this out
	
	boolean isCorrect;

	// Constructor
	public QuestionBoxDialog(Frame aFrame) {
		super(aFrame, true);// how does this work?

		// setContentPane(questionPanel);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 691, 762);

		/**
		 * The base of the QuestionBoxDialog window
		 */
		contentPane = new JPanel();
		contentPane.setSize(500, 500);
		contentPane.setBackground(Color.black);
		contentPane.setBorder(new EmptyBorder(5, 100, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		/**
		 * The layer that holds all of the labels and buttons
		 */
		layeredPane = new JLayeredPane();
		layeredPane.setSize(500, 500);
		layeredPane.setBackground(Color.red);
		layeredPane.setBounds(10, 10, 657, 700);
		contentPane.add(layeredPane);

		/**
		 * Creates current question position on layedPane background
		 */
		currentQuestion = new JLabel("Q");
		currentQuestion.setOpaque(true);
		currentQuestion.setBounds(35, 400, 573, 21);
		layeredPane.add(currentQuestion);

		/**
		 * Creates answerChoice radio buttons and positions them on the layeredPane
		 * background
		 */
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

		/**
		 * Groups the answerchoice buttons so that only one can be selected at a time.
		 */
		bg2 = new ButtonGroup();
		bg2.add(radioButton1);
		bg2.add(radioButton2);
		bg2.add(radioButton3);
		bg2.add(radioButton4);

		/**
		 * SUBMIT button checks to see if answer choice is correct and adds treasure
		 * points to score.
		 */
		submitButton = new JButton("Submit");// WORKING HERE
		submitButton.setBounds(270, 584, 100, 21);

		/**
		 * I need help working with this listener.
		 */
		submitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				// only using this "if" to return a String to the fireQBEvent
				String checkAnswerString = "";
				if (checkAnswer(question)) {
					checkAnswerString = "TRUE";
					// s.addPoints(1);//this should be treasure value
					// System.out.println(s.getCurrentScore());//just testing

				} else {
					checkAnswerString = "FALSE";
				}
				bg2.clearSelection();
				int scoreIndicator = 0;
				fireQBEvent(new QuestionBoxEvent(this, scoreIndicator));

			}
		});
		layeredPane.add(submitButton);

		/**
		 * Return button that closes the dialog box and returns the user to the last
		 * visited room.
		 */
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

		/**
		 * Holds the current hint for display once the hint button is clicked.
		 */
		// TODO Create GENERIC hint label - do not access question, it has not been created yet.
		hintRevealedLabel = new JLabel("");
																													// working
		hintRevealedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		hintRevealedLabel.setBounds(150, 636, 391, 28);
		layeredPane.add(hintRevealedLabel);
		hintRevealedLabel.setVisible(false);

		/**
		 * Holds the image of the fairy in the frame.
		 */
		JLabel fairyRevealLabel = new JLabel("");
		fairyRevealLabel.setIcon(new ImageIcon("fairy.png"));
		fairyRevealLabel.setBounds(5, 547, 180, 163);
		layeredPane.add(fairyRevealLabel);
		fairyRevealLabel.setVisible(false);

		/**
		 * Hint button displays the current hint, an image of the fairy, and subtracts 1
		 * point for the players score
		 */
		JButton hintButton = new JButton("HINT");// WORKING HERE *************Not working
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
		hintButton.setBounds(70, 584, 100, 21);
		layeredPane.add(hintButton);

		/**
		 * Replaces the monster background image with a picture of the current treasure
		 * collected.
		 */
		
		treasureImageLabel = new JLabel("");
		treasureImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		//Need to link the Room/Treasure association
		treasureImageLabel.setIcon(new ImageIcon("diamond2.png"));
		
		treasureImageLabel.setBounds(212, 50, 243, 180);
		layeredPane.add(treasureImageLabel);
		treasureImageLabel.setVisible(true);

		/**
		 * Sends a message to the player that they have collected the current treasure.
		 */
		collectTreasureLabel = new JLabel("Message to Player");
		collectTreasureLabel.setHorizontalAlignment(SwingConstants.CENTER);
		collectTreasureLabel.setBounds(212, 200, 267, 98);
		layeredPane.add(collectTreasureLabel);
		collectTreasureLabel.setVisible(false);

		/**
		 * Displays monster image as a background for the box frame
		 */
		javaMonsterImageLabel = new JLabel("");
		javaMonsterImageLabel.setVerticalAlignment(SwingConstants.TOP);
		javaMonsterImageLabel.setIcon(new ImageIcon(monsterGenerator()));
		javaMonsterImageLabel.setBounds(0, 0, 645, 695);
		layeredPane.add(javaMonsterImageLabel);
		javaMonsterImageLabel.setVisible(true);

		setContentPane(contentPane);//this is listed twice

	}// end constructor



	/**
	 * Compares the selected radioButton/answerchoice to the current
	 * correctAnswer.
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

	public void setUpQuestion(Question q) {
		question = q;
		currentQuestion.setText(q.getQuestion());
		radioButton1.setText(q.getAnswer1());
		radioButton2.setText(q.getAnswer2());
		radioButton3.setText(q.getAnswer3());
		radioButton4.setText(q.getAnswer4());
		javaMonsterImageLabel.setIcon(new ImageIcon(monsterGenerator()));
		hintRevealedLabel.setText(q.getHint());
	}

	public void setUpTreasure(Treasure t) {
		treasure = t;
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

	/*************************************************
	 * LISTENERS
	 ********************************************************/

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

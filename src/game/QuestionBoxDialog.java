package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
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
import javax.swing.border.EmptyBorder;
import javax.swing.event.EventListenerList;
/**
 * Class to extend JDialog, implements ActionListener and PropertyChangeListener
 * Creates a pop-up Question box that generates random questions
 * Java Monsters are integrated as part of the background of dialog box
 * User must answer multiple choice question to collect treasure
 * User may request 'hint' from Fairy GodTA by clicking button
 * @author Team 30
 *
 */
//public class QuestionBoxDialog extends JDialog implements ActionListener, PropertyChangeListener {
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
	private JLabel treasureImageLabel;
	private JLabel collectTreasureLabel;
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
	private JLabel wrongAnswerMessage;//TODO delete?
	JOptionPane jp; //TODO private?
	ImageIcon dragonImage; //TODO private?

	/**
	 * Constructor
	 * This class displays a new window when the player pushed the
     * treasureBoxButton. The new window includes a java question, four answer
     * choices, and a hint option.
	 * @param aFrame
	 */
	public QuestionBoxDialog(Frame aFrame) {
		super(aFrame, true);

		/***** Creates the Base Frames *****/
		setUpUIFoundation();
		
		/***** Positions Current Question *****/
		setUpCurrentQuestionElements();
		
		/***** Positions Answer Choice Buttons *****/
		setUpAnswerChoiceButtons();
		
		/***** Set Up Submit Button *****/
		setUpSubmitButton();
		
		/***** Set Up Return Button *****///TODO delete?
		//setUpReturnButton();
		
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
		contentPane.setBackground(Color.gray);
		contentPane.setBorder(new EmptyBorder(5, 100, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		layeredPane = new JLayeredPane();
		layeredPane.setSize(500, 500);
		layeredPane.setBackground(Color.red);
		layeredPane.setBounds(10, 10, 657, 700);
		contentPane.add(layeredPane);
	}

	/**
	 * This methods sets up the question information when the dialog box is shown
	 * @param q : question object
	 */
	public void setUpQuestion(Question q) {
		question = q;
		currentQuestion.setText("<HTML>" + q.getQuestion() +"</HTML>");
		radioButton1.setText("<HTML>" + q.getAnswer1() + "</HTML>");
		radioButton2.setText("<HTML>" + q.getAnswer2() + "</HTML>");
		radioButton3.setText("<HTML>" + q.getAnswer3() + "</HTML>");
		radioButton4.setText("<HTML>" + q.getAnswer4() + "</HTML>");
		javaMonsterImageLabel.setIcon(new ImageIcon(monsterGenerator()));
		hintRevealedLabel.setText("<HTML>" + q.getHint() + "</HTML>");
		hintTaken = false;
		hintButton.setVisible(true);
		hintRevealedLabel.setVisible(false);
		fairyRevealLabel.setVisible(false);
	}

	/*
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

	/*
	 * This method creates the answer choices
	 */
	public void setUpAnswerChoiceButtons() {

		// sets button position and format
		radioButton1 = new JRadioButton("R1");
		radioButton1.setBounds(35, 410, 275, 40);
		radioButton1.setBackground(Color.LIGHT_GRAY);
		radioButton1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		radioButton1.setOpaque(true);
		layeredPane.add(radioButton1);

		radioButton2 = new JRadioButton("R2");
		radioButton2.setBounds(35, 460, 275, 40);
		radioButton2.setBackground(Color.LIGHT_GRAY);
		radioButton2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		radioButton2.setOpaque(true);
		layeredPane.add(radioButton2);

		radioButton3 = new JRadioButton("R3");
		radioButton3.setBounds(35, 510, 275, 40);
		radioButton3.setBackground(Color.LIGHT_GRAY);
		radioButton3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		radioButton3.setOpaque(true);
		layeredPane.add(radioButton3);

		radioButton4 = new JRadioButton("R4");
		radioButton4.setBounds(35, 560, 275, 40);
		radioButton4.setBackground(Color.LIGHT_GRAY);
		radioButton4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		radioButton4.setOpaque(true);
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
		submitButton = new JButton("SUBMIT");
		submitButton.setBounds(365, 568, 110, 35);
		submitButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		submitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GameStatus scoreIndicator = GameStatus.NA; // Default to init the variable
				if (checkAnswer(question) && (!hintTaken)) {
					scoreIndicator = GameStatus.QuestionCorrect;
				} else if (checkAnswer(question) && (hintTaken)) {
					scoreIndicator = GameStatus.QuestionWithHint;
				}
				else {
					scoreIndicator = GameStatus.QuestionWrong;
					scoreIndicator = GameStatus.QuestionWrong;
					dragonImage = new ImageIcon("images/dragon2.jpg");
					JOptionPane.showMessageDialog(jp,
					    "",
					    "",
					    JOptionPane.INFORMATION_MESSAGE,
					    dragonImage);
				}

				bg2.clearSelection();

				hintRevealedLabel.setVisible(false);
				fairyRevealLabel.setVisible(false);
				hintButton.setVisible(true);
				
				

				fireQBEvent(new QuestionBoxEvent(this, scoreIndicator));
			}
		});
		layeredPane.add(submitButton);
	}

	//hint button click method to help with core indicator in submit button
	public void hintButtonClicked() {
		hintTaken = true;
		hintRevealedLabel.setVisible(true);
		fairyRevealLabel.setVisible(true);
		//hintButton.setVisible(false);//moved button so don't need this
	}

	/*
	 * This method creates the HINT button and HINT TEXT
	 */
	public void setUpHintButton() {
		// reveals the current hint at the bottom of the box

		hintRevealedLabel = new JLabel("");
		hintRevealedLabel.setBounds(100, 650, 390, 40);
		//hintRevealedLabel.setHorizontalAlignment(SwingConstants.CENTER);
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
		hintButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				hintButtonClicked();
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
		// do we need this part?
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
	 * Compares the selected radioButton/answerchoice to the current correctAnswer.
	 * @param q
	 * @return
	 */
	public boolean checkAnswer(Question q) {
		question = q;
		int correctAnswerNumber = q.getCorrectAnswer();
		//		isCorrect = false;
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
		javaMonsters.add("images/assassinBlock.png");
		javaMonsters.add("images/headlessBlock.png");
		javaMonsters.add("images/ghostBlock.png");
		javaMonsters.add("images/ogreBlock.png");
		javaMonsters.add("images/gremlinBlock.png");
		javaMonsters.add("images/dragonBlock.png");
		javaMonsters.add("images/mummyBlock.png");
		javaMonsters.add("images/zombieBlock.png");
		int randomChoice = randomMonster.nextInt(javaMonsters.size());
		String currentMonster = javaMonsters.get(randomChoice);
		return currentMonster;
	}

	/**
	 * Swing listeners that track and process events
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
	 * @param listener
	 */
	public void addQuestionBoxListener(QuestionBoxListener listener) {
		listenerList.add(QuestionBoxListener.class, listener);
	}
	/**
	 * Question Box listener to remove question from list
	 * @param listener
	 */
	public void removeQuestionBoxListener(QuestionBoxListener listener) {
		listenerList.remove(QuestionBoxListener.class, listener);
	}
}

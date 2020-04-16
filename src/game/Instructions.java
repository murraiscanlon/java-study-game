package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.EventListenerList;
/**
 * @author Team 30
 *
 */
//public class QuestionBoxDialog extends JDialog implements ActionListener, PropertyChangeListener {
public class Instructions extends JDialog {
    /**
     * Instance variables
     */
	private static final long serialVersionUID = 1L;
	private EventListenerList listenerList = new EventListenerList();
	private JLayeredPane layeredPane;
	private JPanel contentPane;
	private JLabel instruction;
	private JLabel javaMonsterImageLabel;
	private JButton okButton;

	public Instructions(Frame aFrame, Score score) {
		super(aFrame, true);

		/***** Creates the Base Frames *****/
		setUpUIFoundation();
		// To add later
		/***** Positions Current Question *****/
		setUpInstructionLabel(score);
		/***** Set Up Submit Button *****/
		setUpOkButton();
		/***** Set Up Monster Images *****/
		setUpMonsterImageBackground();
	}

	
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
	
	/*
	 * This positions all elements for the current question
	 */
	public void setUpInstructionLabel(Score score) {
		String inst = "You have to get " + score.scoreTarget + " points and not more than " + score.wronqQuestionTarget + " quesitons wrong!";
		instruction = new JLabel(inst);
		instruction.setBackground(Color.LIGHT_GRAY);
		instruction.setFont(new Font("Tahoma", Font.PLAIN, 18));
		instruction.setOpaque(true);
		instruction.setBounds(35, 350, 573, 40);
		layeredPane.add(instruction);
	}
	
	/*
	 * This method creates the SUBMIT button
	 */
	public void setUpOkButton() {
		okButton = new JButton("OK!");
		okButton.setBounds(365, 568, 110, 35);
		okButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		okButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		layeredPane.add(okButton);
	}


	
	
	
	

	
	//  To add later
	/*
	 * This method sets up the base frame components for the main question window
	 */


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

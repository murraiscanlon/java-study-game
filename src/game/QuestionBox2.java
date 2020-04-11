package game;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionEvent;

public class QuestionBox2 extends JFrame {

	static QuestionBox2 frame;
	private JPanel contentPane;
	Questions1 q1 = new Questions1();
	Question q;
	ButtonGroup bg;
	JButton hintButton;
	JLabel javaMonsterImageLabel;
	JLayeredPane layeredPane1;
	
	JLabel treasureImageLabel;
	JLabel collectTreasureLabel;

	/**
	 * Launch from main method for testing
//	 */
//	public static void main(String[] args) {
//		
//		launchQuestionBoxFrame();
//
//	}
	
	public static void launchQuestionBoxFrame() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					frame = new QuestionBox2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the frame.
	 */
	public QuestionBox2() {
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 691, 762);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//LAYERED PANEL 1
		layeredPane1 = new JLayeredPane();
		layeredPane1.setBounds(10, 10, 657, 700);
		contentPane.add(layeredPane1);
		
		JLabel currentQuestion = new JLabel(q1.getCurrentQuestion().getQuestion());//WORKING HERE
		currentQuestion.setOpaque(true);
		currentQuestion.setBounds(35, 374, 573, 21);
		layeredPane1.add(currentQuestion);
		
		JLabel hintRevealedLabel = new JLabel("'" + displayHint() + "'" + " - your FairyGodTA, Jami");
		hintRevealedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		hintRevealedLabel.setBounds(103, 636, 391, 28);
		layeredPane1.add(hintRevealedLabel);
		hintRevealedLabel.setVisible(false);
		
		JLabel fairyRevealLabel = new JLabel("");
		fairyRevealLabel.setIcon(new ImageIcon("fairy2.png"));
		fairyRevealLabel.setBounds(465, 547, 180, 163);
		layeredPane1.add(fairyRevealLabel);
		fairyRevealLabel.setVisible(false);
		
		
		
		JButton hintButton = new JButton("HINT");
		hintButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hintRevealedLabel.setVisible(true);
				fairyRevealLabel.setVisible(true);
				hintButton.setVisible(false);
				
			}
		});
		hintButton.setBounds(141, 584, 375, 21);
		layeredPane1.add(hintButton);
		
		JRadioButton answerBtn1 = new JRadioButton(q1.getCurrentQuestion().getAnswer1());
		answerBtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (answerBtn1.isSelected()) {
				checkAnswer("answerBtn1");
				}
				
			}
		});
		answerBtn1.setBounds(35, 430, 573, 21);
		layeredPane1.add(answerBtn1);
		
		
		JRadioButton answerBtn2 = new JRadioButton(q1.getCurrentQuestion().getAnswer2());
		answerBtn2.setBounds(35, 460, 573, 21);
		layeredPane1.add(answerBtn2);
		
		
		JRadioButton answerBtn3 = new JRadioButton(q1.getCurrentQuestion().getAnswer3());
		answerBtn3.setBounds(35, 490, 573, 21);
		layeredPane1.add(answerBtn3);
		
		
		JRadioButton answerBtn4 = new JRadioButton(q1.getCurrentQuestion().getAnswer4());
		answerBtn4.setBounds(35, 520, 573, 21);
		layeredPane1.add(answerBtn4);
		
		bg = new ButtonGroup();
		bg.add(answerBtn1);
		bg.add(answerBtn2);
		bg.add(answerBtn3);
		bg.add(answerBtn4);

		
		
		//LABEL FOR THE JAVA MONSTER BACKGROUND IMAGE
		javaMonsterImageLabel = new JLabel("");
		javaMonsterImageLabel.setVerticalAlignment(SwingConstants.TOP);
		javaMonsterImageLabel.setIcon(new ImageIcon(monsterGenerator()));//WORKING HERE
		javaMonsterImageLabel.setBounds(0, 0, 645, 695);
		layeredPane1.add(javaMonsterImageLabel);
		
		JLabel treasureImageLabel = new JLabel("");
		treasureImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		treasureImageLabel.setIcon(new ImageIcon("C:\\Users\\Murrai.Scanlon\\Desktop\\github\\final-project-team-30\\diamond2.png"));
		treasureImageLabel.setBounds(212, 50, 243, 180);
		layeredPane1.add(treasureImageLabel);
		
		JLabel collectTreasureLabel = new JLabel(collectTreasureNotify("Debug Diamond"));//call notify and use treasure name as param
		collectTreasureLabel.setHorizontalAlignment(SwingConstants.CENTER);
		collectTreasureLabel.setBounds(212, 200, 267, 98);
		layeredPane1.add(collectTreasureLabel);
		
		
		
		
	}
	
	public void checkAnswer(String AnswerButtonNumber) {
		
		String buttonNumber = AnswerButtonNumber;
		int buttonInt = 0;
		switch (buttonNumber) {
		case "answerBtn1":
			buttonInt = 1;
			if (1 == buttonInt) {//WORKING HERE (this needs to compare the actual current correct answer
				javaMonsterImageLabel.setVisible(false);
				timerMethod();
								
			}
		case "answerBtn2":
			buttonInt = 2;//FINISH OUT THIS SWITCH WHEN THE FIRST ONE IS GOOD TO GO
			
		}
			
	}
	
	
	public String displayQuestion() {
		Question qpack = q1.getCurrentQuestion();
		String qpackString = qpack.toString();
		
		return qpackString;
	}
	
	
	public String displayHint() {
		String currentHint = q1.getCurrentQuestion().getHint();
		return currentHint;
	}
	
	public String monsterGenerator() {
		Random randomMonster = new Random();
		ArrayList<String> javaMonsters = new ArrayList<String>();
		javaMonsters.add("assassinBlock.png");
		javaMonsters.add("ghostBlock.png");
		javaMonsters.add("ogreBlock.png");
		javaMonsters.add("gremlinBlock.png");
		javaMonsters.add("dragonBlock.png");
		javaMonsters.add("mummyBlock.png");
		int randomChoice = randomMonster.nextInt(javaMonsters.size());
		String currentMonster = javaMonsters.get(randomChoice);
		return currentMonster;
	}
	
	public String collectTreasureNotify(String currentTreasure) {
		
		String thisCurrentTreasure = currentTreasure;
		String message = "<HTML>Well done, " + SwingEnterPage.playerName + " You have added a new treasure to your inventory! " + 
		"COLLECTED: " + currentTreasure + "</HTML>";
		
		
		return message;
	}
	
	public void returnToRoom() {
		frame.setVisible(false);//yay!! it works!
		SwingRoom sw = new SwingRoom();
		sw.setVisible(true);
		
	}
	
	public void timerMethod() {
		Timer timer = new Timer(5000, new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent arg0) {    
		    	
		    	frame.setVisible(false);//yay!! it works!
		        
		    	//returnToRoom();
		    }
		});
		timer.setRepeats(false);
		timer.start();
	}
}

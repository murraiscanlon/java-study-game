package game;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;

/**
 * Class contains the framework for castle rooms Main area for game play
 * 
 * @author Team 30
 *
 */
public class SwingRoom extends JFrame {
	/**
	 * Instance Variables
	 */
	private static final long serialVersionUID = 1L;
	private JPanel roomArea;
	private JLayeredPane layeredPane;
	private JLabel scrollLabel = new JLabel();
	private Room currentRoom; // Track current room
	private Rooms rooms;
	private JButton roomN;
	private JButton roomS;
	private JButton roomE;
	private JButton roomW;
	private JButton treasureButton;
	private JButton helpButton;
	private JButton exitButton;
	private Questions questions;
	private Question q;
	private QuestionBoxDialog qbDialog;
	private Instructions inst;
	private JLabel backgroundLbl = new JLabel();
	private Icon bgIcon = new ImageIcon();
	private JLabel background;
	private JLabel inventory;
	private Icon fairy;
	private JLabel scoreLabel;
	private JLabel bitcoin;
	private JLabel diamond;
	private JLabel magicIDE;
	private JLabel sword;
	private JLabel keyCompiler;
	private JLabel jewel;
	private JLabel tList;
	private Score score = new Score();

	/**
	 * Constructor
	 * 
	 * @param playerName - Player name entered in the beginning
	 */
	public SwingRoom(String playerName) {

		/***** Initialize the Rooms *****/
		initRooms(playerName);

		/***** Set up the Room UI foundation *****/
		setUpUIFoundation();

		/***** Set up the Question Dialog Window and initialize questions *****/
		setUpQuestionDialogWindow();

		/***** Set up the Instructions Window *****/
		setUpInstructions();

		/***** Set up the Direction Buttons *****/
		setUpDirButtons();

		/***** Set up the Help Button *****/
		setUpHelpButton();

		/***** Set up the Quit / Exit Button *****/
		setUpQuitButton();

		/***** Set up the background *****/
		setUpBackground();

		/***** Set up the scroll label *****/
		setUpScrollLabel();

		/***** Set up the inventory label *****/
		setUpInventoryLabel();

		/***** Set up the scoring label *****/
		setUpScoreLabel();

		/***** Set up the fairy *****/
		setUpFairy();

		/***** Set up Treasure Labels *****/
		setUpTreasures();

		/***** Set up the treasure button *****/
		setUpTreasureButton();

		/***** Final background set up *****/
		finalBGSetup();

		/***** Prepare to start the game *****/
		postUISetup();
	}

	/**
	 * Method initializes all the game rooms and set up the treasures in the rooms
	 */
	private void initRooms(String playerName) {
		String roomFilename = "rooms12.csv"; // File with rooms
		rooms = new Rooms(roomFilename); // Instance of Rooms that contains the map of the rooms
		this.currentRoom = rooms.getRoomAtID(1); // Set the initial room to id 1
		questions = new Questions();
		questions.shuffleQuestions();
		score.setName(playerName);
	}

	/**
	 * Method to set up the foundation for the UI
	 */
	private void setUpUIFoundation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		setLocationRelativeTo(null);
		roomArea = new JPanel();
		roomArea.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(roomArea);
		roomArea.setLayout(new CardLayout(0, 0));

		layeredPane = new JLayeredPane();
		layeredPane.setBackground(Color.GRAY);
		layeredPane.setOpaque(false);
		roomArea.add(layeredPane, "");
		layeredPane.setLayout(null);
	}

	/**
	 * Method to set up the Question Dialog Window
	 */
	private void setUpQuestionDialogWindow() {
		qbDialog = new QuestionBoxDialog(this); // New Dialog Box
		qbDialog.setLocationRelativeTo(null);
		qbDialog.addQuestionBoxListener(new QuestionBoxListener() {
			public void questionBoxEventOccurred(QuestionBoxEvent event) {
				qbDialog.setVisible(false);
				showHideDirButtons();
				GameStatus scoreIndicator = event.getScoreIndicator();
				processReturnFromQBD(scoreIndicator);
			}
		});
	}

	/**
	 * Method to set up the instruction pop up window
	 */
	private void setUpInstructions() {
		inst = new Instructions(this);
		inst.setLocationRelativeTo(null);
		inst.setVisible(true);
	}

	/**
	 * Method to create and set up the directional buttons
	 */
	private void setUpDirButtons() {

		roomN = new DirectionButton("N", 730, 354);
		roomN.addActionListener(e -> {
			Room nextRoom = currentRoom.getRoomAtDirection("north");
			processNextRoom(nextRoom);
		});
		layeredPane.add(roomN);

		roomW = new DirectionButton("W", 685, 394);
		roomW.addActionListener(e -> {
			Room nextRoom = currentRoom.getRoomAtDirection("west");
			processNextRoom(nextRoom);
		});
		layeredPane.add(roomW);

		roomS = new DirectionButton("S", 730, 433);
		roomS.addActionListener(e -> {
			Room nextRoom = currentRoom.getRoomAtDirection("south");
			processNextRoom(nextRoom);
		});
		layeredPane.add(roomS);

		roomE = new DirectionButton("E", 777, 394);
		roomE.addActionListener(e -> {
			Room nextRoom = currentRoom.getRoomAtDirection("east");
			processNextRoom(nextRoom);
		});
		layeredPane.add(roomE);
	}

	/**
	 * Method to set up Help / Instructions button
	 */
	private void setUpHelpButton() {
		helpButton = new DirectionButton("Help", 730, 480);
		helpButton.setLocation(730, 485);
		helpButton.addActionListener(e -> {
			inst.setVisible(true);
		});
		layeredPane.add(helpButton);
	}

	/**
	 * Method to setup the Quit / Exit button
	 */
	private void setUpQuitButton() {
		// Exit button upper right corner, has same format as Direction Button
		exitButton = new DirectionButton("QUIT", 715, 35);
		exitButton.setLocation(730, 23);
		exitButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		exitButton.addActionListener(e -> {
			System.exit(0);
		});
		layeredPane.add(exitButton);
	}

	/**
	 * Method to set up the background
	 */
	private void setUpBackground() {
		background = new JLabel(new ImageIcon("images/scroll2.png"));
		layeredPane.add(background);
		background.setBounds(60, 0, 687, 124);
		background.setLayout(new BorderLayout());
	}

	/**
	 * Method to set up the fairy
	 */
	private void setUpFairy() {
		fairy = new ImageIcon("images/fairy1.png");
		JLabel fairyPlace = new JLabel(fairy, JLabel.CENTER);
		fairyPlace.setBounds(694, 75, 180, 185);
		layeredPane.add(fairyPlace);
	}

	/**
	 * Method to set up the scroll label that describes the room
	 */
	private void setUpScrollLabel() {
		scrollLabel = new JLabel();
		scrollLabel.setText("<HTML>" + currentRoom.getLongDesc() + "</HTML>");
		scrollLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		scrollLabel.setBounds(10, 10, 600, 100);
		scrollLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scrollLabel.setOpaque(false);
		background.add(scrollLabel, BorderLayout.CENTER);//
	}

	/**
	 * Method to set up the Inventory label
	 */
	private void setUpInventoryLabel() {
		inventory = new JLabel("You have no treasures yet!");
		inventory.setHorizontalAlignment(SwingConstants.CENTER);
		inventory.setLayout(null);
		inventory.setBackground(new Color(0, 0, 0));
		inventory.setForeground(new Color(255, 255, 255));
		inventory.setBounds(60, 503, 825, 61);
		inventory.setOpaque(true);
		inventory.setFont(new Font("Tahoma", Font.PLAIN, 15));
		layeredPane.add(inventory);
	}

	/*
	 * Method to place current score on main window.
	 */
	private void setUpScoreLabel() {
		scoreLabel = new JLabel("Score: 0");
		scoreLabel.setBorder(new LineBorder(new Color(153, 153, 153), 2));
		scoreLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		scoreLabel.setBackground(new Color(60, 0, 0));
		scoreLabel.setForeground(Color.WHITE);
		scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scoreLabel.setOpaque(true);
		scoreLabel.setBounds(328, 99, 200, 54);
		layeredPane.add(scoreLabel);
	}

	/**
	 * Method to set up Treasure Labels Uses TreasureLabel class to generate
	 * treasure icons
	 */
	private void setUpTreasures() {

		bitcoin = new TreasureLabel(0, 38, "images/bitcoinS.png");
		layeredPane.add(bitcoin);

		diamond = new TreasureLabel(0, 130, "images/diamondS.png");
		layeredPane.add(diamond);

		keyCompiler = new TreasureLabel(0, 194, "images/keyCompilerS.png");
		layeredPane.add(keyCompiler);

		magicIDE = new TreasureLabel(0, 269, "images/magicIDES.png");
		layeredPane.add(magicIDE);

		sword = new TreasureLabel(0, 355, "images/swordS.png");
		layeredPane.add(sword);

		jewel = new TreasureLabel(0, 446, "images/jewelS.png");
		layeredPane.add(jewel);

		tList = new JLabel("Your Treasures");
		tList.setVerticalAlignment(SwingConstants.TOP);
		tList.setFont(new Font("Tahoma", Font.PLAIN, 10));
		tList.setForeground(new Color(255, 255, 255));
		tList.setHorizontalAlignment(SwingConstants.CENTER);
		tList.setBackground(new Color(0, 0, 0));
		tList.setOpaque(true);
		tList.setBounds(0, 0, 85, 564);
		layeredPane.add(tList);
	}

	/**
	 * Method to establish Treasure Chest
	 */
	private void setUpTreasureButton() {
		treasureButton = new JButton(new ImageIcon("images/treasureS.png"));
		treasureButton.setToolTipText("Take Treasure");
		treasureButton.setBackground(Color.BLACK);
		treasureButton.setOpaque(true);
		treasureButton.setBounds(358, 282, 161, 133);
		treasureButton.addActionListener(e -> {
			treasureButtonPushed();
		});
		layeredPane.add(treasureButton);
	}

	/**
	 * Method finishes up the background set up
	 */
	private void finalBGSetup() {
		bgIcon = new ImageIcon(currentRoom.getImage());
		backgroundLbl = new JLabel(bgIcon, JLabel.CENTER);
		backgroundLbl.setForeground(new Color(0, 0, 0));
		backgroundLbl.setBackground(new Color(128, 128, 0));
		backgroundLbl.setBounds(0, 0, 900, 600);
		layeredPane.add(backgroundLbl);
	}

	/**
	 * Post UI setup
	 */
	private void postUISetup() {
		showHideDirButtons();
	}

	/*** Game Play Methods ***/

	/**
	 * Method processes the next room. It checks if it exists, and if so if it was
	 * visited or not
	 * 
	 * @param nextRoom : Room to enter, can be null
	 */
	public void processNextRoom(Room nextRoom) {
		// Leave print statements in for future testing
		// System.out.println("Current Room: " + currentRoom.getName());

		if (nextRoom != null) {
			currentRoom = nextRoom;
			if (currentRoom.wasVisited()) {
				scrollLabel.setText(currentRoom.getShortDesc());
				backgroundLbl.setIcon(new ImageIcon(currentRoom.getImage()));
			} else {
				scrollLabel.setText(currentRoom.getLongDesc());
				backgroundLbl.setIcon(new ImageIcon(currentRoom.getImage()));
				currentRoom.setVisited();
			}
			showHideDirButtons();
		}
		// *** Leave print statements in for future testing ***
		// System.out.println("Next Room: "+ currentRoom.getName());
		// System.out.println("Treasure is:" + currentRoom.getTreasureType());
	}

	/**
	 * Method shows or hides buttons depending on if there is an adjacent room.
	 */
	public void showHideDirButtons() {
		if (currentRoom.getRoomAtDirection("north") == null) {
			roomN.setEnabled(false);
		} else {
			roomN.setEnabled(true);
		}

		if (currentRoom.getRoomAtDirection("south") == null) {
			roomS.setEnabled(false);
		} else {
			roomS.setEnabled(true);
		}

		if (currentRoom.getRoomAtDirection("west") == null) {
			roomW.setEnabled(false);
		} else {
			roomW.setEnabled(true);
		}

		if (currentRoom.getRoomAtDirection("east") == null) {
			roomE.setEnabled(false);
		} else {
			roomE.setEnabled(true);
		}

		if (currentRoom.getTreasure() == null) {
			treasureButton.setVisible(false);
		} else {
			treasureButton.setVisible(true);
		}
	}

	/**
	 * Method handles calling the question dialog when the treasure button is pushed
	 */
	public void treasureButtonPushed() {
		// Leave print statements in for future testing
		// System.out.println("TreasureButtonPushed");
		q = questions.getCurrentQuestion();
		qbDialog.setUpQuestion(q);
		qbDialog.setVisible(true);
	}

	/**
	 * Method handles player input and scores questions
	 * 
	 * @param scoreIndicator - indicates is player answered question correctly and
	 *                       if they used a hint
	 */
	public void processReturnFromQBD(GameStatus scoreIndicator) {
		if (scoreIndicator == GameStatus.QUESTION_WRONG) {
			score.incrementWrongQuestions();
		}
		if ((scoreIndicator == GameStatus.QUESTION_CORRECT) || (scoreIndicator == GameStatus.QUESTION_WITH_HINT)) { // Answered
																													// correctly
			if (currentRoom.getTreasure() != null) {
				Treasure currentTreasure = currentRoom.getTreasure();
				currentTreasure.setRoomId(0); // Remove treasure from the room
				score.addTreasure(currentTreasure); // Add treasure to the players inventory
				if (scoreIndicator == GameStatus.QUESTION_CORRECT) { // No hint
					score.addPoints(currentTreasure.getPoints());
				} else if (scoreIndicator == GameStatus.QUESTION_WITH_HINT) { // Player needed hint, remove one point
					score.addPoints(currentTreasure.getPoints() - 1);
				}
				currentRoom.setTreasure(null);
				String inventoryString = "";
				for (int i = 0; i < score.getTreasures().size(); i++) {
					inventoryString += score.getTreasures().get(i).getTreasureType();
					if (i < score.getTreasures().size() - 1) {
						inventoryString += ", ";
					}
				}
				inventory.setText(inventoryString);

				// Displays treasure that is collected
				if (currentTreasure.getTreasureType() == "Bitcoin") {
					bitcoin.setVisible(true);
				} else if (currentTreasure.getTreasureType() == "Jewel Editor") {
					jewel.setVisible(true);
				} else if (currentTreasure.getTreasureType() == "Java Sword") {
					sword.setVisible(true);
				} else if (currentTreasure.getTreasureType() == "Diamond Debugger") {
					diamond.setVisible(true);
				} else if (currentTreasure.getTreasureType() == "Key Compiler") {
					keyCompiler.setVisible(true);
				} else if (currentTreasure.getTreasureType() == "Magic IDE") {
					magicIDE.setVisible(true);
				}
				treasureButton.setVisible(false);
			}
		}
		scoreLabel.setText("Score: " + score.getCurrentScore());
		// Check the game status to see if the player won or lost
		GameStatus gameStatus = score.checkGameStatus();
		// Keep print statement for testing
		// System.out.println("Game Status : " + gameStatus);

		// Check to see if player has won or lost:

		// Sends player to GameOver Page
		if (gameStatus == GameStatus.GAME_OVER_WIN) {
			dispose();
			SwingGameOver win = new SwingGameOver(score);
			win.getWinMsg();
			// Call the winning game over screen
			// Keep print statement for testing
			// System.out.println("*** You Won! ***");
		} else if (gameStatus == GameStatus.GAME_OVER_LOSE) {
			dispose();
			SwingGameOver lose = new SwingGameOver(score);
			lose.getLoseMsg();
			// Call the losing game over screen
			// Keep print statement for testing
			// System.out.println("*** You Lost! 8-( ***");
		}
	}
}

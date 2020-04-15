package game;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

public class SwingRoom extends JFrame {

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
	private Questions1 questions;
	private Question q;
	private QuestionBoxDialog qbDialog;
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
	 * Create the Swing interface for a room in the game
	 */
	public SwingRoom() {

		/***** Initialize the Rooms  *****/
		initRooms();
		/***** Set up the Room UI foundation  *****/
		setUpUIFoundation();
		/***** Set up the Question Dialog Window and initialize questions  *****/
		setUpQuestionDialogWindow();
		/***** Set up the Direction Buttons  *****/
		setUpDirButtons();
		/***** Set up the Quit / Exit Button  *****/
		setUpQuitButton();
		/***** Set up the background  *****/
		setUpBackground();
		/***** Set up the scroll label  *****/
		setUpScrollLabel();
		/***** Set up the inventory label  *****/
		setUpInventoryLabel();
		/***** Set up the scoring label  *****/
		setUpScoreLabel();
		/***** Set up the fairy  *****/
		setUpFairy();			
		/*****Set up Treasure Labels*****/
		setUpTreasures();
		/***** Set up the treasure button  *****/
		setUpTreasureButton();
		/***** Final background set up  *****/
		finalBGSetup();
		/***** Prepare to start the game  *****/
		postUISetup();
	}

	/** Helper methods **/	

	/**
	 * Method initializes all the game rooms and set up the treasures in the rooms
	 */
	public void initRooms() {
		String roomFilename = "rooms12.csv"; // File with rooms
		rooms = new Rooms(roomFilename); // Instance of Rooms that contains the map of the rooms
		this.currentRoom = rooms.getRoomAtID(1); // Set the initial room to id 1
		questions = new Questions1();
		questions.shuffleQuestions();
	}

	/**
	 * Method to set up the foundation for the UI
	 */
	public void setUpUIFoundation(){
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
	public void setUpQuestionDialogWindow() {
		qbDialog = new QuestionBoxDialog(this); // New Dialog Box
		qbDialog.setLocationRelativeTo(null);
		qbDialog.addQuestionBoxListener(new QuestionBoxListener() {
			public void questionBoxEventOccurred(QuestionBoxEvent event) {
				qbDialog.setVisible(false);
				showHideDirButtons();
				GameStatus scoreIndicator = event.getScoreIndicator();
				System.out.println("Returned score indicator: " + scoreIndicator);
				//TODO remove print statement
				processReturnFromQBD(scoreIndicator);
			}
		});	
	}

	/**
	 * Method to create and set up the directional buttons
	 */
	public void setUpDirButtons() {

		roomN = new DirectionButton("N", 730, 354);
		roomN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Room nextRoom = currentRoom.getRoomAtDirection("north");
				processNextRoom(nextRoom);
			}
		});
		layeredPane.add(roomN);	

		roomW = new DirectionButton("W", 685, 394);
		roomW.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Room nextRoom = currentRoom.getRoomAtDirection("west");
				processNextRoom(nextRoom);
			}
		});
		layeredPane.add(roomW);

		roomS = new DirectionButton("S", 730, 433);
		roomS.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Room nextRoom = currentRoom.getRoomAtDirection("south");
				processNextRoom(nextRoom);
			}
		});    
		layeredPane.add(roomS);

		roomE = new DirectionButton("E", 777, 394);
		roomE.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Room nextRoom = currentRoom.getRoomAtDirection("east");
				processNextRoom(nextRoom);
			}
		});    
		layeredPane.add(roomE);
	}

	/**
	 * Method to setup the Quit / Exit button
	 */
	public void setUpQuitButton() {
		//Exit button upper right corner, has same format as Direction Button
		JButton exitButton = new DirectionButton("QUIT",715, 35, 120, 40);
		exitButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		layeredPane.add(exitButton);
	}

	/**
	 * Method to set up the background
	 */
	public void setUpBackground() {
		background = new JLabel(new ImageIcon("images/scroll2.png"));
		layeredPane.add(background);
		background.setBounds(60, 0, 687, 124);
		background.setLayout(new BorderLayout());
	}

	/**
	 * Set up the fairy
	 */
	public void setUpFairy() {
		fairy = new ImageIcon("images/fairy1.png");
		JLabel fairyPlace = new JLabel(fairy, JLabel.CENTER);
		fairyPlace.setBounds(694, 75, 180, 185);
		layeredPane.add(fairyPlace);
	}

	/**
	 * Method to set up the scroll label that describes the room
	 */
	public void setUpScrollLabel() {
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
	public void setUpInventoryLabel() {
		inventory = new JLabel("You have no treasures yet!");
		inventory.setHorizontalAlignment(SwingConstants.CENTER);
		//inventory.setBounds(0, 500, 874, 30);
		inventory.setLayout(null);
		inventory.setBackground(new Color(0, 0, 0));
		inventory.setForeground(new Color(255, 255, 255));
		inventory.setBounds(84, 509, 790, 41);
		inventory.setOpaque(true);
		inventory.setFont(new Font("Tahoma", Font.PLAIN, 15));
		//inventory.setHorizontalAlignment(SwingConstants.CENTER);

		layeredPane.add(inventory);
	}

	/*
	 * Method to place current score on main window.
	 */
	public void setUpScoreLabel() {
		scoreLabel = new JLabel("");
		scoreLabel.setBounds(349, 86, 435, 86);
		scoreLabel.setBackground(new Color(0, 0, 0));		
		scoreLabel.setForeground(new Color(255, 255, 255));
		scoreLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		//scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		//scoreLabel.setBounds(607, 510, 267, 41);
		//scoreLabel.setOpaque(true);
		layeredPane.add(scoreLabel);
	}

	/**
	 * Method to set up Treasure Labels
	 * 
	 */
	public void setUpTreasures() {
		bitcoin = new JLabel("");
		bitcoin.setIcon(new ImageIcon("images/bitcoinS.png"));
		bitcoin.setHorizontalAlignment(SwingConstants.CENTER);
		bitcoin.setBackground(Color.GRAY);
		bitcoin.setBounds(0, 38, 84, 79);
		bitcoin.setVisible(false);
		layeredPane.add(bitcoin);

		diamond = new JLabel("");
		diamond.setForeground(new Color(255, 255, 255));
		diamond.setIcon(new ImageIcon("images/diamondS.png"));
		diamond.setHorizontalAlignment(SwingConstants.CENTER);
		diamond.setBackground(Color.GRAY);
		diamond.setBounds(4, 130, 80, 80);
		diamond.setVisible(false);
		layeredPane.add(diamond);

		keyCompiler = new JLabel("");
		keyCompiler.setIcon(new ImageIcon("images/keyCompilerS.png"));
		keyCompiler.setHorizontalAlignment(SwingConstants.CENTER);
		keyCompiler.setBackground(Color.GRAY);
		keyCompiler.setBounds(0, 194, 80, 80);
		keyCompiler.setVisible(false);
		layeredPane.add(keyCompiler);

		magicIDE = new JLabel("");
		magicIDE.setIcon(new ImageIcon("images/magicIDES.png"));
		magicIDE.setHorizontalAlignment(SwingConstants.CENTER);
		magicIDE.setBackground(Color.GRAY);
		magicIDE.setBounds(4, 269, 80, 80);
		magicIDE.setVisible(false);
		layeredPane.add(magicIDE);

		sword = new JLabel("");
		sword.setIcon(new ImageIcon("images/swordS.png"));
		sword.setHorizontalAlignment(SwingConstants.CENTER);
		sword.setBackground(Color.GRAY);
		sword.setBounds(4, 355, 80, 80);
		sword.setVisible(false);
		layeredPane.add(sword);

		jewel = new JLabel("");
		jewel.setIcon(new ImageIcon("images/jewelS.png"));
		jewel.setHorizontalAlignment(SwingConstants.CENTER);
		jewel.setBackground(Color.GRAY);
		jewel.setBounds(0, 446, 80, 80);
		jewel.setVisible(false);
		layeredPane.add(jewel);

		tList = new JLabel("Your Treasures");
		tList.setVerticalAlignment(SwingConstants.TOP);
		tList.setFont(new Font("Tahoma", Font.PLAIN, 10));
		tList.setForeground(new Color(255, 255, 255));
		tList.setHorizontalAlignment(SwingConstants.CENTER);
		tList.setBackground(new Color(0, 0, 0));
		tList.setOpaque(true);
		tList.setBounds(0, 0, 85, 550);
		layeredPane.add(tList);
	}


	public void setUpTreasureButton() {
		treasureButton = new JButton(new ImageIcon("images/treasureS.png"));
		treasureButton.setToolTipText("Take Treasure");
		treasureButton.setBackground(Color.BLACK);
		treasureButton.setBounds(371, 274, 161, 133);

		treasureButton.addMouseListener(new MouseAdapter() {
			//write method to have something happen when click on treasure
			@Override
			public void mouseClicked(MouseEvent e) {
				treasureButtonPushed();
			}
		});
		layeredPane.add(treasureButton);
	}

	/**
	 * Method finishes up the background set up
	 */
	public void finalBGSetup() {
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
	public void postUISetup() {
		showHideDirButtons();
	}


	/**
	 * Method processes the next room.  It checks if it exists, and if so if it was 
	 * visited or not
	 * @param nextRoom : Room to enter, can be null
	 */
	public void processNextRoom(Room nextRoom) {
		System.out.println("Current Room: "+ currentRoom.getName());

		if(nextRoom != null) {
			currentRoom = nextRoom;
			//			String treasureType = "";
			//			if (currentRoom.getTreasure() != null) {
			//				treasureType=currentRoom.getTreasureType();
			//				
			//			}
			if (currentRoom.wasVisited()) {
				scrollLabel.setText(currentRoom.getShortDesc());    
				backgroundLbl.setIcon(new ImageIcon(currentRoom.getImage()));
			}
			else {
				scrollLabel.setText(currentRoom.getLongDesc());
				backgroundLbl.setIcon(new ImageIcon(currentRoom.getImage()));
				currentRoom.setVisited();
			}
			showHideDirButtons();
		}
		System.out.println("Next Room: "+ currentRoom.getName());
		System.out.println("Treasure is:" + currentRoom.getTreasureType());
	}


	/**
	 * Method shows or hides buttons depending on if there is an adjacent room.
	 */
	public void showHideDirButtons(){
		if(currentRoom.getRoomAtDirection("north") == null) {
			roomN.setEnabled(false);
		}
		else {
			roomN.setEnabled(true);
		}		

		if(currentRoom.getRoomAtDirection("south") == null) {
			roomS.setEnabled(false);
		}
		else {
			roomS.setEnabled(true);
		}		

		if(currentRoom.getRoomAtDirection("west") == null) {
			roomW.setEnabled(false);
		}
		else {
			roomW.setEnabled(true);
		}		

		if(currentRoom.getRoomAtDirection("east") == null) {
			roomE.setEnabled(false);
		}
		else {
			roomE.setEnabled(true);
		}

		if(currentRoom.getTreasure() == null) {
			treasureButton.setVisible(false);
		}
		else {
			treasureButton.setVisible(true);
		}
	}

	/**
	 * Method handles calling the question dialog when the treasure button is pushed
	 */
	public void treasureButtonPushed() {
		System.out.println("TreasureButtonPushed");
		q = questions.getCurrentQuestion();
		qbDialog.setUpQuestion(q);
		//		qbDialog.setUpTreasure(currentRoom.getTreasure());
		qbDialog.setVisible(true);
	}
	/**
	 * Handles player input and scores questions
	 * @param scoreIndicator
	 */
	public void processReturnFromQBD(GameStatus scoreIndicator) {
		if (scoreIndicator == GameStatus.QuestionWrong) {
			score.incrementWrongQuestions();
		}
		if ((scoreIndicator == GameStatus.QuestionCorrect) || (scoreIndicator == GameStatus.QuestionWithHint)) {
			if (currentRoom.getTreasure() != null) {
				Treasure currentTreasure = currentRoom.getTreasure();
				currentTreasure.setRoomId(0);
				//treasureInventory.add(currentTreasure);
				score.addTreasure(currentTreasure);
				if(scoreIndicator == GameStatus.QuestionCorrect) {
					score.addPoints(currentTreasure.getPoints());
				}
				else if (scoreIndicator == GameStatus.QuestionWithHint) {
					score.addPoints(currentTreasure.getPoints() - 1);
				}
				currentRoom.setTreasure(null);
				String inventoryString = "";
				for (int i = 0; i < score.getTreasures().size(); i++) {
					inventoryString += score.getTreasures().get(i).getTreasureType();
					if (i < score.getTreasures().size()-1) {
						inventoryString += ", ";
					}
				}
				inventory.setText(inventoryString);
				//Displays treasure that is collected
				if (currentTreasure.getTreasureType() == "Bitcoin") {
					bitcoin.setVisible(true);
				}
				else if (currentTreasure.getTreasureType() == "Jewel Editor") {
					jewel.setVisible(true);
				}
				else if (currentTreasure.getTreasureType() == "Java Sword") {
					sword.setVisible(true);
				}
				else if (currentTreasure.getTreasureType() == "Diamond Debugger") {
					diamond.setVisible(true);
				}
				else if (currentTreasure.getTreasureType() == "Key Compiler") {
					keyCompiler.setVisible(true);
				}
				else if (currentTreasure.getTreasureType() == "Magic IDE") {
					magicIDE.setVisible(true);
				}
				treasureButton.setVisible(false);
			} 
		}
		scoreLabel.setText("Score: " + score.getCurrentScore());
		// Check the game status to see if the player won or lost
		GameStatus gameStatus = score.checkGameStatus();
		System.out.println("Game Status : " + gameStatus);
		if (gameStatus == GameStatus.GameOverWin) {
			dispose();
			SwingGameOver win = new SwingGameOver();
			win.getWinMsg();
			//win.getFinalScore();//show score on final page
			// Call the winning game over screen
			System.out.println("*** You Won! ***");
		}
		else if (gameStatus == GameStatus.GameOverLose) {
			dispose();
			SwingGameOver lose = new SwingGameOver();
			lose.getLoseMsg();
			//lose.getFinalScore();//show score on final page
			// Call the losing game over screen					
			System.out.println("*** You Lost! 8-( ***");
		}
	}

}


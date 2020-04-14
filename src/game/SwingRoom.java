package game;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Graphics;

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
	JLabel background;
	JLabel inventory;
	Icon fairy;
	private ArrayList<Treasure> treasureInventory = new ArrayList<Treasure>();
	private int score = 0;
	JLabel scoreLabel;
	private JLabel tLabel;
    private JLabel tTitle;
    private ImageIcon tPic;
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
		/*****Set up Treasure Label*****/
		setUpTreasureLabel();
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
	}
	
	/**
	 * Method to set up the foundation for the UI
	 */
	public void setUpUIFoundation(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
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
//				String text = event.getText(); // Information to return from Dialog Box
//				System.out.println("Returned text: " + text); 
				int scoreIndicator = event.getScoreIndicator();
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
		JButton exitButton = new DirectionButton("QUIT",775, 0);        
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
	 * Method to set up the scroll label that describes the room
	 */
	public void setUpScrollLabel() {
		scrollLabel = new JLabel();
		scrollLabel.setText(currentRoom.getLongDesc());
		scrollLabel.setBounds(10, 10, 600, 100);
		scrollLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scrollLabel.setOpaque(false);
		background.add(scrollLabel, BorderLayout.CENTER);
	}
	
	/**
	 * Method to set up the Inventory label
	 */
	public void setUpInventoryLabel() {
		inventory = new JLabel("Inventory List Placeholder");
        inventory.setBackground(Color.GRAY);
        inventory.setForeground(new Color(255, 255, 255));
        inventory.setFont(new Font("Tahoma", Font.PLAIN, 14));
        inventory.setHorizontalAlignment(SwingConstants.CENTER);
        inventory.setBounds(0, 465, 874, 86);
        layeredPane.add(inventory);
	}
	
	
	/*
	 * Method to place current score on main window.
	 */
	public void setUpScoreLabel() {//WORKING HERE
		scoreLabel = new JLabel("");
		scoreLabel.setBackground(Color.GRAY);
		scoreLabel.setForeground(new Color(255, 255, 255));
		scoreLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scoreLabel.setBounds(200, 465, 874, 86);
		layeredPane.add(scoreLabel);
				
	}
	
	/**
	 * Set up the fairy
	 */
	public void setUpFairy() {
		fairy = new ImageIcon("fairy.png");
		JLabel fairyPlace = new JLabel(fairy, JLabel.CENTER);
		fairyPlace.setBounds(218, 152, 180, 185);
		layeredPane.add(fairyPlace);
	}
	/**
     * Method to set up Treasure Labels
     * 
     */
    public void setUpTreasureLabel() {
        tPic = currentRoom.getTreasurePic();
        tTitle = new JLabel("Treasure is: " + currentRoom.getTreasureType());
        tTitle.setBounds(205, 345, 200, 25);        
        tTitle.setForeground(Color.WHITE);
        tLabel = new JLabel(tPic);
        tLabel.setBounds(228, 348, 127, 124);
        layeredPane.add(tLabel);
        layeredPane.add(tTitle);
        if (currentRoom.getTreasure() != null) {           
            
            tLabel.setVisible(true);
            tTitle.setVisible(true);
        }
    }
	
	public void setUpTreasureButton() {
		treasureButton = new JButton(new ImageIcon("images/treasureS.png"));
		treasureButton.setToolTipText("Take Treasure");
		treasureButton.setBackground(Color.BLACK);
		treasureButton.setBounds(365, 341, 161, 133);
		
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
			String treasureType = "";
			if (currentRoom.getTreasure() != null) {
				treasureType=currentRoom.getTreasureType();			
			}
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
		qbDialog.setUpTreasure(currentRoom.getTreasure());
		qbDialog.setVisible(true);
	}

	public void processReturnFromQBD(int scoreIndicator) {
		if ((scoreIndicator == 1) || (scoreIndicator == 2)) {
			if (currentRoom.getTreasure() != null) {
				Treasure currentTreasure = currentRoom.getTreasure();
				currentTreasure.setRoomId(0);
				treasureInventory.add(currentTreasure);
				if(scoreIndicator == 1) {
					score += currentTreasure.getPoints();
				}
				else if (scoreIndicator == 2) {
					score += currentTreasure.getPoints() - 2;
				}
				currentRoom.setTreasure(null);
				String inventoryString = "";
				for (int i = 0; i < treasureInventory.size(); i++) {
					inventoryString += treasureInventory.get(i).getTreasureType() + " ";
				}
				inventory.setText(inventoryString);
				scoreLabel.setText("Current Score: " + score);//WORKING HERE
				treasureButton.setVisible(false);
			} 
		}
	}

}


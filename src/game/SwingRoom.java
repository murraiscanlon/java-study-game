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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLayeredPane;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Graphics;

public class SwingRoom extends JFrame {

	private static final LayoutManager GridBagLayout = null;
	private JPanel roomArea;
	JLabel scrollLabel = new JLabel();
	Room currentRoom; // Track current room
	Rooms rooms;
	JButton roomN;
	JButton roomS;
	JButton roomE;
	JButton roomW;
	JButton treasureButton;
	JButton questionReturnButton;
	Questions1 questions;
	Question q;
	QuestionBox questionBox;
	QuestionBoxDialog qbDialog;
	JLabel question;
	JLabel answer1;
	JLabel answer2;
	JLabel answer3;
	JLabel answer4;
	JLabel backgroundLbl = new JLabel();
    Icon bgIcon = new ImageIcon();

	/**
	 * Launch the room template
	 * 
	 * Room needs to be a generic type with methods to support
	 * adding and subtracting components based which Room the player is in
	 * Required methods to integrate include:
	 * Inventory display, monster display, treasure, score, room background, room descr.
	 * Need to figure out how to hide/show objects based on situation
	 * Event handlers should be able to deal with objects
	 */

	/**
	 * Create the frame.
	 */
	public SwingRoom() {

		//initialize rooms
		initRooms();

		//initial setup
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		roomArea = new JPanel();
		roomArea.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(roomArea);
		roomArea.setLayout(new CardLayout(0, 0));

		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBackground(Color.GRAY);
		layeredPane.setOpaque(false);
		roomArea.add(layeredPane, "");
		layeredPane.setLayout(null);
		
		//Set up QBDialog
		
		qbDialog = new QuestionBoxDialog(this);
		qbDialog.pack();

		//Set up Question Box
	
		questionBox = new QuestionBox();
		layeredPane.add(questionBox);
		questionBox.addQuestionBoxListener(new QuestionBoxListener() {
			public void questionBoxEventOccurred(QuestionBoxEvent event) {
				questionBox.setVisible(false);
				roomN.setVisible(true);
				roomS.setVisible(true);
				roomE.setVisible(true);
				roomW.setVisible(true);
				treasureButton.setVisible(true);
				showHideDirButtons();
			}
		});

		questionBox.setVisible(false);

		//these are the room direction buttons - need to link them to backgrounds
		roomN = new JButton("N");
		roomN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Room nextRoom = currentRoom.getRoomAtDirection("north");
				processNextRoom(nextRoom);
			}
		});
		roomN.setIcon(null);
		roomN.setEnabled(true);        
		roomN.setBackground(new Color(128, 128, 128));        
		roomN.setOpaque(true);
		roomN.setBounds(730, 354, 80, 41);        
		layeredPane.add(roomN);

		roomW = new JButton("W");
		roomW.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Room nextRoom = currentRoom.getRoomAtDirection("west");
				processNextRoom(nextRoom);
			}
		});
		roomW.setIcon(null);
		roomW.setEnabled(true);
		roomW.setForeground(new Color(0, 0, 0));         
		roomW.setBackground(new Color(128, 128, 128));
		roomW.setOpaque(true);
		roomW.setBounds(685, 394, 80, 41);        
		layeredPane.add(roomW);

		roomS = new JButton("S");
		roomS.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Room nextRoom = currentRoom.getRoomAtDirection("south");
				processNextRoom(nextRoom);
			}
		});
		roomS.setIcon(null);
		roomS.setEnabled(true);        
		roomS.setBackground(new Color(128, 128, 128));
		roomS.setOpaque(true);
		roomS.setBounds(730, 433, 80, 41);        
		layeredPane.add(roomS);

		roomE = new JButton("E");
		roomE.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Room nextRoom = currentRoom.getRoomAtDirection("east");
				processNextRoom(nextRoom);
			}
		});
		roomE.setIcon(null);
		roomE.setEnabled(true);        
		roomE.setBackground(new Color(128, 128, 128));
		roomE.setOpaque(true);
		roomE.setBounds(777, 394, 80, 41);        
		layeredPane.add(roomE);
		//
		//Exit button upper right corner
		JButton exitButton = new JButton("QUIT");        
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		exitButton.setEnabled(true);
		exitButton.setIcon(null);

		exitButton.setForeground(new Color(0, 0, 0));
		exitButton.setBackground(new Color(128, 128, 128));

		exitButton.setOpaque(true);
		exitButton.setBounds(775, 0, 100, 41);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});

		layeredPane.add(exitButton);

		JLabel background = new JLabel(new ImageIcon("images/scroll2.png"));
		layeredPane.add(background);
		background.setBounds(60, 0, 687, 124);
		background.setLayout(new BorderLayout());
		
		scrollLabel = new JLabel();
		scrollLabel.setText(currentRoom.getLongDesc());
		scrollLabel.setBounds(10, 10, 600, 100);
		scrollLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scrollLabel.setOpaque(false);
		background.add(scrollLabel, BorderLayout.CENTER);
		
		

		//this will be list of treasures or points
		JLabel inventory = new JLabel("Inventory List Placeholder");
        inventory.setBackground(Color.GRAY);
        inventory.setForeground(new Color(255, 255, 255));
        inventory.setFont(new Font("Tahoma", Font.PLAIN, 14));
        inventory.setHorizontalAlignment(SwingConstants.CENTER);
        inventory.setBounds(0, 465, 874, 86);
        layeredPane.add(inventory);

		Icon fairy = new ImageIcon("fairy.png");
		JLabel fairyPlace = new JLabel(fairy, JLabel.CENTER);
		fairyPlace.setBounds(218, 152, 180, 185);
		layeredPane.add(fairyPlace);

		//take treasure button - can't get this to work right now
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



		//need to write a method that swaps out background images  
		bgIcon = new ImageIcon(currentRoom.getImage());
		backgroundLbl = new JLabel(bgIcon, JLabel.CENTER);
		backgroundLbl.setForeground(new Color(0, 0, 0));
		backgroundLbl.setBackground(new Color(128, 128, 0));
		backgroundLbl.setBounds(0, 0, 900, 600);
		layeredPane.add(backgroundLbl); 

		postUISetup();
	}

	public void initRooms() {
		String roomFilename = "rooms12.csv"; // File with rooms
		rooms = new Rooms(roomFilename); // Instance of Rooms that contains the map of the rooms
		this.currentRoom = rooms.getRoomAtID(1); // Set the initial room to id 1
		questions = new Questions1();
	}

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
//			ImageIcon treasurePic = null;
//			if (currentRoom.getTreasure() != null) {
//			    treasurePic = currentRoom.getTreasurePic();
//				
			}
			if (currentRoom.wasVisited()) {
				//scrollLabel.setText((currentRoom.getShortDesc()) + " " + treasureType);       
			    //scrollLabel.setText(currentRoom.getShortDesc() + " " + treasurePic);
			    scrollLabel.setText(currentRoom.getShortDesc());
			    backgroundLbl.setIcon(new ImageIcon(currentRoom.getImage()));
			}
			else {
				//scrollLabel.setText((currentRoom.getLongDesc()) + " " + treasureType);
				//scrollLabel.setText(currentRoom.getLongDesc()) + " " + treasurePic;
				scrollLabel.setText(currentRoom.getLongDesc());
				backgroundLbl.setIcon(new ImageIcon(currentRoom.getImage()));
				currentRoom.setVisited();
			}
			checkoutLocation();
			showHideDirButtons();
		}
		System.out.println("Next Room: "+ currentRoom.getName());
		System.out.println("Treasure is:" + currentRoom.getTreasureType());
	}

	/**
	 * Tester method to check for location 
	 */
	public void checkoutLocation() {
		//		Need to add code to process being a room
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

	public void treasureButtonPushed() {
		System.out.println("TreasureButtonPushed");
		q = questions.getCurrentQuestion();
		roomN.setVisible(false);
		roomS.setVisible(false);
		roomE.setVisible(false);
		roomW.setVisible(false);
		treasureButton.setVisible(false);
		questionBox.setUpLabels(q);
		questionBox.setVisible(true);
		//qbDialog.setVisible(true);
	}


}


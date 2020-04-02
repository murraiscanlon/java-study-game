package game;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.*;

/**
 * This class is a test version of the game manager
 * Swing is used for the GUI
 * 
 * @author Team 30
 * 3/31/2020
 */
public class SwingInterface extends JFrame {

	private static final long serialVersionUID = 1L; // Something needed for Swing
	Room currentRoom; // Track current room
	JLabel description = new JLabel(); // Description of the current room
	boolean foundTreasure = false; // Flag to show treasure was found (testing purposes)

	public void initializeGame() {

		String roomFilename = "rooms9.csv"; // File with rooms
		Rooms rooms = new Rooms(roomFilename); // Instance of Rooms that contains the map of the rooms
		this.currentRoom = rooms.getRoomAtID(1); // Set the initial room to id 1
	}

	/**
	 * Constructor
	 */
	public SwingInterface() {
		initComponents();
	}

	/**
	 * Initializes the game board
	 */
	public void initComponents() {
		
		initializeGame(); // Initialize game board
		setTitle("Java Zombies"); // Set the title of the GUI window
		setSize(800,800); // Set size of the GUI window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Need to set so that application closes when window closes
		setLocationByPlatform(true);

		JPanel panel = new JPanel(); // Panel for the description
		panel.setLayout(new GridBagLayout()); // Set panel as a grid layout
		GridBagConstraints c = new GridBagConstraints(); // Create a constraint variable to define interface
		c.anchor = GridBagConstraints.LINE_START; 
		c.insets = new Insets(5, 5, 5, 5);
		add(panel, BorderLayout.NORTH); // BoarderLayout is the default Frame - put panel at the top

		c.gridx = 0; c.gridy = 0; // Put description information at 0,0
		panel.add(description,c);
		
		JPanel buttonPanel = new JPanel(); // Panel to Hold the Buttons
		buttonPanel.setLayout(new GridBagLayout()); // Set Layout to grid
		add(buttonPanel, BorderLayout.CENTER); // Put button panel in center of Frame
		
		// North Button
		c.gridx = 1; c.gridy = 0;
		JButton northButton = new JButton("NORTH");
		northButton.addActionListener(e->{
			northButtonPushed();
		});
		buttonPanel.add(northButton, c);
		
		// West Button
		c.gridx = 0; c.gridy = 1;
		JButton westButton = new JButton("WEST");
		westButton.addActionListener(e->{
			westButtonPushed();
		});		buttonPanel.add(westButton, c);

		// East Button
		c.gridx = 2; c.gridy = 1;
		JButton eastButton = new JButton("EAST");
		eastButton.addActionListener(e->{
			eastButtonPushed();
		});		buttonPanel.add(eastButton, c);
		
		// South Button
		c.gridx = 1; c.gridy = 2;
		JButton southButton = new JButton("SOUTH");
		southButton.addActionListener(e->{
			southButtonPushed();
		});		buttonPanel.add(southButton, c);
		
		// Exit Button
		c.gridx = 1; c.gridy = 3;
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(e -> {
			System.exit(0);
		});
		buttonPanel.add(exitButton, c);
		
		// Set description 
		description.setText(currentRoom.getLongDesc());
		setVisible(true);
	}

	/**
	 * Process North Button Pressed
	 */
	public void northButtonPushed() {
		Room nextRoom = currentRoom.getRoomAtDirection("north");
		processNextRoom(nextRoom);
	}

	/**
	 * Process East Button Pressed
	 */
	public void eastButtonPushed() {
		Room nextRoom = currentRoom.getRoomAtDirection("east");
		processNextRoom(nextRoom);
	}

	/**
	 * Process South Button Pressed
	 */
	public void southButtonPushed() {
		Room nextRoom = currentRoom.getRoomAtDirection("south");
		processNextRoom(nextRoom);
	}

	/**
	 * Process West Button Pressed
	 */
	public void westButtonPushed() {
		Room nextRoom = currentRoom.getRoomAtDirection("west");
		processNextRoom(nextRoom);
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
				description.setText((currentRoom.getShortDesc()) + " " + treasureType);
			}
			else {
				description.setText((currentRoom.getLongDesc()) + " " + treasureType);
				currentRoom.setVisited();
			}
			checkoutLocation();
		}
		System.out.println("Next Room: "+ currentRoom.getName());		
	}

	/**
	 * Tester method to check for location 
	 */
	public void checkoutLocation() {
		if (currentRoom.getId() == 3) {
			foundTreasure = true;
		}
		if ((currentRoom.getId() == 1) && (foundTreasure == true)) {
			description.setText("You Won!");
		}
	}
	
	/**
	 * Main method required to run the program.
	 * @param args
	 */
	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(() -> {
			JFrame frame = new SwingInterface();
		});
	}
	
}

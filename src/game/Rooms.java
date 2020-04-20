package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * MCIT 591 Final Project
 * 
 * @author Team 30
 * 
 *         This class is responsible for setting up the rooms in the game. -
 *         Loads the room data from a CSV file - Parses the CSV data into the
 *         room information - Puts the rooms into a HashMap - Puts the room
 *         links in a separate HashMap to set up the connections once all the
 *         rooms are created.
 * 
 *         rooms : HashMap of the rooms using the unique room id as the key and
 *         the room object as the value roomLinks : HashMap of the links between
 *         the rooms - links are created after all the rooms are created
 */
public class Rooms {

	/*
	 * Instance Variables
	 */
	private HashMap<Integer, Room> rooms = new HashMap<Integer, Room>();
	private HashMap<Integer, Integer[]> roomLinks = new HashMap<Integer, Integer[]>();
	private Treasures treasures = new Treasures();

	/**
	 * Rooms Constructor - takes as an argument the file name of the CSV containing
	 * the room data
	 * 
	 * @param roomFilename - CSV containing the room data
	 */
	public Rooms(String roomFilename) {
		loadRoomCSV(roomFilename);
	}

	/**
	 * Method reads in the data from the CSV files and sends to other methods for
	 * processing
	 * 
	 * @param roomFilename
	 */
	private void loadRoomCSV(String roomFilename) {
		File roomFile = new File(roomFilename);
		try {
			Scanner roomFileScanner = new Scanner(roomFile);
			// Read header
			String input = roomFileScanner.nextLine();
			// Read the data
			while (roomFileScanner.hasNextLine()) {
				input = roomFileScanner.nextLine();
				processFileLine(input); // Creates each room based on the CSV data
			}
			roomFileScanner.close();
			processRoomLinks(); // Creates the link between rooms after all the rooms have been created
			processTreasures(); // Creates links to the treasures

		} catch (FileNotFoundException e) {
			System.out.println("Cannot find file <" + roomFilename + ">");
			System.exit(0);
		}
	}

	/**
	 * Method takes each line in the CSV, parses it, and creates a new room object
	 * 
	 * @param line - line of data from the input CSV file
	 */
	public void processFileLine(String line) {
		String[] data = line.split(",");
		if (data.length < 9) {
			return;
		} // There should be 9 fields in each CSV

		// Set default data for the room object
		int id = -1;
		String name = "";
		String shortDesc = "";
		String longDesc = "";
		int n = -1;
		int e = -1;
		int s = -1;
		int w = -1;
		String image = "";

		// If data parsing fails, results are left at their default
		// Print statements in the catch block are to help find issues with csv file
		try {
			id = Integer.parseInt(data[0]);
		} catch (NumberFormatException e1) {
			System.out.println("Bad id <" + data[0] + ">");
		}
		name = data[1];
		shortDesc = data[2];
		longDesc = data[3];

		try {
			n = Integer.parseInt(data[4]);
		} catch (NumberFormatException e1) {
			System.out.println("Bad n <" + data[4] + ">");
		}
		try {
			e = Integer.parseInt(data[5]);
		} catch (NumberFormatException e1) {
			System.out.println("Bad e <" + data[5] + ">");
		}
		try {
			s = Integer.parseInt(data[6]);
		} catch (NumberFormatException e1) {
			System.out.println("Bad s <" + data[6] + ">");
		}
		try {
			w = Integer.parseInt(data[7]);
		} catch (NumberFormatException e1) {
			System.out.println("Bad w <" + data[7] + ">");
		}

		image = data[8];

		Room room = new Room(id, name, shortDesc, longDesc, image);

		// Add the room to the ArrayList rooms
		rooms.put(id, room);

		// Update roomLinks for processing
		Integer[] adjacentRooms = { n, e, s, w };
		roomLinks.put(id, adjacentRooms);
	}

	/**
	 * This method takes all of the room links and sets them once all of the rooms
	 * are created
	 */
	public void processRoomLinks() {
		for (Integer id : roomLinks.keySet()) {
			int n = roomLinks.get(id)[0];
			int e = roomLinks.get(id)[1];
			int s = roomLinks.get(id)[2];
			int w = roomLinks.get(id)[3];

			// Only rooms links with values greater than 0 are valid
			// Make sure that the room that is being linked to exists

			if ((n > 0) && rooms.containsKey(n)) { // check for valid room Link
				rooms.get(id).setAdjacentRoom("north", rooms.get(n));
			}
			if ((e > 0) && rooms.containsKey(e)) { // check for valid room Link
				rooms.get(id).setAdjacentRoom("east", rooms.get(e));
			}
			if ((s > 0) && rooms.containsKey(s)) { // check for valid room Link
				rooms.get(id).setAdjacentRoom("south", rooms.get(s));
			}
			if ((w > 0) && rooms.containsKey(w)) { // check for valid room Link
				rooms.get(id).setAdjacentRoom("west", rooms.get(w));
			}
		}
	}

	/**
	 * This method sets the treasures in each room
	 */
	public void processTreasures() {
		treasures.setTreasuresToRooms(rooms.size(), true);

		for (int id : rooms.keySet()) {
			Treasure treasure = treasures.getTreasureForRoom(id);
			rooms.get(id).setTreasure(treasure);
		}
	}

	/**
	 * Method returns the room object at the id.
	 * 
	 * @param id : id for the room desired
	 * @return : Room object at id. Note that this could be null and need to account
	 *         for it
	 */
	public Room getRoomAtID(int id) {
		if (rooms.containsKey(id)) {
			return rooms.get(id);
		}
		return null;
	}
}

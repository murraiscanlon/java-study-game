package game;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
/**
 * Contains objects the player collects for points
 * Interacts with Room Class
 * @author Team 30
 **/

public class Treasures {

	/**
	 * Instance Variables
	 */
	private  ArrayList<Treasure> treasures = new ArrayList<Treasure>(); 
	private HashMap<Integer, Treasure> roomToTreasures = new HashMap<Integer, Treasure>();

	/**
	 * Constructor
	 */
	public Treasures() {
		assignTreasureTypes();
	}

	/**
	 * Assigns Treasure type, value and room location to ArrayList
	 * @return ArrayList of Treasures
	 */
	private ArrayList<Treasure> assignTreasureTypes() {

	    treasures.add(new Treasure("Bitcoin", 5, (new ImageIcon("images/bitcoinS.png"))));
        treasures.add(new Treasure("Jewel Editor", 5,(new ImageIcon("images/jewelS.png"))));
        treasures.add(new Treasure("Java Sword", 5, (new ImageIcon("images/swordS.png"))));
        treasures.add(new Treasure ("Magic IDE", 5, (new ImageIcon("images/magicIDES.png"))));
        treasures.add(new Treasure ("Diamond Debugger", 5,(new ImageIcon("images/diamondS.png"))));
        treasures.add(new Treasure ("Key Compiler", 5,(new ImageIcon("images/keyCompilerS.png"))));
		
		return treasures;
	}
	
	/**
	 * Assigns treasures to rooms randomly
	 * @param numberRooms - total number of rooms in the game
	 * @param random - set to true to randomize treasures to room, set to false for testing
	 */
	public void setTreasuresToRooms(int numberRooms, boolean random) {
		
		int[] roomList = new int[numberRooms];
		if(random) {
			roomList = RandomOrderGenerator.getRandomOrder(numberRooms);
		} else {
			for(int index = 0; index < numberRooms; index++) {
				roomList[index] = index + 1;
			}
		}
		for (int index = 0; index < treasures.size(); index++ ) {
			if (index < numberRooms) {
				roomToTreasures.put(roomList[index], treasures.get(index));
				treasures.get(index).setRoomId(roomList[index]);
			}
		}
	}
	
	/**
	 * Gets the treasure for a room
	 * @param id - Room ID
	 * @return - The treasure in the room, could be null to indicate no treasure
	 */
	public Treasure getTreasureForRoom(int id) {
		if(roomToTreasures.containsKey(id)) {
			return roomToTreasures.get(id);
		}
		return null;
	}
}

package game;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import javax.swing.ImageIcon;
/**
 * Contains objects the player collects for points
 * Interacts with Room Class
 * @author Team 30
 **/

public class Treasures {

	/**
	 * ArrayList of treasures
	 */
	private  ArrayList<Treasure> treasures = new ArrayList<Treasure>(); 
	HashMap<Integer, Treasure> roomToTreasures = new HashMap<Integer, Treasure>();

	/**
	 * Constructor
	 */
	public Treasures() {
		assignTreasureTypes();
	}

	/**
	 * Assigns Treasure type, value and room location to ArrayList
	 * Additional Treasures will be added later
	 * @param
	 */
	public ArrayList<Treasure> assignTreasureTypes() {

	    treasures.add(new Treasure("Bitcoin", 2, "", (new ImageIcon("bitcoinS.png"))));
        treasures.add(new Treasure("Jewel Editor", 2, "",(new ImageIcon("jewelS.png"))));
        treasures.add(new Treasure("Java Sword", 2, "", (new ImageIcon("swordS.png"))));
        treasures.add(new Treasure ("Magic IDE", 2, "", (new ImageIcon("magicIDES.png"))));
        treasures.add(new Treasure ("Diamond Debugger", 2, "",(new ImageIcon("diamondS.png"))));
        treasures.add(new Treasure ("Key Compiler", 2, "",(new ImageIcon("keyCompilerS.png"))));
		
		return treasures;
	}

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
	
	public Treasure getTreasureForRoom(int id) {
		if(roomToTreasures.containsKey(id)) {
			return roomToTreasures.get(id);
		}
		return null;
	}
	
	/**
	 * HashMap to assign values to treasures
	 * If we want to use a HashMap instead of ArrayList
	 * @param 
	 */ 
//	public void assignTreasures(){
//
//		//Local Variables
//		String bitcoin = "bitcoin";
//		String jewel = "jewel";
//		String sword = "sword";
//		String magicIDE = "magicIDE";
//		HashMap<String, Integer> treasurePoints = new HashMap<String, Integer>();
//
//		//Instantiate treasure objects
//		Treasure t = new Treasure(bitcoin, 2, "");
//		Treasure t1 = new Treasure(jewel, 2, "");     
//		Treasure t2 = new Treasure(sword, 2, "");
//		Treasure t3 = new Treasure(magicIDE, 2, "");
//
//		//Assigns Treasure type as Key - Integer is point Value
//		treasurePoints.put(t.getTreasureType(), t.getPoints());
//		treasurePoints.put(t1.getTreasureType(), t1.getPoints());
//		treasurePoints.put(t2.getTreasureType(), t2.getPoints());
//		treasurePoints.put(t3.getTreasureType(), t3.getPoints());         
//	}

	/**
	 * Checks if Treasure is in Room
	 * @param
	 */
	public Treasure isTreasureInRoom(int id) {

		if (id < treasures.size()) {
			return treasures.get(id);
		}
		return null;
	}

	/**
	 * Adds treasure to Inventory List when player correctly answers question
	 * @param isCorrect
	 * @param inventoryList
	 */ 
//	public void addTreasure(boolean isCorrect, //checks if answer is correct
//			ArrayList<Treasure> inventoryList) { 
//		//Local Variables
//		Treasure treasure = null;//will be replaced with object in room
//
//		if (isCorrect == true) {
//			inventoryList.add(treasure);
//		}
//	}
	//For local testing purposes only
	public static void main (String[] args) {
		Treasures t = new Treasures();
		System.out.println(t.assignTreasureTypes());
	}
}

package game;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
/**
 * Contains objects the player collects for points
 * Interacts with Room Class
 * @author Team 30
 **/

public class Treasures {

	/**
	 * ArrayList of treasures
	 */
	private  ArrayList<Treasure> treasureValues = new ArrayList<Treasure>(); 

	/**
	 * Constructor
	 */
	public Treasures() {
	}

	/**
	 * Assigns Treasure type, value and room location to ArrayList
	 * Additional Treasures will be added later
	 * @param
	 */
	public ArrayList<Treasure> assignTreasureTypes() {

		treasureValues.add(new Treasure("Bitcoin", 2, "Dungeon"));
		treasureValues.add(new Treasure("Jewel", 2, "Kitchen"));
		treasureValues.add(new Treasure("Sword", 2, "Library"));
		treasureValues.add(new Treasure ("MagicIDE", 2, "Tower"));

		return treasureValues;
	}

	/**
	 * HashMap to assign values to treasures
	 * If we want to use a HashMap instead of ArrayList
	 * @param 
	 */ 
	public void assignTreasures(){

		//Local Variables
		String bitcoin = "bitcoin";
		String jewel = "jewel";
		String sword = "sword";
		String magicIDE = "magicIDE";
		HashMap<String, Integer> treasurePoints = new HashMap<String, Integer>();

		//Instantiate treasure objects
		Treasure t = new Treasure(bitcoin, 2, "");
		Treasure t1 = new Treasure(jewel, 2, "");     
		Treasure t2 = new Treasure(sword, 2, "");
		Treasure t3 = new Treasure(magicIDE, 2, "");

		//Assigns Treasure type as Key - Integer is point Value
		treasurePoints.put(t.getTreasureType(), t.getPoints());
		treasurePoints.put(t1.getTreasureType(), t1.getPoints());
		treasurePoints.put(t2.getTreasureType(), t2.getPoints());
		treasurePoints.put(t3.getTreasureType(), t3.getPoints());         
	}

	/**
	 * Checks if Treasure is in Room
	 * @param
	 */
	public Treasure isTreasureInRoom(int id) {

		if (id < treasureValues.size()) {
			return treasureValues.get(id);
		}
		return null;
	}

	/**
	 * Adds treasure to Inventory List when player correctly answers question
	 * @param isCorrect
	 * @param inventoryList
	 */ 
	public void addTreasure(boolean isCorrect, //checks if answer is correct
			ArrayList<Treasure> inventoryList) { 
		//Local Variables
		Treasure treasure = null;//will be replaced with object in room

		if (isCorrect == true) {
			inventoryList.add(treasure);
		}
	}
	//For local testing purposes only
	public static void main (String[] args) {
		Treasures t = new Treasures();
		System.out.println(t.assignTreasureTypes());
	}
}

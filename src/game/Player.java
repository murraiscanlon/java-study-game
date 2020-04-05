package game;

import java.util.ArrayList;

/**
 * The Player class contains the name of the player and list of the items collected.
 * 
 *  
 * @author Team 30
 *
 */

	public class Player {
		
	//Member variables	
	private String name;
	private ArrayList<String> inventoryOfTreasures;
	private int lifePoints;
	//private ArrayList<Treasure> inventoryList = new ArrayList<Treasure>();//connect this to addTreasures() in Treasures class??
		
	
	Treasures treasure = new Treasures();
	
	//Constructor
	Player(String name){
		this.name = name;
		this.inventoryOfTreasures = new ArrayList<String>();
		this.lifePoints = 20;
		//this.inventoryList = null;//if using this list
	}
	

	//getters and setters
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public ArrayList<String> getInventoryOfTreasures() {
		return inventoryOfTreasures;
	}



	public void setInventoryOfTreasures(ArrayList<String> inventoryOfTreasures) {
		this.inventoryOfTreasures = inventoryOfTreasures;
	}



	public int getLifePoints() {
		return lifePoints;
	}



	public void setLifePoints(int lifePoints) {
		this.lifePoints = lifePoints;
	}
	
	
	/**
	 * THIS NEEDS TO BE MOVED TO GAME MANAGER
	 * 
	 * After the user enters a room, they can look and receive information
	 * about whether there is treasure in the room. For the first level of testing, we just want 
	 * the player to be able to collect the treasure in the current room and store it
	 * in the inventory list.
	 * 
	 */
	public void lookInRoom() {
		
		//call isTreasureInRoom(room iD)
		//if true, call askQuestion()
		//else return to game play/choices
		
		
		
		//Level 1 - testing
		if (treasure.isTreasureInRoom(1) != null) {//fix this parameter
			
			String result = "bitcoin"; //This needs to come from the treasure type in the currentRoom. Not sure how to get at it.

			switch (result) {
			case "bitcoin" :
				this.inventoryOfTreasures.add(result);
				System.out.println("Congratulations, you have earned some BitCoin!"
						+ "Don't spend it all in one place lols!");
				break;
			case "jewel":
				this.inventoryOfTreasures.add(result);
				System.out.println("Congratulations, you have earned some a jewel!"
						+ "(not the vape kind)");
				break;
			case "sword":
				this.inventoryOfTreasures.add(result);
				System.out.println("Congratulations, you have earned sword!"
						+ "swordfish fish really. The stuffed kind, we got a good bargain.");
				break;
			case "magicIDE":
				this.inventoryOfTreasures.add(result);
				System.out.println("Congratulations, you have earned a MAGIC IDE!"
						+ "(not redeemable during 591 finals)");
				break;
			default://this may or may not be a part of the method/game. Change default as needed
				if (lifePoints > 0) {

					this.setLifePoints(-1);

					int x = -1;
					int currentLifePoints = this.getLifePoints();
					int updatedLifePoints = currentLifePoints - x;
					this.setLifePoints(updatedLifePoints);

					System.out.println("Sorry, wrong answer. Don't worry, "
							+ "you'll get the next one! (hopefully)");
					System.out.println("Current Life Points: " +
										this.getLifePoints());
				} else {
					//end game? or give extra choices?
					System.out.println("Sorry, game over!");
				}
				break;
			}
			
				
				
		} else {
			//give the user options like go to the next room, etc.
			//maybe call Room(s) or gameManager
		}
	
	}
	
	
}

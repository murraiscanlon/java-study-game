package game;

import java.util.ArrayList;

/**
 * The Player class contains the name of the player, the lifePoints, and 
 * a list of the items collected.
 * 
 * It interacts with the treasure(s) class and question(s) class I think.
 *  
 * @author Team 30
 *
 */

	public class Player {
	private String name;
	private ArrayList<String> inventoryOfTreasures;
	private int lifePoints;
	//Room room = new Room();
	Treasures treasure = new Treasures();
	
	//Constructor
	Player(String name){
		this.name = name;
		this.inventoryOfTreasures = new ArrayList<String>();
		this.lifePoints = 20;
		
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
	 * After the user enters a room, they can look and receive information
	 * about whether there is treasure in the room.
	 */
	public void look() {
		
		//call isTreasureInRoom(room iD)
		//if true, call askQuestion()
		//else return to game play/choices
		
		//Level 1 - testing
		if (treasure.isTreasureInRoom(1)) {//fix this parameter
<<<<<<< HEAD
			String result = treasure.addTreasure("");
=======
			String result = treasure.addTreasure("");//fix this parameter
>>>>>>> 462f6b75a00f4eeea46094e6c1638669ad571006
			
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
			default:
				if (lifePoints > 0) {
<<<<<<< HEAD
					this.setLifePoints(-1);
=======
					int x = -1;
					int currentLifePoints = this.getLifePoints();
					int updatedLifePoints = currentLifePoints - x;
					this.setLifePoints(updatedLifePoints);
					
>>>>>>> 462f6b75a00f4eeea46094e6c1638669ad571006
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
	
	/**
	 * If there is treasure in a room when the player "looks", they will 
	 * be asked a question. Correct/incorrect answers result in add to inventory 
	 * or decreased lifepoints.
	 */
	public void askQuestion() {
		//parameter might be Question question
		//if question answered correctly . . .
		//call addTreasure() from Treasure(s) 
		//if question incorrect . . .
		//decrease lifepoints and return to game play/choices
	}
	
	public static void main(String[] args) {
		

	}

}

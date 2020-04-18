package game;

import javax.swing.ImageIcon;

/**
 * Treasure contains objects for player to collect Treasure objects have a
 * points value and a room location
 * 
 * @author Team 30
 */

public class Treasure {

	/**
	 * Instance variables for Treasure Class
	 */
	private String treasureType;
	private int points;
	private int roomId = -1;
	private ImageIcon treasurePic;

	/**
	 * Constructor - creates a treasure
	 * 
	 * @param treasureType - type of treasure
	 * @param points       - points each treasure is worth
	 * @param treasurePic
	 */
	public Treasure(String treasureType, int points, ImageIcon treasurePic) {
		this.treasureType = treasureType;
		this.points = points;
		this.treasurePic = treasurePic;
	}

	/**
	 * toString method & Getters + Setters
	 * 
	 * @return String of the treasure
	 */
	@Override
	public String toString() {
		return "Treasure [treasureType=" + treasureType + ", points=" + points + "]";
	}

	public String getTreasureType() {
		return treasureType;
	}

	public void setTreasureType(String treasureType) {
		this.treasureType = treasureType;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public ImageIcon getTreasurePic() {
		return treasurePic;
	}

	public void setTreasurePic(ImageIcon treasurePic) {
		this.treasurePic = treasurePic;
	}

}

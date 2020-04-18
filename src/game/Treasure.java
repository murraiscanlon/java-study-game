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
	private String roomName;
	private int roomId = -1;
	private ImageIcon treasurePic;

	/**
	 * Constructor - creates a treasure
	 * 
	 * @param treasureType - type of treasure
	 * @param points       - points each treasure is worth
	 * @param roomName     - room that the treasure is assigned to
	 * @param roomId       - id of room that treasure is assigned to
	 * @param treasurePic
	 */
	public Treasure(String treasureType, int points, String roomName, ImageIcon treasurePic) {
		this.treasureType = treasureType;
		this.points = points;
		this.roomName = roomName;
		this.treasurePic = treasurePic;
	}

	/**
	 * toString method & Getters + Setters
	 * 
	 * @return String of the treasure
	 */
	@Override
	public String toString() {
		return "Treasure [treasureType=" + treasureType + ", points=" + points + ", roomName=" + roomName + "]";
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

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
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

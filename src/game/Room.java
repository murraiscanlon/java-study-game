package game;

import java.util.HashMap;

import javax.swing.ImageIcon;

/**
 * MCIT 591 Final Project
 * 
 * @author Team 30
 * 
 *         This class models a room in the Adventure game. id: Unique ID for
 *         each room. name: Name of the room. shortDesc: Short description of
 *         the room longDesc: Long (detailed) description of the room image:
 *         Background image for each room which will display in GUI visited:
 *         Default false until player enters the room adjacentRooms: maps
 *         directions (north, east, south, west) to the unique ID of the room in
 *         that direction Not all rooms will have adjacent rooms in each
 *         direction treasure: The treasure in the room. Could be null
 */
public class Room {
	/**
	 * Instance Variables
	 */
	private int id;
	private String name;
	private String shortDesc;
	private String longDesc;
	private String image;
	private boolean visited = false;
	private HashMap<String, Room> adjacentRooms = new HashMap<String, Room>();
	private Treasure treasure;

	/**
	 * Constructor
	 * 
	 * @param id        : Unique ID for each room
	 * @param name      : Name of the room
	 * @param shortDesc : Short description of the room
	 * @param longDesc  : Long (detailed) description of the room
	 * @param image     : image file name
	 */
	public Room(int id, String name, String shortDesc, String longDesc, String image) {
		this.id = id;
		this.name = name;
		this.shortDesc = shortDesc;
		this.longDesc = longDesc;
		this.image = image;
	}

	/**
	 * Room name getter
	 * 
	 * @return name of the room
	 */
	public String getName() {
		return name;
	}

	/**
	 * Room short description getter
	 * 
	 * @return short description of the room
	 */
	public String getShortDesc() {
		return shortDesc;
	}

	/**
	 * Room long (detailed) description getter
	 * 
	 * @return long (detailed) description of the room
	 */
	public String getLongDesc() {
		return longDesc;
	}

	/**
	 * Room ID getter
	 * 
	 * @return room id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Room image getter
	 * 
	 * @return image string
	 */
	public String getImage() {
		return image;
	}

	/**
	 * Method to return if room was visited
	 * 
	 * @return if room was visited before
	 */
	public boolean wasVisited() {
		return visited;
	}

	/**
	 * Method to set that the room was visited
	 */
	public void setVisited() {
		this.visited = true;
	}

	/**
	 * Method to set the treasure in the room
	 * 
	 * @param treasure : treasure in the room
	 */
	public void setTreasure(Treasure treasure) {
		this.treasure = treasure;
	}

	/**
	 * Method to get the treasure in the room
	 * 
	 * @return : treasure, note could be null
	 */
	public Treasure getTreasure() {
		return treasure;
	}

	/**
	 * Method to get the treasure type
	 * 
	 * @return : treasure type
	 */
	public String getTreasureType() {
		String treasureType = "";
		if (treasure != null) {
			treasureType = treasure.getTreasureType();
		}
		return treasureType;
	}

	/**
	 * Method to get treasure picture
	 * 
	 * @return : treasurePic
	 */
	public ImageIcon getTreasurePic() {
		ImageIcon treasurePic = null;
		if (treasure != null) {
			treasurePic = treasure.getTreasurePic();
		}
		return treasurePic;
	}

	/**
	 * Method to set up the adjacent rooms. Note that all rooms must be created
	 * before you can set up the room connections
	 * 
	 * @param direction : direction out of the room
	 * @param room      : room in the direction specified
	 */
	public void setAdjacentRoom(String direction, Room room) {
		adjacentRooms.put(direction, room);
	}

	/**
	 * Method to return the room in the direction specified Note that the room can
	 * be null and the caller must handle that case.
	 * 
	 * @param direction : direction from the room
	 * @return : Room object in that direction, can be null
	 */
	public Room getRoomAtDirection(String direction) {
		Room room = null;

		if (adjacentRooms.containsKey(direction) && adjacentRooms.get(direction) != null) {
			room = adjacentRooms.get(direction);
		}
		return room;
	}

}

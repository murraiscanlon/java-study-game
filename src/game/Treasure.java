package game;
/**
 * Treasure contains objects for player to collect
 * 
 * Treasure objects have a points value and a room location
 * 
 * @author Team 30
 */

public class Treasure {
    
   
    /**
     *Instance variables for Treasure Class
     */
    private String treasureType;
    private int points;
    private String roomName;
    
    /**
     * Constructor       
     * @param treasureType
     * @param points
     * @param roomName
     */
    public Treasure(String treasureType, int points, String roomName) {
        this.treasureType = treasureType;
        this.points = points;
        this.roomName = roomName;
    }
    
    /**
     * toString method & Getters + Setters
     * @return
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
    
    
    
}

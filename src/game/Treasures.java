package game;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Treasures {
    
    /**
     * Contains objects the player collects for points
     * Interacts with Room Class
     * @author Team 30
     **/
    
    /*
     * Instance variables
     * Remove "static" after testing
     */
    private static ArrayList<Treasure> treasureValues = new ArrayList<Treasure>(); 
    
    /*
     * Constructor
     */
    public Treasures(ArrayList<Treasure> treasures) {
        this.treasureValues = treasures;
        
    }
    
    /**
     * Assigns Treasure type, value and room location to ArrayList
     * Additional Treasures can be added later
     * @param
     */
    public ArrayList<Treasure> assignTreasureTypes() {
        String bitcoin = "bitcoin";
        String dungeon = "Dungeon";
        String jewel = "jewel";
        String kitchen = "Kitchen";
        String sword = "sword"; 
        String library = "Library";
        String magicIDE = "magicIDE";
        String tower = "Tower";
        
        treasureValues.add(new Treasure(bitcoin, 2, dungeon));
        treasureValues.add(new Treasure(jewel, 2, kitchen));
        treasureValues.add(new Treasure(sword, 2, library));
        treasureValues.add(new Treasure (magicIDE, 2, tower));
        
        return treasureValues;
    }
    
    /**
     * HashMap to assign values to treasures
     * If we want to use a HashMap instead of ArrayList
     * @param 
     */ 
    public void assignTreasures(){
        
        /***Local Variables***/
        String bitcoin = "bitcoin";
        String jewel = "jewel";
        String sword = "sword";
        String magicIDE = "magicIDE";
        HashMap<String, Integer> treasurePoints = new HashMap<String, Integer>();
        
        /**Instantiate treasure objects***/
        Treasure t = new Treasure(bitcoin, 2, "");
        Treasure t1 = new Treasure(jewel, 2, "");     
        Treasure t2 = new Treasure(sword, 2, "");
        Treasure t3 = new Treasure(magicIDE, 2, "");
                   
        /***Assigns Treasure type as Key - Integer is point Value***/
        treasurePoints.put(t.getTreasureType(), t.getPoints());
        treasurePoints.put(t1.getTreasureType(), t1.getPoints());
        treasurePoints.put(t2.getTreasureType(), t2.getPoints());
        treasurePoints.put(t3.getTreasureType(), t3.getPoints());
               
    }
   
    /**
     * Checks if Treasure is in Room*
     * @param
     */
    public boolean isTreasureInRoom(Treasure t, Treasure id) {//replace w/Room id
        if (t.getRoomName().equals(id.getRoomName())){
            
        }
        return true;
             
    }
    
    /**
     * Adds treasure to Inventory List when player answers question
     */ 
       
    public void addTreasure(boolean isCorrect, //checks if answer is correct
                              ArrayList<Treasure> inventoryList) { 
        /***Local Variables***/
        Treasure treasure = null;//will be replaced with object in room
        
        if (isCorrect == true) {
            inventoryList.add(treasure);
        }
    }
    
    public static void main (String[] args) {
       Treasures t = new Treasures(treasureValues);
       System.out.println(t.assignTreasureTypes());
       
       
    }
    
}

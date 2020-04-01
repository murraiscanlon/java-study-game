package game;
/**
 * Character class creates characters with whom the Player interacts
 * 
 * @author Team 30
 *
 */
public class Character {
    /**
     * Instance variables to generate Character
     */
    private String name;
    private String location;
    private String interaction;
    
    /**
     * Constructor
     * Contains character name, their location (e.g., Room),
     * and their interaction w/Player (e.g., question, hint, etc.) 
     * @param name
     * @param location
     * @param interaction
     */
    public Character(String name, String location, String interaction) {
        this.name = name;
        this.location = location;
        this.interaction = interaction;
        
    }
   
    /**
     * toString() method to obtain Character info
     * Getters & Setters
     * @return
     */
    @Override
    public String toString() {
        return "Character [name=" + name + ", location=" + location + ", interaction=" + interaction + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getInteraction() {
        return interaction;
    }

    public void setInteraction(String interaction) {
        this.interaction = interaction;
    }
    

}

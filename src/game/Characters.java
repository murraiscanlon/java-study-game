package game;

import java.util.ArrayList;

/**
 * Characters establishes the game cast and player interactions
 * Interacts with Questions and Rooms
 * 
 * @author Team 30
 *
 */
public class Characters {
    /**
     * Instance variable
     */
    private ArrayList<Character> characters = new ArrayList<Character>();
    
   /**
    * Constructor
    * @param c
    */
    public Characters(ArrayList<Character> c) {
        characters = c;
     
    }
    /**
     * Method to add one Character
     * @param name
     * @param location
     * @param interaction
     */
    public void addCharacter(String name, String location, String interaction) {
        Character newChar = new Character(name, location, interaction);
        characters.add(newChar);
        }
    /**
     * Method to create list of Characters 
     * Wizard Arvind, Fairy GodTA & Java Monsters
     * @return characters
     */
    public ArrayList<Character> generateCharacterList(){
        //Interactions will be replaced later with variables/method from other classes
        addCharacter("Wizard Arvind", "Finish", "Thank you for freeing me!");
        addCharacter("Fairy GodTA", "Every Room", "Generate Hint");
        addCharacter("Null Pointer Ninja", "Dungeon", "Question");
        addCharacter("HashMap Assassin", "Kitchen", "Question");
        addCharacter("Infinite Loopy", "Tower", "Question");
        addCharacter("Attack Array", "Library", "Question");
        
        return characters;
    }
    
    
}


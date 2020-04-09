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
    private Question question;
    private Question hint;
    private Character wizard; 
    private Character fairy; 
    /**
    * Constructor
    * 
    */
    public Characters() {
            
    }
    /**
     * Method to add one Character
     * @param name
     * @param location
     * @param interaction
     */
    public void addCharacter(String name, String interaction) {
        Character newChar = new Character(name, interaction);
        characters.add(newChar);
        }
    /**
     * Method to create list of Characters 
     * Java Monsters
     * @return characters
     */
        
    public ArrayList<Character> generateMonsters(){
                
        String question1 = question.toString();
        
        addCharacter("Null Pointer Dragon", question1 );
        addCharacter("HashMap Assassin", question1 );
        addCharacter("Infinite Loop Ghost", question1);
        addCharacter("Zombie Array", question1);
        addCharacter("Github Gremlin", question1);
        addCharacter("Dead Code Mummy", question1);
        addCharacter("Headless Exception", question1);
        addCharacter("IndexOutOfBounds Ogre", question1);
                
        return characters;
    }
    /**
     * Method to create Wizard Arvind & Fairy GodTA
     * @return
     */
    public String[] createWizardAndFairy() {
        String [] addChars = new String [2];
        String hint1 = hint.getHint();
        wizard = new Character("Wizard Arvind", "Thank you for saving me!");
        fairy = new Character("Fairy GodTA Jami", hint1);
        
        addChars[0] = wizard.toString();
        addChars[1] = fairy.toString();        
        
        return addChars;
    }
    
}


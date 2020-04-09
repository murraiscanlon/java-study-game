package game;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

class CharactersTest {
    
    Character c = new Character("Runtime Dragon", "Hello");
    Character c2 = new Character("Hashmap Assasin", "Goodbye");
    ArrayList<Character> c1 = new ArrayList<Character>();
    
    @Test
    void testGenerateMonsters() {
        c1.add(c);
        assertEquals(c1.toString(), "[Character [name=Runtime Dragon, interaction=Hello]]");
    }

    @Test
    void testCreateWizardAndFairy() {
       String monster = c.getName();
       String monster2 = c2.getName();
       String[] test = new String[2];
       test[0] = monster;
       test[1] = monster2;
              
       assertEquals(Arrays.toString(test), "[Runtime Dragon, Hashmap Assasin]");
    }

}

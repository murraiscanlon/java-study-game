package game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CharacterTest {
    Character c = new Character("Runtime Dragon", "Hello");
    
    @Test
    void testToString() {
        assertEquals(c.toString(), "Character [name=Runtime Dragon, interaction=Hello]");
    }

    @Test
    void testGetName() {
        assertEquals(c.getName(), "Runtime Dragon");
    }

    @Test
    void testSetName() {
        Character c1 = new Character("Runtime Dragon", "Hello");
        c1.setName("Runtime Dragon");
        assertEquals(c1.getName(), "Runtime Dragon");
    }

    @Test
    void testGetInteraction() {
        assertEquals(c.getInteraction(), "Hello");
    }

    @Test
    void testSetInteraction() {
        Character c2 = new Character("Runtime Dragon", "Hello");
        c2.setInteraction("Hello");
        assertEquals(c2.getInteraction(), "Hello");
    }

}

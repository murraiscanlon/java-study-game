package game;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.ImageIcon;

import org.junit.jupiter.api.Test;
/**
 * Test for Treasure class
 * @author Team 30
 *
 */
class TreasureTest {
	
    ImageIcon diamond;
	Treasure t = new Treasure("Diamond", 5, diamond);

	// Test the toString method
	@Test
	void testToString() {
		assertEquals(t.toString(), "Treasure [treasureType=Diamond, points=5]");
	}

	// Test the TreasureType getter
	@Test
	void testGetTreasureType() {
		assertEquals(t.getTreasureType(), "Diamond");
	}

	// Test the TreasureType setter
	@Test
	void testSetTreasureType() {
		Treasure t1 = new Treasure("Diamond", 5, diamond);
		t1.setTreasureType("Bitcoin");
		assertEquals(t1.getTreasureType(), "Bitcoin");
	}

	// Test the Treasure Points getter
	@Test
	void testGetPoints() {
		assertEquals(t.getPoints(), 5);
	}

	// Test the Treasure Points setter
	@Test
	void testSetPoints() {
		Treasure t1 = new Treasure("Diamond", 5, diamond);
		t1.setPoints(15);
		assertEquals(t1.getPoints(), 15);
	}

	// Test the Treasure Room Id getter
	@Test
	void testGetRoomId() {
		assertEquals(t.getRoomId(), -1);
	}
	
	// Test the Treasure Room Id setter
	@Test
	void testSetRoomId() {
		Treasure t1 = new Treasure("Diamond", 5, diamond);
		t1.setRoomId(5);		
		assertEquals(t1.getRoomId(), 5);
	}

}

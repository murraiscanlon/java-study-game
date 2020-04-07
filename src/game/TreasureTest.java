package game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TreasureTest {
	
	Treasure t = new Treasure("Diamond", 5, "Entry");

	@Test
	void testToString() {
		assertEquals(t.toString(), "Treasure [treasureType=Diamond, points=5, roomName=Entry]");
	}

	@Test
	void testGetTreasureType() {
		assertEquals(t.getTreasureType(), "Diamond");
	}

	@Test
	void testSetTreasureType() {
		Treasure t1 = new Treasure("Diamond", 5, "Entry");
		t1.setTreasureType("Bitcoin");
		assertEquals(t1.getTreasureType(), "Bitcoin");
	}

	@Test
	void testGetPoints() {
		assertEquals(t.getPoints(), 5);
	}

	@Test
	void testSetPoints() {
		Treasure t1 = new Treasure("Diamond", 5, "Entry");
		t1.setPoints(15);
		assertEquals(t1.getPoints(), 15);
	}

	@Test
	void testGetRoomName() {
		assertEquals(t.getRoomName(), "Entry");
	}

	@Test
	void testSetRoomName() {
		Treasure t1 = new Treasure("Diamond", 5, "Entry");
		t1.setRoomName("Kitchen");
		assertEquals(t1.getRoomName(), "Kitchen");
	}

}
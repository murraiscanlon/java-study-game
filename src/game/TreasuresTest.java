package game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TreasuresTest {
	
	/**
	 * Test as part of other tests
	 */
//	@Test
//	void testAssignTreasureTypes() {
//	}

	/**
	 * Cannot test, it does not return a value or set instance var
	 */
//	@Test
//	void testAssignTreasures() {
//		fail("Not yet implemented");
//	}

	@Test
	void testIsTreasureInRoom_1() {
		Treasures treasures = new Treasures();
		treasures.assignTreasureTypes();
		int roomid = 1;
		Treasure t = treasures.isTreasureInRoom(roomid-1);
		assertEquals(t.getTreasureType(), "Bitcoin");
	}

	@Test
	void testIsTreasureInRoom_2() {
		Treasures treasures = new Treasures();
		treasures.assignTreasureTypes();
		int roomid = 2;
		Treasure t = treasures.isTreasureInRoom(roomid-1);
		assertEquals(t.getTreasureType(), "Jewel");
	}
	
	@Test
	void testIsTreasureInRoom_3() {
		Treasures treasures = new Treasures();
		treasures.assignTreasureTypes();
		int roomid = 3;
		Treasure t = treasures.isTreasureInRoom(roomid-1);
		assertEquals(t.getTreasureType(), "Sword");
	}
	
	@Test
	void testIsTreasureInRoom_4() {
		Treasures treasures = new Treasures();
		treasures.assignTreasureTypes();
		int roomid = 4;
		Treasure t = treasures.isTreasureInRoom(roomid-1);
		assertEquals(t.getTreasureType(), "MagicIDE");
	}
	
	@Test
	void testIsTreasureInRoom_null() {
		Treasures treasures = new Treasures();
		treasures.assignTreasureTypes();
		int roomid = 5;
		Treasure t = treasures.isTreasureInRoom(roomid-1);
		assertEquals(t, null);
	}
	
//	@Test
//	void testAddTreasure() {
//		fail("Not yet implemented");
//	}


}

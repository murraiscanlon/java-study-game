package game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/**
 * Test for Rooms
 * Make sure that rooms and treasures are assigned properly. 
 * 
 * @author Team 30
 *
 */
class RoomsTest {
	
	Rooms rooms = new Rooms("roomsTest.csv");
	
	@Test 
	void testProcessFileLine01() {
		rooms.processFileLine("5,Room5,Room 5 Short,Room 5 Long,1,2,3,0,X");
		assertEquals(rooms.getRoomAtID(5).getName(), "Room5");
		assertEquals(rooms.getRoomAtID(5).getShortDesc(), "Room 5 Short");
		assertEquals(rooms.getRoomAtID(5).getLongDesc(), "Room 5 Long");
		rooms.processRoomLinks();
		assertEquals(rooms.getRoomAtID(5).getRoomAtDirection("north").getId(), 1);
		assertEquals(rooms.getRoomAtID(5).getRoomAtDirection("east").getId(), 2);
		assertEquals(rooms.getRoomAtID(5).getRoomAtDirection("south").getId(), 3);
		assertEquals(rooms.getRoomAtID(5).getRoomAtDirection("west"), null);
	}
	
	/* The tests below check the methods that assign treasures to rooms.
	 * Make sure that we don't try to access an array element in treasures or rooms that is out of bounds
	 * The tests below should not throw an exception. Verify output with print statements. 
	 */
	
	// Case where number of rooms is less than number of treasures (6) with random
	// Use print out to verify results.  
	@Test
	void testProcessTreasures_1() {
		Rooms roomTest = new Rooms("RoomsBlank.csv");
		roomTest.processFileLine("1,Room1,Room 1 Short,Room 1 Long,1,2,0,0,X");
		roomTest.processFileLine("2,Room2,Room 2 Short,Room 2 Long,1,2,0,0,X");
		roomTest.processRoomLinks();	
		roomTest.processTreasures();
		System.out.println("\nMore Treasures Than Rooms");
		for(int id = 1; id <= 2; id++) {
			System.out.println("Room" + id + ":" + roomTest.getRoomAtID(id).getTreasureType());
		}
		System.out.println("*****");
	}
	
	// Case where number of rooms is same as number of treasures (6) with random
	// Use print out to verify results.  Make sure treasures are random.
	@Test
	void testProcessTreasures_2() {
		Rooms roomTest = new Rooms("RoomsBlank.csv");
		roomTest.processFileLine("1,Room1,Room 1 Short,Room 1 Long,1,2,0,0,X");
		roomTest.processFileLine("2,Room2,Room 2 Short,Room 2 Long,1,2,0,0,X");
		roomTest.processFileLine("3,Room3,Room 3 Short,Room 3 Long,1,2,0,0,X");
		roomTest.processFileLine("4,Room4,Room 4 Short,Room 4 Long,1,2,0,0,X");
		roomTest.processFileLine("5,Room5,Room 5 Short,Room 5 Long,1,2,0,0,X");
		roomTest.processFileLine("6,Room6,Room 6 Short,Room 6 Long,1,2,0,0,X");
		roomTest.processRoomLinks();	
		roomTest.processTreasures();
		System.out.println("\nSame number of Treaures and Rooms");
		for(int id = 1; id <= 6; id++) {
			System.out.println("Room" + id + ":" + roomTest.getRoomAtID(id).getTreasureType());
		}
	}
	
	// Case where number of rooms is greater than number of treasures (6) with random
	// Use printout to verify result, make sure treasures are random.  Some rooms will have blank treasures.  
	// Note that this is the case for game play
	@Test
	void testProcessTreasures_3() {
		Rooms roomTest = new Rooms("RoomsBlank.csv");
		roomTest.processFileLine("1,Room1,Room 1 Short,Room 1 Long,1,2,0,0,X");
		roomTest.processFileLine("2,Room2,Room 2 Short,Room 2 Long,1,2,0,0,X");
		roomTest.processFileLine("3,Room3,Room 3 Short,Room 3 Long,1,2,0,0,X");
		roomTest.processFileLine("4,Room4,Room 4 Short,Room 4 Long,1,2,0,0,X");
		roomTest.processFileLine("5,Room5,Room 5 Short,Room 5 Long,1,2,0,0,X");
		roomTest.processFileLine("6,Room6,Room 6 Short,Room 6 Long,1,2,0,0,X");
		roomTest.processFileLine("7,Room7,Room 7 Short,Room 7 Long,1,2,0,0,X");
		roomTest.processFileLine("8,Room8,Room 8 Short,Room 8 Long,1,2,0,0,X");
		roomTest.processRoomLinks();	
		roomTest.processTreasures();
		System.out.println("\nMore Rooms than Treasures");
		for(int id = 1; id <= 8; id++) {
			System.out.println("Room" + id + ":" + roomTest.getRoomAtID(id).getTreasureType());
		}
		System.out.println("*****");
	}
}

package game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/**
 * Test for Rooms
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
	
	// Case where number of rooms is less than number of treasures (4) with random
	@Test
	void testProcessTreasures_1() {
		Rooms roomTest = new Rooms("RoomsBlank.csv");
		roomTest.processFileLine("1,Room1,1,1,Room 1 Short,Room 1 Long,1,2,0,0");
		roomTest.processFileLine("2,Room2,2,2,Room 2 Short,Room 2 Long,1,2,0,0");
		roomTest.processRoomLinks();	
		roomTest.processTreasures();
		System.out.println("\nMore Treasures Than Rooms");
		int id = 1;
		System.out.println("Room" + id + ":" + roomTest.getRoomAtID(id).getTreasureType());
		id = 2;
		System.out.println("Room" + id + ":" + roomTest.getRoomAtID(id).getTreasureType());
		System.out.println("*****");
	}
	
	// Case where number of rooms is same as number of treasures (4) with random
	@Test
	void testProcessTreasures_2() {
		Rooms roomTest = new Rooms("RoomsBlank.csv");
		roomTest.processFileLine("1,Room1,1,1,Room 1 Short,Room 1 Long,1,2,0,0");
		roomTest.processFileLine("2,Room2,2,2,Room 2 Short,Room 2 Long,1,2,0,0");
		roomTest.processFileLine("3,Room3,3,3,Room 3 Short,Room 3 Long,1,2,0,0");
		roomTest.processFileLine("4,Room4,4,4,Room 4 Short,Room 4 Long,1,2,0,0");
		roomTest.processRoomLinks();	
		roomTest.processTreasures();
		System.out.println("\nSame number of Treaures and Rooms");
		int id = 1;
		System.out.println("Room" + id + ":" + roomTest.getRoomAtID(id).getTreasureType());
		id = 2;
		System.out.println("Room" + id + ":" + roomTest.getRoomAtID(id).getTreasureType());
		id = 3;
		System.out.println("Room" + id + ":" + roomTest.getRoomAtID(id).getTreasureType());
		id = 4;
		System.out.println("Room" + id + ":" + roomTest.getRoomAtID(id).getTreasureType());
		System.out.println("*****");
	}
	
	// Case where number of rooms is greater than number of treasures (4) with random
	@Test
	void testProcessTreasures_3() {
		Rooms roomTest = new Rooms("RoomsBlank.csv");
		roomTest.processFileLine("1,Room1,1,1,Room 1 Short,Room 1 Long,1,2,0,0");
		roomTest.processFileLine("2,Room2,2,2,Room 2 Short,Room 2 Long,1,2,0,0");
		roomTest.processFileLine("3,Room3,3,3,Room 3 Short,Room 3 Long,1,2,0,0");
		roomTest.processFileLine("4,Room4,4,4,Room 4 Short,Room 4 Long,1,2,0,0");
		roomTest.processFileLine("5,Room5,5,5,Room 5 Short,Room 5 Long,1,2,0,0");
		roomTest.processFileLine("6,Room6,6,6,Room 6 Short,Room 6 Long,1,2,0,0");
		roomTest.processRoomLinks();	
		roomTest.processTreasures();
		System.out.println("\nSame number of Treaures and Rooms");
		int id = 1;
		System.out.println("Room" + id + ":" + roomTest.getRoomAtID(id).getTreasureType());
		id = 2;
		System.out.println("Room" + id + ":" + roomTest.getRoomAtID(id).getTreasureType());
		id = 3;
		System.out.println("Room" + id + ":" + roomTest.getRoomAtID(id).getTreasureType());
		id = 4;
		System.out.println("Room" + id + ":" + roomTest.getRoomAtID(id).getTreasureType());
		id = 5;
		System.out.println("Room" + id + ":" + roomTest.getRoomAtID(id).getTreasureType());
		id = 6;
		System.out.println("Room" + id + ":" + roomTest.getRoomAtID(id).getTreasureType());
		System.out.println("*****");
	}
}

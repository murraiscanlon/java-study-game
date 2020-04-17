package game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/**
 * Test for Treasures Class
 * @author Team 30
 *
 */
class TreasuresTest {

	
	@Test
	//Test to see if treasures 1-6 are in room
	void testIsTreasureInRoom_1() {
		Treasures treasures = new Treasures();
		int roomid = 1;
		Treasure t = treasures.isTreasureInRoom(roomid-1);
		assertEquals(t.getTreasureType(), "Bitcoin");
	}

	@Test
	void testIsTreasureInRoom_2() {
		Treasures treasures = new Treasures();
		int roomid = 2;
		Treasure t = treasures.isTreasureInRoom(roomid-1);
		assertEquals(t.getTreasureType(), "Jewel Editor");
	}

	@Test
	void testIsTreasureInRoom_3() {
		Treasures treasures = new Treasures();
		int roomid = 3;
		Treasure t = treasures.isTreasureInRoom(roomid-1);
		assertEquals(t.getTreasureType(), "Java Sword");
	}

	@Test
	void testIsTreasureInRoom_4() {
		Treasures treasures = new Treasures();
		int roomid = 4;
		Treasure t = treasures.isTreasureInRoom(roomid-1);
		assertEquals(t.getTreasureType(), "Magic IDE");
	}
	
	@Test
    void testIsTreasureInRoom_5() {
        Treasures treasures = new Treasures();
        int roomid = 5;
        Treasure t = treasures.isTreasureInRoom(roomid-1);
        assertEquals(t.getTreasureType(), "Diamond Debugger");
    }
	
	@Test
    void testIsTreasureInRoom_6() {
        Treasures treasures = new Treasures();
        int roomid = 6;
        Treasure t = treasures.isTreasureInRoom(roomid-1);
        assertEquals(t.getTreasureType(), "Key Compiler");
    }
	@Test
	//Tests if Treasure is not in Room
	void testIsTreasureInRoom_null() {
		Treasures treasures = new Treasures();
		int roomid = 7;
		Treasure t = treasures.isTreasureInRoom(roomid-1);
		assertEquals(t, null);
	}

	// Test with 2 rooms, 4 treasures, not random
	@Test
	void testSetTreasuresToRooms_02_04_false() {
		Treasures treasures = new Treasures();
		int numberOfRooms = 2;
		treasures.setTreasuresToRooms(numberOfRooms, false);

		System.out.println("\nRooms: " + numberOfRooms + " Treasures: 4, not random");
		for(int index = 0; index < numberOfRooms; index++) {
			Treasure t = treasures.getTreasureForRoom(index + 1);
			System.out.println("Room: " + (index+1) + "  Treasure: " + t.getTreasureType() + "  RoomID: " + t.getRoomId());;

			switch(index + 1) {
			case 1:
				assertEquals(t.getTreasureType(), "Bitcoin");
				break;
			case 2:
				assertEquals(t.getTreasureType(), "Jewel Editor");
				break;
			default:
			}

			assertEquals(t.getRoomId(), index+1);
		}
		System.out.println("*****");
	}

	// Test with 4 rooms, 4 treasures, not random
	@Test
	void testSetTreasuresToRooms_04_04_false() {
		Treasures treasures = new Treasures();
		int numberOfRooms = 4;
		treasures.setTreasuresToRooms(numberOfRooms, false);

		System.out.println("\nRooms: " + numberOfRooms + " Treasures: 4, not random");
		for(int index = 0; index < numberOfRooms; index++) {
			Treasure t = treasures.getTreasureForRoom(index + 1);
			System.out.println("Room: " + (index+1) + "  Treasure: " + t.getTreasureType() + "  RoomID: " + t.getRoomId());;

			switch(index + 1) {
			case 1:
				assertEquals(t.getTreasureType(), "Bitcoin");
				break;
			case 2:
				assertEquals(t.getTreasureType(), "Jewel Editor");
				break;		
			case 3:
				assertEquals(t.getTreasureType(), "Java Sword");
				break;			
			case 4:
				assertEquals(t.getTreasureType(), "Magic IDE");
				break;
			default:
			}

			assertEquals(t.getRoomId(), index+1);
		}
		System.out.println("*****");
	}

	// Test with 6 rooms, 4 treasures, not random
	@Test
	void testSetTreasuresToRooms_06_04_false() {
		Treasures treasures = new Treasures();
		int numberOfRooms = 6;
		treasures.setTreasuresToRooms(numberOfRooms, false);

		System.out.println("\nRooms: " + numberOfRooms + " Treasures: 4, not random");
		for(int index = 0; index < numberOfRooms; index++) {
			Treasure t = treasures.getTreasureForRoom(index + 1);
			System.out.print("Room: " + (index+1) + "  Treasure: ");
			if(t != null) {
				System.out.println(t.getTreasureType() + "  RoomID: " + t.getRoomId());
			}
			else {
				System.out.println("No Treasure.");
			}
			switch(index + 1) {
			case 1:
				assertEquals(t.getTreasureType(), "Bitcoin");
				break;
			case 2:
				assertEquals(t.getTreasureType(), "Jewel Editor");
				break;		
			case 3:
				assertEquals(t.getTreasureType(), "Java Sword");
				break;			
			case 4:
				assertEquals(t.getTreasureType(), "Magic IDE");
				break;
			default:
			}

			if (t != null) {
				assertEquals(t.getRoomId(), index+1);
			}
		}
		System.out.println("*****");
	}
	
	// Test with 2 rooms, 4 treasures, RANDOM
	@Test
	void testSetTreasuresToRooms_02_04_true() {
		Treasures treasures = new Treasures();
		int numberOfRooms = 2;
		treasures.setTreasuresToRooms(numberOfRooms, true);

		System.out.println("\nRooms: " + numberOfRooms + " Treasures: 4, RANDOM");
		for(int index = 0; index < numberOfRooms; index++) {
			Treasure t = treasures.getTreasureForRoom(index + 1);
			System.out.print("Room: " + (index+1) + "  Treasure: ");
			if(t != null) {
				System.out.println(t.getTreasureType() + "  RoomID: " + t.getRoomId());
			}
			else {
				System.out.println("No Treasure.");
			}		}
		System.out.println("*****");
	}

	
	// Test with 4 rooms, 4 treasures, RANDOM
	@Test
	void testSetTreasuresToRooms_04_04_true() {
		Treasures treasures = new Treasures();
		int numberOfRooms = 4;
		treasures.setTreasuresToRooms(numberOfRooms, true);

		System.out.println("\nRooms: " + numberOfRooms + " Treasures: 4, RANDOM");
		for(int index = 0; index < numberOfRooms; index++) {
			Treasure t = treasures.getTreasureForRoom(index + 1);
			System.out.print("Room: " + (index+1) + "  Treasure: ");
			if(t != null) {
				System.out.println(t.getTreasureType() + "  RoomID: " + t.getRoomId());
			}
			else {
				System.out.println("No Treasure.");
			}		}
		System.out.println("*****");
	}
	
	
	// Test with 6 rooms, 4 treasures, RANDOM
	@Test
	void testSetTreasuresToRooms_06_04_true() {
		Treasures treasures = new Treasures();
		int numberOfRooms = 6;
		treasures.setTreasuresToRooms(numberOfRooms, true);

		System.out.println("\nRooms: " + numberOfRooms + " Treasures: 4, RANDOM");
		for(int index = 0; index < numberOfRooms; index++) {
			Treasure t = treasures.getTreasureForRoom(index + 1);
			System.out.print("Room: " + (index+1) + "  Treasure: ");
			if(t != null) {
				System.out.println(t.getTreasureType() + "  RoomID: " + t.getRoomId());
			}
			else {
				System.out.println("No Treasure.");
			}		}
		System.out.println("*****");
	}
	
}























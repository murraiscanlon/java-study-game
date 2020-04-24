package game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/**
 * Test for Treasures Class
 * @author Team 30
 *
 */
class TreasuresTest {

	/*
	 * The tests in this class verify that the treasure are set correctly when there are different number
	 * of rooms.  This was to verify that the assignment would work if there were not equal number of rooms and treasures
	 * The setTreasurestoRoom method take a boolean to flag if the treasures should be random.  This is set to false
	 * for testing with assertEquals.  It is set to true for some tests, but the results are printed out and manually checked
	 * to make sure they are randomly generated.
	 */

	// Test with 2 rooms, 6 treasures, not random
	@Test
	void testSetTreasuresToRooms_02_06_false() {
		Treasures treasures = new Treasures();
		int numberOfRooms = 2;
		treasures.setTreasuresToRooms(numberOfRooms, false); // set randomizing to false

		System.out.println("\nRooms: " + numberOfRooms + " Treasures: 6, not random");
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

	// Test with 6 rooms, 6 treasures, not random
	@Test
	void testSetTreasuresToRooms_06_06_false() {
		Treasures treasures = new Treasures();
		int numberOfRooms = 4;
		treasures.setTreasuresToRooms(numberOfRooms, false);

		System.out.println("\nRooms: " + numberOfRooms + " Treasures: 6, not random");
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
			case 5:
				assertEquals(t.getTreasureType(), "Diamond Debugger");
				break;
			case 6:
				assertEquals(t.getTreasureType(), "Key Compiler");
				break;
			default:
			}

			assertEquals(t.getRoomId(), index+1);
		}
		System.out.println("*****");
	}

	// Test with 10 rooms, 6 treasures, not random
	@Test
	void testSetTreasuresToRooms_10_06_false() {
		Treasures treasures = new Treasures();
		int numberOfRooms = 10;
		treasures.setTreasuresToRooms(numberOfRooms, false);

		System.out.println("\nRooms: " + numberOfRooms + " Treasures: 6, not random");
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
			case 5:
				assertEquals(t.getTreasureType(), "Diamond Debugger");
				break;
			case 6:
				assertEquals(t.getTreasureType(), "Key Compiler");
				break;
			default:
			}

			if (t != null) {
				assertEquals(t.getRoomId(), index+1);
			}
		}
		System.out.println("*****");
	}

	// Test with 2 rooms, 6 treasures, RANDOM
	@Test
	void testSetTreasuresToRooms_02_06_true() {
		Treasures treasures = new Treasures();
		int numberOfRooms = 2;
		treasures.setTreasuresToRooms(numberOfRooms, true);

		System.out.println("\nRooms: " + numberOfRooms + " Treasures: 6, RANDOM");
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


	// Test with 6 rooms, 6 treasures, RANDOM
	@Test
	void testSetTreasuresToRooms_06_06_true() {
		Treasures treasures = new Treasures();
		int numberOfRooms = 6;
		treasures.setTreasuresToRooms(numberOfRooms, true);

		System.out.println("\nRooms: " + numberOfRooms + " Treasures: 6, RANDOM");
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


	// Test with 10 rooms, 6 treasures, RANDOM
	@Test
	void testSetTreasuresToRooms_10_06_true() {
		Treasures treasures = new Treasures();
		int numberOfRooms = 10;
		treasures.setTreasuresToRooms(numberOfRooms, true);

		System.out.println("\nRooms: " + numberOfRooms + " Treasures: 6, RANDOM");
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























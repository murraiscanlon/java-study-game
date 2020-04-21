package game;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * Test for Room
 * @author Team 30
 *
 */
class RoomTest {
	
	//Set up two rooms for testing. 
	
	Room room1 = new Room(1, "FOYER", "You are in the FOYER.", 
	            "You have entered the Foyer. From here you may"
	            + " traverse many different rooms. Note the "
	            + "distinct castle architecture reminiscent "
	            + "of the Baroque era.", "");
	Room room2 = new Room(2, "DUNGEON", "You are in the DUNGEON.", 
	            "You have entered the Dungeon-a pit of despair where"
	            + " untold numbers have reached Index Out of Bounds."
	            + " Wizard Arvind remains in captivity-only your "
	            + "knowledge can save him!", "");
	
	// Set up connections between two rooms.
	@BeforeEach
	void setUp() throws Exception {
		room1.setAdjacentRoom("east", room2);
		room2.setAdjacentRoom("west", room1);
	}

	// Test Room Name getter
	@Test
	void testGetName() {
		assertEquals(room1.getName(), "FOYER");
	}

	// Test Short Description getter
	@Test
	void testGetShortDesc() {
		assertEquals(room1.getShortDesc(), "You are in the FOYER.");
	}

	// Test Long Description getter
	@Test
	void testGetLongDesc() {
		assertEquals(room1.getLongDesc(), "You have entered the Foyer. "
		        + "From here you may traverse many different rooms. "
		        + "Note the distinct castle architecture reminiscent "
		        + "of the Baroque era.");
	}

	/*
	 * Test:
	 * - Room was initially unvistied
	 * - Set the rooms as visited 
	 * - Check that the room was visit boolean is set to true
	 */
	@Test
	void testVisited() {
		assertFalse(room1.wasVisited());
		room1.setVisited();
		assertTrue(room1.wasVisited());		
	}

	/* Test Room links
	 * Check to make sure that the room links set in the BeforeEach above are correctly set
	 */
	@Test
	void testGetRoomAtDirection_R1_E2() {
		assertEquals(room1.getRoomAtDirection("east").getId(),2);
	}
	
	@Test
	void testGetRoomAtDirection_R2_W1() {
		assertEquals(room2.getRoomAtDirection("west").getId(),1);
	}

	@Test
	void testGetRoomAtDirection_R1_Snull() {
		assertEquals(room1.getRoomAtDirection("south"),null);
	}
}

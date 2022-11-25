package dungeon;

import org.junit.Test;

import static org.junit.Assert.*;

public class MedievalLevelBuilderTest {

    private static final int FIRST_ROOM = 0;

    /**
     * Test adding rooms.
     */
    @Test(timeout = 3000)
//    @TestWeight(weight = 5)
    public void testAddingRoomsTarget() {
        MedievalLevelBuilder b = new MedievalLevelBuilder(1, 3, 0, 0);
        b.addRoom("Entrance");
        b.addRoom("Hallway");
        b.addRoom("Cave");
        Level l1 = b.build();
        String expected = "Level 1 contains 3 rooms:\n\n"
                + "Room 0 -- Entrance\nMonsters:\n\tNone\nTreasures:\n\tNone\n\n"
                + "Room 1 -- Hallway\nMonsters:\n\tNone\nTreasures:\n\tNone\n\n"
                + "Room 2 -- Cave\nMonsters:\n\tNone\nTreasures:\n\tNone\n";
        assertEquals("Error adding rooms", expected, l1.toString());
    }

    /**
     * Testing adding too many treasures.
     */
    @Test(expected = IllegalStateException.class)
//    @TestWeight(weight = 1)
    public void testAddingTooManyTreasures() {
        MedievalLevelBuilder b = new MedievalLevelBuilder(1, 0, 0, 0);
        b.addRoom("Entrance");
        try {
            b.addPotion(FIRST_ROOM);
            fail("Expected error adding too many potions");
        } catch (IllegalStateException ex) {
            // this is what we expect
        }
        try {
            b.addGold(FIRST_ROOM, 10);
            fail("Expected error adding too many gold");
        } catch (IllegalStateException ex) {
            // this is what we expect
        }
        try {
            b.addWeapon(FIRST_ROOM, "sword");
            fail("Expected error adding too many weapons");
        } catch (IllegalStateException ex) {
            // this is what we expect
        }
        try {
            b.addSpecial(FIRST_ROOM, "magic sword", 100);
            fail("Expected error adding too many special treasures");
        } catch (IllegalStateException ex) {
            // this is what we expect
        }
    }

}
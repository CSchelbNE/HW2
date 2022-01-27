import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * RoomTest verifies that all of the
 * methods in the Room class are behaving as
 * intended when given valid and invalid
 * inputs.
 */
public class RoomTest {
  private Room testSingleRoom;
  private Room testDoubleRoom;
  private Room testFamilyRoom;

  /**
   * Creates one of each type of Room to be used
   * in each of the subsequent tests.
   */
  @Before
  public void setUp(){
    Room testSingleRoom = new Room(RoomType.SINGLE_ROOM,234.1);
    Room testDoubleRoom = new Room(RoomType.DOUBLE_ROOM,1010.2);
    Room testFamilyRoom = new Room(RoomType.FAMILY_ROOM,234.1);

    this.testSingleRoom = testSingleRoom;
    this.testDoubleRoom = testDoubleRoom;
    this.testFamilyRoom = testFamilyRoom;
  }

  /**
   * This test makes sure the Room constructor
   * properly creates new Room objects.
   */
  @Test
  public void testRoomConstructor(){
    Room testDoubleRoom2 = new Room(RoomType.DOUBLE_ROOM,600);
    assertTrue(testDoubleRoom2.isAvailable());
    testDoubleRoom2.bookRoom(2);
    assertEquals(testDoubleRoom2.getNumberOfGuests(),2);
  }

  /**
   * This test makes sure that if a negative value
   * for price passed into the constructor the
   * proper exception is thrown.
   */
  @Test(expected=IllegalArgumentException.class)
  public void testInvalidRoomConstructor() {

    Room testSingleRoom = new Room(RoomType.SINGLE_ROOM, -234.1);

  }

  /**
   * This test makes sure isAvailable()
   * returns True when the room isn't
   * occupied and False otherwise.
   */
  @Test
  public void testIsAvailable() {
    // Each testcase runs a positive and then a negative check
    // Test with a single room
    assertTrue(testSingleRoom.isAvailable());
    testSingleRoom.bookRoom(1);
    assertFalse(testSingleRoom.isAvailable());

    // Test with a double room
    assertTrue(testDoubleRoom.isAvailable());
    testDoubleRoom.bookRoom(2);
    assertFalse(testDoubleRoom.isAvailable());

    // Test with a family room
    assertTrue(testFamilyRoom.isAvailable());
    testFamilyRoom.bookRoom(4);
    assertFalse(testFamilyRoom.isAvailable());
  }

  /**
   * This tests verifies that
   * bookRoom() behaves properly
   * with standard valid input.
   */
  @Test
  public void testValidBookRoom() {
    testSingleRoom.bookRoom(1);
    assertFalse(testSingleRoom.isAvailable());
    assertEquals(testSingleRoom.getNumberOfGuests(),1);

    testDoubleRoom.bookRoom(2);
    assertFalse(testDoubleRoom.isAvailable());
    assertEquals(testDoubleRoom.getNumberOfGuests(),2);

    testFamilyRoom.bookRoom(4);
    assertFalse(testFamilyRoom.isAvailable());
    assertEquals(testFamilyRoom.getNumberOfGuests(),4);
  }

  /**
   * This tests validates that bookRoom(0
   * behaves properly given different types
   * of invalid inputs.
   */
  @Test
  public void testInvalidBookRoom(){
    // Booking with invalid numbers of guests
    testSingleRoom.bookRoom(2);
    assertEquals(testSingleRoom.getNumberOfGuests(),0);

    testDoubleRoom.bookRoom(3);
    assertEquals(testDoubleRoom.getNumberOfGuests(),0);

    testFamilyRoom.bookRoom(6);
    assertEquals(testFamilyRoom.getNumberOfGuests(),0);

    // Booking with 0 guests
    testSingleRoom.bookRoom(0);
    assertEquals(testSingleRoom.getNumberOfGuests(),0);

    // Try to book a room that's already occupied
    testFamilyRoom.bookRoom(3);
    testFamilyRoom.bookRoom(2);
    // Assert the invalid booking does not change the previous state
    assertEquals(testFamilyRoom.getNumberOfGuests(),3);
  }

  /**
   * Verifies if the getNumberOfGuests()
   * method properly returns the amount of
   * guests currently booked in a room.
   */
  @Test
  public void testGetNumberOfGuests() {
    testFamilyRoom.bookRoom(3);
    assertEquals(testFamilyRoom.getNumberOfGuests(),3);
  }
}
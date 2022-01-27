import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RoomTest {
  private Room testSingleRoom;
  private Room testDoubleRoom;
  private Room testFamilyRoom;


  /**
   *
   */
  @Before
  public void setUp(){
    Room testSingleRoom = new Room(RoomType.SINGLE_ROOM,234.1);
    Room testDoubleRoom = new Room(RoomType.DOUBLE_ROOM,1010.2);
    Room testFamilyRoom = new Room(RoomType.SINGLE_ROOM,234.1);

    this.testSingleRoom = testSingleRoom;
    this.testDoubleRoom = testDoubleRoom;
    this.testFamilyRoom = testFamilyRoom;
  }

  /**
   *
   */
  @Test
  public void testRoomConstructor(){
    //
  }

  /**
   *
   */
  @Test(expected=IllegalArgumentException.class)
  public void testInvalidRoomConstructor(){
    try{
      Room testSingleRoom = new Room(RoomType.SINGLE_ROOM,234.1);
    }
    catch(IllegalArgumentException e){
    }
  }

  /**
   *
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
   *
   */
  @Test
  public void testValidBookRoom() {


  }

  /**
   *
   */
  @Test
  public void testInvalidBookRoom(){

  }

  /**
   *
   */
  @Test
  public void testGetNumberOfGuests() {
  }
}
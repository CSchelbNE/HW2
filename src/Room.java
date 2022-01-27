/**
 * The room class represents a room that's part
 * of a hotel's booking system.
 */
public class Room {
  private int maxOccupancy;
  private double price;
  private int bookedGuests = 0;

  /**
   * Creates a new Room object based on the type of
   * room passed in.
   * @param room the type of room being booked
   * @param price the price of the room
   * @throws IllegalArgumentException Thrown if price is a negative value
   */
  public Room(RoomType room, double price) throws IllegalArgumentException{
    if (price < 0) throw new IllegalArgumentException();

    else{
      this.price = price;
      this.maxOccupancy = room.getMaxOccupancy();
      }
  }

  /**
   * Checks if a room is available to be booked.
   * Available means there are 0 guests currently
   * assigned to the room object.
   * @return Returns true if the room is available, else false
   */
  public boolean isAvailable(){
    return bookedGuests == 0 ? true : false;
  }

  /**
   * Books a room if the room is available and
   * the passed in guests argument is valid for
   * the room type.
   * @param guests The number of guests to be assigned to the room.
   */
  public void bookRoom(int guests){
    bookedGuests = guests <= maxOccupancy && guests > 0 && isAvailable() ? guests : bookedGuests;
  }

  /**
   * Checks how many guests are currently
   * assigned to a room object.
   * @return Returns the number of guests currently assigned to a room.
   */
  public int getNumberOfGuests(){
    return bookedGuests;
  }
}

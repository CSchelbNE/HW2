package hw2;

/**
 * The room class represents a room that's part
 * of a hotel's booking system.
 */
public class Room {
  private int maxOccupancy;
  private double price;
  private int bookedGuests = 0;

  /**
   * Creates a new hw2.Room object based on the type of
   * room passed in.
   *
   * @param room  the type of room being booked
   * @param price the price of the room
   * @throws IllegalArgumentException Thrown if price is a negative value
   */
  public Room(RoomType room, double price) throws IllegalArgumentException {
    if (price < 0) throw new IllegalArgumentException();

    else {
      this.price = price;
      this.maxOccupancy = room.getMaxOccupancy();
    }
  }

  /**
   * Checks if a room is available to be booked.
   * Available means there are 0 guests currently
   * assigned to the room object.
   *
   * @return Returns true if the room is available, else false
   */
  public boolean isAvailable() {
    return bookedGuests == 0 ? true : false;
  }

  /**
   * Books a room if the room is available and
   * the passed in guests argument is valid for
   * the room type.
   *
   * @param guests The number of guests to be assigned to the room.
   */
  public void bookRoom(int guests) {
    // If the # of guests is valid and the room is available, book the room, otherwise no change.
    bookedGuests = guests <= maxOccupancy && guests > 0 && isAvailable() ? guests : bookedGuests;
  }

  /**
   * Returns the room's maximum occupancy.
   * @return Returns the attribute maxOccupancy.
   */
  public int getMaxOccupancy(){ return maxOccupancy; }

  /**
   * Returns the room's price
   * @return Returns the attribute price.
   */
  public double getPrice(){ return price; }

  /**
   * Checks how many guests are currently
   * assigned to a room object.
   *
   * @return Returns the number of guests currently assigned to a room.
   */
  public int getNumberOfGuests() {
    return bookedGuests;
  }
}

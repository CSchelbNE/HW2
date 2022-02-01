package hw2;

/**
 * This enum contains the different room types available
 * to be booked. Each room type has a max occupancy.
 */
public enum RoomType {
  SINGLE(1), DOUBLE(2), FAMILY(4);

  private final int maxOccupancy;

  /**
   * Assigns values to each of the constants in RoomType.
   *
   * @param maxOccupancy Max number of people a room can hold.
   */
  RoomType(int maxOccupancy) {
    this.maxOccupancy = maxOccupancy;
  }

  /**
   * Gets the maximum occupancy for the called RoomType.
   * @return returns the value of maxOccupancy
   */
  public int getMaxOccupancy() {
    return this.maxOccupancy;
  }

}

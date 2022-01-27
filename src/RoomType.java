public enum RoomType {
  SINGLE_ROOM(1),
  DOUBLE_ROOM(2),
  FAMILY_ROOM(4);

  private final int maxOccupancy;
  RoomType(int maxOccupancy) {
    this.maxOccupancy = maxOccupancy;
  }

  public int getMaxOccupancy(){
    return this.maxOccupancy;
  }

}

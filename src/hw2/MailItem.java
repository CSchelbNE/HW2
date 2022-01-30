package hw2;

/**
 * MailItem represents an arbitrary mail item
 * in a package system. It has a size
 * represented as 3d data and a recipient
 * who the mailitem is intended for.
 */
public class MailItem {
  // Dimensions cannot be less than 1
  private int width;
  private int height;
  private int depth;
  // Cannot be null
  private Recipient recipient;

  /**
   * Initializes a new MailItem object.
   * @param width The width of the mail item
   * @param height The height of the mail item
   * @param depth The depth of the mail item
   * @param recipient The person whom the package is being sent to
   * @throws IllegalArgumentException Constructor throws exception if
   *       {width,height,depth} < 1 or if recipient is null.
   */
  public MailItem(int width, int height, int depth, Recipient recipient) throws
          IllegalArgumentException {
    if (lessThanOne(new int[]{width, height, depth}) || recipient == null)
      throw new IllegalArgumentException();
    else {
      this.width = width;
      this.height = height;
      this.depth = depth;
    }
  }

  /**
   * @return
   */
  public int getWidth(){
    return width;
  }

  /**
   * @return
   */
  public int getHeight(){
    return height;
  }

  /**
   * @return
   */
  public int getDepth(){
    return depth;
  }

  /**
   * @return
   */
  public int[] getDimensions(){
    return new int[] {width,height,depth};
  }
  /**
   * Validation function to make sure the constructor
   * properly flags invalid input parameters.
   * @param input The input array to be validated
   * @return Returns true if all the values are >= 1
   */
  private boolean lessThanOne(int[] input) {
    for (int i = 0; i < 4; i++) {
      if (input[i] < 1 ? true : false) return true;
    }
    return false;
  }


  /**
   * Gets the mailitem's recipient.
   * @return Returns the mailitems recipient.
   */
  public Recipient getRecipient() {
    return recipient;
  }
}
package hw2;

/**
 * MailItem represents an arbitrary mail item
 * in a package system. It has a size
 * represented as 3d data and a recipient
 * who the mailitem is intended for.
 */
public class MailItem {
  // 3d values for the MailItem, cannot be less than 1
  private final int width;
  private final int height;
  private final int depth;
  // Cannot be null
  private final Recipient recipient;

  /**
   * Initializes a new MailItem object.
   *
   * @param width     The width of the mail item
   * @param height    The height of the mail item
   * @param depth     The depth of the mail item
   * @param recipient The person whom the package is being sent to
   * @throws IllegalArgumentException Constructor throws exception if
   *                                  {width,height,depth} < 1 or if recipient is null.
   */
  public MailItem(int width, int height, int depth, Recipient recipient)
          throws IllegalArgumentException {
    if (lessThanOne(new int[]{width, height, depth}) || recipient == null)
      throw new IllegalArgumentException("Dimensions cannot be less than 1.");
    else {
      this.width = width;
      this.height = height;
      this.depth = depth;
      this.recipient = recipient;
    }
  }

  /**
   * Validation function to make sure the constructor
   * properly flags invalid input parameters.
   *
   * @param input The input array to be validated
   * @return Returns true if all the values are >= 1
   */
  private boolean lessThanOne(int[] input) {
    for (int i = 0; i < 3; i++) {
      if (input[i] < 1) return true;
    }
    return false;
  }

  /**
   * Gets the width of the mailitem.
   * @return Returns the width attribute.
   */
  public int getWidth() {
    return width;
  }

  /**
   * Gets the height of the mailitem.
   * @return Returns the height attribute.
   */
  public int getHeight() {
    return height;
  }

  /**
   * Gets the depth of the mailitem.
   * @return Returns the depth attribute.
   */
  public int getDepth() {
    return depth;
  }

  /**
   * Gets all the dimensions of the mailitem.
   * @return Returns an int array of width,height and depth.
   */
  public int[] getDimensions() {
    return new int[]{width, height, depth};
  }

  /**
   * Gets the mailitem's recipient.
   *
   * @return Returns the value of recipient.
   */
  public Recipient getRecipient() {
    return recipient;
  }
}
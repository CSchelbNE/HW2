package hw2;

/**
 * Locker represents a locker in a mail/
 * package transfer system. It is used to
 * store mail items for pickup.
 */
public class Locker {
  // 3d values for the Locker, cannot be less than 1
  private final int maxWidth;
  private final int maxHeight;
  private final int maxDepth;
  // Initialized as null since the locker is empty until mail is put in
  private MailItem lockerStatus = null;

  /**
   * Initializes a new Locker object with 3d attributes.
   * @param maxWidth The max width mail the locker can hold
   * @param maxHeight The max height mail the locker can hold
   * @param maxDepth The max depth mail the locker can hold
   * @throws IllegalArgumentException If any of the dimensions are
   *      less than 1 throw this exception.
   */
  public Locker(int maxWidth, int maxHeight, int maxDepth) throws IllegalArgumentException {
    // Passes an array of the dimensions into a function to check if any are <1
    if (lessThanOne(new int[]{maxWidth, maxHeight, maxDepth})) {
      throw new IllegalArgumentException("Dimensions cannot be less than 1.");
    } else {
      this.maxWidth = maxWidth;
      this.maxHeight = maxHeight;
      this.maxDepth = maxDepth;
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
   * Gets the max width of the locker.
   * @return Returns the maxWidth attribute
   */
  public int getMaxWidth() {
    return maxWidth;
  }

  /**
   * Gets the max height of the locker.
   * @return Returns the maxHeight attribute.
   */
  public int getMaxHeight() {
    return maxHeight;
  }

  /**
   * Gets the max depth of the locker.
   * @return Returns the maxDepth attribute.
   */
  public int getMaxDepth() {
    return maxDepth;
  }

  /**
   * Returns if the locker is empty or not.
   * @return Returns the lockerStatus attribute.
   */
  public MailItem getLockerStatus() {
    return lockerStatus;
  }

  /**
   * Gets the dimensions of the locker.
   * @return Returns an int array containing maxWidth,maxHeight and maxDepth.
   */
  private int[] getLockerDimensions() {
    return new int[]{maxWidth, maxHeight, maxDepth};
  }

  /**
   * Adds a new Mailitem object to the locker given that is
   * doesn't already have mail in it and the dimensions of the mail
   * are smaller than the locker's max dimensions.
   * @param newMail The mailitem object to be added to the locker
   */
  public void addMail(MailItem newMail) {
    // If the locker is empty end the method call
    if (lockerStatus != null) return;

    // Create arrays with each of the object's dimensions
    int[] mailDimensions = newMail.getDimensions();
    int[] lockerDimensions = this.getLockerDimensions();
    for (int i = 0; i < 3; i++) {
      if (mailDimensions[i] > lockerDimensions[i]) return;
    }
    lockerStatus = newMail;
  }

  /**
   * Removes the mailitem from the locker if the passed in recipient
   * matches the recipient attached to the mailitem.
   *
   * @param recipient The recipient of the mail.
   * @return Returns the mailitem if the checks pass otherwise null.
   */
  public MailItem pickupMail(Recipient recipient) {
    // If the locker isn't empty and the recipients match return the mail
    if (lockerStatus != null && (lockerStatus.getRecipient() == recipient)) {
      MailItem temp = lockerStatus;
      lockerStatus = null;
      return temp;
    }
    return null;
  }
}



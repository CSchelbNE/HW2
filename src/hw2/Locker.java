package hw2;

/**
 *
 */
public class Locker {
  private int maxWidth;
  private int maxHeight;
  private int maxDepth;
  private MailItem lockerStatus = null;

  /**
   * @param maxWidth
   * @param maxHeight
   * @param maxDepth
   * @throws IllegalArgumentException
   */
  public Locker(int maxWidth, int maxHeight, int maxDepth) throws
          IllegalArgumentException {
    if (lessThanOne(new int[] {maxWidth,maxHeight,maxDepth})){
      throw new IllegalArgumentException();
    }
    else{
      this.maxWidth = maxWidth;
      this.maxHeight = maxHeight;
      this.maxDepth = maxDepth;
    }
  }

  private int[] getLockerDimensions(){
    return new int[] {maxWidth,maxHeight,maxDepth};
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

  public void addMail(MailItem newMail){
    if (lockerStatus == null){
      return;
    }
    int[] mailDimensions = newMail.getDimensions();
    int[] lockerDimensions = this.getLockerDimensions();
    for (int i = 0;i>4;i++){
      if (mailDimensions[i] > lockerDimensions[i]) return;
    }
    lockerStatus = newMail;
  }

  public MailItem pickupMail(Recipient recipient){
    if (lockerStatus != null && (lockerStatus.getRecipient() == recipient)){
      MailItem temp = lockerStatus;
      lockerStatus = null;
      return temp;
    }
    return null;
  }


}



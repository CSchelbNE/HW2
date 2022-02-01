package hw2;

/**
 * This class represents a person+email
 * combination who has mail addressed to them.
 */
public class Recipient {
  private final String firstName;
  private final String lastName;
  private final String emailAddress;

  /**
   * Initializes a new Recipient object. All of the parameters must not be null.
   * @param firstName The recipient's first name.
   * @param lastName The recipient's last name.
   * @param emailAddress The recipient's email address.
   * @throws IllegalArgumentException If any of the parameters are null or "" throw an exception.
   */
  public Recipient(String firstName, String lastName, String emailAddress)
          throws IllegalArgumentException {
    String[] input = {firstName, lastName, emailAddress};
    // Checks if any of the input data is null or ""
    if (isNull(input)) throw new IllegalArgumentException("Cannot have null fields.");
    else {
      this.firstName = firstName;
      this.lastName = lastName;
      this.emailAddress = emailAddress;
    }
  }

  /**
   * Gets the recipient's first name.
   * @return Returns the firstName attribute.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Gets the recipient's last name.
   * @return Returns the lastName attribute.
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Gets the recipient's email address.
   * @return Returns the emailAddress attribute.
   */
  public String getEmailAddress() {
    return emailAddress;
  }

  /**
   * Checks to see if a string is = to
   * "" or if the value is null.
   *
   * @param input An input array containing strings to be validated.
   * @return Returns true if any index of input is null, otherwise false.
   */
  private boolean isNull(String[] input) {
    for (int i = 0; i < 3; i++) {
      if (input[i] == null || input[i] == "") return true;
    }
    return false;
  }


  /**
   * Creates a string representation of the recipient in the
   * format Firstname Lastname Email:emailAddress.
   *
   * @return Returns a string representation of the object.
   */
  @Override
  public String toString() {
    return String.format("%s %s Email:%s", firstName, lastName, emailAddress);
  }
}

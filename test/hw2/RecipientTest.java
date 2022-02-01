package hw2;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests if all the methods in the MailItem class are
 * working as intended with valid and invalid inputs.
 */
public class RecipientTest {
  private Recipient testRecipient1;

  /**
   * Initializes a new valid recipient object
   * prior to running each unit test.
   */
  @Before
  public void setUp() {
    Recipient testrecipient1 = new Recipient("John", "Doe",
            "abc123@gmail.com");
    this.testRecipient1 = testrecipient1;
  }

  /**
   * Tests if the constructor will properly raise an IllegalArgumentException.
   * if any of the necessary fields are empty or null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidRecipient1() {
    Recipient testRecipient1 = new Recipient("John", "", "");
  }

  /**
   * Tests if the constructor will properly raise an IllegalArgumentException.
   * if any of the necessary fields are empty or null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidRecipient2() {
    Recipient testRecipient2 = new Recipient("John", null, null);
  }

  /**
   * Tests if the constructor will properly raise an IllegalArgumentException.
   * if any of the necessary fields are empty or null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidRecipient3() {
    Recipient testRecipient3 = new Recipient(null, "Doe", "");

  }

  /**
   * Tests if getFirstName() returns the proper value.
   */
  @Test
  public void getFirstName() {
    assertEquals(testRecipient1.getFirstName(), "John");
  }

  /**
   * Tests if getLastName() returns the proper value.
   */
  @Test
  public void getLastName() {
    assertEquals(testRecipient1.getLastName(), "Doe");
  }

  /**
   * Tests if getEmailAddress() returns the proper value.
   */
  @Test
  public void getEmailAddress() {
    assertEquals(testRecipient1.getEmailAddress(), "abc123@gmail.com");
  }

  /**
   * Tests if toString properly returns a string representation of the
   * object.
   */
  @Test
  public void testToString() {
    assertEquals(testRecipient1.toString(), "John Doe Email:abc123@gmail.com");
  }
}
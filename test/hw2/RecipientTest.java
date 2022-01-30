package hw2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecipientTest {

  @Before
  public void setUp() throws Exception {
    Recipient testrecipient1 = new Recipient("John","Doe",
            "abc123@gmail.com");
  }


  /**
   * Tests if the constructor will properly raise an IllegalArgumentException
   * if any of the necessary fields are empty or null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidRecipient1() {
    Recipient testRecipient1 =
            new Recipient("John", "", "");
  }

  /**
   * Tests if the constructor will properly raise an IllegalArgumentException
   * if any of the necessary fields are empty or null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidRecipient2() {
    Recipient testRecipient2 = new Recipient("John", null,
            null);
  }

  /**
   * Tests if the constructor will properly raise an IllegalArgumentException
   * if any of the necessary fields are empty or null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidRecipient3() {
    Recipient testRecipient3 = new Recipient(null, "Doe",
            "");

  }

  @Test
  public void testToString() {
  }
}
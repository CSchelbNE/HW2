package hw2;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests if all the methods in the MailItem class are
 * working as intended with valid and invalid inputs.
 */
public class MailItemTest {
  Recipient testRecipient1 = new Recipient("Abba", "Sheep", "Abbasheep@yahoo.com");
  private MailItem testMailItem1;

  /**
   * Initializes a new valid recipient and Mailitem
   * object prior to running each unit test.
   */
  @Before
  public void setUp() {
    MailItem testMailItem1 = new MailItem(1, 5, 4, testRecipient1);
    this.testMailItem1 = testMailItem1;
  }


  /**
   * Checks that a constructor with valid normal inputs
   * properly creates a new Mailitem object.
   */
  @Test
  public void testValidConstructor() {
    MailItem testMailItem2 = new MailItem(100, 1000, 5, testRecipient1);
    assertEquals(testMailItem2.getWidth(), 100);
    assertEquals(testMailItem2.getHeight(), 1000);
    assertEquals(testMailItem2.getDepth(), 5);
    assertEquals(testMailItem2.getRecipient(), testRecipient1);
  }

  /**
   * Tests if an exception is thrown when
   * the constructor is passed an invalid integer
   * as an argument.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructor1() {
    MailItem invalidMailItem1 = new MailItem(2, 3, 0, testRecipient1);
  }

  /**
   * Tests if an exception is thrown if the
   * recipient argument is set to null.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructor2() {
    MailItem invalidMailItem1 = new MailItem(2,
            3, 4, null);
  }

  /**
   * Tests if getWidth returns the
   * proper value.
   */
  @Test
  public void getWidth() {
    assertEquals(testMailItem1.getWidth(), 1);
  }

  /**
   * Tests if getHeight returns the
   * proper value.
   */
  @Test
  public void getHeight() {
    assertEquals(testMailItem1.getHeight(), 5);
  }

  /**
   * Tests if getDepth returns the
   * proper value.
   */
  @Test
  public void getDepth() {
    assertEquals(testMailItem1.getDepth(), 4);
  }

  /**
   * Tests if getDimensions returns the
   * proper collection of values.
   */
  @Test
  public void getDimensions() {
    assertArrayEquals(testMailItem1.getDimensions(), new int[]{1, 5, 4});
  }

  /**
   * Tests if getRecipient returns the
   * proper value.
   */
  @Test
  public void getRecipient() {
    assertEquals(testMailItem1.getRecipient(), testRecipient1);
  }
}



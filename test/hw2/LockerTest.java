package hw2;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.locks.Lock;

/**
 * Tests if all the methods in the LockerTest class are
 * working as intended with valid and invalid inputs.
 */
public class LockerTest {
  private Locker testLocker1;
  private MailItem validMail;
  private Recipient testRecipient1 = new Recipient("John", "Xia",
          "John_xia@yahoo.com");

  /**
   * Initializes a new valid Locker and MailItem
   * object prior to running each unit test.
   */
  @Before
  public void setUp() {
    Locker testLocker1 = new Locker(4, 6, 5);
    MailItem validMail = new MailItem(1, 2, 3, testRecipient1);
    this.testLocker1 = testLocker1;
    this.validMail = validMail;
  }

  /**
   * Checks that a constructor with valid normal inputs
   * properly creates a new Locker object.
   */
  @Test
  public void testValidConstructor() {
    Locker testLocker2 = new Locker(6000, 400, 91237423);
    assertEquals(testLocker2.getMaxWidth(), 6000);
    assertEquals(testLocker2.getMaxHeight(), 400);
    assertEquals(testLocker2.getMaxDepth(), 91237423);

    Locker testLocker3 = new Locker(1,1,1);
    assertEquals(testLocker3.getMaxWidth(),1);
    assertEquals(testLocker3.getMaxHeight(),1);
    assertEquals(testLocker3.getMaxDepth(),1);
  }

  /**
   * Checks that a constructor with invalid inputs
   * properly throws an exception.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructor1() {
    Locker invalidLocker1 = new
            Locker(-1, 2, 5);
  }

  /**
   * Checks that a constructor with invalid inputs
   * properly throws an exception.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidConstructor2() {
    Locker invalidLocker1 = new
            Locker(5, 2, -5);
  }

  /**
   * Tests if getMaxWidth() returns the proper value.
   */
  @Test
  public void getMaxWidth() {
    assertEquals(testLocker1.getMaxWidth(), 4);
  }

  /**
   * Tests if getMaxHeight() returns the proper value.
   */
  @Test
  public void getMaxHeight() {
    assertEquals(testLocker1.getMaxHeight(), 6);
  }

  /**
   * Tests if getMaxDepth() returns the proper value.
   */
  @Test
  public void getMaxDepth() {
    assertEquals(testLocker1.getMaxDepth(), 5);
  }

  /**
   * Tests if addMail() properly adds a MailItem object to
   * the locker.
   */
  @Test
  public void addMail() {
    testLocker1.addMail(validMail);
    assertEquals(testLocker1.getLockerStatus(), validMail);
  }

  /**
   * Tests if addMail() properly handles invalid input and
   * an attempt to add a MailItem to a locker that's already full.
   */
  @Test
  public void addInvalidMail() {
    // Try to add mail that's larger than the locker
    MailItem invalidMail = new MailItem(100, 200, 1000, testRecipient1);
    testLocker1.addMail(invalidMail);
    assertEquals(testLocker1.getLockerStatus(), null);

    // Try to add valid mail to a locker that's already has mail in it
    MailItem validMail2 = new MailItem(1, 2, 3, testRecipient1);
    testLocker1.addMail(validMail);
    testLocker1.addMail(validMail2);
    assertEquals(testLocker1.getLockerStatus(), validMail);
  }

  /**
   * Tests if pickupmail() properly returns
   * the mailitem object in the locker.
   */
  @Test
  public void pickupMail() {
    testLocker1.addMail(validMail);
    assertEquals(testLocker1.pickupMail(testRecipient1), validMail);

    Locker testlocker2 = new Locker(100,500,300);
    testlocker2.addMail(validMail);
    assertEquals(testlocker2.pickupMail(testRecipient1), validMail);
  }


  /**
   * Tests if pickupMail() properly handles attempts
   * to pickup mail from a locker that's empty and
   * picking up mail with the wrong recipient name.
   */
  @Test
  public void pickupInvalidMail() {
    // Try to pick up mail from an empty locker.
    assertEquals(testLocker1.pickupMail(testRecipient1), null);

    // Try to pickup mail with the wrong recipient name.
    testLocker1.addMail(validMail);
    assertEquals(testLocker1.pickupMail(new Recipient("Leon", "Masker",
            "Leon_masker@protonmail.com")), null);
  }
}

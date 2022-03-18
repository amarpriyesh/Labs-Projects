package transmission;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;


/**
 * The Class tests the methods and behaviour of class AutomaticTransmission.
 * We test several scenarios using instances of class AutomaticTransmission.
 */
public class TransmissionTest {
  Transmission threshhold;
  Transmission threshhold1;
  Transmission threshhold2;

  /**
   * The setUp method creates instance threshhold of class AutomaticTransmission.
   * It also increases  the speed so that various test cases could be tested.
   * threshhold represents instance of class AutomaticTransmission.
   */
  @Before
  public void setUp() {
    threshhold = new AutomaticTransmission(15, 30, 45, 60, 75);
    for (int i = 0; i < 43; i++) {
      threshhold.increaseSpeed();
    }
  }

  /**
   * increase speed method is called  in the below test method and the increased speed is compared
   * with the static possible speed.
   */
  @Test
  public void testIncreaseSpeed() {
    threshhold.increaseSpeed();
    assertEquals(44, threshhold.getSpeed());
  }

  /**
   * decrease speed method is called  in the below test method and the decreased speed is compared
   * with the static possible speed.
   */
  @Test
  public void decreaseSpeed() {
    threshhold.decreaseSpeed();
    assertEquals(42, threshhold.getSpeed());
  }

  /**
   * getSpeed method is called  in the below test method and the decreased speed is compared
   * with the static possible speed.
   */
  @Test
  public void testGetSpeed() {
    assertEquals(43, threshhold.getSpeed());
  }

  /**
   * getGear method is called  in the below test, the gear corresponding to speed 43 is 3.
   * The getGear should return value 3.
   */
  @Test
  public void getGear() {
    assertEquals(3, threshhold.getGear());
  }

  /**
   * The below method compares the static string with the return value of toDString method.
   */
  @Test
  public void testToString() {
    assertEquals("Transmission (speed = 43, gear = 3)", threshhold.toString());
  }

  /**
   * The below function expects illegal parameters and throw Illegal argument exception.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalArguments() {

    threshhold1 = new AutomaticTransmission(-15, 30, -45, 60, 75);
  }

  /**
   * The below function expects illegal parameters and throw Illegal state exception.
   * We decrease the speed value to less than zero and expect IllegalStateException.
   */
  @Test(expected = IllegalStateException.class)
  public void testIllegalState() {

    threshhold2 = new AutomaticTransmission(15, 30, 45, 60, 75);
    threshhold2.decreaseSpeed();
  }
}
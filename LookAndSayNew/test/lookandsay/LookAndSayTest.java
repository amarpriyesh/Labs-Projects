package lookandsay;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.math.BigInteger;
import java.util.NoSuchElementException;




/**
 * Represents test class to test the methods and functionality of LookAndSayIterator.
 */
public class LookAndSayTest {

  /**
   * Does basic test regarding next sequence.
   */
  @Test
  public void testBasic() {
    RIterator<BigInteger> it = new LookAndSayIterator();
    assertTrue(it.hasNext());
    assertEquals(new BigInteger("1"), it.next());
  }

  /**
   * The below test, tests if we are getting right next values in the sequesnce.
   */
  @Test
  public void testNextPrevious() {
    RIterator<BigInteger> it = new LookAndSayIterator(new BigInteger("1"));


    assertEquals(1, it.next().intValue());
    assertEquals(11, it.next().intValue());
    assertEquals(21, it.next().intValue());
    assertEquals(11, it.prev().intValue());
    assertEquals(1, it.prev().intValue());


  }

  /**
   * The test throws o such element exception if the int value exceeds the end value.
   */
  @Test(expected = NoSuchElementException.class)
  public void testNext1() {
    RIterator<BigInteger> it = new LookAndSayIterator(new BigInteger("31"),
            new BigInteger("100"));
    assertEquals(31, it.next().intValue());
    assertEquals(1311, it.next().intValue());
    assertEquals(111321, it.next().intValue());
    assertEquals(31131211, it.next().intValue());


  }

  /**
   * The test throws Illegal argument exception  when an invalid seed is passed.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidSeed() {
    RIterator<BigInteger> it = new LookAndSayIterator(new BigInteger("-1"),
            new BigInteger("100"));


  }

  /**
   * The test throws Illegal argument exception  when seed is greater than end value.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidSeedGreaterThanEnd() {
    RIterator<BigInteger> it = new LookAndSayIterator(new BigInteger("100"),
            new BigInteger("50"));


  }

  /**
   * The test throws Illegal argument exception  when an invalid seed is passed in
   * one arg constructor.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidSeedOneArgConstructor() {
    RIterator<BigInteger> it = new LookAndSayIterator(new BigInteger("-1"));


  }

  /**
   * The test throws No such element exception  when next is called.
   */
  @Test(expected = NoSuchElementException.class)
  public void testNoSuchElementNext() {
    RIterator<BigInteger> it = new LookAndSayIterator(new BigInteger("1"),
            new BigInteger("100"));


    it.next();
    it.next();
    it.next();
    it.next();

  }

  /**
   * The test throws No such element exception  when prev() is called.
   */
  @Test(expected = NoSuchElementException.class)
  public void testNoSuchElementPrev() {
    RIterator<BigInteger> it = new LookAndSayIterator(new BigInteger("1"),
            new BigInteger("100"));


    it.prev();


  }

  /**
   * The test tests if has next and has previous returns true if there is a value present.
   */
  @Test
  public void testHasNextPrevious() {
    RIterator<BigInteger> it = new LookAndSayIterator(new BigInteger("1"),
            new BigInteger("100"));

    assertTrue(it.hasNext());
    assertEquals(1, it.next().intValue());
    assertTrue(it.hasNext());
    assertEquals(11, it.next().intValue());
    assertTrue(it.hasNext());
    assertEquals(21, it.next().intValue());
    assertFalse(it.hasNext());
    assertTrue(it.hasPrevious());
    assertEquals(11, it.prev().intValue());
    assertTrue(it.hasPrevious());
    assertEquals(1, it.prev().intValue());
    assertFalse(it.hasPrevious());


  }

}

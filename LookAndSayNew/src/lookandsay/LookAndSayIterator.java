package lookandsay;

import java.math.BigInteger;
import java.util.NoSuchElementException;

/**
 * The class represents the iterator which stores the number as you call them and provides
 * you different methods to iterate through the numbers.
 */
public class LookAndSayIterator implements RIterator<BigInteger> {


  private final BigInteger end;
  private BigInteger seed;
  private boolean  count;



  /**
   * Represents LookAndSayIterator constructor which can take starting number and end number to
   * iterate.
   *
   * @param seed starting number.
   * @param end  End number.
   */
  public LookAndSayIterator(BigInteger seed, BigInteger end) {
    if (seed.compareTo(new BigInteger("0")) <= 0 || seed.compareTo(end) > 0
            || seed.toString().contains("0") || seed.toString().contains("-")
            || end.toString().contains("-")) {
      throw new IllegalArgumentException("Invalid seed");
    }

    this.end = end;
    this.seed = seed;
    count = true;

  }

  /**
   * Represents LookAndSayIterator constructor which can take starting number to
   * iterate.
   *
   * @param seed starting number.
   */
  public LookAndSayIterator(BigInteger seed) {
    this(seed, new BigInteger("9".repeat(100)));

  }

  /**
   * Represents LookAndSayIterator constructor which can take default start and end numbers to
   * iterate.
   **/
  public LookAndSayIterator() {
    this(new BigInteger("1"), new BigInteger("9".repeat(100)));
  }


  /**
   * Returns true if this iterator has more elements when traversing the sequence
   * in the reverse direction.
   *
   * @return true if the sequence has more elements when traversing the sequence.
   *
   */
  @Override
  public boolean hasPrevious() {
    return (seed.toString().length() % 2 == 0) && (getPrev().compareTo(end) <= 0);
  }


  /**
   * Returns the previous element in the sequence and moves the cursor position
   * backwards. This method may be called repeatedly to iterate backwards through
   * the sequence.
   *
   * @return the previous element in the sequence
   * @throws NoSuchElementException if there is no previous element in the sequence
   */
  @Override
  public BigInteger prev() {
    if (!hasPrevious()) {
      throw new NoSuchElementException("No previous number present");
    }

    seed = getPrev();

    return seed;
  }


  private BigInteger getPrev() {


    String str = "";
    for (int i = seed.toString().length() - 1; i >= 0; i -= 2) {
      int count = Integer.parseInt(String.valueOf(seed.toString().charAt(i - 1)));

      while (count > 0) {
        str = seed.toString().charAt(i) + str;
        count--;
      }
    }
    return new BigInteger(str);
  }

  @Override
  public boolean hasNext() {
    return getNext().compareTo(end) <= 0;
  }


  private BigInteger getNext() {

    // compute next value based on current, and return it, WITHOUT mutating anything

    String str = "";
    int count = 1;
    for (int i = 0; i < seed.toString().length(); i++) {

      if (i != (seed.toString().length() - 1)) {
        if (seed.toString().charAt(i) == seed.toString().charAt(i + 1)) {
          count++;

        } else {

          str = str + count + seed.toString().charAt(i);
          count = 1;
        }
      } else {
        str = str + count + seed.toString().charAt(i);


      }
    }

    return new BigInteger(str);

  }

  @Override
  public BigInteger next() {

    if (count) {
      count = false;
      return seed;
    }

    if (!hasNext()) {
      throw new NoSuchElementException("No next number present");
    }
    seed = getNext();
    return seed;
  }


}

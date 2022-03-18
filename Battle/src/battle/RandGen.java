package battle;

import java.util.Random;

/**
 * Creates random numbers.
 */
public class RandGen {

  Random newRand;

  /**
   * Random with seeds.
   * @param a seed.
   */
  public RandGen(int a) {
    newRand = new Random(a);
  }

  /**
   * Random without seeds.
   */
  public RandGen() {
    newRand = new Random();
  }

  /**
   * Creates integers in bounds.
   * @param a int a.
   * @param b int b.
   * @return integer.
   */
  public int nextInt(int a, int b) {

    return a + newRand.nextInt((b - a + 1));
  }


}



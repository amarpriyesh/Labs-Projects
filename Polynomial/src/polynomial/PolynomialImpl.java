package polynomial;

/**
 * The class represents an implementation class for the given polynomial interface, which uses
 * list of term type head to perform various operations.
 */
public class PolynomialImpl implements Polynomial {

  private ListOfTerm head;
  private int degree;
  private int coefficient;

  /**
   * Points to an empty node if a blank polynomial is passed.
   */
  public PolynomialImpl() {
    head = new TermEmptyNode();
  }

  /**
   * Creates a polynomial by parsing the string.
   * @param str represents polynomial string.
   */
  public PolynomialImpl(String str) {
    //+3x^4 -2x^5 -5 -2x^4 +11x^1
    head = new TermEmptyNode();
    String[] tokens = str.split(" ");

    for (String t : tokens) {
      try {

        if (t.contains("x^")) {
          if ((t.substring(0, t.indexOf("x"))).equals("+") || (t.substring(0, t.indexOf("x")))
                  .equals("")) {
            coefficient = 1;
          }
          else if ((t.substring(0, t.indexOf("x"))).equals("-")) {
            coefficient = -1;
          }
          else {
            coefficient = Integer.parseInt(t.substring(0, t.indexOf("x")));
          }
          degree = Integer.parseInt(t.substring(t.indexOf('^') + 1)); }
        else if (t.contains("x")) {
          if ((t.substring(0, t.indexOf("x"))).equals("+") || (t.substring(0, t.indexOf("x")))
                  .equals("")) {
            coefficient = 1;
          }
          else if ((t.substring(0, t.indexOf("x"))).equals("-")) {
            coefficient = -1;
          }
          else {
            coefficient = Integer.parseInt(t.substring(0, t.indexOf("x")));
          }
          degree = 1;
        }
        else {
          coefficient = Integer.parseInt(t);
          degree = 0;
        }
      } catch (java.lang.NumberFormatException e) {
        throw new IllegalArgumentException("String format is not correct.");
      }
      if (degree < 0) {
        throw new IllegalArgumentException("Power can't be negative");
      }
      addTerm(coefficient, degree);
    }
  }


  /**
   * Add this polynomial to another and return the result as another polynomial.
   *
   * @param other the other polynomial to be added
   * @return the resulting polynomial
   * @throws IllegalArgumentException if parameter is not the same concrete type
   *                                  as the current object.
   */
  @Override
  public Polynomial add(Polynomial other) throws IllegalArgumentException {
    if (other instanceof PolynomialImpl) {
      return head.add(other);
    } else {
      throw new IllegalArgumentException("other is not an instance");
    }
  }

  /**
   * Add a term to this polynomial with the specified coefficient and power.
   *
   * @param coefficient the coefficient of the term to be added
   * @param power       the power of the term to be added
   * @throws IllegalArgumentException if the power is negative
   */
  @Override
  public void addTerm(int coefficient, int power) throws IllegalArgumentException {
    if (power < 0) {
      throw new IllegalArgumentException("Power or coefficient can't be negative");
    }
    head = head.addTerm(coefficient, power);
  }

  /**
   * Determines if this polynomial is the same as the parameter polynomial.
   *
   * @param poly the polynomial to use
   * @return true if this polynomial is of the same concrete type and has the same.
   */
  @Override
  public boolean isSame(Polynomial poly) {
    if ((poly instanceof PolynomialImpl)) {
      return this.head.equals(((PolynomialImpl) poly).head);
    }
    return false;

  }

  /**
   * Evaluate the value of this polynomial at the given value of the variable.
   *
   * @param x the value at which the polynomial is to be evaluated.
   * @return the value of the polynomial at x
   */
  @Override
  public double evaluate(double x) {
    return head.evaluate(x);
  }

  /**
   * Return the coefficient of the term with the given power.
   *
   * @param power the power whose coefficient is sought
   * @return the coefficient at the given power
   */
  @Override
  public int getCoefficient(int power) {
    if (power < 0) {
      throw new IllegalArgumentException("Power or coefficient can't be negative");
    }
    return head.getCoefficient(power);
  }

  /**
   * Get the degree of this polynomial.
   *
   * @return the degree of this polynomial as a whole number
   */
  @Override
  public int getDegree() {
    return head.getDegree();
  }

  @Override
  public String toString() {
    /*if (head.toString().substring(0,1).equals("+") ) {
      return head.toString().substring(1);
    }
    else {*/
    return head.toString();
    // }
  }
}

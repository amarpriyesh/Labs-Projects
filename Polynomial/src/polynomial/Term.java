package polynomial;

/**
 * The below class represents individual terms of the polynomial.
 */
public class Term {
  private final int coefficient;
  private final int degree;
  private boolean head;

  /**
   * The constructor initialise the below variables.
   * @param coefficient coefficient of the term.
   * @param power power of the term.
   */
  public Term(int coefficient, int power) {
    this.coefficient = coefficient;
    this.degree = power;
    this.head = false;
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof Term) {
      Term t = (Term) o;
      return coefficient == (t.coefficient) && degree == t.degree;
    } else {
      throw new IllegalArgumentException("concrete");
    }
  }

  @Override
  public int hashCode() {
    return 1;
  }

  public int getDegree() {
    return this.degree;
  }

  public int getCoefficient() {
    return this.coefficient;
  }

  @Override
  public String toString() {
    if (coefficient == 0) {
      return "";
    }
    if (this.degree > 0) {


      return String.format("%dx^%d", this.coefficient, this.degree);

    } else {

      return String.format("%d", this.coefficient);

    }
  }

  public void setHead(boolean f) {
    head = f;
  }
}

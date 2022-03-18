package polynomial;

/**
 * The interface houses methods to perform operations on union data type of polynomial.
 */
public interface ListOfTerm {

  /**
   * The below method helps adding a term to the polynomial.
   * @param coefficient represents coefficient of the term.
   * @param power represents power of the polynomial.
   * @return returns list of terms.
   */
  ListOfTerm addTerm(int coefficient, int power);

  /**
   * Returns Coefficient of a term with given power.
   * @param power accepts power of the term.
   * @return coefficient.
   */
  int getCoefficient(int power);

  /**
   * Calculates the value of the polynomial assigning a value x.
   * @param x represents value x.
   * @return value in double.
   */
  double evaluate(double x);

  /**
   * The below  method adds polynomial to other polynomial and returns a new polynomial.
   * @param other polynomial to be added.
   * @return returns new polynomial.
   */
  Polynomial add(Polynomial other);

  /**
   * Helper method to return  the current term.
   * @return term of the polynomial.
   */
  Term getTerm();

  /**
   * Helper method to return rest of the list.
   * @return rest of the list.
   */
  ListOfTerm getRest();

  /**
   * The method returns maximum degree of the polynomial.
   * @return the maximum degree in int.
   */
  int getDegree();



  /**
   * Helper method to equate the terms.
   * @param t represents object of type list.
   * @return true if both the lists are equal.
   */
  boolean equalHelper(ListOfTerm t);

  /**
   * Uses accumulator to compute toString and helps toString to concat the terms.
   * @param s takes string builder object.
   * @return concatenated string accumulator.
   */
  String toStringHelp(StringBuilder s);
}

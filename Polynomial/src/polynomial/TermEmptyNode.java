package polynomial;

/**
 * The class represents empty node pointing to the end of the list.
 */
public class TermEmptyNode implements ListOfTerm {
  @Override
  public ListOfTerm addTerm(int coefficient, int degree) {
    return new TermElementNode(new Term(coefficient, degree), this);
  }

  @Override
  public int getCoefficient(int power) {
    return 0;
  }

  public Term getTerm() {
    return null;
  }

  public ListOfTerm getRest() {
    return null;
  }

  @Override
  public int getDegree() {
    return 0;
  }


  @Override
  public String toStringHelp(StringBuilder s) {
    return s.append("0").toString();
  }


  @Override
  public double evaluate(double x) {
    //double eval = this.term.getCoefficient() * Math.pow(x,this.term.getDegree());
    return 0;
  }

  @Override
  public Polynomial add(Polynomial other) {
    return new PolynomialImpl();
  }

  @Override
  public String toString() {
    return "0";
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof ListOfTerm) {
      ListOfTerm t = (ListOfTerm) o;
      return this.toString().equals(t.toString());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return 1;
  }

  /**
   * Represents dummy helper.
   * @param t represents object of type list.
   * @return boolean.
   */
  public boolean equalHelper(ListOfTerm t) {
    return true;
  }
}

package polynomial;

/**
 * The class represents individual element node pointing to rest of the list and has methods
 * for the same purpose.
 */
public class TermElementNode implements ListOfTerm {

  private Term term;
  private ListOfTerm rest;

  /**
   * Represents constructor to initialise term and rest of the list.
   * @param term represents this term.
   * @param rest represents rest of the list.
   */
  public TermElementNode(Term term, ListOfTerm rest) {
    if (rest == null) {
      rest = new TermEmptyNode();
    }
    this.term = term;
    this.rest = rest;
  }


  @Override
  public ListOfTerm addTerm(int coefficient, int degree) {
    if (degree < 0) {
      throw new IllegalArgumentException("Power can't be negative");
    }
    if (this.rest == null) {
      rest = new TermEmptyNode();
    }

    if (degree == this.term.getDegree()) {
      this.term = new Term(this.term.getCoefficient() + coefficient, degree);
    } else if (degree > this.term.getDegree()) {
      TermElementNode node = new TermElementNode(new Term(coefficient, degree), this);
      return node;

    } else {
      rest = rest.addTerm(coefficient, degree);
    }

    this.term.setHead(true);
    return this;
  }

  @Override
  public int getCoefficient(int power) {
    if (power == this.term.getDegree()) {
      return this.term.getCoefficient();
    } else {
      return rest.getCoefficient(power);
    }
  }



  @Override
  public double evaluate(double x) {
    double eval = this.term.getCoefficient() * Math.pow(x, this.term.getDegree());
    return eval + rest.evaluate(x);
  }

  @Override
  public Polynomial add(Polynomial other) {

    Polynomial pol = other;


    int a = this.term.getCoefficient();
    int b = this.term.getDegree();
    pol.addTerm(a, b);
    rest.add(pol);
    return pol;
  }

  /**
   * helper method for toString method.
   * @param acc accumulator to store the string.
   * @return returns string.
   */
  public String toStringHelp(StringBuilder acc) {

    if (acc.toString().equals("")) {
      acc.append("");
    } else if (this.term.getCoefficient() > 0) {
      acc.append("+");
    }

    if (this.rest instanceof TermEmptyNode) {
      /*if (this.term.getCoefficient() > 0) {
        acc.append("+");
      }*/
      acc.append(this.term.toString());
      return acc.toString();
    }

    return this.rest.toStringHelp(acc.append(this.term.toString()).append(" "));
  }

  @Override
  public String toString() {

    return this.toStringHelp(new StringBuilder());
  }

  public Term getTerm() {
    return this.term;
  }

  public ListOfTerm getRest() {
    return this.rest;
  }



  @Override
  public int getDegree() {
    int acc = term.getDegree();
    return (acc);
  }

  /**
   * Helper for the equals method.
   * @param t represents object of type list.
   * @return if lists are equal in true or false.
   */
  public boolean equalHelper(ListOfTerm t) {
    if (this.term.equals(t.getTerm())) {
      return this.rest.equalHelper(t.getRest());
    } else {
      return false;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof ListOfTerm) {
      ListOfTerm t = (ListOfTerm) o;
      //return this.term.equals(t.getTerm()) && this.rest.equals(t.getRest());
      return this.equalHelper(t) ;
    } else {
      throw new IllegalArgumentException("not an instance");
    }
    //return false;
  }

  @Override
  public int hashCode() {
    return 1;
  }
}


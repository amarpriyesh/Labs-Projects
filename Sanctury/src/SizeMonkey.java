/**
 * The below class represents Monkey SIze which is of enum type.
 */
public enum SizeMonkey {
  S(1), M(5), L(10);
  private int description;

  SizeMonkey(int description) {
    this.description = description;
  }

  public int getValue() {
    return this.description;
  }
}

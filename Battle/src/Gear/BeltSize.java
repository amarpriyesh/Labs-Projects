package Gear;

/**
 * Represents belt size in S,M,L.
 */
public enum BeltSize {
  SMALL(1), MEDIUM(2), LARGE(4);
  private final int description;

  BeltSize(int description) {
    this.description = description;
  }

  public int getValue() {
    return this.description;
  }
}

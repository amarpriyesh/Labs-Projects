package weapon;

/**
 * Represents  swords.
 */
public class TwoHandedSword extends Sword {

  /**
   * default constructor.
   */
  public TwoHandedSword() {
    super(8, 12, "TwoHandedSword");
  }

  /**
   * loaded constructor.
   * @param halfDamage damage.
   */
  public TwoHandedSword(int halfDamage) {
    super(8 / halfDamage, 12 / halfDamage, "TwoHandedSword");
  }
}

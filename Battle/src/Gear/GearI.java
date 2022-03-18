package Gear;

/**
 * Represents Gear.Gear Interface.
 */
public interface GearI extends Comparable<GearI> {

  /**
   * returns strength.
   * @return strength.
   */
  int getStrength();

  /**
   * returns constution.
   * @return constitution.
   */
  int getConstitution();

  /**
   * Returns dexterity.
   * @return dexterity.
   */
  int getDexterity();

  /**
   * return charisma.
   * @return charisa.
   */
  int getCharisma();

  /**
   * returns diminishing values.
   * @returndiminishing values.
   */
  boolean isDiminishing();

  /**
   * Returns belt size.
   * @return belt size in Size type.
   */
  public BeltSize getSize();

  /**
   * returnSizeBelt in int.
   * @return size of belt in int.
   */
  public int returnSizeBelt();

  /**
   * Returns nanme.
   * @return name.
   */
  String getName();

  //public String toString();
}

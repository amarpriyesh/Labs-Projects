package Gear;

/**
 * The class represents the Gear.Gear Gear.Belt.
 */
public class Belt extends Gear {


  public BeltSize size;

  /**
   * Initialize the belt params.
   * @param name name of the gear.
   * @param isDiminishing if the gear diminishes the strength.
   * @param strength strength values affected.
   * @param constitution values affected.
   * @param dexterity values affected.
   * @param charisma values affected.
   * @param size values affected.
   */
  public Belt(String name, boolean isDiminishing, int strength, int constitution,
              int dexterity, int charisma, BeltSize size) {
    super(name, isDiminishing, strength, constitution, dexterity, charisma);
    this.size = size;
  }

  @Override
  public String toString() {
    return String.format("%s, Belt Size %d", super.toString(), this.size.getValue());
  }

  @Override
  protected int compareHeadGear(Headgear o) {
    return -1;
  }

  @Override
  protected int comparePotion(Potion o) {
    return -1;
  }


  @Override
  protected int compareBelt(Belt o) {
    return o.getName().compareTo(this.getName());

  }

  @Override
  protected int compareFootWear(Footwear o) {

    return 1;

  }

  @Override
  public int compareTo(GearI o) {

    if (o instanceof Gear) {
      Gear ab = (Gear) o;
      return ab.compareBelt(this);
    }
    return 1;
  }

  @Override
  public boolean equals(Object o) {
    return (o instanceof Belt && ((Belt) o).getName().equals(this.getName()));
  }

  @Override
  public int hashCode() {
    return Long.hashCode(1);
  }

  /**
   * Returns size of the belt.
   * @return int size.
   */
  @Override
  public int returnSizeBelt() {
    return this.size.getValue();
  }

  @Override
  public BeltSize getSize() {
    return size;
  }
}

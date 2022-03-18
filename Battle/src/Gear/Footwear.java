package Gear;

/**
 * Represents footwear.
 */
public class Footwear extends Gear {

  /**
   * COnstructor to initialize following parameter.
   * @param name name.
   * @param isDiminishing boolean diminishing.
   * @param strength strength affected.
   * @param constitution constitution affected.
   * @param dexterity values affected.
   * @param charisma values afected.
   */
  public Footwear(String name, boolean isDiminishing, int strength, int constitution,
                  int dexterity, int charisma) {
    super(name, isDiminishing, strength, constitution, dexterity, charisma);
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
    return -1;

  }

  @Override
  protected int compareFootWear(Footwear o) {

    return o.getName().compareTo(this.getName());

  }

  @Override
  public int compareTo(GearI o) {

    if (o instanceof Gear) {
      Gear ab = (Gear) o;
      return ab.compareFootWear(this);
    }
    return 1;
  }

  @Override
  public boolean equals(Object o) {
    return (o instanceof Footwear && ((Footwear) o).getName().equals(this.getName()));
  }

  @Override
  public int hashCode() {
    return Long.hashCode(1);
  }
}

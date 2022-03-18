package Gear;

/**
 * Represents types of gear.
 */
public class Potion extends Headgear {

  /**
   * Constructor to initialize following parameter.
   * @param name name.
   * @param isDiminishing boolean diminishing.
   * @param strength strength affected.
   * @param constitution constitution affected.
   * @param dexterity values affected.
   * @param charisma values afected.
   */
  public Potion(String name, boolean isDiminishing, int strength, int constitution,
                int dexterity, int charisma) {
    super(name, isDiminishing, strength, constitution, dexterity, charisma);
  }

  @Override
  protected int compareHeadGear(Headgear o) {
    return -1;
  }

  @Override
  protected int comparePotion(Potion o) {
    return o.getName().compareTo(this.getName());
  }


  @Override
  protected int compareBelt(Belt o) {
    return 1;


  }

  @Override
  protected int compareFootWear(Footwear o) {

    return 1;

  }

  @Override
  public int compareTo(GearI o) {

    if (o instanceof Gear) {
      Gear ab = (Gear) o;
      return ab.comparePotion(this);
    }
    return 1;
  }

  @Override
  public boolean equals(Object o) {
    return (o instanceof Potion && ((Potion) o).getName().equals(this.getName()));
  }

  @Override
  public int hashCode() {
    return Long.hashCode(1);
  }
}

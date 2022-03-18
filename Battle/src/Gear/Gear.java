package Gear;

/**
 * The class represents the super class for the available gears.
 */
public abstract class Gear implements GearI {
  private boolean isDiminishing;
  private final int strength;
  private final int constitution;
  private final int dexterity;
  private final int charisma;
  private final String name;

  /**
   * Constructor to initialize following parameter.
   * @param name name.
   * @param isDiminishing boolean diminishing.
   * @param strength strength affected.
   * @param constitution constitution affected.
   * @param dexterity values affected.
   * @param charisma values afected.
   */
  public Gear(String name, boolean isDiminishing, int strength, int constitution, int dexterity,
              int charisma) {
    this.strength = strength;
    this.constitution = constitution;
    this.dexterity = dexterity;
    this.charisma = charisma;
    this.name = name;
    this.isDiminishing = isDiminishing;
  }

  public String getName() {
    return name;
  }

  public int getStrength() {
    return strength;
  }

  public int getConstitution() {
    return constitution;
  }

  public int getDexterity() {
    return dexterity;
  }

  public int getCharisma() {
    return charisma;
  }

  public boolean isDiminishing() {
    return isDiminishing;
  }

  /*public void setDiminishing(boolean diminishing) {
    isDiminishing = diminishing;
  }*/

  @Override
  public String toString() {
    return String.format("Name: %s, Strength %d, Constitution %d, Dexterity %d, Charisma %d",
            name, strength, constitution, dexterity, charisma);
  }


  protected int compareHeadGear(Headgear o) {
    return 1;
  }


  protected int comparePotion(Potion o) {
    return 1;
  }


  protected int compareBelt(Belt o) {

    return 1;
  }

  protected int compareFootWear(Footwear o) {

    return 1;

  }


  @Override
  public int compareTo(GearI o) {
    return 0;
  }

  /**
   * Returns belt size.
   * @return belt size.
   */
  public int returnSizeBelt() {
    return 0;
  }

  public BeltSize getSize() {
    return null;
  }



}

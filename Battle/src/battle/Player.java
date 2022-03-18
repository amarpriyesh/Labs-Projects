package battle;

import Gear.GearI;
import weapon.WeaponI;

/**
 * The class represents the player playing in the arena.
 */
public class Player {

  //RandGen obj = new RandGen();
  private int strength;
  private int constitution;
  private int dexterity;
  private int charisma;
  private final String name;
  private GearI[] gear;
  private WeaponI weapon;
  private int health;
  private Boolean isActive;

  /**
   * The below constructor initialises the below fields.
   *
   * @param strength strength.
   * @param constitution const.
   * @param dexterity dexterity.
   * @param charisma charisma.
   */
  public Player(int strength, int constitution, int dexterity, int charisma, String name) {
    this.strength = strength;
    this.constitution = constitution;
    this.dexterity = dexterity;
    this.charisma = charisma;
    this.name = name;
    this.health = this.strength + this.constitution + this.dexterity + this.charisma;
  }

  /**
   * battle.Player constructor.
   * @param other to create a deep copy of the player.
   */
  public Player(Player other) {
    this.strength = other.strength;
    this.constitution = other.constitution;
    this.dexterity = other.dexterity;
    this.charisma = other.charisma;
    this.name = other.name;
    this.health = this.strength + this.constitution + this.dexterity + this.charisma;
  }

  /**
   * Returns state of the player.
   * @return state.
   */
  public Boolean getActive() {
    return this.isActive;
  }

  /**
   * returns gear of the player.
   * @return gear.
   */
  public GearI[] getGear() {
    if (this.gear == null) {
      throw new IllegalArgumentException("Gears have not been assigned to the player yet");
    }
    return this.gear;
  }

  /**
   * sets the player active.
   * @param active set flag.
   */
  public void setActive(Boolean active) {
    this.isActive = active;
  }

  @Override
  public String toString() {
    String weaponName;
    if (this.weapon == null) {
      weaponName = "";
    } else {
      weaponName = this.weapon.getName();
    }
    return String.format("Player name: %s , strength %d, constitution %d, dexterity %d, charisma"
                    +
                    " %d Health %d, Weapon %s", this.name, this.strength, this.constitution,
            this.dexterity, this.charisma, this.health, weaponName);
  }

  @Override
  public boolean equals(Object o) {
    return (o instanceof Player && ((Player) o).getName().equals(this.getName()));
  }

  @Override
  public int hashCode() {
    return Long.hashCode(1);
  }

  public int getHealth() {

    return this.health;
  }

  protected void setHealth(int damage) {

    this.health = this.health - damage;

  }

  protected void calHealth() {
    //TODO remove
    //System.out.println(Arrays.toString(gear));
    for (int i = 0; i < this.gear.length; i++) {
      this.charisma = this.charisma + gear[i].getCharisma();
      this.strength = this.strength + gear[i].getStrength();
      this.dexterity = this.dexterity + gear[i].getDexterity();
      this.constitution = this.constitution + gear[i].getConstitution();
    }
    this.health = this.charisma + this.strength + this.constitution + this.dexterity;
  }

  protected int getCharisma() {
    return this.charisma;
  }

  /**
   * Returns the striking power.
   * @return striking power.
   */
  public int getStrikingPower() {
    int strikePower = 0;
    strikePower = this.strength + Arena.OBJ.nextInt(1, 10) + randomWeaponStrength();
    return strikePower;
  }

  private int randomWeaponStrength() {
    int i = Arena.OBJ.nextInt(0,19);
    while (this.gear[i].getStrength() != 0) {
      i = Arena.OBJ.nextInt(0,19);
    }
    return this.gear[i].getStrength();
  }

  private int randomWeaponDexterity() {
    int i = Arena.OBJ.nextInt(0,19);
    while (this.gear[i].getDexterity() != 0) {
      i = Arena.OBJ.nextInt(0,19);
    }
    return this.gear[i].getDexterity();
  }

  /**
   * Sets player gear.
   * @param gear type Gear.
   */
  public void setGear(GearI[] gear) {
    this.gear = gear;
  }

  /**
   * Returns getAvoidanceAbility of the player.
   * @return avoidance ability in int.
   */
  public int getAvoidanceAbility() {
    int avoidance = 0;
    avoidance = this.dexterity + Arena.OBJ.nextInt(1, 6) + randomWeaponDexterity();
    return avoidance;
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

  public WeaponI getWeapon() {
    return weapon;
  }

  protected void setWeapon(WeaponI obj) {
    this.weapon = obj;
  }

  public String getName() {
    return name;
  }

}

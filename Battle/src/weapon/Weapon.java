package weapon;

import battle.Arena;

/**
 * Represents weapon.Weapon.
 */
public class Weapon implements WeaponI {
  //RandGen obj = new RandGen();

  private int damage;
  private final int lowerBound;
  private final int upperBound;
  private final String name;
  private int halfDamage;

  /**
   * Constructor taking bounds.
   * @param lowerBound lb.
   * @param upperBound ub.
   * @param name name.
   */
  public Weapon(int lowerBound, int upperBound, String name) {
    this.lowerBound = lowerBound;
    this.upperBound = upperBound;
    this.name = name;
    halfDamage = 1;
  }

  /**
   * return Damage.
   * @return damage.
   */
  public int getDamage() {
    return damage;
  }

  /**
   * Returns the damage value.
   * @return damage.
   */
  @Override
  public int generateDamage() {
    this.damage = Arena.OBJ.nextInt(lowerBound / halfDamage, upperBound / halfDamage);
    return this.damage;
  }



  /**
   * returns name of the weapon.
   * @return name.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the weapon capability to do  the half damage.
   *
   * @param a
   * @return
   */
  @Override
  public void setHalfDamage(int a) {
    this.halfDamage = a;
  }
}

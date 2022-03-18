package weapon;

/**
 * Represents weapon interface.
 */
public interface WeaponI {

  /**
   * Returns damages.
   * @return damages.
   */
  int generateDamage();

  /**
   * Returns weapon name.
   * @return weapon name.
   */
  String getName();

  /**
   * Sets the weapon capability to do  the half damage.
   * @return
   */
  public void setHalfDamage(int a);


}

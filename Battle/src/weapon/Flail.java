package weapon;

/**
 * Represents class of weapons flails.
 */
public class Flail extends Weapon {

  /**
   * constructor for full damage.
   */
  public Flail() {

    super(8, 12, "Flail");

  }

  /**
   * constructor for half damage.
   */
  public Flail(int halfDamage) {

    super(8 / halfDamage, 12 / halfDamage, "Flail");

  }


}


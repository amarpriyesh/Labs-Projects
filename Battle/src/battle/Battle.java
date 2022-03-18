package battle;

import Gear.GearI;

/**
 * The class represents interface for battle.Arena.
 */
public interface Battle {
  /**
   * The method returns player desc.
   * @return player desc.
   */
  String playerDescription();

  /**
   * Decides which player to go first.
   * @return result of the toss.
   */
  String toss();

  /**
   * Sets weapon for the player.
   */
  void setWeapon();

  /**
   * Chooses the next player.
   */
  void nextTurn();

  /**
   * Attacks the player.
   */
  void strike();

  /**
   * Starts the battle.
   */
  void battleStart();

  /**
   * Gets the current state of the game.
   * @return Game state.
   */
  GameState getState();

  /**
   * sets gear for the player.
   */
  void setGear();

  /**
   * Sets up game for the battle.
   */
  void gameSetup();

  /**
   * Prints the logs of the game.
   * @return String.
   */
  String printLog();

  /**
   * REturns active player of Player type.
   * @return Player.
   */
  public Player getActivePlayer();

  /**
   * Returns inactive player of Player type.
   * @return Player.
   */
  public Player getInActivePlayer();

  /**
   * Tests dice outcome.
   * @return numbers 2 - 6.
   */
  public int rollDice();

  /**
   * Returns top three outcomes of the dice.
   * @return SUm of top three outcomes.
   */
  public int returnAbility();

  /**
   * Returns Gear bag.
   * @return gear bag.
   */
  public  GearI[] getGearBag();

  /**
   * Returns selected gear.
   * @return selected gear.
   */
  public  GearI[] gearSelect();

  /**
   * Returns actual damage.
   * @return actual damage.
   */
  public int getActualDamage();

  /**
   * Returns potential damage caused by the weapon.
   * @return potential damage.
   */
  public int potentialDamage();

  /**
   * Returns actual damage.
   * @return actual damage.
   */
  public int actualDamage();

  /**
   * Returns defending power of the opponent.
   * @return defending power.
   */
  public int defendingPowerArena();

  /**
   * Returns attacking power of the opponent.
   * @return attacking power.
   */
  public int strikingPowerArena();


  //public int rollDice(); TODO
}

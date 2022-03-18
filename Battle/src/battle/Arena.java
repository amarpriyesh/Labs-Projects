package battle;

import Gear.GearI;
import weapon.WeaponI;

import java.util.Arrays;

/**
 * The class controls the game movement and provides method to create two player.
 */
public class Arena implements Battle {


  public static RandGen OBJ; //Public as it is used in Weapon package as well.
  StringBuilder sb;
  private Player p1;
  private Player p2;
  private Player active;
  private Player inActive;
  private GameState state;
  private int actualDamage;
  private int repeat ;
  private final Player p1Ref;
  private final Player p2Ref;
  private int countKatana;
  private int potentialDamage;
  private int strikingPower;
  private int avoidanceAbility;





  /**
   * The below constructor creates two player  and creates a deep copy of them for rematch.
   *
   * @param player1 name of player1.
   * @param player2 name of player2.
   */
  public Arena(String player1, String player2) {

    if ((player1 == null || player2 == null)) {
      throw new IllegalArgumentException("Players can't be null");
    }
    OBJ = new RandGen();

    p1 = new Player(returnAbility(), returnAbility(), returnAbility(),
            returnAbility(), player1);
    p2 = new Player(returnAbility(), returnAbility(), returnAbility(),
            returnAbility(), player2);
    p1Ref = new Player(p1);
    p2Ref = new Player(p2);
    sb = new StringBuilder();
    sb.append("Welcome to the Battle, here two players P1 and P2 will be contesting.");
    sb.append("\n");

    repeat = 0;
    countKatana = 0;
  }

  /**
   * The below constructor creates two player  and creates a deep copy of them for rematch.
   *
   * @param player1 name of player1.
   * @param player2 name of player2.
   * @param seed Seed for random val
   */
  public Arena(String player1, String player2,int seed) {
    if ((player1 == null || player2 == null)) {
      throw new IllegalArgumentException("Players can't be null");
    }
    OBJ = new RandGen(seed);

    p1 = new Player(returnAbility(), returnAbility(), returnAbility(),
            returnAbility(), player1);
    p2 = new Player(returnAbility(), returnAbility(), returnAbility(),
            returnAbility(), player2);
    p1Ref = new Player(p1);
    p2Ref = new Player(p2);
    sb = new StringBuilder();
    sb.append("Welcome to the Battle, here two players P1 and P2 will be contesting.");
    sb.append("\n");
  }

  /**
   * The method sets up the  reference player for every rematch.
   */
  public void gameSetup() {
    p1 = new Player(p1Ref);
    p2 = new Player(p2Ref);
    active = p1;
    inActive = p2;
    active.setActive(Boolean.TRUE);
    inActive.setActive(Boolean.FALSE);
    state = GameState.SETUP;
    sb.append("---------Below Players Created:------------");
    sb.append("\n");
    sb.append(active);
    sb.append("\n");
    sb.append(inActive);
    sb.append("\n");
    sb.append("\n");
  }

  @Override
  public String printLog() {
    return sb.toString();
  }

  /**
   * The below method sets gear for the current player and adds up the abilities corresponding
   * to every gear.
   */
  public void setGear() {
    sb.append("\n");
    sb.append("---------Setting up below player:------------");
    sb.append("\n");
    sb.append(active);
    sb.append("\n");
    active.setGear(new CreateGear().gearSelect());
    active.calHealth();

    sb.append("\n");
    sb.append("-------Printing the gears assigned in sorted order--------");
    sb.append("\n");
    sb.append("\n");
    GearI[] gearList =  active.getGear();
    int i = 0;
    Arrays.sort(gearList);

    while (i < 20) {
      sb.append(gearList[i]);
      sb.append("\n");
      i++;
    }

    sb.append("\n");
    sb.append("\n");
    sb.append("---------Player abilities after gears have been assigned:------------");
    sb.append("\n");
    sb.append(active);
    sb.append("\n");
    sb.append("\n");
  }


  /**
   * The below method sets up weapon for  the current player.
   */
  public void setWeapon() {
    WeaponI[] weaponList = new CreateGear().getWeaponList();
    int randWeapon = OBJ.nextInt(0, 4);
    WeaponI weaponName = weaponList[randWeapon];
    int halfDamage = 1;
    if ((active.getStrength() <= 14 && weaponName.getName().equals("TwoHandedSword"))
            || (active.getDexterity()
            <= 14 && weaponName.getName().equals("Flail"))) {
      weaponName.setHalfDamage(2);
    }

    if (weaponName.getName().equals("Katana")) {
      active.setWeapon(weaponName);
    } else if (weaponName.getName().equals("TwoHandedSword")) {
      active.setWeapon(weaponName);
    } else if (weaponName.getName().equals("BroadSword")) {
      active.setWeapon(weaponName);
    } else if (weaponName.getName().equals("Flail")) {
      active.setWeapon(weaponName);
    } else {
      active.setWeapon(weaponName);
    }
    sb.append("------------weapon.Weapon--------------");
    sb.append("\n");
    sb.append(String.format("%s weapon has been assigned to player %s",
            active.getWeapon().getName(),active.getName()));
    sb.append("\n");
    sb.append("\n");
    sb.append("\n");
  }

  /**
   * The method decides which layer will strike first based upon the dice values.
   *
   * @return battle.Player name
   */
  public String toss() {
    if (p1.getCharisma() > p2.getCharisma()) {
      active = p1;
      inActive = p2;
      p1.setActive(Boolean.TRUE);
      p2.setActive(Boolean.FALSE);
      sb.append("-----------TOSS---------");
      sb.append("\n");
      sb.append(String.format("%s player won the toss.",active.getName()));
      sb.append("\n");
      sb.append("----------------------------------------");
      sb.append("\n");
      return p1.getName();
    } else {
      active = p2;
      inActive = p1;
      p2.setActive(Boolean.TRUE);
      p1.setActive(Boolean.FALSE);
      sb.append("-----------TOSS---------");
      sb.append("\n");
      sb.append(String.format("%s player won the toss.",active.getName()));
      sb.append("\n");
      sb.append("----------------------------------------");
      sb.append("\n");
      return p2.getName();
    }


  }

  /**
   * Selects the other play for setup.
   */
  public void nextTurn() {
    if (p1.getActive()) {
      inActive = p1;
      active = p2;
      p1.setActive(Boolean.FALSE);
      p2.setActive(Boolean.TRUE);
    } else {
      active = p1;
      inActive = p2;
      p1.setActive(Boolean.TRUE);
      p2.setActive(Boolean.FALSE);
    }
    sb.append(active.getName());
    sb.append(" player is selected.");
    sb.append("\n");
    sb.append("----------------------------------------");
    sb.append("\n");
    sb.append("\n");

  }

  /**
   * Changes the state of the game to playing.
   */
  public void battleStart() {
    if ((active.getWeapon() == null || active.getGear() == null)
            || (inActive.getWeapon() == null || inActive.getGear() == null )) {
      throw new IllegalArgumentException("weapons and gears cant be null before the fight.");
    }
    if (state == GameState.SETUP) {
      state = GameState.PLAYING;
    }
  }

  /**
   * checks game state.
   *
   * @return state of the game.
   */
  private GameState setGameState() {
    if (p1.getHealth() > 0 && p2.getHealth() > 0) {
      state = GameState.PLAYING;
    } else if (p1.getHealth() > 0 && p2.getHealth() <= 0) {
      sb.append(p1.getName());
      sb.append(" Won the battle");
      sb.append("\n");
      state = GameState.P1WIN;
    } else if (p1.getHealth() <= 0 && p2.getHealth() > 0) {
      sb.append(p2.getName());
      sb.append(" Won the battle");
      sb.append("\n");
      state = GameState.P2WIN;
    } else if (p1.getHealth() <= 0 && p2.getHealth() <= 0) {
      state = GameState.DRAW;
    }

    return state;
  }

  /**
   * In case of repeated runs.
   * @return state of the game.
   */
  private GameState repeatState() {
    state = GameState.DRAW;


    return state;
  }


  /**
   * Returns the state of the game.
   *
   * @return state.
   */
  public GameState getState() {
    return state;
  }

  /**
   * Calculates the actual damage.
   *
   * @return actual damage.
   */
  public int getActualDamage() {
    potentialDamage = 0;
    actualDamage = 0;
    potentialDamage = active.getStrength()
            +
            active.getWeapon().generateDamage();
    sb.append("Potential damage val: ");
    sb.append(potentialDamage);
    sb.append("\n");
    actualDamage = potentialDamage - inActive.getConstitution();
    sb.append("Actual damage val: ");
    sb.append(actualDamage);
    sb.append("\n");
    return actualDamage;
  }

  /**
   * The below method represents striking of player with weapon.
   */
  public void strike() {

    if (state == GameState.PLAYING) {
      strikingPower = active.getStrikingPower();
      avoidanceAbility = inActive.getAvoidanceAbility();
      sb.append("\n");
      sb.append(String.format("Striking Power of attacking player: %d",strikingPower
              ));
      sb.append("\n");
      sb.append(String.format("Avoidance Power of defending player: %d",
              avoidanceAbility));
      sb.append("\n");
      if (active.getStrikingPower() > inActive.getAvoidanceAbility()) {
        sb.append(String.format("%s Strikes, with weapon %s", active.getName(),
                active.getWeapon().getName()));
        sb.append("\n");

        if (getActualDamage() > 0) {
          inActive.setHealth(actualDamage);
          sb.append(String.format("%s, suffers %d loss of health, health remaining is: %d",
                  inActive.getName(), actualDamage,
                  inActive.getHealth()));
          sb.append("\n");
        }
        if (active.getWeapon().getName().equals("Katana") && countKatana < 1) {
          sb.append("Katana strikes twice");
          sb.append("\n");
          countKatana++;
          setGameState();
          strike();
        }
        if ( repeat > 50) {
          sb.append("The Game has gone into  a repeated state because both"
                  +
                  " the players could attack but the actual damage is zero or less in every case");
          sb.append("\n");
          repeatState();
        }
        repeat++;
        countKatana = 0;
        setGameState();
        nextTurn();
      } else {
        repeat++;
        sb.append(String.format("%s could not strike this time because of low Striking Power",
                active.getName()));
        sb.append("\n");
        setGameState();
        nextTurn();
        // Match goes on if both the actual damages less than zero
        if ( repeat > 50) {
          sb.append("The Game has gone into  a repeated state because both"
                  +
                  " the players could defend the attacks of each other or they could not attack");
          sb.append("\n");
          repeatState();
        }
      }

    }
    sb.append(String.format("State of Game: %s",state));
    sb.append("\n");
  }

  /**
   * The method returns player description.
   *
   * @return player signature.
   */
  public String playerDescription() {
    return active.toString();

  }

  /**
   * Returns value of actual damage.
   * @return damage.
   */
  public int actualDamage() {
    return actualDamage;
  }


  /**
   * Returns damage.
   * @return damage.
   */
  public int potentialDamage() {
    return potentialDamage;
  }

  /**
   * Returns ability to and decides player ability.
   * @return ability in the range 6 to 18.
   */
  public int returnAbility() {
    int abilityVal = 0;
    int[] arr = {rollDice(), rollDice(), rollDice(), rollDice()};
    Arrays.sort(arr);
    for (int i = 0; i < 3; i++) {
      abilityVal = abilityVal + arr[i];
    }
    return abilityVal;
  }

  /**
   * Returns value of dice.
   * @return val between 2 to 6.
   */
  public int rollDice() {
    int diceVal = 0;
    while (diceVal < 2) {
      diceVal = OBJ.nextInt(1, 6);
    }
    return diceVal;
  }

  /**
   * Returns active player.
   * @return active layer.
   */
  public Player getActivePlayer() {
    return active;
  }

  /**
   * Returns active player.
   * @return active layer.
   */
  public Player getInActivePlayer() {
    return inActive;
  }

  /**
   * Creates new gear bag.
   * @return Gear bag.
   */
  public  GearI[] getGearBag() {
    return new CreateGear().gearList();
  }

  /**
   * Returns selected gear.
   * @return selected gear.
   */
  public  GearI[] gearSelect() {
    return new CreateGear().gearSelect();
  }

  /**
   * Returns striking power.
   * @return striking power.
   */
  public int strikingPowerArena() {
    return strikingPower;
  }

  /**
   * Return defending power.
   * @return defending power of opponent.
   */
  public int defendingPowerArena() {
    return avoidanceAbility;
  }
}


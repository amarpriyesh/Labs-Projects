import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import battle.Arena;
import battle.Battle;
import Gear.BeltSize;
import battle.CreateGear;
import battle.GameState;
import Gear.GearI;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;


/**
 * The class tests the dummy run of program Battle.
 */
public class BattleTest {


  Battle bat = new Arena("P1", "P2", 75);


  /**
   * Sets up P1 by default.
   */
  @Before
  public void setUp() {
    bat.gameSetup();
    bat.setGear();
    bat.setWeapon();
    bat.nextTurn();
    bat.setGear();
    bat.setWeapon();
  }

  /**
   * The below methods  tests dice outcomes.
   */
  @Test
  public void rollDice() {
    int i = 0;
    while (i < 100) {
      assertTrue(bat.rollDice() <= 6 && bat.rollDice() >= 2);
      i++;
    }
  }

  /**
   * The below methods  tests  the ability outcome.
   */
  @Test
  public void testAbility() {
    int i = 0;
    while (i < 100) {
      assertTrue(bat.returnAbility() <= 18 && bat.returnAbility() >= 6);
      i++;
    }
  }

  /**
   * The method tests for validity of th created Player.
   */
  @Test
  public void player1Test() {

    assertEquals("Player name: P1 , strength 42, constitution 28, dexterity 29,"
            +
            " charisma 29 Health 128, Weapon Katana", bat.getInActivePlayer().toString());


  }

  /**
   * The method tests for validity of the created Player2.
   */
  @Test
  public void player2Test() {

    assertEquals("Player name: P2 , strength 26, constitution 22, dexterity 30,"
            +
            " charisma 25 Health 103, Weapon TwoHandedSword", bat.getActivePlayer().toString());
  }

  /**
   * The method tests if gear is created for the user P1 and P2.
   */
  @Test
  public void testGear() {
    Battle bat = new Arena("P1", "p2", 75);
    bat.gameSetup();
    //System.out.println(bat.playerDescription());
    bat.setGear();
    bat.getActivePlayer().getGear();
    //System.out.println(bat.playerDescription());

    Battle bat2 = new Arena("P1", "p2", 75);
    bat2.gameSetup();
    bat2.setGear();
    bat2.getActivePlayer().getGear();

    assertEquals(bat.getActivePlayer().getGear(), bat2.getActivePlayer().getGear());
  }

  /**
   * The below method tests if the player had abilities and if they got incresed after assigning
   * the gears.
   */
  @Test
  public void testPlayerEntry() {
    Battle bat = new Arena("P1", "P2", 75);
    bat.gameSetup();
    assertEquals("Player name: P1 , strength 14, constitution 14, dexterity 9,"
            +
            " charisma 14 Health 51, Weapon ", bat.playerDescription());
    bat.setGear();
    assertEquals("Player name: P1 , strength 42, constitution 28, dexterity 29,"
            +
            " charisma 29 Health 128, Weapon ", bat.playerDescription());
    bat.setWeapon();
    assertEquals("Player name: P1 , strength 42, constitution 28, dexterity 29,"
            +
            " charisma 29 Health 128, Weapon Katana", bat.playerDescription());

    bat.nextTurn();
    assertEquals("Player name: P2 , strength 14, constitution 9,"
            +
            " dexterity 11, charisma 12 Health 46, Weapon ", bat.playerDescription());

    bat.setGear();
    assertEquals("Player name: P2 , strength 26, constitution 22, dexterity 30,"
            +
            " charisma 25 Health 103, Weapon ", bat.playerDescription());
    bat.setWeapon();
    assertEquals("Player name: P2 , strength 26, constitution 22,"
                    +
                    " dexterity 30, charisma 25 Health 103, Weapon TwoHandedSword",
            bat.playerDescription());
    //Since charisma is 31 for P1, P1 will win the toss.
    assertEquals("P1", bat.toss());


    bat.battleStart();
    //Since actual damage is 42 player strikes
    bat.strike();
    assertEquals(43, bat.strikingPowerArena());

    assertEquals(31, bat.defendingPowerArena());
    assertEquals(47, bat.potentialDamage());


    //actual damage is potential - constitution i.e 42.
    //System.out.println(bat.potentialDamage());
    assertEquals(25, bat.actualDamage());
    //P2 health should get reduced by 42 and hence the remaining health should be 58.
    //The player becomes active as the program automatically set the turn for P2.
    assertEquals(54, bat.getInActivePlayer().getHealth());
    assertEquals("Player name: P2 , strength 26, constitution 22, dexterity 30,"
            +
            " charisma 25 Health 54, Weapon TwoHandedSword", bat.getInActivePlayer().toString());
    int j = 0;
    while (bat.getState() == GameState.PLAYING) {
      bat.strike();
    }
    //after the match the game could again setup the two player to their actual health.
    bat.gameSetup();
    assertEquals("Player name: P1 , strength 14, constitution 14, dexterity 9,"
            +
            " charisma 14 Health 51, Weapon ", bat.playerDescription());
    assertEquals("Player name: P2 , strength 14, constitution 9,"
            +
            " dexterity 11, charisma 12 Health 46, Weapon ", bat.getInActivePlayer().toString());


  }

  /**
   * Tests the property of headgear.
   */
  @Test
  public void testHeadGear() {

    for (GearI item : bat.getGearBag()
    ) {
      if (item.getName().contains("Headgear")) {
        assertTrue(item.getConstitution() >= -6 && item.getConstitution() <= 6);
        assertTrue(item.getDexterity() == 0);
        assertTrue(item.getCharisma() == 0);
        assertTrue(item.getStrength() == 0);
      }
    }

  }


  /**
   * The method checks if the belt adds up to unit which is less than 10.
   */
  @Test
  public void testBeltSize() {
    int i = 0;
    for (GearI item : bat.gearSelect()
    ) {
      if (item.getName().contains("Belt") && (item.getSize().equals(BeltSize.LARGE)
              || item.getSize().equals(BeltSize.SMALL) || item.getSize().equals(BeltSize.MEDIUM))) {

        i = i + item.returnSizeBelt();
      }
    }
    assertTrue(i <= 10 && i > 0);

  }

  /**
   * The method tests if potions affect any of the player ability.
   */
  @Test
  public void testPotion() {
    int strength = 0;
    int dexterity = 0;
    int constitution = 0;
    int charisma = 0;
    for (GearI item : bat.getGearBag()
    ) {

      if (1 == 1) { //item.getName().contains("Potion")
        if (item.getConstitution() != 0) {
          constitution++;
        } else if (item.getStrength() != 0) {
          strength++;
        } else if (item.getDexterity() != 0) {
          dexterity++;
        } else if (item.getCharisma() != 0) {
          charisma++;
        }
      }
    }

    assertTrue(charisma > 0 && dexterity > 0 && strength > 0 && constitution > 0);
  }


  /**
   * The method tests if the foot wear is selected in pair.
   */
  @Test
  public void testFootWear() {
    int count = 0;
    for (GearI item : bat.gearSelect()
    ) {
      if (item.toString().contains("Footwear")) {
        count++;
        assertTrue(item.getConstitution() == 0);
        assertTrue(item.getStrength() == 0);
        assertTrue(item.getCharisma() == 0);
      }

    }

    assertTrue((count % 2) == 0);
  }

  /**
   * Tests selection of weapon.
   */
  @Test
  public void testWeaponSelection() {

    int i = 0;

    while (i < 100) {
      bat.setWeapon();
      assertTrue(("Katana,Flail,Axe,BroadSword,"
              +
              "TwoHandedSword").contains(bat.getActivePlayer().getWeapon().getName()));
      i++;
    }
  }

  /**
   * Tests the items in the gearBag, if it is as per specification.
   */
  @Test
  public void testGearBagItemNumber() {

    int p = 0;
    int h = 0;
    int b = 0;
    int f = 0;

    for (GearI item : bat.getGearBag()
    ) {
      if (item.getName().contains("Potion")) {
        p++;
      } else if (item.getName().contains("Headgear")) {
        h++;
      } else if (item.getName().contains("Footwear")) {
        f++;
      } else if (item.getName().contains("Belt")) {
        b++;
      }


    }
    assertTrue(h >= 5 && f >= 5 && p >= 15 && b >= 15);
  }



  /**
   * Tests weapon set.
   */
  @Test
  public void testSetWeapon() {
    bat.gameSetup();
    bat.setWeapon();
    assertEquals("Flail", bat.getActivePlayer().getWeapon().getName());
  }

  /**
   * Tests how many gears are diminishing.
   */
  @Test
  public void testGearDiminishVal() {
    Battle ab = new Arena("P1", "P2");
    GearI[] arr = ab.getGearBag();
    int diminishingItems = 0;
    int items = 0;
    for (GearI item : arr
    ) {
      if (item.isDiminishing()) {
        diminishingItems++;
      } else {
        items++;
      }
    }
    assertEquals(25, diminishingItems * 100 / (diminishingItems + items));
  }

  /**
   * Tests the battles without assigning weapon to player.
   */
  @Test( expected = IllegalArgumentException.class)
  public void testBattleWithoutWeapon() {
    Battle ab1 = new Arena("P1","P2",75);
    ab1.gameSetup();
    ab1.setGear();
    ab1.battleStart();
  }

  /**
   * Tests the battles without assigning gear to player.
   */
  @Test( expected = IllegalArgumentException.class)
  public void testBattleWithoutGear() {
    Battle ab1 = new Arena("P1","P2",75);
    ab1.gameSetup();
    ab1.setWeapon();
    ab1.battleStart();
  }

  /**
   * The below test sorts the arrays of gear selected and equate it for equality.
   */
  @Test
  public void testGearSort() {
    Battle ab1 = new Arena("P1", "P2", 30);
    GearI[] arr = ab1.gearSelect();
    Arrays.sort(arr);

    Battle ab2 = new Arena("P1", "P2", 30);
    GearI[] arr2 = ab2.gearSelect();
    Arrays.sort(arr2);

    assertEquals(arr,arr2);

  }

  /**
   * Tests weapon damage  when dexterity is greater than 8.
   */
  @Test
  public void testWeaponDamage() {
    assertEquals(bat.getActivePlayer().getWeapon().getName(),"TwoHandedSword");
    assertTrue(bat.getActivePlayer().getWeapon().generateDamage() >= 8
             && bat.getActivePlayer().getWeapon().generateDamage() <= 12 );
    //System.out.println(ab.p1.getHealth()+"  "+ab.p2.getHealth()); TODO

  }

  /**
   * Tests weapon damage  when dexterity is greater than 8.
   */
  @Test
  public void testWeaponDamageAnotherWeapon() {
    assertEquals(bat.getInActivePlayer().getWeapon().getName(),"Katana");
    assertTrue(bat.getInActivePlayer().getWeapon().generateDamage()  >= 4
            && bat.getInActivePlayer().getWeapon().generateDamage() <= 8 );
    //System.out.println(ab.p1.getHealth()+"  "+ab.p2.getHealth()); TODO

  }

  /**
   * Tests weapon damage  when dexterity is greater than 8.
   */
  @Test
  public void testWeaponAxe() {
    Battle new1 = new Arena("p1","p2",1);
    new1.gameSetup();
    new1.setWeapon();
    assertEquals(new1.getActivePlayer().getWeapon().getName(),"Axe");
    assertTrue(new1.getActivePlayer().getWeapon().generateDamage()  >= 4
            && new1.getActivePlayer().getWeapon().generateDamage() <= 8 );
    //System.out.println(ab.p1.getHealth()+"  "+ab.p2.getHealth()); TODO

  }

  /**
   * Test weapon damage Axe.
   */
  @Test
  public void testWeaponBroadSword() {
    Battle new1 = new Arena("p1","p2",2);
    new1.gameSetup();
    new1.setWeapon();
    assertEquals(new1.getActivePlayer().getWeapon().getName(),"BroadSword");
    assertTrue(new1.getActivePlayer().getWeapon().generateDamage()  >= 6
            && new1.getActivePlayer().getWeapon().generateDamage() <= 10 );
    //System.out.println(ab.p1.getHealth()+"  "+ab.p2.getHealth()); TODO

  }

  /**
   * Test damage Flail.
   */
  @Test
  public void testWeaponFlail() {
    Battle new1 = new Arena("p1","p2",5);
    new1.gameSetup();
    new1.setWeapon();
    assertEquals(new1.getActivePlayer().getDexterity(),10);
    assertEquals(new1.getActivePlayer().getWeapon().getName(),"Flail");
    assertTrue(new1.getActivePlayer().getWeapon().generateDamage()  >= 4
            && new1.getActivePlayer().getWeapon().generateDamage() <= 6 );
    //System.out.println(ab.p1.getHealth()+"  "+ab.p2.getHealth()); TODO

  }
  @Test
  public void testGears() {
    CreateGear obj = new CreateGear();
    Arrays.sort(obj.gearList());
    for (GearI item:obj.gearList()
         ) {
      System.out.println(item.toString());

    }
  }
}



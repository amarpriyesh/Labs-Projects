package battle;

import Gear.Belt;
import Gear.BeltSize;
import Gear.Footwear;
import Gear.GearI;
import Gear.Headgear;
import Gear.Potion;
import weapon.Axe;
import weapon.BroadSword;
import weapon.Flail;
import weapon.Katana;
import weapon.TwoHandedSword;
import weapon.WeaponI;

/**
 * This is a helper class to battle.Arena to create bag of gears and to fetch 20
 * gears required by the class.
 */
public class CreateGear {

  private final int bagSize;
  private GearI[] gearBag;
  private boolean isDiminishing;
  //RandGen obj = new RandGen();
  private int countHeadgears;
  private int countFootwears;
  private int countBelts;
  private int countPotions;
  private int h;
  private int f;
  private int b;
  private int p;
  private int itemCount;
  //TODO assumption
  private int[] multiplierDiminishing;
  private int[] multiplierAbilities;
  private int strength;
  private int constitution;
  private int dexterity;
  private int charisma;
  private BeltSize size;

  /**
   * This represents the constructor to initialize the required variables.
   */
  public CreateGear() {
    h = 0;
    f = 0;
    b = 0;
    p = 0;
    itemCount = 0;
    bagSize = 56;
    //arr = new int[4];
    gearBag = new GearI[56];
    isDiminishing = false;
    countHeadgears = 5;
    countFootwears = 5;
    countBelts = 15;
    countPotions = 17;

  }

  private void calAbility() {
    strength = (Arena.OBJ.nextInt(1, 6)) * multiplierAbilities[0] * multiplierDiminishing[0];
    constitution = (Arena.OBJ.nextInt(1, 6)) * multiplierAbilities[1] * multiplierDiminishing[1];
    dexterity = (Arena.OBJ.nextInt(1, 6)) * multiplierAbilities[2] * multiplierDiminishing[2];
    charisma = (Arena.OBJ.nextInt(1, 6)) * multiplierAbilities[3] * multiplierDiminishing[3];
    multiplierAbilities = new int[]{1, 1, 1, 1};
    //multiplierDiminishing = new int[]{1,1,1,1};
  }

  /**
   * Creates list of 56 gears.
   * @return Gears.
   */
  public GearI[] gearList() {

    while (itemCount < bagSize) {

      gearBag[itemCount] = gear(isDiminishing);
      if (itemCount == 42) {
        countHeadgears = 100;
        countFootwears = 100;
        countBelts = 100;
        countPotions = 100;
        isDiminishing = true;

        break;
      }
    }
    while (itemCount < bagSize) {

      gearBag[itemCount] = gear(isDiminishing);
    }


    //System.out.println(h+" head "+b+" belt "+p+" potion "+f+ " foot wear");
    //TODO  (create a for loop with teh above consts )players to equip themselves from a bag
    // of equipment that contains a
    // minimum of 5 items of headgear, 5 items of footwear, 15 belts, and 15 potions.

    return gearBag;

  }


  private GearI gear(boolean isDiminishing) {
    multiplierDiminishing = new int[]{1, 1, 1, 1};
    if (isDiminishing) {
      multiplierDiminishing = new int[]{-1, -1, -1, -1};
    }
    int a = Arena.OBJ.nextInt(1, 4);
    if (a == 1 && h < countHeadgears) {
      multiplierAbilities = new int[]{0, 1, 0, 0};
      calAbility();
      h++;
      itemCount++;
      return new Headgear(String.format("Headgear%d", itemCount), isDiminishing,
              strength, constitution, dexterity, charisma);

    } else if (a == 2 && p < countPotions) {
      int select1 = Arena.OBJ.nextInt(1, 4);
      multiplierAbilities = new int[]{0, 0, 0, 0};
      multiplierAbilities[select1 - 1] = 1;
      calAbility();
      p++;
      itemCount++;
      return new Potion(String.format("Potion%d", itemCount), isDiminishing,
              strength, constitution, dexterity, charisma);

    } else if (a == 3 && b < countBelts) {
      multiplierAbilities = new int[]{1, 1, 1, 1};
      int select1 = 0;
      int select2 = 0;

      while (select1 == select2) {
        select1 = Arena.OBJ.nextInt(1, 4);
        select2 = Arena.OBJ.nextInt(1, 4);
      }
      //System.out.println(select1 + " select "+ select2); //TODO
      multiplierAbilities[select1 - 1] = 0;
      multiplierAbilities[select2 - 1] = 0;
      int belt = Arena.OBJ.nextInt(1, 3);
      if (belt == 1) {
        size = BeltSize.SMALL;
      } else if (belt == 2) {
        size = BeltSize.MEDIUM;
      } else {
        size = BeltSize.LARGE;
      }
      calAbility();
      b++;
      itemCount++;
      return new Belt(String.format("Belt%d", itemCount), isDiminishing, strength,
              constitution, dexterity, charisma, size);

    } else if (a == 4 && f < countFootwears) {
      multiplierAbilities = new int[]{0, 0, 1, 0};
      calAbility();
      f++;
      itemCount++;
      return new Footwear(String.format("Footwear%d", itemCount), isDiminishing, strength,
              constitution, dexterity, charisma);

    } else {
      return null;
    }
  }

  /**
   * Returns list of 20 items required by the player.
   * @return Gear.Gear.
   */
  public GearI[] gearSelect() {
    //int[] arr = new int[4];
    GearI[] arr;
    arr = gearList();
    GearI[] arraySel = new GearI[20];
    //TODO 1 head gear, 1 footwear, belts 10 unit, potions
    ////TODO

    int h = 0;
    int b = 0;
    int f = 0;
    int headGear = 1;


    int i = 0;
    while (i < 20) {
      int ra = Arena.OBJ.nextInt(0, 55);
      if (arr[ra] != null) {
        if ((arr[ra].getName().contains("Headgear") && h > 0)
                ||
                (arr[ra].getName().contains("Belt") && (b + ((Belt) arr[ra]).size.getValue()) > 10)
                || (arr[ra].getName().contains("Footwear") && f >= 2)) {
          continue;
        }

        if (arr[ra].getName().contains("Headgear")) { //TODO
          h++;
          arraySel[i] = arr[ra];
          arr[ra] = null;
          i++;
          continue;
        }
        if (arr[ra].getName().contains("Belt")) { //TODO
          b = b + ((Belt) arr[ra]).size.getValue();
          arraySel[i] = arr[ra];
          arr[ra] = null;
          i++;
          continue;
        }

        if (arr[ra].getName().contains("Footwear")) { //TODO
          f++;
          arraySel[i] = arr[ra];
          arr[ra] = null;
          i++;
          int j = 0;
          while (j < 55) {
            if (arr[j] != null) {
              if (arr[j].getName().contains("Footwear")) {
                f++;
                arraySel[i] = arr[j];
                arr[ra] = null;
                i++;
                break;
              }
            }
            j++;
          }
          continue;
        }

        if (arr[ra].getName().contains("Potion")) { //TODO
          arraySel[i] = arr[ra];
          arr[ra] = null;
          i++;
          continue;
        }
      }
    }
    return arraySel;
  }

  protected WeaponI[] getWeaponList() {
    WeaponI[] obj = {new Katana(),new TwoHandedSword(),new BroadSword(),new Flail(), new Axe()};
    return obj;
  }


}





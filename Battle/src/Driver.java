import java.util.Scanner;

import battle.Arena;
import battle.Battle;
import battle.GameState;

/**
 * The class tests battle.
 */
public class Driver {

  /**
   * Start of program.
   * @param args args.
   */
  public static void main(String[] args) {

    Battle pCreate = new Arena("P1", "P2",75);
    while (true) {
      pCreate.gameSetup();
      //System.out.println(pCreate.playerDescription());
      pCreate.setGear();
      //System.out.println(pCreate.playerDescription());
      pCreate.setWeapon();
      //System.out.println(pCreate.playerDescription());

      pCreate.nextTurn();
      //System.out.println(pCreate.playerDescription());
      pCreate.setGear();
      // System.out.println(pCreate.playerDescription());
      pCreate.setWeapon();
      //System.out.println(pCreate.playerDescription());
      pCreate.toss();
      pCreate.battleStart();

      while (pCreate.getState() == GameState.PLAYING) {
        pCreate.strike();
      }
      System.out.println(pCreate.printLog());
      System.out.println("");
      System.out.println("Game with result: " + pCreate.getState());
      System.out.println("Enter REMATCH rematch the players or enter any key to exit:");
      if (pCreate.getState() != GameState.PLAYING) {
        Scanner scan = new Scanner(System.in);
        String sc = scan.next();
        if (sc.equals("REMATCH")) {
          pCreate.gameSetup();
          continue;
        } else {
          break;
        }
      }

    }

  }

}


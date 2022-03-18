import static java.lang.Boolean.TRUE;

import java.util.ArrayList;



/**
 * The class Isolation  represents housing of monkeys that are sent to Isolation.
 * It can only accommodate fixed number of monkeys and has several methods to perform differet
 * actions.
 */
public class Isolation extends HousingImpl {
  private int isolationSize;
  private int idCounter;

  /**
   * The constructor initialises the parameter value for isolation size.
   * @param isolationSizePass maximum number of monkeys the isolation can hold.
   */
  public Isolation(int isolationSizePass) {
    //TODO Assumption
    if (isolationSizePass <= 0 || isolationSizePass > 1000) {
      throw new IllegalArgumentException("Isolation Size can't be"
              +
              " less than 0 or greater than 1000");
    }
    this.isolationSize = isolationSizePass;
    this.idCounter = 0;
  }

  /**
   * This method takes the below parameters and creates list of new monkeys in the arraylist.
   * newMonkeyList.
   * @param name name of the monkey.
   * @param age age.
   * @param species species.
   * @param gender {M, F}.
   * @param food  EGGS("Eggs"), FRUITS("Fruits"), INSECTS("Insects"), LEAVES("Leaves"),
   *            NUTS("Nuts"), SEEDS("Seeds"), TREESAP("TreeSap").
   *
   * @param medicalReception {True, False}.
   * @param size {S,M,L}.
   */
  @Override
  public void addMonkeyIsolation(String name, int age, String species, Sex gender,
                                 Food food, Boolean medicalReception, SizeMonkey size) {
    if (newMonkeyList.size() >= this.isolationSize) {
      throw new IllegalArgumentException("Cant add more monkeys to the Isolation, "
              +
              "max count of monkeys could be: " + this.isolationSize);
    }
    idCounter++;
    newMonkeyList.add(new Monkey(idCounter, name, age, species, gender, food,
            medicalReception, size));
    map.put(idCounter, "Isolation");

    //m.put(name, new Monkey(name, age, size, num));
  }

  @Override
  public String getSign(int id) {
    return null;
  }

  @Override
  public void printEnclosureState() {
    // Dummy method for this class.

  }

  @Override
  public void sendToEnclosure(Monkey monkey) {
    // Dummy method for this class.

  }

  @Override
  public void setSpecies(String species) {
    // Dummy method for this class.

  }

  /**
   * The method sets the medication of the Monkey corresponding to the monkey ID.
   * @param id Monkey ID to be passed.
   */
  public void setMedication(int id) {

    sendMonkeyObject(id).setMedicalReception(TRUE);
  }

  /**
   * This method takes the name of Species  and returns String of IDs showing the isolation number.
   * @param name pass name of species.
   * @return String of isolation location ID.
   */
  public String returnSpeciesLocation(String name) {
    //System.out.println("name is"+name);
    String strTroop = "";
    for (Monkey item : newMonkeyList
    ) {
      if (name.equals(item.getSpecies())) {
        strTroop = strTroop + " " + item.getId();
      }
    }

    return strTroop;
  }

  @Override
  public ArrayList<String> getSpecies() {
    // Dummy method for this class.
    return null;
  }

  @Override
  public void deleteMonkeyEnclosure(int id) {
    // Dummy method for this class.

  }

  @Override
  public ArrayList<Troop> getEnclosures() {
    return null;
  }


}



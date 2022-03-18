import java.util.ArrayList;
import java.util.Map;

/**
 * The below class represents an interface to the housing having Isolation and Enclosure of Monkeys.
 */
public interface Housing {
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
  public void addMonkeyIsolation(String name, int age, String species,
                                 Sex gender, Food food, Boolean medicalReception, SizeMonkey size);

  /**
   * The method returns monkey list of teh object.
   * @return Monkey list
   */
  public ArrayList<Monkey> returnMonkeyList();
  /**
   * Delete  the monkey corresponding to the ID.
   */

  public void deleteMonkeyFromList(int id); //iso

  /**
   * Returns the monkey object.
   */
  public Monkey sendMonkeyObject(int id);

  /**
   * Sets medication with respect to the ID.
   */
  public void setMedication(int id); // iso

  /**
   * Returns the monkey map.
   */
  public Map returnMonkeyMap();

  /**
   * Returns the monkey sign.
   */
  public String getSign(int id);//en

  /**
   * Returns list of Troop/Enclosures.
   */
  public ArrayList<Troop> getEnclosures();

  /**
   * Returns Enclosure location of species.
   */
  public String returnSpeciesLocation(String name);

  /**
   * Deletes monkey from the enclosure.
   */
  public void deleteMonkeyEnclosure(int id);

  /**
   * Prints teh enclosure State for tracking purpose.
   */
  public void printEnclosureState();

  /**
   * Sends a monkey from Isolation to Enclosure.
   * @param monkey Monkey Object.
   */
  public void sendToEnclosure(Monkey monkey);

  /**
   * Returns list of Species being Housed in Enclosure.
   * @return List of string.
   */
  ArrayList<String> getSpecies();

  /**
   * Sets Species to be housed in the Enclosure.
   * @param species Species name.
   */
  public void setSpecies(String species); //En


}

/**
 * The class represents different enclosure of monkeys.
 */
public class Troop {
  int monId;
  String name;
  int troopNumber;
  String species;
  int size;

  /**
   * The below constructor initialises the below parameters.
   * @param monId Monkey ID.
   * @param name Monkey name.
   * @param troopNumber Troop Number.
   * @param species Species name
   * @param size Size of Monkey.
   */
  public Troop(int monId, String name, int troopNumber, String species, int size) {
    this.name = name;
    this.troopNumber = troopNumber;
    this.species = species;
    this.size = size;
    this.monId = monId;

  }


  public String getSpecies() {
    return this.species;
  }

  public int getNumber() {
    return this.troopNumber;
  }

  public int getSize() {
    return this.size;
  }

  public String getName() {
    return this.name;
  }

  public int getMonId() {
    return this.monId;
  }

}

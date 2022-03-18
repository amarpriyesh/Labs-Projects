import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The class Enclosure  represents housing of monkeys that are sent to Enclosure.
 * It can only accommodate fixed number of troops and every enclosure has a fixed size.
 *
 */
public class Enclosure extends HousingImpl {
  private final  int sizeOfTroop;
  private final  int numTroops;
  List<String> species = new ArrayList<>();
  List<Troop> troop = new ArrayList<>();

  int[] trackSize;
  String[] trackSpecies;

  /**
   * The constructor initialises the parameter value for each Enclosure size/Troop Size
   * and total number of troops.
   * @param sizeOfTroop input size of troops in m2.
   * @param numTroops input total number of troops or enclosures required.
   */
  public Enclosure(int sizeOfTroop, int numTroops) {
    if (sizeOfTroop <= 0 || sizeOfTroop > 1000) {
      throw new IllegalArgumentException(" Size can't be"
              +
              " less than 0 or greater than 1000");
    }
    if (numTroops <= 0 || numTroops > 100) {
      throw new IllegalArgumentException(" Troops can't be"
              +
              " less than 0 or greater than 100");
    }
    this.sizeOfTroop = sizeOfTroop;
    this.numTroops = numTroops;
    trackSize = new int[this.numTroops];
    trackSpecies = new String[this.numTroops];
  }


  @Override
  public void addMonkeyIsolation(String name, int age, String species, Sex gender, Food food,
                                 Boolean medicalReception, SizeMonkey size) {
  // Dummy method for this class.
  }

  @Override
  public String getSign(int id) {
    return String.format("Monkey Name = %s, Sex = %s, Favourite Food = %s",
            sendMonkeyObject(id).getName(), sendMonkeyObject(id).getSex().getValue(),
            sendMonkeyObject(id).getFood());
  }

  @Override
  public void printEnclosureState() {
    for (Troop item : troop
    ) {
      //System.out.println(item.getName() + " Enclosure no " + item.getNumber());

    }
    System.out.println("---------------Enclosure State----------------------");
    System.out.println(Arrays.toString(trackSpecies));
    System.out.println(Arrays.toString(trackSize));
  }

  @Override
  public void sendToEnclosure(Monkey monkey) {
    //System.out.println("I ma in enclosure");


    //System.out.println(chkSpecies(monkey.getSpecies()));
    if (chkSpecies(monkey.getSpecies()) && monkey.getMonkeySize() <= this.sizeOfTroop
            &&
            monkey.getMedicalReception()) {
      //System.out.println("Adding monkeys in enclosure 1");
      if (troop.size() == 0) {
        troop.add(new Troop(monkey.getId(), monkey.getSpecies(), 1, monkey.getSpecies(),
                monkey.getMonkeySize()));
        trackSpecies[0] = monkey.getSpecies();
        trackSize = new int[this.numTroops];
        chkTroopSize();
        //System.out.println("Adding monkeys in enclosure");
        newMonkeyList.add(monkey);
        map.put(monkey.getId(), "Enclosure");
      } else {

        for (int i = 0; i < this.numTroops; i++) {

          if (monkey.getSpecies().equals(trackSpecies[i]) && (sizeOfTroop - trackSize[i])
                  >=
                  monkey.getMonkeySize()) {
            troop.add(new Troop(monkey.getId(), monkey.getSpecies(), i + 1,
                    monkey.getSpecies(), monkey.getMonkeySize()));
            trackSize = new int[this.numTroops];
            chkTroopSize();
            newMonkeyList.add(monkey);
            map.put(monkey.getId(), "Enclosure");
          } else if (trackSpecies[i] == null && (sizeOfTroop - trackSize[i])
                  >=
                  monkey.getMonkeySize()) {
            troop.add(new Troop(monkey.getId(), monkey.getSpecies(), i + 1,
                    monkey.getSpecies(), monkey.getMonkeySize()));
            trackSpecies[i] = monkey.getSpecies();
            trackSize = new int[this.numTroops];
            chkTroopSize();
            newMonkeyList.add(monkey);
            map.put(monkey.getId(), "Enclosure");

          } else {
            if (i == this.numTroops - 1) {
              throw new IllegalArgumentException("cant add species");


            }
            //continue;
          }


        }
      }


    } else {
      throw new IllegalArgumentException("cant add species");

    }

  }

  @Override
  public void setSpecies(String species1) {
    species.add(species1);
  }

  @Override
  public String returnSpeciesLocation(String name) {
    String strTroop = "";
    for (int i = 0; i < this.trackSpecies.length; i++) {
      if (name.equals(trackSpecies[i])) {
        strTroop = strTroop + " " + (i + 1);
      }
    }
    return strTroop;
  }

  @Override
  public ArrayList<String> getSpecies() {
    return (ArrayList<String>) species;
  }

  @Override
  public void deleteMonkeyEnclosure(int id) {
    if (newMonkeyList.contains(sendMonkeyObject(id))) {
      deleteMonkeyFromList(id);
      deleteMonkey(id);
      //System.out.println("Monkey Deleted");
    }
    else {
      throw new IllegalArgumentException("Monkey does not exist in enclosure with this ID");
    }

  }

  @Override
  public ArrayList<Troop> getEnclosures() {
    return (ArrayList<Troop>) troop;
  }

  @Override
  public void setMedication(int val) {
    // Dummy method for this class.

  }

  private void deleteMonkey(int id) {
    Troop monkey = null;
    for (Troop item : troop
    ) {
      if (item.getMonId() == (id)) {
        monkey = item;
      }

    }
    troop.remove(monkey);
    trackSize = new int[this.numTroops];
    chkTroopSize();

  }

  private void chkTroopSize() {

    for (int i = 0; i < this.numTroops; i++) {
      for (Troop item : troop
      ) {
        if (item.troopNumber == i + 1) {
          trackSize[i] = trackSize[i] + item.getSize();
        }
      }
      if (trackSize[i] == 0) {
        trackSpecies[i] = null;
      }

    }

  }

  private boolean chkSpecies(String name) {

    return species.contains(name);
  }
}

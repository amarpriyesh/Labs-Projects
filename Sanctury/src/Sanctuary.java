import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class drives the Sanctuary by calling various methods and print statements.
 */
public class Sanctuary {
  static ArrayList<Monkey> list = new ArrayList<>();
  static Map<Integer, String> map = new HashMap<>();

  /**
 * Main method declaration.
 **/
  public static void main(String[] args) {
    Housing isolationObj = new Isolation(10);

    String error = "";

    // String name, int age, String species, Sex gender,Food food,
    // Boolean medicalReception, SizeMonkey size
    isolationObj.addMonkeyIsolation("Sam", 8, "Zpew", Sex.M, Food.LEAVES,
            Boolean.FALSE, SizeMonkey.S);
    isolationObj.addMonkeyIsolation("Abey", 8, "Ape", Sex.M, Food.FRUITS,
            Boolean.FALSE, SizeMonkey.M);
    isolationObj.addMonkeyIsolation("Catline", 8, "Ape", Sex.M, Food.FRUITS,
            Boolean.FALSE, SizeMonkey.M);
    isolationObj.addMonkeyIsolation("Aaey", 8, "Ape", Sex.M, Food.TREESAP,
            Boolean.FALSE, SizeMonkey.M);
    isolationObj.addMonkeyIsolation("Vam", 8, "Ape", Sex.M, Food.NUTS,
            Boolean.FALSE, SizeMonkey.L);
    isolationObj.addMonkeyIsolation("Vaa", 8, "Chimp", Sex.M, Food.INSECTS,
            Boolean.FALSE, SizeMonkey.M);
    System.out.println("print monkey in isolation");
    printObjects(isolationObj.returnMonkeyList());
    System.out.println("");
    //System.out.println(isolationObj.returnMonkeyList());
    isolationObj.setMedication(2);
    isolationObj.setMedication(3);
    isolationObj.setMedication(1);
    isolationObj.setMedication(6);
    //System.out.println(isolationObj.sendMonkeyObject(2).getMedicalReception());
    //Sets Enclosure parameters.
    Housing enclosureObj = new Enclosure(20, 3);
    enclosureObj.setSpecies("Ape");
    enclosureObj.setSpecies("Chimp");
    System.out.println(enclosureObj.getSpecies());
    System.out.println("Adding monkey to Enclosure");
    try {
      enclosureObj.sendToEnclosure(isolationObj.sendMonkeyObject(2));
     // enclosureObj.sendToEnclosure(isolationObj.sendMonkeyObject(6));
    } catch (IllegalArgumentException e) {
      error = e.getMessage();

    }
    if (error.equals("")) {
      isolationObj.deleteMonkeyFromList(2);
      //isolationObj.deleteMonkeyFromList(6);
    }
    System.out.println("print monkey in enclosure");
    printObjects(enclosureObj.returnMonkeyList());
    System.out.println("-------------------------");



    // Printing Enclosure Animals

    //isolationObj.addMonkeyToEncloserFromIso(1);
    //System.out.println(enclosureObj.getSign(2));
    System.out.println("deleting monkey e from enclosure");
    //enclosureObj.deleteMonkeyEnclosure(2);
    printObjects(enclosureObj.returnMonkeyList());
    enclosureObj.printEnclosureState();


    //print combined map
    list = returnCombinedList(enclosureObj, isolationObj);
    map = returnCombinedMap(enclosureObj, isolationObj);

    System.out.println("Printing Species of monkey and its location in alphabetical order "
            +
            "with respect to species");
    System.out.println("----------------------------------------------------------"
            +
            "-------------------------------");
    Collections.sort(list, Monkey.speciesComparator);

    for (String[] s : returnList(map, list)
    ) {
      System.out.println(String.format("Species name: %s, Species location: %s", s[0], s[1]));

    }
    System.out.println("-------------------------------------------------------------"
            +
            "----------------------------");
    System.out.println("");
    System.out.println("Printing where Monkey species Ape is currently housed");
    System.out.println("-----------------------------------------------------");
    System.out.println(checkHousing("Zpew", isolationObj, enclosureObj));
    System.out.println("-----------------------------------------------------");
    System.out.println("");

    System.out.println("Printing Sign of a given enclosure");
    System.out.println("-----------------------------------------------------");
    printEnclosureSigns(1, enclosureObj);
    System.out.println("-----------------------------------------------------");
    System.out.println("");
    System.out.println("Printing list of all the monkeys and their location in alphabetical order");
    System.out.println("-------------------------------------------------------------------------");
    Collections.sort(list);
    for (String[] s : returnListComplete(map, list)
    ) {
      System.out.println(String.format("Monkey name: %s, Species location: %s", s[0], s[1]));

    }
    System.out.println("-------------------------------------------------------------------------");
    System.out.println("");
    System.out.println("Printing shopping list of the food for all the monkeys");
    System.out.println(shoopingList(list));




  }

  /**
   * The below method returns the desired string of species and location.
   * @param map list of Map.
   * @param alist List of Monkeys.
   * @return Returns list of String.
   */
  public static ArrayList<String[]> returnList(Map<Integer, String> map, ArrayList<Monkey> alist) {
    ArrayList<String[]> list = new ArrayList<String[]>();
    for (Monkey item : alist
    ) {
      String[] str = {item.getSpecies(), map.get(item.getId())};
      list.add(str);
    }

    return list;
  }

  /**
   * The below method takes two objects and returns a merged list of Monkeys both from Isolation
   * and Enclosure.
   * @param obj1 Object of Isolation.
   * @param obj2 Object of Enclosure.
   * @return List of Monkeys in Isolation and enclosure.
   */
  public static ArrayList<Monkey> returnCombinedList(Housing obj1, Housing obj2) {
    list.addAll(obj1.returnMonkeyList());
    list.addAll(obj2.returnMonkeyList());
    return list;
  }

  /**
   * The below method takes two objects and returns a merged Map of Monkeys both from Isolation
   * and Enclosure.
   * @param obj1 Object of Isolation.
   * @param obj2 Object of Enclosure.
   * @return Map of Monkeys in Isolation and enclosure.
   */
  public static Map<Integer, String> returnCombinedMap(Housing obj1, Housing obj2) {
    map.putAll(obj1.returnMonkeyMap());
    map.putAll(obj2.returnMonkeyMap());
    return map;
  }

  /**
   * The below Method prints where exactly a species is housed in a sanctuary.
   * @param name name of teh species.
   * @param obj1 Isolation object.
   * @param obj2 Enclosure object.
   * @return String of location and species.
   */
  public static String checkHousing(String name, Housing obj1, Housing obj2) {
    if (obj2.returnSpeciesLocation(name).equals("")
            && obj1.returnSpeciesLocation(name).equals("")) {
      return String.format("The Species  %s is not stored anywhere", name);
    } else if (obj2.returnSpeciesLocation(name).equals("")
            && !obj1.returnSpeciesLocation(name).equals("")) {
      return String.format("The Species %s  is only available in Isolation at "
              +
              "the following numbers %s", name, obj1.returnSpeciesLocation(name));
    } else if (obj1.returnSpeciesLocation(name).equals("")
            && !obj2.returnSpeciesLocation(name).equals("")) {
      return String.format("The Species %s is only available"
              +
              " in Enclosure at the following Enclosure "
              +
              "numbers %s", name, obj2.returnSpeciesLocation(name));
    } else {
      return String.format("The Species %s is available in  Isolation at %s and it is also"
                      +
              " available in Enclosure at the following Enclosure"
                      +
              " numbers %s",
              name, obj1.returnSpeciesLocation(name), obj2.returnSpeciesLocation(name));
    }
  }

  /**
   * This method prints the sign of monkeys with resect to enclosure number.
   * @param enclosureNo Int enclosure number.
   * @param enclosureObj Enclosure object.
   */
  public static void printEnclosureSigns(int enclosureNo, Housing enclosureObj) {

    System.out.println("Below are the signs of Monkeys present in enclosure no " + enclosureNo);
    for (Troop item : enclosureObj.getEnclosures()
    ) {
      if (item.getNumber() == enclosureNo) {
        System.out.println(enclosureObj.getSign(item.getMonId()));
      }

    }
  }

  /**
   * The method returns the merged list of Monkey name and location.
   * @param map Takes map of Monkey and location.
   * @param alist Takes list of Monkeys.
   * @return ist of Monkey name and location.
   */
  public static ArrayList<String[]> returnListComplete(Map<Integer, String> map,
                                                       ArrayList<Monkey> alist) {
    ArrayList<String[]> list = new ArrayList<String[]>();
    for (Monkey item : alist
    ) {
      String[] str = {item.getName(), map.get(item.getId())};
      list.add(str);
    }

    return list;
  }

  /**
   * The below method generates the shopping list of food items and weight of food items required.
   * @param list List of monkeys.
   * @return List of Food and weight.
   */
  public static Map<String, Integer> shoopingList(ArrayList<Monkey> list) {

    Map<String, Integer> str = new HashMap<>();
    List<String> str2 = new ArrayList<>();
    for (Monkey item : list
    ) {
      int weight;
      switch (item.getMonkeySize()) {
        case 1:
          weight = 100;
          break;
        case 5:
          weight = 250;
          break;
        case 10:
          weight = 500;
          break;
        default:
          weight = 0;
          throw new IllegalStateException("Unexpected value: " + item.getMonkeySize());
      }


      if (str2.contains(item.getFood().getValue())) {

        int x = str.get(item.getFood().getValue());
        x = x + weight;
        str.put(item.getFood().getValue(), x);

      } else {
        str2.add(item.getFood().getValue());
        str.put(item.getFood().getValue(), weight);
      }

    }
    return str;
  }

  /**
   * Prints monkey array.
   *
   */
  public static void printObjects(ArrayList<Monkey> monkey) {
    for (Monkey items: monkey
         ) {
      System.out.println(String.format("name: %s size: %s food: %s",items.getName(),
              items.getMonkeySize(),items.getFood()));
    }
  }

}




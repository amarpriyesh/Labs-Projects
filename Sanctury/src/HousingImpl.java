import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract class HousingImpl implements Housing {

  List<Monkey> newMonkeyList = new ArrayList<>();// TODO return a copy
  Map<Integer, String> map = new HashMap<>();


  public abstract void addMonkeyIsolation(String name, int age, String species, Sex gender,
                                 Food food, Boolean medicalReception, SizeMonkey size) ;





  public void deleteMonkeyFromList(int id) {
    if (sendMonkeyObject(id) instanceof Monkey) {
      newMonkeyList.remove(sendMonkeyObject(id));
      map.remove(id);
    }
    else {
      throw new IllegalArgumentException("Monkey does not exist with this ID");
    }
  }

  public ArrayList<Monkey> returnMonkeyList() {
    return (ArrayList<Monkey>) newMonkeyList;
  }

  public Map returnMonkeyMap() {
    return (Map) map;
  }


  public Monkey sendMonkeyObject(int id) {
    for (Monkey item : newMonkeyList
    ) {
      if (id == item.getId()) {
        return item;
      }

    }
    return null;
  }

  public abstract String getSign(int id);

  public abstract void printEnclosureState() ;

  public  abstract  void sendToEnclosure(Monkey monkey) ;

  public  abstract void setSpecies(String species) ;

  public abstract String returnSpeciesLocation(String name);

  public abstract   ArrayList<String> getSpecies();

  public abstract void deleteMonkeyEnclosure(int id) ;

  public  abstract ArrayList<Troop> getEnclosures() ;



  public abstract void setMedication(int val) ;








}

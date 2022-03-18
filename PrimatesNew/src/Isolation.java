import java.util.ArrayList;
import java.util.List;

public class Isolation extends HousingImpl {

  List<Monkey> list = new ArrayList<>();
  int enclosureMaxCapacity;


  @Override
  public void setHousing(int a) {
    this.enclosureMaxCapacity = a;
  }

  @Override
  public void setIsolation(String name, int age) {
    list.add(new Monkey(name, age));

  }

  @Override
  public ArrayList<Monkey> getIsolation() {
    return (ArrayList<Monkey>) list;

    }




}

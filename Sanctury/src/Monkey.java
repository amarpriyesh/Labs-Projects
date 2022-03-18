import java.util.Comparator;

/**
 * The class represents monkeys in Enclosure and Isolation.
 * It also has functions to set and get various parameters.
 */
public class Monkey implements Comparable<Monkey> {

  public static Comparator<Monkey> speciesComparator = new Comparator<Monkey>() {

    public int compare(Monkey s1, Monkey s2) {
      String nameOne = s1.getSpecies().toUpperCase();
      String nameTwo = s2.getSpecies().toUpperCase();

      //ascending order
      return nameOne.compareTo(nameTwo);

    }
  };
  private int id;
  private String name;
  private int age;
  private String species;
  private Sex gender;
  private Food food;
  private Boolean medicalReception;
  private SizeMonkey size;

  /**
   * The below constructor initialises monkey and sets below parameters.
   * @param id id of teh monkey.
   * @param name name of the monkey.
   * @param age age of the monkey.
   * @param species species of the monkey.
   * @param gender gender of the monkey.
   * @param food food of the monkey.
   * @param medicalReception medical reception of the monkey.
   * @param size size of the monkey.
   */
  public Monkey(int id, String name, int age, String species, Sex gender,
                Food food, Boolean medicalReception, SizeMonkey size) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.species = species;
    this.gender = gender;
    this.food = food;
    this.medicalReception = medicalReception;
    this.size = size;
  }

  public String getSpecies() {

    return this.species;
  }

  public int getMonkeySize() {
    return (size.getValue());
  }

  public int getId() {
    return this.id;
  }

  public Food getFood() {
    return this.food;
  }

  public Sex getSex() {
    return this.gender;
  }

  public String getName() {
    return this.name;
  }

  public int getAge() {
    return this.age;
  }

  public Boolean getMedicalReception() {
    return this.medicalReception;
  }

  public void setMedicalReception(Boolean medication) {
    this.medicalReception = medication;
  }

  /**
   * The below method helps to compare two monkey objects.
   * @param e Takes monkey
   * @return returns integer.
   */
  public int compareTo(Monkey e) {
    if (this.getName().equals(e.getName())) {
      return 0;
    }
    else if ((int) this.getName().charAt(0) > (int) e.getName().charAt(0)) {
      return 1;
    }
    else {
      return -1;
    }
  }

}

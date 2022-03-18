package assignments;

import java.util.Collections;
import java.util.List;

/**
 * The class represents a strategy to arrange the records of the assignments in
 * the order they were assigned.
 */
public class AssignedSchedulingStrategy implements SchedulingStrategy {
  SchedulingStrategy fallbackStrategy;

  /**
   * strategy to arrange the records of the assignments in
   *  * the order they were assigned.
   */
  public AssignedSchedulingStrategy() {
    this.fallbackStrategy = new AlphabeticalSchedulingStrategy();
  }

  @Override
  public String schedule(List<Assignment> list) {
    if (list == null) {
      throw new IllegalArgumentException("hello");
    }
    Collections.sort(list, new AssignedSchedulingStrategy());

    return this.toString();
  }


  @Override
  public int compare(Assignment o1, Assignment o2) {


    if (o1.getNumber() > o2.getNumber()) {
      return 1;
    } else if (o1.getNumber() < o2.getNumber()) {
      return -1;
    } else {
      return new AlphabeticalSchedulingStrategy().compare(o1, o2);
    }
  }

  @Override
  public String toString() {
    return "assigned";
  }
}

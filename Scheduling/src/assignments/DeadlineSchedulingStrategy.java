package assignments;

import java.util.Collections;
import java.util.List;

/**
 * The class represents deadline  scheduling strategy function to arrange
 * the records with respect to the deadline.
 */
public class DeadlineSchedulingStrategy implements SchedulingStrategy {

  @Override
  public String schedule(List<Assignment> list) {
    if (list == null) {
      throw new IllegalArgumentException("hello");
    }
    Collections.sort(list, new DeadlineSchedulingStrategy());


    return toString();
  }


  @Override
  public int compare(Assignment o1, Assignment o2) {
    if (o1.getEndDate().isEqual(o2.getEndDate())) {
      return new AlphabeticalSchedulingStrategy().compare(o1, o2);
    }
    return o1.getEndDate().compareTo(o2.getEndDate());
  }

  @Override
  public String toString() {
    return "deadline";
  }
}

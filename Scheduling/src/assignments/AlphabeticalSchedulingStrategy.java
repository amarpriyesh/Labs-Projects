package assignments;

import java.util.Collections;
import java.util.List;

/**
 * The class represents the scheduling strategy to arrange the records alphabetically based upon
 * description.
 */
public class AlphabeticalSchedulingStrategy implements SchedulingStrategy {
  @Override
  public String schedule(List<Assignment> list) {
    if (list == null) {
      throw new IllegalArgumentException("hello");
    }
    Collections.sort(list, new AlphabeticalSchedulingStrategy());
    return this.toString();
  }



  @Override
  public int compare(Assignment o1, Assignment o2) {

    return o1.getDescription().compareTo(o2.getDescription());

  }

  @Override
  public String toString() {
    return "alphabetical";
  }
}

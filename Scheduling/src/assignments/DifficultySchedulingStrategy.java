package assignments;

import java.util.Collections;
import java.util.List;

/**
 * The class represents the strategy functionality to arrange the records based upon difficulty.
 */
public class DifficultySchedulingStrategy implements SchedulingStrategy {

  @Override
  public String schedule(List<Assignment> list) {
    if (list == null) {
      throw new IllegalArgumentException("hello");
    }
    Collections.sort(list, new DifficultySchedulingStrategy());
    return toString();
  }


  @Override
  public int compare(Assignment o1, Assignment o2) {
    if (((int)(o1.getDifficulty())) == ((int)(o2.getDifficulty()))) {
      return new AlphabeticalSchedulingStrategy().compare(o1, o2);
    }
    if ((int)(o1.getDifficulty()) > (int)(o2.getDifficulty())) {
      return -1;

    }
    return 1;

  }

  @Override
  public String toString() {
    return "difficulty";
  }
}

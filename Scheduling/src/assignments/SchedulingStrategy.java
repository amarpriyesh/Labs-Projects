package assignments;

import java.util.Comparator;
import java.util.List;

/**
 * The below interface represent an interface to different scheduling class acting as a
 * function to arrange the records.
 */
public interface SchedulingStrategy extends Comparator<Assignment> {

  /**
   * Represents scheduling function to arrange the records.
   *
   * @param list list of assignments.
   * @return name of assignment.
   */
  String schedule(List<Assignment> list);
}

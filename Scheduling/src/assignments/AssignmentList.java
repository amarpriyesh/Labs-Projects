package assignments;

import java.util.ArrayList;
import java.util.List;

/**
 * A list of task that need to be completed.
 */
public class AssignmentList {

  private final List<Assignment> tasks;
  private String ordering;


  /**
   * Default constructor.
   */
  public AssignmentList() {
    tasks = new ArrayList<>();
    ordering = "assigned";
  }

  /**
   * Add a task to the task list.
   *
   * @param t the task
   */
  public void add(Assignment t) {
    tasks.add(t);
  }

  /**
   * The method enables the user to apply different scheduling strategy.
   * @param str represents the  strategy.
   */
  public void scheduleAssignments(SchedulingStrategy str) {
    if (str == null) {
      throw new IllegalArgumentException("Scheduling strategy can't be null");
    }
    StringBuilder sb = new StringBuilder();
    sb.append(str);
    ordering = str.schedule(tasks);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Ordered by ");
    sb.append(ordering);
    sb.append("\n");
    for (int i = 0; i < tasks.size(); i++) {
      sb.append(i + 1);
      sb.append(" -- ");
      sb.append(tasks.get(i));
      sb.append("\n");
    }
    return sb.toString();
  }
}

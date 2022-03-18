import static org.junit.Assert.assertEquals;

import assignments.AlphabeticalSchedulingStrategy;
import assignments.AssignedSchedulingStrategy;
import assignments.Assignment;
import assignments.AssignmentList;
import assignments.DeadlineSchedulingStrategy;

import org.junit.Test;

import java.time.LocalDate;

/** Class that tests the tasks. */
public class AssignmentTest {


  /** Testing constructor and toString(). */
  @Test
  public void testConstructor() {
    LocalDate now = LocalDate.now();
    System.out.println(now);
    Assignment t1 = new Assignment("task 1");
    assertEquals("task 1, starting " + now + ", ending " + now, t1.toString());
    Assignment t2 = new Assignment("task 2");
    t2.setDeadline(3, 4, 3000);
    t2.setStart(1,1,2000);
   // assertEquals("task 2, starting " + now + ", ending 2025-03-04", t2.toString());
    Assignment t3 = new Assignment("zo");
    t3.setDeadline(3, 4, 2029);
    Assignment t4 = new Assignment("eb");
    t4.setDeadline(3, 4, 2029);
    Assignment t5 = new Assignment("abc");
    t5.setDeadline(3, 4, 2029);
    Assignment t6 = new Assignment("kbc");
    t6.setDeadline(3, 4, 2050);
    AssignmentList obj = new AssignmentList();
    AssignmentList obj2 = new AssignmentList();

    obj.add(t1);
    obj.add(t2);
    obj.add(t3);
    obj.add(t4);
    obj.add(t5);
    obj.add(t6);
    obj.scheduleAssignments(new DeadlineSchedulingStrategy());
    System.out.println(obj.toString());

  }
}

import static org.junit.Assert.assertEquals;

import assignments.AlphabeticalSchedulingStrategy;
import assignments.AssignedSchedulingStrategy;
import assignments.Assignment;
import assignments.AssignmentList;
import assignments.DeadlineSchedulingStrategy;
import assignments.DifficultySchedulingStrategy;
import org.junit.Before;
import org.junit.Test;





/**
 * Class that tests the tasks.
 */
public class AssignmentTest {

  private AssignmentList obj;

  /**
   * The below method sets up assignment list to be ordered using as strategy.
   */
  @Before
  public void setUp() {
    Assignment t1 = new Assignment("buy beer");
    t1.setDeadline(11, 1, 2022);
    t1.setStart(11, 1, 2022);
    Assignment t2 = new Assignment("review module materials");
    t2.setDeadline(11, 5, 2022);
    t2.setStart(11, 1, 2022);
    Assignment t3 = new Assignment("take quiz");
    t3.setDeadline(11, 5, 2022);
    t3.setStart(11, 5, 2022);
    Assignment t4 = new Assignment("complete self evaluation for Lab 8");
    t4.setDeadline(11, 11, 2022);
    t4.setStart(11, 9, 2022);
    Assignment t5 = new Assignment("turn in CS5010 Module 9 Lab");
    t5.setDeadline(11, 7, 2022);
    t5.setStart(11, 2, 2022);

    obj = new AssignmentList();
    obj.add(t1);
    obj.add(t2);
    obj.add(t3);
    obj.add(t4);
    obj.add(t5);
  }

  /**
   * Testing constructor and toString().
   */
  @Test
  public void testConstructor() {
    Assignment a = new Assignment("buy beer");
    a.setDeadline(11, 1, 2022);

    assertEquals("buy beer, starting 2021-11-21, ending 2022-11-01",a.toString());

  }

  /**
   *The below function sorts the list alphabetically.
   */
  @Test
  public void arrangeAlphabetically() {
    obj.scheduleAssignments(new AlphabeticalSchedulingStrategy());
    assertEquals("Ordered by alphabetical\n"
            +
            "1 -- buy beer, starting 2022-11-01, ending 2022-11-01\n"
            +
            "2 -- complete self evaluation for Lab 8, starting 2022-11-09, ending 2022-11-11\n"
            +
            "3 -- review module materials, starting 2022-11-01, ending 2022-11-05\n"
            +
            "4 -- take quiz, starting 2022-11-05, ending 2022-11-05\n"
            +
            "5 -- turn in CS5010 Module 9 Lab, starting 2022-11-02, "
            +
            "ending 2022-11-07\n",obj.toString());

  }

  /**
   *The below function sorts the list alphabetically.
   */
  @Test
  public void arrangeAlphabeticallyafterOther() {
    obj.scheduleAssignments(new AssignedSchedulingStrategy());
    obj.scheduleAssignments(new AlphabeticalSchedulingStrategy());
    assertEquals("Ordered by alphabetical\n"
            +
            "1 -- buy beer, starting 2022-11-01, ending 2022-11-01\n"
            +
            "2 -- complete self evaluation for Lab 8, starting 2022-11-09, ending 2022-11-11\n"
            +
            "3 -- review module materials, starting 2022-11-01, ending 2022-11-05\n"
            +
            "4 -- take quiz, starting 2022-11-05, ending 2022-11-05\n"
            +
            "5 -- turn in CS5010 Module 9 Lab, starting 2022-11-02, "
            +
            "ending 2022-11-07\n",obj.toString());

  }

  /**
   * The test confirms that the list gets assigned after assignment schedule is called.
   */
  @Test
  public void arrangeAssigned() {
    obj.scheduleAssignments(new AssignedSchedulingStrategy());
    assertEquals("Ordered by assigned\n"
            +
            "1 -- buy beer, starting 2022-11-01, ending 2022-11-01\n"
            +
            "2 -- review module materials, starting 2022-11-01, ending 2022-11-05\n"
            +
            "3 -- take quiz, starting 2022-11-05, ending 2022-11-05\n"
            +
            "4 -- complete self evaluation for Lab 8, starting 2022-11-09, ending 2022-11-11\n"
            +
            "5 -- turn in CS5010 Module 9 Lab, starting 2022-11-02, "
            +
            "ending 2022-11-07\n",obj.toString());

  }

  /**
   * The below method sorts the assignment list by the assigned number after other assignment.
   */
  @Test
  public void arrangeAssignedAfterOther() {
    obj.scheduleAssignments(new AlphabeticalSchedulingStrategy());
    obj.scheduleAssignments(new AssignedSchedulingStrategy());
    assertEquals("Ordered by assigned\n"
            +
            "1 -- buy beer, starting 2022-11-01, ending 2022-11-01\n"
            +
            "2 -- review module materials, starting 2022-11-01, ending 2022-11-05\n"
            +
            "3 -- take quiz, starting 2022-11-05, ending 2022-11-05\n"
            +
            "4 -- complete self evaluation for Lab 8, starting 2022-11-09, ending 2022-11-11\n"
            +
            "5 -- turn in CS5010 Module 9 Lab, starting 2022-11-02, "
            +
            "ending 2022-11-07\n",obj.toString());

  }

  /**
   * The below method tests arranging the list sorted by deadline.
   */
  @Test
  public void arrangeDeadline() {
    obj.scheduleAssignments(new DeadlineSchedulingStrategy());
    assertEquals("Ordered by deadline\n"
            +
            "1 -- buy beer, starting 2022-11-01, ending 2022-11-01\n"
            +
            "2 -- review module materials, starting 2022-11-01, ending 2022-11-05\n"
            +
            "3 -- take quiz, starting 2022-11-05, ending 2022-11-05\n"
            +
            "4 -- turn in CS5010 Module 9 Lab, starting 2022-11-02, ending 2022-11-07\n"
            +
            "5 -- complete self evaluation for Lab 8, starting 2022-11-09, "
            +
            "ending 2022-11-11\n",obj.toString());

  }

  /**
   * The below method tests arranging the list sorted by deadline after sorting
   * it by another strategy.
   */
  @Test
  public void arrangeDeadlineAfterOther() {
    obj.scheduleAssignments(new AssignedSchedulingStrategy());
    obj.scheduleAssignments(new DeadlineSchedulingStrategy());
    assertEquals("Ordered by deadline\n"
            +
            "1 -- buy beer, starting 2022-11-01, ending 2022-11-01\n"
            +
            "2 -- review module materials, starting 2022-11-01, ending 2022-11-05\n"
            +
            "3 -- take quiz, starting 2022-11-05, ending 2022-11-05\n"
            +
            "4 -- turn in CS5010 Module 9 Lab, starting 2022-11-02, ending 2022-11-07\n"
            +
            "5 -- complete self evaluation for Lab 8, starting 2022-11-09, "
            +
            "ending 2022-11-11\n",obj.toString());

  }

  /**
   * The below method tests sorting the list by the difficulty.
   */
  @Test
  public void arrangeDifficulty() {
    obj.scheduleAssignments(new DifficultySchedulingStrategy());
    assertEquals("Ordered by difficulty\n"
            +
            "1 -- turn in CS5010 Module 9 Lab, starting 2022-11-02, ending 2022-11-07\n"
            +
            "2 -- review module materials, starting 2022-11-01, ending 2022-11-05\n"
            +
            "3 -- complete self evaluation for Lab 8, starting 2022-11-09, ending 2022-11-11\n"
            +
            "4 -- buy beer, starting 2022-11-01, ending 2022-11-01\n"
            +
            "5 -- take quiz, starting 2022-11-05, ending 2022-11-05\n",obj.toString());


  }

  /**
   * The below method tests sorting the list by the difficulty after other sorting strategy.
   */
  @Test
  public void arrangeDifficultyAfterOther() {
    obj.scheduleAssignments(new AlphabeticalSchedulingStrategy());
    obj.scheduleAssignments(new DifficultySchedulingStrategy());
    assertEquals("Ordered by difficulty\n"
            +
            "1 -- turn in CS5010 Module 9 Lab, starting 2022-11-02, ending 2022-11-07\n"
            +
            "2 -- review module materials, starting 2022-11-01, ending 2022-11-05\n"
            +
            "3 -- complete self evaluation for Lab 8, starting 2022-11-09, ending 2022-11-11\n"
            +
            "4 -- buy beer, starting 2022-11-01, ending 2022-11-01\n"
            +
            "5 -- take quiz, starting 2022-11-05, ending 2022-11-05\n",obj.toString());


  }

  /**
   * The below  method tests for null strategy.
   */
  @Test(expected = IllegalArgumentException.class)
  public void nullStrategy() {
    obj.scheduleAssignments(null);

  }

  /**
   * The below method tests if teh list is sorted alphabetically.
   */
  @Test
  public void arrangeAlphabeticallySameDifficulty() {
    Assignment t2 = new Assignment("review module materials");
    t2.setDeadline(11, 5, 2022);
    t2.setStart(11, 1, 2022);
    Assignment t1 = new Assignment("buy beer");
    t1.setDeadline(11, 5, 2022);
    t1.setStart(11, 1, 2022);
    AssignmentList lis = new AssignmentList();
    lis.add(t2);
    lis.add(t1);
    lis.scheduleAssignments(new DifficultySchedulingStrategy());
    assertEquals("Ordered by difficulty\n"
            +
            "1 -- buy beer, starting 2022-11-01, ending 2022-11-05\n"
            +
            "2 -- review module materials, starting 2022-11-01, ending "
            +
            "2022-11-05\n",lis.toString());


  }

  /**
   * The below method expects exception for the invalid list passed.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidList() {
    Assignment t2 = new Assignment(null);
    t2.setDeadline(11, 0, 0);
    t2.setStart(11, 1, 2022);
    Assignment t1 = new Assignment("buy beer");
    t1.setDeadline(11, 5, 2022);
    t1.setStart(0, 1, 2022);
    AssignmentList lis = new AssignmentList();
    lis.add(t2);
    lis.add(t1);
  }

  /**
   * The below method tests if the assignments get sorted alphabetically
   * if they have the same deadline.
   */
  @Test
  public void arrangeAlphabeticallySameDeadline() {
    Assignment t2 = new Assignment("review module materials");
    t2.setDeadline(11, 5, 2022);
    t2.setStart(11, 1, 2022);
    Assignment t3 = new Assignment("cat");
    t3.setDeadline(11, 5, 2022);
    t3.setStart(11, 1, 2022);
    Assignment t1 = new Assignment("buy beer");
    t1.setDeadline(11, 5, 2022);
    t1.setStart(11, 1, 2022);
    AssignmentList lis = new AssignmentList();
    lis.add(t2);
    lis.add(t1);
    lis.add(t3);
    lis.scheduleAssignments(new DifficultySchedulingStrategy());
    assertEquals("Ordered by difficulty\n"
            +
            "1 -- buy beer, starting 2022-11-01, ending 2022-11-05\n"
            +
            "2 -- cat, starting 2022-11-01, ending 2022-11-05\n"
            +
            "3 -- review module materials, starting 2022-11-01, ending 2022-11-05\n",
            lis.toString());


  }

  /**
   * The method tests the records that are added after schedule.
   */
  @Test
  public void testAssignmentAddedAfterSchedule() {
    Assignment t2 = new Assignment("review module materials");
    t2.setDeadline(11, 5, 2022);
    t2.setStart(11, 1, 2022);
    Assignment t1 = new Assignment("buy beer");
    t1.setDeadline(11, 5, 2022);
    t1.setStart(11, 1, 2022);
    AssignmentList lis = new AssignmentList();
    lis.add(t2);
    lis.add(t1);
    lis.scheduleAssignments(new DifficultySchedulingStrategy());
    assertEquals("Ordered by difficulty\n"
            +
            "1 -- buy beer, starting 2022-11-01, ending 2022-11-05\n"
            +
            "2 -- review module materials, starting 2022-11-01, ending "
            +
            "2022-11-05\n",lis.toString());


    Assignment t3 = new Assignment("Hello World");
    t3.setDeadline(11, 5, 2022);
    t3.setStart(11, 1, 2022);

    Assignment t4 = new Assignment("China Town");
    t4.setDeadline(11, 1, 2022);
    t4.setStart(11, 1, 2022);

    lis.add(t3);
    lis.add(t4);


    assertEquals("Ordered by difficulty\n"
            +
            "1 -- buy beer, starting 2022-11-01, ending 2022-11-05\n"
            +
            "2 -- review module materials, starting 2022-11-01, ending 2022-11-05\n"
            +
            "3 -- Hello World, starting 2022-11-01, ending 2022-11-05\n"
            +
            "4 -- China Town, starting 2022-11-01, ending 2022-11-01\n",lis.toString());


  }
}

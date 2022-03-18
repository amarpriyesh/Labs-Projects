import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * This class tests different methods for the interface Housing.
 */
public class HousingTest {



  /**
   * The below method objects isoObj1 for testing purpose.
   *
   */
  @Before
  public void setUp()  {
    Housing isoObj1 = new Isolation(1);
    isoObj1.addMonkeyIsolation("Sam", 8, "Ape", Sex.M, Food.LEAVES,
            Boolean.FALSE, SizeMonkey.S);
    isoObj1.setMedication(1);





  }

  /**
   * The below method tests for the invalid isolation parameters.
   *
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetIsolation1() {
    Housing isoObj = new Isolation(-3);
  }

  /**
   * The below method tests for Illegal exception when isolation is initialised with 0.
   *
   */
  @Test(expected = IllegalArgumentException.class)
  public void testSetIsolation2() {
    Housing isoObj = new Isolation(0);
  }

  /**
   * The below method tests if a monkey is added in the isolation and compares it with a static val.
   *
   */
  @Test
  public void addMonkeyIsolation() {
    Housing isoObj = new Isolation(1);
    isoObj.addMonkeyIsolation("Sam", 8, "Zpew", Sex.M, Food.LEAVES,
            Boolean.FALSE, SizeMonkey.S);
    assertEquals("Sam",isoObj.sendMonkeyObject(1).getName());
  }

  /**
   * The below method tests if a monkey gets deleted from isolation.
   *
   */
  @Test(expected = NullPointerException.class)
  public void deleteMonkeyFromList() {
    Housing isoObj = new Isolation(1);
    isoObj.addMonkeyIsolation("Sam", 8, "Zpew", Sex.M, Food.LEAVES,
            Boolean.FALSE, SizeMonkey.S);
    isoObj.deleteMonkeyFromList(1);
    isoObj.sendMonkeyObject(1).getName();
  }

  /**
   * The below method tests if send monkey object returns an instance of Monkey.
   *
   */
  @Test
  public void sendMonkeyObject() {
    Housing isoObj = new Isolation(1);
    isoObj.addMonkeyIsolation("Sam", 8, "Zpew", Sex.M, Food.LEAVES,
            Boolean.FALSE, SizeMonkey.S);
    assertTrue( isoObj.sendMonkeyObject(1) instanceof Monkey);
  }

  /**
   * The below method sets  and tests the medication value for the monkey.
   *
   */
  @Test
  public void setMedication() {
    Housing isoObj = new Isolation(1);
    isoObj.addMonkeyIsolation("Sam", 8, "Zpew", Sex.M, Food.LEAVES,
            Boolean.FALSE, SizeMonkey.S);
    isoObj.setMedication(1);
    assertTrue(isoObj.sendMonkeyObject(1).getMedicalReception());
  }

  /**
   * The below method tests  when ever a monkey with invalid species is added.
   *
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidSpecies() {
    Housing isoObj1 = new Isolation(1);
    isoObj1.addMonkeyIsolation("Sam", 8, "Ape", Sex.M, Food.LEAVES,
            Boolean.FALSE, SizeMonkey.S);
    isoObj1.setMedication(1);
    Housing encObj1 = new Enclosure(20,2);
    encObj1.setSpecies("Chimp");
    encObj1.sendToEnclosure(isoObj1.sendMonkeyObject(1));
    assertEquals("Monkey Name = Sam, Sex = Male, Favourite Food = LEAVES",
            encObj1.getSign(1));
  }

  /**
   * The below method tests  the sign returned.
   *
   */
  @Test
  public void getSign() {
    Housing isoObj1 = new Isolation(1);
    isoObj1.addMonkeyIsolation("Sam", 8, "Ape", Sex.M, Food.LEAVES,
            Boolean.FALSE, SizeMonkey.S);
    isoObj1.setMedication(1);
    Housing encObj1 = new Enclosure(20,2);
    encObj1.setSpecies("Ape");
    encObj1.sendToEnclosure(isoObj1.sendMonkeyObject(1));
    assertEquals("Monkey Name = Sam, Sex = Male, Favourite Food = LEAVES",
            encObj1.getSign(1));

  }

  /**
   * The below method tests  if an exception is thrown when we delete a monkey from the enclosure.
   *
   */
  @Test(expected = NullPointerException.class)
  public void deleteMonkeyEnclosure() {
    Housing isoObj1 = new Isolation(1);
    isoObj1.addMonkeyIsolation("Sam", 8, "Ape", Sex.M, Food.LEAVES,
            Boolean.FALSE, SizeMonkey.S);
    isoObj1.setMedication(1);
    Housing encObj1 = new Enclosure(20,2);
    encObj1.setSpecies("Ape");
    encObj1.sendToEnclosure(isoObj1.sendMonkeyObject(1));
    encObj1.deleteMonkeyEnclosure(1);
    System.out.println(encObj1.sendMonkeyObject(1).getName());
  }

  /**
   * The below method tests for monkey getting sent to enclosure successfully.
   *
   */
  @Test
  public void sendToEnclosure() {
    Housing isoObj1 = new Isolation(1);
    isoObj1.addMonkeyIsolation("Sam", 8, "Ape", Sex.M, Food.LEAVES,
            Boolean.FALSE, SizeMonkey.S);
    isoObj1.setMedication(1);
    Housing encObj1 = new Enclosure(20,2);
    encObj1.setSpecies("Ape");
    encObj1.sendToEnclosure(isoObj1.sendMonkeyObject(1));
    assertEquals("Sam",encObj1.sendMonkeyObject(1).getName());
  }

  /**
   *Tests if a species is added to the list.
   */
  @Test
  public void setSpecies() {
    Housing encObj1 = new Enclosure(20,2);
    encObj1.setSpecies("Ape");
    List<String> str1 = new ArrayList<>();
    str1.add("Ape");
    assertEquals(str1,encObj1.getSpecies());
  }

  /**
   *Tests for if an illegal  dimension of enclosures are passed.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testEnclosureDimension() {
    Housing isoObj1 = new Isolation(1);
    isoObj1.addMonkeyIsolation("Sam", 8, "Ape", Sex.M, Food.LEAVES,
            Boolean.FALSE, SizeMonkey.S);
    isoObj1.setMedication(1);
    Housing encObj1 = new Enclosure(0,2);

  }

}
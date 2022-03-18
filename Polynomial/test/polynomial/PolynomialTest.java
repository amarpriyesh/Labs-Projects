package polynomial;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;


/**
 * Represents the test class to test different methods and validations to class polynomial.
 */
public class PolynomialTest {
  Polynomial pol;

  /**
   * sets up a an empty polynomial object or a polynomial with different terms.
   * @throws Exception if the format of the string is not correct.
   */
  @Before
  public void setUp() throws Exception {
    pol = new PolynomialImpl();
  }

  /**
   * Tests if the polynomial has the same value after adding different polynomials.
   */
  @Test
  public void add() {
    Polynomial poly1 = new PolynomialImpl("+3x^4 +2x^5 -5 -20x^4 +11x^1");
    Polynomial poly2 = new PolynomialImpl("4x^1");
    Polynomial poly3 = new PolynomialImpl("2x^5 -17x^4 +15x^1 -5");

    assertTrue(poly3.isSame(poly2.add(poly1)));

  }

  /**
   * Adds various terms to teh empty polynomila and asserts if the right coefficient could be
   * produced.
   */
  @Test
  public void addTerm() {
    //pol.addTerm(3,2);
    pol.addTerm(4, 1);
    pol.addTerm(-5, 3);
    pol.addTerm(5, 3);
    pol.addTerm(8, 2);
    pol.addTerm(-8, -0);
    assertEquals(8, pol.getCoefficient(2));

  }


  /**
   * The below method asserts equality of the two polynomials.
   */
  @Test
  public void isSame() {
    Polynomial poly1 = new PolynomialImpl("2 +4x^1");

    Polynomial poly2 = new PolynomialImpl("4x^1 +2");

    assertTrue(poly2.isSame(poly1));
  }

  /**
   * The method evaluates the value of the polynomial and checks if the value is right.
   */
  @Test
  public void evaluate() {
    pol.addTerm(3, 1);
    assertEquals(-6,(int)pol.evaluate(-2));
  }

  /**
   * The method asserts if we are getting right coefficient of a given term with the degree.
   */
  @Test
  public void getCoefficient() {
    Polynomial poly1 = new PolynomialImpl("4x^1 +2");
    assertEquals(4,poly1.getCoefficient(1));
  }



  /**
   * Asserts if  the maximum degree of the polynomial is a correct value.
   */
  @Test
  public void getDegree() {
    Polynomial poly1 = new PolynomialImpl("-5x^1 -3x^202 +2x^1");
    assertEquals(202,poly1.getDegree());
  }

  /**
   * The below method tests if the no argument constructor works correctly, and returns 0 as string.
   */
  @Test
  public void testNoArgumentConstructor() {
    Polynomial poly1 = new PolynomialImpl();
    assertEquals("0", poly1.toString());
  }

  /**
   * The method tests polynomial with multiple non-zero values.
   */
  @Test
  public void testNonZeroPolynomial() {
    Polynomial poly2 = new PolynomialImpl("7x^5 +5x^4 +9 +10");
    assertEquals("7x^5 +5x^4 +19", poly2.toString());
  }

  /**
   * The method tests  if the polynomial gets created correctly with only non-zero constants.
   */
  @Test
  public void testNonZeroPolynomialConstant() {
    Polynomial poly2 = new PolynomialImpl("2");
    assertEquals("2", poly2.toString());
  }

  /**
   * The method tests if the polynomial is getting created correctly if the elements
   * are passed with teh same power.
   */
  @Test
  public void testNonZeroPolynomialSamePower() {
    Polynomial poly2 = new PolynomialImpl("7x^5 +5x^5 +5x^4 +9 +10");
    assertEquals("12x^5 +5x^4 +19", poly2.toString());
  }

  /**
   * Tests if the constructor throws exception when a string is passed with no values.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testEmptyString() {
    Polynomial poly2 = new PolynomialImpl("");
    assertEquals("12x^5 +5x^4 +19", poly2.toString());
  }

  /**
   * Tests if the constructor throws exception when a null string is passed as an argument.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testNullString() {
    Polynomial poly2 = new PolynomialImpl("null");
    assertEquals("12x^5 +5x^4 +19", poly2.toString());
  }

  /**
   * Tests if the constructor throws error when a polynomial with invalid format is created.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testInvalidString() {
    Polynomial poly2 = new PolynomialImpl("5y^4+2");

  }

  /**
   * The below method asserts if we are getting right to string values from the polynomial.
   */
  @Test
  public void testToString() {
    Polynomial poly1 = new PolynomialImpl("2x^5 +17x^1 -3x^3");
    assertEquals(poly1.toString(),"2x^5 -3x^3 +17x^1");
  }

  /**
   * The below method asserts if we are getting right to string values from the polynomial.
   */
  @Test
  public void testToStringCoefficientOf1() {
    Polynomial poly1 = new PolynomialImpl("5x^3 +x -1x^3");
    assertEquals(poly1.toString(),"4x^3 +1x^1");
  }

  /**
   * Tests addition of two polynomial with different power.
   */
  @Test
  public void testTwoPolyWithDiffPower() {
    Polynomial poly1 = new PolynomialImpl("1 +2x");
    Polynomial poly2 = new PolynomialImpl("5x^2 -6x^3");
    assertEquals((poly1.add(poly2)).toString(),"-6x^3 +5x^2 +2x^1 +1");
  }

  /**
   * It tests addition of two polynimial with one of terms having same  power.
   */
  @Test
  public void testTwoPolyWithSamePower() {
    Polynomial poly1 = new PolynomialImpl("1 +2x +5x^2");
    Polynomial poly2 = new PolynomialImpl("2x +5x^2 -6x^3");
    assertEquals((poly1.add(poly2)).toString(),"-6x^3 +10x^2 +4x^1 +1");
  }

  /**
   * Tests the output when two zero polynomials are added.
   */
  @Test
  public void testAddPolyZero() {
    Polynomial poly1 = new PolynomialImpl();
    Polynomial poly2 = new PolynomialImpl();
    assertEquals((poly1.add(poly2)).toString(),"0");
  }

  /**
   * The method tests if Illegal Argument exception is thrown if we try to create an invalid
   * polynomial with negative power.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testValidPoly() {
    Polynomial poly1 = new PolynomialImpl("-5x^1 -3x^-202 +2x^1");
  }

  /**
   * * The method tests if the polynomial is valid if the same term is added.
   */
  @Test
  public void testValidPolyAdd() {
    Polynomial poly1 = new PolynomialImpl("5x^2");
    poly1.addTerm(5,2);
    assertEquals("10x^2",poly1.toString());
  }

  /**
   * The method tests if the polynomial is valid if different term is added.
   */
  @Test
  public void testValidPolyAddDiffTerm() {
    Polynomial poly1 = new PolynomialImpl("5x^2 +2x");
    poly1.addTerm(6,3);
    assertEquals("6x^3 +5x^2 +2x^1",poly1.toString());
  }

  /**
   * The method tests if the polynomial is valid if different term is added.
   */
  @Test
  public void testisSameDifferentPower() {
    Polynomial poly1 = new PolynomialImpl("5x^2 +2x");
    Polynomial poly2 = new PolynomialImpl("5x^3 +1");
    assertFalse(poly1.isSame(poly2));
    poly1.addTerm(4,4);
    poly2.addTerm(4,4);
    assertFalse(poly1.isSame(poly2));
  }

  /**
   * The method tests if the polynomial is valid if different term is added.
   */
  @Test
  public void testisSameZeroPower() {
    Polynomial poly1 = new PolynomialImpl();
    Polynomial poly2 = new PolynomialImpl();
    assertTrue(poly1.isSame(poly2));

  }

  /**
   * The method tests if the polynomial has right degree.
   */
  @Test
  public void testDegree() {
    Polynomial poly2 = new PolynomialImpl("5x^3 +1 +5x^2");
    assertEquals(poly2.getDegree(),3);

  }

  /**
   * The method tests if the polynomial has right degree.
   */
  @Test
  public void testDegreeConstant() {
    Polynomial poly2 = new PolynomialImpl("5");
    assertEquals(poly2.getDegree(),0);

  }

  /**
   * Tests coefficient of terms/ power that does not exist.
   */
  @Test
  public void testCoefficientNotExists() {
    Polynomial poly2 = new PolynomialImpl("2x^4 +5");
    assertEquals(0, poly2.getCoefficient(5));

  }

  /**
   * The method evaluates the value of the polynomial and checks if the value is right for negative
   * x.
   */
  @Test
  public void evaluateNegative() {
    Polynomial poly3 = new PolynomialImpl("2x^3 +5");
    assertEquals(-11,(int)poly3.evaluate(-2));
  }

  /**
   * The method evaluates the value of the polynomial and checks if the value is right for positive
   * x.
   */
  @Test
  public void evaluatePositive() {
    Polynomial poly3 = new PolynomialImpl("2x^3 +5");
    assertEquals(21,(int)poly3.evaluate(2));
  }

}
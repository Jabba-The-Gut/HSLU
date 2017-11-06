/**
 * 
 */
package ch.hslu.oop.sw07.Equals;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ch.hslu.oop.sw07.Person.Person;
import nl.jqno.equalsverifier.EqualsVerifier;

/**
 * @author Dave
 *
 */
public class PointTest {
	private static int testcounter;

	@BeforeClass
	public static void setBefore() {
		testcounter = 0;
		System.out.println("Tests starting now...");
	}

	@Before
	public void before() {
		testcounter++;
		System.out.println("Test " + testcounter + " has started...");
	}

	@After
	public void after() {
		System.out.println("Test " + testcounter + " has ended...");
	}

	@AfterClass
	public static void setAfter() {
		System.out.println("Tests ended...");
	}

	@Test
	public void equalsContract() {
		EqualsVerifier.forClass(Point.class).verify();
	}

	/**
	 * Test method for {@link ch.hslu.oop.sw07.Equals.Point#toString()}.
	 */
	@Test
	public void testToString() throws Exception {
		assertEquals("Point mit X-Koor: 10 und Y-Koor: 10", new Point(10, 10).toString());
	}

	/**
	 * Test method for
	 * {@link ch.hslu.oop.sw07.Equals.Point#equals(java.lang.Object)}.
	 */
	@Test
	public void testEqualsTrue() {
		assertTrue(new Point(10, 10).equals(new Point(10, 10)));
	}

	/**
	 * Test method for
	 * {@link ch.hslu.oop.sw07.Equals.Point#equals(java.lang.Object)}.
	 */
	@Test
	public void testEqualsFalse() {
		assertFalse(new Point(10, 10).equals(new Point(5, 30)));
	}

	/**
	 * Test method for {@link ch.hslu.oop.sw07.Equals.Point#hashCode()}.
	 */
	@Test
	public void testHashCodeTrue() {
		assertTrue(new Point(10, 10).hashCode() == new Point(10, 10).hashCode());
	}

	/**
	 * Test method for {@link ch.hslu.oop.sw07.Equals.Point#hashCode()}.
	 */
	@Test
	public void testHashCodeMultiple() {
		final Point point1 = new Point(10, 10);
		final Point point2 = new Point(10, 10);
		assertArrayEquals(new int[] { point1.hashCode(), point1.hashCode(), point1.hashCode() },
				new int[] { point2.hashCode(), point2.hashCode(), point2.hashCode() });
	}

	/**
	 * Test method for {@link ch.hslu.oop.sw07.Equals.Point#hashCode()}.
	 */
	@Test
	public void testHashCodeFalse() {
		assertFalse(new Point(10, 20).hashCode() == new Point(40, 10).hashCode());
	}

	/**
	 * Test method for
	 * {@link ch.hslu.oop.sw07.Equals.Point#compareTo(ch.hslu.oop.sw07.Equals.Point)}.
	 */
	@Test
	public void testCompareEquals() {
		assertTrue(new Point(10, 10).compareTo(new Point(10, 10)) == 0);
	}
	
	/**
	 * Test method for
	 * {@link ch.hslu.oop.sw07.Equals.Point#compareTo(ch.hslu.oop.sw07.Equals.Point)}.
	 */
	@Test
	public void testCompareSmaller() {
		assertTrue(new Point(9, 9).compareTo(new Point(10, 10)) < 0);
	}
	
	/**
	 * Test method for
	 * {@link ch.hslu.oop.sw07.Equals.Point#compareTo(ch.hslu.oop.sw07.Equals.Point)}.
	 */
	@Test
	public void testCompareBigger() {
		assertTrue(new Point(12, 12).compareTo(new Point(10, 10)) > 0);
	}
}

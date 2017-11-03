/**
 * 
 */
package ch.hslu.oop.sw07.Equals;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
public class TemperaturTest {
	private static int testcounter;
	private static Temperatur temp1;

	@BeforeClass
	public static void setBefore() {
		temp1 = new Temperatur(12.0);
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
		EqualsVerifier.forClass(Temperatur.class).verify();
	}

	/**
	 * Test method for
	 * {@link ch.hslu.oop.sw07.Equals.Temperatur#equals(java.lang.Object)}.
	 */
	@Test
	public void testEqualsTrue() {
		assertTrue(temp1.equals(temp1));
	}

	/**
	 * Test method for
	 * {@link ch.hslu.oop.sw07.Equals.Temperatur#equals(java.lang.Object)}.
	 */
	@Test
	public void testEqualsFalse() {
		assertFalse(new Temperatur(12.0).equals(new Temperatur(12.0)));
	}

	/**
	 * Test method for {@link ch.hslu.oop.sw07.Equals.Temperatur#hashCode()}.
	 */
	@Test
	public void testHashCode() {
		assertTrue(temp1.hashCode() == temp1.hashCode());
	}

	/**
	 * Test method for {@link ch.hslu.oop.sw07.Equals.Temperatur#hashCode()}.
	 */
	@Test
	public void testHashCodeMultiple() {
		assertArrayEquals(new int[] { temp1.hashCode(), temp1.hashCode(), temp1.hashCode() },
				new int[] { temp1.hashCode(), temp1.hashCode(), temp1.hashCode() });
	}

	/**
	 * Test method for
	 * {@link ch.hslu.oop.sw07.Equals.Temperatur#Temperatur(double)}.
	 */
	@Test
	public void testTemperaturDouble() {
		Temperatur temp = new Temperatur((Double.MAX_VALUE * 3));
		assertTrue(temp.getTempCels() == 20.0);
	}

	/**
	 * Test method for {@link ch.hslu.oop.sw07.Equals.Temperatur#toString()}.
	 */
	@Test
	public void testToString() {
		assertEquals("Aktuelle Temperatur in Celsius: 12.0", temp1.toString());
	}

	/**
	 * Test method for
	 * {@link ch.hslu.oop.sw07.Equals.Temperatur#compareTo(ch.hslu.oop.sw07.Equals.Temperatur)}.
	 */
	@Test
	public void testCompareToEquals() {
		assertTrue(temp1.compareTo(new Temperatur(12.0)) == 0);
	}

	/**
	 * Test method for
	 * {@link ch.hslu.oop.sw07.Equals.Temperatur#compareTo(ch.hslu.oop.sw07.Equals.Temperatur)}.
	 */
	@Test
	public void testCompareToSmaller() {
		assertTrue(temp1.compareTo(new Temperatur(13.0)) < 0);
	}

	/**
	 * Test method for
	 * {@link ch.hslu.oop.sw07.Equals.Temperatur#compareTo(ch.hslu.oop.sw07.Equals.Temperatur)}.
	 */
	@Test
	public void testCompareToBigger() {
		assertTrue(temp1.compareTo(new Temperatur(11.0)) > 0);
	}

}

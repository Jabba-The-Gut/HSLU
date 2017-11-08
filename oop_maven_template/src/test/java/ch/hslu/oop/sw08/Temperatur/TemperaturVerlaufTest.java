/**
 * 
 */
package ch.hslu.oop.sw08.Temperatur;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Dave
 *
 */
public class TemperaturVerlaufTest {
	private static int testcounter;

	@BeforeClass
	public static void setBefore() {
		testcounter = 0;
		System.out.println("JUnit Tests started");
	}

	@Before
	public void before() {
		testcounter++;
		System.out.println("Test " + testcounter + " started...");
	}

	@After
	public void after() {
		System.out.println("Test " + testcounter + " ended...");
	}

	@AfterClass
	public static void setAfter() {
		System.out.println("JUnit Tests finished");
	}

	/**
	 * Test method for
	 * {@link ch.hslu.oop.sw08.TemperaturVerlauf#add(ch.hslu.oop.sw08.Temperatur)}.
	 */
	@Test
	public void testAdd() {
		TemperaturVerlauf sample = new TemperaturVerlauf();
		sample.add(new Temperatur(10.0f));
		assertTrue(sample.getCount() == 1);
	}

	/**
	 * Test method for {@link ch.hslu.oop.sw08.TemperaturVerlauf#clear()}.
	 */
	@Test
	public void testClear() {
		TemperaturVerlauf sample = new TemperaturVerlauf();
		sample.add(new Temperatur(10.0f));
		sample.add(new Temperatur(15.32f));
		sample.add(new Temperatur(50.0f));
		sample.clear();
		assertTrue(sample.getCount() == 0);
	}

	/**
	 * Test method for {@link ch.hslu.oop.sw08.TemperaturVerlauf#getCount()}.
	 */
	@Test
	public void testGetCount() {
		TemperaturVerlauf sample = new TemperaturVerlauf();
		sample.add(new Temperatur(10.0f));
		sample.add(new Temperatur(15.32f));
		sample.add(new Temperatur(50.0f));
		sample.add(new Temperatur(22.0f));
		sample.add(new Temperatur(9.8f));
		sample.add(new Temperatur(2.0f));
		assertTrue(sample.getCount() == 6);
	}

	/**
	 * Test method for {@link ch.hslu.oop.sw08.TemperaturVerlauf#toString()}.
	 */
	@Test
	public void testToString() {
		TemperaturVerlauf sample = new TemperaturVerlauf();
		sample.add(new Temperatur(9.8f));
		sample.add(new Temperatur(2.0f));
		assertEquals("This TemperaturVerlauf-Object contains 2 objects of type Temperatur", sample.toString());
	}

	/**
	 * Test method for {@link ch.hslu.oop.sw08.TemperaturVerlauf#getMin()}.
	 */
	@Test
	public void testGetMin() {
		TemperaturVerlauf sample = new TemperaturVerlauf();
		sample.add(new Temperatur(10.0f));
		sample.add(new Temperatur(15.32f));
		sample.add(new Temperatur(50.0f));
		sample.add(new Temperatur(22.0f));
		sample.add(new Temperatur(9.8f));
		sample.add(new Temperatur(2.0f));
		assertTrue(sample.getMin().getCelsius() == 2.0f);
	}

	/**
	 * Test method for {@link ch.hslu.oop.sw08.TemperaturVerlauf#getMax()}.
	 */
	@Test
	public void testGetMax() {
		TemperaturVerlauf sample = new TemperaturVerlauf();
		sample.add(new Temperatur(10.0f));
		sample.add(new Temperatur(15.32f));
		sample.add(new Temperatur(50.0f));
		sample.add(new Temperatur(22.0f));
		sample.add(new Temperatur(9.8f));
		sample.add(new Temperatur(2.0f));
		assertTrue(sample.getMax().getCelsius() == 50.0f);

	}

	/**
	 * Test method for
	 * {@link ch.hslu.oop.sw08.TemperaturVerlauf#calculateAverage()}.
	 */
	@Test
	public void testCalculateAverage() {
		TemperaturVerlauf sample = new TemperaturVerlauf();
		sample.add(new Temperatur(10.0f));
		sample.add(new Temperatur(15.32f));
		sample.add(new Temperatur(50.0f));
		sample.add(new Temperatur(22.0f));
		assertTrue(sample.calculateAverage() == 24.33f);
	}

}

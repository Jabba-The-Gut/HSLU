/**
 * 
 */
package ch.hslu.oop.sw10.Console;

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
		sample.add(Temperatur.createFromCelsius(10.0f));
		assertTrue(sample.getCount() == 1);
	}

	/**
	 * Test method for {@link ch.hslu.oop.sw08.TemperaturVerlauf#clear()}.
	 */
	@Test
	public void testClear() {
		TemperaturVerlauf sample = new TemperaturVerlauf();
		sample.add(Temperatur.createFromKelvin(10.0f));
		sample.add(Temperatur.createFromCelsius(15.32f));
		sample.add(Temperatur.createFromKelvin(50.0f));
		sample.clear();
		assertTrue(sample.getCount() == 0);
	}

	/**
	 * Test method for {@link ch.hslu.oop.sw08.TemperaturVerlauf#getCount()}.
	 */
	@Test
	public void testGetCount() {
		TemperaturVerlauf sample = new TemperaturVerlauf();
		sample.add(Temperatur.createFromKelvin(10.0f));
		sample.add(Temperatur.createFromKelvin(15.32f));
		sample.add(Temperatur.createFromCelsius(50.0f));
		sample.add(Temperatur.createFromCelsius(22.0f));
		sample.add(Temperatur.createFromKelvin(9.8f));
		sample.add(Temperatur.createFromCelsius(2.0f));
		assertTrue(sample.getCount() == 6);
	}

	/**
	 * Test method for {@link ch.hslu.oop.sw08.TemperaturVerlauf#getMin()}.
	 */
	@Test
	public void testGetMin() {
		TemperaturVerlauf sample = new TemperaturVerlauf();
		sample.add(Temperatur.createFromCelsius(10.0f));
		sample.add(Temperatur.createFromCelsius(15.32f));
		sample.add(Temperatur.createFromCelsius(50.0f));
		sample.add(Temperatur.createFromCelsius(22.0f));
		sample.add(Temperatur.createFromCelsius(9.8f));
		sample.add(Temperatur.createFromCelsius(2.0f));
		assertTrue(sample.getMin().getCelsius() == 2.0f);
	}

	/**
	 * Test method for {@link ch.hslu.oop.sw08.TemperaturVerlauf#getMax()}.
	 */
	@Test
	public void testGetMax() {
		TemperaturVerlauf sample = new TemperaturVerlauf();
		sample.add(Temperatur.createFromKelvin(10.0f));
		sample.add(Temperatur.createFromKelvin(15.32f));
		sample.add(Temperatur.createFromKelvin(50.0f));
		sample.add(Temperatur.createFromKelvin(22.0f));
		sample.add(Temperatur.createFromKelvin(9.8f));
		sample.add(Temperatur.createFromKelvin(2.0f));
		assertTrue(sample.getMax().getKelvin() == 50.0f);

	}

	/**
	 * Test method for
	 * {@link ch.hslu.oop.sw08.TemperaturVerlauf#calculateAverageKelvin()}.
	 */
	@Test
	public void testCalculateAverageKelvin() {
		TemperaturVerlauf sample = new TemperaturVerlauf();
		sample.add(Temperatur.createFromKelvin(10.0f));
		sample.add(Temperatur.createFromKelvin(15.32f));
		sample.add(Temperatur.createFromKelvin(50.0f));
		sample.add(Temperatur.createFromKelvin(22.0f));
		assertTrue(sample.calculateAverageKelvin() == 24.33f);
	}

}

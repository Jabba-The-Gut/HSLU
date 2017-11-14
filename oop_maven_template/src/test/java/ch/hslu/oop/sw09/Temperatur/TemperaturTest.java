/**
 * 
 */
package ch.hslu.oop.sw09.Temperatur;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import ch.hslu.oop.sw09.Temperatur.Temperatur;
import nl.jqno.equalsverifier.EqualsVerifier;

/**
 * @author Dave
 *
 */
public class TemperaturTest {

	private static int testcounter;
	private static Temperatur temperatur;

	@BeforeClass
	public static void setBefore() {
		testcounter = 0;
		temperatur = Temperatur.createFromCelsius(20.0f);
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

	@Test
	public void equalsContract() {
		EqualsVerifier.forClass(Temperatur.class).verify();
	}

	@Test
	public void testHashCode() {
		Temperatur sample = Temperatur.createFromKelvin(10.0f);
		Temperatur sample2 = (Temperatur) sample;
		assertTrue(sample.hashCode() == sample2.hashCode());
	}

	@Test
	public void testTemperaturTemperatur() {
		Temperatur sample = Temperatur.createFromKelvin(10.0f);
		Temperatur sample2 = Temperatur.createFromObject(sample);
		assertTrue(sample.getKelvin() == sample2.getKelvin());
	}
	
	@Rule 
	public ExpectedException e =  ExpectedException.none();
	
	@Test
	public void testTemperaturIllegalArgument() {
		e.expect(IllegalArgumentException.class);
		e.expectMessage("Temperatur canno't be below the absolute point of zero!");
		Temperatur.createFromCelsius(-300.0f);
	}

	@Test
	public void testGetKelvin() {
		assertTrue(temperatur.getKelvin() == 293.15f);
	}

	@Test
	public void testGetCelsius() {
		assertTrue(temperatur.getCelsius() == 20.0f);
	}

	@Test
	public void testConvertKelvinToCelsius() {
		assertTrue(Temperatur.convertKelvinToCelsius(20.0f) == -253.15f);
	}

	@Test
	public void testConvertCelsiusToKelvin() {
		assertTrue(Temperatur.convertCelsiusToKelvin(20.0f) == 293.15f);
	}

	@Test
	public void testEqualsObject() {
		Temperatur sample = Temperatur.createFromCelsius(10.0f);
		Temperatur sample2 = (Temperatur) sample;
		assertTrue(sample.equals(sample2));
	}

	@Test
	public void testToString() {
		assertTrue("Aktuelle Temperatur in Celsius: 20.0".equals(temperatur.toString()));
	}

	@Test
	public void testCompareToEqual() {
		Temperatur sample = Temperatur.createFromCelsius(10.0f);
		Temperatur sample2 = Temperatur.createFromCelsius(10.0f);
		assertTrue(sample.compareTo(sample2) == 0);
	}

	@Test
	public void testCompareToSmaller() {
		Temperatur sample = Temperatur.createFromCelsius(9.0f);
		Temperatur sample2 = Temperatur.createFromCelsius(10.0f);
		assertTrue(sample.compareTo(sample2) < 0);
	}

	@Test
	public void testCompareToBigger() {
		Temperatur sample = Temperatur.createFromCelsius(23.0f);
		Temperatur sample2 = Temperatur.createFromCelsius(10.0f);
		assertTrue(sample.compareTo(sample2) > 0);
	}
}

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

import ch.hslu.oop.sw07.Person.Person;
import nl.jqno.equalsverifier.EqualsVerifier;


public class TemperaturTest {
	private static int testcounter;
	private static Temperatur temperatur;

	@BeforeClass
	public static void setBefore() {
		testcounter = 0;
		temperatur = new Temperatur(20.0f);
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
		EqualsVerifier.forClass(Person.class).verify();
	}

	@Test
	public void testHashCode() {
		Temperatur sample = new Temperatur(10.0f);
		Temperatur sample2 = (Temperatur) sample;
		assertTrue(sample.hashCode() == sample2.hashCode());
	}

	@Test
	public void testTemperaturTemperatur() {
		Temperatur sample = new Temperatur(10.0f);
		Temperatur sample2 = new Temperatur(sample);
		assertTrue(sample.getKelvin() == sample2.getKelvin());
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
	public void testSetKelvin() {
		Temperatur sample = new Temperatur(20.0f);
		sample.setKelvin(200.15f);
		assertTrue(sample.getKelvin() == 200.15f);
	}

	@Test
	public void testSetCelsius() {
		Temperatur sample = new Temperatur(30.0f);
		sample.setCelsius(40.0f);
		assertTrue(sample.getCelsius() == 40.0f);
	}

	@Test
	public void testConvertKelvinToCelsius() {
		assertTrue(Temperatur.convertKelvinToCelsius(20.0f)== -253.15f);
	}

	@Test
	public void testConvertCelsiusToKelvin() {
		assertTrue(Temperatur.convertCelsiusToKelvin(20.0f) == 293.15f);
	}

	@Test
	public void testEqualsObject() {
		Temperatur sample = new Temperatur(10.0f);
		Temperatur sample2 = (Temperatur) sample;
		assertTrue(sample.equals(sample2));
	}

	@Test
	public void testToString() {
		assertTrue("Aktuelle Temperatur in Celsius: 20.0".equals(temperatur.toString()));
	}

	@Test
	public void testCompareToEqual() {
		Temperatur sample = new Temperatur(10.0f);
		Temperatur sample2 = new Temperatur(10.0f);
		assertTrue(sample.compareTo(sample2) == 0);
	}
	
	@Test
	public void testCompareToSmaller() {
		Temperatur sample = new Temperatur(9.0f);
		Temperatur sample2 = new Temperatur(10.0f);
		assertTrue(sample.compareTo(sample2) < 0);
	}
	
	@Test
	public void testCompareToBigger() {
		Temperatur sample = new Temperatur(23.5f);
		Temperatur sample2 = new Temperatur(10.0f);
		assertTrue(sample.compareTo(sample2) > 0);
	}

}

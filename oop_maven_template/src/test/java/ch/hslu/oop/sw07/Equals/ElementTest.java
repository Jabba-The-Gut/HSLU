package ch.hslu.oop.sw07.Equals;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ElementTest {
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

	/**
	 * Test method for
	 * {@link ch.hslu.oop.sw07.Equals.Element#compareTo(ch.hslu.oop.sw07.Equals.Element)}.
	 */
	@Test
	public void testCompareToEquals() {
		assertTrue(new Blei("Blei", 12).compareTo(new Blei("Blei", 12)) == 0);
	}

	/**
	 * Test method for
	 * {@link ch.hslu.oop.sw07.Equals.Element#compareTo(ch.hslu.oop.sw07.Equals.Element)}.
	 */
	@Test
	public void testCompareSmaller() {
		assertTrue(new Blei("Blei", 11).compareTo(new Blei("Blei", 12)) < 0);
	}

	/**
	 * Test method for
	 * {@link ch.hslu.oop.sw07.Equals.Element#compareTo(ch.hslu.oop.sw07.Equals.Element)}.
	 */
	@Test
	public void testCompareBigger() {
		assertTrue(new Blei("Blei", 13).compareTo(new Blei("Blei", 12)) > 0);
	}

}

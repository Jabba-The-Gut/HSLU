/**
 * 
 */
package ch.hslu.oop.sw08;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Daveeee
 *
 */
public class TemperaturTest {
    private static int testcounter;
    private static Temperatur temp1;
    private static Temperatur temp2;

    @BeforeClass
    public static void setBefore() {
        testcounter = 0;
        temp1 = new Temperatur();
        temp2 = new Temperatur();
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
     * Test method for {@link ch.hslu.oop.sw08.Temperatur#hashCode()}.
     */
    @Test
    public void testHashCodeTrue() {
        assertTrue(temp1.hashCode() == temp2.hashCode());
    }

    /**
     * Test method for {@link ch.hslu.oop.sw08.Temperatur#hashCode()}.
     */
    @Test
    public void testHashCodeFalse() {
        Temperatur sample = new Temperatur(33.0);
        assertFalse(sample.hashCode() == temp2.hashCode());
    }

    /**
     * Test method for {@link ch.hslu.oop.sw08.Temperatur#Temperatur(double)}.
     */
    @Test
    public void testTemperaturDoubleToBig() {
        Temperatur sample = new Temperatur((Double.MAX_VALUE + Double.MAX_VALUE));
        assertTrue(20.0 == sample.getTempCels());
    }

    /**
     * Test method for {@link ch.hslu.oop.sw08.Temperatur#getTempCels()}.
     */
    @Test
    public void testGetTempCels() {
        assertTrue(temp1.getTempCels() == 20.0);
    }

    /**
     * Test method for {@link ch.hslu.oop.sw08.Temperatur#setTempCels(double)}.
     */
    @Test
    public void testSetTempCels() {
        Temperatur sample = new Temperatur();
        sample.setTempCels(40.0);
        assertTrue(sample.getTempCels() == 40.0);
    }

    /**
     * Test method for
     * {@link ch.hslu.oop.sw08.Temperatur#convertCelsToCelvin()}.
     */
    @Test
    public void testConvertCelsToCelvin() {
        assertTrue(temp2.convertCelsToCelvin() == 293.15);
    }

    /**
     * Test method for {@link ch.hslu.oop.sw08.Temperatur#convertCelsToFar()}.
     * 
     */
    @Test
    public void testConvertCelsToFar() {
        assertTrue(temp2.convertCelsToFar() == 68.0);
    }

    /**
     * Test method for
     * {@link ch.hslu.oop.sw08.Temperatur#equals(java.lang.Object)}.
     */
    @Test
    public void testEqualsTrue() {
        assertTrue(temp1.equals(temp1));
    }

    /**
     * Test method for
     * {@link ch.hslu.oop.sw08.Temperatur#equals(java.lang.Object)}.
     */
    @Test
    public void testEqualsFalse() {
        assertFalse(temp1.equals(temp2));
    }

    /**
     * Test method for {@link ch.hslu.oop.sw08.Temperatur#toString()}.
     */
    @Test
    public void testToString() {
        assertEquals("Aktuelle Temperatur in Celsius: 20.0", temp1.toString());
    }

    /**
     * Test method for
     * {@link ch.hslu.oop.sw08.Temperatur#compareTo(ch.hslu.oop.sw08.Temperatur)}.
     */
    @Test
    public void testCompareToTrue() {
        assertTrue(temp1.compareTo(temp2) == 0);
    }
}

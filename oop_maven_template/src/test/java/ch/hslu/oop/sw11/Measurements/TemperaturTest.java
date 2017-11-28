/**
 * 
 */
package ch.hslu.oop.sw11.Measurements;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
     * {@link ch.hslu.oop.sw11.Measurements.Temperatur#createFromCelsius(float, java.time.LocalDateTime, int)}.
     */
    @Test
    public void testCreateFromCelsius() {
        LocalDateTime timestamp = LocalDateTime.parse("2016/10/26 20:35:58",
                DateTimeFormatter.ofPattern("yyy/MM/dd HH:mm:ss"));
        Temperatur temp = Temperatur.createFromCelsius(12.0f, timestamp, 12);
        assertArrayEquals("Object creation not as expectd", new Object[] { 12.0f,
                LocalDateTime.parse("2016/10/26 20:35:58", DateTimeFormatter.ofPattern("yyy/MM/dd HH:mm:ss")), 12 },
                new Object[] { temp.getCelsius(), temp.getTimestamp(), temp.getHumidity() });
    }

    /**
     * Test method for
     * {@link ch.hslu.oop.sw11.Measurements.Temperatur#createFromKelvin(float, java.time.LocalDateTime, int)}.
     */
    @Test
    public void testCreateFromKelvin() {
        LocalDateTime timestamp = LocalDateTime.parse("2016/10/22 18:35:58",
                DateTimeFormatter.ofPattern("yyy/MM/dd HH:mm:ss"));
        Temperatur temp = Temperatur.createFromKelvin(225.0f, timestamp, 12);
        assertArrayEquals("Object creation not as expectd", new Object[] { 225.0f,
                LocalDateTime.parse("2016/10/22 18:35:58", DateTimeFormatter.ofPattern("yyy/MM/dd HH:mm:ss")), 12 },
                new Object[] { temp.getKelvin(), temp.getTimestamp(), temp.getHumidity() });
    }

    /**
     * Test method for
     * {@link ch.hslu.oop.sw11.Measurements.Temperatur#getHumidity()}.
     */
    @Test
    public void testGetHumidity() {
        fail("Not yet implemented");
    }

    /**
     * Test method for
     * {@link ch.hslu.oop.sw11.Measurements.Temperatur#getTimestamp()}.
     */
    @Test
    public void testGetTimestamp() {
        fail("Not yet implemented");
    }

    /**
     * Test method for
     * {@link ch.hslu.oop.sw11.Measurements.Temperatur#equals(java.lang.Object)}.
     */
    @Test
    public void testEqualsObjectFalse() {
        Temperatur temp1 = Temperatur.createFromKelvin(225.0f, LocalDateTime.parse("2016/10/22 18:35:58",
                DateTimeFormatter.ofPattern("yyy/MM/dd HH:mm:ss")), 12);
        Temperatur temp2 = Temperatur.createFromKelvin(225.0f, LocalDateTime.parse("2016/10/22 18:35:58",
                DateTimeFormatter.ofPattern("yyy/MM/dd HH:mm:ss")), 12);
        assertFalse((temp1.equals(temp2)));
    }
    
    /**
     * Test method for
     * {@link ch.hslu.oop.sw11.Measurements.Temperatur#equals(java.lang.Object)}.
     */
    @Test
    public void testEqualsObjectTrue() {
        Temperatur temp1 = Temperatur.createFromKelvin(225.0f, LocalDateTime.parse("2016/10/22 18:35:58",
                DateTimeFormatter.ofPattern("yyy/MM/dd HH:mm:ss")), 12);
        Temperatur temp2 = temp1;
        assertTrue((temp1.equals(temp2)));
    }

    /**
     * Test method for
     * {@link ch.hslu.oop.sw11.Measurements.Temperatur#toString()}.
     */
    @Test
    public void testToString() {
        fail("Not yet implemented");
    }

}

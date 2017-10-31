/**
 * 
 */
package ch.hslu.oop.sw06.JUnit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Daveeee
 *
 */
public class Demo1Test {
    private Demo1 testDemoInstance;

    @Before
    public void setUp() {
        testDemoInstance = new Demo1();
    }

    /**
     * Test method for {@link ch.hslu.oop.sw06.JUnit.Demo1#Demo1()}.
     */
    @Ignore
    @Test
    public void testDemo1() {
    }

    /**
     * Test method for {@link ch.hslu.oop.sw06.JUnit.Demo1#max(int, int)}.
     */
    @Test
    public void testMax1() {
        assertEquals(6, testDemoInstance.max(6, 2));
    }

    /**
     * Test method for {@link ch.hslu.oop.sw06.JUnit.Demo1#max(int, int)}.
     */
    @Test
    public void testMax2() {
        assertEquals(3, testDemoInstance.max(2, 3));
    }

    /**
     * Test method for {@link ch.hslu.oop.sw06.JUnit.Demo1#max(int, int)}.
     */
    @Test
    public void testMax3() {
        assertEquals(0, testDemoInstance.max(9, 9));
    }

}

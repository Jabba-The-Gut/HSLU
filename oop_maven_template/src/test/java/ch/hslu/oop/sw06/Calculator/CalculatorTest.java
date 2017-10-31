/**
 * 
 */
package ch.hslu.oop.sw06.Calculator;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Daveeee
 *
 */
public class CalculatorTest {
    private static Computable calculator;
    private static int testcounter;
    
    /**
     * Methode, um ein Calculator-Object zu instanzieren
     */
    @BeforeClass
    public static void instantiateClass(){
        testcounter = 0;
        calculator = new Calculator();
        System.out.println("Tests starting now...");
    }
    
    @Before 
    public void before(){
        testcounter++;
        System.out.println("Test " + testcounter + " has started...");
    }
    
    @After 
    public void after(){
        System.out.println("Test " + testcounter + " has ended...");
    }

    /**
     * Test method for {@link ch.hslu.oop.sw06.Calculator.Calculator#additionInt(int, int)}.
     */
    @Test
    public void testAdditionIntZero() {
        assertEquals(0, calculator.additionInt(0, 0));
    }
    
    /**
     * Test method for {@link ch.hslu.oop.sw06.Calculator.Calculator#additionInt(int, int)}.
     */
    @Test
    public void testAdditionIntNormal() {
        assertEquals(10, calculator.additionInt(5, 5));
    }
    
    /**
     * Test method for {@link ch.hslu.oop.sw06.Calculator.Calculator#additionInt(int, int)}.
     */
    @Test
    public void testAdditionIntNegative() {
        assertEquals(8, calculator.additionInt(10, -2));
    }
    
    /**
     * Test method for {@link ch.hslu.oop.sw06.Calculator.Calculator#additionInt(int, int)}.
     */
    @Test
    public void testAdditionIntNotIntZero() {
        assertEquals(3, calculator.additionInt(10, (int)-7.0f));
    }
    
    /**
     * Test method for {@link ch.hslu.oop.sw06.Calculator.Calculator#additionInt(int, int)}.
     */
    @Test
    public void testAdditionIntNotIntNotZero() {
        assertEquals(5, calculator.additionInt(10, (int)-5.5f));
    }
    
    /**
     * Test method for {@link ch.hslu.oop.sw06.Calculator.Calculator#additionInt(int, int)}.
     */
    @Test
    public void testAdditionIntPi() {
        assertEquals(7, calculator.additionInt(10, (int)-Math.PI));
    }
    
    /**
     * Test method for {@link ch.hslu.oop.sw06.Calculator.Calculator#additionInt(int, int)}.
     */
    @Test
    public void testAdditionIntE() {
        assertEquals(3, calculator.additionInt(5, (int)-Math.E));
    }
    
    /**
     * Test method for {@link ch.hslu.oop.sw06.Calculator.Calculator#additionInt(int, int)}.
     */
    @Test
    public void testAdditionIntCalculation() {
        assertEquals(7, calculator.additionInt(5, (5-3)));
    }

}

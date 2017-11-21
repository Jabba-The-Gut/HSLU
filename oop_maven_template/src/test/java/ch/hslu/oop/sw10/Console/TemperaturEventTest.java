/**
 * 
 */
package ch.hslu.oop.sw10.Console;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Dave
 *
 */
public class TemperaturEventTest {

	/**
	 * Test method for
	 * {@link ch.hslu.oop.sw10.Console.TemperaturEvent#TemperaturEvent(java.lang.Object, ch.hslu.oop.sw10.Console.MaxOrMinEnum)}.
	 */
	@Test
	public void testTemperaturEvent() {
		TemperaturEvent event = new TemperaturEvent(this, MaxOrMinEnum.MAX, 12.0f);
		assertEquals(this, event.getSource());
	}

	/**
	 * Test method for {@link ch.hslu.oop.sw10.Console.TemperaturEvent#toString()}.
	 */
	@Test
	public void testToStringMax() {
		TemperaturEvent event = new TemperaturEvent(this, MaxOrMinEnum.MAX, 12.0f);
		assertEquals("Maximum", event.toString());
	}

	/**
	 * Test method for {@link ch.hslu.oop.sw10.Console.TemperaturEvent#toString()}.
	 */
	@Test
	public void testToStringMin() {
		TemperaturEvent event = new TemperaturEvent(this, MaxOrMinEnum.MIN, 12.0f);
		assertEquals("Minimum", event.toString());
	}

	/**
	 * Test method for {@link ch.hslu.oop.sw10.Console.TemperaturEvent#getValue()}.
	 */
	@Test
	public void testGetValue() {
		TemperaturEvent event = new TemperaturEvent(this, MaxOrMinEnum.MIN, 12.0f);
		assertEquals(12.0f, event.getValue(), 0.0f);
	}

}

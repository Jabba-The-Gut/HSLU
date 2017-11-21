package ch.hslu.oop.sw10.Console;

import java.util.EventObject;

/**
 * Eigens definierte Events für TemperaturVerlaufs-Klasse
 * @author Dave
 *
 */
public class TemperaturEvent extends EventObject {
	private MaxOrMinEnum value;
	private float temp;

	public TemperaturEvent(Object source, MaxOrMinEnum maxormin, float temp) {
		super(source);
		value = maxormin;
		this.temp = temp;
	}

	@Override
	public String toString() {
		return value.returnPrettyFormat();
	}
	
	public float getValue() {
		return this.temp;
	}
}

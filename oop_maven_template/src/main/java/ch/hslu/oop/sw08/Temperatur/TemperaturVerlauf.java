/**
 * 
 */
package ch.hslu.oop.sw08.Temperatur;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/**
 * @author Dave
 *
 */
public final class TemperaturVerlauf {
	private Collection<Temperatur> store;
	private float median;

	public TemperaturVerlauf() {
		store = new ArrayList<>();
		median = 0.0f;
	}

	/**
	 * Add a Temperatur Object to the collection
	 * 
	 * @param temp
	 *            the Temperatur-Object to add
	 */
	public void add(Temperatur temp) {
		store.add(temp);
	}

	/**
	 * Removes all the Objects stored, the Temperatur-Verlauf is empty afterwards
	 */
	public void clear() {
		store.clear();
	}

	public int getCount() {
		return store.size();
	}

	@Override
	public String toString() {
		return "This TemperaturVerlauf-Object contains " + this.getCount() + " objects of type Temperatur";
	}

	public Temperatur getMax() {
		if (this.getCount() != 0) {
			return Collections.max(store);
		}
		return null;
	}

	public Temperatur getMin() {
		if (this.getCount() != 0) {
			return Collections.min(store);
		}
		return null;
	}

	/**
	 * Get the average of all Temperatur-objects stored
	 * 
	 * @return the average in float rounded to two decimal places
	 */
	public float calculateAverage() {
		if (this.getCount() != 0) {
			Iterator<Temperatur> iterator = store.iterator();
			while (iterator.hasNext()) {
				median += iterator.next().getCelsius();
			}
			return TemperaturVerlauf.round((median / store.size()), 2);
		}
		return 0.0f;
	}

	/**
	 * Method to round a float to two decimal places
	 * 
	 * @param d
	 *            the float do be rounded
	 * @param decimalPlace
	 *            how much decimal places
	 * @return the float rounded to the specified decimal places
	 */
	private static final float round(float d, int decimalPlace) {
		BigDecimal bd = new BigDecimal(Float.toString(d));
		bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
		return bd.floatValue();
	}

}

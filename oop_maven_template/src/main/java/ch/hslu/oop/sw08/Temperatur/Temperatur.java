package ch.hslu.oop.sw08.Temperatur;

/**
 * Klasse Temperatur, welche die real existierende Temperatur in Kelvin
 * abbildet.
 * 
 * @author JabbbaTheGut
 * @version 1.3
 */
public final class Temperatur implements Comparable<Temperatur> {
	private static final float KELVIN_OFFSET = 273.15f;
	private float kelvin;

	/**
	 * Default Konstruktor
	 * 
	 * @param celsius
	 *            Temperatur in Celsius
	 */
	public Temperatur(float celsius) {
		if (celsius > Float.MIN_VALUE && celsius < Float.MAX_VALUE) {
			kelvin = Temperatur.convertCelsiusToKelvin(celsius);
		} else {
			kelvin = 20.0f;
		}
	}

	/**
	 * Konstruktor mit Temperatur-Objekt als Parameter
	 * 
	 * @param temp
	 *            Temperatur Objekt, dessen Temp-Wert übernommen werden soll
	 */
	public Temperatur(Temperatur temp) {
		kelvin = temp.getKelvin();
	}

	public float getKelvin() {
		return kelvin;
	}

	public float getCelsius() {
		return Temperatur.convertKelvinToCelsius(kelvin);
	}

	public void setKelvin(float kelvin) {
		if (kelvin > Float.MIN_VALUE && kelvin < Float.MAX_VALUE) {
			this.kelvin = kelvin;
		}
	}

	public void setCelsius(float celsius) {
		if (celsius > Float.MIN_VALUE && celsius < Float.MAX_VALUE) {
			kelvin = Temperatur.convertCelsiusToKelvin(celsius);
		}
	}

	public static float convertKelvinToCelsius(float kelvin) {
		return (kelvin - KELVIN_OFFSET);
	}

	public static float convertCelsiusToKelvin(float celsius) {
		return (celsius + KELVIN_OFFSET);
	}

	/**
	 * Zwei Temperatur-Objekte sind gleich, falls sie die gleiche Identität, den
	 * gleichen Typ und den gleichen Temp-Wert haben
	 */
	@Override
	public final boolean equals(Object object) {
		if (this == object) {
			final Temperatur temp = (Temperatur) object;
			if (object instanceof Temperatur) {
				if (this.kelvin == temp.getKelvin()) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * Da zwei Objekte gleich sind, wenn sie die gleiche Identität haben, muss an
	 * der default-Implementation nichts geandert werden
	 */
	@Override
	public final int hashCode() {
		return super.hashCode();
	}

	@Override
	public final String toString() {
		return "Aktuelle Temperatur in Celsius: " + this.getCelsius();
	}

	/**
	 * Zwei Temperatur-Objekte werden aufgrund ihrer Temperatur verglichen
	 */
	@Override
	public int compareTo(Temperatur o) {
		return Float.compare(this.kelvin, o.getKelvin());
	}

}

package ch.hslu.oop.sw11.Console;

/**
 * Klasse Temperatur, welche die real existierende Temperatur in Kelvin
 * abbildet.
 * 
 * @author JabbbaTheGut
 * @version 1.3
 */
public final class Temperatur implements Comparable<Temperatur> {
	private static final float KELVIN_OFFSET = 273.15f;
	private final float kelvin;

	/**
	 * Default Konstruktor
	 * 
	 * @param temp
	 *            TEmperatur als float
	 * @param unit
	 *            CELSIUS oder KELVIN (enum)
	 */
	private Temperatur(float temp, UnitEnum unit) {
		if (Temperatur.validArgument(temp, unit)) {
			if (unit == UnitEnum.CELSIUS) {
				kelvin = Temperatur.convertCelsiusToKelvin(temp);
			} else {
				kelvin = temp;
			}

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
	private Temperatur(Temperatur temp) {
		 this(temp.getKelvin(), UnitEnum.KELVIN);
	}

	/**
	 * Factory-Methode für neue Temperatur-Objekte in Celsius
	 * 
	 * @param celsius
	 *            Temperatur in Celsius
	 * @return Temperatur-Objekt
	 */
	public static Temperatur createFromCelsius(final float celsius) {
		return new Temperatur(celsius, UnitEnum.CELSIUS);
	}

	/**
	 * Factory-Methode für neue Temperatur-Objekte in Kelvin
	 * 
	 * @param kelvin
	 *            Temperatur in Kelvin
	 * @return Temperatur-Objekt
	 */
	public static Temperatur createFromKelvin(final float kelvin) {
		return new Temperatur(kelvin, UnitEnum.KELVIN);
	}

	/**
	 * Factory-Methode für neue Temperatur-Objekte aus einem bestehenden Objekt
	 * 
	 * @param temp
	 *            Temperatur-Objekt
	 * @return Temperatur-Objekt
	 */
	public static Temperatur createFromObject(Temperatur temp) {
		return new Temperatur(temp);
	}

	public float getKelvin() {
		return kelvin;
	}

	public float getCelsius() {
		return Temperatur.convertKelvinToCelsius(kelvin);
	}

	public static float convertKelvinToCelsius(float kelvin) {
		return (kelvin - KELVIN_OFFSET);
	}

	public static float convertCelsiusToKelvin(float celsius) {
		return (celsius + KELVIN_OFFSET);
	}

	/**
	 * Überprüfung, ob der übergebene Wert nicht unter dem Abosluten Null-Punkt
	 * liegt und ob er in der Range von float liegt.
	 * 
	 * @param value
	 *            zu überprüfender Wert
	 * @param unit
	 *            Einheit des Werts
	 * @return true wenn der Wert gültig ist, false wenn nicht
	 * @throws IllegalArgumentException
	 *             falls der Wert unter dem absoluten Null-Punkt liegt
	 */
	private static boolean validArgument(float value, UnitEnum unit) throws IllegalArgumentException {
		if (value < unit.getBoundary()) {
			throw new IllegalArgumentException("Temperatur canno't be below the absolute point of zero!");
		} else if (value > Float.MIN_VALUE && value < Float.MAX_VALUE) {
			return true;
		} else {
			return false;
		}
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

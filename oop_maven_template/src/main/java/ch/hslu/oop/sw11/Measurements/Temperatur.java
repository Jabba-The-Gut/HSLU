package ch.hslu.oop.sw11.Measurements;

import java.time.LocalDateTime;

/**
 * Klasse Temperatur, welche die real existierende Temperatur in Kelvin
 * abbildet.Jede Temperatur besizt zudem einen TimeStamp von der Messung sowie
 * eine Feuchtigkeitsangabe (in Prozent)
 * 
 * @author JabbbaTheGut
 * @version 1.3
 */
public final class Temperatur implements Comparable<Temperatur> {
    private static final float KELVIN_OFFSET = 273.15f;
    // Temperatur in Kelvin
    private final float kelvin;
    // Timestamp jeder Temperatur-Messung
    private final LocalDateTime timestamp;
    // Luftfeuchtigkeit zum Zeitpunkt der Messung
    private final int humidity;

    public enum UnitEnum {
        CELSIUS(-273.15f), KELVIN(0);

        private final float boundary;

        UnitEnum(float boundary) {
            this.boundary = boundary;
        }

        public float getBoundary() {
            return boundary;
        }
    }

    private Temperatur(float temp, LocalDateTime timestamp, int humidity, UnitEnum unit) {
        // Wenn die Temperatur den Kriterien enspricht,
        // instanziere alle Felder entsprechend
        if (Temperatur.validArgument(temp, unit)) {
            if (unit == UnitEnum.CELSIUS) {
                this.kelvin = Temperatur.convertCelsiusToKelvin(temp);
            } else {
                kelvin = temp;
            }
            this.timestamp = timestamp;
            this.humidity = humidity;
        }
        // Wenn die Temperatur nicht zugelassen ist, wird als timestamp die
        // aktuelle Zeit genommen
        // und die Luftfeuchtigkeit wird random generiert
        else {
            kelvin = 20.0f;
            this.timestamp = LocalDateTime.now();
            this.humidity = (int) Math.random();
        }
    }

    /**
     * Konstruktor mit Temperatur-Objekt als Parameter
     * 
     * @param temp
     *            Temperatur Objekt, dessen Temp-Wert übernommen werden soll
     */
    private Temperatur(Temperatur temp) {
        this(temp.getKelvin(), temp.getTimestamp(), temp.getHumidity(), UnitEnum.KELVIN);
    }

    /**
     * Factory-Methode für neue Temperatur-Objekte in Celsius
     * 
     * @param celsius
     *            Temperatur in Celsius
     * @param timestamp
     *            Zeitpunkt der Messung
     * @param humidity
     *            Luftfeuchtigkeit bei der Messung
     * @return neues Temperatur-Objekt
     */

    public static Temperatur createFromCelsius(final float celsius, final LocalDateTime timestamp, final int humidity) {
        return new Temperatur(celsius, timestamp, humidity, UnitEnum.CELSIUS);
    }

    /**
     * Factory-Methode für neue Temperatur-Objekte in Kelvin
     * 
     * @param kelvin
     *            Temperatur in Kelvin
     * @param timestamp
     *            Zeitpunkt der Messung
     * @param humidity
     *            Luftfeuchtigkeit bei der Messung
     * @return neues Temperatur-Objekt
     */
    public static Temperatur createFromKelvin(final float kelvin, final LocalDateTime timestamp, final int humidity) {
        return new Temperatur(kelvin, timestamp, humidity, UnitEnum.KELVIN);
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

    public int getHumidity() {
        return this.humidity;
    }

    public LocalDateTime getTimestamp() {
        return this.timestamp;
    }

    public float getKelvin() {
        return this.kelvin;
    }

    public float getCelsius() {
        return Temperatur.convertKelvinToCelsius(this.kelvin);
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
     * gleichen Typ und die gleichen Attribute haben
     */
    @Override
    public final boolean equals(Object object) {
        if (this == object) {
            final Temperatur temp = (Temperatur) object;
            if (object instanceof Temperatur) {
                if (this.kelvin == temp.getKelvin() && this.timestamp == temp.getTimestamp()
                        && this.humidity == temp.humidity) {
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
     * Da zwei Objekte gleich sind, wenn sie die gleiche Identität haben, muss
     * an der default-Implementation nichts geandert werden
     */
    @Override
    public final int hashCode() {
        return super.hashCode();
    }

    @Override
    public final String toString() {
        return "Temperatur: " + this.getCelsius() + "-Gemessen: " + this.timestamp + ", Luftfechtigkeit bei der Messung: "
                + this.humidity + "%";
    }

    /**
     * Zwei Temperatur-Objekte werden aufgrund ihrer Temperatur verglichen
     */
    @Override
    public int compareTo(Temperatur o) {
        return Float.compare(this.kelvin, o.getKelvin());
    }

}

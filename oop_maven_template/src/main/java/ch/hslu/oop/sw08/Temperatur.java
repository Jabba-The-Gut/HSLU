package ch.hslu.oop.sw08;

/**
 * Klasse Temperatur, welche die real existierende Temperatur in Grad mit einem
 * Feld abbildet. Die Temperatur kann abgefragt, umgewandelt und relativ
 * geändert werden.
 * 
 * @author JabbbaTheGut
 * @version 2017.02.10
 */
public class Temperatur implements Comparable<Temperatur> {

    private static final double KELVIN_OFFSET = 273.15;
    private double tempCels;

    /**
     * Konstruktor, welcher die initiale Temperatur aut. auf 20 Grad setzt
     */
    public Temperatur() {
        tempCels = 20.0;
    }

    /**
     * Konstruktor, bei welchem die initiale Temperatur gewählt werden kann
     */
    public Temperatur(double defaultTemp) {
        if (defaultTemp < Double.MIN_VALUE || defaultTemp > Double.MAX_VALUE) {
            tempCels = 20.0;
        } else {
            tempCels = defaultTemp;
        }
    }

    /**
     * Getter-Methode für die Temperatur in Grad
     */
    public final double getTempCels() {
        return tempCels;
    }

    /**
     * Setter-Methode für die Temperatur in Grad
     */
    public final void setTempCels(double input) {
        if (input > Double.MIN_VALUE && input < Double.MAX_VALUE) {
            tempCels = input;
        } else {
        }
    }

    /**
     * Umrechnung von Grad zu Kelvin
     */
    public double convertCelsToCelvin() {
        return (tempCels + KELVIN_OFFSET);
    }

    /**
     * Umrechnung von Grad zu Fahrenheit
     */
    public double convertCelsToFar() {
        return (((tempCels * 1.8) + 32));
    }

    /**
     * Veränderung der Temperatur um einen relativen Kelvin-Wert
     */
    public void changeKelv(double relativeValueKelv) {
        if (relativeValueKelv > Double.MAX_VALUE && relativeValueKelv < Double.MIN_VALUE) {
            double tempKelv = convertCelsToCelvin();
            tempKelv += relativeValueKelv;
            setTempCels((tempKelv - KELVIN_OFFSET));
        }
    }

    /**
     * Veränderung der Temperatur um einen relativen Grad-Wert
     */
    public void changeCelsius(double relativeValueCels) {
        if (relativeValueCels > Double.MAX_VALUE && relativeValueCels < Double.MIN_VALUE) {
            tempCels += relativeValueCels;
        }
    }

    /**
     * Zwei Temperatur-Objekte sind gleich, falls sie die gleiche Identität
     * haben und Temp-Wert haben
     */
    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            final Temperatur temp = (Temperatur) obj;
            if (obj instanceof Temperatur) {
                if (this.tempCels == temp.tempCels) {
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
     * an der hash-Implementation nichts geändert werden
     */
    @Override
    public final int hashCode() {
        return Double.hashCode(this.tempCels);
    }

    @Override
    public final String toString() {
        return "Aktuelle Temperatur in Celsius: " + this.getTempCels();
    }

    /**
     * Zwei Temperatur-Objekte werden aufgrund ihrer Temperatur verglichen
     */
    @Override
    public int compareTo(Temperatur o) {
        return Double.compare(this.getTempCels(), o.getTempCels());
    }

}

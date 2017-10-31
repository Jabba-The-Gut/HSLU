package ch.hslu.oop.sw07.Equals;

/**
 * Klasse Temperatur, welche die real existierende Temperatur in Grad mit einem
 * Feld abbildet. Die Temperatur kann abgefragt, umgewandelt und relativ
 * geändert werden.
 * 
 * @author JabbbaTheGut
 * @version 2017.02.10
 */
public class Temperatur {
	// Privates Feld, welches den aktuellen Wert des Temperatur-Objekts
	// speichert
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
		tempCels = defaultTemp;
	}

	/**
	 * Getter-Methode für die Temperatur in Grad
	 */
	public double getTempCels() {
		return tempCels;
	}

	/**
	 * Setter-Methode für die Temperatur in Grad
	 */
	public void setTempCels(double input) {
		tempCels = input;
	}

	/**
	 * Umrechnung von Grad zu Kelvin
	 */
	public double convertCelsToCelvin() {
		double tempKelv = tempCels + 273.15;
		return tempKelv;
	}

	/**
	 * Umrechnung von Grd zu Fahrenheit
	 */
	public double convertCelsToFar() {
		double tempFar = (tempCels * 1.8) + 32;
		return tempFar;
	}

	/**
	 * Veränderung der Temperatur um einen relativen Kelvin-Wert, welcher dann
	 * in Grad zurückgerechnet wird
	 */
	public void changeKelv(double relativevalue) {
		double tempKelv = convertCelsToCelvin();
		tempKelv += relativevalue;
		setTempCels((tempKelv - 273.15f));
	}

	/**
	 * Veränderung der Temperatur um einen relativen Grad-Wert
	 */
	public void changeCelsius(double relativevalue) {
		tempCels += relativevalue;
	}

	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		return super.equals(arg0);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}

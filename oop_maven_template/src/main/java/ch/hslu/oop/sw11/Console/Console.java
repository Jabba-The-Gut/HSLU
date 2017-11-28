package ch.hslu.oop.sw11.Console;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Console implements TemperaturEventListener {
	private static final Logger LOG = LogManager.getLogger(Main.class);
	TemperaturVerlauf verlauf;
	Scanner scanner;
	Temperatur temp;
	String input;

	public Console() {
		verlauf = new TemperaturVerlauf();
		scanner = new Scanner(System.in);
		verlauf.addTemperaturEventListener(this);
	}

	public void main() {

		do {
			LOG.info("Bitte Temperatur in Celsius eingeben ('exit' zum Beenden): ");

			try {
				input = scanner.next();
				temp = Temperatur.createFromCelsius(Float.valueOf(input));
				verlauf.add(temp);

				LOG.info("Temperatur hinzugefügt");

			} catch (NumberFormatException e) {
				if (input.equals("exit")) {
					LOG.info("Schlüsselwort 'exit' erkannt...");
					input = "exit";
				} else {
					LOG.error(
							"Dem Programm wurde ein Temperatur-Wert in einem falschen Format übergeben, Programm wird beendet...",
							e);
					input = "exit";
				}

			} catch (Exception e) {
				LOG.error("Unerwarteter Fehler, Programm wird beendet...", e);
				input = "exit";
			}

		} while (!input.equals("exit"));
		scanner.close();
		
		//Write temp-Values to file
		BinaryTemperaturWriter.writeTempToFile("/Users/Daveeee/Desktop/verlauf.txt", verlauf);
		LOG.info("Wrote Temperatur-Values to file: /Users/Daveeee/Desktop/test.txt");
		LOG.info(verlauf.toString());
		LOG.info("Programm beendet.");
	}

	/**
	 * Passiert, falls der TemperaturEvent vorkommt
	 */
	@Override
	public void temperaturEvent(TemperaturEvent event) {
		LOG.info("Neues " + event.toString() + " erreicht mit einem Temperatur-Wert von: " + Temperatur.convertKelvinToCelsius(event.getValue()));

	}
}

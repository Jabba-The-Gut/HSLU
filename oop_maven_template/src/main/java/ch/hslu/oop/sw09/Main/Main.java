package ch.hslu.oop.sw09.Main;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
	private static final Logger LOG = LogManager.getLogger(Main.class);

	public static void main(String[] args) {

		String input;
		Scanner scanner = new Scanner(System.in);
		do {
			LOG.info("Bitte Temperatur eingeben ('exit' zum Beenden): ");
			input = scanner.next();
			try {
				float value = Float.valueOf(input);
			} catch (Exception e) {
				LOG.error("Es wurde eine Temperatur im falschen Format entdeckt, Programm wird beendet...", e);
				input = "exit";
			}

		} while (!input.equals("exit"));
		LOG.info("Programm beendet.");

	}

}

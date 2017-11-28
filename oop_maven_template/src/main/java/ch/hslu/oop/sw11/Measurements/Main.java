/**
 * 
 */
package ch.hslu.oop.sw11.Measurements;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Main Klasse, welche ein File mit Temperatur-Messwerten einliest und diese in
 * der Klasse TemperaturVerlauf speichert
 * 
 * @author Daveeee
 *
 */
public class Main {
    private static final Logger LOG = LogManager.getLogger(Main.class);
    private static TemperaturVerlauf tempVerlauf = new TemperaturVerlauf();

    public static void main(String[] args) {
        String path = "/Users/Daveeee/Desktop/measurements.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String[] components;
            int i = 0;

            LOG.info("Started reading...");
            while (reader.readLine() != null) {
                // Get each line from the file
                components = new String[] {};

                // Splitting each line
                components = reader.readLine().split(";");
                // Creating a Temperatur-Object with the data of the line and
                // adding it to TemperaturVerlauf
                tempVerlauf.add(Temperatur.createFromCelsius(Float.valueOf(components[2]),
                        LocalDateTime.parse(components[1], DateTimeFormatter.ofPattern("yyy/MM/dd HH:mm:ss")),
                        Integer.valueOf(components[3])));
                i++;
                LOG.info("Created Temperature-Object. Total: " + i);
            }
            LOG.info("Finished reading...");
            LOG.info("Minimal Temperature read: " + tempVerlauf.getMin().toString());
            LOG.info("Maximal Temperature read: " + tempVerlauf.getMax().toString());
        } catch (FileNotFoundException e) {
            LOG.error("Couldn't access file: " + e);
        } catch (Exception e) {
            LOG.error("Error: " + e);
        }
    }

}

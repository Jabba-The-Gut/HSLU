/**
 * 
 */
package ch.hslu.oop.sw11.Console;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class that reads the binary-data of a file and supposes that all data
 * represents a temperature-value of a Temperatur-Object.
 * 
 * @author Daveeee
 *
 */
public final class BinaryTemperaturReader {
    private static final Logger LOG = LogManager.getLogger(BinaryTemperaturReader.class);

    private BinaryTemperaturReader() {
    };

    public static ArrayList<Float> readTempFromFile(String path) {
        ArrayList<Float> tempValues = new ArrayList<>();
        try (DataInputStream in = new DataInputStream(new FileInputStream(path))) {
            LOG.debug("Generating InputStream successfull. Reading from file...");
            while (true) {
                tempValues.add(in.readFloat());
            }

        } catch (FileNotFoundException e) {
            LOG.error("File not found" + e);
        } catch (EOFException e) {
            LOG.debug("Reached end of file while reading...");
            return tempValues;
        } catch (IOException e) {
            LOG.error("IO-Exception" + e);
        } catch (Exception e) {
            LOG.error("Error occured " + e);
        } finally {
            return tempValues;
        }
    }
}

/**
 * 
 */
package ch.hslu.oop.sw11.Console;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class that reades the data of a binary file and supposes that all data
 * represents a Temperatur-Objetct with a temp.
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
            LOG.info("Generating InputStream successfull. Reading from file...");
            while (true) {
                tempValues.add(in.readFloat());
            }

        } catch (FileNotFoundException e) {
            LOG.error("File not found" + e);
        } catch (EOFException e) {
            LOG.info("Reached end of file while reading...");
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

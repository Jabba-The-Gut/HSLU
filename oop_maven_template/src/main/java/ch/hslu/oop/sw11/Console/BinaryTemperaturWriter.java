/**
 * 
 */
package ch.hslu.oop.sw11.Console;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class that writes the value of all Temperatur-Objects stored in a
 * Temperatur-Verlauf to a file in a binary format
 * 
 * @author Daveeee
 *
 */
public final class BinaryTemperaturWriter {
    private static final Logger LOG = LogManager.getLogger(BinaryTemperaturWriter.class);

    private BinaryTemperaturWriter() {
    };

    public static void writeTempToFile(String path, TemperaturVerlauf verlauf) {
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(path))) {

            LOG.info("Generating OutputStream successfull. Writing to file...");

            Iterator<Temperatur> it = verlauf.getStore().iterator();
            while (it.hasNext()) {
                out.writeFloat((float) it.next().getCelsius());
            }
            out.flush();
            LOG.info("Finished writing...");

        } catch (FileNotFoundException e) {
            LOG.error("File not found" + e);
        } catch (IOException e) {
            LOG.error("IO-Exception" + e);
        } catch (Exception e) {
            LOG.error("Error occured " + e);
        }
    }
}

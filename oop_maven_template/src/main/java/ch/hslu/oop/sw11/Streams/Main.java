/**
 * 
 */
package ch.hslu.oop.sw11.Streams;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * * Class that reads and writes to a file using binary-Stream. It shows that it
 * can be written to a file in binary format in any order, as long as it is read
 * the same way it was written
 * 
 * @author Daveeee
 *
 */
public class Main {
    private static final Logger LOG = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        final String PATH = "/Users/Daveeee/Desktop/test.txt";

        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(PATH))) {

            LOG.info("Generating OutputStream successfull. Writing to file...");
            out.writeInt(2);
            out.writeInt(23);
            out.writeUTF("Hallo, mein Name ist Müller!");
            out.flush();
            LOG.info("Finished writing...");

        } catch (FileNotFoundException e) {
            LOG.error("File not found" + e);
        } catch (IOException e) {
            LOG.error("IO-Exception" + e);
        } catch (Exception e) {
            LOG.error("Error occured" + e);
        }

        try (DataInputStream in = new DataInputStream(new FileInputStream(PATH))) {

            LOG.info("Generating InputStream successfull, file found. Reading file...");
            int first = in.readInt();
            int second = in.readInt();
            LOG.info("Read following data (float): " + first + "/" + second);
            String utf = in.readUTF();
            LOG.info("Read following data (String): " + utf);
            LOG.info("Finished reading...");

        } catch (FileNotFoundException e) {
            LOG.error("File not found" + e);
        } catch (IOException e) {
            LOG.error("IO-Exception" + e);
        } catch (Exception e) {
            LOG.error("Error occured" + e);
        }

    }

}

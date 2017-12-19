package ch.hslu.oop.sw14.Runnable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.experimental.theories.Theories;

import ch.hslu.oop.sw11.Console.BinaryTemperaturWriter;

public class WorkerDemoAsynchron {
    private static final Logger LOG = LogManager.getLogger(BinaryTemperaturWriter.class);
    final Thread thread1;
    final Thread thread2;
    final Thread thread3;

    private WorkerDemoAsynchron() {
        thread1 = new Thread(this::processWork);
        thread2 = new Thread(this::processWork);
        thread3 = new Thread(this::processWork);
    }

    private void processWork() {
        try {
            Thread.sleep(3000);
            LOG.info("Einzelner Thread fertig...");
        } catch (InterruptedException e) {
            LOG.error("InterupptedException occured...", e);
        } catch (Exception e) {
            LOG.error("Exception occured...", e);
        }
    }

    private void startThreads() {
        thread1.start();
        thread2.start();
        thread3.start();
    }

    public static void main(String[] args) {
        WorkerDemoAsynchron worker = new WorkerDemoAsynchron();
        long timeStart = System.currentTimeMillis();
        worker.startThreads();

        LOG.info("Asynchrone Ausführung fertig. Dauer: " + (System.currentTimeMillis() - timeStart));
    }

}

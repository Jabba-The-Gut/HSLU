package ch.hslu.oop.sw14.Runnable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ch.hslu.oop.sw11.Console.BinaryTemperaturWriter;

public class WorkerDemoSynchron {
    private static final Logger LOG = LogManager.getLogger(BinaryTemperaturWriter.class);

    public WorkerDemoSynchron() {

    }

    public void processWork(long sleep) {
        try {
            Thread.sleep(sleep);
            LOG.info("Einzelner Thread fertig...");
        } catch (InterruptedException e) {
            LOG.error("InterupptedException occured...", e);
        } catch (Exception e) {
            LOG.error("Exception occured...", e);
        }
    }

    public void startProcessing() {
        this.processWork(2000);
        this.processWork(1000);
        this.processWork(5000);
    }

    public static void main(String[] args) {
        WorkerDemoSynchron workerDemo = new WorkerDemoSynchron();
        long timeStart = System.currentTimeMillis();
        workerDemo.startProcessing();
        long timeEnd = System.currentTimeMillis();

        LOG.info("Synchrone Ausführung fertig. Dauer: " + (timeEnd - timeStart));

    }

}

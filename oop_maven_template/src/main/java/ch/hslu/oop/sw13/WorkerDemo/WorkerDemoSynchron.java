package ch.hslu.oop.sw13.WorkerDemo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ch.hslu.oop.sw11.Console.BinaryTemperaturWriter;

public class WorkerDemoSynchron {
	private static final Logger LOG = LogManager.getLogger(BinaryTemperaturWriter.class);

	public WorkerDemoSynchron() {

	}

	public void processWork(long sleep) throws InterruptedException {
		Thread.sleep(sleep);
	}
	
	public static void main(String[] args) {
		WorkerDemoSynchron workerDemo = new WorkerDemoSynchron();
		try {
			long timeStart = System.currentTimeMillis();
			workerDemo.processWork(2000);
			workerDemo.processWork(100);
			workerDemo.processWork(5000);
			long timeEnd = System.currentTimeMillis();
			
			LOG.info("Synchrone Ausführung fertig. Dauer: " + (timeEnd-timeStart));
		} catch (Exception e) {
			LOG.error("Fehler aufgetreten, siehe StackTrace...",e);
		}
		

	}

}

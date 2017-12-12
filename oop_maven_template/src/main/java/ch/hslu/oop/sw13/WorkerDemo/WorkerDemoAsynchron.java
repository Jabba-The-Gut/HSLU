package ch.hslu.oop.sw13.WorkerDemo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ch.hslu.oop.sw11.Console.BinaryTemperaturWriter;

public class WorkerDemoAsynchron {
	private static final Logger LOG = LogManager.getLogger(BinaryTemperaturWriter.class);

	public WorkerDemoAsynchron() {

	}

	public void processWork(long sleep) throws InterruptedException {
		Thread.sleep(sleep);
	}

	public static void main(String[] args) {
		WorkerDemoSynchron workerDemo = new WorkerDemoSynchron();
		try {
			long timeStart = System.currentTimeMillis();

			final Thread thread1 = new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						workerDemo.processWork(2000);
						LOG.info("Thread 1 fertig");
					} catch (Exception e) {
						LOG.error("Fehler in Thread 1, siehe StackTrace...", e);
					}
				}
			});
			
			final Thread thread2 = new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						workerDemo.processWork(100);
						LOG.info("Thread 2 fertig");
					} catch (Exception e) {
						LOG.error("Fehler in Thread 2, siehe StackTrace...", e);
					}
				}
			});

			final Thread thread3 = new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						workerDemo.processWork(5000);
					} catch (Exception e) {
						LOG.error("Fehler in Thread 3, siehe StackTrace...", e);
					}
				}
			});
			
			thread1.start();
			thread2.start();
			thread3.start();
			long timeEnd = System.currentTimeMillis();

			LOG.info("Synchrone Ausführung fertig. Dauer: " + (timeEnd - timeStart));
		} catch (Exception e) {
			LOG.error("Fehler aufgetreten, siehe StackTrace...", e);
		}

	}

}

package ch.hslu.oop.sw13.Nebenlaeufigkeit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Demo-Klasse, um den Effekt von kritischen Bereichen und Thread-Safety bei
 * Nebenläufigkeit zu testen.
 * 
 * @author Dave
 *
 */
public class NebenlaeufigkeitDemo {
	private static final Logger LOG = LogManager.getLogger(NebenlaeufigkeitDemo.class);

	private static final class Worker implements Runnable {
		private final Counter counter;

		Worker(final Counter counter) {
			this.counter = counter;
		}

		@Override
		public void run() {
			for (int i = 0; i < 10000; i++) {
				this.counter.increment();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		final Counter counter = new Counter();
		final Thread[] threads = new Thread[3];

		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(new Worker(counter));
		}
		for (final Thread thread : threads) {
			thread.start();
		}

		threads[0].join();
		threads[1].join();
		threads[2].join();

		LOG.info("Zählerstand: " + counter.getCount());

	}

}

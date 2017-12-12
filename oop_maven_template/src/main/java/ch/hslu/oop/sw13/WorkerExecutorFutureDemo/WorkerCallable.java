package ch.hslu.oop.sw13.WorkerExecutorFutureDemo;

import java.util.concurrent.Callable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * WorkerCallable-Klasse, welche vom Callable-Interace erbt und somit an eine
 * Executor-Service übergeben werden kann.
 * 
 * @author Dave
 *
 */
public class WorkerCallable implements Callable<Integer> {
	public static final Logger LOG = LogManager.getLogger(WorkerCallable.class);
	private final int number1;
	private final int number2;

	public WorkerCallable(int a, int b) {
		this.number1 = a;
		this.number2 = b;
	}

	@Override
	public Integer call() throws Exception {
		try {
			LOG.info("Resultat: " + ((number1 + number2) / 2));
			Thread.sleep(500);
			return ((number1 + number2) / 2);
		} catch (Exception e) {
			LOG.error("call()-Methode von WorkerCallable hat eine Exception geworfen...", e);
		}
		return null;
	}

}

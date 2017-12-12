package ch.hslu.oop.sw13.WorkerExecutorFutureDemo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Demo-Klasse mit einem Executor-Service, in welchem WorkerCallable-Objekte der
 * Reihe nach bearbeitet werden. Die einmals WorkerCallable-Klasse ist nun eine
 * innere anonyme Klasse.
 * 
 * @author Dave
 */
public class WorkerExecutorFutureDemoAnonymousClass {
	private final static Logger LOG = LogManager.getLogger(WorkerExecutorFutureDemo.class);

	public static void main(String[] args) {
		final ExecutorService execService = Executors.newFixedThreadPool(10);

		Future<Integer> future1 = execService.submit(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				try {
					Thread.sleep(2000);
					return ((1564 + 165) / 2);
				} catch (Exception e) {
					LOG.error("call()-Methode von WorkerCallable hat eine Exception geworfen...", e);
				}
				return null;
			}

		});

		try {
			LOG.info("Resultat: " + future1.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}

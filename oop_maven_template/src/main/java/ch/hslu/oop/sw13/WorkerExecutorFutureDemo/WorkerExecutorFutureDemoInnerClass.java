package ch.hslu.oop.sw13.WorkerExecutorFutureDemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Demo-Klasse mit einem Executor-Service, in welchem WorkerCallable-Objekte der
 * Reihe nach bearbeitet werden. Die WorkerCallable-Klasse ist nun eine innere
 * Klasse.
 * 
 * @author Dave
 */
public class WorkerExecutorFutureDemoInnerClass {
	private final static Logger LOG = LogManager.getLogger(WorkerExecutorFutureDemo.class);
	private static List<Callable<Integer>> workerList;

	private class WorkerCallable implements Callable<Integer> {
		public final Logger LOG = LogManager.getLogger(WorkerCallable.class);
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

	public WorkerExecutorFutureDemoInnerClass() {
		workerList = new ArrayList<>();
		workerList.add(new WorkerExecutorFutureDemoInnerClass.WorkerCallable(10, 20));
		workerList.add(new WorkerExecutorFutureDemoInnerClass.WorkerCallable(1564, 165));
		workerList.add(new WorkerExecutorFutureDemoInnerClass.WorkerCallable(1564, 75));
		workerList.add(new WorkerExecutorFutureDemoInnerClass.WorkerCallable(2313112, 6));
		workerList.add(new WorkerExecutorFutureDemoInnerClass.WorkerCallable(1564, 498463584));
		workerList.add(new WorkerExecutorFutureDemoInnerClass.WorkerCallable(6, 758));
		workerList.add(new WorkerExecutorFutureDemoInnerClass.WorkerCallable(1564, 786));
		workerList.add(new WorkerExecutorFutureDemoInnerClass.WorkerCallable(78, 435));
		workerList.add(new WorkerExecutorFutureDemoInnerClass.WorkerCallable(78, 435));
	}

	public static void main(String[] args) {
		final ExecutorService execService = Executors.newFixedThreadPool(10);
		final WorkerExecutorFutureDemoInnerClass demo = new WorkerExecutorFutureDemoInnerClass();

		Iterator<Callable<Integer>> it = workerList.iterator();

		while (it.hasNext()) {
			execService.submit(it.next());
		}

	}
}

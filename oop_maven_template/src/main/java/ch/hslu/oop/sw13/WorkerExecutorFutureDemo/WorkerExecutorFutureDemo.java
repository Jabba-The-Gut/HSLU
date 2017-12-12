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
 * Reihe nach bearbeitet werden.
 * 
 * @author Dave
 *
 */
public class WorkerExecutorFutureDemo {
	private final static Logger LOG = LogManager.getLogger(WorkerExecutorFutureDemo.class);
	private static List<Callable<Integer>> workerList;

	public static void main(String[] args) {
		final ExecutorService execService = Executors.newFixedThreadPool(10);

		workerList = new ArrayList<>();
		workerList.add(new WorkerCallable(10, 20));
		workerList.add(new WorkerCallable(1564, 165));
		workerList.add(new WorkerCallable(1564, 75));
		workerList.add(new WorkerCallable(63, 49848984));
		workerList.add(new WorkerCallable(1564, 498463584));
		workerList.add(new WorkerCallable(6, 758));
		workerList.add(new WorkerCallable(1564, 786));
		workerList.add(new WorkerCallable(78, 435));
		workerList.add(new WorkerCallable(78, 435));

		Iterator<Callable<Integer>> it = workerList.iterator();

		while (it.hasNext()) {
			execService.submit(it.next());
		}

	}

}

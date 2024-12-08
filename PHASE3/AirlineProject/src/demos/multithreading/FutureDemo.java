package demos.multithreading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureDemo {

	public static void main(String[] args) {

		// Create an ExecutorService with a fixed thread pool
		ExecutorService executor = Executors.newFixedThreadPool(2);

		Future<Integer> future1 = null, future2 = null;

		try {
			// Submit two async tasks that return Futures
			future1 = executor.submit(new ComplexCalculation("Task 1"));
			future2 = executor.submit(new ComplexCalculation("Task 2"));

			System.out.println("Tasks submitted, continuing with other work...");

			// Simulate doing other work while tasks are running
			Thread.sleep(1000);
			System.out.println("Did some other work while waiting for results");

			// Get results from futures with timeout

			int result1 = future1.get(5, TimeUnit.SECONDS);
			System.out.println("Result from Task 1: " + result1);

			int result2 = future2.get(5, TimeUnit.SECONDS);
			System.out.println("Result from Task 2: " + result2);

			int total = result1 + result2;
			System.out.println("Combined result: " + total);

		} catch (TimeoutException e) {
			System.out.println("Task took too long!");
			future1.cancel(true);
			future2.cancel(true);
		} catch (InterruptedException | ExecutionException e) {
			System.out.println("Task was interrupted or failed: " + e.getMessage());
		}

		finally {
			// Properly shutdown the executor
			executor.shutdownNow();
		}
	}

}

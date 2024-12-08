package demos.multithreading;

public class NumberProducingThreadUsingRunnable implements Runnable {

	

	// Define the task
	public void run() {

		for (int i = 0; i < 100; i++) {
			System.out.println(Thread.currentThread().getName() + " i = " + i);
			
			try {
				Thread.sleep(100);// sleep for 100 ms
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		}

	}

	
}
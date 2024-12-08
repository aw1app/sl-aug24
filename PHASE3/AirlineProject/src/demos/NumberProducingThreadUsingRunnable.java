package demos;

public class NumberProducingThreadUsingRunnable implements Runnable {

	public String name;
	
	public NumberProducingThreadUsingRunnable(String name) {
		this.name=name;
	}

	// Define the task
	public void run() {

		for (int i = 0; i < 100; i++) {
			System.out.println(this.name + " i = " + i);
			
			try {
				Thread.sleep(100);// sleep for 100 ms
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		}

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
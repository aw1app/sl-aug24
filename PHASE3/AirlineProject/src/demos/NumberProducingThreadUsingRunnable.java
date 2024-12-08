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
		}

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
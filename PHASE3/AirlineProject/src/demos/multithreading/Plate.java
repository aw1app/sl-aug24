package demos.multithreading;

public class Plate {


	public synchronized void addItem(String item) {		

		for (int i = 0; i < 10; i++) {
			System.out.println("added a " + item + " to the plate.");
			
			try {
				Thread.sleep(100);// sleep for 100 ms
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		}

	}

}

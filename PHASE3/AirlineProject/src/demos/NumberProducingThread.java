package demos;

public class NumberProducingThread extends Thread{
	
	// Define the task 
	public void run() {
		
		for(int i=0;i<100;i++) {
			System.out.println("[NumberProducingThread] i = "+i);
		}
		
	}

}

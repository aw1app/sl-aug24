package demos;

public class NumberProducingThread extends Thread{
	
	// Define the task 
	public void run() {
		
		for(int i=0;i<100;i++) {
			System.out.println(this.getName() + " i = "+i);
			
			try {
				Thread.sleep(100);// sleep for 100 ms
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		}
		
	}
	
	public int m1() {
		return 5;
	}

}

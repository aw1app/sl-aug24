package demos;

public class MultiThreadingDemo {

	public static void main(String[] args) {
		System.out.println("Main stmt 1");
		System.out.println("Main stmt 2");
		
		Thread t1 = new NumberProducingThread();
		t1.setName("NP1");
		t1.start();
		
		Thread t2 = new NumberProducingThread();
		t2.setName("NP2");
		t2.start();
		
		Runnable r1 = new NumberProducingThreadUsingRunnable();
		Thread tr1 = new Thread(r1);
		tr1.setName("R1");
		tr1.start();
		
		
		System.out.println("Main stmt 3");
		
		for(int i=0;i<1000;i++) {
		System.out.println("Main stmt 4 M "+i);
		try {
			Thread.sleep(100);// sleep for 100 ms
		} catch (InterruptedException e) {				
			e.printStackTrace();
		}
		}
		
		
		
		System.out.println("Main stmt 5");

	}

}

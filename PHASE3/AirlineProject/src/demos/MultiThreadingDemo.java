package demos;

public class MultiThreadingDemo {

	public static void main(String[] args) {
		System.out.println("Main stmt 1");
		System.out.println("Main stmt 2");
		
		NumberProducingThread t1 = new NumberProducingThread();
		t1.setName("NP1");
		t1.start();
		
		NumberProducingThread t2 = new NumberProducingThread();
		t2.setName("NP2");
		t2.start();
		
		
		System.out.println("Main stmt 3");
		
		for(int i=0;i<1000;i++)
		System.out.println("Main stmt 4 M "+i);
		
		
		
		System.out.println("Main stmt 5");

	}

}

package demos;

public class SynchronizedDemo {

	public static void main(String[] args) {
		Plate p1 = new Plate();
		
		Thread dosachef = new DosaChef(p1);		
		
		Thread rotichef = new RotiChef(p1);
		
		dosachef.start();
		rotichef.start();

	}

}

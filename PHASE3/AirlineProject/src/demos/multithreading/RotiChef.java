package demos.multithreading;

public class RotiChef extends Thread {

	Plate plate;
	
	

	public RotiChef(Plate plate) {
		super();
		this.plate = plate;
	}



	public void run() {

		plate.addItem("Roti");

	}

}

package demos.multithreading;

public class DosaChef extends Thread {

	Plate plate;
	
	public DosaChef(Plate plate) {
		super();
		this.plate = plate;
	}


	public void run() {

		plate.addItem("Dosa");

	}

}

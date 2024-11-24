
public class AirlineMain {

	public static void main(String[] args) {
		
		Pilot p1 = new Pilot();
		p1.name = "Peter";
		p1.age = 45;
		p1.licenseNo = 4646756;
		
		Pilot p2 = new Pilot();
		p2.name = "Kelly";
		p2.age = 55;
		p2.licenseNo = 565657;
		
		p1.displayDetails();
		
		//Use custom constructors
		Pilot p3 = new Pilot("Madan", 20, 56500000);
		
		p3.displayDetails();

	}

}


// CHALLENGE : Develop class AirHostess
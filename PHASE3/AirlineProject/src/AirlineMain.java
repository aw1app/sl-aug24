import java.util.Arrays;

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
		
		//Create some 2 AirHostess..
		System.out.println("\n\n AIR HOSTESS ...");
		String[] services1 = {"Food Service", "Cabin Service", "Safety Demonstration"};
		AirHostess airHostess1 = new AirHostess("Keerthy", 22, services1);
		airHostess1.displayDetails();
		
		AirHostess airHostess2 = new AirHostess("Raju", 23);
		
		
		
		
		
		
		
		//airHostess2.services = new String[] {"Food Service", "Blanklet Service", "Safety Demonstration"};
		String[] services2 = {"Food Service", "Blanklet Service", "Safety Demonstration"};
		airHostess2.setServices(services2);
		airHostess2.displayDetails();
		
	}

}


// CHALLENGE : Develop class AirHostess
// C2 : Add one more constructor to you AirHostess
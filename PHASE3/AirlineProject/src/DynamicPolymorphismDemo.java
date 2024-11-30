import airline.staff.HourlyRatePilot;
import airline.staff.Pilot;

public class DynamicPolymorphismDemo {

	public static void main(String[] args) {
		
		Pilot pilot1 = new HourlyRatePilot("Sudeep",45, 2123121);
		
		System.out.println("pilot1.x = " + pilot1.x);
		
		pilot1.displayDetails();

	}

}

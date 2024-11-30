import airline.staff.HourlyRateMonsterDotComPilot;
import airline.staff.HourlyRatePilot;
import airline.staff.Pilot;

public class DynamicPolymorphismDemo {

	public static void main(String[] args) {
		
		Pilot pilot1 = new HourlyRateMonsterDotComPilot("Sudeep",45, 2123121);
		//Pilot pilot1 = new HourlyRateIndeedDotComPilot("Sudeep",45, 2123121);
		
		//pilot1.x = 111;
		
		System.out.println("pilot1.x = " + pilot1.x);
		
		pilot1.displayDetails();
		
		System.out.println("pilot1.x = " + pilot1.x);

	}

}

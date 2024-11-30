package airline.staff;

public class HourlyRatePilot extends Pilot{
	
	int x = 100;
	
	public HourlyRatePilot(String name, int i, int j) {
		super(name,i,j);
	}

	@Override
	public void displayDetails() {
		System.out.println("[Hourly Rate Contract Pilot ] " + "Name :"+ name + "; Age :"+ this.age +  "; Licence No :"+ this.licenseNo );
	}
	

}

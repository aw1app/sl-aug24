package airline.staff;

public abstract class HourlyRatePilot extends Pilot{
	
	int x = 100;
	
	public HourlyRatePilot(String name, int i, int j) {
		super(name,i,j);
		//this.x = 999;
	}

	@Override
	public void displayDetails() {
		System.out.println("[Hourly Rate Contract Pilot ] " + "Name :"+ name + "; Age :"+ this.age +  "; Licence No :"+ this.licenseNo );
		System.out.println("[ x = ] " + this.x);
	}
	
	// we don't what to code in the body
	abstract public void setContractTerms();
	
	// Force sub class to provide the implementation
	abstract public void verifyIdentity();
	

}
